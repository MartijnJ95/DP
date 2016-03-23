package desingPatterns;

import java.util.HashMap;

public class Storage 
{
	
	// object Lokaal
	private Lokaal Lokaal;
	// object Gebruiker
	private Gebruiker Gebruiker;
	// object factory
	private GebruikersFactory gebruikersFactory;
	// Singleton Instance
	private static Storage instance = null;
	
	// HashMaps
	private HashMap<String, Lokaal> lokalen = new HashMap<String, Lokaal>();
	private HashMap<String, Gebruiker> gebruikers = new HashMap<String, Gebruiker>();
	
	// Voeg gebruiker toe op naam en object
	public void addGebruiker(String gebruikerNaam, Gebruiker gebr) 
	{
		gebruikers.put(gebruikerNaam, gebr);
	}
	
	// Voeg lokaal toe op lokaalnummer en object
	public void addLokaal(String lokaalNummer, Lokaal lok) 
	{
		lokalen.put(lokaalNummer, lok);
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
	
	
	public Lokaal getLokaalByNr(String nr) 
	{
		return lokalen.get(nr);
	}
	
	
	public void fillStorage() 
	{
		// Declare strings
		String Student = "Student";
		String Docent = "Docent";
		String Administrator = "Administrator";
		
		// Set Gebruikers in factory
		Gebruiker kevin = gebruikersFactory.getGebruiker(Student);
		Gebruiker martijn = gebruikersFactory.getGebruiker(Student);
		Gebruiker wilco = gebruikersFactory.getGebruiker(Docent);
		Gebruiker xing = gebruikersFactory.getGebruiker(Administrator);
		
		kevin.SetNaam("Kevin");
		
		martijn.SetNaam("Martijn");
		
		wilco.SetNaam("Wilco");
		
		xing.SetNaam("Xing");
		
		gebruikers.put("Kevin", kevin);
		gebruikers.put("Martijn", martijn);
		gebruikers.put("Wilco", wilco);
		gebruikers.put("Xing", xing);
	}
	
	// Set de huigige ingelogd
	public void setHuidigeIngelogd(Gebruiker gebr) 
	{
		this.Gebruiker = gebr;
	}
	
	
	public Gebruiker GetHuidigeIngelogd() 
	{
		return Gebruiker;
	}
	
	
	public static Storage getInstance() 
	{
		if(instance == null) {
			instance = new Storage();
		}
		return instance;
	}
}