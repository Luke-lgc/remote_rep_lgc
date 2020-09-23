package com.lgc.ems.controller;

import com.lgc.ems.entity.EmpManager;
import com.lgc.ems.service.EmpManagerService;
import com.lgc.ems.service.impl.EmpManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "EmpManagerLoginController",value = "/manager/empManagerLogin")
public class EmpManagerLoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决编码问题 -- filter完成
        //1.收参
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String inputVcode = request.getParameter("inputVcode");

        //在session作用域中拿到验证码字符串，进行判断
        String codes = (String) request.getSession().getAttribute("codes");
        if(!inputVcode.isEmpty() && inputVcode.equalsIgnoreCase(codes)){
            //2.调用业务逻辑
            EmpManagerService empManagerService = new EmpManagerServiceImpl();
            EmpManager empManager = empManagerService.login(username,password);
            if(empManager != null){
                //登录成功
                HttpSession session = request.getSession();
                session.setAttribute("empManager",empManager);

                //跳转到查询所有员工信息的页面
                response.sendRedirect(request.getContextPath()+"/manager/safe/showAllEmp");
            }else {
                //登录失败，重定向到登录页面
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }
        }else {
            //验证码验证失败,重定向到登录页面
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
