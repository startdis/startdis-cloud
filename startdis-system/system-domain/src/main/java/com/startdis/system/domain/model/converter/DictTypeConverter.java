package com.startdis.system.domain.model.converter;


import com.startdis.system.domain.model.dto.DictTypePostDTO;
import com.startdis.system.domain.model.dto.DictTypePutDTO;
import com.startdis.system.domain.model.entity.DictType;
import com.startdis.system.domain.model.query.DictTypeQuery;
import com.startdis.system.domain.model.vo.DictTypeVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 字典类型表 DictTypeConverter转换接口
 */
@Mapper
public interface DictTypeConverter {
    
    DictTypeConverter INSTANT = Mappers.getMapper(DictTypeConverter.class);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    DictType postDtoToEntity(DictTypePostDTO dictTypeDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    DictType putDtoToEntity(DictTypePutDTO dictTypeDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    DictType queryToEntity(DictTypeQuery dictTypeQuery);
    
    DictTypeVO entityToVO(DictType dictType);
    
}
