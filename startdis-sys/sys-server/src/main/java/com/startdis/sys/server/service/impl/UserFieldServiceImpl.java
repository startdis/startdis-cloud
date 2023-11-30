package com.startdis.sys.server.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.startdis.sys.domain.model.entity.UserField;
import com.startdis.sys.infra.mapper.UserFieldMapper;
import com.startdis.sys.server.service.UserFieldService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 用户字段表 UserFieldService
 */
@Service("userFieldService")
public class UserFieldServiceImpl extends ServiceImpl<UserFieldMapper, UserField> implements UserFieldService {

}
