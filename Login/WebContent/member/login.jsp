<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

</head>
<body>
	<c:if test = "${!empty sessionScope.id}">
		<a href="<%=request.getContextPath() %>/editForm.do">��������</a>
		<a href="<%=request.getContextPath() %>/logout.do">�α׾ƿ�</a>
		<a href="<%=request.getContextPath() %>/del.do">Ż��</a>
		<a href="<%=request.getContextPath() %>/boardForm.do">�۾���</a>
	</c:if>
</body>
</html>