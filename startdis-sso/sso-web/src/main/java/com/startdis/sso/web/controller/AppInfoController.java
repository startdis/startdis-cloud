package com.startdis.sso.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.comm.domain.bean.PagerBean;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.domain.model.PageQuery;
import com.startdis.comm.util.bean.BeanCopyKits;
import com.startdis.sso.domain.model.converter.AppInfoConverter;
import com.startdis.sso.domain.model.dto.post.AppInfoPostDTO;
import com.startdis.sso.domain.model.dto.put.AppInfoPutDTO;
import com.startdis.sso.domain.model.entity.AppInfo;
import com.startdis.sso.domain.model.query.AppInfoQuery;
import com.startdis.sso.domain.model.vo.AppInfoVO;
import com.startdis.sso.server.service.AppInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
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
    /**
     * 服务对象
     */
    @Resource
    private AppInfoService appInfoService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("查询单条")
    public ResultBean<AppInfoVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        AppInfo ssoAppInfo = appInfoService.getById(id);
        //处理格式转换
        AppInfoVO ssoAppInfoVO = AppInfoConverter.INSTANT.entityToVO(ssoAppInfo);
        return ResultBean.success(ssoAppInfoVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param ssoAppInfoQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @ApiOperation("查询所有")
    public ResultBean<List<AppInfoVO>> list(@RequestBody AppInfoQuery ssoAppInfoQuery) {
        //处理格式转换
        AppInfo ssoAppInfo = AppInfoConverter.INSTANT.queryToEntity(ssoAppInfoQuery);
        //执行分页查询
        List<AppInfo> listResult = appInfoService.list(new QueryWrapper<>(ssoAppInfo));
        return ResultBean.success(BeanCopyKits.coverList(listResult, AppInfoVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery       分页对象
     * @param ssoAppInfoQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @ApiOperation("分页查询")
    public ResultBean<PagerBean<AppInfoVO>> page(PageQuery pageQuery, AppInfoQuery ssoAppInfoQuery) {
        //处理分页条件
        Page<AppInfo> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        AppInfo ssoAppInfo = AppInfoConverter.INSTANT.queryToEntity(ssoAppInfoQuery);
        //执行分页查询
        Page<AppInfo> pageResult = appInfoService.page(page, new QueryWrapper<>(ssoAppInfo));
        PagerBean<AppInfoVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyKits.coverList(pageResult.getRecords(), AppInfoVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param ssoAppInfoDTO 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation("新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated AppInfoPostDTO ssoAppInfoDTO) {
        //处理格式转换
        AppInfo ssoAppInfo = AppInfoConverter.INSTANT.postDtoToEntity(ssoAppInfoDTO);
        //执行数据保存
        return ResultBean.success(appInfoService.save(ssoAppInfo));
    }

    /**
     * 修改数据
     *
     * @param ssoAppInfoDTO 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated AppInfoPutDTO ssoAppInfoDTO) {
        //处理格式转换
        AppInfo ssoAppInfo = AppInfoConverter.INSTANT.putDtoToEntity(ssoAppInfoDTO);
        //执行数据更新
        return ResultBean.success(appInfoService.updateById(ssoAppInfo));
    }

    /**
     * 删除数据
     *
     * @param ids 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    @ApiOperation("删除数据")
    public ResultBean<Boolean> delete(@RequestParam("ids") List<String> ids) {
        return ResultBean.success(appInfoService.removeByIds(ids));
    }

}

