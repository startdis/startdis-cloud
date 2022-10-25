package com.startdis.system.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.common.domain.bean.PagerBean;
import com.startdis.common.domain.bean.ResultBean;
import com.startdis.common.domain.model.PageQuery;
import com.startdis.common.util.bean.BeanCopyUtils;
import com.startdis.system.domain.model.dto.OperateLogPostDTO;
import com.startdis.system.domain.model.dto.OperateLogPutDTO;
import com.startdis.system.domain.model.entity.OperateLog;
import com.startdis.system.domain.model.query.OperateLogQuery;
import com.startdis.system.domain.model.vo.OperateLogVO;
import com.startdis.system.server.service.OperateLogService;
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
 * @desc 操作日志记录表(OperateLog)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "OperateLog", tags = {"操作日志记录表"})
@RequestMapping("operateLog")
public class OperateLogController {
    
    /**
     * 服务对象
     */
    @Resource
    private OperateLogService operateLogService;
    
    
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("查询单条")
    public ResultBean<OperateLogVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        OperateLogVO operateLogVO = new OperateLogVO();
        OperateLog operateLog = operateLogService.getById(id);
        BeanUtils.copyProperties(operateLog, operateLogVO);
        return ResultBean.success(operateLogVO);
    }
    
    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param operateLogQuery 实例对象
     * @return 对象列表
     */
    @GetMapping(value = "/list")
    @ApiOperation("查询所有")
    public ResultBean<List<OperateLogVO>> list(OperateLogQuery operateLogQuery) {
        //处理查询条件
        OperateLog operateLog = new OperateLog();
        BeanUtils.copyProperties(operateLogQuery, operateLog);
        //执行分页查询
        List<OperateLog> listResult = operateLogService.list(new QueryWrapper<>(operateLog));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, OperateLogVO.class));
    }
    
    /**
     * 分页查询所有数据
     *
     * @param pageQuery       分页对象
     * @param operateLogQuery 查询实体
     * @return 分页对象
     */
    @GetMapping(value = "/page")
    @ApiOperation("分页查询")
    public ResultBean<PagerBean<OperateLogVO>> page(PageQuery pageQuery, OperateLogQuery operateLogQuery) {
        //处理分页条件
        Page<OperateLog> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理查询条件
        OperateLog operateLog = new OperateLog();
        BeanUtils.copyProperties(operateLogQuery, operateLog);
        //执行分页查询
        Page<OperateLog> pageResult = operateLogService.page(page, new QueryWrapper<>(operateLog));
        PagerBean<OperateLogVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), OperateLogVO.class));
        return ResultBean.success(pageBean);
    }
    
    /**
     * 新增数据
     *
     * @param operateLogDTO 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ApiOperation("新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated OperateLogPostDTO operateLogDTO) {
        OperateLog operateLog = new OperateLog();
        BeanUtils.copyProperties(operateLogDTO, operateLog);
        return ResultBean.success(operateLogService.save(operateLog));
    }
    
    /**
     * 修改数据
     *
     * @param operateLogDTO 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated OperateLogPutDTO operateLogDTO) {
        OperateLog operateLog = new OperateLog();
        BeanUtils.copyProperties(operateLogDTO, operateLog);
        return ResultBean.success(operateLogService.updateById(operateLog));
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
        return ResultBean.success(operateLogService.removeByIds(ids));
    }
    
}

