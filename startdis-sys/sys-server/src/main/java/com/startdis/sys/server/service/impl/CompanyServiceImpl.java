package com.startdis.sys.server.service.impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.sys.domain.model.entity.Company;
import com.startdis.sys.infra.mapper.CompanyMapper;
import com.startdis.sys.server.service.CompanyService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 公司表 CompanyService
 */
@Service("companyService")
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {

    @Override
    public ResultBean add(Company company) {
        String companyName = company.getCompanyName();
        Long count = this.baseMapper.selectCount(Wrappers.<Company>lambdaQuery().eq(Company::getCompanyName, companyName));
        if (count > 0){
            return ResultBean.error("公司名称已存在！");
        }
        this.save(company);
        return ResultBean.success();
    }

    @Override
    public ResultBean update(Company company) {
        String companyName = company.getCompanyName();
        Long count = this.baseMapper.selectCount(Wrappers.<Company>lambdaQuery()
                .eq(Company::getCompanyName, companyName)
                .ne(Company::getId,company.getId()));
        if (count > 0){
            return ResultBean.error("公司名称已存在！");
        }
        this.updateById(company);
        return ResultBean.success();
    }
}
