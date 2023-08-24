package com.dev.controller.userController;

import com.dev.controller.Controller;
import com.dev.dao.UserDao;
import com.dev.dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserInsertController implements Controller {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("userId");
        String userPass = request.getParameter("userPass");
        String userName = request.getParameter("userName");

        if(id.isEmpty() || userPass.isEmpty() || userName.isEmpty()){
            request.setAttribute("error", "모든 항목을 빠짐없이 입력해주시기 바랍니다!");
        }

        UserDto userDto = new UserDto();
        userDto.setUserId(id);
        userDto.setUserName(userName);
        userDto.setUserPass(userPass);

        UserDao userDao = UserDao.getInstance();
        int cnt = userDao.userInsert(userDto);


        String ctx = request.getContextPath();

        if(cnt > 0){
            response.sendRedirect(ctx+ "/result/memberListOutput.jsp");
        }else{
            throw new ServletException("not insert");
        }


    }
}
