package com.yjf.servlet;

import com.yjf.Constants.Constans;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 余俊锋
 * @date 2020/9/19 11:19
 * @Description
 */
@WebServlet("/toAddUser")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute(Constans.ERROR_USER)!=null){
            req.getSession().removeAttribute(Constans.ERROR_USER);
        }
        resp.sendRedirect("/addUser.jsp");
    }
}
