package com.startdis.sso.server.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.startdis.comm.exception.custom.BusinessException;
import com.startdis.comm.util.bean.BeanCopyKits;
import com.startdis.comm.util.id.UUIDUtils;
import com.startdis.comm.util.object.ObjectKits;
import com.startdis.comm.util.security.AesKits;
import com.startdis.comm.util.security.Md5Kits;
import com.startdis.comm.redis.service.RedisService;
import com.startdis.sso.domain.model.dto.post.TokenPostDTO;
import com.startdis.sso.domain.model.entity.AccessToken;
import com.startdis.sso.domain.model.entity.AppInfo;
import com.startdis.sso.domain.model.entity.OauthCode;
import com.startdis.sso.domain.model.entity.RefreshToken;
import com.startdis.sso.domain.model.enums.RedisKeysEnum;
import com.startdis.sso.domain.model.vo.OAuth2VO;
import com.startdis.sso.infra.mapper.AccessTokenMapper;
import com.startdis.sso.server.service.AccessTokenService;
import com.startdis.sso.server.service.AppInfoService;
import com.startdis.sso.server.service.OauthCodeService;
import com.startdis.sso.server.service.RefreshTokenService;
import com.startdis.sys.domain.model.entity.User;
import com.startdis.sys.domain.model.vo.UserInfoVO;
import com.startdis.sys.domain.model.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiMengwei
 * @email limengwei@dianjiu.cc
 * @desc 鉴权令牌表(AccessToken)服务实现层
 */
@Slf4j
@Service("accessTokenService")
public class AccessTokenServiceImpl extends ServiceImpl<AccessTokenMapper, AccessToken> implements AccessTokenService {

    @Resource
    private AppInfoService appInfoService;

    @Resource
    private RefreshTokenService refreshTokenService;

    @Resource
    private OauthCodeService oauthCodeService;

    @Resource
    private RedisService redisService;

    @Override
    public OAuth2VO getAccessTokenByAuthCode(TokenPostDTO tokenPostDTO) throws Exception {
        // 验证授权码的合法性
        Map map = redisService.hmget(RedisKeysEnum.AUTH_CODE.getKey(tokenPostDTO.getOauthCode()));
        if (null == map) {
            throw new BusinessException("A0001", "授权码不合法或已失效，请重新授权！");
        }
        UserVO userVO = (UserVO) map.get("user");
        UserInfoVO user = BeanCopyKits.copyPropertiesThird(userVO, UserInfoVO.class);
//        UserInfoVO user = (UserInfoVO) ObjectKits.mapToObject(map, UserInfoVO.class);
        user.setUniqueId(String.valueOf(map.get("userId")));
        // 验证应用令牌的合法性
        LambdaQueryWrapper<AppInfo> queryWrapper = Wrappers.lambdaQuery(AppInfo.class).eq(AppInfo::getAppKey, tokenPostDTO.getAppKey().toLowerCase()).eq(AppInfo::getAppSecret, tokenPostDTO.getAppSecret());
        AppInfo app = appInfoService.getOne(queryWrapper);
        if (null == app) {
            throw  new BusinessException("A0001", "应用令牌非法，请联系管理员！");
        }
        // 生成AppToken和RefreshToken
        String accessToken = "";
        try {
            //TODO 后续加密内容为AppKey+UserCode+当前时间戳
//            accessToken = AesKits.aesEncrypt(app.getAppKey()+user.getUserCode()+System.currentTimeMillis(), tokenPostDTO.getAppSecret());
            accessToken = app.getAppKey()+user.getUserCode()+System.currentTimeMillis() + tokenPostDTO.getAppSecret();
        } catch (Exception e) {
            log.error("生成AppToken异常: "+ e.getMessage());
            throw new BusinessException("A0001", "生成AppToken异常。");
        }
        //String refreshToken = IdUtil.getSnowflake().nextIdStr();
        String refreshToken = UUIDUtils.simpleUuid();
        // 保存AppToken和RefreshToken
        // 存入accessToken信息
        AccessToken accessTokenEntity = AccessToken.builder().id(IdUtil.getSnowflake().nextIdStr())
                //.userId(String.valueOf(jsonObject.get("userId")))
                .appKey(tokenPostDTO.getAppKey())
                .appSecret(tokenPostDTO.getAppSecret())
                .accessToken(Md5Kits.encode(accessToken))
                .refreshToken(refreshToken)
                .expiresAt(LocalDateTime.now().plusSeconds(60*60*3))
                .status(1).build();
        save(accessTokenEntity);
        // 存入refreshToken信息
        RefreshToken refreshTokenEntity = RefreshToken.builder().id(IdUtil.getSnowflake().nextIdStr())
                //.userId(String.valueOf(jsonObject.get("userId")))
                .appKey(tokenPostDTO.getAppKey())
                .appSecret(tokenPostDTO.getAppSecret())
                .accessToken(Md5Kits.encode(accessToken))
                .refreshToken(refreshToken)
                .status(1).used(0).build();
        refreshTokenService.save(refreshTokenEntity);
        // 存入Redis缓存，3小时过期
        Map<String, Object> accessMap = new HashMap<>();
        accessMap.put("user", user);
        accessMap.put("accessToken", Md5Kits.encode(accessToken));
        accessMap.put("refreshToken", refreshToken);
        accessMap.put("used", 0);
        redisService.hmset(RedisKeysEnum.ACCESS_TOKEN.getKey(Md5Kits.encode(accessToken)), accessMap, 60 * 60 * 3);
        // 更新授权码状态为已使用
        UpdateWrapper<OauthCode> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("auth_code", tokenPostDTO.getOauthCode());
        OauthCode oauthCode = new OauthCode();
        oauthCode.setUsed(1);
        oauthCodeService.update(oauthCode, updateWrapper);
        // 结束授权码Code的缓存生命周期
        redisService.del(RedisKeysEnum.AUTH_CODE.getKey(tokenPostDTO.getOauthCode()));
        // 构造AppTokenVO
        return OAuth2VO.builder().accessToken(Md5Kits.encode(accessToken)).refreshToken(refreshToken).expiresIn(String.valueOf(60*60*3)).build();
    }

