<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>감독 등록</title>
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
<tr><td colspan="2" class="caption"> 감독 등록</td></tr>
<tr><td colspan="2" class="bpadding"> &nbsp;</td></tr>
<tr><td colspan="2" class="tbasic tspacial"> &nbsp;</td></tr>
</thead>
<form method="post"action="${root}/director/register">
<tbody>
<tr>
	<td class="tbasic">감독ID</td>
	<td class="tbasic"><input type="text" size="10" name="id"/></td>
</tr>	
<tr>
	<td class="tbasic">감독이름</td>
	<td class="tbasic"><input type="text" size="40" name="name"/></td>
</tr>	
<tr>
	<td class="tbasic">감독나이</td>
	<td class="tbasic"><input type="number" size="40" name="age"/></td>
</tr>	
<tr>
	<td class="tbasic">감독수상횟수</td>
	<td class="tbasic"><input type="number" size="40" name="winnerCount"/></td>
</tr>	

<tr><td colspan="2" class="bpadding"> &nbsp;</td></tr>
<tr><td colspan="2" align="center" class="tspacial tfoot">
 <input type="submit"  value="등록">
 <input type="reset"  value="취소">
 </td></tr>
 </tbody>
</form>
</table>
</body>
</html>
