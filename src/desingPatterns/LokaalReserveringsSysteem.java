package desingPatterns;

public class LokaalReserveringsSysteem 
{
	
	// Main Class
	public static void main(String[] args)
	{
	// Get enige beschikbare object
	Storage storage = Storage.getInstance();
	
	// Fill Storage
	storage.fillStorage();
	
	// Instantieer de view
	InlogView inlogView = new InlogView();
	
	// Call de inlog view
	inlogView.setVisible(true);
	}
}