package com.startdis.system.domain.model.converter;


import com.startdis.system.domain.model.dto.PostPostDTO;
import com.startdis.system.domain.model.dto.PostPutDTO;
import com.startdis.system.domain.model.entity.Post;
import com.startdis.system.domain.model.query.PostQuery;
import com.startdis.system.domain.model.vo.PostVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 岗位表 PostConverter转换接口
 */
@Mapper
public interface PostConverter {
    
    PostConverter INSTANT = Mappers.getMapper(PostConverter.class);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Post postDtoToEntity(PostPostDTO postDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Post putDtoToEntity(PostPutDTO postDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Post queryToEntity(PostQuery postQuery);
    
    PostVO entityToVO(Post post);
    
}
