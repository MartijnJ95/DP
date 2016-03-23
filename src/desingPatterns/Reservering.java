package desingPatterns;

import com.sun.org.apache.xerces.internal.impl.dv.xs.DateTimeDV;

public class Reservering {

	private DateTimeDV beginTijd;
	private DateTimeDV eindTijd;
	private Gebruiker gebruiker;
	
	// Constructor
	public Reservering()
	{
		
	}
	
	// Get the begin time of the reservation
	public DateTimeDV GetBeginTijd()
	{
		return beginTijd;
	}
	
	// Get the ending time of the reservation
	public DateTimeDV GetEindTijd()
	{
		return eindTijd;
	}
	
	// Get the user
	public Gebruiker GetGebruiker()
	{
		return gebruiker;
	}
	
	// Set the begin time
	public void SetBeginTijd(DateTimeDV beginTijd)
	{
		this.beginTijd = beginTijd;
	}
	
	// Set the  ending time
	public void SetEindTijd(DateTimeDV eindTijd)
	{
		this.eindTijd= eindTijd;
	}
	
	// Set the user
	public void SetGebruiker(Gebruiker gebruiker)
	{
		this.gebruiker = gebruiker;
	}	
}
