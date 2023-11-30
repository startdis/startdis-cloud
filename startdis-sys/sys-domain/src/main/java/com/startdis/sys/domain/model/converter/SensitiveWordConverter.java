package com.startdis.sys.domain.model.converter;


import com.startdis.sys.domain.model.dto.post.SensitiveWordPostDTO;
import com.startdis.sys.domain.model.dto.put.SensitiveWordPutDTO;
import com.startdis.sys.domain.model.entity.SensitiveWord;
import com.startdis.sys.domain.model.query.SensitiveWordQuery;
import com.startdis.sys.domain.model.vo.SensitiveWordVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**

 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 系统敏感词表 SensitiveWordConverter转换接口
 */
@Mapper
public interface SensitiveWordConverter {

    public static SensitiveWordConverter INSTANT = Mappers.getMapper(SensitiveWordConverter.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    SensitiveWord postDtoToEntity(SensitiveWordPostDTO sensitiveWordDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    SensitiveWord putDtoToEntity(SensitiveWordPutDTO sensitiveWordDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    SensitiveWord queryToEntity(SensitiveWordQuery sensitiveWordQuery);
    
    SensitiveWordVO entityToVO(SensitiveWord sensitiveWord);
    
}
