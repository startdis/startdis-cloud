package com.startdis.sso.domain.model.converter;


import com.startdis.sso.domain.model.dto.post.RefreshTokenPostDTO;
import com.startdis.sso.domain.model.dto.put.RefreshTokenPutDTO;
import com.startdis.sso.domain.model.entity.RefreshToken;
import com.startdis.sso.domain.model.query.RefreshTokenQuery;
import com.startdis.sso.domain.model.vo.RefreshTokenVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 刷新令牌表 RefreshTokenConverter转换接口
 */
@Mapper
public interface RefreshTokenConverter {

    RefreshTokenConverter INSTANT = Mappers.getMapper(RefreshTokenConverter.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    RefreshToken postDtoToEntity(RefreshTokenPostDTO refreshTokenDTO);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    RefreshToken putDtoToEntity(RefreshTokenPutDTO refreshTokenDTO);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    RefreshToken queryToEntity(RefreshTokenQuery refreshTokenQuery);

    RefreshTokenVO entityToVO(RefreshToken refreshToken);

}
