package com.eduask.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.eduask.util.ConnectionHelper;

public class BaseDao {

	protected Connection conn;

	protected Statement stat;

	protected PreparedStatement ps;

	protected ResultSet rs;

	protected Connection getConnection(){

		String driverClass = ConnectionHelper.newInstance().getString("jdbc.driver");

		String url = ConnectionHelper.newInstance().getString("jdbc.url");

		String user = ConnectionHelper.newInstance().getString("jdbc.user");

		String pwd = ConnectionHelper.newInstance().getString("jdbc.pwd");

		try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;


	}

	protected void closeResource(){

		if(rs!=null){

			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if(ps!=null){

			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if(stat!=null){

			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if(conn!=null){

			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
