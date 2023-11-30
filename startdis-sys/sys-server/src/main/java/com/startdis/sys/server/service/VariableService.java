package com.startdis.sys.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.startdis.sys.domain.model.entity.Variable;
import com.startdis.sys.domain.model.query.VariableQuery;

import java.util.List;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 全局变量表(Variable)服务定义层
 */
public interface VariableService extends IService<Variable> {

    List<Variable> search(VariableQuery variableQuery);
}
