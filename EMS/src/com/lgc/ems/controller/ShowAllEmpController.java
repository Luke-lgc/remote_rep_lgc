package com.lgc.ems.controller;

import com.lgc.ems.entity.Emp;
import com.lgc.ems.entity.Page;
import com.lgc.ems.service.EmpService;
import com.lgc.ems.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowAllEmpController",value = "/manager/safe/showAllEmp")
public class ShowAllEmpController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.权限验证 -- filter完成
        //2.调用业务逻辑
        String pageIndex = request.getParameter("pageIndex");
        if(pageIndex == null){
            pageIndex = "1";

        }
        Page page = new Page(Integer.valueOf(pageIndex));

        EmpService empService = new EmpServiceImpl();
        List<Emp> empList = empService.showAllEmpByPage(page);

        request.setAttribute("empList",empList);
        request.setAttribute("page",page);

        request.getRequestDispatcher("/empList.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
