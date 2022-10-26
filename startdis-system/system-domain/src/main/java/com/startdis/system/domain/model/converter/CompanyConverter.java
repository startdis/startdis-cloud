package com.startdis.system.domain.model.converter;


import com.startdis.system.domain.model.dto.CompanyPostDTO;
import com.startdis.system.domain.model.dto.CompanyPutDTO;
import com.startdis.system.domain.model.entity.Company;
import com.startdis.system.domain.model.query.CompanyQuery;
import com.startdis.system.domain.model.vo.CompanyVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 公司表 CompanyConverter转换接口
 */
@Mapper
public interface CompanyConverter {
    
    CompanyConverter INSTANT = Mappers.getMapper(CompanyConverter.class);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Company postDtoToEntity(CompanyPostDTO companyDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Company putDtoToEntity(CompanyPutDTO companyDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Company queryToEntity(CompanyQuery companyQuery);
    
    CompanyVO entityToVO(Company company);
    
}
