package com.startdis.sys.infra.mapper;


import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.startdis.sys.domain.model.entity.LoginLog;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 系统登录日志 LoginLogMapper
 */
@Mapper
public interface LoginLogMapper extends BaseMapper<LoginLog> {
    
    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<LoginLog> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<LoginLog> entities);
    
    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<LoginLog> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<LoginLog> entities);
    
}
