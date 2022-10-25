package com.startdis.common.log.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.startdis.common.log.entity.SystemLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 系统日志表 Mapper 接口
 * </p>
 *
 * @author 点九
 * @since 2022-07-19
 */
@Mapper
public interface SystemLogMapper extends BaseMapper<SystemLog> {

}
