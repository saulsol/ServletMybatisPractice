<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2023-08-22
  Time: 오후 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>회원가입</h3>
    ${error}


    <form action="userInsert.do" method="post">

        ID : <input type="text" name="userId"/> <br>
        비밀번호 : <input type="password" name="userPass"> <br>
        이름 : <input type="text" name="userName"/>

        <input type="submit" value="가입">

    </form>



</body>
</html>
