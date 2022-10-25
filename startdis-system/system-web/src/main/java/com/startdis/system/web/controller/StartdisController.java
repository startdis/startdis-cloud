package com.startdis.system.web.controller;

import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.common.domain.bean.ResultBean;
import com.startdis.system.domain.model.dto.post.RegisterDTO;
import com.startdis.system.server.service.StartdisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 注册登录控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "Post", tags = {"启迪入口"})
@RequestMapping("startdis")
public class StartdisController {
    
    @Resource
    private StartdisService startdisService;
    
    /**
     * 平台注册
     *
     * @param registerDTO 实体对象
     * @return 注册结果
     */
    @PostMapping(value = "/register")
    @ApiOperation("平台注册")
    public ResultBean<String> register(@RequestBody @Validated RegisterDTO registerDTO) {
        
        return ResultBean.success(startdisService.register(registerDTO));
    }
    
}
