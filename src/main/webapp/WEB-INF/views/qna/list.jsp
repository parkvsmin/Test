<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
	<h1>게시판 리스트</h1>
	
				<form action="./list"
					class="row row-cols-lg-auto g-3 align-items-center">
			<div class="col-12">
						 <select
							name="kind" class="form-select" id="Kind">
							<option class="kinds" value="num">글번호</option>
							<option class="kinds" value="writer">작성자</option>
							<option class="kinds" value="title">제목</option>
						</select>
					</div>

					<div class="col-12">
						<label class="visually-hidden" for="search">Search</label>
						<div class="input-group">
							<input type="text" name="search" value="${param.search}"
								class="form-control" id="search" placeholder="Search">
						</div>
					</div>
					
					<div class="col-12">
						<button type="submit" class="btn btn-dark">검색어찾기</button>
					</div>
					</form>
	
	<table class="table table-striped">
				<thead>
					<tr>
						<th>글번호</th>
						<th>작성자</th>
						<th>제목</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="dto">
						<tr>
						<c:catch>
						<c:forEach begin="1" end="${dto.depth}">--</c:forEach>
						</c:catch>
							<td><a href="detail?num=${dto.num}">${dto.num}</a></td>
							<td>${dto.title}</td>
							<td>${dto.writer}</td>
							<td>${dto.regDate}</td>
							<td>${dto.hit}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<c:if test="${pager.pre}">
						<li class="page-item"><a class="page-link"
							href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">Previous</a>
						</li>
					</c:if>
					<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
						<li class="page-item"><a class="page-link"
							href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
					</c:forEach>

					<li class="page-item ${pager.next?'':'disabled'}"><a
						class="page-link"
						href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">Next</a>
					</li>
				</ul>
			</nav>
			
			<div class="mb-3">
				<a href="./add" class="btn btn-dark">글쓰기</a>
			</div>
			
			<script type="text/javascript">
			let result = '${param.result}';
			if(result !="") {
				if(result =='1') {
					alert('등록성공');
				}else {
					alert('등록실패');
				}
			}
			</script>
</body>
</html>

