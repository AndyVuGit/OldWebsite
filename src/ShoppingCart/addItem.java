package ShoppingCart;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/addItem")
public class addItem extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws IOException, ServletException
	{
		String movieName = request.getParameter("movieName");
		int movieID = Integer.parseInt(request.getParameter("movieID"));
		int orderQuantity = Integer.parseInt(request.getParameter("orderQuantity"));
		Item item = new Item(movieName, movieID, orderQuantity);
		
		HttpSession session = request.getSession();
		
		shoppingCart cart = (shoppingCart) session.getAttribute("shoppingCart");
		
		if (cart == null)
		{
			cart = new shoppingCart();
			
			session.setAttribute("shoppingCart", cart);
			
		}
		
		cart.addItems(item);
		
		response.sendRedirect(response.encodeRedirectURL("DisplayShoppingCart.jsp"));
		
		
		
	}
}