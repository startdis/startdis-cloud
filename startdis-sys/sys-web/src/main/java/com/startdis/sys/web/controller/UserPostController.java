package com.startdis.sys.web.controller;


import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.comm.auth.annotation.RbacPermission;
import com.startdis.comm.domain.bean.PagerBean;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.domain.model.PageQuery;
import com.startdis.comm.exception.custom.BusinessException;
import com.startdis.comm.util.bean.BeanCopyKits;
import com.startdis.comm.util.string.StringKits;
import com.startdis.sys.domain.model.dto.post.UserPostAuthUserDTO;
import com.startdis.sys.domain.model.entity.User;
import com.startdis.sys.domain.model.entity.UserPost;
import com.startdis.sys.domain.model.query.UserPostAuthUserQuery;
import com.startdis.sys.domain.model.vo.UserVO;
import com.startdis.sys.server.service.UserPostService;
import com.startdis.sys.server.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 用户岗位表(UserPost)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "UserPost", tags = {"用户岗位表"})
@RequestMapping("userPost")
public class UserPostController {
    
    /**
     * 服务对象
     */
    @Resource
    private UserPostService userPostService;
    
    @Resource
    private UserService userService;
    
    
    /**
     * 批量授权
     *
     * @param userPostDTO 实体对象
     * @return 批量授权结果
     */
    @PostMapping(value = "/authUser")
    @ApiOperation("批量授权用户")
    @RbacPermission
    public ResultBean<Boolean> auth(@RequestBody @Validated UserPostAuthUserDTO userPostDTO) {
        //新增授权
        List<UserPost> list = new ArrayList<>();
        for (String userId : userPostDTO.getUserIds()) {
            UserPost build = UserPost.builder().userId(userId).postId(userPostDTO.getPostId()).build();
            list.add(build);
        }
        return ResultBean.success(userPostService.saveBatch(list));
    }
    
    /**
     * 批量取消授权
     *
     * @param userPostDTO 实体对象
     * @return 批量取消授权结果
     */
    @PutMapping(value = "/delAuthUser")
    @ApiOperation("批量取消授权用户")
    @RbacPermission
    public ResultBean<Boolean> delAuth(@RequestBody @Validated UserPostAuthUserDTO userPostDTO) {
        //删除授权
        LambdaQueryWrapper<UserPost> queryWrapper = Wrappers.lambdaQuery(UserPost.class).eq(UserPost::getPostId, userPostDTO.getPostId())
                .in(UserPost::getUserId, userPostDTO.getUserIds());
        return ResultBean.success(userPostService.remove(queryWrapper));
    }
    
    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param userPostQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/listAuthUser")
    @ApiOperation("查询所有岗位授权用户")
    @RbacPermission
    public ResultBean<List<UserVO>> listAuthUser(UserPostAuthUserQuery userPostQuery) {
        List<UserVO> userVOS = null;
        if (StringKits.isEmpty(userPostQuery.getAuthStatus()) || StringKits.isEmpty(userPostQuery.getPostId())) {
            throw new BusinessException("40001", "授权状态或岗位信息不能为空！");
        }
        //查询已授权的用户信息
        if ("1".equals(userPostQuery.getAuthStatus())) {
            //查中间表，查询出岗位已授权的用户
            LambdaQueryWrapper<UserPost> userPostQueryWrapper =
                    Wrappers.lambdaQuery(UserPost.class).eq(UserPost::getPostId, userPostQuery.getPostId());
            List<UserPost> userPosts = userPostService.list(userPostQueryWrapper);
            //查用户表,查询出用户的详情信息表
            if (CollectionUtil.isNotEmpty(userPosts)) {
                Set<String> userIds = userPosts.stream().map(UserPost::getUserId).collect(Collectors.toSet());
                LambdaQueryWrapper<User> userQueryWrapper = Wrappers.lambdaQuery(User.class).in(User::getId, userIds);
                if(StringKits.isNotEmpty(userPostQuery.getUserCode())){
                    userQueryWrapper.eq(User::getUserCode, userPostQuery.getUserCode());
                }
                if(StringKits.isNotEmpty(userPostQuery.getUserName())){
                    userQueryWrapper.like(User::getUserName, userPostQuery.getUserName());
                }
                userVOS = BeanCopyKits.coverList(userService.list(userQueryWrapper), UserVO.class);
                //组装用户中间表信息
                for (UserVO userVO : userVOS) {
                    userService.assembleUserVO(userVO);
                }
            }
        }
        //查询未授权的用户信息
        if ("0".equals(userPostQuery.getAuthStatus())) {
            //查中间表，查询出岗位已授权的用户
            LambdaQueryWrapper<UserPost> userPostQueryWrapper =
                    Wrappers.lambdaQuery(UserPost.class).eq(UserPost::getPostId, userPostQuery.getPostId());
            List<UserPost> userPosts = userPostService.list(userPostQueryWrapper);
            //如果这个岗位还没有授权给任何用户，则返回所有的用户
            if (CollectionUtil.isEmpty(userPosts)) {
                return ResultBean.success(BeanCopyKits.coverList(userService.list(), UserVO.class));
            }
            //查用户表,查询出用户的详情信息表
            //1、筛选出用户信息
            //2、筛选出这个公司的用户信息
            //3、筛选出这个岗位没有授权的用户信息
            Set<String> userIds = userPosts.stream().map(UserPost::getUserId).collect(Collectors.toSet());
            LambdaQueryWrapper<User> userQueryWrapper = Wrappers.lambdaQuery(User.class).notIn(User::getId, userIds);
            if(StringKits.isNotEmpty(userPostQuery.getUserCode())){
                userQueryWrapper.eq(User::getUserCode, userPostQuery.getUserCode());
            }
            if(StringKits.isNotEmpty(userPostQuery.getUserName())){
                userQueryWrapper.like(User::getUserName, userPostQuery.getUserName());
            }
            userVOS = BeanCopyKits.coverList(userService.list(userQueryWrapper), UserVO.class);
            //组装用户中间表信息
            for (UserVO userVO : userVOS) {
                userService.assembleUserVO(userVO);
            }
        }
        return ResultBean.success(userVOS);
    }
    
