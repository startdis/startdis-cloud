package com.startdis.system.domain.model.converter;


import com.startdis.system.domain.model.dto.ErrorCodePostDTO;
import com.startdis.system.domain.model.dto.ErrorCodePutDTO;
import com.startdis.system.domain.model.entity.ErrorCode;
import com.startdis.system.domain.model.query.ErrorCodeQuery;
import com.startdis.system.domain.model.vo.ErrorCodeVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 错误码表 ErrorCodeConverter转换接口
 */
@Mapper
public interface ErrorCodeConverter {
    
    ErrorCodeConverter INSTANT = Mappers.getMapper(ErrorCodeConverter.class);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    ErrorCode postDtoToEntity(ErrorCodePostDTO errorCodeDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    ErrorCode putDtoToEntity(ErrorCodePutDTO errorCodeDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    ErrorCode queryToEntity(ErrorCodeQuery errorCodeQuery);
    
    ErrorCodeVO entityToVO(ErrorCode errorCode);
    
}
