package com.startdis.sys.infra.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.startdis.sys.domain.model.entity.User;
import com.startdis.sys.domain.model.query.UserQuery;
import com.startdis.sys.domain.model.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 用户表 UserMapper
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 分页查询用户列表接口
     */
    List<UserVO> listPage(@Param("item") UserQuery userQuery);

    int countPage(@Param("item") UserQuery userQuery);

    List<UserVO> getUserInPms(@Param("companyTenantId") String companyTenantId);
    List<UserVO> getCountryUserInPms(@Param("companyTenantId") String companyTenantId);

    /**
     * 根据部门查询分管领导用户
     * @param deptIds
     * @return
     */
    List<UserVO> getLeaderUserByDeptInPms(@Param("deptIds") List<String> deptIds);

    UserVO getProcessApproverInPms(@Param("userId") String userId, @Param("type") String type, @Param("companyTenantId") String companyTenantId);
    UserVO getProcessStartApproverInPms(@Param("deptId") String deptId, @Param("type") String type, @Param("companyTenantId") String companyTenantId);

    List<UserVO> page(UserQuery userQuery);

    UserVO getHeadUserByDeptInPms(@Param("deptId") String deptId);
}
