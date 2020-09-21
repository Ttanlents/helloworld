package com.yjf.Listener;

import com.yjf.Constants.Constans;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author 余俊锋
 * @date 2020/9/19 13:59
 * @Description
 */
@WebListener
public class ApplicationListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute(Constans.COUNT, 0);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
