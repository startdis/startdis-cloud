package com.startdis.system.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.common.domain.bean.PagerBean;
import com.startdis.common.domain.bean.ResultBean;
import com.startdis.common.domain.model.PageQuery;
import com.startdis.common.util.bean.BeanCopyUtils;
import com.startdis.system.domain.model.dto.PostPostDTO;
import com.startdis.system.domain.model.dto.PostPutDTO;
import com.startdis.system.domain.model.entity.Post;
import com.startdis.system.domain.model.query.PostQuery;
import com.startdis.system.domain.model.vo.PostVO;
import com.startdis.system.server.service.PostService;
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
 * @desc 岗位表(Post)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "Post", tags = {"岗位表"})
@RequestMapping("post")
public class PostController {
    
    /**
     * 服务对象
     */
    @Resource
    private PostService postService;
    
    
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("查询单条")
    public ResultBean<PostVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        PostVO postVO = new PostVO();
        Post post = postService.getById(id);
        BeanUtils.copyProperties(post, postVO);
        return ResultBean.success(postVO);
    }
    
    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param postQuery 实例对象
     * @return 对象列表
     */
    @GetMapping(value = "/list")
    @ApiOperation("查询所有")
    public ResultBean<List<PostVO>> list(PostQuery postQuery) {
        //处理查询条件
        Post post = new Post();
        BeanUtils.copyProperties(postQuery, post);
        //执行分页查询
        List<Post> listResult = postService.list(new QueryWrapper<>(post));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, PostVO.class));
    }
    
    /**
     * 分页查询所有数据
     *
     * @param pageQuery 分页对象
     * @param postQuery 查询实体
     * @return 分页对象
     */
    @GetMapping(value = "/page")
    @ApiOperation("分页查询")
    public ResultBean<PagerBean<PostVO>> page(PageQuery pageQuery, PostQuery postQuery) {
        //处理分页条件
        Page<Post> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理查询条件
        Post post = new Post();
        BeanUtils.copyProperties(postQuery, post);
        //执行分页查询
        Page<Post> pageResult = postService.page(page, new QueryWrapper<>(post));
        PagerBean<PostVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), PostVO.class));
        return ResultBean.success(pageBean);
    }
    
    /**
     * 新增数据
     *
     * @param postDTO 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation("新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated PostPostDTO postDTO) {
        Post post = new Post();
        BeanUtils.copyProperties(postDTO, post);
        return ResultBean.success(postService.save(post));
    }
    
    /**
     * 修改数据
     *
     * @param postDTO 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated PostPutDTO postDTO) {
        Post post = new Post();
        BeanUtils.copyProperties(postDTO, post);
        return ResultBean.success(postService.updateById(post));
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
        return ResultBean.success(postService.removeByIds(ids));
    }
    
}

