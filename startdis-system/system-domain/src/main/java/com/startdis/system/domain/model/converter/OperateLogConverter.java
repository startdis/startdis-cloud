package com.startdis.system.domain.model.converter;


import com.startdis.system.domain.model.dto.OperateLogPostDTO;
import com.startdis.system.domain.model.dto.OperateLogPutDTO;
import com.startdis.system.domain.model.entity.OperateLog;
import com.startdis.system.domain.model.query.OperateLogQuery;
import com.startdis.system.domain.model.vo.OperateLogVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 操作日志记录表 OperateLogConverter转换接口
 */
@Mapper
public interface OperateLogConverter {
    
    OperateLogConverter INSTANT = Mappers.getMapper(OperateLogConverter.class);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    OperateLog postDtoToEntity(OperateLogPostDTO operateLogDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    OperateLog putDtoToEntity(OperateLogPutDTO operateLogDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "tenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    OperateLog queryToEntity(OperateLogQuery operateLogQuery);
    
    OperateLogVO entityToVO(OperateLog operateLog);
    
}
