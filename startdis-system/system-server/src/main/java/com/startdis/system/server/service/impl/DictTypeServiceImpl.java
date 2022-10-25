package com.startdis.system.server.service.impl;

import com.startdis.system.domain.model.entity.DictType;
import com.startdis.system.infra.mapper.DictTypeMapper;
import com.startdis.system.server.service.DictTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 字典类型表 服务实现类
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Service
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements DictTypeService {

}
