package desingPatterns;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LokaalDetailController 
{
	private LokaalDetailView lokDetView;
	private Storage storageModel;
	private Gebruiker huidigeIngelogd;
	
	public LokaalDetailController(LokaalDetailView lokDetView, Storage storageModel)
	{
		//Storage storage = Storage.getInstance();
		this.lokDetView = lokDetView;
		this.storageModel = storageModel;
		
		this.lokDetView.addReserveerListener(new ReserveerListener());
	}
	
	
	class ReserveerListener implements ActionListener
	{
	
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Storage storage = Storage.getInstance();
			try
			{
				huidigeIngelogd = storage.GetHuidigeIngelogd();
				System.out.println(lokDetView.getReservering());
				System.out.println("Banaan");
			}
			catch(Exception ex)
			{
				lokDetView.displayErrorMsg("Er ging iets verkeerd!"+ ex);
			}
		}
	}
}