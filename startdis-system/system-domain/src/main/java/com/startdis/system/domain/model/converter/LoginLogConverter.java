package com.startdis.system.domain.model.converter;


import com.startdis.system.domain.model.dto.LoginLogPostDTO;
import com.startdis.system.domain.model.dto.LoginLogPutDTO;
import com.startdis.system.domain.model.entity.LoginLog;
import com.startdis.system.domain.model.query.LoginLogQuery;
import com.startdis.system.domain.model.vo.LoginLogVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 系统登录日志 LoginLogConverter转换接口
 */
@Mapper
public interface LoginLogConverter {
    
    LoginLogConverter INSTANT = Mappers.getMapper(LoginLogConverter.class);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    LoginLog postDtoToEntity(LoginLogPostDTO loginLogDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    LoginLog putDtoToEntity(LoginLogPutDTO loginLogDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    LoginLog queryToEntity(LoginLogQuery loginLogQuery);
    
    LoginLogVO entityToVO(LoginLog loginLog);
    
}
