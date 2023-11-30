package com.startdis.comm.util.auth;

import com.startdis.comm.core.enums.IdentityTypeEnum;
import com.startdis.comm.core.enums.PermissionScopeEnum;
import com.startdis.comm.core.enums.ServiceTypeEnum;
import lombok.Data;

import java.util.Set;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc CompanyAuthInfo
 */
@Data
public class CompanyAuthInfo implements AuthInfo {

    /**
     * 根据 {@link IdentityTypeEnum} 不同代表不同的身份
     * 用户id、不同端代表对应的id
     */
    private String uniqueId;

    /**
     * 用户名称 可为空
     */
    private String userName;

    /**
     * 集团租户号
     */
    private String groupTenantId;

    /**
     * 公司租户号
     */
    private String companyTenantId;

    /**
     * 鉴权token
     */
    private String authToken;

    /**
     * 权限范围
     */
    private PermissionScopeEnum permissionScope;

    /**
     * 如果具有集团范围权限时，这个值为拥有这个权限的公司id集合
     */
    private Set<String> hasPermissionCompanyIds;

    @Override
    public IdentityTypeEnum getIdentityTypeEnum() {
        return IdentityTypeEnum.COMPANY;
    }

    @Override
    public String getServiceTypeCode() {
        return ServiceTypeEnum.WEB_SERVICE.getCode();
    }
}
