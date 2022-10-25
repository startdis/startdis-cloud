package com.startdis.system.server.service.impl;

import com.startdis.system.domain.model.entity.CompanyDept;
import com.startdis.system.infra.mapper.CompanyDeptMapper;
import com.startdis.system.server.service.CompanyDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 公司部门表 服务实现类
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Service
public class CompanyDeptServiceImpl extends ServiceImpl<CompanyDeptMapper, CompanyDept> implements CompanyDeptService {

}
