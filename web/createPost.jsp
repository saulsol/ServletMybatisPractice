
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>게시물 작성</title>
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

    label {
      font-weight: bold;
      display: block;
      margin-bottom: 5px;
    }

    input[type="text"],
    textarea {
      width: 100%;
      padding: 10px;
      margin-bottom: 10px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    textarea {
      resize: vertical;
    }

    input[type="submit"] {
      background-color: #2a8b59;
      color: white;
      border: none;
      padding: 10px 20px;
      border-radius: 4px;
      cursor: pointer;
    }

    input[type="submit"]:hover {
      background-color: #1d6340;
    }
  </style>

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
