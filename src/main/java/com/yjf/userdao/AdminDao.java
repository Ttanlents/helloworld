package com.yjf.userdao;

import com.yjf.entity.Admin;

/**
 * @author 余俊锋
 * @date 2020/9/21 12:00
 * @Description
 */
public interface AdminDao {
    void add(Admin admin);
    Admin select(String name);
    Admin selectByNameAndPwd(String name,String password);
}
