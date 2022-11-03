<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
	<h1>로그인</h1>

	<section class="container-fluid ">
		<div class="row">
			<form action="./login" method="post" id="frm">
				<div class="mb-3">
					<label for="id" class="form-label">아이디</label> <input type="text"
						name="id" class="form-control" id="id"
						aria-describedby="emailHelp">
					<div id="emailHelp" class="form-text"></div>
				</div>
				<div class="mb-3">
					<label for="password" class="form-label">비밀번호</label> <input
						type="password" name="password" class="form-control" id="password">
				</div>
			
				<button type="submit" class="btn btn-dark" id="btn">Submit</button>
			</form>

		</div>
	</section>


</body>
</html>