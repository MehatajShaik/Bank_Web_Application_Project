package com.AxisBank.Application;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	
	static Connection con=null;
	
	public static Connection requestConnection()
			throws ClassNotFoundException,SQLException
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?"+"user=root&password=tiger");
				return con;
			}
}
