package com.startdis.system.server.service.impl;

import com.startdis.system.domain.model.entity.DictItem;
import com.startdis.system.infra.mapper.DictItemMapper;
import com.startdis.system.server.service.DictItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 字典数据表 服务实现类
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Service
public class DictItemServiceImpl extends ServiceImpl<DictItemMapper, DictItem> implements DictItemService {

}
