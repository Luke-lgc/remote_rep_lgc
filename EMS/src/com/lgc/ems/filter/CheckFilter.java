package com.lgc.ems.filter;

import com.lgc.ems.entity.EmpManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 管理员权限验证
 */
@WebFilter(value = "/manager/safe/*")
public class CheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //实现ShowAllEmpController层的权限验证
        //首先需要拆箱
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        //获取EmpManagerLoginController存储在session作用域的empManager
        EmpManager empManager = (EmpManager) session.getAttribute("empManager");
        if(empManager != null){ //登录过
            filterChain.doFilter(request,response);
        }else{
            //没有登录过，验证失败，重定向到登录页面
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
