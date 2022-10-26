package com.startdis.system.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.startdis.system.domain.model.entity.CompanyDept;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 公司部门表 Mapper 接口
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Mapper
public interface CompanyDeptMapper extends BaseMapper<CompanyDept> {

}
