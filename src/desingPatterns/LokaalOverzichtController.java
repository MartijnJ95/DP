package desingPatterns;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LokaalOverzichtController {

	private LokaalOverzichtView lokOverzicht;
	private Storage storageModel;
	
	// Constructor
	public LokaalOverzichtController(LokaalOverzichtView lokOverzicht, Storage storageModel)
	{
		this.lokOverzicht = lokOverzicht;
		this.storageModel = storageModel;
		
		// On start fill the table with lokalen
		getAllLokalen();
		
		// Room for listeners
		// this.lokOvezicht.addListenernaamhier(new addListenernaamhier());
	}
	
	// Get all lokalen en vul de tabel
	private void getAllLokalen()
	{
		// Get storage and all the lokalen in the storage
		Storage storage = Storage.getInstance();
		HashMap<String, Lokaal> lok = storage.getAllLokalen();
			
		// Send the hashmap to the view and fill the table
		lokOverzicht.fillTable(lok);
	}
	
	
}
