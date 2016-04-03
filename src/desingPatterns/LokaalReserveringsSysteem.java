package desingPatterns;

public class LokaalReserveringsSysteem 
{
	// Main
	public static void main(String[] args)
	{
	// Get storage instance
	Storage storage = Storage.getInstance();
	
	// Fill Storage
	storage.fillStorage();
	
	// Instantiate the view
	InlogView inlogView = new InlogView();
	
	// Instantiate the controller
	InlogController inlogController = new InlogController(inlogView);
	
	// Call the inlog view
	inlogView.setVisible(true);
	}
}