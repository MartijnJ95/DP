package desingPatterns;

import java.util.HashMap;

import javax.swing.JOptionPane;

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
	// Storage constructor private zodat hij niet geinstantieerd kan worden
	private Storage(){}
	
	// HashMaps
	private HashMap<String, Lokaal> lokalen = new HashMap<String, Lokaal>();
	private HashMap<String, Gebruiker> gebruikers = new HashMap<String, Gebruiker>();
	
	// Voeg gebruiker toe op naam en object
	public void addGebruiker(String gebruikerNaam, Gebruiker gebr)
	{
		if(gebruikers.containsKey(gebruikerNaam) != true)
		{
			// DO NOTHING
			gebruikers.put(gebruikerNaam, gebr);
		}
	}
	
	// Voeg lokaal toe op lokaalnummer en object
	public void addLokaal(String lokaalNummer, Lokaal lok)
	{
		if(lokalen.containsKey(lokaalNummer) != true)
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
	
	// Vullen van de Storage
	public void fillStorage() 
	{	
		// Set Gebruikers in factory
		Gebruiker kevin = gebruikersFactory.getGebruiker("STUDENT");
		Gebruiker martijn = gebruikersFactory.getGebruiker("STUDENT");
		Gebruiker wilco = gebruikersFactory.getGebruiker("DOCENT");
		Gebruiker xing = gebruikersFactory.getGebruiker("ADMINISTRATOR");

		// TODO setten voor later indien nodig
		kevin.SetNaam("Kevin");
		martijn.SetNaam("Martijn");
		wilco.SetNaam("Wilco");
		xing.SetNaam("Xing");
		
		// Vullen HashMap
		gebruikers.put("Kevin", kevin);
		gebruikers.put("Martijn", martijn);
		gebruikers.put("Wilco", wilco);
		gebruikers.put("Xing", xing);
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
	
	// Singleton instance, get enige beschikbare object
	public static Storage getInstance() 
	{
		if(instance == null)
		{
			instance = new Storage();
		}
		return instance;
	}
}