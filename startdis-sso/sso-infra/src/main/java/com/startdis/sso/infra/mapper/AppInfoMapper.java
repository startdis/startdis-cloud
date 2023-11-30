package com.startdis.sso.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.startdis.sso.domain.model.entity.AppInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 应用中心表(AppInfo)数据层
 */
@Mapper
public interface AppInfoMapper extends BaseMapper<AppInfo> {

}
