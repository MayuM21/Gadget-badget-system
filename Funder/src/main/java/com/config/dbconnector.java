package com.config;

import java.sql.*;

public class dbconnector {
	
	public static Connection connector()
	{
		Connection con = null;
		
		String url = "jdbc:mysql://127.0.0.1:3306/gbsystem";
		String username = "root";
		String password = "";
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connection Top");
			//con =  (Connection) DriverManager.getConnection(url,username,password);
			//con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gbsystem?" +"user=root&password=");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gbsystem?user="+username+"&password="+password);
			System.out.println("Connection Done");
			if (con != null) {
                System.out.println("Connected to the fail");
            }
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}

}
