package com.dev.controller.postController;

import com.dev.controller.Controller;
import com.dev.dao.PostDao;
import com.dev.dto.PostDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PostListController implements Controller {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PostDao postDao = PostDao.getInstance();
        double totalSize = postDao.getTotalPostCount();
        int pageSize = (int) Math.ceil(totalSize/10);

        String sPageNum = request.getParameter("pageNum");
        if(sPageNum == null){
            sPageNum = "1";
        }

        int pageNum = Integer.parseInt(sPageNum);

        List<PostDto> list = postDao.getPostByPage(pageNum);

        request.setAttribute("pageSize", pageSize);
        request.setAttribute("list", list);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/result/postListOutput.jsp");
        requestDispatcher.forward(request, response);
    }
}
