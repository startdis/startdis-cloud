package com.startdis.comm.web.auth;


import com.google.common.collect.Sets;
import com.startdis.comm.core.constant.HeaderConstant;
import com.startdis.comm.core.enums.PermissionScopeEnum;
import com.startdis.comm.util.auth.AuthInfo;
import com.startdis.comm.util.auth.CompanyAuthInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc B端集团公司验证类
 */
@Component
public class WebAuthHandler implements AuthHandler {

    @Override
    public AuthInfo getAuthInfo(HttpServletRequest request, HttpServletResponse response) {
        String groupTenantId = request.getHeader(HeaderConstant.X_GROUP_TENANT_ID);
        String companyTenantId = request.getHeader(HeaderConstant.X_COMPANY_TENANT_ID);
        String userId = request.getHeader(HeaderConstant.X_UNIQUE_ID);
        Set<String> companyIds = Sets.newHashSet(request.getHeaders(HeaderConstant.X_COMPANY_IDS).asIterator());
        String permissionScopeCode = request.getHeader(HeaderConstant.X_PERMISSION_SCOPE);
        String authToken = request.getHeader(HeaderConstant.X_ACCESS_TOKEN);
        PermissionScopeEnum permissionScopeEnum = StringUtils.isBlank(permissionScopeCode)?null:
            PermissionScopeEnum.codeOf(permissionScopeCode);
        CompanyAuthInfo companyAuthInfo = new CompanyAuthInfo();
        companyAuthInfo.setGroupTenantId(groupTenantId);
        companyAuthInfo.setCompanyTenantId(companyTenantId);
        companyAuthInfo.setPermissionScope(permissionScopeEnum);
        companyAuthInfo.setHasPermissionCompanyIds(companyIds);
        companyAuthInfo.setUniqueId(userId);
        companyAuthInfo.setAuthToken(authToken);
        return companyAuthInfo;
    }
}
