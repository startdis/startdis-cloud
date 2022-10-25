package com.startdis.system.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.common.domain.bean.PagerBean;
import com.startdis.common.domain.bean.ResultBean;
import com.startdis.common.domain.model.PageQuery;
import com.startdis.common.util.bean.BeanCopyUtils;
import com.startdis.system.domain.model.dto.DictTypePostDTO;
import com.startdis.system.domain.model.dto.DictTypePutDTO;
import com.startdis.system.domain.model.entity.DictType;
import com.startdis.system.domain.model.query.DictTypeQuery;
import com.startdis.system.domain.model.vo.DictTypeVO;
import com.startdis.system.server.service.DictTypeService;
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
 * @desc 字典类型表(DictType)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "DictType", tags = {"字典类型表"})
@RequestMapping("dictType")
public class DictTypeController {
    
    /**
     * 服务对象
     */
    @Resource
    private DictTypeService dictTypeService;
    
    
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("查询单条")
    public ResultBean<DictTypeVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        DictTypeVO dictTypeVO = new DictTypeVO();
        DictType dictType = dictTypeService.getById(id);
        BeanUtils.copyProperties(dictType, dictTypeVO);
        return ResultBean.success(dictTypeVO);
    }
    
    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param dictTypeQuery 实例对象
     * @return 对象列表
     */
    @GetMapping(value = "/list")
    @ApiOperation("查询所有")
    public ResultBean<List<DictTypeVO>> list(DictTypeQuery dictTypeQuery) {
        //处理查询条件
        DictType dictType = new DictType();
        BeanUtils.copyProperties(dictTypeQuery, dictType);
        //执行分页查询
        List<DictType> listResult = dictTypeService.list(new QueryWrapper<>(dictType));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, DictTypeVO.class));
    }
    
    /**
     * 分页查询所有数据
     *
     * @param pageQuery     分页对象
     * @param dictTypeQuery 查询实体
     * @return 分页对象
     */
    @GetMapping(value = "/page")
    @ApiOperation("分页查询")
    public ResultBean<PagerBean<DictTypeVO>> page(PageQuery pageQuery, DictTypeQuery dictTypeQuery) {
        //处理分页条件
        Page<DictType> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理查询条件
        DictType dictType = new DictType();
        BeanUtils.copyProperties(dictTypeQuery, dictType);
        //执行分页查询
        Page<DictType> pageResult = dictTypeService.page(page, new QueryWrapper<>(dictType));
        PagerBean<DictTypeVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), DictTypeVO.class));
        return ResultBean.success(pageBean);
    }
    
    /**
     * 新增数据
     *
     * @param dictTypeDTO 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation("新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated DictTypePostDTO dictTypeDTO) {
        DictType dictType = new DictType();
        BeanUtils.copyProperties(dictTypeDTO, dictType);
        return ResultBean.success(dictTypeService.save(dictType));
    }
    
    /**
     * 修改数据
     *
     * @param dictTypeDTO 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated DictTypePutDTO dictTypeDTO) {
        DictType dictType = new DictType();
        BeanUtils.copyProperties(dictTypeDTO, dictType);
        return ResultBean.success(dictTypeService.updateById(dictType));
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
        return ResultBean.success(dictTypeService.removeByIds(ids));
    }
    
}

