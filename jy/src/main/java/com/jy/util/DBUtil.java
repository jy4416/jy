package com.jy.util;

import java.sql.*;

public class DBUtil {
	
	public static Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String uid="root";
			String pwd="root";
			String url="jdbc:mysql://localhost:3306/addressbook?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
			conn=DriverManager.getConnection(url,uid,pwd);
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return conn;
		
	}
	public static void main(String[] args) throws SQLException {
		Connection conn=getConnection();
		System.out.println(conn);
		conn.close();
	}
}
