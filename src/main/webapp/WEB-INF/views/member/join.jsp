<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
	<h1>회원가입</h1>

	<div class="row mb-3">
		<div class="col-lg-6">
			<form:form modelAttribute="memberVO" method="post">
				<div class="row">
					<label for="inputId" class="col-sm-2 col-form-label">아이디</label>
					<div class="col">
						<form:input path="id" cssClass="form-control" id="inputId" />
						<div id="idResult">
							<form:errors path="id"></form:errors>
						</div>
					</div>
				</div>
				<p>
				<div class="row mb-3">
					<label for="inputPassword" class="col-sm-2 col-form-label">비밀번호</label>
					<div class="col-sm-10">
						<form:password path="password" cssClass="form-control"
							id="inputPassword" />
						<form:errors path="password"></form:errors>
						<div id="pwResult"></div>
					</div>
				</div>

				<div class="row mb-3">
					<label for="inputPassword" class="col-sm-2 col-form-label">비밀번호재입력</label>
					<div class="col-sm-10">
						<form:password path="passwordCheck" cssClass="form-control"
							id="inputPasswordCheck" />
						<form:errors path="passwordCheck"></form:errors>
						<div id="pwcResult"></div>
					</div>
				</div>

				<div class="row mb-3">
					<label for="inputName" class="col-sm-2 col-form-label">이름</label>
					<div class="col-sm-10">
						<form:input path="name" cssClass="form-control" id="inputName" />
						<div id="nameResult">${name}</div>
					</div>
				</div>

				<div class="row mb-3">
					<label for="inputEmail" class="col-sm-2 col-form-label">이메일</label>
					<div class="col-sm-10">
						<form:input path="email" cssClass="form-control" id="inputEmail" />
						<form:errors path="email"></form:errors>
						<div id="emailResult"></div>
					</div>
				</div>

				<div class="row justify-content-end">
					<div>
						<button type="submit" id="joinButton" class="btn btn-dark">가입하기</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>

</body>
</html>