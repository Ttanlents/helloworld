package com.yjf.servlet;

import com.yjf.Constants.Constans;
import com.yjf.entity.User;
import com.yjf.service.UserService;
import com.yjf.userdao.UserDao;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 余俊锋
 * @date 2020/9/16 12:19
 */
@WebServlet("/addUser")
public class AddServlet extends HttpServlet {
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
        if (user.getAge()==0){
            user.setAge(null);
        }
        if (user.getSal()==0.0d){
            user.setSal(null);
        }
        System.out.println("添加"+user);
        if (user.getName()==null||user.getName().equals("")||user.getAge()==null||user.getSex()==null
                ||user.getSex().equals("")||user.getSal()==null||user.getBirth()==null||user.getBirth().equals("")){
            req.getSession().setAttribute(Constans.ERROR_USER,user);
            resp.setHeader("refresh","1;url=addUser.jsp");
            String message =
                    "<font size=\"6\">保存失败，检查数据合法性！</font><br/>";
            ServletOutputStream os = resp.getOutputStream();
            os.write(message.getBytes());
            os.flush();
            os.close();
            return;
        }
        userDao.add(user);
        resp.setHeader("refresh","1;url=select");
        String message =
                "<font size=\"6\">保存成功！</font><br/>";
        ServletOutputStream os = resp.getOutputStream();
        os.write(message.getBytes());
        os.flush();
        os.close();

    }
}
