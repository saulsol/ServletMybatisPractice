package com.dev.controller.userController;

import com.dev.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserLogoutController implements Controller {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.removeAttribute("loginSuccess");
        System.out.println("로그아웃 성공!");

        String ctx = request.getContextPath();

        response.sendRedirect(ctx + "/index.jsp");

    }
}
