<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2023-08-22
  Time: 오후 8:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h3>로그인 페이지</h3>

    <form action="userLogin.do" method="post">

      ID : <input type="text" name="userId"/> <br>
      비밀번호 : <input type="password" name="userPass"> <br>

      <input type="submit" value="로그인">

    </form>

    <a href="userLogout.do">로그아웃</a> <br>

    <a href="userLogout.do">게시물 작성</a>

  </body>
</html>
