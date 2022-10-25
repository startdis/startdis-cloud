package com.startdis.system.server.service.impl;

import com.startdis.system.domain.model.entity.DeptPost;
import com.startdis.system.infra.mapper.DeptPostMapper;
import com.startdis.system.server.service.DeptPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门岗位表 服务实现类
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Service
public class DeptPostServiceImpl extends ServiceImpl<DeptPostMapper, DeptPost> implements DeptPostService {

}
