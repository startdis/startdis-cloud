package com.startdis.sys.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.startdis.sys.domain.model.entity.Variable;
import com.startdis.sys.domain.model.query.VariableQuery;
import com.startdis.sys.infra.mapper.VariableMapper;
import com.startdis.sys.server.service.VariableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 全局变量表(Variable)服务实现层
 */
@Service("variableService")
public class VariableServiceImpl extends ServiceImpl<VariableMapper, Variable> implements VariableService {

    @Autowired
    private VariableMapper variableMapper;

    @Override
    public List<Variable> search(VariableQuery variableQuery) {
        List<Variable> variableList = variableMapper.search(variableQuery);
        return variableList;
    }
}

