package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GoodViewServlet
 */
@WebServlet("/com/demo/GoodViewServlet")
public class GoodViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			
		}
		
		try{
			String url = "jdbc:mysql://localhost:3306/shopping?Unicode=true&characterEncoding=UTF-8";
			String username = "root";
			String pwd = "root";
			Connection con = DriverManager.getConnection(url,username,pwd);
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from goods");
			out.println("<style>" +
                    "table,table tr th, table tr td { border:1px solid #000; }" +
                    "table {position: relative; margin: 10px auto; width: 60%;}" +
                    "table td {padding: 10px;}" +
                    "table img {width: 50px;}" +
                    "a{text-decoration:none}" +
                    "</style>" +
                    "<table style=\"border:1px solid #000; text-align: center; border-collapse: collapse;\">" +
                    "<tr><th>编号</th><th>名称</th><th>产地</th><th>价格</th><th>数量</th><th>图片</th><th></th><th></th></tr>");
			while(rs.next()){
				out.println("<tr>" +
                        "<td>" + rs.getString("id").trim() + "</td>" +
                        "<td>" + rs.getString("name").trim() + "</td>" +
                        "<td>" + rs.getString("place").trim() + "</td>" +
                        "<td>" + rs.getString("price").trim()+ "</td>" +
                        "<td>" + rs.getString("number").trim() + "</td>" +
                        "<td><a href=\"../../images/" + rs.getString("pic").trim() + "\">" +
                        "<img src=\"../../images/" + rs.getString("pic").trim() + "\"></a></td>" +
                        "<td><a href=GetDetailServlet?id="+rs.getString("id")+">修改</a></td>" +
                        "<td><a href=GoodsDeleteServlet?id="+rs.getString("id")+">修改</a></td>" +
                        "</tr>");
			}
			out.println("</table>");
			rs.close();
			s.close();
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
