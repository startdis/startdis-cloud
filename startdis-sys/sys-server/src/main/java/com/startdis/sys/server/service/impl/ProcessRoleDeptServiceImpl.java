package com.startdis.sys.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.startdis.sys.domain.model.converter.ProcessRoleDeptConverter;
import com.startdis.sys.domain.model.entity.Dept;
import com.startdis.sys.domain.model.entity.ProcessRole;
import com.startdis.sys.domain.model.entity.ProcessRoleDept;
import com.startdis.sys.domain.model.query.ProcessRoleDeptQuery;
import com.startdis.sys.domain.model.vo.ProcessRoleDeptVO;
import com.startdis.sys.infra.mapper.ProcessRoleDeptMapper;
import com.startdis.sys.server.service.DeptService;
import com.startdis.sys.server.service.ProcessRoleDeptService;
import com.startdis.sys.server.service.ProcessRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 流程角色部门表(ProcessRoleDept)服务实现层
 */
@Service("processRoleDeptService")
public class ProcessRoleDeptServiceImpl extends ServiceImpl<ProcessRoleDeptMapper, ProcessRoleDept> implements ProcessRoleDeptService {

    @Resource
    private DeptService deptService;

    @Resource
    private ProcessRoleService processRoleService;

    @Override
    public ProcessRoleDeptVO getInfoById(String id) {
        ProcessRoleDept processRoleDept = this.getById(id);
        //处理格式转换
        ProcessRoleDeptVO processRoleDeptVO = ProcessRoleDeptConverter.INSTANT.entityToVO(processRoleDept);
        Dept dept = deptService.getById(processRoleDeptVO.getDeptId());
        processRoleDeptVO.setDeptName(dept.getDeptName());
        ProcessRole processRole = processRoleService.getById(processRoleDeptVO.getProcessRoleId());
        processRoleDeptVO.setProcessRoleName(processRole.getRoleName());
        return processRoleDeptVO;
    }

    @Override
    public List<ProcessRoleDeptVO> pageList(ProcessRoleDeptQuery processRoleDeptQuery) {
        return this.baseMapper.pageList(processRoleDeptQuery);
    }
}

