package com.startdis.sys.server.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.startdis.sys.domain.model.entity.OperateLog;
import com.startdis.sys.infra.mapper.OperateLogMapper;
import com.startdis.sys.server.service.OperateLogService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 操作日志记录表 OperateLogService
 */
@Service("operateLogService")
public class OperateLogServiceImpl extends ServiceImpl<OperateLogMapper, OperateLog> implements OperateLogService {

}
