package desingPatterns;

import java.util.Date;

public interface ReserveringsStrategy {
	
	Reservering MaakReservering(Date beginTijd);
}
