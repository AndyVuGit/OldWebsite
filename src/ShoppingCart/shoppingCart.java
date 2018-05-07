package ShoppingCart;


import java.util.*;
import java.io.*;

public class shoppingCart implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Vector items;
	
	public shoppingCart()
	{
		items  = new Vector();
	}
	
	public Vector getItems()
	{
		return (Vector) items.clone();
	}
	
	public synchronized void addItems(Item newItem)
	{
		Enumeration e = items.elements();
		
		while(e.hasMoreElements())
		{
			Item currItem = (Item) e.nextElement();
			
			if(newItem.equals(currItem))
			{
				currItem.orderQuantity = currItem.orderQuantity + 
						newItem.orderQuantity;
				return;
			}
		}
		
		items.addElement(newItem);
	}
	
	public synchronized void removeItem(int itemIndex)
	{
		Item item = (Item) items.elementAt(itemIndex);
		
		item.orderQuantity = item.orderQuantity - 1;
		
		if (item.orderQuantity <= 0)
		{
			items.removeElementAt(itemIndex);
		}
	}
	
	protected static int nextOrderNumber = 1;
	
	public String completeOrder(Billing billing) 
			throws ShoppingCartException 
	{
		try
		{
			int orderNumber = 0;
			
			synchronized(this)
			{
				orderNumber = nextOrderNumber;
				nextOrderNumber = nextOrderNumber + 1;
			}
			PrintWriter out = new PrintWriter(new FileOutputStream("order" + orderNumber));
			
			out.println(billing.nameOnCard);
			out.println(billing.creditID);
			out.println(billing.expiration);
			out.println(billing.emailAddress);
			
			Enumeration e = items.elements();
			while (e.hasMoreElements())
			{
				Item item = (Item) e.nextElement();
				
				out.println(item.movieName);
			}
			out.close();
			
			return "" + orderNumber;
			
		}
		catch (Exception exc)
		{
			throw new ShoppingCartException(
					"Error saving order: "+ exc.toString());
		}
	}
	
}
