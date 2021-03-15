package dao;

import java.sql.*;

import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import Bean.SignUpBean;

public class ConnectorForEmp {
	
	
	public static ArrayList showStates()
	{
		ArrayList s_al = new ArrayList();
		Connection con = dbConnector.getConnection();
		try {
			String query = "select * from state";
			PreparedStatement stmt=con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				s_al.add(rs.getString(2));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return s_al;
	}

	public static ArrayList getCityByStateId(String stateid)
	{
		//SignUpBean sb = new SignUpBean();
		Connection con = dbConnector.getConnection();
		ArrayList al = new ArrayList();
		try {
		
		String query = "Select City_Name from city where State_Id="+stateid;
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		while(rs.next())
		{
			//sb.setCity(rs.getString(1));
			al.add(rs.getString(1));
			//System.out.println(rs.getString(1));
			
		}
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return al;
	}
	
	
	
	
	
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
			b.setGender(rs.getString(7));
			b.setCity(rs.getString(8));
			b.setDev(rs.getString(9));
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
			String query = "update signup set FirstName=?,LastName=?,Email=?,Phone=?,Password=?,Gender=?,City=?,Device=? where id=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1,obj.getFname());
			stmt.setString(2,obj.getLname());
			stmt.setString(3,obj.getEmail());
			stmt.setString(4,obj.getPhone());
			stmt.setString(5,obj.getPassword());
			stmt.setString(6, obj.getGender());
			stmt.setString(7,obj.getCity());
			
			String s = obj.getDev();
			String d = String.join(",", s);
			stmt.setString(8,d);
			
			
			System.out.println(d);
			
			
			stmt.setInt(9, obj.getId());
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
