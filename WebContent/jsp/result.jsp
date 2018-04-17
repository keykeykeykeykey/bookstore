<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int num = Integer.parseInt(request.getParameter("number"));
		int rnum = (Integer)session.getAttribute("rnum");
		if(num>rnum){
			response.sendRedirect("large.jsp?number="+num);
		}else if(num<rnum){
			response.sendRedirect("small.jsp?number="+num);
		}else{
			response.sendRedirect("success.jsp?number="+num);
		}
	%>
</body>
</html>