package com.startdis.sys.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.comm.auth.annotation.RbacPermission;
import com.startdis.comm.domain.bean.PagerBean;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.domain.model.PageQuery;
import com.startdis.comm.util.bean.BeanCopyKits;
import com.startdis.sys.domain.model.converter.VariableConverter;
import com.startdis.sys.domain.model.dto.post.VariablePostDTO;
import com.startdis.sys.domain.model.dto.put.VariablePutDTO;
import com.startdis.sys.domain.model.entity.Variable;
import com.startdis.sys.domain.model.query.VariableQuery;
import com.startdis.sys.domain.model.vo.VariableVO;
import com.startdis.sys.server.service.VariableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 全局变量表(Variable)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "Variable", tags = {"全局变量表"})
@RequestMapping("variable")
public class VariableController {

    /**
     * 服务对象
     */
    @Autowired
    private VariableService variableService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("查询单条")
    @RbacPermission
    public ResultBean<VariableVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        Variable variable = variableService.getById(id);
        //处理格式转换
        VariableVO variableVO = VariableConverter.INSTANT.entityToVO(variable);
        return ResultBean.success(variableVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param variableQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @ApiOperation("查询所有")
    @RbacPermission
    public ResultBean<List<VariableVO>> list(@RequestBody VariableQuery variableQuery) {
        //处理格式转换
        Variable variable = VariableConverter.INSTANT.queryToEntity(variableQuery);
        //执行分页查询
        List<Variable> listResult = variableService.list(new QueryWrapper<>(variable));
        return ResultBean.success(BeanCopyKits.coverList(listResult, VariableVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery     分页对象
     * @param variableQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @ApiOperation("分页查询")
    @RbacPermission
    public ResultBean<PagerBean<VariableVO>> page(PageQuery pageQuery, VariableQuery variableQuery) {
        //处理分页条件
        Page<Variable> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        Variable variable = VariableConverter.INSTANT.queryToEntity(variableQuery);
        //执行分页查询
        Page<Variable> pageResult = variableService.page(page, new QueryWrapper<>(variable));
        PagerBean<VariableVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(), pageResult.getSize(),
                BeanCopyKits.coverList(pageResult.getRecords(), VariableVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param variableDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @ApiOperation("新增数据")
    @RbacPermission
    public ResultBean<Boolean> insert(@RequestBody @Validated VariablePostDTO variableDTO) {
        //处理格式转换
        Variable variable = VariableConverter.INSTANT.postDtoToEntity(variableDTO);
        //执行数据保存
        return ResultBean.success(variableService.save(variable));
    }

    /**
     * 修改数据
     *
     * @param variableDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @ApiOperation("修改数据")
    @RbacPermission
    public ResultBean<Boolean> update(@RequestBody @Validated VariablePutDTO variableDTO) {
        //处理格式转换
        Variable variable = VariableConverter.INSTANT.putDtoToEntity(variableDTO);
        //执行数据更新
        return ResultBean.success(variableService.updateById(variable));
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
        return ResultBean.success(variableService.removeByIds(ids));
    }

    @PostMapping("/search")
    @ApiOperation("查询数据和筛选")
    @RbacPermission
    public ResultBean<List<VariableVO>> search(@RequestBody VariableQuery variableQuery) {
        List<Variable> listResult = variableService.search(variableQuery);
        return ResultBean.success(BeanCopyKits.coverList(listResult, VariableVO.class));

    }
}

