package com.startdis.sys.domain.model.converter;


import com.startdis.sys.domain.model.dto.post.DeptPostDTO;
import com.startdis.sys.domain.model.dto.put.DeptPutDTO;
import com.startdis.sys.domain.model.entity.Dept;
import com.startdis.sys.domain.model.query.DeptQuery;
import com.startdis.sys.domain.model.vo.DeptVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**

 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 部门表 DeptConverter转换接口
 */
@Mapper
public interface DeptConverter {

    public static DeptConverter INSTANT = Mappers.getMapper(DeptConverter.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Dept postDtoToEntity(DeptPostDTO deptDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Dept putDtoToEntity(DeptPutDTO deptDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Dept queryToEntity(DeptQuery deptQuery);
    
    DeptVO entityToVO(Dept dept);
    
}
