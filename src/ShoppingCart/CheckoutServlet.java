package ShoppingCart;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.net.*;

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException    
        {
	        Billing billing = new Billing();
	
	        billing.setCardName(request.getParameter("nameOnCard"));
	        billing.setCreditID(request.getParameter("creditID"));
	        billing.setExpiration(request.getParameter("expiration"));
	        billing.setEmail(request.getParameter("emailAddress"));
	        billing.setPassword(request.getParameter("password"));
	        
	        HttpSession session = request.getSession();
	        
	        shoppingCart cart =
	                (shoppingCart) session.getAttribute("shoppingCart");
	        
	        
	        if(billing.nameOnCard == "" || billing.creditID == "" || billing.expiration == ""
	        		|| billing.emailAddress == "" || billing.password == "")
	        {
	        	IOException e = new IOException();
	        	
	            PrintWriter out = response.getWriter();
	        	
	            out.println("<html><body><h1>Error</h1>");
	            out.println("An error occurred while "+
	                "processing your order.");
	            out.println("</body></html>");

	        	try {
					String confirmation = cart.completeOrder(billing);
				} catch (ShoppingCartException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				out.print("Invalid Card Information");  
		        RequestDispatcher rd=request.getRequestDispatcher("Checkout.jsp");  
		        rd.include(request,response);  
	        }
	        else
	        {
	
		        if(cart == null)
		        {
		        	cart = new shoppingCart();
		        	session.setAttribute("shoppingCart", cart);
		        	   
		        }
		        try
		        {
		        	String confirmation = cart.completeOrder(billing);
		        	response.sendRedirect(response.encodeRedirectURL(
		                    "ShowConfirmation.jsp"+
		                    "?confirmationNumber="+URLEncoder.encode(confirmation)));
		        }
		        catch (ShoppingCartException exc)
		        {
		            PrintWriter out = response.getWriter();
	
		            out.println("<html><body><h1>Error</h1>");
		            out.println("The following error occurred while "+
		                "processing your order:");
		            out.println("<pre>");
		            out.println(exc.getMessage());
		            out.println("</pre>");
		            out.println("</body></html>");
		            out.close();
		            return;
		        }
	        }
        }
}