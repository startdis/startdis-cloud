package com.startdis.system.server.service.impl;

import com.startdis.system.domain.model.entity.SensitiveWord;
import com.startdis.system.infra.mapper.SensitiveWordMapper;
import com.startdis.system.server.service.SensitiveWordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统敏感词表 服务实现类
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Service
public class SensitiveWordServiceImpl extends ServiceImpl<SensitiveWordMapper, SensitiveWord> implements SensitiveWordService {

}
