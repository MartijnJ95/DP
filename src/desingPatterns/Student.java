package desingPatterns;

import java.util.ArrayList;

public class Student implements Gebruiker{

	private String naam;
	private int maximaalAantalReserveringen;
	private ArrayList<Reservering> huidigeReserveringen;
	
	// Constructor
	public Student()
	{
		huidigeReserveringen = new ArrayList<Reservering>();
		maximaalAantalReserveringen = 5;
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
	
	// Remove huidige reservering
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
