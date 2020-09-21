package com.yjf.test;


import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yjf.entity.User;

import java.io.IOException;

/**
 * @author 余俊锋
 * @date 2020/9/21 16:08
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        User user = new User();
        user.setSal(22.0);
        user.setId(1);
        user.setAge(18);
        /*String s = JSON.toJSONString(user);
        System.out.println(s);
        User object = JSON.parseObject(s, new TypeReference<User>() {
        });
        System.out.println(object);*/

        ObjectMapper mapper = new ObjectMapper();
        String s1="";
        try {
             s1 = mapper.writeValueAsString(user);
            System.out.println(s1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            User user1 = mapper.readValue(s1, new TypeReference<User>() {
            });
            System.out.println(user1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
