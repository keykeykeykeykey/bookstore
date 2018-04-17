<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@ page import="entity.Goods"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
  request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="goods" class="entity.Goods" scope="request"></jsp:useBean>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改信息</title>
</head>
<body>
<%
	ArrayList list = (ArrayList) request.getAttribute("list");
	Goods good = (Goods) list.get(0);
	Integer id = good.getId();
	String name = good.getName();
	String place = good.getPlace();
	String price = good.getPrice();
	String number = good.getNumber();
	String pic = good.getPic();
%>
	<form action="GoodsUpdateServlet" method=post name=form>
		<table>
			<tr>
				<td>商品编号:</td>
				<td><input type=text name=id value="<%=id %>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>商品名称:</td>
				<td><input type=text name=name value="<%=name %>"></td>
			</tr>
			<tr>
				<td>产地:</td>
				<td><input type=text name=place value="<%=place %>"></td>
			</tr>
			<tr>
				<td>商品价格:</td>
				<td><input type=text name=price value="<%=price %>"></td>
			</tr>
			<tr>
				<td>商品数量:</td>
				<td><input type=text name=number value="<%=number %>"></td>
			</tr>
			<tr>
				<td>图片:</td>
				<td><input type=text name=pic value="<%=pic %>"></td>
			</tr>
			<tr>
				<td><input type=submit value="提交" name=submit></td>
				<td><input type=submit value="重置" name=submit></td>
			</tr>
		</table>
	</form>
</body>
</html>