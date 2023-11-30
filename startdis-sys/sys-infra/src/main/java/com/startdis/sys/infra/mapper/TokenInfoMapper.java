package com.startdis.sys.infra.mapper;

import com.startdis.sys.domain.model.entity.TokenInfo;
import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 系统授权信息表(TokenInfo)数据层
 */
@Mapper
public interface TokenInfoMapper extends BaseMapper<TokenInfo> {

}
