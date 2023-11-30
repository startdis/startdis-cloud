package com.startdis.sys.web.controller;


import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.comm.core.constant.Constants;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.sso.api.client.SsoApi;
import com.startdis.sso.domain.model.query.AppInfoQuery;
import com.startdis.sso.domain.model.vo.AppInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 应用中心表(AppInfo)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "AppInfo", tags = {"应用中心表"})
@RequestMapping("appInfo")
public class AppInfoController {

    @Resource
    private SsoApi ssoApi;

    @PostMapping(value = "list")
    @ApiOperation("获取应用列表")
    ResultBean appInfoList(@RequestBody AppInfoQuery appInfoQuery){
        ResultBean<List<AppInfoVO>> resultBean = ssoApi.appInfoList(appInfoQuery);
        if (!Constants.SUCCESS.equals(resultBean.getCode())){
            return ResultBean.error("获取应用列表异常！");
        }
        return resultBean;
    }
}

