package com.startdis.system.domain.model.converter;


import com.startdis.system.domain.model.dto.RoleMenuPostDTO;
import com.startdis.system.domain.model.dto.RoleMenuPutDTO;
import com.startdis.system.domain.model.entity.RoleMenu;
import com.startdis.system.domain.model.query.RoleMenuQuery;
import com.startdis.system.domain.model.vo.RoleMenuVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 角色菜单中间表 RoleMenuConverter转换接口
 */
@Mapper
public interface RoleMenuConverter {
    
    RoleMenuConverter INSTANT = Mappers.getMapper(RoleMenuConverter.class);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    RoleMenu postDtoToEntity(RoleMenuPostDTO roleMenuDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    RoleMenu putDtoToEntity(RoleMenuPutDTO roleMenuDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    RoleMenu queryToEntity(RoleMenuQuery roleMenuQuery);
    
    RoleMenuVO entityToVO(RoleMenu roleMenu);
    
}
