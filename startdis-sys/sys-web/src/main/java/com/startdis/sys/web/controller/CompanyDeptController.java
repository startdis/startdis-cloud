package com.startdis.sys.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.comm.auth.annotation.RbacPermission;
import com.startdis.comm.domain.bean.PagerBean;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.domain.model.PageQuery;
import com.startdis.comm.util.bean.BeanCopyKits;
import com.startdis.sys.domain.model.converter.CompanyDeptConverter;
import com.startdis.sys.domain.model.dto.post.CompanyDeptPostDTO;
import com.startdis.sys.domain.model.dto.put.CompanyDeptPutDTO;
import com.startdis.sys.domain.model.entity.CompanyDept;
import com.startdis.sys.domain.model.query.CompanyDeptQuery;
import com.startdis.sys.domain.model.vo.CompanyDeptVO;
import com.startdis.sys.server.service.CompanyDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 公司与部门关系表(CompanyDept)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "CompanyDept", tags = {"公司与部门关系表"})
@RequestMapping("companyDept")
public class CompanyDeptController {
    /**
     * 服务对象
     */
    @Resource
    private CompanyDeptService companyDeptService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("查询单条")
    @RbacPermission
    public ResultBean<CompanyDeptVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        CompanyDept companyDept = companyDeptService.getById(id);
        //处理格式转换
        CompanyDeptVO companyDeptVO = CompanyDeptConverter.INSTANT.entityToVO(companyDept);
        return ResultBean.success(companyDeptVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param companyDeptQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @ApiOperation("查询所有")
    @RbacPermission
    public ResultBean<List<CompanyDeptVO>> list(@RequestBody CompanyDeptQuery companyDeptQuery) {
        //处理格式转换
        CompanyDept companyDept = CompanyDeptConverter.INSTANT.queryToEntity(companyDeptQuery);
        //执行分页查询
        List<CompanyDept> listResult = companyDeptService.list(new QueryWrapper<>(companyDept));
        return ResultBean.success(BeanCopyKits.coverList(listResult, CompanyDeptVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery        分页对象
     * @param companyDeptQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @ApiOperation("分页查询")
    @RbacPermission
    public ResultBean<PagerBean<CompanyDeptVO>> page(PageQuery pageQuery, CompanyDeptQuery companyDeptQuery) {
        //处理分页条件
        Page<CompanyDept> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        CompanyDept companyDept = CompanyDeptConverter.INSTANT.queryToEntity(companyDeptQuery);
        //执行分页查询
        Page<CompanyDept> pageResult = companyDeptService.page(page, new QueryWrapper<>(companyDept));
        PagerBean<CompanyDeptVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyKits.coverList(pageResult.getRecords(), CompanyDeptVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param companyDeptDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @ApiOperation("新增数据")
    @RbacPermission
    public ResultBean<Boolean> insert(@RequestBody @Validated CompanyDeptPostDTO companyDeptDTO) {
        //处理格式转换
        CompanyDept companyDept = CompanyDeptConverter.INSTANT.postDtoToEntity(companyDeptDTO);
        //执行数据保存
        return ResultBean.success(companyDeptService.save(companyDept));
    }

    /**
     * 修改数据
     *
     * @param companyDeptDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @ApiOperation("修改数据")
    @RbacPermission
    public ResultBean<Boolean> update(@RequestBody @Validated CompanyDeptPutDTO companyDeptDTO) {
        //处理格式转换
        CompanyDept companyDept = CompanyDeptConverter.INSTANT.putDtoToEntity(companyDeptDTO);
        //执行数据更新
        return ResultBean.success(companyDeptService.updateById(companyDept));
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
        return ResultBean.success(companyDeptService.removeByIds(ids));
    }

}

