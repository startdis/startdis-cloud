package com.startdis.sys.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.comm.auth.annotation.RbacPermission;
import com.startdis.comm.domain.bean.PagerBean;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.domain.model.PageQuery;
import com.startdis.comm.util.bean.BeanCopyKits;
import com.startdis.sys.domain.model.converter.SensitiveWordConverter;
import com.startdis.sys.domain.model.dto.post.SensitiveWordPostDTO;
import com.startdis.sys.domain.model.dto.put.SensitiveWordPutDTO;
import com.startdis.sys.domain.model.entity.SensitiveWord;
import com.startdis.sys.domain.model.query.SensitiveWordQuery;
import com.startdis.sys.domain.model.vo.SensitiveWordVO;
import com.startdis.sys.server.service.SensitiveWordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 系统敏感词表(SensitiveWord)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "SensitiveWord", tags = {"系统敏感词表"})
@RequestMapping("sensitiveWord")
public class SensitiveWordController {

    /**
     * 服务对象
     */
    @Resource
    private SensitiveWordService sensitiveWordService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("查询单条")
    @RbacPermission
    public ResultBean<SensitiveWordVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        SensitiveWord sensitiveWord = sensitiveWordService.getById(id);
        //处理格式转换
        SensitiveWordVO sensitiveWordVO = SensitiveWordConverter.INSTANT.entityToVO(sensitiveWord);
        return ResultBean.success(sensitiveWordVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param sensitiveWordQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @ApiOperation("查询所有")
    @RbacPermission
    public ResultBean<List<SensitiveWordVO>> list(@RequestBody SensitiveWordQuery sensitiveWordQuery) {
        //处理格式转换
        SensitiveWord sensitiveWord = SensitiveWordConverter.INSTANT.queryToEntity(sensitiveWordQuery);
        //执行分页查询
        List<SensitiveWord> listResult = sensitiveWordService.list(new QueryWrapper<>(sensitiveWord));
        return ResultBean.success(BeanCopyKits.coverList(listResult, SensitiveWordVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery          分页对象
     * @param sensitiveWordQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @ApiOperation("分页查询")
    @RbacPermission
    public ResultBean<PagerBean<SensitiveWordVO>> page(PageQuery pageQuery, SensitiveWordQuery sensitiveWordQuery) {
        //处理分页条件
        Page<SensitiveWord> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        SensitiveWord sensitiveWord = SensitiveWordConverter.INSTANT.queryToEntity(sensitiveWordQuery);
        //执行分页查询
        Page<SensitiveWord> pageResult = sensitiveWordService.page(page, new QueryWrapper<>(sensitiveWord));
        PagerBean<SensitiveWordVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(), pageResult.getSize(),
                BeanCopyKits.coverList(pageResult.getRecords(), SensitiveWordVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param sensitiveWordDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @ApiOperation("新增数据")
    @RbacPermission
    public ResultBean<Boolean> insert(@RequestBody @Validated SensitiveWordPostDTO sensitiveWordDTO) {
        //处理格式转换
        SensitiveWord sensitiveWord = SensitiveWordConverter.INSTANT.postDtoToEntity(sensitiveWordDTO);
        //执行数据保存
        return ResultBean.success(sensitiveWordService.save(sensitiveWord));
    }

    /**
     * 修改数据
     *
     * @param sensitiveWordDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @ApiOperation("修改数据")
    @RbacPermission
    public ResultBean<Boolean> update(@RequestBody @Validated SensitiveWordPutDTO sensitiveWordDTO) {
        //处理格式转换
        SensitiveWord sensitiveWord = SensitiveWordConverter.INSTANT.putDtoToEntity(sensitiveWordDTO);
        //执行数据更新
        return ResultBean.success(sensitiveWordService.updateById(sensitiveWord));
    }

    /**
     * 删除数据
     *
     * @param ids 主键结合
     * @return 删除结果
     */
    @DeleteMapping("/delete")
    @ApiOperation("删除数据")
    @RbacPermission
    public ResultBean<Boolean> delete(@RequestParam("ids") List<String> ids) {
        return ResultBean.success(sensitiveWordService.removeByIds(ids));
    }

}

