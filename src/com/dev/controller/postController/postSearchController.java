package com.dev.controller.postController;

import com.dev.controller.Controller;
import com.dev.dao.PostDao;
import com.dev.dto.PostDto;
import com.dev.dto.PostSearchCountDto;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class postSearchController implements Controller {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PostDao postDao = PostDao.getInstance();
        String sPageNum = request.getParameter("pageNum");
        if(sPageNum == null){
            sPageNum = "1";
        }
        String postTitle = request.getParameter("search");
        String postContent = request.getParameter("search");

        int pageNum = Integer.parseInt(sPageNum);


        double totalSize = postDao.postSearchCount(new PostSearchCountDto(postTitle, postContent));
        int pageSize = (int) Math.ceil(totalSize/10);
        List<PostDto> list = postDao.postSearch(pageNum, postTitle, postContent);
        request.setAttribute("searching", request.getParameter("search"));
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("list", list);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/result/postSearchListOutput.jsp");
        requestDispatcher.forward(request, response);


    }
}
