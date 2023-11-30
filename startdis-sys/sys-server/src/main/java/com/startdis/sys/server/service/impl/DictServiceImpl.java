package com.startdis.sys.server.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.startdis.sys.domain.model.entity.Dict;
import com.startdis.sys.infra.mapper.DictMapper;
import com.startdis.sys.server.service.DictService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 字典主表 DictService
 */
@Service("dictService")
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

}
