<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<%
  request.setCharacterEncoding("UTF-8");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:useBean id="car" class="entity.Car" scope="request"></jsp:useBean>
<title>输入车辆信息</title>
</head>
<body>
<form action="" method=post name=form>
	<label>汽车牌号:</label><input type="text" name=number><br/>
	<label>汽车名称:</label><input type="text" name=name><br/>
	<label>汽车生产日期:</label><input type="text" name=birth><br/>
<input type=submit value="提交">
</form>
<jsp:setProperty property="number" name="car"/>
<jsp:setProperty property="name" name="car"/>
<jsp:setProperty property="birth" name="car"/>
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
<style>
table,table tr th, table tr td{ 
 	border:1px solid #000; 
 	border-collapse:collapse;
 	text-align:center;
}
table td{
	padding: 10px;
}
</style>
</html>