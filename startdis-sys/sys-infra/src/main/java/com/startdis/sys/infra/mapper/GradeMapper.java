package com.startdis.sys.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.startdis.sys.domain.model.entity.Grade;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 职系表(Grade)数据层
 */
@Mapper
public interface GradeMapper extends BaseMapper<Grade> {

}
