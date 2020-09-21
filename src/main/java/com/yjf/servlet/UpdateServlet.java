package com.yjf.servlet;

import com.yjf.entity.User;
import com.yjf.service.UserService;
import com.yjf.userdao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 余俊锋
 * @date 2020/9/16 13:27
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    UserDao userDao=new UserService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id2 = req.getParameter("id");
        if (id2==null||id2.length()<=0){
            return;
        }
        int id = Integer.parseInt(id2);
        User one = userDao.getOne(id);
        req.setAttribute("user",one);
        req.getRequestDispatcher("/update.jsp").forward(req,resp);

    }
}
