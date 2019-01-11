import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ZurueckgebenFenster extends JFrame {

	private JPanel contentPane;
	private JTable spieleTabelle;
	private JTextField suchenTextField;
	private JTable ausgabeTabelle;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ZurueckgebenFenster() {
		setBounds(100, 100, 582, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 75, 546, 176);
		contentPane.add(panel);
		panel.setLayout(null);
		
		spieleTabelle = new JTable();
		spieleTabelle.setBounds(10, 169, 526, -164);
		panel.add(spieleTabelle);
		spieleTabelle.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Beschreibung", "FSK", "Datum", "Spiel"
			}
		));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 546, 176);
		panel.add(scrollPane_1);
		
		ausgabeTabelle = new JTable();
		ausgabeTabelle.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Spiel","Kundennachname", "IBAN", "Preis", "Menge", "Fälligkeitsdatum", "Ausleihdatum"
			}
		));
		scrollPane_1.setViewportView(ausgabeTabelle);
		
		JButton zurueckgebenButton = new JButton("Zur\u00FCckgeben");
		zurueckgebenButton.setBounds(10, 11, 122, 23);
		contentPane.add(zurueckgebenButton);
		
		JButton suchenButton = new JButton("Suchen");
		suchenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
			}
		});
		suchenButton.setBounds(283, 11, 107, 23);
		contentPane.add(suchenButton);
		
		suchenTextField = new JTextField();
		suchenTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		suchenTextField.setBounds(400, 12, 156, 20);
		contentPane.add(suchenTextField);
		suchenTextField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(523, 239, -494, -151);
		contentPane.add(scrollPane);
		
		JLabel spielelisteLabel = new JLabel("Ausgeliehende Spiele:");
		spielelisteLabel.setBounds(10, 50, 156, 14);
		contentPane.add(spielelisteLabel);
	}
}
