<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/edit.do" method="post" name="f">
		<table border="1" cellspacing="0">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" readonly value="${m.id}"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd" value="${m.pwd}"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${m.pwd}"></td>
			</tr>
			<tr>
				<td>가입인사</td>
				<td><input type="text" name="msg" value="${m.msg}"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정"></td>
			</tr>
		</table>	
	</form>
</body>
</html>