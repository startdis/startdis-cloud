package com.startdis.system.domain.model.converter;


import com.startdis.system.domain.model.dto.SocialUserBindPostDTO;
import com.startdis.system.domain.model.dto.SocialUserBindPutDTO;
import com.startdis.system.domain.model.entity.SocialUserBind;
import com.startdis.system.domain.model.query.SocialUserBindQuery;
import com.startdis.system.domain.model.vo.SocialUserBindVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 社交用户绑定表 SocialUserBindConverter转换接口
 */
@Mapper
public interface SocialUserBindConverter {
    
    SocialUserBindConverter INSTANT = Mappers.getMapper(SocialUserBindConverter.class);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    SocialUserBind postDtoToEntity(SocialUserBindPostDTO socialUserBindDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    SocialUserBind putDtoToEntity(SocialUserBindPutDTO socialUserBindDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    SocialUserBind queryToEntity(SocialUserBindQuery socialUserBindQuery);
    
    SocialUserBindVO entityToVO(SocialUserBind socialUserBind);
    
}
