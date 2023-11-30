package com.startdis.sys.infra.mapper;

import com.startdis.sys.domain.model.entity.UserProcessRole;
import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 用户流程角色表(UserProcessRole)数据层
 */
@Mapper
public interface UserProcessRoleMapper extends BaseMapper<UserProcessRole> {

}
