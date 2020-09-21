package com.yjf.servlet;

import com.yjf.entity.Admin;
import com.yjf.service.AdminService;
import com.yjf.userdao.AdminDao;
import com.yjf.utils.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author 余俊锋
 * @date 2020/9/21 11:19
 * @Description
 */
@WebServlet("/checkName")
public class CheckNameServlet extends HttpServlet {
    AdminDao adminDao= new AdminService();
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
       if (name==null){
           return;
       }
        Admin admin = adminDao.select(name);
        if (admin.getId()!=null&&admin.getId()>0){
            JsonUtils.responseJSON(resp,1);
        }else {
            JsonUtils.responseJSON(resp,0);
        }
    }
}
