package desingPatterns;

import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class LokaalDetailView extends JFrame
{
	/**
	 * Standard serial, not used but avoids warnings.
	 */
	private static final long serialVersionUID = 1L;
	
	// Fields
	private ButtonGroup tijdGroep;
	private ButtonGroup tijdsDuurGroep;
	private JButton reserveerButton = new JButton("Reserveer");
	private JRadioButton halfNegen = new JRadioButton("8:30", true);
	private JRadioButton kwartOverNegen = new JRadioButton("9:15", false);
	private JRadioButton kwartOverTien = new JRadioButton("10:15", false);
	private JRadioButton elfUur = new JRadioButton("11:00", false);
	private JRadioButton kwartVoorTwaalf = new JRadioButton("11:45", false);
	private JRadioButton halfEen = new JRadioButton("12:30", false);
	private JRadioButton kwartOverEen = new JRadioButton("13:15", false);
	private JRadioButton tweeUur = new JRadioButton("14:00", false);
	private JRadioButton drieUur = new JRadioButton("15:00", false);
	private JRadioButton kwartVoorVier = new JRadioButton("15:45", false);
	private JRadioButton halfVijf = new JRadioButton("16:30", false);

	private JRadioButton reserveringEenUur = new JRadioButton("1 Uur", true);
	private JRadioButton reserveringTweeUur = new JRadioButton("2 Uur", false);
	private JRadioButton reserveringDrieUur = new JRadioButton("3 Uur", false);
	
	private String reservering;
	private Date reserveringParsed;
	
	private Boolean isEenUur = false;
	private Boolean isTweeUur = false;
	private Boolean isDrieUur = false;
	
	private Lokaal huidigLokaal;
	
	// Constructor
	LokaalDetailView(Lokaal lokaal)
	{
		super("Maak een Reservering");
		
		// Set the current lokaal as the give lokaal
		huidigLokaal = lokaal;
		
		// Set the size of the frame
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(550, 350);
		this.setResizable(false);
		
		// Create a new frame
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		JPanel reserveringPanel = new JPanel();
		JPanel reserveringsTijdPanel = new JPanel();
		
		tijdGroep = new ButtonGroup();
		
		this.add(mainPanel);
		
		mainPanel.add(reserveringsTijdPanel);
		mainPanel.add(reserveringPanel);
		mainPanel.add(reserveerButton);
		
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
		
		reserveringsTijdPanel.add(reserveringEenUur);
		reserveringsTijdPanel.add(reserveringTweeUur);
		reserveringsTijdPanel.add(reserveringDrieUur);
		
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
		
		tijdsDuurGroep = new ButtonGroup();
		
		tijdsDuurGroep.add(reserveringEenUur);
		tijdsDuurGroep.add(reserveringTweeUur);
		tijdsDuurGroep.add(reserveringDrieUur);
	}
	
	// Get the current lokaal in which the reservation is made
	public Lokaal getHuidigLokaal()
	{
		return huidigLokaal;
	}
	
	// Get the time of the reservation
	public Date getReservering() throws Exception
	{
		if(halfNegen.isSelected())
		{
			reservering = "08:30";
		}
		if(kwartOverNegen.isSelected())
		{
			reservering = "09:15";
		}
		if(kwartOverTien.isSelected())
		{
			reservering = "10:15";
		}
		if(elfUur.isSelected())
		{
			reservering = "11:00";
		}
		if(kwartVoorTwaalf.isSelected())
		{
			reservering = "11:45";
		}
		if(halfEen.isSelected())
		{
			reservering = "12:30";
		}
		if(kwartOverEen.isSelected())
		{
			reservering = "13:15";
		}
		if(tweeUur.isSelected())
		{
			reservering = "14:00";
		}
		if(drieUur.isSelected())
		{
			reservering = "15:00";
		}
		if(kwartVoorVier.isSelected())
		{
			reservering = "15:45";
		}
		if(halfVijf.isSelected())
		{
			reservering = "16:30";
		}
		
		// Get the time and convert it to the date object
		Calendar myDate = new GregorianCalendar();
		Calendar now = Calendar.getInstance();
		String target = reservering;
		Date theDate = new SimpleDateFormat("HH:mm", Locale.ENGLISH).parse(target);
		myDate.setTime(theDate);
		
		myDate.set(Calendar.DAY_OF_MONTH, now.get(Calendar.DAY_OF_MONTH));
		myDate.set(Calendar.MONTH, now.get(Calendar.MONTH));
		myDate.set(Calendar.YEAR, now.get(Calendar.YEAR));
		Date reserveDate = myDate.getTime();
		
		reserveringParsed = reserveDate;
		
		if(reserveringEenUur.isSelected())
		{
			isEenUur = true;
		}
		else if(reserveringTweeUur.isSelected())
		{
			isTweeUur = true;
		}
		if(reserveringDrieUur.isSelected())
		{
			isDrieUur = true;
		}
		return reserveringParsed;
	}
	
	// Get which radio button is true
	public Boolean isEenUur()
	{
		return isEenUur;
	}
	public Boolean isTweeUur()
	{
		return isTweeUur;
	}
	public Boolean isDrieUur()
	{
		return isDrieUur;
	}
	
	// Reservation button listener
	public void addReserveerListener(ActionListener listenForReserveerButton)
	{
		reserveerButton.addActionListener(listenForReserveerButton);
	}
	
	// Show error message
	public void displayErrorMsg(String errorMsg)
	{
		JOptionPane.showMessageDialog(this, errorMsg);
	}
}