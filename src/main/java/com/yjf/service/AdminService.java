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
        ResultSet resultSet=null;
        PreparedStatement statement=null;
        try {
             statement = conn.prepareStatement(sql);
            statement.setObject(1, name);
             resultSet = statement.executeQuery();
            return getAdmin(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(resultSet,statement,conn);
        }
        return new Admin();
    }

    @Override
    public Admin selectByNameAndPwd(String name, String password) {
        Connection conn = JdbcUtils.getConn();
        String sql = "select * from admin where name=? and `password`=?";
        ResultSet resultSet=null;
        PreparedStatement statement=null;
        try {
             statement = conn.prepareStatement(sql);
            statement.setObject(1, name);
            statement.setObject(2, password);
             resultSet = statement.executeQuery();
            return getAdmin(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(resultSet,statement,conn);
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
