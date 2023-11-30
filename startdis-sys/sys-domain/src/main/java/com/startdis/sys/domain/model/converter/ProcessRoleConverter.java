package com.startdis.sys.domain.model.converter;


import com.startdis.sys.domain.model.dto.post.ProcessRolePostDTO;
import com.startdis.sys.domain.model.dto.put.ProcessRolePutDTO;
import com.startdis.sys.domain.model.entity.ProcessRole;
import com.startdis.sys.domain.model.query.ProcessRoleQuery;
import com.startdis.sys.domain.model.vo.ProcessRoleVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 流程角色表 ProcessRoleConverter转换接口
 */
@Mapper
public interface ProcessRoleConverter {

    ProcessRoleConverter INSTANT = Mappers.getMapper(ProcessRoleConverter.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    ProcessRole postDtoToEntity(ProcessRolePostDTO processRoleDTO);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    ProcessRole putDtoToEntity(ProcessRolePutDTO processRoleDTO);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    ProcessRole queryToEntity(ProcessRoleQuery processRoleQuery);

    ProcessRoleVO entityToVO(ProcessRole processRole);

}
