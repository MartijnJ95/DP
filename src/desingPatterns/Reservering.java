package desingPatterns;

import java.util.Date;

public class Reservering {

	private Date beginTijd;
	private Date eindTijd;
	private Gebruiker gebruiker;
	
	// Constructor
	public Reservering()
	{
		
	}
	
	// Get the begin time of the reservation
	public Date GetBeginTijd()
	{
		return beginTijd;
	}
	
	// Get the ending time of the reservation
	public Date GetEindTijd()
	{
		return eindTijd;
	}
	
	// Get the user
	public Gebruiker GetGebruiker()
	{
		return gebruiker;
	}
	
	// Set the begin time
	public void SetBeginTijd(Date beginTijd)
	{
		this.beginTijd = beginTijd;
	}
	
	// Set the  ending time
	public void SetEindTijd(Date eindTijd)
	{
		this.eindTijd= eindTijd;
	}
	
	// Set the user
	public void SetGebruiker(Gebruiker gebruiker)
	{
		this.gebruiker = gebruiker;
	}	
}
