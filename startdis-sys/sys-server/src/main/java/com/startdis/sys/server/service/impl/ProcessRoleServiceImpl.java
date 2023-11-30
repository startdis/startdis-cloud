package com.startdis.sys.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.startdis.sys.domain.model.entity.ProcessRole;
import com.startdis.sys.infra.mapper.ProcessRoleMapper;
import com.startdis.sys.server.service.ProcessRoleService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 流程角色表(ProcessRole)服务实现层
 */
@Service("processRoleService")
public class ProcessRoleServiceImpl extends ServiceImpl<ProcessRoleMapper, ProcessRole> implements ProcessRoleService {

    @Override
    public String getUserIdByDeptAndRoldCode(String deptId, String roleCode) {
        return this.baseMapper.getUserIdByDeptAndRoldCode(deptId,roleCode);
    }
}

