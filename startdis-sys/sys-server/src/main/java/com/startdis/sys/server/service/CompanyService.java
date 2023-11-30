package com.startdis.sys.server.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.sys.domain.model.entity.Company;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 公司表 CompanyService
 */
public interface CompanyService extends IService<Company> {

    ResultBean add(Company company);

    ResultBean update(Company company);
}
