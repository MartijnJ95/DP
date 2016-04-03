package desingPatterns;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


public class LokaalOverzichtView extends JFrame {

	/**
	 * Nodig bij extends JFrame
	 */
	private static final long serialVersionUID = 1L;
	JPanel lokOverzichtPanel;
	private JTable overzichtTabel;
	private JScrollPane scrollPane;
	private JButton uitlogKnop = new JButton("Log Out");
	
	LokaalOverzichtView()
	{
		// Add description
		super("Lokalen overzicht");
	
		// Create new Jframe and set size and onclose method
		lokOverzichtPanel = new JPanel();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400,400);
		this.setResizable(true);
		
		// Get the instance of storage and fill the table with the lokalen
		Storage storage = Storage.getInstance();
		fillTable(storage.getAllLokalen());
		
		// Add componenten aan de JFrame
		lokOverzichtPanel.add(uitlogKnop);
		
		this.add(lokOverzichtPanel);
	}
	
	// Fill the table from the hashmap
	public void fillTable(HashMap<String, Lokaal> lokMap)
	{
		// Get all the keys from the hashmap
		ArrayList<String> lokaalList = new ArrayList<String>(lokMap.keySet());
		
		// Sort the list
		Collections.sort(lokaalList);
		
		// Create a new table
		CustomTableModel tableModel = new CustomTableModel(lokaalList);
		overzichtTabel = new JTable(tableModel);
		overzichtTabel.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		
		// Create the scrollpane and set the dimensions
		scrollPane = new JScrollPane(overzichtTabel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(300,300));
		
		// Add scrollpane to the panel
		lokOverzichtPanel.add(scrollPane, BorderLayout.LINE_START);
	}
	
	// Mouselistener for tableclick
	void mouseListener(MouseListener list)
	{
		overzichtTabel.addMouseListener(list);
	}
	
	// Actionlistener for loguit button
	void addLogoutListener(ActionListener listenForLogOutButton)
	{
		uitlogKnop.addActionListener(listenForLogOutButton);
	}
	
	// Return the lokaalnummer string
	public String getClicked(Point point)
	{
		int r = overzichtTabel.rowAtPoint(point);
		int c = overzichtTabel.columnAtPoint(point);
		String returnString = (String)overzichtTabel.getValueAt(r, c);
		return returnString;
	}
	
	// Show error
	public void displayErrorMsg(String msg)
	{
		JOptionPane.showMessageDialog(this, msg);
	}
}


// Custom table model to use the arraylist
class CustomTableModel extends AbstractTableModel{
	
	private ArrayList<String> al = new ArrayList<String>();
	private String[] header = {"Lokaal nummer", "Reserveringen"};
	
	// Constructor
	public CustomTableModel(ArrayList<String> lokList)
	{
		al = lokList;
	}
	
	@Override
	public int getRowCount()
	{
		return al.size();					
	}
	
	@Override
	public Object getValueAt(int row, int col)
	{
		Storage storage = Storage.getInstance();
		Lokaal lok = storage.getLokaalByNr(al.get(row)); 
		
		switch(col)
		{
		case 0:
			return lok.GetLokaalNummer();
		case 1:
			// Show all the reservations made for all the lokalen
			ArrayList<Reservering> resList = lok.GetReseringen();
			String output = "";
			if(resList.size() != 0)
			{
				for(int i = 0; i < resList.size(); i++)
				{
					Reservering res = resList.get(i);
					SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss dd:MM");
					String begin = format.format(res.GetBeginTijd());
					String eind = format.format(res.GetEindTijd());
					output += (begin + " - " + eind + " ; "); 
				}
			}
			else
			{
				output += "Geen Reserveringen";
			}
			return output;
		default:
			return "unknown";
		}
	}
	
	public String getColmnName(int col)
	{
		return header[col];
	}
	
	@Override
	public Class getColumnClass(int c)
	{
		return getValueAt(0,c).getClass();
	}

	@Override
	public int getColumnCount() {
		return header.length;
	}
}


