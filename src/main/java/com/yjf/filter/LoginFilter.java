package com.yjf.filter;

import com.yjf.Constants.Constans;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 余俊锋
 * @date 2020/9/18 12:11
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        String path=request.getRequestURI();
        if (!(path.endsWith("index.jsp")||path.endsWith("login")||path.endsWith("/"))){
            Object session = request.getSession().getAttribute(Constans.SESSION_NAME);
            if (session==null||session.equals("")){
                response.sendRedirect("/index.jsp");
                return;
            }
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
