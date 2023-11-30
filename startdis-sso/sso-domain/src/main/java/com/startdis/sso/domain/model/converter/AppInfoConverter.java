package com.startdis.sso.domain.model.converter;


import com.startdis.sso.domain.model.dto.post.AppInfoPostDTO;
import com.startdis.sso.domain.model.dto.put.AppInfoPutDTO;
import com.startdis.sso.domain.model.entity.AppInfo;
import com.startdis.sso.domain.model.query.AppInfoQuery;
import com.startdis.sso.domain.model.vo.AppInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 应用中心表 AppInfoConverter转换接口
 */
@Mapper
public interface AppInfoConverter {

    AppInfoConverter INSTANT = Mappers.getMapper(AppInfoConverter.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    AppInfo postDtoToEntity(AppInfoPostDTO appInfoDTO);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    AppInfo putDtoToEntity(AppInfoPutDTO appInfoDTO);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    AppInfo queryToEntity(AppInfoQuery appInfoQuery);

    AppInfoVO entityToVO(AppInfo appInfo);

}
