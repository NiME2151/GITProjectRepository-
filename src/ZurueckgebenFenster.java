

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextField;

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

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ZurueckgebenFenster extends JFrame {

	private JPanel contentPane;
	private JTextField suchenTextField;
	private JTable ausgabeTabelle;
	KundenSpiele kundenSpiele = new KundenSpiele();
	KundenSpieleDAO kundenSpieleDAO = new KundenSpieleDAO();
	ZurueckgebenFensterDAO zurueckDao = new ZurueckgebenFensterDAO();
	GetWertInZeile getWertInZeile = new GetWertInZeile();
	/**
	 * Launch the application.
	 */
	//

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
		
		JScrollPane spielelisteScrollPane = new JScrollPane();
		spielelisteScrollPane.setToolTipText("Hier werden die Daten des Kunden und die zum Ausleih-Prozess angezeigt die gesucht werden");
		spielelisteScrollPane.setBounds(0, 0, 546, 176);
		panel.add(spielelisteScrollPane);
		
		ausgabeTabelle = new JTable();
		this.ausgabeTabelle.removeEditor();
		this.ausgabeTabelle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_ausgabeTabelle_mouseClicked(e);
			}
		});
		ausgabeTabelle.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"SpieleID","KundenID", "Ausleihpreis", "Ausleihmenge", "Faelligkeitsdatum", "Ausleihdatum"
			}
		));
		spielelisteScrollPane.setViewportView(ausgabeTabelle);
		
		JButton zurueckgebenButton = new JButton("Zur\u00FCckgeben");
		zurueckgebenButton.setToolTipText("Bei Klick wird der Zur\u00FCckgeben-Prozess beendet");
		zurueckgebenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					try {
						do_ZurueckgebenButton_actionPerformed(e);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		zurueckgebenButton.setBounds(10, 11, 122, 23);
		contentPane.add(zurueckgebenButton);
		
		JButton suchenButton = new JButton("Suchen");
		suchenButton.setToolTipText("Bei Klick auf den Button wird nach einem Kunden gesucht");
		suchenButton.addActionListener(new ActionListener() {
				public void actionPerformed (ActionEvent e) {
					try {
						do_SuchenButton_actionPerformed(e);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		});
		suchenButton.setBounds(283, 11, 107, 23);
		contentPane.add(suchenButton);
		
		suchenTextField = new JTextField();
		this.suchenTextField.setToolTipText("Hier kann ein Kundennachname eingegeben werden");
		suchenTextField.setBounds(400, 12, 156, 20);
		contentPane.add(suchenTextField);
		suchenTextField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(523, 239, -494, -151);
		contentPane.add(scrollPane);
		
		JLabel kundenlisteLabel = new JLabel("Kunden:");
		kundenlisteLabel.setBounds(10, 50, 156, 14);
		contentPane.add(kundenlisteLabel);
	}

	protected void do_SuchenButton_actionPerformed(ActionEvent arg0) throws ClassNotFoundException, SQLException {
		ResultSet rs = zurueckDao.searchForKundenspiele(suchenTextField.getText());
		this.ausgabeTabelle.setModel(DbUtils.resultSetToTableModel(rs));
	}
	
	protected void do_ZurueckgebenButton_actionPerformed(ActionEvent arg0) throws ClassNotFoundException, SQLException {
		String spieleID = getWertInZeile.getWertInZeileVariabel(ausgabeTabelle, 0);
		String kundenID = getWertInZeile.getWertInZeileVariabel(ausgabeTabelle, 1);
		String ausleihmenge = getWertInZeile.getWertInZeileVariabel(ausgabeTabelle, 3);
		String faelligkeitsdatum = getWertInZeile.getWertInZeileVariabel(ausgabeTabelle, 4);
		String ausleihdatum = getWertInZeile.getWertInZeileVariabel(ausgabeTabelle, 5);
		zurueckDao.decreaseCounter(spieleID, ausleihmenge);
		
		//KundenSpiele ks = kundenSpieleDAO.selectKundenSpiele(ausgabeTabelle);
		zurueckDao.zurueckgeben(spieleID, kundenID, faelligkeitsdatum, ausleihdatum);
	}
	protected void do_ausgabeTabelle_mouseClicked(MouseEvent e) {
		String kundenID = getWertInZeile.getWertInZeileVariabel(ausgabeTabelle, 1);
	}
}