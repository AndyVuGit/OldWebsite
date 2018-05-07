

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
	  
		String un=request.getParameter("username");
		String pw=request.getParameter("password");
		EmployeeList c = new EmployeeList();
		//boolean isCustomer = true;
		HashMap<String,employee> l = c.list();
		PrintWriter out = response.getWriter();
		//System.out.println(l.get(un).password);
		
		if(l.containsKey(un) && l.get(un).password.equals(pw))
		{
			response.sendRedirect("dashboard.jsp");
			return;
		}
		else
		{
			
			request.setAttribute("error","Invalid Username or Password");
			RequestDispatcher rd=request.getRequestDispatcher("/_dashboard.jsp");            
			rd.include(request, response);
		}
		out.close();
	}

}
