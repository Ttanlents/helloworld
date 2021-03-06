package com.yjf.servlet;

import com.yjf.entity.Page;
import com.yjf.entity.User;
import com.yjf.service.UserService;
import com.yjf.userdao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 余俊锋
 * @date 2020/9/16 11:31
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    UserDao userDao=new UserService();
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if (idStr==null||idStr.length()==0){
            return;
        }
        int id = Integer.parseInt(idStr);
        userDao.delete(id);

        Integer pageCurrent=1;
        String name = req.getParameter("name");
        String pagStr=req.getParameter("pageCurrent");
        if (name==null){
            name="";
        }
        if (pagStr!=null&&!pagStr.equals("")){
            pageCurrent=Integer.parseInt(pagStr);
        }
        int count = userDao.selectCount();
        Page<List<User>> page=new Page(pageCurrent,4,count);
        List<User> list = userDao.selectAll(name, page);
        page.setData(list);
        req.setAttribute("name",name);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/userList.jsp").forward(req,resp);
    }
}
