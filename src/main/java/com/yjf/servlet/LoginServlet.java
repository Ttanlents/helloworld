package com.yjf.servlet;

import com.yjf.Constants.Constans;
import com.yjf.entity.Page;
import com.yjf.entity.User;
import com.yjf.service.UserService;
import com.yjf.userdao.UserDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * @author 余俊锋
 * @date 2020/9/16 10:27
 */
@WebServlet(value ="/login")
public class LoginServlet extends HttpServlet {
    UserDao userDao = new UserService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String name1 = req.getParameter("name");
        String password = req.getParameter("password");
        String rememberNumber = req.getParameter("rememberNumber");
        int number = 1;
        if (rememberNumber != null) {
            number = Integer.parseInt(rememberNumber);
        }
        if (Objects.equals(name1, "admin") && Objects.equals(password, "123456")) {
            int time = 0;
            Cookie cookie1 = new Cookie("name", "admin");
            Cookie cookie2 = new Cookie("password", "123456");
            if (number == 1) {
                //不记住cookies
                session.setAttribute(Constans.SESSION_NAME, name1);
                login(req, resp);
                return;
            } else if (number == 2) {
                //七天免登陆
                time = 60 * 60 * 24 * 7;
            } else {
                time = 60 * 60 * 24 * 30;
            }
            cookie1.setMaxAge(time);
            cookie2.setMaxAge(time);
            resp.addCookie(cookie1);
            resp.addCookie(cookie2);
            session.setAttribute(Constans.SESSION_NAME, name1);
            System.out.println("登录成功存储登录名字"+name1+"  "+session.getId());
            login(req, resp);
        } else {
            resp.getOutputStream().write("账号或密码错误！".getBytes());
        }


    }


    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext application = req.getServletContext();
        Integer pageCurrent = 1;
        String name = "";
        int count = userDao.selectCount();
        Page<List<User>> page = new Page<>(pageCurrent, 4, count);
        List<User> list = userDao.selectAll(name, page);
        page.setData(list);
        req.setAttribute("page", page);
        req.getRequestDispatcher("/userList.jsp").forward(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("初始化login完成");

    }
}
