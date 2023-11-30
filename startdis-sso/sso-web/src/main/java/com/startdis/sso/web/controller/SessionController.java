package com.startdis.sso.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.comm.auth.annotation.RbacPermission;
import com.startdis.comm.core.constant.Constants;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.domain.model.UserPassWordDto;
import com.startdis.comm.redis.service.RedisService;
import com.startdis.comm.util.asserts.AssertKits;
import com.startdis.comm.util.security.PwdKits;
import com.startdis.comm.util.string.StringKits;
import com.startdis.sso.domain.model.dto.post.AuthorizePostDTO;
import com.startdis.sso.domain.model.dto.post.LoginPostDTO;
import com.startdis.sso.domain.model.entity.AppInfo;
import com.startdis.sso.domain.model.enums.RedisKeysEnum;
import com.startdis.sso.domain.model.vo.LoginVO;
import com.startdis.sso.domain.model.vo.OAuth2VO;
import com.startdis.sso.server.service.AppInfoService;
import com.startdis.sso.server.service.OauthCodeService;
import com.startdis.sys.api.SysApi;
import com.startdis.sys.domain.model.vo.MenuVO;
import com.startdis.sys.domain.model.vo.UserInfoVO;
import com.startdis.sys.domain.model.vo.UserTokenVO;
import com.startdis.sys.domain.model.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Validated
@RestController
@ApiSort(value = 1)
@RequestMapping()
@Api(value = "Session", tags = {"会话管理"})
public class SessionController {

    @Resource
    private SysApi sysApi;

    @Resource
    private AppInfoService appInfoService;

    @Resource
    private RedisService redisService;

    @Resource
    private OauthCodeService oauthCodeService;

    @Validated
    @ApiOperation("登录")
    @PostMapping("/login")
    public ResultBean<LoginVO> login(@RequestBody LoginPostDTO loginDto) throws Exception {
        LoginVO loginVO = new LoginVO();
        // 1、用户身份验证
        UserTokenVO userToken = null;
        // 基于token验证用户身份
        if (null != loginDto && StringKits.isNotBlank(loginDto.getAccessToken())) {
            userToken = getUserTokenByToken(loginDto.getAccessToken()).getData();
            AssertKits.notNull(userToken, "用户已失效");
        }
        // 基于账号、密码验证用户身份
        if (null != loginDto && StringKits.isNotBlank(loginDto.getUserCode()) && StringKits.isNotBlank(loginDto.getPassword())) {
            userToken = sysApi.getUserInfoByUserCode(loginDto.getUserCode()).getData();
            AssertKits.notNull(userToken, "用户不存在");
            boolean validPassword = PwdKits.isValidPassword(loginDto.getPassword(), userToken.getUser().getPassword());
            AssertKits.check(validPassword, "账号或密码错误");
        }
        // 2、获取授权码
        LambdaQueryWrapper<AppInfo> queryWrapper = Wrappers.lambdaQuery(AppInfo.class).eq(AppInfo::getAppCode, loginDto.getAppCode());
        AppInfo appInfo = appInfoService.getOne(queryWrapper);
        AuthorizePostDTO authorizePostDTO = AuthorizePostDTO.builder().responseType("code").appKey(appInfo.getAppKey()).redirectUrl(appInfo.getRedirectUrl()).state(loginDto.getState()).build();
        OAuth2VO oAuth2VO = oauthCodeService.getAuthCode(authorizePostDTO, userToken);
        loginVO.setState(oAuth2VO.getState());
        loginVO.setOauthCode(oAuth2VO.getOauthCode());
        return ResultBean.success("登陆成功！", loginVO);
    }

    @Validated
    @ApiOperation("登出")
    @PostMapping("/logout")
    public ResultBean logout(@RequestParam String authToken) {
        redisService.del(RedisKeysEnum.ACCESS_TOKEN.getKey(authToken));
        return ResultBean.success();
    }

    @Validated
    @ApiOperation("获取用户令牌信息")
    @GetMapping("/getUserToken")
    public ResultBean<UserTokenVO> getUserTokenByToken(@RequestParam String authToken) {
        UserTokenVO userTokenVO = new UserTokenVO();
        UserInfoVO user = (UserInfoVO) redisService.hget(RedisKeysEnum.ACCESS_TOKEN.getKey(authToken), "user");
        user.setUserId(Objects.isNull(user) ? null : user.getId());
        userTokenVO.setUserInfoVO(user);
        // 组装菜单集合
        List<MenuVO> menus = (List<MenuVO>) redisService.hget(RedisKeysEnum.ACCESS_TOKEN.getKey(authToken), "menus");
        userTokenVO.setMenus(menus);
        return ResultBean.success(userTokenVO);
    }

    @ApiOperation("修改用户密码")
    @PostMapping("updateUserPassWord")
    @RbacPermission
    public ResultBean updateUserPassWord(@RequestBody UserPassWordDto userPassWordDto){
        ResultBean resultBean = sysApi.updateUserPassWord(userPassWordDto);
        if (!Constants.SUCCESS.equals(resultBean.getCode())){
            return ResultBean.error("修改密码异常！请联系管理员。 " + resultBean.getMsg());
        }
        return ResultBean.success("修改成功!");
    }
}
