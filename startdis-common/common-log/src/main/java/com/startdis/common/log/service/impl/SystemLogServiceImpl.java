package com.startdis.common.log.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.startdis.common.log.entity.SystemLog;
import com.startdis.common.log.mapper.SystemLogMapper;
import com.startdis.common.log.service.SystemLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 系统日志表 服务实现类
 * </p>
 *
 * @author 点九
 * @since 2022-07-19
 */
@Service
@Slf4j
public class SystemLogServiceImpl extends ServiceImpl<SystemLogMapper, SystemLog> implements SystemLogService {

    @Resource
    private SystemLogMapper systemLogMapper;

    /**
     * 系统日志分页查询
     *
     * @param systemLog 查询参数
     * @param pageNum   pageNum
     * @param pageSize  pageSize
     * @return 1
     */
    @Override
    public PageInfo<SystemLog> systemLogPageList(SystemLog systemLog, int pageNum, int pageSize) {
        log.info(" --------------- 系统日志分页查询 start --------------- ");
        // 查询List
        Page<SystemLog> page = PageHelper.startPage(pageNum, pageSize);
        List<SystemLog> systemLogList = systemLogMapper.selectList(Wrappers.<SystemLog>lambdaQuery()
                // 用户名称
                .like(StringUtils.isNotEmpty(systemLog.getUserName()), SystemLog::getUserName, systemLog.getUserName())
                // 流水号
                .like(StringUtils.isNotEmpty(systemLog.getBusinessNo()), SystemLog::getBusinessNo, systemLog.getBusinessNo())
                .orderByDesc(SystemLog::getCreatedAt)
        );
        PageInfo<SystemLog> pageInfo = new PageInfo<SystemLog>(systemLogList);
        pageInfo.setTotal(page.getTotal());
        PageHelper.clearPage();
        log.info(" --------------- 系统日志分页查询 end --------------- ");
        return pageInfo;
    }


    //
    //@Override
    //public void save(SystemLog systemLog) {
    //    SystemLogMapper systemLogMapper = SpringBeans.getBean(SystemLogMapper.class);
    //    systemLogMapper.insert(systemLog);
    //}
}
