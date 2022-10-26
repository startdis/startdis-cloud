package com.startdis.system.domain.model.converter;


import com.startdis.system.domain.model.dto.UsersPostDTO;
import com.startdis.system.domain.model.dto.UsersPutDTO;
import com.startdis.system.domain.model.entity.Users;
import com.startdis.system.domain.model.query.UsersQuery;
import com.startdis.system.domain.model.vo.UsersVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 用户表 UsersConverter转换接口
 */
@Mapper
public interface UsersConverter {
    
    UsersConverter INSTANT = Mappers.getMapper(UsersConverter.class);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Users postDtoToEntity(UsersPostDTO usersDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Users putDtoToEntity(UsersPutDTO usersDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Users queryToEntity(UsersQuery usersQuery);
    
    UsersVO entityToVO(Users users);
    
}
