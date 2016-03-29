package desingPatterns;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class LokaalOverzichtView extends JFrame {

	/**
	 * Nodig bij extends JFrame
	 */
	private static final long serialVersionUID = 1L;
	JPanel lokOverzichtPanel;
	private JTable overzichtTabel;
	
	private JButton uitlogKnop = new JButton();
	
	LokaalOverzichtView()
	{
		// Geef beschrijving mee
		super("Lokalen overzicht");
	
		// Creer nieuwe JFrame en zet de size en onclose
		lokOverzichtPanel = new JPanel();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(350,150);
		this.setResizable(false);
		
		// Add componenten aan de JFrame
		lokOverzichtPanel.add(uitlogKnop);
		
		// Get the instance of storage and fill the table with the lokalen
		Storage storage = Storage.getInstance();
		fillTable(storage.getAllLokalen());
		
		this.add(lokOverzichtPanel);
	}
	
	// Fill the table from the hashmap
	public void fillTable(HashMap<String, Lokaal> lokMap)
	{
		ArrayList<Lokaal> lokaalList = new ArrayList<Lokaal>(lokMap.values());
		overzichtTabel = new JTable(new customTableModel(lokaalList));
		
		JScrollPane scrollPane = new JScrollPane(overzichtTabel);
		lokOverzichtPanel.add(scrollPane);
		
		// Add listener to the table
		overzichtTabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent evt){
				int row = overzichtTabel.rowAtPoint(evt.getPoint());
				int col = overzichtTabel.columnAtPoint(evt.getPoint());
				
				Lokaal test = (Lokaal)overzichtTabel.getValueAt(row, col);
				switchNaarAnderView(test);
			}
		});
	}
	
	// Switch naar de lokalen detail view waar gereserveerd kan worden
	private void switchNaarAnderView(Lokaal test)
	{
		System.out.println(test);
	}
}

// Custom table model to use the arraylist
class customTableModel extends DefaultTableModel{
	
	ArrayList<Lokaal> al;
	String[] header;
	
	customTableModel(ArrayList<Lokaal> lokList)
	{
		al = lokList;
	}
	
	public int getRowCount()
	{
		return al.size();
	}
	
	@Override
	public Lokaal getValueAt(int row, int col)
	{
		return al.get(row);
	}
	
	public String getColmnName(int index)
	{
		return header[index];
	}
	
	public Class getColumnClass(int c)
	{
		return getValueAt(0,c).getClass();
	}
}


