package com.startdis.system.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.startdis.system.domain.model.entity.Company;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 公司表 Mapper 接口
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Mapper
public interface CompanyMapper extends BaseMapper<Company> {

}
