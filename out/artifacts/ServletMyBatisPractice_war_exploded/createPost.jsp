<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2023-08-24
  Time: 오후 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>게시물 작성</title>
</head>
<body>
<h3>게시물 작성 폼</h3>
<form action="createPost.do" method="post">
  <label for="title">제목:</label>
  <input type="text" id="title" name="postTitle" required><br><br>

  <label for="content">내용:</label><br>
  <textarea id="content" name="postContent" rows="4" cols="50" required></textarea><br><br>

  작성자:<%=session.getAttribute("loginSuccess")%> <br>


  <input type="submit" value="작성">
</form>
</body>
</html>
