package desingPatterns;

public class GebruikersFactory {

	public Gebruiker getGebruiker(String gebruikersType)
	{
		if(gebruikersType == null)
		{
			return null;
		}
		else if(gebruikersType.equalsIgnoreCase("ADMINISTRATOR"))
		{
			return new Administrator();
		}
		else if(gebruikersType.equalsIgnoreCase("DOCENT"))
		{
			return new Docent();
		}
		else if(gebruikersType.equalsIgnoreCase("STUDENT"))
		{
			return new Student();
		}
		return null;
	}
}