    /**
     * 考虑几种特殊情况
     * 1.兑换了新Token，但三方系统由于网络原因，没有接收到最新兑换的Token，下次仍然用旧ToKen来兑换。
     * 2.兑换了新Token，三方系统收到了，但未使用新的ToKen，refreshToken依然是未激活状态。
     * 以上两种情况，都会认为插件系统没收到新的Token对，返回已生成但未接收成功的refreshToken。
     * 3.兑换了新Token，且refreshToken已激活，仍然使用旧的RefreshToken来换取Token对。
     * 这种情况认为是接收成功了，但是插件方没有保存或者没有更新refreshToken，返回已生成但未接收成功的refreshToken。
     *
     * @return
     */
    @Override
    public OAuth2VO getAccessTokenByRefreshToken(TokenPostDTO tokenPostDTO) {
        OAuth2VO appTokenVO = new OAuth2VO();
        // 先查一下数据库，有没有已存在且未使用的refreshToken（握手没成功），若存在则返回。
        // 这里要考虑下已存在且未使用的Token对是否已过期（3小时失效），若已过期，则从新生成；若未过期，则直接返回。
        QueryWrapper<RefreshToken> queryOldWrapper = new QueryWrapper<>();
        queryOldWrapper.eq("refresh_token", tokenPostDTO.getRefreshToken());
        // 此时refreshToken为旧token，但已生成新的刷新Token latestRefreshToken
        queryOldWrapper.isNotNull("latest_refresh_token");
        RefreshToken oldRefreshToken = refreshTokenService.getOne(queryOldWrapper);
        if (null != oldRefreshToken) {
            log.info(tokenPostDTO.getRefreshToken() + "已激活，请使用最新的刷新token" + oldRefreshToken.getRefreshToken() + "更新鉴权令牌。");
            QueryWrapper<RefreshToken> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("refresh_token", oldRefreshToken.getLatestRefreshToken());
            RefreshToken newRefreshToken = refreshTokenService.getOne(queryWrapper);
            //校验已存在且未使用的token对是否已过期
            Object obj = redisService.hmget(RedisKeysEnum.ACCESS_TOKEN.getKey(newRefreshToken.getAccessToken()));
            if (null == obj) {
                log.info("已存在且未使用的token对已过期,即将生成新的Token对！");
            }
            if(null != obj){
                appTokenVO.setRefreshToken(newRefreshToken.getRefreshToken());
                appTokenVO.setAccessToken(newRefreshToken.getAccessToken());
                // TODO 此时这里应该刷新token对的时间
                appTokenVO.setExpiresIn(String.valueOf(60 * 60 * 3));
                return appTokenVO;
            }
        }
        // 若不存在，则生成一个新的AppToken和RefreshToken
        QueryWrapper<RefreshToken> queryWrapper = new QueryWrapper<RefreshToken>().eq("refresh_token", tokenPostDTO.getRefreshToken()).eq("used", 0).eq("status", 1);
        RefreshToken authRefreshToken = refreshTokenService.getOne(queryWrapper);
        if (null == authRefreshToken) {
            log.info("刷新令牌{}非法", tokenPostDTO.getRefreshToken());
            throw new BusinessException("A0001", "刷新令牌非法参数！");
        }
        User user = (User) redisService.hget(RedisKeysEnum.ACCESS_TOKEN.getKey(authRefreshToken.getAccessToken()), "user");
        String accessToken = "";
        try {
            accessToken = AesKits.aesEncrypt(tokenPostDTO.getAppKey()+user.getUserCode()+System.currentTimeMillis(), authRefreshToken.getAppSecret());
        } catch (Exception e) {
            log.error("生成AppToken异常", e.getMessage());
            throw new BusinessException("A0001", "生成AppToken异常。");
        }
        //String latestRefreshToken = IdUtil.getSnowflake().nextIdStr();
        String latestRefreshToken = UUIDUtils.simpleUuid();
        // 保存AccessToken和RefreshToken
        // 存入accessToken信息
        AccessToken accessTokenEntity = AccessToken.builder().id(IdUtil.getSnowflake().nextIdStr())
                //.userId(String.valueOf(jsonObject.get("userId")))
                .appKey(tokenPostDTO.getAppKey())
                .appSecret(tokenPostDTO.getAppKey())
                .accessToken(Md5Kits.encode(accessToken))
                .refreshToken(latestRefreshToken)
                .expiresAt(LocalDateTime.now().plusSeconds(60*60*3))
                .status(1).build();
        save(accessTokenEntity);
        // 存入refreshToken信息
        RefreshToken refreshTokenEntity = RefreshToken.builder().id(IdUtil.getSnowflake().nextIdStr())
                //.userId(String.valueOf(jsonObject.get("userId")))
                .appKey(tokenPostDTO.getAppKey())
                .appSecret(tokenPostDTO.getAppKey())
                .accessToken(Md5Kits.encode(accessToken))
                .refreshToken(latestRefreshToken)
                .status(1).used(0).build();
        refreshTokenService.save(refreshTokenEntity);
        // 存入Redis缓存，3小时过期
        Map<String, Object> accessMap = new HashMap<>();
        accessMap.put("user", user);
        accessMap.put("used", 0);
        accessMap.put("accessToken", Md5Kits.encode(accessToken));
        accessMap.put("refreshToken", latestRefreshToken);
        redisService.hmset(RedisKeysEnum.ACCESS_TOKEN.getKey(Md5Kits.encode(accessToken)), accessMap, 60 * 60 * 3);
        // 这里暂不更新为激活状态，只更新latestRefreshToken
        UpdateWrapper<RefreshToken> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("refresh_token", tokenPostDTO.getRefreshToken());
        RefreshToken oauthRefreshToken = RefreshToken.builder().latestRefreshToken(latestRefreshToken)
                .build();
        refreshTokenService.update(oauthRefreshToken, updateWrapper);
        // 结束旧Token的生命周期
        redisService.del(RedisKeysEnum.ACCESS_TOKEN.getKey(authRefreshToken.getAccessToken()));
        // 组装响应报文
        appTokenVO.setAccessToken(Md5Kits.encode(accessToken));
        appTokenVO.setExpiresIn(String.valueOf(60*60*3));
        appTokenVO.setRefreshToken(latestRefreshToken);
        return appTokenVO;
    }

