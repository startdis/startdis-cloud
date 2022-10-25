package com.startdis.system.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.common.domain.bean.PagerBean;
import com.startdis.common.domain.bean.ResultBean;
import com.startdis.common.domain.model.PageQuery;
import com.startdis.common.util.bean.BeanCopyUtils;
import com.startdis.system.domain.model.dto.RolePostDTO;
import com.startdis.system.domain.model.dto.RolePutDTO;
import com.startdis.system.domain.model.entity.Role;
import com.startdis.system.domain.model.query.RoleQuery;
import com.startdis.system.domain.model.vo.RoleVO;
import com.startdis.system.server.service.RoleService;
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
 * @desc 角色表(Role)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "Role", tags = {"角色表"})
@RequestMapping("role")
public class RoleController {
    
    /**
     * 服务对象
     */
    @Resource
    private RoleService roleService;
    
    
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("查询单条")
    public ResultBean<RoleVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        RoleVO roleVO = new RoleVO();
        Role role = roleService.getById(id);
        BeanUtils.copyProperties(role, roleVO);
        return ResultBean.success(roleVO);
    }
    
    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param roleQuery 实例对象
     * @return 对象列表
     */
    @GetMapping(value = "/list")
    @ApiOperation("查询所有")
    public ResultBean<List<RoleVO>> list(RoleQuery roleQuery) {
        //处理查询条件
        Role role = new Role();
        BeanUtils.copyProperties(roleQuery, role);
        //执行分页查询
        List<Role> listResult = roleService.list(new QueryWrapper<>(role));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, RoleVO.class));
    }
    
    /**
     * 分页查询所有数据
     *
     * @param pageQuery 分页对象
     * @param roleQuery 查询实体
     * @return 分页对象
     */
    @GetMapping(value = "/page")
    @ApiOperation("分页查询")
    public ResultBean<PagerBean<RoleVO>> page(PageQuery pageQuery, RoleQuery roleQuery) {
        //处理分页条件
        Page<Role> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理查询条件
        Role role = new Role();
        BeanUtils.copyProperties(roleQuery, role);
        //执行分页查询
        Page<Role> pageResult = roleService.page(page, new QueryWrapper<>(role));
        PagerBean<RoleVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), RoleVO.class));
        return ResultBean.success(pageBean);
    }
    
    /**
     * 新增数据
     *
     * @param roleDTO 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation("新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated RolePostDTO roleDTO) {
        Role role = new Role();
        BeanUtils.copyProperties(roleDTO, role);
        return ResultBean.success(roleService.save(role));
    }
    
    /**
     * 修改数据
     *
     * @param roleDTO 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated RolePutDTO roleDTO) {
        Role role = new Role();
        BeanUtils.copyProperties(roleDTO, role);
        return ResultBean.success(roleService.updateById(role));
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
        return ResultBean.success(roleService.removeByIds(ids));
    }
    
}

