package com.startdis.system.domain.model.converter;


import com.startdis.system.domain.model.dto.DeptPostDTO;
import com.startdis.system.domain.model.dto.DeptPutDTO;
import com.startdis.system.domain.model.entity.Dept;
import com.startdis.system.domain.model.query.DeptQuery;
import com.startdis.system.domain.model.vo.DeptVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 部门表 DeptConverter转换接口
 */
@Mapper
public interface DeptConverter {
    
    DeptConverter INSTANT = Mappers.getMapper(DeptConverter.class);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Dept postDtoToEntity(DeptPostDTO deptDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Dept putDtoToEntity(DeptPutDTO deptDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Dept queryToEntity(DeptQuery deptQuery);
    
    DeptVO entityToVO(Dept dept);
    
}
