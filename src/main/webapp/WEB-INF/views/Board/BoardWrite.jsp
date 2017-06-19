<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="freeboard${path}" method="post">
		<c:if test="${path eq 'update'}">		
		<p><input type="hidden" name="num" value="${dto.num}"></p> 	
		</c:if>
		<p>작성자 : <input type="text" name="writer" value="${dto.writer}"></p>
		<p>제목 : <input type="text" name="title" value="${dto.title}"></p>
		<p>내용 : <input type="text" name="contents"  value="${dto.contents}"></p>
		<input type="submit" value="전송">	
	</form>
</body>
</html>