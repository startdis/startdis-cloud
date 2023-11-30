package com.startdis.sys.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.startdis.sys.domain.model.entity.Notice;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 通知公告表(Notice)数据层
 */
@Mapper
public interface NoticeMapper extends BaseMapper<Notice> {

}
