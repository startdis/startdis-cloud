package com.startdis.sys.web.controller;


import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.comm.auth.annotation.RbacPermission;
import com.startdis.comm.core.constant.Constants;
import com.startdis.comm.domain.bean.PagerBean;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.domain.model.PageQuery;
import com.startdis.comm.domain.model.UserPassWordDto;
import com.startdis.comm.exception.custom.BusinessException;
import com.startdis.comm.util.auth.AuthInfoUtils;
import com.startdis.comm.util.bean.BeanCopyKits;
import com.startdis.comm.util.config.SnowflakeConfig;
import com.startdis.comm.util.id.SnowflakeIDUtils;
import com.startdis.comm.util.security.PwdKits;
import com.startdis.comm.util.string.StringKits;
import com.startdis.sys.domain.model.converter.UserConverter;
import com.startdis.sys.domain.model.dto.post.UserPostDTO;
import com.startdis.sys.domain.model.dto.put.UserPutDTO;
import com.startdis.sys.domain.model.entity.Dept;
import com.startdis.sys.domain.model.entity.User;
import com.startdis.sys.domain.model.query.UserQuery;
import com.startdis.sys.domain.model.vo.MenuVO;
import com.startdis.sys.domain.model.vo.UserTokenVO;
import com.startdis.sys.domain.model.vo.UserVO;
import com.startdis.sys.server.service.DeptService;
import com.startdis.sys.server.service.RoleMenuService;
import com.startdis.sys.server.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 用户表(User)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "User", tags = {"用户表"})
@RequestMapping("/user")
public class UserController {

    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @Resource
    private RoleMenuService roleMenuService;

    @Resource
    private DeptService deptService;

