package com.startdis.system.server.service.impl;

import com.startdis.system.domain.model.entity.Package;
import com.startdis.system.infra.mapper.PackageMapper;
import com.startdis.system.server.service.PackageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 套餐表 服务实现类
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Service
public class PackageServiceImpl extends ServiceImpl<PackageMapper, Package> implements PackageService {

}
