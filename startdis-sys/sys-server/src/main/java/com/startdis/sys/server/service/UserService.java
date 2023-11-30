package com.startdis.sys.server.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.sys.domain.model.dto.post.UserPostDTO;
import com.startdis.sys.domain.model.dto.put.UserPutDTO;
import com.startdis.sys.domain.model.entity.User;
import com.startdis.sys.domain.model.query.UserQuery;
import com.startdis.sys.domain.model.vo.UserVO;

import java.util.List;
import java.util.Map;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 用户表 UserService
 */
public interface UserService extends IService<User> {

    void saveUserRelation(UserPostDTO userDTO, String userId);

    void updateUserRelation(UserPutDTO userDTO);

    void deleteUserRelation(List<String> ids);

    void assembleUserVO(UserVO userVO);

    List<UserVO> getLeaderInChargeInPms(String companyTenantId);
    List<UserVO> getCountryLeaderInChargeInPms(String companyTenantId);

    UserVO getProcessApproverInPms(String userId, String type, String companyTenantId);
    UserVO getProcessStartApproverInPms(String deptId, String type, String companyTenantId);

    List<UserVO> page(UserQuery userQuery);

    User getUserInfoByUserCode(String userCode);

    ResultBean<Boolean> userIsAdmin();

    ResultBean<UserVO> getHeadUserByDeptInPms(Map<String, String> map);

    ResultBean<UserVO> getUserByIdInPms(Map<String, String> map);

    ResultBean<Boolean> userIsWmsAdmin();

    ResultBean<Boolean> userIsCommonAdmin();
}
