package com.startdis.sys.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.startdis.sys.domain.model.entity.Variable;
import com.startdis.sys.domain.model.query.VariableQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 全局变量表(Variable)数据层
 */
@Mapper
public interface VariableMapper extends BaseMapper<Variable> {

    List<Variable> search(@Param("variableQuery") VariableQuery variableQuery);
}
