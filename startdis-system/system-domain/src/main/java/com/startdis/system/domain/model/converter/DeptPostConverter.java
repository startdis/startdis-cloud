package com.startdis.system.domain.model.converter;


import com.startdis.system.domain.model.dto.DeptPostPostDTO;
import com.startdis.system.domain.model.dto.DeptPostPutDTO;
import com.startdis.system.domain.model.entity.DeptPost;
import com.startdis.system.domain.model.query.DeptPostQuery;
import com.startdis.system.domain.model.vo.DeptPostVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 部门岗位表 DeptPostConverter转换接口
 */
@Mapper
public interface DeptPostConverter {
    
    DeptPostConverter INSTANT = Mappers.getMapper(DeptPostConverter.class);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    DeptPost postDtoToEntity(DeptPostPostDTO deptPostDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    DeptPost putDtoToEntity(DeptPostPutDTO deptPostDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    DeptPost queryToEntity(DeptPostQuery deptPostQuery);
    
    DeptPostVO entityToVO(DeptPost deptPost);
    
}
