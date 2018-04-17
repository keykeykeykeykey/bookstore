package com.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Goods;

/**
 * Servlet implementation class GetDeatilServlet
 */
@WebServlet("/com/demo/GetDetailServlet")
public class GetDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDetailServlet() {
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
		String id = request.getParameter("id");
		ArrayList<Goods> list = new ArrayList<Goods>(); 
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			
		}
		
		try{
			String url = "jdbc:mysql://localhost:3306/shopping?Unicode=true&characterEncoding=UTF-8";
			String username = "root";
			String pwd = "root";
			Connection con = DriverManager.getConnection(url,username,pwd);
			PreparedStatement s = con.prepareStatement("select * from goods where id=?");
			s.setString(1, id);
			ResultSet rs = s.executeQuery();
			while(rs.next()){
				Goods good = new Goods();
				good.setId(rs.getInt("id"));
				good.setName(rs.getString("name"));
				good.setPlace(rs.getString("place"));
				good.setPrice(rs.getString("price"));
				good.setNumber(rs.getString("number"));
				good.setPic(rs.getString("pic"));
				list.add(good);
			}
			request.setAttribute("list", list);
		}catch(Exception e){
			System.out.println(e);
		}
		request.getRequestDispatcher("../../jsp/goodsdetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
