package com.dev.controller.postController;

import com.dev.controller.Controller;
import com.dev.dao.PostDao;
import com.dev.dto.PostDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PostContentController implements Controller {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PostDao postDao = PostDao.getInstance();

        int postNum = Integer.parseInt(request.getParameter("postNum"));
        PostDto postDto = postDao.findById(postNum);
        request.setAttribute("postDto", postDto);

        // 좋아요 개수랑 싫어요 개수 리턴해줘야 함
        int likesCount = postDao.countPostLikes(postNum);
        int disLikesCount = postDao.countPostDisLikes(postNum);

        request.setAttribute("likesCount", likesCount);
        request.setAttribute("disLikesCount", disLikesCount);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/result/postContentOutput.jsp");
        requestDispatcher.forward(request, response);


    }
}
