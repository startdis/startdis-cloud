package com.startdis.sys.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.startdis.sys.domain.model.entity.UserDept;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 用户部门表(UserDept)数据层
 */
@Mapper
public interface UserDeptMapper extends BaseMapper<UserDept> {

}
