

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertStarServlet
 */
@WebServlet("/InsertStarServlet")
public class InsertStarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertStarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
		String idtemp ="1";
		String name="";
		String dob="";
		String photo="";
		PrintWriter out = response.getWriter();
		boolean t = true;
		
		idtemp = request.getParameter("id");
		name=request.getParameter("name");
		dob=request.getParameter("dob");
		photo=request.getParameter("photo");
		if(dob == null){
			dob = "";
		}
		if(photo == null){
			photo = "";
		}
		//int id = Integer.getInteger(idtemp);
		
		String firstName, lastName;
		firstName = "";
		lastName = "";
		
		String[] s = name.split(" ",2);
		if (s.length > 1){
			firstName = s[0];
			lastName = s[1];
		}
		else{
			lastName = name;
		}
		

		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Connection connection = DriverManager.getConnection("jdbc:mysql:///moviedb","root", "root");
			System.out.println("hello");
			Statement select = connection.createStatement();
            select.execute("insert into stars (id, first_name, last_name, dob, photo_url) VALUES ("
        			+ idtemp + ", " + "'" + firstName + "'" +", " + "'" + lastName +"'"+", " + "'" + dob +"'"+", " + "'" + photo +"'"+ ")");
		}
		catch (Exception e) { out.println("invalid data entry");
		RequestDispatcher rd=request.getRequestDispatcher("/dashboard.jsp");
		rd.include(request, response);
		t = false;}
		
		//boolean isCustomer = true;
		
		if(t == true){
		out.println("Star inserted");
			RequestDispatcher rd=request.getRequestDispatcher("/dashboard.jsp");
		
			rd.include(request, response);
		}
		out.close();
	}

}
