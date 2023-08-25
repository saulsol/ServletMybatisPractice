
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>

    <script>
        function renderPostPage(num){
            location.href="${ctx}/postList.do?pageNum="+num;
        }


    </script>



</head>
<body>
<table class="table table-bordered">
    <tr>
        <td>게시물 번호</td>
        <td>게시물 제목</td>
        <td>유저 아이디</td>
    </tr>

    <c:forEach var="postDto" items="${requestScope.list}">
        <tr>
        <td>${postDto.postNum}</td>
        <td><a href="postContent.do?postNum=${postDto.postNum}">${postDto.postTitle}</a></td>
        <td>${postDto.userId}</td>
        </tr>
    </c:forEach>

    <c:forEach var="cnt" begin="1" end="${requestScope.pageSize}" step="1">
        <button onclick="renderPostPage(${cnt})"> ${cnt}</button>
    </c:forEach>

</table>

<br>




</body>
</html>
