<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增商品</title>
</head>
<body>
	<form action="../com/demo/GoodsAddServlet" method=post name=form>
		<table>
			<tr>
				<td>商品编号:</td>
				<td><input type=text name=id></td>
			</tr>
			<tr>
				<td>商品名称:</td>
				<td><input type=text name=name></td>
			</tr>
			<tr>
				<td>产地:</td>
				<td><input type=text name=place></td>
			</tr>
			<tr>
				<td>商品价格:</td>
				<td><input type=text name=price></td>
			</tr>
			<tr>
				<td>商品数量:</td>
				<td><input type=text name=number></td>
			</tr>
			<tr>
				<td>图片:</td>
				<td><input type=text name=pic></td>
			</tr>
			<tr>
				<td><input type=submit value="提交" name=submit></td>
				<td><input type=submit value="重置" name=submit></td>
			</tr>
		</table>
	</form>
</body>
</html>