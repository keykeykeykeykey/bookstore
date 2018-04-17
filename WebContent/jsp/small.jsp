<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>太小了</title>
</head>
<body>
	<form action="" method=get name=form>
		太小了,再猜猜：<input type=text name=num>
		<input type=submit value="送出" name=submit>
	</form>
	<%
		String number = request.getParameter("num");
			if(number!=null){
				int b = Integer.parseInt(number);
				String c = session.getAttribute("time").toString();
				int a = Integer.parseInt(c);
				a++;
				session.setAttribute("time",a);
				response.sendRedirect("result.jsp?number="+b);
			}
	%>
</body>
</html>