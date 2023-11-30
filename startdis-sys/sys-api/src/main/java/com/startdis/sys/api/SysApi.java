package com.startdis.sys.api;

import com.startdis.comm.domain.bean.PagerBean;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.domain.model.UserPassWordDto;
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
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

public interface SysApi {

    /**
     * 通过userCode查询用户信息
     *
     * @param userCode 用户编码
     * @return 用户数据集合
     */
    @PostMapping("/user/getUserInfoByUserCode")
    public ResultBean<UserTokenVO> getUserInfoByUserCode(@RequestParam("userCode") String userCode);

    @GetMapping("processRole/getUserIdByDeptAndRoldCode")
    String getUserIdByDeptAndRoldCode(@RequestParam("deptId") String deptId, @RequestParam("roleCode") String roleCode);

    @PostMapping("dept/tree")
    ResultBean<List<DeptTree>> deptTree(@RequestBody DeptQuery deptQuery);

    @PostMapping("company/tree")
    ResultBean<List<CompanyTree>> companyTree(@RequestBody CompanyQuery companyQuery);

    @PostMapping("user/srsUserPage")
    ResultBean<PagerBean<UserVO>> userPage(@RequestBody Map<String, Object> map);

    @PostMapping("company/list")
    ResultBean<List<CompanyVO>> companyList(@RequestBody CompanyQuery companyQuery);

    @GetMapping("company/{id}")
    public ResultBean<CompanyVO> getCompany(@PathVariable(value = "id") @Validated @NotBlank(message = "ID不能为空") String id);

    @PostMapping(value = "file/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResultBean<FileInfo> fileUpload(@RequestPart(name = "multipartFile") MultipartFile multipartFile);

    @GetMapping(value = "file/download", consumes = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
    Response downloadFile(@RequestParam("objectName") String objectName);
    @PostMapping("user/list")
    ResultBean<List<UserVO>> list(@RequestBody UserQuery userQuery);

    @GetMapping("user/{id}")
    public ResultBean<UserVO> getUser(@PathVariable(value = "id") @Validated @NotBlank(message = "ID不能为空") String id);

    //通过userCode查询单条数据
    @PostMapping("user/queryUserInfoByUserCode")
    ResultBean queryUserInfoByUserCode(@RequestParam(value = "userCodes", required = false) List<String> userCodes);

    @GetMapping("file/fileList")
    ResultBean fileList(@RequestParam(value = "fileName", required = false) String fileName);

    @GetMapping("file/getFileById")
    ResultBean getFileById(@RequestParam("id") String id);

    @PostMapping(value = "dept/list")
    ResultBean<List<DeptVO>> deptList(@RequestBody DeptQuery deptQuery);

    @GetMapping(value = "dept/{id}")
    ResultBean<DeptVO> getDept(@PathVariable(value = "id") @Validated @NotBlank(message = "ID不能为空") String id);

    @PostMapping(value = "user/getLeaderInChargeInPms")
    ResultBean<List<UserVO>> getLeaderInChargeInPms();

    @PostMapping(value = "user/getProcessApproverInPms")
    ResultBean<UserVO> getProcessApproverInPms(@RequestBody Map<String, String> map);

    @PostMapping(value = "dept/getDeptByUser")
    ResultBean<DeptVO> getDeptByUser(@RequestParam("userId") String userId);

    @PostMapping("user/updateUserPassWord")
    ResultBean updateUserPassWord(@RequestBody UserPassWordDto userPassWordDto);

    /**
     * 查询用户应用菜单
     * @param userMenuTreeQuery
     * @return
     */
    @PostMapping("menu/getUserMenuTreeByAppCode")
    ResultBean<List<Menu>> getUserMenuTreeByAppCode(@RequestBody UserMenuTreeQuery userMenuTreeQuery);

    @GetMapping("file/share")
    ResultBean<String>  getFileUrl(@RequestParam("objectName") String objectName,@RequestParam("expires") Integer expires);

    @GetMapping(value = "dept/getDeptByUserCode")
    ResultBean<DeptVO> getDeptByUserCode(@RequestParam("userCode") String userCode);

    @GetMapping("company/getCompanyInfoById")
    ResultBean<CompanyVO> getCompanyInfoById(@RequestParam("companyTenantId") String companyTenantId);

    @GetMapping("menu/getAllMenuByUser")
    ResultBean<List<Menu>> getAllMenuByUser(@RequestParam("userCode") String userCode);

    @GetMapping("user/userIsAdmin")
    ResultBean<Boolean> userIsAdmin();

    @GetMapping("user/userIsWmsAdmin")
    ResultBean<Boolean> userIsWmsAdmin();

    @GetMapping("user/userIsCommonAdmin")
    ResultBean<Boolean> userIsCommonAdmin();

    @GetMapping(value = "dept/getLeaderDeptInPms")
    ResultBean<List<DeptVO>> getLeaderDeptInPms();

    @PostMapping(value = "user/getHeadUserByDeptInPms")
    ResultBean<UserVO> getHeadUserByDeptInPms(@RequestBody Map<String, String> map);

    @PostMapping(value = "user/getUserByIdInPms")
    ResultBean<UserVO> getUserByIdInPms(@RequestBody Map<String, String> map);
}
