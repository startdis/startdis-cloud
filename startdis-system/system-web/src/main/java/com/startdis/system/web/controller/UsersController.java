package com.startdis.system.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.common.domain.bean.PagerBean;
import com.startdis.common.domain.bean.ResultBean;
import com.startdis.common.domain.model.PageQuery;
import com.startdis.common.util.bean.BeanCopyUtils;
import com.startdis.system.domain.model.dto.UsersPostDTO;
import com.startdis.system.domain.model.dto.UsersPutDTO;
import com.startdis.system.domain.model.entity.Users;
import com.startdis.system.domain.model.query.UsersQuery;
import com.startdis.system.domain.model.vo.UsersVO;
import com.startdis.system.server.service.UsersService;
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
 * @desc 用户表(Users)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "Users", tags = {"用户表"})
@RequestMapping("users")
public class UsersController {
    
    /**
     * 服务对象
     */
    @Resource
    private UsersService usersService;
    
    
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("查询单条")
    public ResultBean<UsersVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        UsersVO usersVO = new UsersVO();
        Users users = usersService.getById(id);
        BeanUtils.copyProperties(users, usersVO);
        return ResultBean.success(usersVO);
    }
    
    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param usersQuery 实例对象
     * @return 对象列表
     */
    @GetMapping(value = "/list")
    @ApiOperation("查询所有")
    public ResultBean<List<UsersVO>> list(UsersQuery usersQuery) {
        //处理查询条件
        Users users = new Users();
        BeanUtils.copyProperties(usersQuery, users);
        //执行分页查询
        List<Users> listResult = usersService.list(new QueryWrapper<>(users));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, UsersVO.class));
    }
    
    /**
     * 分页查询所有数据
     *
     * @param pageQuery  分页对象
     * @param usersQuery 查询实体
     * @return 分页对象
     */
    @GetMapping(value = "/page")
    @ApiOperation("分页查询")
    public ResultBean<PagerBean<UsersVO>> page(PageQuery pageQuery, UsersQuery usersQuery) {
        //处理分页条件
        Page<Users> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理查询条件
        Users users = new Users();
        BeanUtils.copyProperties(usersQuery, users);
        //执行分页查询
        Page<Users> pageResult = usersService.page(page, new QueryWrapper<>(users));
        PagerBean<UsersVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), UsersVO.class));
        return ResultBean.success(pageBean);
    }
    
    /**
     * 新增数据
     *
     * @param usersDTO 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation("新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated UsersPostDTO usersDTO) {
        Users users = new Users();
        BeanUtils.copyProperties(usersDTO, users);
        return ResultBean.success(usersService.save(users));
    }
    
    /**
     * 修改数据
     *
     * @param usersDTO 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated UsersPutDTO usersDTO) {
        Users users = new Users();
        BeanUtils.copyProperties(usersDTO, users);
        return ResultBean.success(usersService.updateById(users));
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
        return ResultBean.success(usersService.removeByIds(ids));
    }
    
}

