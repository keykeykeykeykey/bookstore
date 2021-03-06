package com.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GoodsDao;
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
		GoodsDao goodsDao = new GoodsDao();
		List<Map<String, Object>> rs = goodsDao.selectGoodsById(id);				
		Goods good = new Goods();
		good.setId((Integer) rs.get(0).get("id"));
		good.setName(rs.get(0).get("name").toString());
		good.setPlace(rs.get(0).get("place").toString());
		good.setPrice(rs.get(0).get("price").toString());
		good.setNumber(rs.get(0).get("number").toString());
		good.setPic(rs.get(0).get("pic").toString());
		list.add(good);
		request.setAttribute("list", list);
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
