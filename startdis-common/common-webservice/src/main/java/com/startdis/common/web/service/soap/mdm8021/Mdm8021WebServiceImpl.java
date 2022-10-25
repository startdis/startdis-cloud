package com.startdis.common.web.service.soap.mdm8021;

import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.List;

/**
 * @author wws
 * Create by wws 2022-06-21 10:57
 */
@WebService(serviceName = "MDM8021_GERP_SI ", // 与接口中指定的name一致
        targetNamespace = "http://www.lgchem.com/PI/GMDM" // 与接口中的命名空间一致,一般是接口的包名倒
        //endpointInterface = "com.zims.ws.wsdl.mdm8021.Mdm8021WebService"// 接口地址
)
@Component("mdm8021WebServiceImpl")
public class Mdm8021WebServiceImpl implements Mdm8021WebService {

    @Override
    public void MDM8021_GERP_SI(String I_LIFNR, I_LFM1 I_LFM1, List<T_WYT3> T_WYT3) {
        //Result result = new Result();
        //result.setCode(200);
        //result.setMsg("数据接收成功！");
        //return result;
    }
}
