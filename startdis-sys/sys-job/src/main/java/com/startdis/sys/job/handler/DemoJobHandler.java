package com.startdis.sys.job.handler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 标签job处理器
 *
 * @author dianjiu
 * @date 2021/12/27 17:38
 **/
@Slf4j
@Component
@AllArgsConstructor
public class DemoJobHandler {

    //@Resource
    //private UsersServiceImpl usersService;

    /**
     * 使用job删除未使用的tag
     *
     * @param param job参数
     * @createTime 2021/12/28 10:19
     */
    @XxlJob("autoDelUnusedTag")
    public ReturnT<String> autoDelUnusedTag(String param) {
        log.info("test start.");
        // todo
        log.info("test end.");
        return ReturnT.SUCCESS;
    }

}
