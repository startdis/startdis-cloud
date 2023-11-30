package com.startdis.comm.exception.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc ExceptionUtils
 */
public class ExceptionUtils {
    //获取控制台打印日志
    public static String getTrace(Throwable t) {
        StringWriter stringWriter= new StringWriter();
        PrintWriter writer= new PrintWriter(stringWriter);
        try {
            t.printStackTrace(writer);
            StringBuffer buffer= stringWriter.getBuffer();
            return buffer.toString();
        } finally {
            writer.close();
        }
    }
}
