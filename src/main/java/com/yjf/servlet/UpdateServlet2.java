package com.yjf.servlet;

import com.yjf.entity.Page;
import com.yjf.entity.User;
import com.yjf.service.UserService;
import com.yjf.userdao.UserDao;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 余俊锋
 * @date 2020/9/16 13:42
 */
@WebServlet("/update2")
public class UpdateServlet2 extends HttpServlet {
    UserDao userDao=new UserService();
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=new User();
        try {
            BeanUtils.populate(user,req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        userDao.update(user);
        Integer pageCurrent=1;
        String name=null;
        if (name==null){
            name="";
        }
        int count = userDao.selectCount();
        Page<List<User>> page=new Page<>(pageCurrent,4,count);
        List<User> list = userDao.selectAll(name, page);
        page.setData(list);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/userList.jsp").forward(req,resp);
    }
}
