package desingPatterns;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class LokaalDetailController 
{
	private LokaalDetailView lokDetView;
	private Gebruiker huidigeIngelogd;
	
	// 
	public LokaalDetailController(LokaalDetailView lokDetView)
	{
		this.lokDetView = lokDetView;
		this.lokDetView.addReserveerListener(new ReserveerListener());
	}
	
	private void maakReservering(Date beginTijd)
	{
		Storage storage = Storage.getInstance();
		Reservering res = new Reservering();
		Gebruiker gebr = storage.GetHuidigeIngelogd();
		Lokaal lok = lokDetView.getHuidigLokaal();
		Boolean canContinue = true;
		
		// Check of er niet meer dan 3 reserveringen aanwezig zijn
		if(gebr.GetMaximaalAantalReserveringen() - 1 > gebr.GetHuidigeReservingen().size())
		{
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
				System.out.println(lok.GetReseringen());
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
	
	class ReserveerListener implements ActionListener
	{
	
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Storage storage = Storage.getInstance();
			try
			{
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