package com.startdis.system.infra.mapper;

import com.startdis.system.domain.model.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户角色中间表 Mapper 接口
 * </p>
 *
 * @author Startdis
 * @since 2022-10-21
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

}
