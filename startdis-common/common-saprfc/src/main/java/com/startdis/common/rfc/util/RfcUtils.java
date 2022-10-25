package com.startdis.common.rfc.util;

import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;
import com.startdis.common.rfc.config.RfcManager;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author DianJiu
 * @email dianjiusir@gmail.com
 * @date 2022-06-16 15:05
 * @desc SapRfcUtils RFC调用工具类
 */
public class RfcUtils {
    private static Logger logger = LoggerFactory.getLogger(RfcUtils.class);

    public static JCoParameterList doRfcImportRequest(String functionName, String codeKey, String msgKey, Object importParams) {
        if (null == importParams) {
            return doRfcByImportParams(functionName, codeKey, msgKey, null);
        }
        Map<String, Object> map = entityToMap(importParams);
        return doRfcByImportParams(functionName, codeKey, msgKey, map);
    }

    /**
     * 通过输入参数发送RFC请求
     *
     * @param functionName 函数名称
     * @param importParams 输入参数
     * @return
     */
    public static JCoParameterList doRfcByImportParams(String functionName, String codeKey, String msgKey, Map<String, Object> importParams) {
        return doRfcFullRequest(functionName, codeKey, msgKey, importParams, null, null);
    }


    public static JCoParameterList doRfcTableRequest(String functionName, String codeKey, String msgKey, List<Object> tableParams) {
        if (null == tableParams) {
            return doRfcByTableParams(functionName, codeKey, msgKey, null);
        }
        List<Map<String, Object>> tableMaps = getTableMaps(tableParams);
        return doRfcByTableParams(functionName, codeKey, msgKey, tableMaps);
    }

    /**
     * 通过内表参数发送RFC请求
     *
     * @param functionName 函数名称
     * @param tableParams  内表参数
     * @return
     */
    public static JCoParameterList doRfcByTableParams(String functionName, String codeKey, String msgKey, List<Map<String, Object>> tableParams) {
        return doRfcFullRequest(functionName, codeKey, msgKey, null, tableParams, null);
    }


    public static JCoParameterList doRfcChangingRequest(String functionName, String codeKey, String msgKey, Object changingParams) {
        if (null == changingParams) {
            return doRfcByChangingParams(functionName, codeKey, msgKey, null);
        }
        Map<String, Object> map = entityToMap(changingParams);
        return doRfcByChangingParams(functionName, codeKey, msgKey, map);
    }

    /**
     * 通过更改参数发送RFC请求
     *
     * @param functionName   函数名称
     * @param changingParams 更改参数
     * @return
     */
    public static JCoParameterList doRfcByChangingParams(String functionName, String codeKey, String msgKey, Map<String, Object> changingParams) {
        return doRfcFullRequest(functionName, codeKey, msgKey, null, null, changingParams);
    }


    public static JCoParameterList doRfcImportTableRequest(String functionName, String codeKey, String msgKey, Object importParams, List<Object> tableParams) {
        if (null == importParams && null != tableParams) {
            List<Map<String, Object>> tableMaps = getTableMaps(tableParams);
            return doRfcByImportTableParams(functionName, codeKey, msgKey, null, tableMaps);
        }
        if (null == tableParams && null != importParams) {
            Map<String, Object> importMap = entityToMap(importParams);
            return doRfcByImportTableParams(functionName, codeKey, msgKey, importMap, null);
        }
        if (null == importParams && null == tableParams) {
            return doRfcByImportTableParams(functionName, codeKey, msgKey, null, null);
        }
        Map<String, Object> importMap = entityToMap(importParams);
        List<Map<String, Object>> tableMaps = getTableMaps(tableParams);
        return doRfcByImportTableParams(functionName, codeKey, msgKey, importMap, tableMaps);
    }

    private static List<Map<String, Object>> getTableMaps(List<Object> tableParams) {
        List<Map<String, Object>> tableMaps = new ArrayList<>();
        for (Object tableParam : tableParams) {
            Map<String, Object> map = entityToMap(tableParam);
            tableMaps.add(map);
        }
        return tableMaps;
    }

    /**
     * 通过内表参数发送RFC请求
     *
     * @param functionName 函数名称
     * @param importParams 输入参数
     * @param tableParams  内表参数
     * @return
     */
    public static JCoParameterList doRfcByImportTableParams(String functionName, String codeKey, String msgKey, Map<String, Object> importParams, List<Map<String, Object>> tableParams) {
        return doRfcFullRequest(functionName, codeKey, msgKey, importParams, tableParams, null);
    }

    /**
     * 发送完整的RFC请求
     *
     * @param functionName   函数名称
     * @param importParams   输入参数
     * @param tableParams    内表参数
     * @param changingParams 更改参数
     * @return
     */
    public static JCoParameterList doRfcFullRequest(String functionName, String codeKey, String msgKey, Map<String, Object> importParams, List<Map<String, Object>> tableParams, Map<String, Object> changingParams) {
        if (StringUtils.isBlank(functionName)) {
            return null;
        }
        logger.info(functionName);
        RfcManager rfcManager = RfcManager.getInstance();
        JCoFunction function = rfcManager.getFunction(functionName);
        try {
            //组装请求参数
            buildRfcRequest(importParams, tableParams, changingParams, function);
            //调用rfc函数
            System.out.println("getTableParameterList "+function.getTableParameterList().toXML());
            rfcManager.executeFunction(function);
            //处理响应结果
            if (buildRfcResponse(function, codeKey, msgKey)) {
                return function.getTableParameterList();
            }
        } catch (Exception e) {
            logger.error("SapRfcUtils doRfcFullRequest error: {}", e.getMessage());
            throw new RuntimeException(e);
        } finally {
            //清空本次条件，如果要继续传入值去或者还要循环，那得将之前的条件清空
            if (null != importParams && !importParams.isEmpty()) {
                function.getImportParameterList().clear();
            }
        }
        return null;
    }

