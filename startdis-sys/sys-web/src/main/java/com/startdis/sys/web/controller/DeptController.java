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
import com.startdis.comm.util.auth.AuthInfoUtils;
import com.startdis.comm.util.bean.BeanCopyKits;
import com.startdis.comm.util.config.SnowflakeConfig;
import com.startdis.sys.domain.model.converter.DeptConverter;
import com.startdis.sys.domain.model.dto.post.DeptPostDTO;
import com.startdis.sys.domain.model.dto.put.DeptPutDTO;
import com.startdis.sys.domain.model.entity.Dept;
import com.startdis.sys.domain.model.entity.User;
import com.startdis.sys.domain.model.entity.UserDept;
import com.startdis.sys.domain.model.query.DeptQuery;
import com.startdis.sys.domain.model.tree.DeptTree;
import com.startdis.sys.domain.model.vo.DeptVO;
import com.startdis.sys.server.service.DeptService;
import com.startdis.sys.server.service.UserDeptService;
import com.startdis.sys.server.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 部门表(Dept)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "Dept", tags = {"部门表"})
@RequestMapping("/dept")
public class DeptController {

    /**
     * 服务对象
     */
    @Resource
    private DeptService deptService;

    @Resource
    private UserDeptService userDeptService;

    @Resource
    private UserService userService;

