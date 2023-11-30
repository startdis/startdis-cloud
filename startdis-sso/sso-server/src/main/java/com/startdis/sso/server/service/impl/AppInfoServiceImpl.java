package com.startdis.sso.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.startdis.sso.domain.model.entity.AppInfo;
import com.startdis.sso.infra.mapper.AppInfoMapper;
import com.startdis.sso.server.service.AppInfoService;
import org.springframework.stereotype.Service;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 应用中心表(AppInfo)服务实现层
 */
@Service("appInfoService")
public class AppInfoServiceImpl extends ServiceImpl<AppInfoMapper, AppInfo> implements AppInfoService {

}

