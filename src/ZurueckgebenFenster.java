

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ZurueckgebenFenster extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable kundenspieleTable;
	private JFrame that=this;
	private JButton btnNewButton;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZurueckgebenFenster frame = new ZurueckgebenFenster();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ZurueckgebenFenster() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 89, 414, 162);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane ausleihScrollPane = new JScrollPane();
		ausleihScrollPane.setBounds(411, 163, -410, -163);
		panel.add(ausleihScrollPane);
		
		kundenspieleTable = new JTable();
		kundenspieleTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Spiel", "KdnName", "FSK", "Releasedatum", "Ausleihdatum" 
			}
		));
		kundenspieleTable.setBounds(411, 145, -410, -141);
		panel.add(kundenspieleTable);
		
		textField = new JTextField();
		textField.setBounds(338, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton suchenButton = new JButton("Suchen");
		suchenButton.setBounds(239, 10, 89, 23);
		contentPane.add(suchenButton);
		
		btnNewButton = new JButton("Kundenverwaltung");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kundenverwaltung kunde = new Kundenverwaltung();
				that.setVisible(true);

			}
		});
		btnNewButton.setBounds(10, 10, 130, 23);
		contentPane.add(btnNewButton);
	}
}