    /**
     * 雪花ID生成
     */
    @Resource
    private SnowflakeConfig snowflakeConfig;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("查询单条")
    @RbacPermission
    public ResultBean<DeptVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        Dept dept = deptService.getById(id);
        //处理格式转换
        DeptVO deptVO = DeptConverter.INSTANT.entityToVO(dept);
        return ResultBean.success(deptVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param deptQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/tree")
    @ApiOperation("查询树结构")
    @RbacPermission
    public ResultBean<List<DeptTree>> tree(@RequestBody DeptQuery deptQuery) {
        Dept dept = DeptConverter.INSTANT.queryToEntity(deptQuery);
        List<Dept> listResult = deptService.getBaseMapper().selectList(Wrappers.<Dept>lambdaQuery()
                .like(StringUtils.isNotEmpty(dept.getDeptName()), Dept::getDeptName, dept.getDeptName())
                .eq(StringUtils.isNotEmpty(deptQuery.getParentId()), Dept::getParentId, dept.getParentId())
                .eq(StringUtils.isNotEmpty(dept.getCompanyId()), Dept::getCompanyId, dept.getCompanyId())
                .orderByAsc(Dept::getDeptSort));
        // 原查询结果转换树形结构
        List<DeptTree> deptTrees = BeanCopyKits.coverList(listResult, DeptTree.class);

        //查询条件为空，默认查询根结点为0的一级部门
        if (CollectionUtil.isNotEmpty(deptTrees)) {
            String rootId = "0";

            // 创建树形结构并返回
            TreeBuild treeBuild = new TreeBuild(rootId, deptTrees);
            return ResultBean.success(treeBuild.buildTree());
        }
        return ResultBean.success(deptTrees);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param deptQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @ApiOperation("查询所有")
    @RbacPermission
    public ResultBean<List<DeptVO>> list(@RequestBody DeptQuery deptQuery) {
        //处理格式转换
        Dept dept = DeptConverter.INSTANT.queryToEntity(deptQuery);
        LambdaQueryWrapper<Dept> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotEmpty(dept.getCompanyId())) {
            queryWrapper.eq(Dept::getCompanyId, dept.getCompanyId());
        }
        if (StringUtils.isNotEmpty(dept.getParentId())) {
            queryWrapper.eq(Dept::getParentId, dept.getParentId());
        }
        //执行分页查询
        List<Dept> listResult = deptService.list(queryWrapper);
        return ResultBean.success(BeanCopyKits.coverList(listResult, DeptVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery 分页对象
     * @param deptQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @ApiOperation("分页查询")
    @RbacPermission
    public ResultBean<PagerBean<DeptVO>> page(PageQuery pageQuery, DeptQuery deptQuery) {
        //处理分页条件
        Page<Dept> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        Dept dept = DeptConverter.INSTANT.queryToEntity(deptQuery);
        //执行分页查询
        Page<Dept> pageResult = deptService.page(page, new QueryWrapper<>(dept));
        PagerBean<DeptVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(), pageResult.getSize(),
                BeanCopyKits.coverList(pageResult.getRecords(), DeptVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param deptDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @ApiOperation("新增数据")
    @RbacPermission
    //@Transactional(rollbackFor = Exception.class,transactionManager = "transactionManager")
    public ResultBean<Boolean> insert(@RequestBody @Validated DeptPostDTO deptDTO) {
        //新增部门信息
        Dept dept = DeptConverter.INSTANT.postDtoToEntity(deptDTO);
        return deptService.add(dept);
    }

    /**
     * 修改数据
     *
     * @param deptDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @ApiOperation("修改数据")
    @RbacPermission
    public ResultBean<Boolean> update(@RequestBody @Validated DeptPutDTO deptDTO) {
        //更新部门信息
        Dept dept = DeptConverter.INSTANT.putDtoToEntity(deptDTO);
        return deptService.update(dept);
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
    @Transactional(rollbackFor = Exception.class, transactionManager = "transactionManager")
    public ResultBean<Boolean> delete(@RequestParam("ids") List<String> ids) {
        for (String id : ids) {
            //删除用户部门信息
            LambdaQueryWrapper<UserDept> userDeptQueryWrapper = Wrappers.lambdaQuery(UserDept.class).eq(UserDept::getDeptId, id);
            userDeptService.remove(userDeptQueryWrapper);
        }
        //删除部门信息
        deptService.removeByIds(ids);
        return ResultBean.success("删除数据成功！");
    }

    /**
     * 根据userId查询部门
     *
     * @return 对象列表
     */
    @PostMapping(value = "/getDeptByUser")
    @ApiOperation("根据userId查询部门")
    public ResultBean<DeptVO> getDeptByUser(@RequestParam("userId") String userId) {
        String companyTenantId = AuthInfoUtils.getCompanyTenantId();
        QueryWrapper<UserDept> userDeptQueryWrapper = new QueryWrapper<>();
        userDeptQueryWrapper.eq("user_id", userId);
        UserDept userDept = userDeptService.getOne(userDeptQueryWrapper);
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
//        if (Constantsbum.SYS_COMPANY_ID.equals(companyTenantId)) {
//            queryWrapper.eq("parent_id", "002");
//        }else{
//            queryWrapper.eq("parent_id", "003");
//        }
        queryWrapper.eq("id", userDept.getDeptId());
        queryWrapper.eq("company_tenant_id", companyTenantId);
        queryWrapper.eq("status", "1");
        queryWrapper.eq("deleted", "0");

        //执行查询
        Dept result = deptService.getOne(queryWrapper);
        return ResultBean.success(BeanCopyKits.copyPropertiesThird(result, DeptVO.class));
    }

    @GetMapping(value = "/getDeptByUserCode")
    @ApiOperation("根据UserCode查询部门")
    public ResultBean<DeptVO> getDeptByUserCode(@RequestParam("userCode") String userCode) {
        User user = userService.getBaseMapper().selectOne(Wrappers.<User>lambdaQuery().eq(User::getUserCode, userCode));
        UserDept userDept = userDeptService.getBaseMapper().selectOne(Wrappers.<UserDept>lambdaQuery().eq(UserDept::getUserId, user.getId()));
        Dept dept = deptService.getById(userDept.getDeptId());
        return ResultBean.success(BeanCopyKits.copyPropertiesThird(dept, DeptVO.class));
    }

    @GetMapping(value = "/getLeaderDeptInPms")
    @ApiOperation("查询pms项目管理部门")
    public ResultBean<List<DeptVO>> getLeaderDeptInPms() {
        // 先查询项目管理部门
        Dept dept = deptService.getBaseMapper().selectOne(Wrappers.<Dept>lambdaQuery().eq(Dept::getDeptCode, "NT-XMGLBM"));
        if (Objects.isNull(dept)){
            return ResultBean.success(Collections.EMPTY_LIST);
        }
        // 再查询项目管理部门有哪些
        List<Dept> listResult = deptService.getBaseMapper().selectList(Wrappers.<Dept>lambdaQuery().eq(Dept::getParentId, dept.getId()));
        return ResultBean.success(BeanCopyKits.coverList(listResult, DeptVO.class));
    }
}

