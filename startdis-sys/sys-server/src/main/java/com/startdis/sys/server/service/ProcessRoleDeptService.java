package com.startdis.sys.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.startdis.sys.domain.model.entity.ProcessRoleDept;
import com.startdis.sys.domain.model.query.ProcessRoleDeptQuery;
import com.startdis.sys.domain.model.vo.ProcessRoleDeptVO;

import java.util.List;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 流程角色部门表(ProcessRoleDept)服务定义层
 */
public interface ProcessRoleDeptService extends IService<ProcessRoleDept> {

    ProcessRoleDeptVO getInfoById(String id);

    List<ProcessRoleDeptVO> pageList(ProcessRoleDeptQuery processRoleDeptQuery);
}
