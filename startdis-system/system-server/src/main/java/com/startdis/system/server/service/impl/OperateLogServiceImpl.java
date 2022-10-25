package com.startdis.system.server.service.impl;

import com.startdis.system.domain.model.entity.OperateLog;
import com.startdis.system.infra.mapper.OperateLogMapper;
import com.startdis.system.server.service.OperateLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志记录表 服务实现类
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Service
public class OperateLogServiceImpl extends ServiceImpl<OperateLogMapper, OperateLog> implements OperateLogService {

}
