package com.startdis.system.domain.model.converter;


import com.startdis.system.domain.model.dto.RolePostDTO;
import com.startdis.system.domain.model.dto.RolePutDTO;
import com.startdis.system.domain.model.entity.Role;
import com.startdis.system.domain.model.query.RoleQuery;
import com.startdis.system.domain.model.vo.RoleVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 角色表 RoleConverter转换接口
 */
@Mapper
public interface RoleConverter {
    
    RoleConverter INSTANT = Mappers.getMapper(RoleConverter.class);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Role postDtoToEntity(RolePostDTO roleDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Role putDtoToEntity(RolePutDTO roleDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Role queryToEntity(RoleQuery roleQuery);
    
    RoleVO entityToVO(Role role);
    
}
