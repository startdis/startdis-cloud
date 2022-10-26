package com.startdis.system.domain.model.converter;


import com.startdis.system.domain.model.dto.TenantPackagePostDTO;
import com.startdis.system.domain.model.dto.TenantPackagePutDTO;
import com.startdis.system.domain.model.entity.TenantPackage;
import com.startdis.system.domain.model.query.TenantPackageQuery;
import com.startdis.system.domain.model.vo.TenantPackageVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 租户套餐表 TenantPackageConverter转换接口
 */
@Mapper
public interface TenantPackageConverter {
    
    TenantPackageConverter INSTANT = Mappers.getMapper(TenantPackageConverter.class);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    TenantPackage postDtoToEntity(TenantPackagePostDTO tenantPackageDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    TenantPackage putDtoToEntity(TenantPackagePutDTO tenantPackageDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    TenantPackage queryToEntity(TenantPackageQuery tenantPackageQuery);
    
    TenantPackageVO entityToVO(TenantPackage tenantPackage);
    
}
