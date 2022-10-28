<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
	<c:if test="${!empty user }">
			<table class="table">
				<thead>
					<tr>
						<th>항목</th>
						<th colspan="2">내용</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>이름</td>
						<td>${user.name }</td>
					</tr>
					<tr>
						<td>아이디</td>
						<td>${user.id }</td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td>${user.pass }</td>
					</tr>
				</tbody>
			</table>
		</c:if>
		<c:if test="${empty user }">
			<p>회원 정보가 없습니다.</p>
		</c:if>
</body>
</html>