    /**
     * 分页查询所有数据
     *
     * @param pageQuery     分页对象
     * @param userPostQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/pageAuthUser")
    @ApiOperation("分页查询岗位授权用户")
    @RbacPermission
    public ResultBean<PagerBean<UserVO>> pageAuthUser(PageQuery pageQuery, UserPostAuthUserQuery userPostQuery) {
        PagerBean<UserVO> pageBean = null;
        //处理分页条件
        Page<User> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        if (StringKits.isEmpty(userPostQuery.getAuthStatus()) || StringKits.isEmpty(userPostQuery.getPostId())) {
            throw new BusinessException("40001", "授权状态或岗位信息不能为空！");
        }
        //查询已授权的用户信息
        if ("1".equals(userPostQuery.getAuthStatus())) {
            //查中间表，查询出岗位已授权的用户信息
            LambdaQueryWrapper<UserPost> userPostQueryWrapper =
                    Wrappers.lambdaQuery(UserPost.class).eq(UserPost::getPostId, userPostQuery.getPostId());
            List<UserPost> userPosts = userPostService.list(userPostQueryWrapper);
            //查用户表,查询出用户的详情信息表
            if (CollectionUtil.isNotEmpty(userPosts)) {
                Set<String> userIds = userPosts.stream().map(UserPost::getUserId).collect(Collectors.toSet());
                LambdaQueryWrapper<User> userQueryWrapper = Wrappers.lambdaQuery(User.class).in(User::getId, userIds);
                if(StringKits.isNotEmpty(userPostQuery.getUserCode())){
                    userQueryWrapper.eq(User::getUserCode, userPostQuery.getUserCode());
                }
                if(StringKits.isNotEmpty(userPostQuery.getUserName())){
                    userQueryWrapper.like(User::getUserName, userPostQuery.getUserName());
                }
                Page<User> pageResult = userService.page(page, userQueryWrapper);
                List<UserVO> userVOS = BeanCopyKits.coverList(pageResult.getRecords(), UserVO.class);
                //组装用户中间表信息
                for (UserVO userVO : userVOS) {
                    userService.assembleUserVO(userVO);
                }
                pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(), pageResult.getSize(),userVOS);
            }
        }
        //查询未授权的用户信息
        if ("0".equals(userPostQuery.getAuthStatus())) {
            //查中间表，查询出岗位已授权的用户信息
            LambdaQueryWrapper<UserPost> userPostQueryWrapper =
                    Wrappers.lambdaQuery(UserPost.class).eq(UserPost::getPostId, userPostQuery.getPostId());
            List<UserPost> userPosts = userPostService.list(userPostQueryWrapper);
            //如果这个岗位还没有授权给任何用户，则返回所有的用户
            if (CollectionUtil.isEmpty(userPosts)) {
                Page<User> pageResult = userService.page(page);
                return ResultBean.success(new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(), pageResult.getSize(),
                        BeanCopyKits.coverList(pageResult.getRecords(), UserVO.class)));
            }
            //查岗位表,查询出用户的详情信息表
            //1、筛选出用户信息
            //2、筛选出这个公司的用户信息
            //3、筛选出这个岗位没有授权的用户信息
            if (CollectionUtil.isNotEmpty(userPosts)) {
                Set<String> userIds = userPosts.stream().map(UserPost::getUserId).collect(Collectors.toSet());
                LambdaQueryWrapper<User> userQueryWrapper = Wrappers.lambdaQuery(User.class).notIn(User::getId, userIds);
                if(StringKits.isNotEmpty(userPostQuery.getUserCode())){
                    userQueryWrapper.eq(User::getUserCode, userPostQuery.getUserCode());
                }
                if(StringKits.isNotEmpty(userPostQuery.getUserName())){
                    userQueryWrapper.like(User::getUserName, userPostQuery.getUserName());
                }
                Page<User> pageResult = userService.page(page, userQueryWrapper);
                List<UserVO> userVOS = BeanCopyKits.coverList(pageResult.getRecords(), UserVO.class);
                //组装用户中间表信息
                for (UserVO userVO : userVOS) {
                    userService.assembleUserVO(userVO);
                }
                pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(), pageResult.getSize(),userVOS);
            }
        }
        return ResultBean.success(pageBean);
    }
}

