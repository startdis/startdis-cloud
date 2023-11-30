package com.startdis.sys.server.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.sys.domain.model.entity.Dept;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 部门表 DeptService
 */
public interface DeptService extends IService<Dept> {

    ResultBean<Boolean> add(Dept dept);

    ResultBean<Boolean> update(Dept dept);
}
