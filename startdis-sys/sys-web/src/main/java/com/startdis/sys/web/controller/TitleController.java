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
import com.startdis.sys.domain.model.converter.TitleConverter;
import com.startdis.sys.domain.model.dto.post.TitlePostDTO;
import com.startdis.sys.domain.model.dto.put.TitlePutDTO;
import com.startdis.sys.domain.model.entity.Title;
import com.startdis.sys.domain.model.query.TitleQuery;
import com.startdis.sys.domain.model.vo.TitleVO;
import com.startdis.sys.server.service.TitleService;
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
 * @desc 职位表(Title)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "Title", tags = {"职位表"})
@RequestMapping("title")
public class TitleController {
    /**
     * 服务对象
     */
    @Resource
    private TitleService titleService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("查询单条")
    @RbacPermission
    public ResultBean<TitleVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        Title title = titleService.getById(id);
        //处理格式转换
        TitleVO titleVO = TitleConverter.INSTANT.entityToVO(title);
        return ResultBean.success(titleVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param titleQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @ApiOperation("查询所有")
    @RbacPermission
    public ResultBean<List<TitleVO>> list(@RequestBody TitleQuery titleQuery) {
        //处理格式转换
        Title title = TitleConverter.INSTANT.queryToEntity(titleQuery);
        //执行分页查询
        List<Title> listResult = titleService.list(new QueryWrapper<>(title));
        return ResultBean.success(BeanCopyKits.coverList(listResult, TitleVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery  分页对象
     * @param titleQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @ApiOperation("分页查询")
    @RbacPermission
    public ResultBean<PagerBean<TitleVO>> page(PageQuery pageQuery, TitleQuery titleQuery) {
        //处理分页条件
        Page<Title> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        Title title = TitleConverter.INSTANT.queryToEntity(titleQuery);
        LambdaQueryWrapper<Title> queryWrapper = Wrappers.<Title>lambdaQuery()
                .like(StringUtils.isNotEmpty(title.getTitleName()), Title::getTitleName, title.getTitleName())
                .eq(StringUtils.isNotEmpty(title.getGradeId()),Title::getGradeId,title.getGradeId())
                .orderByAsc(Title::getTitleSort);
        //执行分页查询
        Page<Title> pageResult = titleService.page(page, queryWrapper);
        PagerBean<TitleVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyKits.coverList(pageResult.getRecords(), TitleVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 校验重复添加
     * @param title
     */
    private void checkExist(Title title) {
        LambdaQueryWrapper<Title> wrapper = Wrappers.lambdaQuery(Title.class)
                .eq(Title::getGradeId,title.getGradeId())
                .and(temp ->temp.eq(Title::getTitleCode, title.getTitleCode()).or().eq(Title::getTitleName, title.getTitleName()));
        if(StringUtils.isNotEmpty(title.getId())){
            wrapper.ne(Title::getId, title.getId());
        }
        List<Title> list = titleService.list(wrapper);
        if(CollectionUtil.isNotEmpty(list)){
            throw new BusinessException("A0001", "职系编码或职系名称已存在，请勿重复添加！");
        }
    }
    
    /**
     * 新增数据
     *
     * @param titleDTO 实体对象
     * @return 新增结果
     */
    @PostMapping(value = "/add")
    @ApiOperation("新增数据")
    @RbacPermission
    public ResultBean<Boolean> insert(@RequestBody @Validated TitlePostDTO titleDTO) {
        //处理格式转换
        Title title = TitleConverter.INSTANT.postDtoToEntity(titleDTO);
        // Updated by limengwei at 20230617，编码或名称重复校验
        checkExist(title);
        //执行数据保存
        return ResultBean.success(titleService.save(title));
    }

    /**
     * 修改数据
     *
     * @param titleDTO 实体对象
     * @return 修改结果
     */
    @PutMapping(value = "/update")
    @ApiOperation("修改数据")
    @RbacPermission
    public ResultBean<Boolean> update(@RequestBody @Validated TitlePutDTO titleDTO) {
        //处理格式转换
        Title title = TitleConverter.INSTANT.putDtoToEntity(titleDTO);
        // Updated by limengwei at 20230617，编码或名称重复校验
        checkExist(title);
        //执行数据更新
        return ResultBean.success(titleService.updateById(title));
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
        return ResultBean.success(titleService.removeByIds(ids));
    }

}

