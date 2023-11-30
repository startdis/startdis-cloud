package com.startdis.sys.server.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.startdis.sys.domain.model.entity.LoginLog;
import com.startdis.sys.infra.mapper.LoginLogMapper;
import com.startdis.sys.server.service.LoginLogService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 系统登录日志 LoginLogService
 */
@Service("loginLogService")
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService {

}
