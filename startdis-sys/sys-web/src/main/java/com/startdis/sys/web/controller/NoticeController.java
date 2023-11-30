package com.startdis.sys.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.startdis.comm.auth.annotation.RbacPermission;
import com.startdis.comm.domain.bean.PagerBean;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.domain.model.PageQuery;
import com.startdis.comm.util.bean.BeanCopyKits;
import com.startdis.sys.domain.model.converter.NoticeConverter;
import com.startdis.sys.domain.model.dto.post.NoticePostDTO;
import com.startdis.sys.domain.model.dto.put.NoticePutDTO;
import com.startdis.sys.domain.model.entity.Notice;
import com.startdis.sys.domain.model.query.NoticeQuery;
import com.startdis.sys.domain.model.vo.NoticeVO;
import com.startdis.sys.server.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
 * @email startdis@dianjiu.cc
 * @desc 通知公告表(Notice)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Api(value = "Notice", tags = {"通知公告表"})
@RequestMapping("notice")
public class NoticeController {

    /**
     * 服务对象
     */
    @Resource
    private NoticeService noticeService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("查询单条")
    @RbacPermission
    public ResultBean<NoticeVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        Notice notice = noticeService.getById(id);
        //处理格式转换
        NoticeVO noticeVO = NoticeConverter.INSTANT.entityToVO(notice);
        return ResultBean.success(noticeVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param noticeQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @ApiOperation("查询所有")
    @RbacPermission
    public ResultBean<List<NoticeVO>> list(@RequestBody NoticeQuery noticeQuery) {
        //处理格式转换
        Notice notice = NoticeConverter.INSTANT.queryToEntity(noticeQuery);
        //执行分页查询
        List<Notice> listResult = noticeService.list(new QueryWrapper<>(notice));
        return ResultBean.success(BeanCopyKits.coverList(listResult, NoticeVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery   分页对象
     * @param noticeQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @ApiOperation("分页查询")
    @RbacPermission
    public ResultBean<PagerBean<NoticeVO>> page(PageQuery pageQuery, NoticeQuery noticeQuery) {
        //处理分页条件
        Page<Notice> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        Notice notice = NoticeConverter.INSTANT.queryToEntity(noticeQuery);
        //执行分页查询
        Page<Notice> pageResult = noticeService.page(page, new QueryWrapper<>(notice));
        PagerBean<NoticeVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(), pageResult.getSize(),
                BeanCopyKits.coverList(pageResult.getRecords(), NoticeVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param noticeDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @ApiOperation("新增数据")
    @RbacPermission
    public ResultBean<Boolean> insert(@RequestBody @Validated NoticePostDTO noticeDTO) {
        //处理格式转换
        Notice notice = NoticeConverter.INSTANT.postDtoToEntity(noticeDTO);
        //执行数据保存
        return ResultBean.success(noticeService.save(notice));
    }

    /**
     * 修改数据
     *
     * @param noticeDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @ApiOperation("修改数据")
    @RbacPermission
    public ResultBean<Boolean> update(@RequestBody @Validated NoticePutDTO noticeDTO) {
        //处理格式转换
        Notice notice = NoticeConverter.INSTANT.putDtoToEntity(noticeDTO);
        //执行数据更新
        return ResultBean.success(noticeService.updateById(notice));
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
    public ResultBean<Boolean> delete(@RequestParam("ids") List<String> ids) {
        return ResultBean.success(noticeService.removeByIds(ids));
    }

}

