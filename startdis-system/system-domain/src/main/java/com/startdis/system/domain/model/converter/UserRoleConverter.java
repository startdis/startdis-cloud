package com.startdis.system.domain.model.converter;


import com.startdis.system.domain.model.dto.UserRolePostDTO;
import com.startdis.system.domain.model.dto.UserRolePutDTO;
import com.startdis.system.domain.model.entity.UserRole;
import com.startdis.system.domain.model.query.UserRoleQuery;
import com.startdis.system.domain.model.vo.UserRoleVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 用户角色中间表 UserRoleConverter转换接口
 */
@Mapper
public interface UserRoleConverter {
    
    UserRoleConverter INSTANT = Mappers.getMapper(UserRoleConverter.class);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    UserRole postDtoToEntity(UserRolePostDTO userRoleDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    UserRole putDtoToEntity(UserRolePutDTO userRoleDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    UserRole queryToEntity(UserRoleQuery userRoleQuery);
    
    UserRoleVO entityToVO(UserRole userRole);
    
}
