package com.startdis.sys.web.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.comm.auth.annotation.RbacPermission;
import com.startdis.comm.core.constant.Constants;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.domain.model.UserPassWordDto;
import com.startdis.comm.util.auth.AuthInfoUtils;
import com.startdis.comm.util.security.PwdKits;
import com.startdis.sso.api.client.SsoApi;
import com.startdis.sso.domain.model.vo.OAuth2VO;
import com.startdis.sys.domain.model.entity.Menu;
import com.startdis.sys.domain.model.entity.TokenInfo;
import com.startdis.sys.domain.model.entity.User;
import com.startdis.sys.domain.model.entity.UserDept;
import com.startdis.sys.domain.model.query.UserMenuTreeQuery;
import com.startdis.sys.domain.model.vo.*;
import com.startdis.sys.server.service.*;
import feign.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "common", tags = {"系统管理接口"})
@RequestMapping("common")
public class CommonController {

    @Resource
    private SsoApi ssoApi;

    @Resource
    private DeptService deptService;

    @Resource
    private UserService userService;

    @Resource
    private UserDeptService userDeptService;

    @Resource
    private TokenInfoService tokenInfoService;

    @Resource
    private MenuService menuService;

    @Value("${appInfo.code}")
    private String appCode;

    @Value("${appInfo.key}")
    private String key;

    @Value("${appInfo.secret}")
    private String secret;

    @GetMapping("getUserInfo")
    @ApiOperation("获取用户信息")
    @RbacPermission
    public ResultBean getUserInfo(){
        String authToken = AuthInfoUtils.getAuthToken();
        ResultBean<UserTokenVO> resultBean = ssoApi.getUserInfoByToken(authToken);
        if (!Constants.SUCCESS.equals(resultBean.getCode())){
            return ResultBean.error(Constants.LOGIN_NO_PERMISSION,"获取用户信息异常！请重新登录。" + resultBean.getMsg(), null);
        }
        UserTokenVO userVO = resultBean.getData();
        if (Objects.isNull(userVO)){
            return ResultBean.error(Constants.LOGIN_NO_PERMISSION,"获取用户信息异常！请重新登录。", null);
        }
        UserInfoVO userInfoVO = userVO.getUserInfoVO();
        String userCode = userInfoVO.getUserCode();
        //获取用户信息
        User user = userService.getBaseMapper().selectOne(Wrappers.<User>lambdaQuery().eq(User::getUserCode, userCode));
        if (Objects.isNull(user)){
            return ResultBean.error(Constants.LOGIN_NO_PERMISSION,"当前应用系统未找到该用户！请联系管理员配置。", null);
        }
        //获取业务部门信息
        UserDept userDept = userDeptService.getBaseMapper().selectOne(Wrappers.<UserDept>lambdaQuery()
                .eq(UserDept::getUserId, user.getId())
                .eq(UserDept::getGroupTenantId,user.getGroupTenantId())
                .eq(UserDept::getCompanyTenantId,user.getCompanyTenantId()));
        if (Objects.nonNull(userDept)) {
            userInfoVO.setDeptId(userDept.getDeptId());
            userInfoVO.setDeptName(deptService.getById(userDept.getDeptId()).getDeptName());
        }
        return ResultBean.success(userVO);
    }

    @GetMapping("token")
    @ApiOperation("获取鉴权令牌")
    ResultBean<Map<String,String>> getToken(@RequestParam(value = "code", required = false) String oauthCode)
    {
        String oauthType = "";
        String accessToken = "";
        String refreshToken = "";
        if (StringUtils.isNotEmpty(oauthCode)){
            oauthType = "authorization_code";
            ResultBean<OAuth2VO> resultBean = ssoApi.getToken(oauthType, key, secret, oauthCode, null);
            if (!Constants.SUCCESS.equals(resultBean.getCode())){
                return ResultBean.error("获取鉴权令牌异常！请重新登录。" + resultBean.getMsg());
            }
            OAuth2VO oAuth2VO = resultBean.getData();
            // 鉴权令牌
            accessToken = oAuth2VO.getAccessToken();
            // 刷新令牌
            refreshToken = oAuth2VO.getRefreshToken();
            // 保存刷新token
            saveOrUpdateToken(accessToken,refreshToken);
        }else {
            String authToken = AuthInfoUtils.getAuthToken();
            ResultBean<Boolean> resultBean = ssoApi.checkToken(authToken);
            if (!Constants.SUCCESS.equals(resultBean.getCode())){
                return ResultBean.error("校验鉴权令牌异常！请重新登录。 " + resultBean.getMsg());
            }
            Boolean aBoolean = resultBean.getData();
            if (aBoolean) {
                oauthType = "authorization_code";
                ResultBean<OAuth2VO> tokenBean = ssoApi.getToken(oauthType, key, secret, oauthCode, null);
                if (!Constants.SUCCESS.equals(resultBean.getCode())) {
                    return ResultBean.error("获取鉴权令牌异常！请重新登录。" + resultBean.getMsg());
                }
                OAuth2VO oAuth2VO = tokenBean.getData();
                // 鉴权令牌
                accessToken = oAuth2VO.getAccessToken();
                // 刷新令牌
                refreshToken = oAuth2VO.getRefreshToken();
                // 保存刷新token
                saveOrUpdateToken(accessToken,refreshToken);
            }else {
                return ResultBean.error("校验鉴权令牌异常！请重新登录。 ");
            }
        }
        Map<String, String> map = new HashMap<>();
        map.put("accessToken",accessToken);
        return ResultBean.success(map);
    }

