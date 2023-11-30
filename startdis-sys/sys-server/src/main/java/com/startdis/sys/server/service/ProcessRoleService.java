package com.startdis.sys.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.startdis.sys.domain.model.entity.ProcessRole;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 流程角色表(ProcessRole)服务定义层
 */
public interface ProcessRoleService extends IService<ProcessRole> {

    String getUserIdByDeptAndRoldCode(String deptId, String roleCode);
}
