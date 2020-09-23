package com.lgc.ems.controller;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CreateCodController",value = "/createCode")
public class CreateCodController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建一个ValidateCode对象
        ValidateCode validateCode = new ValidateCode(200,30,4,20);
        //将生成的验证码转成String类型
        String codes = validateCode.getCode();
        //将验证码保存在session作用域里面
        HttpSession session = request.getSession();
        session.setAttribute("codes",codes);

        //将验证码响应给客户端
        validateCode.write(response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
