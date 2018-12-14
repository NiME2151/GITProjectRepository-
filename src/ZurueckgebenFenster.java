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

public class ZurueckgebenFenster extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField suchenTextField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ZurueckgebenFenster() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 54, 546, 197);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"blablacar", "FSK", "Datum", "Spiel"
			}
		));
		table.setBounds(-265, 0, 535, 191);
		panel_1.add(table);
		
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setBounds(0, 0, 284, 250);
		panel_1.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		JButton zurueckgebenButton = new JButton("Zur\u00FCckgeben");
		zurueckgebenButton.setBounds(10, 11, 107, 23);
		contentPane.add(zurueckgebenButton);
		
		JButton suchenButton = new JButton("Suchen");
		suchenButton.setBounds(283, 11, 107, 23);
		contentPane.add(suchenButton);
		
		suchenTextField = new JTextField();
		suchenTextField.setBounds(400, 12, 156, 20);
		contentPane.add(suchenTextField);
		suchenTextField.setColumns(10);
	}
}
