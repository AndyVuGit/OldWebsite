package ShoppingCart;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AddingToShoppingCartServlet extends HttpServlet
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request,
        HttpServletResponse response)
        throws IOException, ServletException
    {

// First get the item values from the request.
		int movieID = Integer.parseInt(request.getParameter("movieID"));
        String movieName = request.getParameter("movieName");
        
        int orderQuantity = Integer.parseInt(
            request.getParameter("orderQuantity"));


// Now create an item to add to the cart.
        Item item = new Item(movieName, movieID, orderQuantity);

        HttpSession session = request.getSession();

// Get the cart.
        shoppingCart cart = (shoppingCart) session.
            getAttribute("ShoppingCart");

// If there is no shopping cart, create one.
        if (cart == null)
        {
            cart = new shoppingCart();

            session.setAttribute("ShoppingCart", cart);
        }

        cart.addItems(item);

// Now display the cart and allow the user to check out or order more items.
        response.sendRedirect(response.encodeRedirectURL(
            "/shoppingcart/ShowCartAfterAdd.jsp"));
    }
}