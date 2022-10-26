package com.startdis.system.domain.model.converter;


import com.startdis.system.domain.model.dto.CompanyPostPostDTO;
import com.startdis.system.domain.model.dto.CompanyPostPutDTO;
import com.startdis.system.domain.model.entity.CompanyPost;
import com.startdis.system.domain.model.query.CompanyPostQuery;
import com.startdis.system.domain.model.vo.CompanyPostVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 公司岗位表 CompanyPostConverter转换接口
 */
@Mapper
public interface CompanyPostConverter {
    
    CompanyPostConverter INSTANT = Mappers.getMapper(CompanyPostConverter.class);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CompanyPost postDtoToEntity(CompanyPostPostDTO companyPostDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CompanyPost putDtoToEntity(CompanyPostPutDTO companyPostDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CompanyPost queryToEntity(CompanyPostQuery companyPostQuery);
    
    CompanyPostVO entityToVO(CompanyPost companyPost);
    
}
