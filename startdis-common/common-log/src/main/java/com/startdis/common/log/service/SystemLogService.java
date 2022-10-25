package com.startdis.common.log.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.startdis.common.log.entity.SystemLog;

/**
 * <p>
 * 系统日志表 服务类
 * </p>
 *
 * @author 点九
 * @since 2022-07-19
 */
public interface SystemLogService extends IService<SystemLog> {
    //public void save(SystemLog systemLog);

    /**
     * 系统日志分页查询
     *
     * @param systemLog 查询参数
     * @param pageNum   pageNum
     * @param pageSize  pageSize
     * @return 1
     */
    PageInfo<SystemLog> systemLogPageList(SystemLog systemLog, int pageNum, int pageSize);
}
