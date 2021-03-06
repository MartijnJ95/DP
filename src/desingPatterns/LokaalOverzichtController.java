package desingPatterns;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

public class LokaalOverzichtController {

	private LokaalOverzichtView lokOverzicht;
	
	// Constructor
	public LokaalOverzichtController(LokaalOverzichtView lokOverzicht)
	{
		this.lokOverzicht = lokOverzicht;
		
		this.lokOverzicht.addLogoutListener(new LogOutListener());
		this.lokOverzicht.mouseListener(new MouseClickListener());
	}

	// Mouse listener for table click
	class MouseClickListener implements MouseListener
	{
		@Override
		public void mousePressed(MouseEvent evt){
			
			// Get the clicked lokaalnumber
			Storage storage = Storage.getInstance();
			Lokaal lokaal = storage.getLokaalByNr(lokOverzicht.getClicked(evt.getPoint()));
			
			// If a lokaal is selected go to the detailed view, if not; show error message
			if(lokaal != null)
			{
				LokaalDetailView lokaalDetailView = new LokaalDetailView(lokaal);
				lokaalDetailView.setVisible(true);
				LokaalDetailController lokOverzichtController = new LokaalDetailController(lokaalDetailView);
			}
			else
			{
				lokOverzicht.displayErrorMsg("Selecteer een lokaal");
			}
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	// When the logout button is pressed, logout
	class LogOutListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Storage storage = Storage.getInstance();
			storage.setHuidigeIngelogd(null);
			lokOverzicht.setVisible(false);
			
			InlogView inlogView = new InlogView();
			inlogView.setVisible(true);
			InlogController controller = new InlogController(inlogView);
		}
	}
}
