package com.yjf.filter;

import com.yjf.Constants.Constans;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

/**
 * @author 余俊锋
 * @date 2020/9/18 16:33
 * @Description
 */
@WebFilter("/*")
public class CookieFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path = request.getRequestURI();
        Cookie[] cookies = request.getCookies();
        int index = 0;
        String cookieName = null;
        String cookiePassword = null;
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(Constans.NAME)) {
                    cookieName = cookie.getValue();
                    index++;
                }
                if (cookie.getName().equals(Constans.PASSWORD)) {
                    cookiePassword=cookie.getValue();
                    index++;
                }
            }
        }
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        if (!(path.endsWith("index.jsp") || path.endsWith("login") || path.endsWith("/")||path.startsWith("/fav"))) {
            //存在cookies
            if (index == 2 ) {
                session.setAttribute(Constans.SESSION_NAME, cookieName);
            }
        }else {
            if (index == 2 ) {
                session.setAttribute(Constans.SESSION_NAME, cookieName);
                session.setAttribute(Constans.COOKIE_NAME,cookieName);
                session.setAttribute(Constans.COOKIE_PASSWORD,cookiePassword);
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
