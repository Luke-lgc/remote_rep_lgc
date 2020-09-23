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

@WebServlet(name = "ShowEmpController",value = "/manager/safe/showEmp")
public class ShowEmpController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.收参
        Integer id = Integer.valueOf(request.getParameter("id"));

        //2.根据id 做一次查询拿到最新的信息，然后保存在request作用域里面，传递到showUpdateEmpInfoJSP展示修改员工信息的页面
        EmpService empService = new EmpServiceImpl();
        Emp emp = empService.selectEmpById(id);
        //存在request作用域里，临时数据传递
        request.setAttribute("emp",emp);

        request.getRequestDispatcher("/updateEmp.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
