package com.startdis.system.server.service.impl;

import com.startdis.system.domain.model.entity.Company;
import com.startdis.system.infra.mapper.CompanyMapper;
import com.startdis.system.server.service.CompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 公司表 服务实现类
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {

}