    /**
     * 雪花ID生成
     */
    @Resource
    private SnowflakeConfig snowflakeConfig;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("查询单条")
    @RbacPermission
    public ResultBean<UserVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        User user = userService.getById(id);
        //处理格式转换
        UserVO userVO = UserConverter.INSTANT.entityToVO(user);
        //组装用户信息
        userService.assembleUserVO(userVO);
        return ResultBean.success(userVO);
    }

    /**
     * 通过userCode查询单条数据
     *
     * @param userCode 用户编码
     * @return 用户数据集合
     */
    @PostMapping("/getUserInfoByUserCode")
    @ApiOperation("通过userCode查询用户信息")
    public ResultBean<UserTokenVO> getUserInfoByUserCode(@RequestParam("userCode") String userCode) {
        UserTokenVO userTokenVO = new UserTokenVO();
        User user = userService.getUserInfoByUserCode(userCode);
        //处理格式转换
        UserVO userVO = UserConverter.INSTANT.entityToVO(user);
        //组装用户信息
        userService.assembleUserVO(userVO);
        userTokenVO.setUser(userVO);
        // 组织应用信息
        // 组装菜单信息
        List<MenuVO> menuVOS = roleMenuService.listAuthMenu(userVO.getRoleId());
        userTokenVO.setMenus(menuVOS);
        return ResultBean.success(userTokenVO);
    }

    /**
     * 通过userCode查询单条数据
     *
     * @param userCodes userCodes
     * @return 用户数据集合
     */
    @PostMapping("/queryUserInfoByUserCode")
    @ApiOperation("通过userCode查询单条数据")
    public ResultBean queryUserInfoByUserCode(@RequestParam(value = "userCodes", required = false) List<String> userCodes) {
        List<User> users = null;
        if (CollectionUtils.isNotEmpty(userCodes)) {
//            users = userService.getBaseMapper().selectBatchIds(userCodes);
            users = userService.getBaseMapper().selectList(Wrappers.<User>lambdaQuery().in(User::getUserCode, userCodes));
        }
        return ResultBean.success(users);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param userQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @ApiOperation("查询所有")
    @RbacPermission
    public ResultBean<List<UserVO>> list(@RequestBody UserQuery userQuery) {
        //处理格式转换
        User user = UserConverter.INSTANT.queryToEntity(userQuery);
        //执行分页查询
        List<User> listResult = userService.list(new QueryWrapper<>(user));
        List<UserVO> userVOS = BeanCopyKits.coverList(listResult, UserVO.class);
        //组装用户中间表信息
        for (UserVO userVO : userVOS) {
            userService.assembleUserVO(userVO);
        }
        return ResultBean.success(userVOS);
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery 分页对象
     * @param userQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @ApiOperation("分页查询")
    @RbacPermission
    public ResultBean<PagerBean<UserVO>> page(PageQuery pageQuery, UserQuery userQuery) {
        //处理分页条件
        Page<Object> page = PageHelper.startPage(pageQuery.getPageNum(), pageQuery.getPageSize());
        //执行分页查询
        List<UserVO> users = userService.page(userQuery);
        PageHelper.clearPage();
        PagerBean<UserVO> pageBean = new PagerBean<>(page.getTotal(), Long.valueOf(pageQuery.getPageNum()), Long.valueOf(pageQuery.getPageSize()),
                BeanCopyKits.coverList(users, UserVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param userDTO 实体对象
     * @return 新增结果 用户关系表
     */
    @PostMapping("/add")
    @ApiOperation("新增数据")
    @RbacPermission
    @Transactional(rollbackFor = Exception.class, transactionManager = "transactionManager")
    public ResultBean<Boolean> insert(@RequestBody @Validated UserPostDTO userDTO) {
        //处理格式转换
        User user = UserConverter.INSTANT.postDtoToEntity(userDTO);
        checkExist(user);
        //保存用户数据
        if (StringKits.isBlank(userDTO.getPassword())) {
            user.setPassword(PwdKits.getDefaultPassEncryption());
        }
        if (StringKits.isNotBlank(userDTO.getPassword())) {
            user.setPassword(PwdKits.encode(userDTO.getPassword()));
        }
        //保存用户数据
        String userId = SnowflakeIDUtils.getInstance().nextIdStr();
        user.setId(userId);
        user.setId(userId);
        userService.save(user);
        //保存用户中间表数据
        userService.saveUserRelation(userDTO, userId);
        return ResultBean.success("新增数据成功！");
    }

    /**
     * 修改数据
     *
     * @param userDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @ApiOperation("修改数据")
    @RbacPermission
    @Transactional(rollbackFor = Exception.class, transactionManager = "transactionManager")
    public ResultBean<Boolean> update(@RequestBody @Validated UserPutDTO userDTO) {
        //处理格式转换
        User user = UserConverter.INSTANT.putDtoToEntity(userDTO);
        checkExist(user);
//        user.setPassword(PwdKits.encode(userDTO.getPassword()));
        user.setUpdatedAt(LocalDateTime.now());
        //执行数据更新
        userService.updateById(user);
        //更新用户中间表数据
        userService.updateUserRelation(userDTO);
        return ResultBean.success("更新数据成功！");
    }

    /**
     * 删除数据
     *
     * @param ids 主键结合
     * @return 删除结果
     */
    @DeleteMapping("/delete")
    @ApiOperation("删除数据")
    @RbacPermission
    @Transactional(rollbackFor = Exception.class, transactionManager = "transactionManager")
    public ResultBean<Boolean> delete(@RequestParam("ids") List<String> ids) {
        //删除用户信息
        userService.removeByIds(ids);
        //删除用户中间表数据
        userService.deleteUserRelation(ids);
        return ResultBean.success("删除数据成功！");
    }

    /**
     * 查询电商采购项目管理部门分管领导下拉列表
     *
     * @return 对象列表
     */
    @PostMapping(value = "/getLeaderInChargeInPms")
    @ApiOperation("查询电商采购项目管理部门分管领导下拉列表")
    public ResultBean<List<UserVO>> getLeaderInChargeInPms() {
        String companyTenantId = AuthInfoUtils.getCompanyTenantId();
        //执行查询
        List<UserVO> userVOS = new ArrayList<>();
        if (Constants.SYS_COMPANY_ID.equals(companyTenantId)) {
            userVOS = userService.getLeaderInChargeInPms(companyTenantId);
        } else {
            userVOS = userService.getCountryLeaderInChargeInPms(companyTenantId);
        }

        //组装用户中间表信息
        for (UserVO userVO : userVOS) {
            userService.assembleUserVO(userVO);
        }
        return ResultBean.success(userVOS);
    }

    /**
     * 查询电商采购下一步审核人或发起人
     * type:12 查市公司专职 13 查县公司经办人 14 县公司负责人   20 、24、26 县公司需求部门负责人
     *
     * @return 对象列表
     */
    @PostMapping(value = "/getProcessApproverInPms")
    @ApiOperation("查询电商采购下一步审核人或发起人")
    public ResultBean<UserVO> getProcessApproverInPms(@RequestBody Map<String, String> map) {
        String companyTenantId = AuthInfoUtils.getCompanyTenantId();
        String userId = map.get("userId");
        String type = map.get("type");
        String deptId = map.get("deptId");
        UserVO userVO = null;
        //执行查询
        if (Integer.valueOf(type) == 20 || Integer.valueOf(type) == 24 || Integer.valueOf(type) == 26) {
            //由于同个公司下项目需求部门负责人会有多个，因此还需要根据部门去查
            userVO = userService.getProcessStartApproverInPms(deptId, type, companyTenantId);
        } else {
            userVO = userService.getProcessApproverInPms(userId, type, companyTenantId);
        }
        //组装用户信息
        userService.assembleUserVO(userVO);
        return ResultBean.success(userVO);
    }

    @PostMapping(value = "/srsUserPage")
    @ApiOperation("srs查询用户分页接口")
    @RbacPermission
    public ResultBean<PagerBean<UserVO>> page(@RequestBody Map<String, Object> map) {
        Object pageQueryObject = map.get("pageQuery");
        PageQuery pageQuery = JSONObject.parseObject(JSON.toJSONString(pageQueryObject), PageQuery.class);
        Object userQueryObject = map.get("userQuery");
        UserQuery userQuery = JSONObject.parseObject(JSON.toJSONString(userQueryObject), UserQuery.class);
        //处理分页条件
        Page<Object> page = PageHelper.startPage(pageQuery.getPageNum(), pageQuery.getPageSize());
        //执行分页查询
        List<UserVO> users = userService.page(userQuery);
        PageHelper.clearPage();
        PagerBean<UserVO> pageBean = new PagerBean<>(page.getTotal(), Long.valueOf(pageQuery.getPageNum()), Long.valueOf(pageQuery.getPageSize()),
                BeanCopyKits.coverList(users, UserVO.class));
        return ResultBean.success(pageBean);
    }

    @ApiOperation("修改用户密码")
    @PostMapping("/updateUserPassWord")
    @RbacPermission
    public ResultBean updateUserPassWord(@RequestBody UserPassWordDto userPassWordDto) {
        String userCode = userPassWordDto.getUserCode();
        User user = userService.getBaseMapper().selectOne(Wrappers.<User>lambdaQuery().eq(User::getUserCode, userCode));
        if (Objects.isNull(user)) {
            return ResultBean.error("用户不存在!");
        }
        String oldPassWord = PwdKits.encode(userPassWordDto.getOldPassWord());
        if (!oldPassWord.equals(user.getPassword())) {
            return ResultBean.error("输入的旧密码不正确!");
        }
        if (!userPassWordDto.getNewPassWord().equals(userPassWordDto.getAgainPassWord())) {
            return ResultBean.error("两次输入的新密码不正确!");
        }
        String newPassWord = PwdKits.encode(userPassWordDto.getNewPassWord());
        user.setPassword(newPassWord);
        userService.updateById(user);
        return ResultBean.success("修改成功!");
    }

    @GetMapping(value = "/userIsAdmin")
    @ApiOperation("srs查询用户是否为管理员")
    @RbacPermission
    public ResultBean<Boolean> userIsAdmin() {
        return userService.userIsAdmin();
    }

    @GetMapping(value = "/userIsWmsAdmin")
    @ApiOperation("wms查询用户是否为管理员")
    @RbacPermission
    public ResultBean<Boolean> userIsWmsAdmin() {
        return userService.userIsWmsAdmin();
    }

    @GetMapping(value = "/userIsCommonAdmin")
    @ApiOperation("查询用户是否为管理员-通用")
    @RbacPermission
    public ResultBean<Boolean> userIsCommonAdmin() {
        return userService.userIsCommonAdmin();
    }

    private void checkExist(User user) {
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery(User.class)
                .and(temp -> temp.eq(User::getUserCode, user.getUserCode()));
        if (StringUtils.isNotEmpty(user.getId())) {
            wrapper.ne(User::getId, user.getId());
        }
        List<User> list = userService.list(wrapper);
        if (CollectionUtil.isNotEmpty(list)) {
            throw new BusinessException("A0001", "用户编码已存在，请勿重复添加！");
        }
    }

    @PostMapping(value = "/getHeadUserByDeptInPms")
    @ApiOperation("根据部门Id或者部门Code查询电商采购负责人")
    public ResultBean<UserVO> getHeadUserByDeptInPms(@RequestBody Map<String, String> map){
        return userService.getHeadUserByDeptInPms(map);
    }

    @PostMapping(value = "/getUserByIdInPms")
    @ApiOperation("根据用户Id查询电商采购用户信息")
    public ResultBean<UserVO> getUserByIdInPms(@RequestBody Map<String, String> map){
        return userService.getUserByIdInPms(map);
    }
}

