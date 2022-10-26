package com.startdis.system.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.startdis.system.domain.model.entity.Dept;
import com.startdis.system.infra.mapper.DeptMapper;
import com.startdis.system.server.service.DeptService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

}
