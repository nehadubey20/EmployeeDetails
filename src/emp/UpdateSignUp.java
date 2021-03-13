package emp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.SignUpBean;
import dao.ConnectorForEmp;

/**
 * Servlet implementation class UpdateSignUp
 */
public class UpdateSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		ArrayList al = new ArrayList();
		
		SignUpBean bs = new SignUpBean();
		int id = Integer.parseInt(request.getParameter("user_id"));
		
		al = ConnectorForEmp.show(id);
		
		getServletContext().setAttribute("UserData", al);
		request.getRequestDispatcher("UpdateSignUp.jsp").forward(request, response);
	
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		///doGet(request, response);
		int sid =0;
		//String sid = null;
		SignUpBean bs1 = new SignUpBean();
		try
		{
			sid = Integer.parseInt(request.getParameter("user_id"));
			System.out.println(sid);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		String fname =  request.getParameter("fname");
		String lname =  request.getParameter("lname");
		String email =  request.getParameter("email");
		String phone =  request.getParameter("phone");
		String password =  request.getParameter("password");
		String gender = request.getParameter("gender");
		String city = request.getParameter("city");
		
		String device = request.getParameter("device");
		//String d[] = device.split(",");
		
		System.out.println(device);
		
		bs1.setId(sid);
		bs1.setFname(fname);
		bs1.setLname(lname);
		bs1.setEmail(email);
		bs1.setPhone(phone);
		bs1.setPassword(password);
		bs1.setGender(gender);
		bs1.setCity(city);
		bs1.setDev(device);
		
		ConnectorForEmp.update(bs1);
	
		response.sendRedirect("ShowUpdatedList");
	
	}

}
