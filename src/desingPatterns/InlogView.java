package desingPatterns;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class InlogView extends JFrame
{
	/**
	 * Standard serial, not used but avoids warnings.
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField gebruikersNaam = new JTextField(10);
	//private JTextField gebruikersNaamShow = new JTextField(10);
	private JButton logInButton = new JButton("Log In");
	
	// Public! Wordt aangeroepen door MAIN
	InlogView()
	{
		super("Inlog Scherm");
		
		JPanel logInPanel = new JPanel();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(350, 150);
		this.setResizable(false);
		
		logInPanel.add(gebruikersNaam);
		//For Testing
		//logInPanel.add(gebruikersNaamShow);
		logInPanel.add(logInButton);
		logInButton.setEnabled(false);
		
		this.add(logInPanel);
		
		this.gebruikersNaam.getDocument().addDocumentListener(new MyDocumentListener());
	}
	
	// Class DocumentListener checkt de status van de TextArea.
	class MyDocumentListener implements DocumentListener
	{

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			changed();
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			changed();
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			changed();
		}
		
		// Checked of de login button actief of niet actief moet zijn.
		public void changed()
		{
			if(getUsername().equals(""))
			{
				logInButton.setEnabled(false);
			}
			else
			{
				logInButton.setEnabled(true);
			}
		}
	}
	
	// Get de username die is ingevuld
	public String getUsername()
	{
		return gebruikersNaam.getText();
	}
	
	/*public void showUsername(String gebruikersNaam)
	{
		gebruikersNaamShow.setText(gebruikersNaam);
	}*/

	// Add actionlistener voor de inlog button
	void addInlogListener(ActionListener listenForLogInButton)
	{
		logInButton.addActionListener(listenForLogInButton);
	}
	
	// Error message bij leeg textveld
	public void displayErrorMsg(String errorMsg)
	{
		JOptionPane.showMessageDialog(this, errorMsg);
	}
}