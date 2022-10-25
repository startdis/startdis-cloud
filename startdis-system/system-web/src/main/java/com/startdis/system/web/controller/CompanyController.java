package com.startdis.system.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.common.domain.bean.PagerBean;
import com.startdis.common.domain.bean.ResultBean;
import com.startdis.common.domain.model.PageQuery;
import com.startdis.common.util.bean.BeanCopyUtils;
import com.startdis.system.domain.model.dto.CompanyPostDTO;
import com.startdis.system.domain.model.dto.CompanyPutDTO;
import com.startdis.system.domain.model.entity.Company;
import com.startdis.system.domain.model.query.CompanyQuery;
import com.startdis.system.domain.model.vo.CompanyVO;
import com.startdis.system.server.service.CompanyService;
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
 * @desc 公司表(Company)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "Company", tags = {"公司表"})
@RequestMapping("company")
public class CompanyController {
    
    /**
     * 服务对象
     */
    @Resource
    private CompanyService companyService;
    
    
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("查询单条")
    public ResultBean<CompanyVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        CompanyVO companyVO = new CompanyVO();
        Company company = companyService.getById(id);
        BeanUtils.copyProperties(company, companyVO);
        return ResultBean.success(companyVO);
    }
    
    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param companyQuery 实例对象
     * @return 对象列表
     */
    @GetMapping(value = "/list")
    @ApiOperation("查询所有")
    public ResultBean<List<CompanyVO>> list(CompanyQuery companyQuery) {
        //处理查询条件
        Company company = new Company();
        BeanUtils.copyProperties(companyQuery, company);
        //执行分页查询
        List<Company> listResult = companyService.list(new QueryWrapper<>(company));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, CompanyVO.class));
    }
    
    /**
     * 分页查询所有数据
     *
     * @param pageQuery    分页对象
     * @param companyQuery 查询实体
     * @return 分页对象
     */
    @GetMapping(value = "/page")
    @ApiOperation("分页查询")
    public ResultBean<PagerBean<CompanyVO>> page(PageQuery pageQuery, CompanyQuery companyQuery) {
        //处理分页条件
        Page<Company> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理查询条件
        Company company = new Company();
        BeanUtils.copyProperties(companyQuery, company);
        //执行分页查询
        Page<Company> pageResult = companyService.page(page, new QueryWrapper<>(company));
        PagerBean<CompanyVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), CompanyVO.class));
        return ResultBean.success(pageBean);
    }
    
    /**
     * 新增数据
     *
     * @param companyDTO 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation("新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated CompanyPostDTO companyDTO) {
        Company company = new Company();
        BeanUtils.copyProperties(companyDTO, company);
        return ResultBean.success(companyService.save(company));
    }
    
    /**
     * 修改数据
     *
     * @param companyDTO 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated CompanyPutDTO companyDTO) {
        Company company = new Company();
        BeanUtils.copyProperties(companyDTO, company);
        return ResultBean.success(companyService.updateById(company));
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
        return ResultBean.success(companyService.removeByIds(ids));
    }
    
}

