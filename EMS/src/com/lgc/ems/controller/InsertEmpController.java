package com.lgc.ems.controller;

import com.lgc.ems.entity.Emp;
import com.lgc.ems.service.EmpService;
import com.lgc.ems.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertEmpController",value = "/manager/safe/insertEmp")
public class InsertEmpController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //收参
        String name = request.getParameter("name");
        Double salary = Double.valueOf(request.getParameter("salary"));
        Integer age = Integer.valueOf(request.getParameter("age"));

        //封装对象
        Emp emp = new Emp(name,salary,age);

        //调用业务逻辑
        EmpService empService = new EmpServiceImpl();
        empService.addEmp(emp);

        //新增成功之后，重定向到查询所有员工信息页面
        response.sendRedirect(request.getContextPath()+"/manager/safe/showAllEmp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
