package com.startdis.sys.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.startdis.sys.domain.model.entity.Title;
import com.startdis.sys.infra.mapper.TitleMapper;
import com.startdis.sys.server.service.TitleService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 职位表(Title)服务实现层
 */
@Service("titleService")
public class TitleServiceImpl extends ServiceImpl<TitleMapper, Title> implements TitleService {

}