    @GetMapping("check")
    @ApiOperation("校验鉴权令牌")
    ResultBean<Boolean> checkToken(@RequestParam(value = "access_token", required = false) String accessToken){
        ResultBean<Boolean> resultBean = ssoApi.checkToken(accessToken);
        if (!Constants.SUCCESS.equals(resultBean.getCode())){
            return ResultBean.error("校验鉴权令牌异常！请重新登录。 " + resultBean.getMsg());
        }
        return resultBean;
    }

    @ApiOperation("登出")
    @PostMapping("logout")
    @RbacPermission
    public ResultBean logout(){
        String authToken = AuthInfoUtils.getAuthToken();
        ResultBean resultBean = ssoApi.logout(authToken);
        if (!Constants.SUCCESS.equals(resultBean.getCode())){
            return ResultBean.error("登出异常！请联系管理员。 " + resultBean.getMsg());
        }
        return ResultBean.success("登出成功!");
    }

    @ApiOperation("修改用户密码")
    @PostMapping("/updateUserPassWord")
    @RbacPermission
    public ResultBean updateUserPassWord(@RequestBody UserPassWordDto userPassWordDto){
        String userCode = userPassWordDto.getUserCode();
        User user = userService.getBaseMapper().selectOne(Wrappers.<User>lambdaQuery().eq(User::getUserCode, userCode));
        if (Objects.isNull(user)){
            return ResultBean.error("用户不存在!");
        }
        String oldPassWord = PwdKits.encode(userPassWordDto.getOldPassWord());
        if (!oldPassWord.equals(user.getPassword())){
            return ResultBean.error("输入的旧密码不正确!");
        }
        if (!userPassWordDto.getNewPassWord().equals(userPassWordDto.getAgainPassWord())){
            return ResultBean.error("两次输入的新密码不正确!");
        }
        String newPassWord = PwdKits.encode(userPassWordDto.getNewPassWord());
        user.setPassword(newPassWord);
        userService.updateById(user);
        return ResultBean.success("修改成功!");
    }

    @ApiOperation("查询用户菜单信息")
    @PostMapping("getUserMenuInfo")
    @RbacPermission
    public ResultBean getUserMenuInfo(){
        String authToken = AuthInfoUtils.getAuthToken();
        ResultBean<UserTokenVO> resultBean = ssoApi.getUserInfoByToken(authToken);
        if (!Constants.SUCCESS.equals(resultBean.getCode())){
            return ResultBean.error(Constants.LOGIN_NO_PERMISSION,"获取用户信息异常！请重新登录。" + resultBean.getMsg(), null);
        }
        UserTokenVO userVO = resultBean.getData();
        if (Objects.isNull(userVO)){
            return ResultBean.error(Constants.LOGIN_NO_PERMISSION,"获取用户信息异常！请重新登录。", null);
        }
        UserInfoVO userInfoVO = userVO.getUserInfoVO();
        String userCode = userInfoVO.getUserCode();
        // 获取用户信息
        User userInfo = userService.getUserInfoByUserCode(userCode);
        if (Objects.isNull(userInfo)){
            return ResultBean.error(Constants.LOGIN_NO_PERMISSION,"查询用户菜单信息异常！请重新登录。");
        }
        // 1.获取用户角色 2.根据角色获取用户菜单 3.过滤菜单信息 4.组装树结构并返回
        List<Menu> menu = menuService.getUserMenuByAppCode(UserMenuTreeQuery.builder().userId(userInfo.getId()).appCode(appCode).build());
        return ResultBean.success(menu);
    }

    /**
     * 保存或更新 鉴权令牌和刷新令牌
     * @param accessToken
     * @param refreshToken
     */
    private void saveOrUpdateToken(String accessToken, String refreshToken) {
        TokenInfo tokenInfo = tokenInfoService.getBaseMapper().selectOne(Wrappers.<TokenInfo>lambdaQuery().eq(TokenInfo::getAccesstoken, accessToken));
        if (Objects.nonNull(tokenInfo)){
            tokenInfo.setRefreshtoken(refreshToken);
            tokenInfoService.updateById(tokenInfo);
        }else {
            TokenInfo newTokenInfo = new TokenInfo();
            newTokenInfo.setAccesstoken(accessToken);
            newTokenInfo.setRefreshtoken(refreshToken);
            newTokenInfo.setStatus(1);
            newTokenInfo.setDeleted(0);
            tokenInfoService.save(newTokenInfo);
        }
    }
}
