package desingPatterns;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InlogView extends JFrame 
{
	/**
	 * Nodig bij extends JFrame
	 */
	private static final long serialVersionUID = 1L;

	private JTextField gebruikersNaam = new JTextField(10);
	private JTextField gebruikersNaamShow = new JTextField(10);
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
		logInPanel.add(gebruikersNaamShow);
		logInPanel.add(logInButton);
		
		this.add(logInPanel);
	}
	
	// Get de username die is ingevuld
	public String getUsername()
	{
		return gebruikersNaam.getText();
	}
	
	public void showUsername(String gebruikersNaam)
	{
		gebruikersNaamShow.setText(gebruikersNaam);
	}

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