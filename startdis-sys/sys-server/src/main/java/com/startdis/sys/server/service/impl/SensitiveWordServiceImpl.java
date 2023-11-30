package com.startdis.sys.server.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.startdis.sys.domain.model.entity.SensitiveWord;
import com.startdis.sys.infra.mapper.SensitiveWordMapper;
import com.startdis.sys.server.service.SensitiveWordService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 系统敏感词表 SensitiveWordService
 */
@Service("sensitiveWordService")
public class SensitiveWordServiceImpl extends ServiceImpl<SensitiveWordMapper, SensitiveWord>
        implements SensitiveWordService {
    
}
