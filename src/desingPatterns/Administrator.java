package desingPatterns;

import java.util.ArrayList;

public class Administrator implements Gebruiker{

	private String naam;
	private int maximaleReserveringstijdInMinuten;
	private int maximaalAantalReserveringen;
	private ArrayList<Reservering> huidigeReserveringen;
	private int huidigeReserveringsTijd;
	
	// Constructor
	public Administrator() 
	{
		huidigeReserveringen = new ArrayList<Reservering>();
	}

	// Get naam
	public String GetNaam()
	{
		return naam;
	}
	
	// Set naam
	public void SetNaam(String naam)
	{
		this.naam = naam;
	}
	
	// Get all huidige reserveringen
	public ArrayList<Reservering> GetHuidigeReservingen()
	{
		return huidigeReserveringen;
	}
	
	// Add reservering to arraylist
	public void AddHuidigeReservering(Reservering res)
	{
		huidigeReserveringen.add(res);
	}
	
	// Remove huidige reservering TODO check of dit werkt zoals intended
	public void RemoveHuidigeReservering(Reservering res)
	{
		huidigeReserveringen.remove(res);
	}
	
	public int GetHuidigeReserveringsTijdInMin()
	{
		return huidigeReserveringsTijd;
	}
	
	public void SetHuidigeReserveringsTijdInMin(int resTijd)
	{
		huidigeReserveringsTijd = resTijd;
	}
	
	public int GetMaximaleReserveringsTijdInMin()
	{
		return maximaleReserveringstijdInMinuten;
	}
	
	public int GetMaximaalAantalReserveringen()
	{
		return maximaalAantalReserveringen;
	}
}
