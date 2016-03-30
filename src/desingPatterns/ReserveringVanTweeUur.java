package desingPatterns;

import java.util.Calendar;
import java.util.Date;

public class ReserveringVanTweeUur implements ReserveringsStrategy {
	
	public ReserveringVanTweeUur()
	{
		
	}
	
	@Override
	public Reservering MaakReservering(Date beginTijd)
	{
		Reservering res = new Reservering();
		Storage storage = Storage.getInstance();
		
		res.SetBeginTijd(beginTijd);
		Calendar cal = Calendar.getInstance();
		cal.setTime(beginTijd);
		cal.add(Calendar.MINUTE, 120);
		res.SetEindTijd(cal.getTime());
		
		res.SetGebruiker(storage.GetHuidigeIngelogd());
		
		return res;
	}
}