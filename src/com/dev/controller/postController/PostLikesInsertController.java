package com.dev.controller.postController;

import com.dev.controller.Controller;
import com.dev.dao.PostDao;
import com.dev.dto.DisLikesDto;
import com.dev.dto.LikesDto;
import com.dev.dto.PostDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class PostLikesInsertController implements Controller {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PostDao postDao = PostDao.getInstance();

        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("loginSuccess");

        int postNum = Integer.parseInt(request.getParameter("postNum"));

        if(postDao.isAlreadyLikes(userId,postNum) >= 1){

            session.setAttribute("duplicateLikes", "이미 좋아요를 누른 게시글입니다");

        }else {
            postDao.insertLikes(new LikesDto(userId, postNum));
        }
        PostDto postDto = postDao.findById(postNum);
        request.setAttribute("postDto", postDto);
        request.setAttribute("likesCount", postDao.countPostLikes(postNum));
        request.setAttribute("disLikesCount", postDao.countPostDisLikes(postNum));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/result/postContentOutput.jsp");
        requestDispatcher.forward(request, response);
    }
}
