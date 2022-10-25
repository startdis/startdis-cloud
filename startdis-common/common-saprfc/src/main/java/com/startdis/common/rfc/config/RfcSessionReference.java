package com.startdis.common.rfc.config;

import com.sap.conn.jco.ext.JCoSessionReference;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author DianJiu
 * @email dianjiusir@gmail.com
 * @date 2022-06-16 14:28
 * @desc RfcSessionReference rfcSession管理中心
 */
public class RfcSessionReference implements JCoSessionReference {
    static AtomicInteger atomicInt = new AtomicInteger(0);
    private String id = "session-" + String.valueOf(atomicInt.addAndGet(1));;

    public void contextFinished() {
    }

    public void contextStarted() {
    }

    public String getID() {
        return id;
    }

}

