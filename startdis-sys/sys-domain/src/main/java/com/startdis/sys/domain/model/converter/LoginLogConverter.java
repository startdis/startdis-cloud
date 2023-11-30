package com.startdis.sys.domain.model.converter;


import com.startdis.sys.domain.model.dto.post.LoginLogPostDTO;
import com.startdis.sys.domain.model.dto.put.LoginLogPutDTO;
import com.startdis.sys.domain.model.entity.LoginLog;
import com.startdis.sys.domain.model.query.LoginLogQuery;
import com.startdis.sys.domain.model.vo.LoginLogVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**

 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 系统登录日志 LoginLogConverter转换接口
 */
@Mapper
public interface LoginLogConverter {

    public static LoginLogConverter INSTANT = Mappers.getMapper(LoginLogConverter.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    LoginLog postDtoToEntity(LoginLogPostDTO loginLogDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    LoginLog putDtoToEntity(LoginLogPutDTO loginLogDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    LoginLog queryToEntity(LoginLogQuery loginLogQuery);
    
    LoginLogVO entityToVO(LoginLog loginLog);
    
}
