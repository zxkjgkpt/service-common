package com.yfny.servicecommon.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 反射机制工具类
 * Created by jisongZhou on 2017/12/4.
 **/
public class ReflectUtils {

    /**
     * 使用反射根据属性名称获取属性值
     *
     * @param fieldName 属性名称
     * @param object    操作对象
     * @return value 属性值
     */
    public static Object getFieldValueByName(String fieldName, Object object) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = object.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(object, new Object[]{});
            return value;
        } catch (Exception e) {
            //System.out.println("属性不存在");
            return null;
        }
    }

    /**
     * 使用反射根据属性名称设置属性值
     *
     * @param clazz
     * @param map
     * @return
     */
    public static Object setFieldValueByName(Class<?> clazz, Map<String, Object> map) {
        Object object = null;
        try {
            object = clazz.newInstance();
        } catch (Exception e) {

        }
        return setFieldValueByName(object, clazz, map);
    }

    /**
     * 使用反射根据属性名称设置属性值
     *
     * @param object
     * @param clazz
     * @param map
     * @return
     */
    public static Object setFieldValueByName(Object object, Class<?> clazz, Map<String, Object> map) {
        try {
            for (String fieldName : map.keySet()) {
                Object fieldValue = map.get(fieldName);
                Field field = getDeclaredField(object, fieldName);
                String firstLetter = fieldName.substring(0, 1).toUpperCase();
                String setter = "set" + firstLetter + fieldName.substring(1);
                Method method = clazz.getMethod(setter, new Class[]{field.getType()});
                method.invoke(object, fieldValue);
            }
            return object;
        } catch (Exception e) {
            //System.out.println("属性不存在");
            return null;
        }
    }

    /**
     * 获取对象的属性名称数组
     *
     * @param object
     * @return
     */
    public static String[] getFiledName(Object object) {
        Field[] localFields = object.getClass().getDeclaredFields();
        Field[] superFields = object.getClass().getSuperclass().getDeclaredFields();
        int size = localFields.length + superFields.length;
        String[] fieldNames = new String[size];
        for (int i = 0; i < size; i++) {
            if (i < localFields.length) {
                //System.out.println(fields[i].getType());
                fieldNames[i] = localFields[i].getName();
            } else {
                int j = i - localFields.length;
                fieldNames[i] = superFields[j].getName();
            }
        }
        return fieldNames;
    }

    /**
     * 复制非null属性
     *
     * @param source
     * @param result
     */
    public static void copyProperties(Object source, Object result) {
        copySuperProperties(source, result);
        copyLocalProperties(source, result);
    }

    /**
     * 复制非null属性
     *
     * @param source
     * @param result
     */
    public static void copyLocalProperties(Object source, Object result) {
        String[] fileds = getFiledName(source);
        Map<String, Object> map = new HashMap<String, Object>();
        for (String filed : fileds) {
            Object value = getFieldValueByName(filed, source);
            if (value != null) {
                map.put(filed, value);
            } else {
                setFieldValue(result, filed, null);
            }
        }
        setFieldValueByName(result, source.getClass(), map);
    }

    /**
     * 复制超类非null属性（超类动态获取太麻烦，写死好了）
     *
     * @param source
     * @param result
     */
    public static void copySuperProperties(Object source, Object result) {
//        setFieldValue(result, "delFlag", getFieldValue(source, "delFlag"));
//        setFieldValue(result, "updateBy", getFieldValue(source, "updateBy"));
//        setFieldValue(result, "updateDate", getFieldValue(source, "updateDate"));
    }

    /**
     * 循环向上转型, 获取对象的 DeclaredField
     *
     * @param object    : 子类对象
     * @param fieldName : 父类中的属性名
     * @return 父类中的属性对象
     */
    public static Field getDeclaredField(Object object, String fieldName) {
        Field field = null;
        Class<?> clazz = object.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                return field;
            } catch (Exception e) {
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
                //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了
            }
        }
        return null;
    }

    /**
     * 直接设置对象属性值, 忽略 private/protected 修饰符, 也不经过 setter
     *
     * @param object    : 子类对象
     * @param fieldName : 父类中的属性名
     * @param value     : 将要设置的值
     */
    public static void setFieldValue(Object object, String fieldName, Object value) {
        //根据 对象和属性名通过反射 调用上面的方法获取 Field对象
        Field field = getDeclaredField(object, fieldName);
        //抑制Java对其的检查
        field.setAccessible(true);
        try {
            //将 object 中 field 所代表的值 设置为 value
            field.set(object, value);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 直接读取对象的属性值, 忽略 private/protected 修饰符, 也不经过 getter
     *
     * @param object    : 子类对象
     * @param fieldName : 父类中的属性名
     * @return : 父类中的属性值
     */
    public static Object getFieldValue(Object object, String fieldName) {

        //根据 对象和属性名通过反射 调用上面的方法获取 Field对象
        Field field = getDeclaredField(object, fieldName);
        //抑制Java对其的检查
        field.setAccessible(true);
        try {
            //获取 object 中 field 所代表的属性值
            return field.get(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
