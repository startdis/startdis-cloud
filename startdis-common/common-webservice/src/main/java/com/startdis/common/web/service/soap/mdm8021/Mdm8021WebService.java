package com.startdis.common.web.service.soap.mdm8021;


import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

/**
 * 供应商公司代码信息
 *
 * @author wws
 * Create by wws 2022-06-21 10:54
 */
@WebService(name = "MDM8021_GERP_SI ", targetNamespace = "http://www.lgchem.com/PI/GMDM")
public interface Mdm8021WebService {


    public @WebResult(name = "result")
    void MDM8021_GERP_SI(@WebParam(name = "I_LIFNR") String I_LIFNR,
                           @WebParam(name = "I_LFM1") I_LFM1 I_LFM1,
                           @WebParam(name = "T_WYT3") List<T_WYT3> T_WYT3);
}
