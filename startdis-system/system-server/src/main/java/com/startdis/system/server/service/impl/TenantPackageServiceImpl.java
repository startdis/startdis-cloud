package com.startdis.system.server.service.impl;

import com.startdis.system.domain.model.entity.TenantPackage;
import com.startdis.system.infra.mapper.TenantPackageMapper;
import com.startdis.system.server.service.TenantPackageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 租户套餐表 服务实现类
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Service
public class TenantPackageServiceImpl extends ServiceImpl<TenantPackageMapper, TenantPackage> implements TenantPackageService {

}
