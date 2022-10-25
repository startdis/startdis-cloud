package com.startdis.system.server.service.impl;

import com.startdis.system.domain.model.entity.Tenant;
import com.startdis.system.infra.mapper.TenantMapper;
import com.startdis.system.server.service.TenantService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 租户表 服务实现类
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Service
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant> implements TenantService {

}
