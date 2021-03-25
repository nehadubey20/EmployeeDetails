package emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import Bean.SignUpBean;
import dao.Connector;
import dao.ConnectorForEmp;

/**
 * Servlet implementation class SignUp
 */
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String city = "<option value='0'>Select City</option>";
		ArrayList al = (ArrayList)ConnectorForEmp.getCityByStateId(request.getParameter("state_id"));
		for(int i=0;i<al.size();i++)
		{
			city += "<option value='"+al.get(i)+"'>"+al.get(i)+"</option>";
		}
		response.getWriter().append(city);
		

		/*
		 * String state = "<option value='0'>Select State</option>"; ArrayList s_al
		 * =(ArrayList)ConnectorForEmp.showStates(request.getParameter("state_id"));
		 * 
		 * for(int i=0;i<s_al.size();i++) { state +=
		 * "<option value='"+s_al.get(i)+"'>"+al.get(i)+"</option>"; }
		 * 
		 * response.getWriter().append(state);
		 */		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		SignUpBean b= new SignUpBean();
		PrintWriter out = response.getWriter();
		b.setFname(request.getParameter("fname"));
		b.setLname(request.getParameter("lname"));
		b.setEmail(request.getParameter("email"));
		b.setPhone(request.getParameter("phone"));
		b.setPassword(request.getParameter("password"));
		b.setGender(request.getParameter("gender"));
		b.setCity(request.getParameter("city"));
		
        String device[]=request.getParameterValues("device");
        String dev = String.join(",", device);
        
        
        b.setDev(dev);
        System.out.println("devices of signupp:"+dev);
		
        //Connector.insert(b);
		if(Connector.insert(b)==true)
		{
			out.print("success!");
		}
		else
		{
			out.println("Connection Fail!");
		}
		
		//SignUpBean b1= new SignUpBean();
		ArrayList arrlst = new ArrayList();
		arrlst = Connector.show();
		getServletContext().setAttribute("showData", arrlst);
		request.getRequestDispatcher("ShowSignUp.jsp").forward(request, response);
		
		
	}

}
