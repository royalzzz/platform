package xin.qust.platform.utils;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class ToolKit {

    public static Map<String, Object> getObjectToMap(Object obj) throws IllegalAccessException {
        Map<String, Object> map = new LinkedHashMap<>();
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = field.get(obj);
            if (value == null){
                value = "";
            }
            map.put(fieldName, value);
        }
        return map;
    }

    public static String mapToJsonString(Map<String, Object> jsonMap) {
        JSONObject jsonObj = new JSONObject(jsonMap);
        return jsonObj.toString();
    }

    public static String dateFormatOutput(Date date, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }
}
