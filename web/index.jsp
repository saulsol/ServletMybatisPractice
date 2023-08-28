
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
  <head>
    <title>$Title$</title>

    <script>
      function logout(){
        location.href="${ctx}/userLogout.do"
      }

      function createPost(){
        location.href="${ctx}/createPost.jsp"
      }

    </script>

    <style>
      body {
        font-family: Arial, sans-serif;
        background-color: #f0f5e9;
        color: #333;
        margin: 0;
        padding: 0;
      }

      h3 {
        color: #2a8b59;
      }

      form {
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
      }

      input[type="text"],
      input[type="password"],
      input[type="submit"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
      }

      input[type="submit"] {
        background-color: #2a8b59;
        color: white;
        border: none;
        cursor: pointer;
      }

      button {
        background-color: #2a8b59;
        color: white;
        border: none;
        padding: 10px 20px;
        margin-top: 10px;
        border-radius: 4px;
        cursor: pointer;
      }

      button:hover {
        background-color: #1d6340;
      }
    </style>


  </head>
  <body>
    <h3>로그인 페이지</h3>

    <form action="userLogin.do" method="post">

      ID : <input type="text" name="userId"/> <br>
      비밀번호 : <input type="password" name="userPass"> <br>

      <input type="submit" value="로그인">

    </form>

    <button onclick="logout()">로그아웃</button>

    <button onclick="createPost()">게시물 작성</button>



  </body>
</html>
