package com.startdis.sys.domain.model.converter;


import com.startdis.sys.domain.model.dto.post.ProcessRoleDeptPostDTO;
import com.startdis.sys.domain.model.dto.put.ProcessRoleDeptPutDTO;
import com.startdis.sys.domain.model.entity.ProcessRoleDept;
import com.startdis.sys.domain.model.query.ProcessRoleDeptQuery;
import com.startdis.sys.domain.model.vo.ProcessRoleDeptVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 流程部门与流程角色关联表 ProcessRoleDeptConverter转换接口
 */
@Mapper
public interface ProcessRoleDeptConverter {

    ProcessRoleDeptConverter INSTANT = Mappers.getMapper(ProcessRoleDeptConverter.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    ProcessRoleDept postDtoToEntity(ProcessRoleDeptPostDTO processRoleDeptDTO);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    ProcessRoleDept putDtoToEntity(ProcessRoleDeptPutDTO processRoleDeptDTO);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    ProcessRoleDept queryToEntity(ProcessRoleDeptQuery processRoleDeptQuery);

    ProcessRoleDeptVO entityToVO(ProcessRoleDept processRoleDept);

}
