package com.yjf.servlet;

import com.yjf.Constants.Constans;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 余俊锋
 * @date 2020/9/19 11:53
 * @Description
 */
@WebServlet("/loginOut")
public class LoginOutServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute(Constans.SESSION_NAME);
        resp.sendRedirect("/index.jsp");
    }
}
