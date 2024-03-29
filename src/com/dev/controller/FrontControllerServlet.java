package com.dev.controller;

import com.dev.controller.postController.*;
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

        // 유저 컨트롤러
        list.put("/userInsert.do", new UserInsertController());
        list.put("/userSearch.do", new UserSearchController());
        list.put("/userUpdate.do", new UserUpdateController());
        list.put("/userDelete.do", new UserDeleteController());
        list.put("/userList.do", new UserListController());
        list.put("/userLogin.do", new UserLoginController());
        list.put("/userLogout.do", new UserLogoutController());

        // 게시물 컨트롤러
        list.put("/createPost.do", new CreatePostController());
        list.put("/postList.do", new PostListController());
        list.put("/postContent.do", new PostContentController());
        list.put("/postLike.do", new PostLikesInsertController());
        list.put("/postDisLike.do", new PostDisLikesInsertController());

        // 게시물 검색 컨트롤러
        list.put("/postSearchController.do", new postSearchController());

        // 유저가 좋아요 누른 게시물들
        list.put("/userLikesPost.do", new UserLikesPostController());


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
