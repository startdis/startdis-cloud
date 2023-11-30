package com.startdis.sys.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.startdis.sys.domain.model.entity.CompanyDept;
import com.startdis.sys.infra.mapper.CompanyDeptMapper;
import com.startdis.sys.server.service.CompanyDeptService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 公司与部门关系表(CompanyDept)服务实现层
 */
@Service("companyDeptService")
public class CompanyDeptServiceImpl extends ServiceImpl<CompanyDeptMapper, CompanyDept> implements CompanyDeptService {

}

