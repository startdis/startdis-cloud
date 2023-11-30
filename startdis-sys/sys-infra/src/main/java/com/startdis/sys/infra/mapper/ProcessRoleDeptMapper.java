package com.startdis.sys.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.startdis.sys.domain.model.entity.ProcessRoleDept;
import com.startdis.sys.domain.model.query.ProcessRoleDeptQuery;
import com.startdis.sys.domain.model.vo.ProcessRoleDeptVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 流程角色部门表(ProcessRoleDept)数据层
 */
@Mapper
public interface ProcessRoleDeptMapper extends BaseMapper<ProcessRoleDept> {

    List<ProcessRoleDeptVO> pageList(ProcessRoleDeptQuery processRoleDeptQuery);
}
