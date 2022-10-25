package com.startdis.system.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.common.domain.bean.PagerBean;
import com.startdis.common.domain.bean.ResultBean;
import com.startdis.common.domain.model.PageQuery;
import com.startdis.common.util.bean.BeanCopyUtils;
import com.startdis.system.domain.model.dto.DeptPostDTO;
import com.startdis.system.domain.model.dto.DeptPutDTO;
import com.startdis.system.domain.model.entity.Dept;
import com.startdis.system.domain.model.query.DeptQuery;
import com.startdis.system.domain.model.vo.DeptVO;
import com.startdis.system.server.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
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
 * @email startdis@cloud-number.cn
 * @desc 部门表(Dept)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "Dept", tags = {"部门表"})
@RequestMapping("dept")
public class DeptController {
    
    /**
     * 服务对象
     */
    @Resource
    private DeptService deptService;
    
    
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("查询单条")
    public ResultBean<DeptVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        DeptVO deptVO = new DeptVO();
        Dept dept = deptService.getById(id);
        BeanUtils.copyProperties(dept, deptVO);
        return ResultBean.success(deptVO);
    }
    
    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param deptQuery 实例对象
     * @return 对象列表
     */
    @GetMapping(value = "/list")
    @ApiOperation("查询所有")
    public ResultBean<List<DeptVO>> list(DeptQuery deptQuery) {
        //处理查询条件
        Dept dept = new Dept();
        BeanUtils.copyProperties(deptQuery, dept);
        //执行分页查询
        List<Dept> listResult = deptService.list(new QueryWrapper<>(dept));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, DeptVO.class));
    }
    
    /**
     * 分页查询所有数据
     *
     * @param pageQuery 分页对象
     * @param deptQuery 查询实体
     * @return 分页对象
     */
    @GetMapping(value = "/page")
    @ApiOperation("分页查询")
    public ResultBean<PagerBean<DeptVO>> page(PageQuery pageQuery, DeptQuery deptQuery) {
        //处理分页条件
        Page<Dept> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理查询条件
        Dept dept = new Dept();
        BeanUtils.copyProperties(deptQuery, dept);
        //执行分页查询
        Page<Dept> pageResult = deptService.page(page, new QueryWrapper<>(dept));
        PagerBean<DeptVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), DeptVO.class));
        return ResultBean.success(pageBean);
    }
    
    /**
     * 新增数据
     *
     * @param deptDTO 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation("新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated DeptPostDTO deptDTO) {
        Dept dept = new Dept();
        BeanUtils.copyProperties(deptDTO, dept);
        return ResultBean.success(deptService.save(dept));
    }
    
    /**
     * 修改数据
     *
     * @param deptDTO 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated DeptPutDTO deptDTO) {
        Dept dept = new Dept();
        BeanUtils.copyProperties(deptDTO, dept);
        return ResultBean.success(deptService.updateById(dept));
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
        return ResultBean.success(deptService.removeByIds(ids));
    }
    
}

