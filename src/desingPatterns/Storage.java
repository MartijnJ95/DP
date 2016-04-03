package desingPatterns;

import java.util.Date;
import java.util.HashMap;


public class Storage 
{
	// object Lokaal
	private Lokaal Lokaal;
	// object Gebruiker
	private Gebruiker gebruiker;
	// object factory
	private GebruikersFactory gebruikersFactory = new GebruikersFactory();
	
	// Singleton Instance
	private static Storage instance; // = new Storage();
	// Storage constructor private
	private Storage(){}
	
	// HashMaps
	private HashMap<String, Lokaal> lokalen = new HashMap<String, Lokaal>();
	private HashMap<String, Gebruiker> gebruikers = new HashMap<String, Gebruiker>();
	
	// Add gebruiker with name and gebruiker object
	public void addGebruiker(String gebruikerNaam, Gebruiker gebr)
	{
		if(gebruikers.containsKey(gebruikerNaam) == false)
		{
			// Create new gebruiker.
			gebruikers.put(gebruikerNaam, gebr);
		}
	}
	
	// Voeg lokaal toe op lokaalnummer en object
	public void addLokaal(String lokaalNummer, Lokaal lok)
	{
		if(lokalen.containsKey(lokaalNummer) == false)
		{
			lokalen.put(lokaalNummer, lok);
		}
	}
	
	// Returned de gebruikers list
	public HashMap<String, Gebruiker> getAllGebruikers()
	{
		return gebruikers;
	}
	
	// Returned de lokalen list
	public HashMap<String, Lokaal> getAllLokalen()
	{
		return lokalen;
	}
	
	// Return de gebruiker op naam
	public Gebruiker getGebruikerByName(String name)
	{
		return gebruikers.get(name);
	}
	
	// Return lokaal op nummer (String)
	public Lokaal getLokaalByNr(String nr)
	{
		return lokalen.get(nr);
	}
	
	// Method to fill the storage with gebruikers and lokalen
	public void fillStorage() 
	{	
		// Get gebruikers using factory
		Gebruiker kevin = gebruikersFactory.getGebruiker("STUDENT");
		Gebruiker martijn = gebruikersFactory.getGebruiker("STUDENT");
		Gebruiker wilco = gebruikersFactory.getGebruiker("DOCENT");
		Gebruiker xing = gebruikersFactory.getGebruiker("ADMINISTRATOR");
		
		// Set name
		kevin.SetNaam("Kevin");
		martijn.SetNaam("Martijn");
		wilco.SetNaam("Wilco");
		xing.SetNaam("Xing");
		
		// Fill HashMap
		gebruikers.put("Kevin", kevin);
		gebruikers.put("Martijn", martijn);
		gebruikers.put("Wilco", wilco);
		gebruikers.put("Xing", xing);
		
		// Fill lokalen
		for(int i = 1000; i< 1023; i++)
		{
			Lokaal lokaal = new Lokaal();
			lokaal.SetLokaalNummer(Integer.toString(i));
			addLokaal(Integer.toString(i), lokaal);
		}
	}
	
	// Set de huigige ingelogd
	public void setHuidigeIngelogd(Gebruiker gebr) 
	{
		this.gebruiker = gebr;
	}
	
	// Get de huidige gebruiker
	public Gebruiker GetHuidigeIngelogd() 
	{
		return gebruiker;
	}
	
	// Singleton instance, Get instance
	public static Storage getInstance() 
	{
		if(instance == null)
		{
			instance = new Storage();
		}
		return instance;
	}
	
	// Create new reservation
	public Reservering MaakReservering(ReserveringsStrategy strategy, Date beginTijd)
	{
		return strategy.MaakReservering(beginTijd);
	}
}