<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var m = '${message}';
	if(m!=""){
		alert(m);		
	}
</script>
</head>
<body>
	<h1>NOTICE LIST</h1>
	<hr>
	<a href="noticeWrite">write</a>
	<hr>
	<table>
		<tr>
			<td>NUM</td>
			<td>TITLE</td>
			<td>WRITER</td>
			<td>DATE</td>
			<td>HIT</td>
		</tr>
		
			<c:forEach items="${list}" var="dto">
		<tr>			
			<td>${dto.num}</td>
			<td><a href="noticeView?num=${dto.num}">${dto.title}</a></td>
			<td>${dto.writer}</td>
			<td>${dto.reg_date}</td>
			<td>${dto.hit}</td>
		</tr>
			</c:forEach>
		
		
	</table>
	
	
</body>
</html>