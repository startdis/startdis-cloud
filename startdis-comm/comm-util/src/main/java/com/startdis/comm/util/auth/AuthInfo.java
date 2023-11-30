package com.startdis.comm.util.auth;


import com.startdis.comm.core.enums.IdentityTypeEnum;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc AuthInfo
 */
public interface AuthInfo {

    /**
     * 用户唯一标识
     */
    String getUniqueId();

    /**
     * 集团租户号
     */
    String getGroupTenantId();

    /**
     * 公司租户号
     */
    String getCompanyTenantId();

    /**
     * 身份类型
     */
    IdentityTypeEnum getIdentityTypeEnum();

    /**
     * 服务类型
     */
    String getServiceTypeCode();

    String getAuthToken();
}
