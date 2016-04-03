package desingPatterns;

import java.util.ArrayList;

public interface Gebruiker {

	String GetNaam();
	void SetNaam(String naam);
	ArrayList<Reservering> GetHuidigeReservingen();
	void AddHuidigeReservering(Reservering res);
	void RemoveHuidigeReservering(Reservering res);
	int GetMaximaalAantalReserveringen();
}
