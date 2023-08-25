package com.dev.controller.postController;

import com.dev.controller.Controller;
import com.dev.dao.PostDao;
import com.dev.dto.CreatePostDto;

import javax.servlet.RequestDispatcher;
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


        CreatePostDto createPostDto = new CreatePostDto(postTitle, postContent, userId);
        PostDao postDao = PostDao.getInstance();
        int cnt = postDao.postInsert(createPostDto);

        request.setAttribute("list", postDao.getPostByPage(1));

        if(cnt > 0){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/result/postListOutput.jsp");
            requestDispatcher.forward(request, response);
        }else{
            throw new ServletException("NOT INSERT");
        }



    }
}
