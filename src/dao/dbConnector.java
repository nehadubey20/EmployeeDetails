package dao;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class dbConnector {
	private static Connection con = null;
	private dbConnector()
	{	
	}
	
	public static Connection getConnection()
	{
		if(con==null)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return con;
	}
	

}
