package com.startdis.sys.server.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.startdis.sys.domain.model.entity.DictItem;
import com.startdis.sys.infra.mapper.DictItemMapper;
import com.startdis.sys.server.service.DictItemService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 字典项表 DictItemService
 */
@Service("dictItemService")
public class DictItemServiceImpl extends ServiceImpl<DictItemMapper, DictItem> implements DictItemService {

}
