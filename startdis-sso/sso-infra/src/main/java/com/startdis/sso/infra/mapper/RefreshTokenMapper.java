package com.startdis.sso.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.startdis.sso.domain.model.entity.RefreshToken;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 刷新令牌表(RefreshToken)数据层
 */
@Mapper
public interface RefreshTokenMapper extends BaseMapper<RefreshToken> {

}
