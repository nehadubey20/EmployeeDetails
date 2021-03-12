package emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class Insert
 */
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		Connection con=null;
		
		String name = request.getParameter("name");
		String company = request.getParameter("company");
		int sal = Integer.parseInt(request.getParameter("salary"));
		String email  = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		
		
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","");
			
			System.out.println(con);
			String query = "insert into userdata(UserName,Company,Salary,UserEmail,Phone) values(?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1,name);
			stmt.setString(2,company);
			stmt.setInt(3,sal);
			stmt.setString(4,email);
			stmt.setString(5,phone);
			
			int i= stmt.executeUpdate();		

			if(i>0)
			{
				out.println("Insertion success!");
				request.getRequestDispatcher("Show").forward(request, response);
				
			}
			else
			{
				out.println("Insertion Fail");
			}
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		}
	}


