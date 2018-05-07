

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.*;

import com.mysql.jdbc.MysqlDataTruncation;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

/**
 * Servlet implementation class MetaData
 */
@WebServlet("/MetaData")
public class MetaData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MetaData() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection connection;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:mysql:///moviedb", "root", "root");
			PrintWriter out = response.getWriter();
		
		DatabaseMetaData tableData = connection.getMetaData();
		String[] types = {};
		ResultSet tableResult = tableData.getTables(null, null, "%", types);
		
		while(tableResult.next())
		{
			out.println("Table Name:" + tableResult.getString("TABLE_NAME"));
			out.println("\n");
		//	System.out.println(tableResult.getString("TABLE_TYPE"));
			Statement temp = connection.createStatement();
            ResultSet temp2 = temp.executeQuery("Select * from " + tableResult.getString("TABLE_NAME"));
			
            ResultSetMetaData temp3 = temp2.getMetaData();
            for(int i = 1; i < temp3.getColumnCount(); i++)
            {
            	out.println("Column(" + i +")" + ": " + temp3.getColumnLabel(i) + "(" + temp3.getColumnTypeName(i)+")");
            	out.println("\n");
            	//System.out.println(temp3.getColumnLabel(i));
            }
			out.println("\n");
			RequestDispatcher rd=request.getRequestDispatcher("/metadata.jsp");            
			rd.include(request, response);

		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
