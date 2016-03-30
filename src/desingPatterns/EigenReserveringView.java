package desingPatterns;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class EigenReserveringView extends JFrame 
{
	
	/**
	 * Standard serial, not used but avoids warnings.
	 */
	private static final long serialVersionUID = 1L;
	
	private ButtonGroup tijdGroep;
	
	EigenReserveringView()
	{
		super("Maak een Reservering");
		
		JPanel reserveringPanel = new JPanel();
		JRadioButton halfNegen = new JRadioButton("8:30", true);
		JRadioButton kwartOverNegen = new JRadioButton("9:15", false);
		JRadioButton kwartOverTien = new JRadioButton("10:15", false);
		JRadioButton elfUur = new JRadioButton("11:00", false);
		JRadioButton kwartVoorTwaalf = new JRadioButton("11:45", false);
		JRadioButton halfEen = new JRadioButton("12:30", false);
		JRadioButton kwartOverEen = new JRadioButton("13:15", false);
		JRadioButton tweeUur = new JRadioButton("14:00", false);
		JRadioButton drieUur = new JRadioButton("15:00", false);
		JRadioButton kwartVoorVier = new JRadioButton("15:45", false);
		JRadioButton halfVijf = new JRadioButton("16:30", false);
		
		tijdGroep = new ButtonGroup();
		
		this.add(reserveringPanel);
		
		reserveringPanel.add(halfNegen);
		reserveringPanel.add(kwartOverNegen);
		reserveringPanel.add(kwartOverTien);
		reserveringPanel.add(elfUur);
		reserveringPanel.add(kwartVoorTwaalf);
		reserveringPanel.add(halfEen);
		reserveringPanel.add(kwartOverEen);
		reserveringPanel.add(tweeUur);
		reserveringPanel.add(drieUur);
		reserveringPanel.add(kwartVoorVier);
		reserveringPanel.add(halfVijf);
		
		tijdGroep.add(halfNegen);
		tijdGroep.add(kwartOverNegen);
		tijdGroep.add(kwartOverTien);
		tijdGroep.add(elfUur);
		tijdGroep.add(kwartVoorTwaalf);
		tijdGroep.add(halfEen);
		tijdGroep.add(kwartOverEen);
		tijdGroep.add(tweeUur);
		tijdGroep.add(drieUur);
		tijdGroep.add(kwartVoorVier);
		tijdGroep.add(halfVijf);
		
		
	}
}