package desingPatterns;

import java.util.ArrayList;

public class Docent implements Gebruiker{
	private String naam;
	private int maximaleReserveringstijdInMinuten;
	private int maximaalAantalReserveringen;
	private ArrayList<Reservering> huidigeReserveringen;
	private int huidigeReserveringsTijd;
	
	// Constructor
	public Docent()
	{
		huidigeReserveringen = new ArrayList<Reservering>();
	}
	
	// Get naam
	@Override
	public String GetNaam()
	{
		return naam;
	}
	
	// Set naam
	@Override
	public void SetNaam(String naam)
	{
		this.naam = naam;
	}
	
	// Get all huidige reserveringen
	@Override
	public ArrayList<Reservering> GetHuidigeReservingen()
	{
		return huidigeReserveringen;
	}
	
	// Add reservering to arraylist
	@Override
	public void AddHuidigeReservering(Reservering res)
	{
		huidigeReserveringen.add(res);
	}
	
	// Remove huidige reservering TODO check of dit werkt zoals intended
	@Override
	public void RemoveHuidigeReservering(Reservering res)
	{
		huidigeReserveringen.remove(res);
	}
	
	@Override
	public int GetHuidigeReserveringsTijdInMin()
	{
		return huidigeReserveringsTijd;
	}
	
	@Override
	public void SetHuidigeReserveringsTijdInMin(int resTijd)
	{
		huidigeReserveringsTijd = resTijd;
	}
	
	@Override
	public int GetMaximaleReserveringsTijdInMin()
	{
		return maximaleReserveringstijdInMinuten;
	}
	
	@Override
	public int GetMaximaalAantalReserveringen()
	{
		return maximaalAantalReserveringen;
	}
}
