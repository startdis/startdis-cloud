package com.startdis.sys.domain.model.converter;


import com.startdis.sys.domain.model.dto.post.CompanyPostDTO;
import com.startdis.sys.domain.model.dto.put.CompanyPutDTO;
import com.startdis.sys.domain.model.entity.Company;
import com.startdis.sys.domain.model.query.CompanyQuery;
import com.startdis.sys.domain.model.vo.CompanyVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**

 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 公司表 CompanyConverter转换接口
 */
@Mapper
public interface CompanyConverter {

    public static CompanyConverter INSTANT = Mappers.getMapper(CompanyConverter.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Company postDtoToEntity(CompanyPostDTO companyDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Company putDtoToEntity(CompanyPutDTO companyDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Company queryToEntity(CompanyQuery companyQuery);
    
    CompanyVO entityToVO(Company company);
    
}
