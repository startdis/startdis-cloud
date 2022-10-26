package com.startdis.system.domain.model.converter;


import com.startdis.system.domain.model.dto.UserPostPostDTO;
import com.startdis.system.domain.model.dto.UserPostPutDTO;
import com.startdis.system.domain.model.entity.UserPost;
import com.startdis.system.domain.model.query.UserPostQuery;
import com.startdis.system.domain.model.vo.UserPostVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 用户岗位表 UserPostConverter转换接口
 */
@Mapper
public interface UserPostConverter {
    
    UserPostConverter INSTANT = Mappers.getMapper(UserPostConverter.class);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    UserPost postDtoToEntity(UserPostPostDTO userPostDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    UserPost putDtoToEntity(UserPostPutDTO userPostDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    UserPost queryToEntity(UserPostQuery userPostQuery);
    
    UserPostVO entityToVO(UserPost userPost);
    
}
