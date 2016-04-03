package desingPatterns;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class LokaalDetailController 
{
	private LokaalDetailView lokDetView;
	private Gebruiker huidigeIngelogd;
	
	// Constructor
	public LokaalDetailController(LokaalDetailView lokDetView)
	{
		this.lokDetView = lokDetView;
		this.lokDetView.addReserveerListener(new ReserveerListener());
	}
	
	// Create a new reservation
	private void maakReservering(Date beginTijd)
	{
		Storage storage = Storage.getInstance();
		Reservering res = new Reservering();
		Gebruiker gebr = storage.GetHuidigeIngelogd();
		Lokaal lok = lokDetView.getHuidigLokaal();
		Boolean canContinue = true;
		
		// Check if the max amount of reservations is not exceeded
		if(gebr.GetMaximaalAantalReserveringen() - 1 > gebr.GetHuidigeReservingen().size())
		{
			// Check if there are no reservations with the same hour in the gebruiker
			for(int i = 0; i < gebr.GetHuidigeReservingen().size(); i++)
			{
				Reservering gebrRes = gebr.GetHuidigeReservingen().get(i);
				if(gebrRes != null)
				{
					if(gebrRes.GetBeginTijd().equals(beginTijd))
					{
						canContinue = false;
					}
				}
			}
			// Do the same here but for this lokaal
			for(int i = 0; i < lok.GetReseringen().size(); i ++)
			{
				Reservering lokRes = lok.GetReseringen().get(i);
				if(lokRes != null)
				{
					if(lokRes.GetBeginTijd().equals(beginTijd))
					{
						canContinue = false;
					}	
				}
			}
			
			// Create a new reservation
			if(lokDetView.isEenUur() && canContinue)
			{
				res = storage.MaakReservering(new ReserveringVanEenUur(), beginTijd);
			}
			else if(lokDetView.isTweeUur() && canContinue)
			{
				res = storage.MaakReservering(new ReserveringVanTweeUur(), beginTijd);
			}
			else if(lokDetView.isDrieUur() && canContinue)
			{
				res = storage.MaakReservering(new ReserveringVanDrieUur(), beginTijd);
			}
			if(canContinue)
			{
				gebr.AddHuidigeReservering(res);
				lok.AddReservering(res);
			}
			else
			{
				lokDetView.displayErrorMsg("Deze reservering bestaat al");
			}
		}
		else
		{
			lokDetView.displayErrorMsg("Maximaal aantal reserveringen bereikt");
		}
	}

	// The button listener for the view
	class ReserveerListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Storage storage = Storage.getInstance();
			try
			{
				// Create a new reservation and close the window
				huidigeIngelogd = storage.GetHuidigeIngelogd();
				maakReservering(lokDetView.getReservering());
				lokDetView.dispose();
			}
			catch(Exception ex)
			{
				lokDetView.displayErrorMsg("Er ging iets verkeerd!"+ ex);
			}
		}
	}
}