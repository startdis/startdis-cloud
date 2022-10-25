package com.startdis.common.rfc.config;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.ext.DestinationDataProvider;
import com.sap.conn.jco.ext.Environment;
import com.startdis.common.core.spring.SpringProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * @author DianJiu
 * @email dianjiusir@gmail.com
 * @date 2022-06-16 14:28
 * @desc RfcManager
 */
@Configuration
@EnableConfigurationProperties(value = RfcProperties.class)
public class RfcManager {
    private static Logger log = LoggerFactory.getLogger(RfcManager.class);
    private static final String ABAP_AS_POOLED = "ABAP_AS_WITH_POOL";
    private static JCoDestination destination;

    @Resource
    private RfcProperties rfcProperties;

    public RfcManager() {
        try {
            //获取JCOProvider
            getDataProvider();
            //获取Destination
            getDestination();
        } catch (IllegalStateException e) {
            log.error("初始化RFC连接异常：",e);
        }
    }

    public static RfcManager getInstance() {
        return new RfcManager();
    }

    private void getDataProvider() {
        JCOProvider provider = new JCOProvider();
        Environment.registerDestinationDataProvider(provider);
        provider.changePropertiesForABAP_AS(ABAP_AS_POOLED, loadProperties());
    }


    /**
     * Created by dianjiu on 2022-06-16 ,contact dianjiusir@gmail.com.
     * 加载RFC服务端配置信息.
     */
    public Properties loadProperties() {
        Properties props=new Properties();

        //从环境变量中读取配置文件
        props.setProperty(DestinationDataProvider.JCO_USER, SpringProperties.getString("jco.client.user"));
        props.setProperty(DestinationDataProvider.JCO_PASSWD,SpringProperties.getString("jco.client.passwd"));
        props.setProperty(DestinationDataProvider.JCO_LANG, SpringProperties.getString("jco.client.lang"));
        props.setProperty(DestinationDataProvider.JCO_CLIENT,SpringProperties.getString("jco.client.client"));
        props.setProperty(DestinationDataProvider.JCO_SYSNR,SpringProperties.getString("jco.client.sysnr"));
        props.setProperty(DestinationDataProvider.JCO_ASHOST,SpringProperties.getString("jco.client.ashost"));
        props.setProperty(DestinationDataProvider.JCO_PEAK_LIMIT,SpringProperties.getString("jco.destination.peakLimit"));
        props.setProperty(DestinationDataProvider.JCO_POOL_CAPACITY,SpringProperties.getString("jco.destination.poolCapacity"));

        return props;
    }

    public JCoDestination getDestination() {
        try {
            destination = JCoDestinationManager.getDestination(ABAP_AS_POOLED);
        } catch (JCoException e) {
            log.error("getDestination exception :{}",e.getMessage());
            throw new RuntimeException(e);
        }
        return destination;
    }

    public void executeFunction(JCoFunction function) {
        log.info("RFC executeFunction name :{}",function.getName());
        try {
            function.execute(destination);
        } catch (JCoException e) {
            log.error("RfcManager executeFunction exception :{}",e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public JCoFunction getFunction(String functionName) {
        JCoFunction function = null;
        try {
            function = destination.getRepository().getFunctionTemplate(functionName).getFunction();
        } catch (Exception e) {
            log.error("RfcManager getFunction exception :{}",e.getMessage());
            throw new RuntimeException(e);
        }
        return function;
    }
}
