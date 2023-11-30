package com.startdis.sys.infra.mapper;

import com.startdis.sys.domain.model.entity.CompanyDept;
import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 公司与部门关系表(CompanyDept)数据层
 */
@Mapper
public interface CompanyDeptMapper extends BaseMapper<CompanyDept> {

}
