package net.viralpatel.autocomplete;

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
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class SearchServlet
 */
public class MovieList {
	private List<String> movies;
	


	public List<String> list() throws IllegalAccessException, ClassNotFoundException, InstantiationException{
        List<String> moviepages = new ArrayList<String>();
		
	  
		 // Incorporate mySQL driver
	
	
        try {
        	Context ctx = null;
            ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/MyLocalDB");
            Connection connection = ds.getConnection();
			
			Statement select = connection.createStatement();
            Statement select2 = connection.createStatement();
            Statement select3 = connection.createStatement();
            ResultSet result = select.executeQuery("Select title from movies");
            //ResultSet result2 = select.executeQuery("Select title from movies");



            // print table's contents, field by field
            while (result.next())
            {
                moviepages.add(result.getString("title"));
               
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return moviepages;
		
	
	
		
	}
	int totalMovies = 0;
	public MovieList(){
		try {
			movies = list();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		totalMovies = movies.size();
	}
	public List<String> getData(String query) {
		String country = null;
		query = query.toLowerCase();
		List<String> matched = new ArrayList<String>();
		for(int i=0; i<totalMovies; i++) {
			country = movies.get(i).toLowerCase();
			if(country.startsWith(query)) {
				matched.add(movies.get(i));
			}
		}
		return matched;
	}
	
	
	
		
	
}
	

