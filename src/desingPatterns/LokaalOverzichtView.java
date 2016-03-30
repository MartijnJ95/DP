package desingPatterns;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import desingPatterns.LokaalOverzichtController.MouseClickListener;

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
		// Geef beschrijving mee
		super("Lokalen overzicht");
	
		// Creer nieuwe JFrame en zet de size en onclose
		lokOverzichtPanel = new JPanel();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(100,400);
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
		overzichtTabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		// Create the scrollpane and set the dimensions
		scrollPane = new JScrollPane(overzichtTabel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(50,300));
		
		// Add scrollpane to the panel
		lokOverzichtPanel.add(scrollPane);
	}
	
	// Mouselistener voor tableclick
	void mouseListener(MouseListener list)
	{
		overzichtTabel.addMouseListener(list);
	}
	
	// Actionlistener voor loguit button
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
}

// Custom table model to use the arraylist
class CustomTableModel extends AbstractTableModel{
	
	private ArrayList<String> al = new ArrayList<String>();
	String[] header;
	
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
	public String getValueAt(int row, int col)
	{
		return al.get(row);
	}
	
	public String getColmnName(int index)
	{
		return header[index];
	}
	
	@Override
	public Class getColumnClass(int c)
	{
		return getValueAt(0,c).getClass();
	}

	@Override
	public int getColumnCount() {
		return 1;
	}
}


