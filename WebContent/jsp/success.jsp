<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>恭喜你，答对了</title>
</head>
<body>
	<h3>恭喜你，猜对了</h3>
	<% 
		int time = (Integer)session.getAttribute("time");
		int rnum = (Integer)session.getAttribute("rnum");
	%>
	<h3>您共猜了<%=time %>次，这个数字是<%=rnum %></h3>
	<h3>单击超链接返回inputGuess.jsp界面</h3>
	<br/>
	<a href="inputGuess.jsp">inputGuess.jsp</a>
</body>
</html>