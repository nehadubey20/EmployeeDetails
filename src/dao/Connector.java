package dao;

import java.util.ArrayList;
import java.sql.*;

import com.mysql.jdbc.Connection;

import Bean.SignUpBean;

public class Connector {
	
	
	public static boolean insert(SignUpBean b)
	{
		
		//String fname,lname,email,phone,password;
		//SignUpBean b = new SignUpBean();
		
		Connection con=dbConnector.getConnection();
		try {
		String query = "Insert into signup(FirstName,LastName,Email,Phone,Password) values (?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1,b.getFname());
		stmt.setString(2,b.getLname());
		stmt.setString(3,b.getEmail());
		stmt.setString(4,b.getPhone());
		stmt.setString(5,b.getPassword());
		int i = stmt.executeUpdate();
		
		if(i>0)
		{
			return true;
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	
	public static ArrayList show()
	{
		Connection con = dbConnector.getConnection();
		ArrayList al= new ArrayList();
		try {
		String query="select * from signup";
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		while(rs.next())
		{
			SignUpBean b= new SignUpBean();
			b.setId(rs.getInt(1));
			b.setFname(rs.getString(2));
			b.setLname(rs.getString(3));
			b.setEmail(rs.getString(4));
			b.setPhone(rs.getString(5));
		//	b.setPassword(rs.getString(6));
			al.add(b);
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}

}

