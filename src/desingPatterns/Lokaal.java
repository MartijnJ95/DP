package desingPatterns;

import java.util.ArrayList;

public class Lokaal {

	private String lokaalNummer;
	private ArrayList<Reservering> reserveringen;
	
	// Constructor
	public Lokaal()
	{
		
	}
	
	// Get lokaalNummer
	public String GetLokaalNummer()
	{
		return lokaalNummer;
	}
	
	// Set the lokaalNummer
	public void SetLokaalNummer(String lokaalNummer)
	{
		this.lokaalNummer = lokaalNummer;
	}
	
	// Get all reserveringen
	public ArrayList<Reservering> GetReseringen()
	{
		return reserveringen;
	}
	
	// Add reservering for this lokaal
	public void AddReservering(Reservering res)
	{
		reserveringen.add(res);
	}
	
	// TODO Check of dit werkt zoals gedacht! 
	public void RemoveReservering(Reservering res)
	{
		reserveringen.remove(res);
	}
	
	
}
