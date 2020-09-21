package com.yjf.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
/**
 * @author 余俊锋
 * @date 2020/9/21 10:37
 * @Description
 */
public class JsonUtils {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     *@Description 将对象转换成json字符串。
     *@author 余俊锋
     *@date 2020/9/21 10:38
     *@params data
     *@return java.lang.String
     */
    public static String StringToJson(Object data) {
    	try {
			String string = MAPPER.writeValueAsString(data);
			return string;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     *@Description 将json结果集转化为对象
     *@author 余俊锋
     *@date 2020/9/21 10:38
     *@params jsonData
     * @param beanType
     *@return T
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
    
    /**
     *@Description 将json数据转换成pojo对象list
     *@author 余俊锋
     *@date 2020/9/21 10:38
     *@params jsonData
     * @param beanType
     *@return java.util.List<T>
     */


    public static <T>List<T> jsonToList(String jsonData, Class<T> beanType) {
    	JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
    	try {
    		List<T> list = MAPPER.readValue(jsonData, javaType);
    		return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return null;
    }

   /**
    *@Description 响应返回json数据
    *@author 余俊锋
    *@date 2020/9/21 10:37
    *@params  响应   字符串
    *@return
    */
    public static void responseJSON(HttpServletResponse response, Object object) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        if (object == null)
            return;
        String jsonStr = mapper.writeValueAsString(object);    //object对象转为 josn 字符串
        OutputStream out = response.getOutputStream();
        out.write(jsonStr.getBytes("UTF-8"));
        out.flush();
    }
    
}
