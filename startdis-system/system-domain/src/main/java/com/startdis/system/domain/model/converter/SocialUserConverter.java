package com.startdis.system.domain.model.converter;


import com.startdis.system.domain.model.dto.SocialUserPostDTO;
import com.startdis.system.domain.model.dto.SocialUserPutDTO;
import com.startdis.system.domain.model.entity.SocialUser;
import com.startdis.system.domain.model.query.SocialUserQuery;
import com.startdis.system.domain.model.vo.SocialUserVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 社交用户表 SocialUserConverter转换接口
 */
@Mapper
public interface SocialUserConverter {
    
    SocialUserConverter INSTANT = Mappers.getMapper(SocialUserConverter.class);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    SocialUser postDtoToEntity(SocialUserPostDTO socialUserDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    SocialUser putDtoToEntity(SocialUserPutDTO socialUserDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    SocialUser queryToEntity(SocialUserQuery socialUserQuery);
    
    SocialUserVO entityToVO(SocialUser socialUser);
    
}
