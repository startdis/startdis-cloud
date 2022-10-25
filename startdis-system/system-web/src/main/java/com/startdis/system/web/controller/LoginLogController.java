package com.startdis.system.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.common.domain.bean.PagerBean;
import com.startdis.common.domain.bean.ResultBean;
import com.startdis.common.domain.model.PageQuery;
import com.startdis.common.util.bean.BeanCopyUtils;
import com.startdis.system.domain.model.dto.LoginLogPostDTO;
import com.startdis.system.domain.model.dto.LoginLogPutDTO;
import com.startdis.system.domain.model.entity.LoginLog;
import com.startdis.system.domain.model.query.LoginLogQuery;
import com.startdis.system.domain.model.vo.LoginLogVO;
import com.startdis.system.server.service.LoginLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 系统登录日志(LoginLog)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "LoginLog", tags = {"系统登录日志"})
@RequestMapping("loginLog")
public class LoginLogController {
    
    /**
     * 服务对象
     */
    @Resource
    private LoginLogService loginLogService;
    
    
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("查询单条")
    public ResultBean<LoginLogVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        LoginLogVO loginLogVO = new LoginLogVO();
        LoginLog loginLog = loginLogService.getById(id);
        BeanUtils.copyProperties(loginLog, loginLogVO);
        return ResultBean.success(loginLogVO);
    }
    
    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param loginLogQuery 实例对象
     * @return 对象列表
     */
    @GetMapping(value = "/list")
    @ApiOperation("查询所有")
    public ResultBean<List<LoginLogVO>> list(LoginLogQuery loginLogQuery) {
        //处理查询条件
        LoginLog loginLog = new LoginLog();
        BeanUtils.copyProperties(loginLogQuery, loginLog);
        //执行分页查询
        List<LoginLog> listResult = loginLogService.list(new QueryWrapper<>(loginLog));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, LoginLogVO.class));
    }
    
    /**
     * 分页查询所有数据
     *
     * @param pageQuery     分页对象
     * @param loginLogQuery 查询实体
     * @return 分页对象
     */
    @GetMapping(value = "/page")
    @ApiOperation("分页查询")
    public ResultBean<PagerBean<LoginLogVO>> page(PageQuery pageQuery, LoginLogQuery loginLogQuery) {
        //处理分页条件
        Page<LoginLog> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理查询条件
        LoginLog loginLog = new LoginLog();
        BeanUtils.copyProperties(loginLogQuery, loginLog);
        //执行分页查询
        Page<LoginLog> pageResult = loginLogService.page(page, new QueryWrapper<>(loginLog));
        PagerBean<LoginLogVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), LoginLogVO.class));
        return ResultBean.success(pageBean);
    }
    
    /**
     * 新增数据
     *
     * @param loginLogDTO 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation("新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated LoginLogPostDTO loginLogDTO) {
        LoginLog loginLog = new LoginLog();
        BeanUtils.copyProperties(loginLogDTO, loginLog);
        return ResultBean.success(loginLogService.save(loginLog));
    }
    
    /**
     * 修改数据
     *
     * @param loginLogDTO 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated LoginLogPutDTO loginLogDTO) {
        LoginLog loginLog = new LoginLog();
        BeanUtils.copyProperties(loginLogDTO, loginLog);
        return ResultBean.success(loginLogService.updateById(loginLog));
    }
    
    /**
     * 删除数据
     *
     * @param ids 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    @ApiOperation("删除数据")
    public ResultBean<Boolean> delete(@RequestParam("ids") List<String> ids) {
        return ResultBean.success(loginLogService.removeByIds(ids));
    }
    
}

