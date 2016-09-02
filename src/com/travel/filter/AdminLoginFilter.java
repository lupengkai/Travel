package com.travel.filter;

/**
 * Created by tage on 4/4/16.
 */

import com.travel.model.Admin;
import com.travel.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminLoginFilter extends HttpServlet implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest sRequest, ServletResponse sResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) sRequest;
        HttpServletResponse response = (HttpServletResponse) sResponse;
        HttpSession session = request.getSession();
        String url = request.getServletPath();
        /*String contextPath=request.getContextPath();*/
        if (url.equals("")) url += "/";
        if (url.startsWith("/admin") && !url.equals("/admin/login") && !url.startsWith("/admin/login_in")) {//若访问后台资源 过滤到login
            Admin admin = (Admin) session.getAttribute("admin");
            if (admin == null) {//转入管理员登陆页面
                /*response.sendRedirect(contextPath+"/login.jsp"); */
                session.setAttribute("error_message", "please login in first");
                response.sendRedirect("/admin/login");
            }
        }
        filterChain.doFilter(sRequest, sResponse);
    }

    public void init(FilterConfig arg0) throws ServletException {

    }
}