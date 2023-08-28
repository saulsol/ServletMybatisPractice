package com.dev.controller.postController;

import com.dev.controller.Controller;
import com.dev.dao.PostDao;
import com.dev.dto.PostDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UserLikesPostController implements Controller {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 유저 로그인 id 값, 필요

        PostDao postDao = PostDao.getInstance();
        String sPageNum = request.getParameter("pageNum");

        if(sPageNum == null){
            sPageNum = "1";
        }
        int pageNum = Integer.parseInt(sPageNum);
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("loginSuccess");

        List<PostDto> list = postDao.userLikesPost(userId, pageNum);

        double totalSize = postDao.userLikesPostCount(userId);
        int pageSize = (int) Math.ceil(totalSize/10);

        request.setAttribute("pageSize", pageSize);
        request.setAttribute("list", list);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/result/userLikesPostOutput.jsp");
        requestDispatcher.forward(request, response);
    }
}
