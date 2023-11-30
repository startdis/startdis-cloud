package com.startdis.sys.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.startdis.sys.domain.model.entity.Title;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 职位表(Title)数据层
 */
@Mapper
public interface TitleMapper extends BaseMapper<Title> {

}
