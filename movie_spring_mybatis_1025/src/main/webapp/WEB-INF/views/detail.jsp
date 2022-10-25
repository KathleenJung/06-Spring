<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>감독 상세정보</title>
<link href="${root}/resources/css/basic.css" rel="stylesheet" type="text/css">

</head>
<body>
<table align="center" cellspacing="0" style="width:500px">
<thead>
<tr class="top">
	<td colspan="2" align="center">
		<jsp:include page="/WEB-INF/views/top.jsp" />
	</td>
</tr>
<tr><td colspan="2" class="caption"> 감독 상세정보</td></tr>
<tr><td colspan="2" class="bpadding"> &nbsp;</td></tr>
<tr><td colspan="2" class="tbasic tspacial"> &nbsp;</td></tr>
</thead>
<form method="post"	action="${root}/director/modify">
<tbody>
<tr>
	<td class="tbasic">감독ID</td>
	<td class="tbasic"><input type="text" size="10" name="id" value="${director.id}" readonly="readonly"/></td>
</tr>	
<tr>
	<td class="tbasic">감독이름</td>
	<td class="tbasic"><input type="text" size="40" name="name" value="${director.name}" readonly="readonly"/></td>
</tr>	
<tr>
	<td class="tbasic">감독나이</td>
	<td class="tbasic"><input type="number" size="40" name="age" value="${director.age}"/></td>
</tr>	
<tr>
	<td class="tbasic">감독수상횟수</td>
	<td class="tbasic"><input type="number" size="40" name="winnerCount" value="${director.winnerCount}"/></td>
</tr>	
<tr><td colspan="2" class="bpadding"> &nbsp;</td></tr>
<tr><td colspan="2" align="center" class="tspacial tfoot">
 <input type="submit"  value="수정">
 <input type="submit"  value="삭제" formaction="${root}/director/remove">
 <input type="reset"  value="취소">
 </td></tr>
 </tbody>
</form>
</table>

<table align="center" cellspacing="0" style="width:500px">
	<thead>
		<tr><td colspan="3" class="caption">연출영화리스트</td></tr>
		<tr>
			<th class="tbasic tspacial">영화ID</th>
			<th class="tbasic tspacial">영화명</th>
			<th class="tbasic tspacial">개봉년도</th>
		</tr>
	</thead>
	<tbody>
	<c:choose>
		<c:when test="${director.movies[0].title != null}">
			<c:forEach items="${director.movies}" var="movie"> 
				<tr>
					<td class="tbasic">${movie.id}</td>
					<td class="tbasic">${movie.title}</td>
					<td class="tbasic">${movie.year}</td>
				</tr>	
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="3" class="tbasic">연출한 영화가 없습니다.</td>
			</tr>
		</c:otherwise>
	</c:choose>
	</tbody>
</table>

</body>
</html>
