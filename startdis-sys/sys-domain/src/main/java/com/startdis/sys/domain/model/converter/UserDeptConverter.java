package com.startdis.sys.domain.model.converter;


import com.startdis.sys.domain.model.dto.post.UserDeptPostDTO;
import com.startdis.sys.domain.model.dto.put.UserDeptPutDTO;
import com.startdis.sys.domain.model.entity.UserDept;
import com.startdis.sys.domain.model.query.UserDeptQuery;
import com.startdis.sys.domain.model.vo.UserDeptVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**

 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 用户部门表 UserDeptConverter转换接口
 */
@Mapper
public interface UserDeptConverter {

    public static UserDeptConverter INSTANT = Mappers.getMapper(UserDeptConverter.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    UserDept postDtoToEntity(UserDeptPostDTO userDeptDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    UserDept putDtoToEntity(UserDeptPutDTO userDeptDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    UserDept queryToEntity(UserDeptQuery userDeptQuery);
    
    UserDeptVO entityToVO(UserDept userDept);
    
}
