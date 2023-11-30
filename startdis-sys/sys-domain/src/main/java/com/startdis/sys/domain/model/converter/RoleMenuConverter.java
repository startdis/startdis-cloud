package com.startdis.sys.domain.model.converter;


import com.startdis.sys.domain.model.dto.post.RoleMenuPostDTO;
import com.startdis.sys.domain.model.dto.put.RoleMenuPutDTO;
import com.startdis.sys.domain.model.entity.RoleMenu;
import com.startdis.sys.domain.model.query.RoleMenuQuery;
import com.startdis.sys.domain.model.vo.RoleMenuVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**

 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 角色菜单表 RoleMenuConverter转换接口
 */
@Mapper
public interface RoleMenuConverter {

    public static RoleMenuConverter INSTANT = Mappers.getMapper(RoleMenuConverter.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    RoleMenu postDtoToEntity(RoleMenuPostDTO roleMenuDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    RoleMenu putDtoToEntity(RoleMenuPutDTO roleMenuDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    RoleMenu queryToEntity(RoleMenuQuery roleMenuQuery);
    
    RoleMenuVO entityToVO(RoleMenu roleMenu);
    
}
