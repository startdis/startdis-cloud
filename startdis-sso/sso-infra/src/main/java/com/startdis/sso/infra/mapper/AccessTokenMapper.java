package com.startdis.sso.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.startdis.sso.domain.model.entity.AccessToken;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 鉴权令牌表(AccessToken)数据层
 */
@Mapper
public interface AccessTokenMapper extends BaseMapper<AccessToken> {

}
