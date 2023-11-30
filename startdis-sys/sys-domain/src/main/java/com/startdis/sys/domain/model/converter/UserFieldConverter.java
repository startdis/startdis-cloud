package com.startdis.sys.domain.model.converter;


import com.startdis.sys.domain.model.dto.post.UserFieldPostDTO;
import com.startdis.sys.domain.model.dto.put.UserFieldPutDTO;
import com.startdis.sys.domain.model.entity.UserField;
import com.startdis.sys.domain.model.query.UserFieldQuery;
import com.startdis.sys.domain.model.vo.UserFieldVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**

 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 用户字段表 UserFieldConverter转换接口
 */
@Mapper
public interface UserFieldConverter {

    public static UserFieldConverter INSTANT = Mappers.getMapper(UserFieldConverter.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    UserField postDtoToEntity(UserFieldPostDTO userFieldDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    UserField putDtoToEntity(UserFieldPutDTO userFieldDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    UserField queryToEntity(UserFieldQuery userFieldQuery);
    
    UserFieldVO entityToVO(UserField userField);
    
}
