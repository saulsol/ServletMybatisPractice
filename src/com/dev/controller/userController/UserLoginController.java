package com.dev.controller.userController;

import com.dev.controller.Controller;
import com.dev.controller.HttpUtil;
import com.dev.dao.UserDao;
import com.dev.dto.UserLoginDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserLoginController implements Controller {

    // 유저 로그인 상황

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("userId");
        String userPass = request.getParameter("userPass");

        if(id.isEmpty() || userPass.isEmpty()){
            request.setAttribute("error", "모든 항목을 빠짐없이 입력해주시기 바랍니다!");
        }

        UserLoginDto loginDto = new UserLoginDto();
        loginDto.setUserId(id);
        loginDto.setUserPass(userPass);

        UserDao userDao = UserDao.getInstance();
        String userId = userDao.findByUserIdAndUserPass(loginDto);

        String ctx = request.getContextPath();

        if(userId == null){
            response.sendRedirect(ctx+ "/index.jsp");
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("loginSuccess", userId);
            System.out.println("로그인 성공!");
            response.sendRedirect(ctx+ "/result/postListOutput.jsp");
        }




    }
}
