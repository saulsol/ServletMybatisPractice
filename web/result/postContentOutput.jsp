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
