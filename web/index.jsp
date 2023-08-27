
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

      function likesPost(){
        location.href="${ctx}/userLikesPost.do"
      }


    </script>


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

    <button>회원이 좋아요 누른 글 목록</button>


  </body>
</html>
