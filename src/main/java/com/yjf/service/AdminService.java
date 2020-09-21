package com.yjf.service;

import com.yjf.entity.Admin;
import com.yjf.userdao.AdminDao;
import com.yjf.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 余俊锋
 * @date 2020/9/21 12:01
 * @Description
 */
public class AdminService implements AdminDao {
    @Override
    public void add(Admin admin) {
        String sql = "insert into admin values(default,?,?)";
        JdbcUtils.dml(sql, admin.getName(), admin.getPassword());
    }

    @Override
    public Admin select(String name) {
        Connection conn = JdbcUtils.getConn();
        String sql = "select * from admin where name=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setObject(1, name);
            ResultSet resultSet = statement.executeQuery();
            return getAdmin(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Admin();
    }

    @Override
    public Admin selectByNameAndPwd(String name, String password) {
        Connection conn = JdbcUtils.getConn();
        String sql = "select * from admin where name=? and `password`=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setObject(1, name);
            statement.setObject(2, password);
            ResultSet resultSet = statement.executeQuery();
            return getAdmin(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Admin getAdmin(ResultSet resultSet) throws SQLException {
        Admin admin = new Admin();
        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String name1 = resultSet.getString("name");
            String password = resultSet.getString("password");
            admin.setId(id);
            admin.setName(name1);
            admin.setPassword(password);
        }
        return admin;
    }


}
