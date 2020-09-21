package com.yjf.userdao;

import com.yjf.entity.Page;
import com.yjf.entity.User;

import java.util.List;

/**
 * @author 余俊锋
 * @date 2020/9/10 11:31
 */
public interface UserDao {

    void add(User user);

    void delete(int id);

    void update(User user);

    int selectCount();

    int selectCount(String name);

    List<User> selectAll(String name, Page page);

    User getOne(int id);

}
