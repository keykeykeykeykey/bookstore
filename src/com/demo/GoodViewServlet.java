package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GoodsDao;

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
		GoodsDao goodsDao = new GoodsDao();
		List<Map<String, Object>> rs = goodsDao.selectAll();
		out.println("<style>" +
                 	"table,table tr th, table tr td { border:1px solid #000; }" +
                    "table {position: relative; margin: 10px auto; width: 60%;}" +
                    "table td {padding: 10px;}" +
                    "table img {width: 50px;}" +
                    "a{text-decoration:none}" +
                    "</style>" +
                    "<a href=../../jsp/goodsNew.jsp>新增商品</a>" +
                    "<table style=\"border:1px solid #000; text-align: center; border-collapse: collapse;\">" +
                    "<tr><th>编号</th><th>名称</th><th>产地</th><th>价格</th><th>数量</th><th>图片</th><th></th><th></th></tr>");
		for(int i = 0;i<rs.size();i++){
				out.println("<tr>" +
                        "<td>" + rs.get(i).get("id") + "</td>" +
                        "<td>" + rs.get(i).get("name") + "</td>" +
                        "<td>" + rs.get(i).get("place") + "</td>" +
                        "<td>" + rs.get(i).get("price")+ "</td>" +
                        "<td>" + rs.get(i).get("number") + "</td>" +
                        "<td><a href=\"../../images/" + rs.get(i).get("pic") + "\">" +
                        "<img src=\"../../images/" + rs.get(i).get("pic") + "\"></a></td>" +
                        "<td><a href=GetDetailServlet?id="+rs.get(i).get("id")+">修改</a></td>" +
                        "<td><a href=GoodsDeleteServlet?id="+rs.get(i).get("id")+">删除</a></td>" +
                        "</tr>");
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
