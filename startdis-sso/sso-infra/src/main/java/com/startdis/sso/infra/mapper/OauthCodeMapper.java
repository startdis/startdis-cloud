package com.startdis.sso.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.startdis.sso.domain.model.entity.OauthCode;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 授权码表(OauthCode)数据层
 */
@Mapper
public interface OauthCodeMapper extends BaseMapper<OauthCode> {

}
