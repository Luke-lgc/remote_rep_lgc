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


@WebServlet(name = "UpdateEmpController",value = "/manager/safe/updateEmp")
public class UpdateEmpController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.update.jsp 收参
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        Double salary = Double.valueOf(request.getParameter("salary"));
        Integer age = Integer.valueOf(request.getParameter("age"));

        Emp emp = new Emp(id,name,salary,age);

        //2.调用业务逻辑
        EmpService empService = new EmpServiceImpl();
        empService.modifyEmp(emp);

        //3.修改完成之后，重新显示查询所有的员工界面，所以重定向到ShowAllEmpController
        response.sendRedirect(request.getContextPath()+"/manager/safe/showAllEmp");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
