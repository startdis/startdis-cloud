package com.startdis.sys.domain.model.converter;


import com.startdis.sys.domain.model.dto.post.GradePostDTO;
import com.startdis.sys.domain.model.dto.put.GradePutDTO;
import com.startdis.sys.domain.model.entity.Grade;
import com.startdis.sys.domain.model.query.GradeQuery;
import com.startdis.sys.domain.model.vo.GradeVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 职系表 GradeConverter转换接口
 */
@Mapper
public interface GradeConverter {

    GradeConverter INSTANT = Mappers.getMapper(GradeConverter.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Grade postDtoToEntity(GradePostDTO gradeDTO);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Grade putDtoToEntity(GradePutDTO gradeDTO);

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Grade queryToEntity(GradeQuery gradeQuery);

    GradeVO entityToVO(Grade grade);

}
