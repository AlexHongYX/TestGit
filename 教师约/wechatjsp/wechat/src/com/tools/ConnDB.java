package com.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnDB {
	public Connection conn = null; 
	public Statement stmt = null; 
	public ResultSet rs = null; 
	private static String url="jdbc:mysql://47.112.23.227:3306/Wechat";
	private static String user="root";
	private static String password="123456";
	//private static String dbClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
	//private static String dbUrl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=db_shop";
	//private static String dbUser = "sa"; 
	//private static String dbPwd = ""; 

	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		conn = DriverManager.getConnection(
		"jdbc:mysql://47.112.23.227/Wechat?useUnicode=true&characterEncoding=utf8", "root", "hyx19990925");
			 
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		if (conn == null) {
			System.err.println("DbConnectionManager.getConnection():"
					 + "\r\n :" + url + "\r\n " + "/"
					+ password);
		}
		
		return conn; 
	}

	
	public int executeUpdate(String sql) {
		int result = 0;
		try {
			conn = getConnection();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			result = stmt.executeUpdate(sql);
		} catch (SQLException ex) {
			result = 0;
			ex.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException ex1) {
			ex1.printStackTrace();
		}
		return result;
	}

	
	public ResultSet executeQuery(String sql) {
		try {
			conn = getConnection();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return rs;
	}

	
	public void close() {
		try { 
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close(); 
			}
			if (conn != null) {
				conn.close(); 
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

	
	public static void main(String[] args) {
		if (getConnection() != null) {
			System.out.print("发生异常");
		}
	}

	
}
