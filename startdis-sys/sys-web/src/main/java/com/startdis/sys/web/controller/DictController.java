package com.startdis.sys.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.comm.auth.annotation.RbacPermission;
import com.startdis.comm.domain.bean.PagerBean;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.domain.model.PageQuery;
import com.startdis.comm.util.bean.BeanCopyKits;
import com.startdis.sys.domain.model.converter.DictConverter;
import com.startdis.sys.domain.model.dto.post.DictPostDTO;
import com.startdis.sys.domain.model.dto.put.DictPutDTO;
import com.startdis.sys.domain.model.entity.Dict;
import com.startdis.sys.domain.model.query.DictQuery;
import com.startdis.sys.domain.model.vo.DictVO;
import com.startdis.sys.server.service.DictService;
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
 * @desc 字典主表(Dict)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "Dict", tags = {"字典主表"})
@RequestMapping("dict")
public class DictController {

    /**
     * 服务对象
     */
    @Resource
    private DictService dictService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("查询单条")
    @RbacPermission
    public ResultBean<DictVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        Dict dict = dictService.getById(id);
        //处理格式转换
        DictVO dictVO = DictConverter.INSTANT.entityToVO(dict);
        return ResultBean.success(dictVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param dictQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @ApiOperation("查询所有")
    @RbacPermission
    public ResultBean<List<DictVO>> list(@RequestBody DictQuery dictQuery) {
        //处理格式转换
        Dict dict = DictConverter.INSTANT.queryToEntity(dictQuery);
        //执行分页查询
        List<Dict> listResult = dictService.list(new QueryWrapper<>(dict));
        return ResultBean.success(BeanCopyKits.coverList(listResult, DictVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery 分页对象
     * @param dictQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @ApiOperation("分页查询")
    @RbacPermission
    public ResultBean<PagerBean<DictVO>> page(PageQuery pageQuery, DictQuery dictQuery) {
        //处理分页条件
        Page<Dict> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        Dict dict = DictConverter.INSTANT.queryToEntity(dictQuery);
        //执行分页查询
        Page<Dict> pageResult = dictService.page(page, new QueryWrapper<>(dict));
        PagerBean<DictVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(), pageResult.getSize(),
                BeanCopyKits.coverList(pageResult.getRecords(), DictVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param dictDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @ApiOperation("新增数据")
    @RbacPermission
    public ResultBean<Boolean> insert(@RequestBody @Validated DictPostDTO dictDTO) {
        //处理格式转换
        Dict dict = DictConverter.INSTANT.postDtoToEntity(dictDTO);
        //执行数据保存
        return ResultBean.success(dictService.save(dict));
    }

    /**
     * 修改数据
     *
     * @param dictDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @ApiOperation("修改数据")
    @RbacPermission
    public ResultBean<Boolean> update(@RequestBody @Validated DictPutDTO dictDTO) {
        //处理格式转换
        Dict dict = DictConverter.INSTANT.putDtoToEntity(dictDTO);
        //执行数据更新
        return ResultBean.success(dictService.updateById(dict));
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
        return ResultBean.success(dictService.removeByIds(ids));
    }

}

