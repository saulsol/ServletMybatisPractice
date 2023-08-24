package com.dev.controller;

import com.dev.controller.userController.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;


public class FrontControllerServlet extends HttpServlet {

    String charSet = null;
    HashMap<String, Controller> list = null;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        charSet = servletConfig.getInitParameter("charset");
        list = new HashMap<String, Controller>();
        list.put("/userInsert.do", new UserInsertController());
        list.put("/userSearch.do", new UserSearchController());
        list.put("/userUpdate.do", new UserUpdateController());
        list.put("/userDelete.do", new UserDeleteController());
        list.put("/userList.do", new UserListController());
        list.put("/userLogin.do", new UserLoginController());
        list.put("/userLogout.do", new UserLogoutController());

    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(charSet);
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        String path = url.substring(contextPath.length());

        Controller subController = list.get(path);
        subController.execute(req,resp);
    }
}
