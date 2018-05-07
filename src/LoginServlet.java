

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
	  
		
		
		String un=request.getParameter("username");
		String pw=request.getParameter("password");
		CustomerList c = new CustomerList();
		//boolean isCustomer = true;
		HashMap<String,Customer> l = c.list();
		PrintWriter out = response.getWriter();
		//System.out.println(l.get(un).password);
		
		//Captcha Verification
		String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
		boolean verify = VerifyUtils.verify(gRecaptchaResponse);
		
		if(l.containsKey(un) && l.get(un).password.equals(pw) && !verify)
		{
			response.sendRedirect("mainpage.html");
			return;
		}
		else
		{
			if(verify)
			{
				out.println("<HTML>" +
						"<HEAD><TITLE>" +
						"MovieDB: Error" +
						"</TITLE></HEAD>\n<BODY>" +
						"<P>Invalid Captcha!!!! </P></BODY></HTML>");
				request.setAttribute("error","Invalid Username or Password");
				request.getRequestDispatcher("index.html").forward(request, response);
			}
			else
			{
				out.println("<HTML>" +
						"<HEAD><TITLE>" +
						"MovieDB: Error" +
						"</TITLE></HEAD>\n<BODY>" +
						"<P>Wrong password or Username!!!! </P></BODY></HTML>");
				request.setAttribute("error","Invalid Username or Password");
				RequestDispatcher rd=request.getRequestDispatcher("/index.html");            
				rd.include(request, response);
			}
		}
		
		/*String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
		System.out.println("gRecaptchaResponse=" + gRecaptchaResponse);
		// Verify CAPTCHA.
		boolean valid = VerifyUtils.verify(gRecaptchaResponse);
		if (!valid) {
		    //errorString = "Captcha invalid!";
		    out.println("<HTML>" +
				"<HEAD><TITLE>" +
				"MovieDB: Error" +
				"</TITLE></HEAD>\n<BODY>" +
				"<P>Recaptcha WRONG!!!! </P></BODY></HTML>");
			request.setAttribute("error","Invalid Username or Password");
			RequestDispatcher rd=request.getRequestDispatcher("/index.html");            
			rd.include(request, response);
		    return;*/
		
		
		
		out.close();
	}

}
