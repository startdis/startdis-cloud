package com.startdis.system.domain.model.converter;


import com.startdis.system.domain.model.dto.SensitiveWordPostDTO;
import com.startdis.system.domain.model.dto.SensitiveWordPutDTO;
import com.startdis.system.domain.model.entity.SensitiveWord;
import com.startdis.system.domain.model.query.SensitiveWordQuery;
import com.startdis.system.domain.model.vo.SensitiveWordVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 系统敏感词表 SensitiveWordConverter转换接口
 */
@Mapper
public interface SensitiveWordConverter {
    
    SensitiveWordConverter INSTANT = Mappers.getMapper(SensitiveWordConverter.class);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    SensitiveWord postDtoToEntity(SensitiveWordPostDTO sensitiveWordDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    SensitiveWord putDtoToEntity(SensitiveWordPutDTO sensitiveWordDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    SensitiveWord queryToEntity(SensitiveWordQuery sensitiveWordQuery);
    
    SensitiveWordVO entityToVO(SensitiveWord sensitiveWord);
    
}
