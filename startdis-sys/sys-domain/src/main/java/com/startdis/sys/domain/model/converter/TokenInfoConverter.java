package com.startdis.sys.domain.model.converter;


import com.startdis.sys.domain.model.dto.post.TokenInfoPostDTO;
import com.startdis.sys.domain.model.dto.put.TokenInfoPutDTO;
import com.startdis.sys.domain.model.entity.TokenInfo;
import com.startdis.sys.domain.model.query.TokenInfoQuery;
import com.startdis.sys.domain.model.vo.TokenInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 系统授权信息表 TokenInfoConverter转换接口
 */
@Mapper
public interface TokenInfoConverter {

    TokenInfoConverter INSTANT = Mappers.getMapper(TokenInfoConverter.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    TokenInfo postDtoToEntity(TokenInfoPostDTO tokenInfoDTO);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    TokenInfo putDtoToEntity(TokenInfoPutDTO tokenInfoDTO);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    TokenInfo queryToEntity(TokenInfoQuery tokenInfoQuery);

    TokenInfoVO entityToVO(TokenInfo tokenInfo);

}
