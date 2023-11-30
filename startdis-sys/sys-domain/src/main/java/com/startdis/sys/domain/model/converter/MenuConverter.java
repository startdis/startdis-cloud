package com.startdis.sys.domain.model.converter;


import com.startdis.sys.domain.model.dto.post.MenuPostDTO;
import com.startdis.sys.domain.model.dto.put.MenuPutDTO;
import com.startdis.sys.domain.model.entity.Menu;
import com.startdis.sys.domain.model.query.MenuQuery;
import com.startdis.sys.domain.model.vo.MenuVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**

 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 菜单表 MenuConverter转换接口
 */
@Mapper
public interface MenuConverter {

    public static MenuConverter INSTANT = Mappers.getMapper(MenuConverter.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Menu postDtoToEntity(MenuPostDTO menuDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Menu putDtoToEntity(MenuPutDTO menuDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Menu queryToEntity(MenuQuery menuQuery);
    
    MenuVO entityToVO(Menu menu);
    
}
