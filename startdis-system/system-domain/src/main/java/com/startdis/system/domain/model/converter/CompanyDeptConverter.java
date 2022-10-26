package com.startdis.system.domain.model.converter;


import com.startdis.system.domain.model.dto.CompanyDeptPostDTO;
import com.startdis.system.domain.model.dto.CompanyDeptPutDTO;
import com.startdis.system.domain.model.entity.CompanyDept;
import com.startdis.system.domain.model.query.CompanyDeptQuery;
import com.startdis.system.domain.model.vo.CompanyDeptVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 公司部门表 CompanyDeptConverter转换接口
 */
@Mapper
public interface CompanyDeptConverter {
    
    CompanyDeptConverter INSTANT = Mappers.getMapper(CompanyDeptConverter.class);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CompanyDept postDtoToEntity(CompanyDeptPostDTO companyDeptDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CompanyDept putDtoToEntity(CompanyDeptPutDTO companyDeptDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CompanyDept queryToEntity(CompanyDeptQuery companyDeptQuery);
    
    CompanyDeptVO entityToVO(CompanyDept companyDept);
    
}
