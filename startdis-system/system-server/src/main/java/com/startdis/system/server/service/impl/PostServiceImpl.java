package com.startdis.system.server.service.impl;

import com.startdis.system.domain.model.entity.Post;
import com.startdis.system.infra.mapper.PostMapper;
import com.startdis.system.server.service.PostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 岗位表 服务实现类
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

}
