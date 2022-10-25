package com.startdis.common.db.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc MybatisPlusConfig 配置类
 */
@Configuration
@MapperScan(value = { "com.startdis.**.mapper*" })
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();

        /*
         * //创建人填充 Boolean createByEnable =
         * fieldFillConfig.getCreatedByIntercept().getEnable(); if (createByEnable){
         * FieldFillInterceptor createByInterceptor = new FieldFillInterceptor();
         * createByInterceptor.setFieldFillHandler(getCreatedByHandler());
         * interceptor.addInnerInterceptor(createByInterceptor);
         * log.info("----------------创建人填充器开启-----------------------"); } //更新人填充
         * Boolean updateByEnable = fieldFillConfig.getUpdateByIntercept().getEnable();
         * if (updateByEnable){ FieldFillInterceptor updateByInterceptor = new
         * FieldFillInterceptor();
         * updateByInterceptor.setFieldFillHandler(getUpdatedByHandler());
         * interceptor.addInnerInterceptor(updateByInterceptor);
         * log.info("----------------更新人填充器开启-----------------------"); } //创建时间 Boolean
         * createAtEnable = fieldFillConfig.getCreateAtIntercept().getEnable(); if
         * (createAtEnable){ FieldFillInterceptor createAtInterceptor = new
         * FieldFillInterceptor();
         * createAtInterceptor.setFieldFillHandler(getCreatedAtHandler());
         * interceptor.addInnerInterceptor(createAtInterceptor);
         * log.info("----------------创建时间填充器开启-----------------------"); } //更新时间
         * Boolean updateAtEnable = fieldFillConfig.getUpdateAtIntercept().getEnable();
         * if (updateAtEnable){ FieldFillInterceptor updateAtInterceptor = new
         * FieldFillInterceptor();
         * updateAtInterceptor.setFieldFillHandler(getUpdatedAtHandler());
         * interceptor.addInnerInterceptor(updateAtInterceptor);
         * log.info("----------------更新时间填充器开启-----------------------"); }
         */
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.POSTGRE_SQL));
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;
    }

    /*
     * @Bean public UpdatedByHandler getUpdatedByHandler(){ return new
     * UpdatedByHandler(fieldFillConfig); }
     * @Bean public UpdatedAtHandler getUpdatedAtHandler(){ return new
     * UpdatedAtHandler(fieldFillConfig); }
     * @Bean public CreatedByHandler getCreatedByHandler(){ return new
     * CreatedByHandler(fieldFillConfig); }
     * @Bean public CreatedAtHandler getCreatedAtHandler(){ return new
     * CreatedAtHandler(fieldFillConfig); }
     */
}
