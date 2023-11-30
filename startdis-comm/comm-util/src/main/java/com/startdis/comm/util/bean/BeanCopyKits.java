package com.startdis.comm.util.bean;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc BeanCopyKits
 */
public class BeanCopyKits {
    
    /**
     * 浅拷贝list
     *
     * @param source 数据源
     * @param clazz  对象
     * @return LIST
     */
    public static List copyListProperties(List source, Class clazz) {
        List target = new ArrayList();
        source.forEach(o -> {
            try {
                target.add(JSONObject.parseObject(JSONObject.toJSONString(o), clazz));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return target;
    }
    
    /**
     * 源对象和目标对象浅拷贝 PS：目标对象和源对象中的属性名称需一至，否则无法copy
     *
     * @param sourceObj 源对象
     * @param targetObj 目标对象
     */
    public static void copyPropertiesThird(Object sourceObj, Object targetObj) {
        BeanUtils.copyProperties(sourceObj, targetObj);
    }
    
    public static <T> T copyPropertiesThird(Object sourceObj, Class<T> calzz) {
        if (Objects.isNull(sourceObj) || Objects.isNull(calzz)) {
            return null;
        }
        T c = null;
        try {
            // c = calzz.newInstance();
            c = calzz.getDeclaredConstructor().newInstance();
            BeanCopyKits.copyPropertiesThird(sourceObj, c);
        } catch (Exception e) {
            System.out.println("BeanCopyKits -> copyPropertiesThird error：" + e);
        }
        return c;
    }
    
    /**
     * 转换list泛型
     *
     * @param source 数据源
     * @param clazz  对象
     * @return LIST
     */
    public static <T> List<T> coverList(List source, Class<T> clazz) {
        List<T> res = new ArrayList<>();
        source.forEach(o -> res.add(BeanCopyKits.copyPropertiesThird(o, clazz)));
        return res;
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
                        Field f = object.getClass().getDeclaredField(field.getName());
                        f.setAccessible(true);
                        Object o = f.get(object);
                        reMap.put(field.getName(), o);
                    } else {
                        Field f = object.getClass().getSuperclass().getDeclaredField(field.getName());
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