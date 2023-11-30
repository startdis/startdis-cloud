package com.startdis.sys.server.service.impl;


import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.startdis.comm.core.constant.Constants;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.util.auth.AuthInfoUtils;
import com.startdis.sso.api.client.SsoApi;
import com.startdis.sys.domain.model.converter.UserConverter;
import com.startdis.sys.domain.model.dto.post.UserPostDTO;
import com.startdis.sys.domain.model.dto.put.UserPutDTO;
import com.startdis.sys.domain.model.entity.*;
import com.startdis.sys.domain.model.query.UserQuery;
import com.startdis.sys.domain.model.vo.UserInfoVO;
import com.startdis.sys.domain.model.vo.UserTokenVO;
import com.startdis.sys.domain.model.vo.UserVO;
import com.startdis.sys.infra.mapper.UserMapper;
import com.startdis.sys.server.service.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 用户表 UserService
 */
@Slf4j
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private DeptService deptService;

    @Resource
    private PostService postService;

    @Resource
    private RoleService roleService;

    @Resource
    private UserDeptService userDeptService;

    @Resource
    private UserPostService userPostService;

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private CompanyService companyService;

    @Resource
    private SsoApi ssoApi;

    /**
     * 保存用户中间表数据
     *
     * @param userDTO
     */
    @Override
    public void saveUserRelation(UserPostDTO userDTO, String userId) {
        //保存用户部门信息
        if (StringUtils.isNotBlank(userDTO.getDeptId())) {
            userDeptService.save(UserDept.builder().userId(userId).deptId(userDTO.getDeptId()).build());
        }
        //保存用户岗位信息
        if (StringUtils.isNotBlank(userDTO.getPostId())) {
            userPostService.save(UserPost.builder().userId(userId).postId(userDTO.getPostId()).build());
        }
        //保存用户角色信息
        if (StringUtils.isNotBlank(userDTO.getRoleId())) {
            userRoleService.save(UserRole.builder().userId(userId).roleId(userDTO.getRoleId()).build());
        }
    }

    /**
     * 更新用户中间表数据
     *
     * @param userDTO
     */
    @Override
    public void updateUserRelation(UserPutDTO userDTO) {
        //更新用户部门信息（先删除后新增）
        if (StringUtils.isNotBlank(userDTO.getDeptId())) {
            LambdaQueryWrapper<UserDept> userDeptQueryWrapper = Wrappers.lambdaQuery(UserDept.class).eq(UserDept::getUserId, userDTO.getId());
            userDeptService.remove(userDeptQueryWrapper);
            userDeptService.save(UserDept.builder().userId(userDTO.getId()).deptId(userDTO.getDeptId()).build());
        }
        //更新用户岗位信息（先删除后新增）
        if (StringUtils.isNotBlank(userDTO.getPostId())) {
            LambdaQueryWrapper<UserPost> userPostQueryWrapper = Wrappers.lambdaQuery(UserPost.class).eq(UserPost::getUserId, userDTO.getId());
            userPostService.remove(userPostQueryWrapper);
            userPostService.save(UserPost.builder().userId(userDTO.getId()).postId(userDTO.getPostId()).build());
        }
        //更新用户角色信息（先删除后新增）
        if (StringUtils.isNotBlank(userDTO.getRoleId())) {
            LambdaQueryWrapper<UserRole> userRoleQueryWrapper = Wrappers.lambdaQuery(UserRole.class).eq(UserRole::getUserId, userDTO.getId());
            userRoleService.remove(userRoleQueryWrapper);
            userRoleService.save(UserRole.builder().userId(userDTO.getId()).roleId(userDTO.getRoleId()).build());
        }
    }

    /**
     * 删除用户中间表数据
     *
     * @param ids
     */
    @Override
    public void deleteUserRelation(List<String> ids) {
        for (String id : ids) {
            //删除用户部门信息
            LambdaQueryWrapper<UserDept> userDeptQueryWrapper = Wrappers.lambdaQuery(UserDept.class).eq(UserDept::getUserId, id);
            userDeptService.remove(userDeptQueryWrapper);
            //删除用户岗位信息
            LambdaQueryWrapper<UserPost> userPostQueryWrapper = Wrappers.lambdaQuery(UserPost.class).eq(UserPost::getUserId, id);
            userPostService.remove(userPostQueryWrapper);
            //删除用户角色信息
            LambdaQueryWrapper<UserRole> userRoleQueryWrapper = Wrappers.lambdaQuery(UserRole.class).eq(UserRole::getUserId, id);
            userRoleService.remove(userRoleQueryWrapper);
        }
    }

    /**
     * 组装用户中间表数据
     *
     * @param userVO
     */
    @Override
    public void assembleUserVO(UserVO userVO) {
        //组装用户部门信息
        LambdaQueryWrapper<UserDept> userDeptQueryWrapper = Wrappers.lambdaQuery(UserDept.class).eq(UserDept::getUserId, userVO.getId());
        List<UserDept> userDepts = userDeptService.list(userDeptQueryWrapper);
        if (CollectionUtil.isNotEmpty(userDepts)) {
            Set<String> deptIds = userDepts.stream().map(UserDept::getDeptId).collect(Collectors.toSet());
            LambdaQueryWrapper<Dept> deptQueryWrapper = Wrappers.lambdaQuery(Dept.class).in(Dept::getId, deptIds);
            List<Dept> list = deptService.list(deptQueryWrapper);
            if (CollectionUtil.isNotEmpty(list)) {
                userVO.setDeptId(list.get(0).getId());
                userVO.setDeptCode(list.get(0).getDeptCode());
                userVO.setDeptName(list.get(0).getDeptName());
                LambdaQueryWrapper<Company> companyQueryWrapper = Wrappers.lambdaQuery(Company.class).eq(Company::getId, list.get(0).getCompanyId());
                Company company = companyService.getOne(companyQueryWrapper);
                if (company != null) {
                    userVO.setCompanyId(company.getId());
                    userVO.setCompanyName(company.getCompanyName());
                }
            }
        }
        //组装用户岗位信息
        LambdaQueryWrapper<UserPost> userPostQueryWrapper = Wrappers.lambdaQuery(UserPost.class).eq(UserPost::getUserId, userVO.getId());
        List<UserPost> userPosts = userPostService.list(userPostQueryWrapper);
        if (CollectionUtil.isNotEmpty(userPosts)) {
            Set<String> postIds = userPosts.stream().map(UserPost::getPostId).collect(Collectors.toSet());
            LambdaQueryWrapper<Post> postQueryWrapper = Wrappers.lambdaQuery(Post.class).in(Post::getId, postIds);
            List<Post> list = postService.list(postQueryWrapper);
            if (CollectionUtil.isNotEmpty(list)) {
                userVO.setPostId(list.get(0).getId());
                userVO.setPostCode(list.get(0).getPostCode());
                userVO.setPostName(list.get(0).getPostName());
            }
        }
        //组装用户角色信息
        LambdaQueryWrapper<UserRole> userRoleQueryWrapper = Wrappers.lambdaQuery(UserRole.class).eq(UserRole::getUserId, userVO.getId());
        List<UserRole> userRoles = userRoleService.list(userRoleQueryWrapper);
        if (CollectionUtil.isNotEmpty(userRoles)) {
            Set<String> roleIds = userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toSet());
            LambdaQueryWrapper<Role> roleQueryWrapper = Wrappers.lambdaQuery(Role.class).in(Role::getId, roleIds);
            List<Role> list = roleService.list(roleQueryWrapper);
            if (CollectionUtil.isNotEmpty(list)) {
                userVO.setRoleId(list.get(0).getId());
                userVO.setRoleCode(list.get(0).getRoleCode());
                userVO.setRoleName(list.get(0).getRoleName());
            }
        }
    }

    @Override
    public List<UserVO> getLeaderInChargeInPms(String companyTenantId) {
//        return userMapper.getUserInPms(companyTenantId);
        // 先查询项目管理部门
        Dept dept = deptService.getBaseMapper().selectOne(Wrappers.<Dept>lambdaQuery().eq(Dept::getDeptCode, "NT-XMGLBM"));
        if (Objects.isNull(dept)){
            return Collections.EMPTY_LIST;
        }
        // 再查询项目管理部门有哪些
        List<Dept> depts = deptService.getBaseMapper().selectList(Wrappers.<Dept>lambdaQuery().eq(Dept::getParentId, dept.getId()));
        List<String> deptIds = depts.stream().map(Dept::getId).collect(Collectors.toList());
        if (CollectionUtil.isEmpty(deptIds)){
            return Collections.EMPTY_LIST;
        }
        return userMapper.getLeaderUserByDeptInPms(deptIds);
    }
    @Override
    public List<UserVO> getCountryLeaderInChargeInPms(String companyTenantId) {
//        return userMapper.getCountryUserInPms(companyTenantId);
        // 先查询县公司分管领导部门
        Dept dept = deptService.getBaseMapper().selectOne(Wrappers.<Dept>lambdaQuery().eq(Dept::getDeptCode, "NT-GSLD"));
        if (Objects.isNull(dept)){
            return Collections.EMPTY_LIST;
        }
        List<String> deptIds = new ArrayList<>();
        deptIds.add(dept.getId());
        return userMapper.getLeaderUserByDeptInPms(deptIds);
    }

    @Override
    public UserVO getProcessApproverInPms(String userId, String type, String companyTenantId) {
        return userMapper.getProcessApproverInPms(userId, type, companyTenantId);
    }
    @Override
    public UserVO getProcessStartApproverInPms(String deptId, String type, String companyTenantId) {
        return userMapper.getProcessApproverInPms(deptId, type, companyTenantId);
    }

    @Override
    public List<UserVO> page(UserQuery userQuery) {
        List<UserVO> users = this.baseMapper.page(userQuery);
        return users;
    }

    @Override
    public User getUserInfoByUserCode(String userCode) {
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery(User.class).eq(User::getUserCode, userCode);
        User user = getOne(queryWrapper);
        return user;
    }

    @Override
    public ResultBean<Boolean> userIsAdmin() {
        Boolean bool = false;
        String authToken = AuthInfoUtils.getAuthToken();
        ResultBean<UserTokenVO> resultBean = ssoApi.getUserInfoByToken(authToken);
        if (!Constants.SUCCESS.equals(resultBean.getCode())){
            return ResultBean.success(bool);
        }
        UserTokenVO userVO = resultBean.getData();
        if (Objects.isNull(userVO)){
            return ResultBean.success(bool);
        }
        UserInfoVO userInfoVO = userVO.getUserInfoVO();
        String userCode = userInfoVO.getUserCode();
        User user = this.baseMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUserCode, userCode));
        List<UserRole> userRoles = userRoleService.getBaseMapper().selectList(Wrappers.<UserRole>lambdaQuery().eq(UserRole::getUserId, user.getId()));
        if (CollectionUtil.isEmpty(userRoles)){
            return ResultBean.success(bool);
        }
        List<String> roleIds = userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList());
        List<Role> roles = roleService.getBaseMapper().selectList(Wrappers.<Role>lambdaQuery().in(Role::getId, roleIds));
        for (Role role : roles) {
            String roleCode = role.getRoleCode();
            if (roleCode.contains("srsadmin") || roleCode.contains("srsAdmin")){
                bool = true;
                break;
            }
        }
        return ResultBean.success(bool);
    }

    @Override
    public ResultBean<UserVO> getHeadUserByDeptInPms(Map<String, String> map) {
        //查询类型 1:根据Id查 2:根据Code查
        String queryType = map.get("queryType");
        try {
            if ("1".equals(queryType)){
                //部门Id
                String deptId = map.get("deptId");
                UserVO userVO = this.baseMapper.getHeadUserByDeptInPms(deptId);
                assembleUserVO(userVO);
                return ResultBean.success(userVO);
            }else {
                String deptCode = map.get("deptCode");
                Dept dept = deptService.getBaseMapper().selectOne(Wrappers.<Dept>lambdaQuery().eq(Dept::getDeptCode,deptCode));
                if (Objects.isNull(dept)){
                    return ResultBean.error("查询部门负责人异常！" + deptCode +"部门不存在！");
                }
                String deptId = dept.getId();
                UserVO userVO = this.baseMapper.getHeadUserByDeptInPms(deptId);
                assembleUserVO(userVO);
                return ResultBean.success(userVO);
            }
        } catch (Exception e) {
            log.error("查询电商采购部门负责人异常!{}", e.getMessage());
            return ResultBean.error("查询部门负责人异常！");
        }
    }

    @Override
    public ResultBean<UserVO> getUserByIdInPms(Map<String, String> map) {
        try {
            String userId = map.get("userId");
            User user = this.baseMapper.selectById(userId);
            if (Objects.isNull(user)){
                log.error("查询电商采购用户信息异常!{}不存在", userId);
                return ResultBean.error("查询电商采购用户信息异常！");
            }
            UserVO userVO = UserConverter.INSTANT.entityToVO(user);
            assembleUserVO(userVO);
            return ResultBean.success(userVO);
        } catch (Exception e) {
            log.error("查询电商采购用户信息异常!{}", e.getMessage());
            return ResultBean.error("查询电商采购用户信息异常！");
        }
    }

    @Override
    public ResultBean<Boolean> userIsWmsAdmin() {
        Boolean bool = false;
        String authToken = AuthInfoUtils.getAuthToken();
        ResultBean<UserTokenVO> resultBean = ssoApi.getUserInfoByToken(authToken);
        if (!Constants.SUCCESS.equals(resultBean.getCode())){
            return ResultBean.success(bool);
        }
        UserTokenVO userVO = resultBean.getData();
        if (Objects.isNull(userVO)){
            return ResultBean.success(bool);
        }
        UserInfoVO userInfoVO = userVO.getUserInfoVO();
        String userCode = userInfoVO.getUserCode();
        User user = this.baseMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUserCode, userCode));
        List<UserRole> userRoles = userRoleService.getBaseMapper().selectList(Wrappers.<UserRole>lambdaQuery().eq(UserRole::getUserId, user.getId()));
        if (CollectionUtil.isEmpty(userRoles)){
            return ResultBean.success(bool);
        }
        List<String> roleIds = userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList());
        List<Role> roles = roleService.getBaseMapper().selectList(Wrappers.<Role>lambdaQuery().in(Role::getId, roleIds));
        for (Role role : roles) {
            String roleCode = role.getRoleCode();
            if (roleCode.contains("admin") || roleCode.contains("Admin")){
                bool = true;
                break;
            }
        }
        return ResultBean.success(bool);
    }

    @Override
    public ResultBean<Boolean> userIsCommonAdmin() {
        Boolean bool = false;
        String authToken = AuthInfoUtils.getAuthToken();
        ResultBean<UserTokenVO> resultBean = ssoApi.getUserInfoByToken(authToken);
        if (!Constants.SUCCESS.equals(resultBean.getCode())){
            return ResultBean.success(bool);
        }
        UserTokenVO userVO = resultBean.getData();
        if (Objects.isNull(userVO)){
            return ResultBean.success(bool);
        }
        UserInfoVO userInfoVO = userVO.getUserInfoVO();
        String userCode = userInfoVO.getUserCode();
        User user = this.baseMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUserCode, userCode));
        List<UserRole> userRoles = userRoleService.getBaseMapper().selectList(Wrappers.<UserRole>lambdaQuery().eq(UserRole::getUserId, user.getId()));
        if (CollectionUtil.isEmpty(userRoles)){
            return ResultBean.success(bool);
        }
        List<String> roleIds = userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList());
        List<Role> roles = roleService.getBaseMapper().selectList(Wrappers.<Role>lambdaQuery().in(Role::getId, roleIds));
        for (Role role : roles) {
            String roleCode = role.getRoleCode();
            if (roleCode.contains("admin") || roleCode.contains("Admin")){
                bool = true;
                break;
            }
        }
        return ResultBean.success(bool);
    }
}
