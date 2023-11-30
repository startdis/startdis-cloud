package com.startdis.sys.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.comm.auth.annotation.RbacPermission;
import com.startdis.comm.domain.bean.PagerBean;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.domain.model.PageQuery;
import com.startdis.comm.util.bean.BeanCopyKits;
import com.startdis.sys.domain.model.converter.DictItemConverter;
import com.startdis.sys.domain.model.dto.post.DictItemPostDTO;
import com.startdis.sys.domain.model.dto.put.DictItemPutDTO;
import com.startdis.sys.domain.model.entity.DictItem;
import com.startdis.sys.domain.model.query.DictItemQuery;
import com.startdis.sys.domain.model.vo.DictItemVO;
import com.startdis.sys.server.service.DictItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
 * @email startdis@dianjiu.cc
 * @desc 字典项表(DictItem)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "DictItem", tags = {"字典项表"})
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
    @RbacPermission
    public ResultBean<DictItemVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        DictItem dictItem = dictItemService.getById(id);
        //处理格式转换
        DictItemVO dictItemVO = DictItemConverter.INSTANT.entityToVO(dictItem);
        return ResultBean.success(dictItemVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param dictItemQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @ApiOperation("查询所有")
    @RbacPermission
    public ResultBean<List<DictItemVO>> list(@RequestBody DictItemQuery dictItemQuery) {
        //处理格式转换
        DictItem dictItem = DictItemConverter.INSTANT.queryToEntity(dictItemQuery);
        //执行分页查询
        List<DictItem> listResult = dictItemService.list(new QueryWrapper<>(dictItem));
        return ResultBean.success(BeanCopyKits.coverList(listResult, DictItemVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery     分页对象
     * @param dictItemQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @ApiOperation("分页查询")
    @RbacPermission
    public ResultBean<PagerBean<DictItemVO>> page(PageQuery pageQuery, DictItemQuery dictItemQuery) {
        //处理分页条件
        Page<DictItem> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        DictItem dictItem = DictItemConverter.INSTANT.queryToEntity(dictItemQuery);
        //执行分页查询
        Page<DictItem> pageResult = dictItemService.page(page, new QueryWrapper<>(dictItem));
        PagerBean<DictItemVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyKits.coverList(pageResult.getRecords(), DictItemVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param dictItemDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @ApiOperation("新增数据")
    @RbacPermission
    public ResultBean<Boolean> insert(@RequestBody @Validated DictItemPostDTO dictItemDTO) {
        //处理格式转换
        DictItem dictItem = DictItemConverter.INSTANT.postDtoToEntity(dictItemDTO);
        //执行数据保存
        return ResultBean.success(dictItemService.save(dictItem));
    }

    /**
     * 修改数据
     *
     * @param dictItemDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @ApiOperation("修改数据")
    @RbacPermission
    public ResultBean<Boolean> update(@RequestBody @Validated DictItemPutDTO dictItemDTO) {
        //处理格式转换
        DictItem dictItem = DictItemConverter.INSTANT.putDtoToEntity(dictItemDTO);
        //执行数据更新
        return ResultBean.success(dictItemService.updateById(dictItem));
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
        return ResultBean.success(dictItemService.removeByIds(ids));
    }

}

