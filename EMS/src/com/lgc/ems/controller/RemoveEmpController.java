package com.lgc.ems.controller;

import com.lgc.ems.service.EmpService;
import com.lgc.ems.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RemoveEmpController",value = "/manager/safe/removeEmp")
public class RemoveEmpController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //将id（String类型）转换成Integer类型  收参
        Integer id = Integer.valueOf(request.getParameter("id"));

        EmpService empService = new EmpServiceImpl();
        //删除id=？的员工
        empService.removeEmp(id);

        //删除完成之后，跳转到查询所有的界面，删除一次员工就要重新做一次查询所有
        response.sendRedirect(request.getContextPath()+"/manager/safe/showAllEmp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
