package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.Goods;

public class GoodsDao {
	public Goods getGoodById(String id){
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
			return (Goods) rs;
		}catch(Exception e){
			
		}
		return null;
	}
}
