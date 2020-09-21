package com.yjf.service;

import com.yjf.entity.Admin;
import com.yjf.entity.Area;
import com.yjf.userdao.AreaDao;
import com.yjf.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 余俊锋
 * @date 2020/9/21 17:35
 * @Description
 */
public class AreaService implements AreaDao {

    @Override
    public List<Area> selectProvince() {
        Connection conn=null;
        ResultSet resultSet=null;
        PreparedStatement statement=null;
         conn = JdbcUtils.getConn();
         String sql="select * from area where type=1";
        try {
             statement = conn.prepareStatement(sql);
             resultSet = statement.executeQuery();
             return getArea(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(resultSet,statement,conn);
        }
        return new ArrayList<>();
    }

    @Override
    public List<Area> selectAreaByParentId(Integer parentId) {
        Connection conn=null;
        ResultSet resultSet=null;
        PreparedStatement statement=null;
        conn = JdbcUtils.getConn();
        String sql="select * from area where parent_id=?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setObject(1,parentId);
            resultSet = statement.executeQuery();
            return getArea(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(resultSet,statement,conn);
        }
        return new ArrayList<>();
    }



    public List<Area> getArea(ResultSet resultSet) throws SQLException {
       List<Area> list=new ArrayList<>();
        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Area area = new Area();
            area.setId(id);
            area.setName(name);
            list.add(area);
        }
        return list;
    }
}
