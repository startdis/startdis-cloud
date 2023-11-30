package com.startdis.sys.domain.model.converter;


import com.startdis.sys.domain.model.dto.post.CompanyDeptPostDTO;
import com.startdis.sys.domain.model.dto.put.CompanyDeptPutDTO;
import com.startdis.sys.domain.model.entity.CompanyDept;
import com.startdis.sys.domain.model.query.CompanyDeptQuery;
import com.startdis.sys.domain.model.vo.CompanyDeptVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 公司与部门关系表 CompanyDeptConverter转换接口
 */
@Mapper
public interface CompanyDeptConverter {

    CompanyDeptConverter INSTANT = Mappers.getMapper(CompanyDeptConverter.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CompanyDept postDtoToEntity(CompanyDeptPostDTO companyDeptDTO);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CompanyDept putDtoToEntity(CompanyDeptPutDTO companyDeptDTO);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CompanyDept queryToEntity(CompanyDeptQuery companyDeptQuery);

    CompanyDeptVO entityToVO(CompanyDept companyDept);

}
