<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./temp/boot.jsp"></c:import>
<link href="/css/test.css" rel=stylesheet>
<script defer src="/js/test.js"></script>
</head>
<body>
	<h1>Test</h1>
	<div>
		<c:choose>
			<c:when test="${not empty member}">

				<a href="./member/logout">로그아웃</a>
        		<a href="./member/join">회원가입</a>
				<a href="./qna/list">게시판</a>
			</c:when>
			<c:otherwise>
			<!-- 	<a href="./member/login">로그인</a>
				<a href="./member/join">회원가입</a> -->
				<a href="./qna/list">게시판</a>
			</c:otherwise>
		</c:choose>
	</div>
	<img src="./images/winter2.jpg">

</body>
</html>