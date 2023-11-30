package com.startdis.sys.api.fallback;

import com.startdis.comm.domain.bean.PagerBean;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.domain.model.UserPassWordDto;
import com.startdis.sys.api.service.SysServiceApi;
import com.startdis.sys.domain.model.entity.FileInfo;
import com.startdis.sys.domain.model.entity.Menu;
import com.startdis.sys.domain.model.query.CompanyQuery;
import com.startdis.sys.domain.model.query.DeptQuery;
import com.startdis.sys.domain.model.query.UserMenuTreeQuery;
import com.startdis.sys.domain.model.query.UserQuery;
import com.startdis.sys.domain.model.tree.CompanyTree;
import com.startdis.sys.domain.model.tree.DeptTree;
import com.startdis.sys.domain.model.tree.MenuTree;
import com.startdis.sys.domain.model.vo.CompanyVO;
import com.startdis.sys.domain.model.vo.DeptVO;
import com.startdis.sys.domain.model.vo.UserTokenVO;
import com.startdis.sys.domain.model.vo.UserVO;
import feign.Response;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Slf4j
public class SysServiceFallback implements SysServiceApi {
    @Setter
    private Throwable cause;

    @Override
    public ResultBean<UserTokenVO> getUserInfoByUserCode(String userCode) {
        log.error("getUserInfoByUserCode = {}", cause.getMessage());
        return null;
    }

    @Override
    public String getUserIdByDeptAndRoldCode(String deptId, String roleCode) {
        log.error("getUserIdByDeptAndRoldCode = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean<List<DeptTree>> deptTree(DeptQuery deptQuery) {
        log.error("deptTree = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean<List<CompanyTree>> companyTree(CompanyQuery companyQuery) {
        log.error("companyTree = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean<PagerBean<UserVO>> userPage(Map<String, Object> map) {
        log.error("userPage = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean<List<CompanyVO>> companyList(CompanyQuery companyQuery) {
        log.error("companyList = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean<CompanyVO> getCompany(String id) {
        log.error("getCompany = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean<FileInfo> fileUpload(MultipartFile multipartFile) {
        log.error("fileUpload = {}", cause.getMessage());
        return null;
    }

    @Override
    public Response downloadFile(String objectName) {
        log.error("downloadFile = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean<List<UserVO>> list(UserQuery userQuery) {
        log.error("list = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean<UserVO> getUser(String id) {
        log.error("getUser = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean queryUserInfoByUserCode(List<String> userCodes) {
        log.error("queryUserInfoByUserCode = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean fileList(String fileName) {
        log.error("fileList = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean getFileById(String id) {
        log.error("getFileById = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean<List<DeptVO>> deptList(DeptQuery deptQuery) {
        log.error("deptList = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean<DeptVO> getDept(String id) {
        log.error("getDept = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean<List<UserVO>> getLeaderInChargeInPms() {
        log.error("getLeaderInChargeInPms = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean<UserVO> getProcessApproverInPms(Map<String, String> map) {
        log.error("getProcessApproverInPms = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean<DeptVO> getDeptByUser(String userId) {
        log.error("getDeptByUser = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean updateUserPassWord(UserPassWordDto userPassWordDto) {
        log.error("updateUserPassWord = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean<List<Menu>> getUserMenuTreeByAppCode(UserMenuTreeQuery userMenuTreeQuery) {
        log.error("getUserMenuTreeByAppCode = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean<String> getFileUrl(String objectName, Integer expires) {
        log.error("getFileUrl = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean<DeptVO> getDeptByUserCode(String userCode) {
        log.error("getDeptByUserCode = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean<CompanyVO> getCompanyInfoById(String companyTenantId) {
        log.error("getCompanyInfoById = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean<List<Menu>> getAllMenuByUser(String userCode) {
        log.error("getAllMenuByUser = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean<Boolean> userIsAdmin() {
        log.error("userIsAdmin = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean<Boolean> userIsWmsAdmin() {
        log.error("userIsWmsAdmin = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean<Boolean> userIsCommonAdmin() {
        log.error("userIsCommonAdmin = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean<List<DeptVO>> getLeaderDeptInPms() {
        log.error("getLeaderDeptInPms = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean<UserVO> getHeadUserByDeptInPms(Map<String, String> map) {
        log.error("getHeadUserByDeptInPms = {}", cause.getMessage());
        return null;
    }

    @Override
    public ResultBean<UserVO> getUserByIdInPms(Map<String, String> map) {
        log.error("getUserByIdInPms = {}", cause.getMessage());
        return null;
    }

}

