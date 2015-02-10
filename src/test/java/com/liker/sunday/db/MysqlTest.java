package com.liker.sunday.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

public class MysqlTest {

//	@Test
	public void testConnection(){
		String driver = "com.mysql.jdbc.Driver";
//		String url = "jdbc:mysql://localhost:3306/mysunday";
//		String username = "root";
//		String password = "root";
		
		String url = "jdbc:mysql://rdsn2iqabqqm36v.mysql.rds.aliyuncs.com:3306/r2xmh5ov5kk18kkg";
		String username = "r2xmh5ov5kk18kkg";
		String password = "likai365";
		
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			
			if(!conn.isClosed()){
				System.out.println("connect mysql successfully!");
			}
			
			Assert.assertEquals(true, !conn.isClosed()); //断言用户已经登录
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
