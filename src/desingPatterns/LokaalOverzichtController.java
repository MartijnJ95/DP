package desingPatterns;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

public class LokaalOverzichtController {

	private LokaalOverzichtView lokOverzicht;
	private Storage storageModel;
	
	// Constructor
	public LokaalOverzichtController(LokaalOverzichtView lokOverzicht, Storage storageModel)
	{
		this.lokOverzicht = lokOverzicht;
		this.storageModel = storageModel;
		
		this.lokOverzicht.addLogoutListener(new LogOutListener());
		this.lokOverzicht.mouseListener(new MouseClickListener());
	}

	// Test code voor mouse click listener
	class MouseClickListener implements MouseListener
	{
		@Override
		public void mousePressed(MouseEvent evt){
			
			Storage storage = Storage.getInstance();
			Lokaal lokaal = storage.getLokaalByNr(lokOverzicht.getClicked(evt.getPoint()));
			
			LokaalDetailView lokaalDetailView = new LokaalDetailView();
			lokaalDetailView.setVisible(true);
			LokaalDetailController lokOverzichtController = new LokaalDetailController(lokaalDetailView, storage);
			//geef lokaal mee aan de detailview.
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
			InlogController controller = new InlogController(inlogView, storage);
		}
	}
}
