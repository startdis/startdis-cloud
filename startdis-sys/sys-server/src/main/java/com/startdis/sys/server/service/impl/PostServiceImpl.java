package com.startdis.sys.server.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.startdis.sys.domain.model.entity.Post;
import com.startdis.sys.infra.mapper.PostMapper;
import com.startdis.sys.server.service.PostService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 岗位表 PostService
 */
@Service("postService")
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

}
