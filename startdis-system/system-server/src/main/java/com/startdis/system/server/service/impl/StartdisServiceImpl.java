package com.startdis.system.server.service.impl;

import com.startdis.common.util.config.SnowflakeConfig;
import com.startdis.system.domain.model.dto.post.RegisterDTO;
import com.startdis.system.domain.model.entity.Company;
import com.startdis.system.domain.model.entity.CompanyPost;
import com.startdis.system.domain.model.entity.Post;
import com.startdis.system.domain.model.entity.Role;
import com.startdis.system.domain.model.entity.Tenant;
import com.startdis.system.domain.model.entity.UserPost;
import com.startdis.system.domain.model.entity.UserRole;
import com.startdis.system.domain.model.entity.Users;
import com.startdis.system.server.service.CompanyPostService;
import com.startdis.system.server.service.CompanyService;
import com.startdis.system.server.service.PostService;
import com.startdis.system.server.service.RoleService;
import com.startdis.system.server.service.StartdisService;
import com.startdis.system.server.service.TenantService;
import com.startdis.system.server.service.UserPostService;
import com.startdis.system.server.service.UserRoleService;
import com.startdis.system.server.service.UsersService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * 启迪 服务实现类
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Service
public class StartdisServiceImpl implements StartdisService {
    
    /**
     * 雪花ID生成
     */
    @Resource
    private SnowflakeConfig snowflakeConfig;
    
    @Resource
    private CompanyService companyService;
    
    @Resource
    private TenantService tenantService;
    
    @Resource
    private PostService postService;
    
    @Resource
    private CompanyPostService companyPostService;
    
    @Resource
    private UsersService usersService;
    
    @Resource
    private RoleService roleService;
    
    @Resource
    private UserRoleService userRoleService;
    
    @Resource
    private UserPostService userPostService;
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String register(RegisterDTO registerDTO) {
        // 保存公司信息
        String companyId = snowflakeConfig.nextIdStr();
        Company company = new Company();
        company.setId(companyId);
        company.setTenantId(companyId);
        BeanUtils.copyProperties(registerDTO.getCompanyPostDTO(), company);
        companyService.save(company);
        //保存租户信息
        Tenant tenant = new Tenant();
        tenant.setId(companyId);
        tenant.setTenantCode(company.getCompanyCode());
        tenant.setTenantId(companyId);
        tenant.setTenantName(company.getCompanyName());
        tenantService.save(tenant);
        //保存岗位信息
        String postId = snowflakeConfig.nextIdStr();
        Post post = new Post();
        post.setId(postId);
        post.setPostCode("Legal Person");
        post.setPostName("公司法人");
        post.setPostRemark("被法律承认享有权利和义务的公司负责人");
        post.setTenantId(companyId);
        postService.save(post);
        //保存公司岗位信息
        CompanyPost companyPost = new CompanyPost();
        companyPost.setCompanyId(companyId);
        companyPost.setPostId(postId);
        companyPost.setTenantId(companyId);
        companyPostService.save(companyPost);
        //保存用户信息
        Users users = new Users();
        String userId = snowflakeConfig.nextIdStr();
        BeanUtils.copyProperties(registerDTO.getUsersPostDTO(), users);
        users.setId(userId);
        users.setTenantId(companyId);
        usersService.save(users);
        //保存角色信息
        Role role = new Role();
        String roleId = snowflakeConfig.nextIdStr();
        role.setId(roleId);
        role.setRoleCode("Super Admin");
        role.setRoleName("超级管理员");
        role.setRoleRemark("超级管理员是注册公司系统时自动生成的第一个用户,具有公司系统的最高权限。");
        role.setRoleSort(1);
        role.setRoleScope(1);
        role.setTenantId(companyId);
        roleService.save(role);
        //保存用户角色信息
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        userRole.setTenantId(companyId);
        userRoleService.save(userRole);
        //保存用户岗位信息
        UserPost userPost = new UserPost();
        userPost.setUserId(userId);
        userPost.setPostId(postId);
        userPost.setTenantId(companyId);
        userPostService.save(userPost);
        return "感谢您使用启迪数字化SaaS平台！";
    }
}
