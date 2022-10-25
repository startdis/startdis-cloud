package com.startdis.system.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.common.domain.bean.PagerBean;
import com.startdis.common.domain.bean.ResultBean;
import com.startdis.common.domain.model.PageQuery;
import com.startdis.common.util.bean.BeanCopyUtils;
import com.startdis.system.domain.model.dto.SocialUserBindPostDTO;
import com.startdis.system.domain.model.dto.SocialUserBindPutDTO;
import com.startdis.system.domain.model.entity.SocialUserBind;
import com.startdis.system.domain.model.query.SocialUserBindQuery;
import com.startdis.system.domain.model.vo.SocialUserBindVO;
import com.startdis.system.server.service.SocialUserBindService;
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
 * @desc 社交用户绑定表(SocialUserBind)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "SocialUserBind", tags = {"社交用户绑定表"})
@RequestMapping("socialUserBind")
public class SocialUserBindController {
    
    /**
     * 服务对象
     */
    @Resource
    private SocialUserBindService socialUserBindService;
    
    
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("查询单条")
    public ResultBean<SocialUserBindVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        SocialUserBindVO socialUserBindVO = new SocialUserBindVO();
        SocialUserBind socialUserBind = socialUserBindService.getById(id);
        BeanUtils.copyProperties(socialUserBind, socialUserBindVO);
        return ResultBean.success(socialUserBindVO);
    }
    
    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param socialUserBindQuery 实例对象
     * @return 对象列表
     */
    @GetMapping(value = "/list")
    @ApiOperation("查询所有")
    public ResultBean<List<SocialUserBindVO>> list(SocialUserBindQuery socialUserBindQuery) {
        //处理查询条件
        SocialUserBind socialUserBind = new SocialUserBind();
        BeanUtils.copyProperties(socialUserBindQuery, socialUserBind);
        //执行分页查询
        List<SocialUserBind> listResult = socialUserBindService.list(new QueryWrapper<>(socialUserBind));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, SocialUserBindVO.class));
    }
    
    /**
     * 分页查询所有数据
     *
     * @param pageQuery           分页对象
     * @param socialUserBindQuery 查询实体
     * @return 分页对象
     */
    @GetMapping(value = "/page")
    @ApiOperation("分页查询")
    public ResultBean<PagerBean<SocialUserBindVO>> page(PageQuery pageQuery, SocialUserBindQuery socialUserBindQuery) {
        //处理分页条件
        Page<SocialUserBind> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理查询条件
        SocialUserBind socialUserBind = new SocialUserBind();
        BeanUtils.copyProperties(socialUserBindQuery, socialUserBind);
        //执行分页查询
        Page<SocialUserBind> pageResult = socialUserBindService.page(page, new QueryWrapper<>(socialUserBind));
        PagerBean<SocialUserBindVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), SocialUserBindVO.class));
        return ResultBean.success(pageBean);
    }
    
    /**
     * 新增数据
     *
     * @param socialUserBindDTO 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation("新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated SocialUserBindPostDTO socialUserBindDTO) {
        SocialUserBind socialUserBind = new SocialUserBind();
        BeanUtils.copyProperties(socialUserBindDTO, socialUserBind);
        return ResultBean.success(socialUserBindService.save(socialUserBind));
    }
    
    /**
     * 修改数据
     *
     * @param socialUserBindDTO 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated SocialUserBindPutDTO socialUserBindDTO) {
        SocialUserBind socialUserBind = new SocialUserBind();
        BeanUtils.copyProperties(socialUserBindDTO, socialUserBind);
        return ResultBean.success(socialUserBindService.updateById(socialUserBind));
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
        return ResultBean.success(socialUserBindService.removeByIds(ids));
    }
    
}

