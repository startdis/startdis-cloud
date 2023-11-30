package com.startdis.sys.domain.model.converter;


import com.startdis.sys.domain.model.dto.post.DictItemPostDTO;
import com.startdis.sys.domain.model.dto.put.DictItemPutDTO;
import com.startdis.sys.domain.model.entity.DictItem;
import com.startdis.sys.domain.model.query.DictItemQuery;
import com.startdis.sys.domain.model.vo.DictItemVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**

 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 字典项表 DictItemConverter转换接口
 */
@Mapper
public interface DictItemConverter {

    public static DictItemConverter INSTANT = Mappers.getMapper(DictItemConverter.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    DictItem postDtoToEntity(DictItemPostDTO dictItemDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    DictItem putDtoToEntity(DictItemPutDTO dictItemDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    DictItem queryToEntity(DictItemQuery dictItemQuery);
    
    DictItemVO entityToVO(DictItem dictItem);
    
}
