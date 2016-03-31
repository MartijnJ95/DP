package desingPatterns;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InlogController
{
	private InlogView inlogView;
	private String gebrNaam;
	private GebruikersFactory gebruikersFactory = new GebruikersFactory();
	
	// Constructor
	public InlogController(InlogView inlogView)
	{
		this.inlogView = inlogView;
		this.inlogView.addInlogListener(new LogInListener());
	}
	
	// LogIn maakt een geheel nieuwe gebruiker aan
	public void LogIn(String gebrNaam)
	{
		this.gebrNaam = gebrNaam;
	}
		
	// Method achter de login button op inlogView
	class LogInListener implements ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Storage storage = Storage.getInstance();
			try
			{
				// Haal de gebruikersnaam op en maak een nieuwe gebruiker aan
				gebrNaam = inlogView.getUsername();
				Gebruiker gebruiker = gebruikersFactory.getGebruiker("STUDENT");
				
				// Voeg deze toe aan de storage
				storage.addGebruiker(gebrNaam, gebruiker);
				storage.setHuidigeIngelogd(gebruiker);
				
				// Switch naar het lokaaloverzicht view
				inlogView.setVisible(false);
				
				// 
				LokaalOverzichtView lokaalOverzichtView = new LokaalOverzichtView();
				lokaalOverzichtView.setVisible(true);
				LokaalOverzichtController lokOverzichtController = new LokaalOverzichtController(lokaalOverzichtView);
			}
			catch(Exception ex)
			{
				inlogView.displayErrorMsg("Er ging iets verkeerd!");
			}
		}
	}
}