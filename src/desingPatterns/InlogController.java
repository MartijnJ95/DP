package desingPatterns;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InlogController
{
	private InlogView inlogView;
	private Storage storageModel;
	private String gebrNaam;
	
	// object factory
	private GebruikersFactory gebruikersFactory = new GebruikersFactory();
	
	public InlogController(InlogView inlogView, Storage storageModel)
	{
		this.inlogView = inlogView;
		this.storageModel = storageModel;
		this.inlogView.addInlogListener(new LogInListener());
	}
	
	// Method voor het inloggen
	// LogIn maakt een geheel nieuwe gebruiker aan
	public void LogIn(String gebrNaam)
	{
		this.gebrNaam = gebrNaam;
	}
	
	// CheckLogIn
	public void checkLogIn(String gebrNaam)
	{
		
	}
	
	// Method achter de Button op inlogView
	class LogInListener implements ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Storage storage = Storage.getInstance();
			try
			{
				gebrNaam = inlogView.getUsername();
				Gebruiker gebruiker = gebruikersFactory.getGebruiker("STUDENT");
				
				storage.addGebruiker(gebrNaam, gebruiker);
				storage.setHuidigeIngelogd(gebruiker);
				
				//inlogView.showUsername(gebrNaam);
				
				// Switch naar het lokaaloverzicht view
				inlogView.setVisible(false);
				
				LokaalOverzichtView lokaalOverzichtView = new LokaalOverzichtView();
				lokaalOverzichtView.setVisible(true);
				LokaalOverzichtController lokOverzichtController = new LokaalOverzichtController(lokaalOverzichtView, storage);
				
				System.out.println("Huidige geruiker is " + gebrNaam);
				System.out.println("Alle gebruikers: " + storage.getAllGebruikers());
			}
			catch(Exception ex)
			{
				inlogView.displayErrorMsg("Er ging iets verkeerd!");
			}
		}
	}
}