

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List; 


public class EmployeeList{
	


	public HashMap<String, employee> list(){
        HashMap<String,employee> employeeList = new HashMap<String,employee>();
		
	  
		 // Incorporate mySQL driver
	
	
        try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Connection connection = DriverManager.getConnection("jdbc:mysql:///moviedb","root", "password");
			
			Statement select = connection.createStatement();
            Statement select2 = connection.createStatement();
            Statement select3 = connection.createStatement();
            ResultSet result = select.executeQuery("Select email, password, fullname from employees");
            //ResultSet result2 = select.executeQuery("Select title, year, director from movies");



            // print table's contents, field by field
            while (result.next())
            {
                String id = result.getString("email");
                employee s = new employee();
                s.setUsername(result.getString("email"));
                s.setPassword(result.getString("password"));
                s.setFullName(result.getString("fullname"));
                employeeList.put(id, s);
			        //out.print();
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeList;
		
	
	
		
	}
	
	
	
		
	
}
	

