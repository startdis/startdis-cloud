package com.startdis.sys.infra.mapper;

import com.startdis.sys.domain.model.entity.ProcessRole;
import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 流程角色表(ProcessRole)数据层
 */
@Mapper
public interface ProcessRoleMapper extends BaseMapper<ProcessRole> {

    String getUserIdByDeptAndRoldCode(@Param("deptId") String deptId,@Param("roleCode") String roleCode);
}
