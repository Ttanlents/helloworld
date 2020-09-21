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
import java.io.PrintWriter;


/**
 * @author 余俊锋
 * @date 2020/9/21 10:19
 * @Description
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    AdminDao adminDao=new AdminService();
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        System.out.println(name+password);
        adminDao.add(new Admin(null,name,password));
        Admin admin = adminDao.select(name);
        if (admin.getId()>0){
            JsonUtils.responseJSON(resp,1);
        }else {
            JsonUtils.responseJSON(resp,0);
        }


    }
}
