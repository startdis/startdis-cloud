package com.startdis.sso.domain.model.converter;


import com.startdis.sso.domain.model.dto.post.AccessTokenPostDTO;
import com.startdis.sso.domain.model.dto.put.AccessTokenPutDTO;
import com.startdis.sso.domain.model.entity.AccessToken;
import com.startdis.sso.domain.model.query.AccessTokenQuery;
import com.startdis.sso.domain.model.vo.AccessTokenVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 鉴权令牌表 AccessTokenConverter转换接口
 */
@Mapper
public interface AccessTokenConverter {

    AccessTokenConverter INSTANT = Mappers.getMapper(AccessTokenConverter.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    AccessToken postDtoToEntity(AccessTokenPostDTO accessTokenDTO);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    AccessToken putDtoToEntity(AccessTokenPutDTO accessTokenDTO);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    AccessToken queryToEntity(AccessTokenQuery accessTokenQuery);

    AccessTokenVO entityToVO(AccessToken accessToken);

}
