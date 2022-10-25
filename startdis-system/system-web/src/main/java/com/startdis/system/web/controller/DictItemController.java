package com.startdis.system.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.common.domain.bean.PagerBean;
import com.startdis.common.domain.bean.ResultBean;
import com.startdis.common.domain.model.PageQuery;
import com.startdis.common.util.bean.BeanCopyUtils;
import com.startdis.system.domain.model.dto.DictItemPostDTO;
import com.startdis.system.domain.model.dto.DictItemPutDTO;
import com.startdis.system.domain.model.entity.DictItem;
import com.startdis.system.domain.model.query.DictItemQuery;
import com.startdis.system.domain.model.vo.DictItemVO;
import com.startdis.system.server.service.DictItemService;
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
 * @desc 字典数据表(DictItem)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "DictItem", tags = {"字典数据表"})
@RequestMapping("dictItem")
public class DictItemController {
    
    /**
     * 服务对象
     */
    @Resource
    private DictItemService dictItemService;
    
    
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("查询单条")
    public ResultBean<DictItemVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        DictItemVO dictItemVO = new DictItemVO();
        DictItem dictItem = dictItemService.getById(id);
        BeanUtils.copyProperties(dictItem, dictItemVO);
        return ResultBean.success(dictItemVO);
    }
    
    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param dictItemQuery 实例对象
     * @return 对象列表
     */
    @GetMapping(value = "/list")
    @ApiOperation("查询所有")
    public ResultBean<List<DictItemVO>> list(DictItemQuery dictItemQuery) {
        //处理查询条件
        DictItem dictItem = new DictItem();
        BeanUtils.copyProperties(dictItemQuery, dictItem);
        //执行分页查询
        List<DictItem> listResult = dictItemService.list(new QueryWrapper<>(dictItem));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, DictItemVO.class));
    }
    
    /**
     * 分页查询所有数据
     *
     * @param pageQuery     分页对象
     * @param dictItemQuery 查询实体
     * @return 分页对象
     */
    @GetMapping(value = "/page")
    @ApiOperation("分页查询")
    public ResultBean<PagerBean<DictItemVO>> page(PageQuery pageQuery, DictItemQuery dictItemQuery) {
        //处理分页条件
        Page<DictItem> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理查询条件
        DictItem dictItem = new DictItem();
        BeanUtils.copyProperties(dictItemQuery, dictItem);
        //执行分页查询
        Page<DictItem> pageResult = dictItemService.page(page, new QueryWrapper<>(dictItem));
        PagerBean<DictItemVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), DictItemVO.class));
        return ResultBean.success(pageBean);
    }
    
    /**
     * 新增数据
     *
     * @param dictItemDTO 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation("新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated DictItemPostDTO dictItemDTO) {
        DictItem dictItem = new DictItem();
        BeanUtils.copyProperties(dictItemDTO, dictItem);
        return ResultBean.success(dictItemService.save(dictItem));
    }
    
    /**
     * 修改数据
     *
     * @param dictItemDTO 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated DictItemPutDTO dictItemDTO) {
        DictItem dictItem = new DictItem();
        BeanUtils.copyProperties(dictItemDTO, dictItem);
        return ResultBean.success(dictItemService.updateById(dictItem));
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
        return ResultBean.success(dictItemService.removeByIds(ids));
    }
    
}

