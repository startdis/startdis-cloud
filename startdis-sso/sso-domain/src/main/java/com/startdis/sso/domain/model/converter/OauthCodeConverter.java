package com.startdis.sso.domain.model.converter;


import com.startdis.sso.domain.model.dto.post.OauthCodePostDTO;
import com.startdis.sso.domain.model.dto.put.OauthCodePutDTO;
import com.startdis.sso.domain.model.entity.OauthCode;
import com.startdis.sso.domain.model.query.OauthCodeQuery;
import com.startdis.sso.domain.model.vo.OauthCodeVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 授权码表 OauthCodeConverter转换接口
 */
@Mapper
public interface OauthCodeConverter {

    OauthCodeConverter INSTANT = Mappers.getMapper(OauthCodeConverter.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    OauthCode postDtoToEntity(OauthCodePostDTO oauthCodeDTO);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    OauthCode putDtoToEntity(OauthCodePutDTO oauthCodeDTO);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    OauthCode queryToEntity(OauthCodeQuery oauthCodeQuery);

    OauthCodeVO entityToVO(OauthCode oauthCode);

}
