package com.demo;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet("/com/demo/LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheckServlet() {
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
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
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
			ResultSet rs = s.executeQuery("select * from username");
			while(rs.next()){
				String a = rs.getString("username");
				String b = rs.getString("password");
				if(a.equals(name)&&b.equals(password)){
					response.sendRedirect("GoodViewServlet");
				}
				else{
					response.sendRedirect("../../index.html");
				}
			}
			
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
