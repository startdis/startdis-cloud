package com.startdis.system.domain.model.converter;


import com.startdis.system.domain.model.dto.DictItemPostDTO;
import com.startdis.system.domain.model.dto.DictItemPutDTO;
import com.startdis.system.domain.model.entity.DictItem;
import com.startdis.system.domain.model.query.DictItemQuery;
import com.startdis.system.domain.model.vo.DictItemVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 字典数据表 DictItemConverter转换接口
 */
@Mapper
public interface DictItemConverter {
    
    DictItemConverter INSTANT = Mappers.getMapper(DictItemConverter.class);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    DictItem postDtoToEntity(DictItemPostDTO dictItemDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    DictItem putDtoToEntity(DictItemPutDTO dictItemDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    DictItem queryToEntity(DictItemQuery dictItemQuery);
    
    DictItemVO entityToVO(DictItem dictItem);
    
}
