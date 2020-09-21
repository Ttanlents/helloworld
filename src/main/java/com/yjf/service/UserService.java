package com.yjf.service;

import com.yjf.entity.Page;
import com.yjf.entity.User;
import com.yjf.userdao.UserDao;
import com.yjf.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 余俊锋
 * @date 2020/9/10 11:38
 */
public class UserService implements UserDao {
    @Override
    public void add(User user) {
        DateFormat dateFormat = new SimpleDateFormat("YYY-MM-dd HH:mm:ss");
        String createTime = dateFormat.format(new Date());
        user.setCreateTime(createTime);
        String sql = "insert into `user` values(default,?,?,?,?,?,?) ";
        JdbcUtils.dml(sql, user.getName(), user.getAge(), user.getSex(), user.getSal(), user.getBirth(), user.getCreateTime());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from `user` where id=? ";
        JdbcUtils.dml(sql, id);
    }

    @Override
    public void update(User user) {
        String sql = "update `user` set  name=?,age=?,sex=?,sal=?,birth=? where id=? ";
        JdbcUtils.dml(sql, user.getName(), user.getAge(), user.getSex(), user.getSal(), user.getBirth(), user.getId());
    }

    @Override
    public int selectCount() {
        Connection conn = JdbcUtils.getConn();
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        String sql = "select count(*) count from `user`";
        int count = 0;
        try {
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt("count");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(resultSet, statement, conn);
        }
        return count;
    }
    @Override
    public int selectCount(String name) {
        Connection conn = JdbcUtils.getConn();
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        String sql = "select count(*) count from `user` where name like ?";
        int count = 0;
        try {
            statement = conn.prepareStatement(sql);
            statement.setObject(1,"%"+name+"%");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                count = resultSet.getInt("count");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(resultSet, statement, conn);
        }
        return count;
    }

    @Override
    public List<User> selectAll(String name , Page page) {
        Connection conn = JdbcUtils.getConn();
        ResultSet resultSet = null;
        PreparedStatement statement = null;

        String sql = "select u.id,u.`name`,u.age,u.sal,u.birth,u.create_time,\n" +
                "case u.sex\n" +
                "when 1 then'男'\n" +
                "when  0 then '女'\n" +
                "else '其他' \n" +
                "end sex\n" +
                "from `user` as u where u.`name` like CONCAT('%',?,'%') LIMIT ?,?;";

        List<User> list = new ArrayList<>();
        try {
            statement = conn.prepareStatement(sql);
            statement.setObject(1, name);
            statement.setObject(2, (page.getPageCurrent() - 1) * page.getPageSize());
            statement.setObject(3, page.getPageSize());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(getUser(resultSet));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet==null){
                JdbcUtils.close( statement, conn);
            }else {
                JdbcUtils.close(resultSet, statement, conn);
            }
        }
        return list;
    }

    @Override
    public User getOne(int id) {
        Connection conn = JdbcUtils.getConn();
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        String sql = "select * from `user` where id=?";
        User user = null;
        try {
            statement = conn.prepareStatement(sql);
            statement.setObject(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = getUser(resultSet);
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(resultSet, statement, conn);
        }
        return user;

    }

    public User getUser(ResultSet resultSet) throws SQLException {
        int id2 = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int age2 = resultSet.getInt("age");
        String sex = resultSet.getString("sex");
        Double sal = resultSet.getDouble("sal");
        String birth = resultSet.getString("birth");
        String createTime = resultSet.getString("create_time");
        return new User(id2, name, age2, sex, sal, birth, createTime);
    }
}
