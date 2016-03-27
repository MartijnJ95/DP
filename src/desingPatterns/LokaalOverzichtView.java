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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class LokaalOverzichtView extends JFrame {

	/**
	 * Nodig bij extends JFrame
	 */
	private static final long serialVersionUID = 1L;

	private JTable overzichtTabel = new JTable();
	
	private JButton uitlogKnop = new JButton();
	
	LokaalOverzichtView()
	{
		// Geef beschrijving mee
		super("Lokalen overzicht");
	
		// Creer nieuwe JFrame en zet de size en onclose
		JPanel lokOverzichtPanel = new JPanel();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(350,150);
		this.setResizable(false);
		
		// Add componenten aan de JFrame
		lokOverzichtPanel.add(overzichtTabel);
		lokOverzichtPanel.add(uitlogKnop);
		
		this.add(lokOverzichtPanel);
	}
	
	// Fill the table from the hashmap
	public void fillTable(HashMap<String, Lokaal> lokMap)
	{
		List<Lokaal> lokaalList = new ArrayList<Lokaal>(lokMap.values());
		// Gebruik lokaallist om de table te vullen. 
	}
	
	private void addTableListener()
	{
		overzichtTabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent evt){
				int row = overzichtTabel.rowAtPoint(evt.getPoint());
				int col = overzichtTabel.columnAtPoint(evt.getPoint());
				
				
				Object test = overzichtTabel.getValueAt(row, col);
				switchNaarAnderView(test);
			}
		});
	}
	
	// Switch naar de lokalen detail view waar gereserveerd kan worden
	private void switchNaarAnderView(Object test)
	{
		System.out.println(test);
	}
}
