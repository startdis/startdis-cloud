package com.startdis.system.server.service.impl;

import com.startdis.system.domain.model.entity.UserPost;
import com.startdis.system.infra.mapper.UserPostMapper;
import com.startdis.system.server.service.UserPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户岗位表 服务实现类
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Service
public class UserPostServiceImpl extends ServiceImpl<UserPostMapper, UserPost> implements UserPostService {

}
