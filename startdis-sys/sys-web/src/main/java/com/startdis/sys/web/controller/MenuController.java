package com.startdis.sys.web.controller;


import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.comm.auth.annotation.RbacPermission;
import com.startdis.comm.domain.bean.PagerBean;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.domain.bean.TreeBuild;
import com.startdis.comm.domain.model.PageQuery;
import com.startdis.comm.util.bean.BeanCopyKits;
import com.startdis.comm.util.object.ObjectKits;
import com.startdis.sys.domain.model.converter.MenuConverter;
import com.startdis.sys.domain.model.dto.post.MenuPostDTO;
import com.startdis.sys.domain.model.dto.put.MenuPutDTO;
import com.startdis.sys.domain.model.entity.Menu;
import com.startdis.sys.domain.model.query.MenuQuery;
import com.startdis.sys.domain.model.query.UserMenuTreeQuery;
import com.startdis.sys.domain.model.tree.MenuTree;
import com.startdis.sys.domain.model.vo.MenuVO;
import com.startdis.sys.server.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
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
import java.util.Map;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
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
    @RbacPermission
    public ResultBean<MenuVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        Menu menu = menuService.getById(id);
        //处理格式转换
        MenuVO menuVO = MenuConverter.INSTANT.entityToVO(menu);
        return ResultBean.success(menuVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param menuQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/tree")
    @ApiOperation("查询树结构")
    @RbacPermission
    public ResultBean<List<MenuTree>> tree(@RequestBody MenuQuery menuQuery) {
        // 根据名称进行模糊匹配
        LambdaQueryWrapper<Menu> queryWrapper = Wrappers.<Menu>lambdaQuery()
                .like(StringUtils.isNotEmpty(menuQuery.getMenuName()), Menu::getMenuName, menuQuery.getMenuName())
                .eq(StringUtils.isNotEmpty(menuQuery.getAppCode()), Menu::getAppCode, menuQuery.getAppCode())
                .orderByAsc(Menu::getMenuSort);
        List<Menu> listResult = menuService.getBaseMapper().selectList(queryWrapper);
        // 原查询结果转换树形结构
        List<MenuTree> menuTrees = BeanCopyKits.coverList(listResult, MenuTree.class);

        //查询条件为空，默认查询根结点为0的一级部门
        if (ObjectKits.isEmpty(menuQuery) && CollectionUtil.isNotEmpty(menuTrees)) {
            String rootId = "0";
            // 创建树形结构并返回
            TreeBuild treeBuild = new TreeBuild(rootId, menuTrees);
            return ResultBean.success(treeBuild.buildTree());
        }
        return ResultBean.success(menuTrees);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param menuQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @ApiOperation("查询所有")
    @RbacPermission
    public ResultBean<List<MenuVO>> list(@RequestBody MenuQuery menuQuery) {
        //处理格式转换
        Menu menu = MenuConverter.INSTANT.queryToEntity(menuQuery);
        //执行分页查询
        List<Menu> listResult = menuService.list(new QueryWrapper<>(menu));
        return ResultBean.success(BeanCopyKits.coverList(listResult, MenuVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery 分页对象
     * @param menuQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @ApiOperation("分页查询")
    @RbacPermission
    public ResultBean<PagerBean<MenuVO>> page(PageQuery pageQuery, MenuQuery menuQuery) {
        //处理分页条件
        Page<Menu> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        Menu menu = MenuConverter.INSTANT.queryToEntity(menuQuery);
        //执行分页查询
        Page<Menu> pageResult = menuService.page(page, new QueryWrapper<>(menu));
        PagerBean<MenuVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(), pageResult.getSize(),
                BeanCopyKits.coverList(pageResult.getRecords(), MenuVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param menuDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @ApiOperation("新增数据")
    @RbacPermission
    public ResultBean<Boolean> insert(@RequestBody @Validated MenuPostDTO menuDTO) {
        //处理格式转换
        Menu menu = MenuConverter.INSTANT.postDtoToEntity(menuDTO);
        //执行数据保存
        return ResultBean.success(menuService.save(menu));
    }

    /**
     * 修改数据
     *
     * @param menuDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @ApiOperation("修改数据")
    @RbacPermission
    public ResultBean<Boolean> update(@RequestBody @Validated MenuPutDTO menuDTO) {
        //处理格式转换
        Menu menu = MenuConverter.INSTANT.putDtoToEntity(menuDTO);
        //执行数据更新
        return ResultBean.success(menuService.updateById(menu));
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
        return ResultBean.success(menuService.removeByIds(ids));
    }

    @PostMapping("getUserMenuTreeByAppCode")
    @ApiOperation("查询用户应用菜单")
    @RbacPermission
    public ResultBean<List<Menu>> getUserMenuTreeByAppCode(@RequestBody UserMenuTreeQuery userMenuTreeQuery){
        List<Menu> listResult = menuService.getUserMenuByAppCode(userMenuTreeQuery);
//        // 原查询结果转换树形结构
//        List<MenuTree> menuTrees = BeanCopyKits.coverList(listResult, MenuTree.class);
//
//        //查询条件为空，默认查询根结点为0的一级部门
//        if (CollectionUtil.isNotEmpty(menuTrees)) {
//            String rootId = "0";
//            // 创建树形结构并返回
//            TreeBuild treeBuild = new TreeBuild(rootId, menuTrees);
//            return ResultBean.success(treeBuild.buildTree());
//        }
        return ResultBean.success(listResult);
    }

    @PostMapping("getAppCodeMenuList")
    @ApiOperation("查询应用菜单")
    @RbacPermission
    public ResultBean<List<Map<String, Object>>> getAppCodeMenuList(){
        return menuService.getAppCodeMenuList();
    }

    @GetMapping("getAllMenuByUser")
    @ApiOperation("查询用户所有菜单")
    @RbacPermission
    public ResultBean<List<Menu>> getAllMenuByUser(@RequestParam String userCode){
        return menuService.getAllMenuByUser(userCode);
    }
}

