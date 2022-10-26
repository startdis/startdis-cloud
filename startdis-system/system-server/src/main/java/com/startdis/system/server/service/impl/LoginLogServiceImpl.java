package com.startdis.system.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.startdis.system.domain.model.entity.LoginLog;
import com.startdis.system.infra.mapper.LoginLogMapper;
import com.startdis.system.server.service.LoginLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统登录日志 服务实现类
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService {

}
