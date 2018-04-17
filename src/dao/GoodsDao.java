package dao;
import java.util.*;

import util.ResultSetSQL;

public class GoodsDao {
	ResultSetSQL resultSetSQL = new ResultSetSQL();
	public List<Map<String, Object>> selectAll(){
		try{
			String sql = "select * from goods";
			return resultSetSQL.excuteQuery(sql);
		}catch(Exception e){
			System.out.println("操作数据库错误");
		}
		return null;
	}
	
	public List<Map<String, Object>> selectGoodsById(String id){
		try{
			String sql = "select * from goods where id = "+id;
			return resultSetSQL.excuteQuery(sql);
		}catch(Exception e){
			System.out.println("操作数据库错误");
		}
		return null;
	}
	
	public int updateGoodsById(String name,String place,String price,String number,String pic,String id){
		try{
			String sql = "UPDATE goods SET name = '" + name +
						 "',place = '" + place +
						 "',price = '" + price +
						 "',number = '" + number + 
						 "',pic = '" + pic + "' where id = '" + id +"'";
			return resultSetSQL.executeUpdate(sql);
		}catch(Exception e){
			System.out.println("操作数据库错误");
		}
		return 1;
	}
	
	public int deleteGoodsById(String id){
		try{
			String sql = "DELETE FROM goods WHERE id = " + id;
			return resultSetSQL.executeUpdate(sql);
		}catch(Exception e){
			System.out.println("操作数据库错误");
		}
		return 1;
	}
	
	public int insertGoodsById(String name,String place,String price,String number,String pic,String id){
		try{
			String sql = "INSERT INTO goods (id,name,place,price,number,pic) VALUES (" + id + ","
					+ name + ","
					+ place + ","
					+ price + ","
					+ number + ","
					+ pic + ")";
			return resultSetSQL.executeUpdate(sql);
		}catch(Exception e){
			System.out.println("操作数据库错误");
		}
		return 1;
	}
}
