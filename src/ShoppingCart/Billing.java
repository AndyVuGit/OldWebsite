package ShoppingCart;


public class Billing {
	public String nameOnCard;
	public String creditID;
	public String expiration;
	public String emailAddress;
	public String password;
	
	public Billing()
	{
		
	}
	
	public String getNameOnCard()
	{
		return nameOnCard;
	}
	
	public void setCardName(String name)
	{
		nameOnCard = name;
	}
	
	public String getCreditID()
	{
		return creditID;
	}
	
	public void setCreditID(String ID)
	{
		creditID = ID;
	}
	
	public String getExp()
	{
		return expiration;
	}
	
	public void setExpiration(String date)
	{
		expiration = date;
	}
	
	public String getEmail()
	{
		return emailAddress;
	}
	
	public void setEmail(String email)
	{
		emailAddress = email;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String newPassword)
	{
		password = newPassword;
	}
}
