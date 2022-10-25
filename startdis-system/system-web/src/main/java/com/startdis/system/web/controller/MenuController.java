package com.startdis.system.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.common.domain.bean.PagerBean;
import com.startdis.common.domain.bean.ResultBean;
import com.startdis.common.domain.model.PageQuery;
import com.startdis.common.util.bean.BeanCopyUtils;
import com.startdis.system.domain.model.dto.MenuPostDTO;
import com.startdis.system.domain.model.dto.MenuPutDTO;
import com.startdis.system.domain.model.entity.Menu;
import com.startdis.system.domain.model.query.MenuQuery;
import com.startdis.system.domain.model.vo.MenuVO;
import com.startdis.system.server.service.MenuService;
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
 * @desc 菜单表(Menu)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "Menu", tags = {"菜单表"})
@RequestMapping("menu")
public class MenuController {
    
    /**
     * 服务对象
     */
    @Resource
    private MenuService menuService;
    
    
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("查询单条")
    public ResultBean<MenuVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        MenuVO menuVO = new MenuVO();
        Menu menu = menuService.getById(id);
        BeanUtils.copyProperties(menu, menuVO);
        return ResultBean.success(menuVO);
    }
    
    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param menuQuery 实例对象
     * @return 对象列表
     */
    @GetMapping(value = "/list")
    @ApiOperation("查询所有")
    public ResultBean<List<MenuVO>> list(MenuQuery menuQuery) {
        //处理查询条件
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuQuery, menu);
        //执行分页查询
        List<Menu> listResult = menuService.list(new QueryWrapper<>(menu));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, MenuVO.class));
    }
    
    /**
     * 分页查询所有数据
     *
     * @param pageQuery 分页对象
     * @param menuQuery 查询实体
     * @return 分页对象
     */
    @GetMapping(value = "/page")
    @ApiOperation("分页查询")
    public ResultBean<PagerBean<MenuVO>> page(PageQuery pageQuery, MenuQuery menuQuery) {
        //处理分页条件
        Page<Menu> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理查询条件
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuQuery, menu);
        //执行分页查询
        Page<Menu> pageResult = menuService.page(page, new QueryWrapper<>(menu));
        PagerBean<MenuVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), MenuVO.class));
        return ResultBean.success(pageBean);
    }
    
    /**
     * 新增数据
     *
     * @param menuDTO 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation("新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated MenuPostDTO menuDTO) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuDTO, menu);
        return ResultBean.success(menuService.save(menu));
    }
    
    /**
     * 修改数据
     *
     * @param menuDTO 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated MenuPutDTO menuDTO) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuDTO, menu);
        return ResultBean.success(menuService.updateById(menu));
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
        return ResultBean.success(menuService.removeByIds(ids));
    }
    
}

