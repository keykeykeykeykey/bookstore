<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>这是一个简单的jsp页面</h1>
	<% int i,sum=0;
		for(i=1;i<100;i++)
			sum+=i;
	%>
	<h5> 1到100的连续和为:
	<%=sum %>
	</h5>
	<font size=4>
		<%! int j = 0; %>
		<% j++; %>
	</font>
	<p>您是第<%=j %>访问本网站的客户</p>
</body>
</html>