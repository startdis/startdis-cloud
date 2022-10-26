package com.startdis.system.domain.model.converter;


import com.startdis.system.domain.model.dto.TenantPostDTO;
import com.startdis.system.domain.model.dto.TenantPutDTO;
import com.startdis.system.domain.model.entity.Tenant;
import com.startdis.system.domain.model.query.TenantQuery;
import com.startdis.system.domain.model.vo.TenantVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 租户表 TenantConverter转换接口
 */
@Mapper
public interface TenantConverter {
    
    TenantConverter INSTANT = Mappers.getMapper(TenantConverter.class);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Tenant postDtoToEntity(TenantPostDTO tenantDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Tenant putDtoToEntity(TenantPutDTO tenantDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Tenant queryToEntity(TenantQuery tenantQuery);
    
    TenantVO entityToVO(Tenant tenant);
    
}
