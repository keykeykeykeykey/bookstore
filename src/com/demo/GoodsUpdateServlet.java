package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GoodsUpdateServlet
 */
@WebServlet("/com/demo/GoodsUpdateServlet")
public class GoodsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsUpdateServlet() {
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
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String place = request.getParameter("place");
		String price = request.getParameter("price");
		String number = request.getParameter("number");
		String pic = request.getParameter("pic");
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			
		}
		
		try{
			String url = "jdbc:mysql://localhost:3306/shopping?Unicode=true&characterEncoding=UTF-8";
			String username = "root";
			String pwd = "root";
			Connection con = DriverManager.getConnection(url,username,pwd);
			PreparedStatement s = con.prepareStatement("UPDATE goods SET name = ?,place = ?,price = ?,number = ?,pic = ? where id = ?");
			s.setString(1, name);
			s.setString(2, place);
			s.setString(3, price);
			s.setString(4, number);
			s.setString(5, pic);
			s.setString(6, id);
			s.executeUpdate();
			s.close();
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
		response.sendRedirect("GoodViewServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
