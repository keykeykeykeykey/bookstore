<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>猜测数字</title>
</head>
<body>
	<h3>随机生成了一个1到100之间的数字，请猜猜</h3>
	<form action="" method=get name=form>
		请输入你的猜测：<input type=text name=number>
		<input type=submit value="送出" name=submit>
	</form>
	<%
		int rnum = (int)(Math.random()*101);
		System.out.println(rnum);
		String number = request.getParameter("number");
			if(number!=null){
			int b = Integer.parseInt(number);
			session.setAttribute("rnum",rnum);
			session.setAttribute("time","1");
			response.sendRedirect("result.jsp?number="+b);
			}
	%>
</body>
</html>