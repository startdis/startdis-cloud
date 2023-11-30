package com.startdis.sys.domain.model.converter;


import com.startdis.sys.domain.model.dto.post.UserProcessRolePostDTO;
import com.startdis.sys.domain.model.dto.put.UserProcessRolePutDTO;
import com.startdis.sys.domain.model.entity.UserProcessRole;
import com.startdis.sys.domain.model.query.UserProcessRoleQuery;
import com.startdis.sys.domain.model.vo.UserProcessRoleVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 用户流程角色表 UserProcessRoleConverter转换接口
 */
@Mapper
public interface UserProcessRoleConverter {

    UserProcessRoleConverter INSTANT = Mappers.getMapper(UserProcessRoleConverter.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    UserProcessRole postDtoToEntity(UserProcessRolePostDTO userProcessRoleDTO);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    UserProcessRole putDtoToEntity(UserProcessRolePutDTO userProcessRoleDTO);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    UserProcessRole queryToEntity(UserProcessRoleQuery userProcessRoleQuery);

    UserProcessRoleVO entityToVO(UserProcessRole userProcessRole);

}