    /**
     * Created by dianjiu on 2022-06-16 ,contact dianjiusir@gmail.com.
     * 组装Rfc请求参数.
     */
    private static void buildRfcRequest(Map<String, Object> importParams, List<Map<String, Object>> tableParams, Map<String, Object> changingParams, JCoFunction function) {
        //输入参数
        if (null != importParams && !importParams.isEmpty()) {
            for (Map.Entry<String, Object> paramEntry : importParams.entrySet()) {
                JCoParameterList inputParam = function.getImportParameterList();
                // 结构体类型
                if (paramEntry.getValue() instanceof Map){
                    JCoStructure structure = function.getImportParameterList().getStructure(paramEntry.getKey());
                    Map maps = (Map) paramEntry.getValue();
                    Iterator<Integer> iterator = maps.keySet().iterator();
                    while (iterator.hasNext()) {
                        structure.setValue(iterator.next(),maps.get(iterator.next()));
                    }
                    inputParam.setValue(paramEntry.getKey(), structure);
                }else {
                    inputParam.setValue(paramEntry.getKey(), paramEntry.getValue());
                }
            }
        }
        //内表参数,支持多个表单对象
        if (null != tableParams && !tableParams.isEmpty()) {
            for (Map<String, Object> tableParam : tableParams) {
                String tableName = String.valueOf(tableParam.get("tableName"));
                JCoTable tableData = function.getTableParameterList().getTable(tableName);
                tableData.appendRow();
                for (Map.Entry<String, Object> tableEntry : tableParam.entrySet()) {
                    if (!"tableName".equals(tableEntry.getKey())) {
                        tableData.setValue(tableEntry.getKey(), tableEntry.getValue());
                    }

                }
            }
        }
        //更改参数
        if (null != changingParams && !changingParams.isEmpty()) {
            for (Map.Entry<String, Object> changingEntry : changingParams.entrySet()) {
                JCoParameterList changingParam = function.getChangingParameterList();
                changingParam.setValue(changingEntry.getKey(), changingEntry.getValue());
            }
        }
    }

    /**
     * Created by dianjiu on 2022-06-16 ,contact dianjiusir@gmail.com.
     * 组装Rfc响应结果.
     */
    private static boolean buildRfcResponse(JCoFunction function, String codeKey, String msgKey) {
        //调用接口返回状态 Message type: S Success, E Error, W Warning, I Info, A Abort
        String code = function.getExportParameterList().getString(codeKey);
        //调用接口返回信息
        String message = function.getExportParameterList().getString(msgKey);
        // 处理具体相应信息
        if (code.equals("E")) {
            logger.error("调用返回Error状态--->" + code + ";调用返回信息--->" + message);
            throw new RuntimeException("SapRfcUtils,error message :{}" + message);
        }
        if (code.equals("F")) {
            logger.error("调用返回No Find状态--->" + code + ";调用返回信息--->" + message);
            throw new RuntimeException("SapRfcUtils,no-find message :{}" + message);
        }
        if (code.equals("W")) {
            logger.error("调用返回Warning状态--->" + code + ";调用返回信息--->" + message);
            throw new RuntimeException("SapRfcUtils,error message :{}" + message);
        }
        if (code.equals("I")) {
            logger.error("调用返回Info状态--->" + code + ";调用返回信息--->" + message);
            throw new RuntimeException("SapRfcUtils,error message :{}" + message);
        }
        if (code.equals("A")) {
            logger.error("调用返回Abort状态--->" + code + ";调用返回信息--->" + message);
            throw new RuntimeException("SapRfcUtils,error message :{}" + message);
        }
        if (code.equals("S")) {
            logger.info("调用返回Success状态--->" + code + ";调用返回信息--->" + message);
            return true;
        }
        return false;
    }

    /**
     * 利用反射 将Java实体转化为 map
     *
     * @param object object
     * @return map
     * @version 1.0
     */
    public static Map<String, Object> entityToMap(Object object) {
        Map<String, Object> reMap = new HashMap<>();
        if (object == null) {
            return null;
        }
        List<Field> fields = new ArrayList<>();
        List<Field> childFields;
        List<String> fieldsName = new ArrayList<>();
        Class tempClass = object.getClass();
        //当父类为null的时候说明到达了最上层的父类(Object类).
        while (tempClass != null) {
            fields.addAll(Arrays.asList(tempClass.getDeclaredFields()));
            //得到父类,然后赋给自己
            tempClass = tempClass.getSuperclass();
        }
        childFields = Arrays.asList(object.getClass().getDeclaredFields());
        for (Field field : childFields) {
            fieldsName.add(field.getName());
        }
        try {
            for (Field field : fields) {
                try {
                    if (fieldsName.contains(field.getName())) {
                        Field f = object.getClass().getDeclaredField(
                                field.getName());
                        f.setAccessible(true);
                        Object o = f.get(object);
                        reMap.put(field.getName(), o);
                    } else {
                        Field f = object.getClass().getSuperclass().getDeclaredField(
                                field.getName());
                        f.setAccessible(true);
                        Object o = f.get(object);
                        reMap.put(field.getName(), o);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return reMap;
    }
}
