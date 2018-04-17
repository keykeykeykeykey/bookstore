package com.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GoodsDao;

/**
 * Servlet implementation class GoodsAddServlet
 */
@WebServlet("/com/demo/GoodsAddServlet")
public class GoodsAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsAddServlet() {
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
		GoodsDao goodsDao = new GoodsDao();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String place = request.getParameter("place");
		String price = request.getParameter("price");
		String number = request.getParameter("number");
		String pic = request.getParameter("pic");
		goodsDao.insertGoodsById(name, place, price, number, pic, id);
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
