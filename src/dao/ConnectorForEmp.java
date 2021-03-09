package dao;

import java.sql.*;

import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import Bean.SignUpBean;

public class ConnectorForEmp {

	
	public static ArrayList show(int id)
	{
		SignUpBean sb = new SignUpBean();
		Connection con = dbConnector.getConnection();
		ArrayList al= new ArrayList();
		try {
			
		String query="select * from signup where id=?";
		
		PreparedStatement stmt = con.prepareStatement(query);
		
		stmt.setObject(1,id);
		
		ResultSet rs = stmt.executeQuery();
		while(rs.next())
		{
			SignUpBean b= new SignUpBean();
			b.setId(rs.getInt(1));
			b.setFname(rs.getString(2));
			b.setLname(rs.getString(3));
			b.setEmail(rs.getString(4));
			b.setPhone(rs.getString(5));
			b.setPassword(rs.getString(6));
			al.add(b);
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}

	
	public static void update(SignUpBean obj)
	{
		
		try
		{
			Connection con = dbConnector.getConnection();
			String query = "update signup set FirstName=?,LastName=?,Email=?,Phone=?,Password=? where id=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1,obj.getFname());
			stmt.setString(2,obj.getLname());
			stmt.setString(3,obj.getEmail());
			stmt.setString(4,obj.getPhone());
			stmt.setString(5,obj.getPassword());
			stmt.setInt(6, obj.getId());
			int i = stmt.executeUpdate();
			if(i>0)
			System.out.println("Update Successful!");
			else
				System.out.println("Fail!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void delete(int id)
	{
			try
			{
				Connection con = dbConnector.getConnection();
				String query = "delete from signup where id=?";
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setInt(1,id);
				int i = stmt.executeUpdate();
				if(i>0)
				{
					System.out.println("Deleted Successfully!");
				}
				else
					System.out.println("Deletion Fail!!!");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	
			
}
