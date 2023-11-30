package com.startdis.sys.infra.mapper;


import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.startdis.sys.domain.model.entity.Dict;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 字典主表 DictMapper
 */
@Mapper
public interface DictMapper extends BaseMapper<Dict> {
    
    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Dict> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Dict> entities);
    
    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Dict> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Dict> entities);
    
}
