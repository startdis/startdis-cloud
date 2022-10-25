package com.startdis.system.server.service.impl;

import com.startdis.system.domain.model.entity.CompanyPost;
import com.startdis.system.infra.mapper.CompanyPostMapper;
import com.startdis.system.server.service.CompanyPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 公司岗位表 服务实现类
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Service
public class CompanyPostServiceImpl extends ServiceImpl<CompanyPostMapper, CompanyPost> implements CompanyPostService {

}
