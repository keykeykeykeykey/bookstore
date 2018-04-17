<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entity.*" %>
<% 
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:useBean id="car" class="entity.Car" scope="session"/>
<title>查看信息</title>
</head>
<body>
<table>
	<tr>
		<th>汽车牌号</th>
		<th>汽车名称</th>
		<th>汽车生产日期</th>
	</tr>
	<tr>
		<td><jsp:getProperty name="car" property="number"/></td>
		<td><jsp:getProperty name="car" property="name"/></td>
		<td><jsp:getProperty name="car" property="birth"/></td>
	</tr>
</table>
</body>
</html>