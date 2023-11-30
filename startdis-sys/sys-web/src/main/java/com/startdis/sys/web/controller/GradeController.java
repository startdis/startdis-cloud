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
import com.startdis.comm.domain.model.PageQuery;
import com.startdis.comm.exception.custom.BusinessException;
import com.startdis.comm.util.bean.BeanCopyKits;
import com.startdis.sys.domain.model.converter.GradeConverter;
import com.startdis.sys.domain.model.dto.post.GradePostDTO;
import com.startdis.sys.domain.model.dto.put.GradePutDTO;
import com.startdis.sys.domain.model.entity.Grade;
import com.startdis.sys.domain.model.query.GradeQuery;
import com.startdis.sys.domain.model.vo.GradeVO;
import com.startdis.sys.server.service.GradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 职系表(Grade)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "Grade", tags = {"职系表"})
@RequestMapping("grade")
public class GradeController {
    /**
     * 服务对象
     */
    @Resource
    private GradeService gradeService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("查询单条")
    @RbacPermission
    public ResultBean<GradeVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        Grade grade = gradeService.getById(id);
        //处理格式转换
        GradeVO gradeVO = GradeConverter.INSTANT.entityToVO(grade);
        return ResultBean.success(gradeVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param gradeQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @ApiOperation("查询所有")
    @RbacPermission
    public ResultBean<List<GradeVO>> list(@RequestBody GradeQuery gradeQuery) {
        //处理格式转换
        Grade grade = GradeConverter.INSTANT.queryToEntity(gradeQuery);
        //执行分页查询
        List<Grade> listResult = gradeService.list(new QueryWrapper<>(grade));
        return ResultBean.success(BeanCopyKits.coverList(listResult, GradeVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery  分页对象
     * @param gradeQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @ApiOperation("分页查询")
    @RbacPermission
    public ResultBean<PagerBean<GradeVO>> page(PageQuery pageQuery, GradeQuery gradeQuery) {
        //处理分页条件
        Page<Grade> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        Grade grade = GradeConverter.INSTANT.queryToEntity(gradeQuery);
        LambdaQueryWrapper<Grade> queryWrapper = Wrappers.<Grade>lambdaQuery()
                .like(StringUtils.isNotEmpty(grade.getGradeName()), Grade::getGradeName, grade.getGradeName())
                .orderByAsc(Grade::getGradeSort);
        //执行分页查询
        Page<Grade> pageResult = gradeService.page(page, queryWrapper);
        PagerBean<GradeVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyKits.coverList(pageResult.getRecords(), GradeVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 校验重复添加
     * @param grade
     */
    private void checkExist(Grade grade) {
        LambdaQueryWrapper<Grade> wrapper = Wrappers.lambdaQuery(Grade.class)
                .and(temp ->temp.eq(Grade::getGradeCode, grade.getGradeCode()).or().eq(Grade::getGradeName, grade.getGradeName()));
        if(StringUtils.isNotEmpty(grade.getId())){
            wrapper.ne(Grade::getId, grade.getId());
        }
        List<Grade> list = gradeService.list(wrapper);
        if(CollectionUtil.isNotEmpty(list)){
            throw new BusinessException("A0001", "职系编码或职系名称已存在，请勿重复添加！");
        }
    }

    /**
     * 新增数据
     *
     * @param gradeDTO 实体对象
     * @return 新增结果
     */
    @PostMapping(value = "/add")
    @ApiOperation("新增数据")
    @RbacPermission
    public ResultBean<Boolean> insert(@RequestBody @Validated GradePostDTO gradeDTO) {
        //处理格式转换
        Grade grade = GradeConverter.INSTANT.postDtoToEntity(gradeDTO);
        // Updated by limengwei at 20230617，编码或名称重复校验
        checkExist(grade);
        //执行数据保存
        return ResultBean.success(gradeService.save(grade));
    }

    /**
     * 修改数据
     *
     * @param gradeDTO 实体对象
     * @return 修改结果
     */
    @PutMapping(value = "/update")
    @ApiOperation("修改数据")
    @RbacPermission
    public ResultBean<Boolean> update(@RequestBody @Validated GradePutDTO gradeDTO) {
        //处理格式转换
        Grade grade = GradeConverter.INSTANT.putDtoToEntity(gradeDTO);
        // Updated by limengwei at 20230617，编码或名称重复校验
        checkExist(grade);
        //执行数据更新
        return ResultBean.success(gradeService.updateById(grade));
    }

    /**
     * 删除数据
     *
     * @param ids 主键结合
     * @return 删除结果
     */
    @DeleteMapping(value = "/delete")
    @ApiOperation("删除数据")
    @RbacPermission
    public ResultBean<Boolean> delete(@RequestParam("ids") List<String> ids) {
        return ResultBean.success(gradeService.removeByIds(ids));
    }

}

