<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
  request.setCharacterEncoding("UTF-8");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:useBean id="car" class="entity.Car" scope="session"/>
<title>输入信息</title>
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
<a href="showCar.jsp">访问showCar.jsp，查看有关信息</a>
</body>
</html>