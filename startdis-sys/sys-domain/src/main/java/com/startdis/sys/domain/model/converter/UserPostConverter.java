package com.startdis.sys.domain.model.converter;


import com.startdis.sys.domain.model.dto.post.UserPostPostDTO;
import com.startdis.sys.domain.model.dto.put.UserPostPutDTO;
import com.startdis.sys.domain.model.entity.UserPost;
import com.startdis.sys.domain.model.query.UserPostQuery;
import com.startdis.sys.domain.model.vo.UserPostVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**

 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 用户岗位表 UserPostConverter转换接口
 */
@Mapper
public interface UserPostConverter {

    public static UserPostConverter INSTANT = Mappers.getMapper(UserPostConverter.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    UserPost postDtoToEntity(UserPostPostDTO userPostDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    UserPost putDtoToEntity(UserPostPutDTO userPostDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    UserPost queryToEntity(UserPostQuery userPostQuery);
    
    UserPostVO entityToVO(UserPost userPost);
    
}
