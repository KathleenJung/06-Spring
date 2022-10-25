<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${root}/resources/css/basic.css" rel="stylesheet" type="text/css">
</head>
<body>
	<table	align="center" cellspacing="0" style="width:500px">
		<thead>
			<tr class="top">
				<td colspan="4" align="center">
					<jsp:include page="/WEB-INF/views/top.jsp" />
				</td>
			</tr>
			<tr><td colspan="4" class="caption"> 감독 목록 </td></tr>
			<tr><td colspan="4" class="bpadding"> &nbsp;</td></tr>
			<tr><td colspan="4" align="center" class="tspacial">
				<form action="${root }/director/search" method="post">
					 이름: <input type = "text" name = "name" value="${param.name}">
					 나이 : <input type = "number" name = "age" value="${param.age}">
					<input type="submit" value = "검색">
				</form>
			 </td></tr>
			 
			<tr><td colspan="4" class="bpadding"> &nbsp;</td></tr>
			<tr><th width="150" class="tbasic tspacial">아이디</td>
				<th width="150" class="tbasic tspacial">이름</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach  var="director"		items="${directorList}">
				<tr>
					<td width="150" class="tbasic">${director.id}</td>
					<td width="150" class="tbasic"><a href="${root}/director/detail?id=${director.id}">${director.name}</a></td>
				</tr>	
			</c:forEach>

		</tbody>
	</table>
</body>
</html>