package com.dev.controller.postController;

import com.dev.controller.Controller;
import com.dev.dao.PostDao;
import com.dev.dto.CreatePostDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CreatePostController implements Controller {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String postTitle = request.getParameter("postTitle");
        String postContent = request.getParameter("postContent");

        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("loginSuccess");

        if(userId.isEmpty()){
            request.setAttribute("error", "로그인을 먼저 해주시기 바랍니다.");
        }
        String ctx = request.getContextPath();

        CreatePostDto createPostDto = new CreatePostDto(postTitle, postContent, userId);
        PostDao postDao = PostDao.getInstance();

        int cnt = postDao.postInsert(createPostDto);

        if(cnt > 0){
            response.sendRedirect(ctx + "/result/postListOutput.jsp");
        }else{
            throw new ServletException("NOT INSERT");
        }



    }
}
