package desingPatterns;

import java.util.ArrayList;
import java.util.HashMap;

public class Storage {
	
	// object Lokaal
	private Lokaal lokaal;
	// object Gebruiker
	private Gebruiker gebruiker;
	
	// HashMaps
	private HashMap<String, Lokaal> lokalen = new HashMap<String, Lokaal>();
	private HashMap<String, Gebruiker> gebruikers = new HashMap<String, Gebruiker>();
	
	// Voeg gebruiker toe op naam en object
	public void AddGebruiker(String gebruikerNaam, Gebruiker gebr) {
		gebruikers.put(gebruikerNaam, gebr);
	}
	
	// Voeg lokaal toe op lokaalnummer en object
	public void AddLokaal(String lokaalNummer, Lokaal lok) {
		lokalen.put(lokaalNummer, lok);
	}
	
	// Returned de gebruikers list
	public HashMap<String, Gebruiker> GetAllGebruikers() {
		return gebruikers;
	}
	
	// Returned de lokalen list
	public HashMap<String, Lokaal> GetAllLokalen() {
		return lokalen;
	}
	
	// Return de gebruiker op naam
	public Gebruiker GetGebruikerByName(String name) {
		return gebruikers.get(name);
	}
	
	
	public void FillStorage() {
		Gebruiker kevin = GebruikersFactory.GetGebruiker(Student);
		Gebruiker martijn = GebruikersFactory.GetGebruiker(Student);
		Gebruiker wilco = GebruikersFactory.GetGebruiker(Docent);
		Gebruiker xing = GebruikersFactory.GetGebruiker(Administrator);
		
		
	}
	
	
	public void GetHuidigeIngelogd() {
		
	}
	
	
	public void SetHuidigeIngelogd(Gebruiker gebr) {
		
	}
	
	
	public void GetLokaalByNr(String nr) {
		
	}
	
	
	public void GetInstance() {
		
	}
}