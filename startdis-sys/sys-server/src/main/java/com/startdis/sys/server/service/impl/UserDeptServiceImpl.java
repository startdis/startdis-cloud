package com.startdis.sys.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.startdis.sys.domain.model.entity.UserDept;
import com.startdis.sys.infra.mapper.UserDeptMapper;
import com.startdis.sys.server.service.UserDeptService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 用户部门表(UserDept)服务实现层
 */
@Service("userDeptService")
public class UserDeptServiceImpl extends ServiceImpl<UserDeptMapper, UserDept> implements UserDeptService {

}

