package desingPatterns;

public class LokaalReserveringsSysteem 
{
	// Main
	public static void main(String[] args)
	{
	// Get enige beschikbare object
	Storage storage = Storage.getInstance();
	
	// Fill Storage
	storage.fillStorage();
	
	// Instantieer de view
	InlogView inlogView = new InlogView();
	
	// Instantieer de Controller
	InlogController inlogController = new InlogController(inlogView);
	
	// Call de inlog view
	inlogView.setVisible(true);
	}
}