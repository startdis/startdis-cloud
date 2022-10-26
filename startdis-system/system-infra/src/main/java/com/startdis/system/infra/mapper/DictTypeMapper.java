package com.startdis.system.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.startdis.system.domain.model.entity.DictType;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 字典类型表 Mapper 接口
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Mapper
public interface DictTypeMapper extends BaseMapper<DictType> {

}