    @Override
    public Boolean checkAccessToken(String accessToken) {
        Map map = redisService.hmget(RedisKeysEnum.ACCESS_TOKEN.getKey(accessToken));
        if (null == map) {
            throw new BusinessException("A0001", "鉴权令牌不合法或已失效，请刷新令牌！");
        }
        // "status"为"0"说明握手成功，此时需要更新旧的refresh_token为已激活状态
        //JSONObject jsonObject = JSONObject.parseObject(String.valueOf(obj));

        if (null != map.get("refreshToken") && null != map.get("used") && 0 == (Integer) map.get("used")) {
            UpdateWrapper<RefreshToken> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("refresh_token", map.get("refreshToken"));
            RefreshToken refreshToken = RefreshToken.builder().used(1).build();
            refreshTokenService.update(refreshToken, updateWrapper);
            // 更新redis数据状态为1
            map.put("used", 1);
            redisService.hset(RedisKeysEnum.ACCESS_TOKEN.getKey(accessToken), "used",1);
        }
        // 组转请求头穿透
        //if(null != jsonObject.get("storeId")){
        //    //设置全局信息
        //    CompanyAuthInfo companyAuthInfo = new CompanyAuthInfo();
        //    companyAuthInfo.setUniqueId(String.valueOf(jsonObject.get("userId")));
        //    companyAuthInfo.setCompanyTenantId(String.valueOf(jsonObject.get("companyTenantId")));
        //    companyAuthInfo.setGroupTenantId(String.valueOf(jsonObject.get("groupTenantId")));
        //    companyAuthInfo.setPermissionScope(PermissionScopeEnum.COMPANY);
        //    RequestHolder.add(companyAuthInfo);
        //}
        return true;
    }
}

