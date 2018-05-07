package ShoppingCart;


public class Item implements java.io.Serializable{
	public String movieName;
	public int movieID;
	public String director;
	public double price;
	public String actors;
	public int orderQuantity;
	
	public Item()
	{
		
	}
	
	public Item(String name, int movID, int quantity)
	{
		movieName = name;
		orderQuantity = quantity;
		movieID = movID;
	}
	
	public String getName()
	{
		return movieName;
	}
	
	public void setName(String name)
	{
		movieName = name;
	}
	
	public int getMovieID()
	{
		return movieID;
	}
	
	public void setMovieID(int id)
	{
		movieID = id;
	}
	
	public int getOrderQuantity()
	{
		return orderQuantity;
	}
	
	public void setOrderQuantity(int quantity)
	{
		orderQuantity = quantity;
	}
	
	public boolean equals(Object ob)
	{
		if (ob == this) return true;
		if (!(ob instanceof Item)) return false;
		if (((Item) ob).getMovieID() == getMovieID())
		{
			return true;
		}
		return false;
	}

}
