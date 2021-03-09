package emp;
import java.sql.*;
import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.BeanClass;

/**
 * Servlet implementation class Show
 */
public class Show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Show() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		Connection con=null;
		ArrayList al = new ArrayList();
		
		try
		{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","");
				
				System.out.println(con);
				
				String query="Select * from userdata";
				PreparedStatement pstmt=con.prepareStatement(query);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					BeanClass b=new BeanClass();
					b.setId(rs.getInt(1));
					b.setName(rs.getString(2));
					b.setCompany(rs.getString(3));
					b.setSalary(rs.getInt(4));
					b.setEmail(rs.getString(5));
					b.setPhone(rs.getString(6));
					
					al.add(b);
					//System.out.println(al);
				}
				
			//	con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		getServletContext().setAttribute("empdata",al);
		request.getRequestDispatcher("ShowEmp.jsp").forward(request,response);
		
	}

}
