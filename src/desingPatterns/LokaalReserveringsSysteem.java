package desingPatterns;

public class LokaalReserveringsSysteem {
	
	public static void main(String[] args)
	{
	// Get enige beschikbare object
	Storage storage = Storage.getInstance();
	
	// Fill Storage
	storage.fillStorage();
	}
}
