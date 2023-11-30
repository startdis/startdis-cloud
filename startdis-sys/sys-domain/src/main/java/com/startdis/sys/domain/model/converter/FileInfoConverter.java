package com.startdis.sys.domain.model.converter;


import com.startdis.sys.domain.model.dto.post.FileInfoPostDTO;
import com.startdis.sys.domain.model.dto.put.FileInfoPutDTO;
import com.startdis.sys.domain.model.entity.FileInfo;
import com.startdis.sys.domain.model.query.FileInfoQuery;
import com.startdis.sys.domain.model.vo.FileInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 上传的文件信息表 FileInfoConverter转换接口
 */
@Mapper
public interface FileInfoConverter {

    FileInfoConverter INSTANT = Mappers.getMapper(FileInfoConverter.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    FileInfo postDtoToEntity(FileInfoPostDTO fileInfoDTO);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    FileInfo putDtoToEntity(FileInfoPutDTO fileInfoDTO);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    FileInfo queryToEntity(FileInfoQuery fileInfoQuery);

    FileInfoVO entityToVO(FileInfo fileInfo);

}
