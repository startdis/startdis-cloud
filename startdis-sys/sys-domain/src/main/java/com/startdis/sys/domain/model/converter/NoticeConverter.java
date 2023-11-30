package com.startdis.sys.domain.model.converter;


import com.startdis.sys.domain.model.dto.post.NoticePostDTO;
import com.startdis.sys.domain.model.dto.put.NoticePutDTO;
import com.startdis.sys.domain.model.entity.Notice;
import com.startdis.sys.domain.model.query.NoticeQuery;
import com.startdis.sys.domain.model.vo.NoticeVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**

 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 通知公告表 NoticeConverter转换接口
 */
@Mapper
public interface NoticeConverter {

    public static NoticeConverter INSTANT = Mappers.getMapper(NoticeConverter.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Notice postDtoToEntity(NoticePostDTO noticeDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Notice putDtoToEntity(NoticePutDTO noticeDTO);
    
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "revision", ignore = true)
    @Mapping(target = "groupTenantId", ignore = true)
    @Mapping(target = "companyTenantId", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Notice queryToEntity(NoticeQuery noticeQuery);
    
    NoticeVO entityToVO(Notice notice);
    
}
