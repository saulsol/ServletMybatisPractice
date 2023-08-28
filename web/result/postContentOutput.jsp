<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>

    <script>

        function postLike(postNum){

            location.href="${ctx}/postLike.do?postNum="+postNum;
        }

        function postDisLike(postNum){

            location.href="${ctx}/postDisLike.do?postNum="+postNum;
        }

        function goToPostList(){
            location.href="${ctx}/postList.do"
        }



    </script>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f5e9;
            color: #333;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        h3 {
            color: #2a8b59;
        }

        textarea {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
            resize: vertical;
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

        .alert {
            color: red;
            margin-top: 10px;
        }
    </style>

</head>
<body>

        <h3>게시물 제목 : ${requestScope.postDto.postTitle}</h3>


        <label>
            게시물 내용 :<br>
            <textarea rows="10" cols="80" readonly>
                ${requestScope.postDto.postContent}
            </textarea>
        </label>

        <c:if test="${not empty sessionScope.duplicateLikes}">

            <script>
                alert("${sessionScope.duplicateLikes}")
            </script>

        </c:if>

        <c:if test="${not empty sessionScope.duplicateDisLikes}">

            <script>
                alert("${sessionScope.duplicateDisLikes}")
            </script>

        </c:if>





        <button onclick="postLike(${requestScope.postDto.postNum})">좋아요 + ${requestScope.likesCount}</button>
        <button onclick="postDisLike(${requestScope.postDto.postNum})">싫어요 - ${requestScope.disLikesCount}</button>

        <br>
        <button onclick="goToPostList()">게시물 목록으로 가기</button>


</body>
</html>
