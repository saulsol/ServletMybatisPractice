package com.dev.controller.postController;

import com.dev.controller.Controller;
import com.dev.dao.PostDao;
import com.dev.dto.DisLikesDto;
import com.dev.dto.PostDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class PostDisLikesInsertController implements Controller {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // userId, postNum, 필요

        PostDao postDao = PostDao.getInstance();

        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("loginSuccess");

        int postNum = Integer.parseInt(request.getParameter("postNum"));



        if(postDao.isAlreadyDisLikes(userId,postNum) >=1){
            request.setAttribute("isAlreadyDisLikes", "yes");
        }else {
            postDao.insertDisLikes(new DisLikesDto(userId, postNum));
        }
        PostDto postDto = postDao.findById(postNum);
        request.setAttribute("postDto", postDto);
        request.setAttribute("likesCount", postDao.countPostLikes(postNum));
        request.setAttribute("disLikesCount", postDao.countPostDisLikes(postNum));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/result/postContentOutput.jsp");
        requestDispatcher.forward(request, response);
    }
}
