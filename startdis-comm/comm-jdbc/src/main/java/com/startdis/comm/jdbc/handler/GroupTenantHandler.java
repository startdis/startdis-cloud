package com.startdis.comm.jdbc.handler;

import com.startdis.comm.jdbc.config.TenantConfig;
import com.startdis.comm.util.auth.AuthInfoUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 集团租户ID字段填充拦截器
 */
@Slf4j
public class GroupTenantHandler extends AbstractTenantHandler {

    public GroupTenantHandler(TenantConfig tenantConfig) {
        super(tenantConfig.getGroupTenant());
    }

    @Override
    protected String doGetTenantId() {
        return Optional.ofNullable(AuthInfoUtils.getGroupTenantId()).orElse("");
    }


    @Override
    protected String getDefaultColumn() {
        return "group_tenant_id";
    }
}
