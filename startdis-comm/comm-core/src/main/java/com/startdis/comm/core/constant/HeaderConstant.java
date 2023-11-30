package com.startdis.comm.core.constant;

import com.startdis.comm.core.enums.IdentityTypeEnum;
import com.startdis.comm.core.enums.PermissionScopeEnum;
import com.startdis.comm.core.enums.ServiceTypeEnum;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 全局请求头常量
 */
public class HeaderConstant {
    
    /**
     * 集团租户id
     */
    public static final String CONTENT_TYPE = "Content-Type";
    
    /**
     * 集团租户id
     */
    public static final String X_GROUP_TENANT_ID = "X-GROUP-TENANT-ID";
    
    /**
     * 公司租户id
     */
    public static final String X_COMPANY_TENANT_ID = "X-COMPANY-TENANT-ID";
    
    
    /**
     * 当前登陆人唯一id
     */
    public static final String X_UNIQUE_ID = "X-UNIQUE-ID";
    
    /**
     * 用户设备唯一标识
     */
    public static final String X_DISTINCT_ID = "X-DISTINCT-ID";
    
    /**
     * 登录token
     */
    public static final String X_ACCESS_TOKEN = "X-ACCESS-TOKEN";
    
    /**
     * 服务类型
     *
     * @see ServiceTypeEnum
     */
    public static final String X_SERVICE_TYPE = "X-SERVICE-TYPE";
    
    /**
     * 身份类型 公司用户 访客用户 启迪用户
     *
     * @see IdentityTypeEnum
     */
    public static final String X_IDENTITY_TYPE = "X-IDENTITY-TYPE";
    
    
    /**
     * 此请求头为用户请求过来的为集团还是公司权限
     *
     * @see PermissionScopeEnum
     */
    public static final String X_PERMISSION_SCOPE = "X-PERMISSION-SCOPE";
    
    /**
     * 当权限类型为集团类型时，此请求头包含的为这个用户的所有店铺id {@link  PermissionScopeEnum}
     */
    public static final String X_COMPANY_IDS = "X-COMPANY-IDS";
    
}
