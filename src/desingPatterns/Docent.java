package desingPatterns;

import java.util.ArrayList;

public class Docent implements Gebruiker{
	private String naam;
	private int maximaalAantalReserveringen;
	private ArrayList<Reservering> huidigeReserveringen;
	
	// Constructor
	public Docent()
	{
		huidigeReserveringen = new ArrayList<Reservering>();
		maximaalAantalReserveringen = 15;
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
	public int GetMaximaalAantalReserveringen()
	{
		return maximaalAantalReserveringen;
	}
}
