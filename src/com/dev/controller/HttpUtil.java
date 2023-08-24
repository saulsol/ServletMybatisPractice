package com.dev.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpUtil {

    public static void forward(HttpServletRequest request,
                               HttpServletResponse response, String path){

        try {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
            requestDispatcher.forward(request, response);
        }catch (Exception ex){
            System.out.println("forward 오류" + ex);
        }

    }
}
