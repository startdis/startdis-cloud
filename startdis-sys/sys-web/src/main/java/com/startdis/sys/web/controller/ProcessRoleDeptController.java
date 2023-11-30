package com.startdis.sys.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.comm.auth.annotation.RbacPermission;
import com.startdis.comm.domain.bean.PagerBean;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.domain.model.PageQuery;
import com.startdis.comm.util.bean.BeanCopyKits;
import com.startdis.sys.domain.model.converter.ProcessRoleDeptConverter;
import com.startdis.sys.domain.model.dto.post.ProcessRoleDeptPostDTO;
import com.startdis.sys.domain.model.dto.put.ProcessRoleDeptPutDTO;
import com.startdis.sys.domain.model.entity.ProcessRoleDept;
import com.startdis.sys.domain.model.query.ProcessRoleDeptQuery;
import com.startdis.sys.domain.model.vo.ProcessRoleDeptVO;
import com.startdis.sys.server.service.ProcessRoleDeptService;
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
 * @desc 流程角色部门表(ProcessRoleDept)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "ProcessRoleDeptDept", tags = {"流程角色部门表"})
@RequestMapping("processRoleDept")
public class ProcessRoleDeptController {
    /**
     * 服务对象
     */
    @Resource
    private ProcessRoleDeptService processRoleDeptService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("查询单条")
    @RbacPermission
    public ResultBean<ProcessRoleDeptVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        ProcessRoleDeptVO processRoleDeptVO = processRoleDeptService.getInfoById(id);
        return ResultBean.success(processRoleDeptVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param processRoleDeptQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @ApiOperation("查询所有")
    @RbacPermission
    public ResultBean<List<ProcessRoleDeptVO>> list(@RequestBody ProcessRoleDeptQuery processRoleDeptQuery) {
        //处理格式转换
        ProcessRoleDept processRoleDept = ProcessRoleDeptConverter.INSTANT.queryToEntity(processRoleDeptQuery);
        //执行分页查询
        List<ProcessRoleDept> listResult = processRoleDeptService.list(new QueryWrapper<>(processRoleDept));
        return ResultBean.success(BeanCopyKits.coverList(listResult, ProcessRoleDeptVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery        分页对象
     * @param processRoleDeptQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @ApiOperation("分页查询")
    @RbacPermission
    public ResultBean<PagerBean<ProcessRoleDeptVO>> page(PageQuery pageQuery, ProcessRoleDeptQuery processRoleDeptQuery) {
        PageHelper.startPage(pageQuery.getPageNum(), pageQuery.getPageSize());
        //执行分页查询
        List<ProcessRoleDeptVO> list = processRoleDeptService.pageList(processRoleDeptQuery);
        PageHelper.clearPage();
        PagerBean<ProcessRoleDeptVO> pageBean = new PagerBean<>(Long.valueOf(list.size()), Long.valueOf(pageQuery.getPageNum()),
                Long.valueOf(pageQuery.getPageSize()), list);
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param processRoleDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @ApiOperation("新增数据")
    @RbacPermission
    public ResultBean<Boolean> insert(@RequestBody @Validated ProcessRoleDeptPostDTO processRoleDTO) {
        //处理格式转换
        ProcessRoleDept processRoleDept = ProcessRoleDeptConverter.INSTANT.postDtoToEntity(processRoleDTO);
        //执行数据保存
        return ResultBean.success(processRoleDeptService.save(processRoleDept));
    }

    /**
     * 修改数据
     *
     * @param processRoleDeptPutDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @ApiOperation("修改数据")
    @RbacPermission
    public ResultBean<Boolean> update(@RequestBody @Validated ProcessRoleDeptPutDTO processRoleDeptPutDTO) {
        //处理格式转换
        ProcessRoleDept processRoleDept = ProcessRoleDeptConverter.INSTANT.putDtoToEntity(processRoleDeptPutDTO);
        //执行数据更新
        return ResultBean.success(processRoleDeptService.updateById(processRoleDept));
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
        return ResultBean.success(processRoleDeptService.removeByIds(ids));
    }
    
}

