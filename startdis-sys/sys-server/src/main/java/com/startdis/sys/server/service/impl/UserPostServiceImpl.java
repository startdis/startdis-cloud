package com.startdis.sys.server.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.startdis.sys.domain.model.entity.UserPost;
import com.startdis.sys.infra.mapper.UserPostMapper;
import com.startdis.sys.server.service.UserPostService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 用户岗位表 UserPostService
 */
@Service("userPostService")
public class UserPostServiceImpl extends ServiceImpl<UserPostMapper, UserPost> implements UserPostService {

}
