package com.startdis.sys.server.service.impl;


import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.exception.custom.BusinessException;
import com.startdis.sys.domain.model.entity.CompanyDept;
import com.startdis.sys.domain.model.entity.Dept;
import com.startdis.sys.infra.mapper.DeptMapper;
import com.startdis.sys.server.service.CompanyDeptService;
import com.startdis.sys.server.service.DeptService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 部门表 DeptService
 */
@Service("deptService")
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

    @Autowired
    private CompanyDeptService companyDeptService;

    @Override
    public ResultBean<Boolean> add(Dept dept) {
        // Updated by limengwei at 20230617，部门编码或部门名称重复校验
        checkExist(dept);
        if (this.save(dept)){
            CompanyDept companyDept = new CompanyDept();
            companyDept.setDeptId(dept.getId());
            companyDept.setCompanyId(dept.getCompanyId());
            companyDeptService.save(companyDept);
        }
        return ResultBean.success();
    }

    /**
     * 校验重复添加
     * @param dept
     */
    private void checkExist(Dept dept) {
        LambdaQueryWrapper<Dept> wrapper = Wrappers.lambdaQuery(Dept.class)
                .eq(Dept::getCompanyId, dept.getCompanyId())
                .and(temp ->temp.eq(Dept::getDeptCode, dept.getDeptCode()).or().eq(Dept::getDeptName, dept.getDeptName()));
        if(StringUtils.isNotEmpty(dept.getId())){
            wrapper.ne(Dept::getId, dept.getId());
        }
        List<Dept> list = list(wrapper);
        if(CollectionUtil.isNotEmpty(list)){
            throw new BusinessException("A0001", "部门编码或部门名称已存在，请勿重复添加！");
        }
    }

    @Override
    public ResultBean<Boolean> update(Dept dept) {
        // Updated by limengwei at 20230617，部门编码或部门名称重复校验
        checkExist(dept);
        if (this.updateById(dept)){
            companyDeptService.remove(Wrappers.<CompanyDept>lambdaQuery()
                    .eq(CompanyDept::getDeptId,dept.getId()));
            CompanyDept companyDept = new CompanyDept();
            companyDept.setDeptId(dept.getId());
            companyDept.setCompanyId(dept.getCompanyId());
            companyDeptService.save(companyDept);
        }
        return ResultBean.success();
    }
}
