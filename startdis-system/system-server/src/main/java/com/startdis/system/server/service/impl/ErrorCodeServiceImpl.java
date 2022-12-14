package com.startdis.system.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.startdis.system.domain.model.entity.ErrorCode;
import com.startdis.system.infra.mapper.ErrorCodeMapper;
import com.startdis.system.server.service.ErrorCodeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 错误码表 服务实现类
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Service
public class ErrorCodeServiceImpl extends ServiceImpl<ErrorCodeMapper, ErrorCode> implements ErrorCodeService {

}
