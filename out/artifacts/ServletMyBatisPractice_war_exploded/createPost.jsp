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
<h1>게시물 작성 폼</h1>
<form action="/submit" method="post">
  <label for="title">제목:</label>
  <input type="text" id="title" name="title" required><br><br>

  <label for="content">내용:</label><br>
  <textarea id="content" name="content" rows="4" cols="50" required></textarea><br><br>

  <label for="author">작성자:</label>
  <input type="text" id="author" name="author" required><br><br>

  <input type="submit" value="작성">
</form>
</body>
</html>
