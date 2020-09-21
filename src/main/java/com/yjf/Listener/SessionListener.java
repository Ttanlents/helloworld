package com.yjf.Listener;

import com.yjf.Constants.Constans;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.Objects;

/**
 * @author 余俊锋
 * @date 2020/9/18 17:53
 * @Description
 */
@WebListener
public class SessionListener implements HttpSessionAttributeListener {

    public SessionListener() {
        super();

        System.out.println("session属性监听器初始化完成");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        int number=0;
        ServletContext application = se.getSession().getServletContext();
        if (Objects.equals(se.getName(), Constans.SESSION_NAME)){
             number =(int) application.getAttribute(Constans.COUNT);
            System.out.println("原来的人数"+number);
            application.setAttribute(Constans.COUNT,++number);
            System.out.println("当前"+application.getAttribute(Constans.COUNT));
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        ServletContext application = se.getSession().getServletContext();
        if (Objects.equals(se.getName(), Constans.SESSION_NAME)){
           int  number =(int) application.getAttribute(Constans.COUNT);
            application.setAttribute(Constans.COUNT,--number);
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {

    }
}
