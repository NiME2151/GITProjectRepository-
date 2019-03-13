import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//
public class Hauptbildschirm extends JFrame {

	private JPanel contentPane;
	private JPanel buttonMenuePanel;
	private JPanel linkesMenuePanel;
	private JButton adminLoginButton;
	private JButton kundenverwaltungButton;
	private JButton spieleverwaltungButton;
	private JButton topZehnSpieleButton;
	private JButton hilfeButton;
	private JButton schliessenButton;
	private JTextField suchfeldTextField;
	private JButton suchenButton;
	private JComboBox alphabetischFilterComboBox;
	private JCheckBox spielVerfuegbarCheckBox;
	private JComboBox genreFilterComboBox;
	private JComboBox uskFilterComboBox;
	private JComboBox preisFilterComboBox;
	private JLabel alphabetischSortierenLabel;
	private JLabel genreFilterLabel;
	private JLabel uskFilterLabel;
	private JLabel preisSortierenLabel;
	private JPanel spielelistePanel;
	private JTable spielelisteTable;
	private JScrollPane spielelisteScrollPane;
	private KundenDAO kundenDAO;
	private SpielDAO spielDAO;
	
	HauptbildschirmDAO hauptDAO = new HauptbildschirmDAO();
	GetWertInZeile spielAuswaehlen = new GetWertInZeile();
	Spiel spiel = new Spiel();
	private JPanel adminLoginPane;
	private JLabel idLabel;
	private JLabel passwortLabel;
	private JTextField idTextField;
	private JTextField passwortTextField;
	private JButton loginButton;
	private String adminId = "1";
	private String adminPasswort = "1";
	
	private JFrame that=this;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hauptbildschirm frame = new Hauptbildschirm();
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
	public Hauptbildschirm() {
		initGUI();
		hauptDAO = new HauptbildschirmDAO();
		this.confirmOnClose();
	}
	
	
	private void initGUI() {
		setTitle("Hauptbildschirm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 400);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		{
			this.spielelistePanel = new JPanel();
			this.spielelistePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
			this.spielelistePanel.setBounds(224, 49, 535, 313);
			this.contentPane.add(this.spielelistePanel);
			this.spielelistePanel.setLayout(null);
			{
				this.spielelisteTable = new JTable();
				this.spielelisteTable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						try {
							do_spielelisteTable_mouseClicked(arg0);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				this.spielelisteTable.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"ID", "Titel", "Genre", "USK", "Release", "Preis (Euro)", "Verfuegbar"
					}
				));
				this.spielelisteTable.setBounds(10, 11, 515, 248);
				this.spielelistePanel.add(this.spielelisteTable);
			}
			{
				this.spielelisteScrollPane = new JScrollPane(spielelisteTable);
				this.spielelisteScrollPane.setBounds(0, 0, 535, 313);
				this.spielelistePanel.add(this.spielelisteScrollPane);
			}
		}
		{
			this.buttonMenuePanel = new JPanel();
			this.buttonMenuePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
			this.buttonMenuePanel.setBounds(0, 0, 759, 50);
			this.contentPane.add(this.buttonMenuePanel);
			this.buttonMenuePanel.setLayout(null);
			{
				this.adminLoginButton = new JButton("Admin-Login");
				this.adminLoginButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_adminLoginButton_actionPerformed(e);
					}
				});
				this.adminLoginButton.setBounds(10, 10, 110, 28);
				this.buttonMenuePanel.add(this.adminLoginButton);
			}
			{
				this.kundenverwaltungButton = new JButton("Kundenverwaltung");
				this.kundenverwaltungButton.setEnabled(false);
				this.kundenverwaltungButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_kundenverwaltungButton_actionPerformed(e);
					}
				});
				this.kundenverwaltungButton.setBounds(130, 10, 145, 28);
				this.buttonMenuePanel.add(this.kundenverwaltungButton);
			}
			{
				this.spieleverwaltungButton = new JButton("Spieleverwaltung");
				this.spieleverwaltungButton.setEnabled(false);
				this.spieleverwaltungButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_spieleverwaltungButton_actionPerformed(e);
					}
				});
				this.spieleverwaltungButton.setBounds(285, 10, 145, 29);
				this.buttonMenuePanel.add(this.spieleverwaltungButton);
			}
			{
				this.topZehnSpieleButton = new JButton("Top-10-Spiele");
				this.topZehnSpieleButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_topZehnSpieleButton_actionPerformed(e);
					}
				});
				this.topZehnSpieleButton.setBounds(440, 10, 125, 28);
				this.buttonMenuePanel.add(this.topZehnSpieleButton);
			}
			{
				this.hilfeButton = new JButton("Hilfe");
				this.hilfeButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_hilfeButton_actionPerformed(e);
					}
				});
				this.hilfeButton.setBounds(594, 10, 60, 28);
				this.buttonMenuePanel.add(this.hilfeButton);
			}
			{
				this.schliessenButton = new JButton("Beenden");
				this.schliessenButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_schliessenButton_actionPerformed(e);
					}
				});
				this.schliessenButton.setBounds(664, 10, 85, 28);
				this.buttonMenuePanel.add(this.schliessenButton);
			}
		}
		{
			this.linkesMenuePanel = new JPanel();
			this.linkesMenuePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
			this.linkesMenuePanel.setBounds(0, 49, 225, 313);
			this.contentPane.add(this.linkesMenuePanel);
			this.linkesMenuePanel.setLayout(null);
			{
				this.suchfeldTextField = new JTextField();
				this.suchfeldTextField.setBounds(10, 11, 205, 20);
				this.linkesMenuePanel.add(this.suchfeldTextField);
				this.suchfeldTextField.setColumns(10);
			}
			{
				this.suchenButton = new JButton("Suchen");
				this.suchenButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							do_suchenButton_actionPerformed(e);
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				this.suchenButton.setBounds(10, 42, 80, 23);
				this.linkesMenuePanel.add(this.suchenButton);
			}
			{
				this.alphabetischFilterComboBox = new JComboBox();
				this.alphabetischFilterComboBox.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						try {
							do_alphabetischFilterComboBox_itemStateChanged(arg0);
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				this.alphabetischFilterComboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							do_alphabetischFilterComboBox_actionPerformed(arg0);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				this.alphabetischFilterComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "absteigend", "aufsteigend"}));
				this.alphabetischFilterComboBox.setToolTipText("");
				this.alphabetischFilterComboBox.setBounds(10, 100, 205, 20);
				this.linkesMenuePanel.add(this.alphabetischFilterComboBox);
			}
			{
				this.spielVerfuegbarCheckBox = new JCheckBox("Spiel verf\u00FCgbar");
				this.spielVerfuegbarCheckBox.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						try {
							do_spielVerfuegbarCheckBox_itemStateChanged(arg0);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				this.spielVerfuegbarCheckBox.setBounds(96, 42, 119, 23);
				this.linkesMenuePanel.add(this.spielVerfuegbarCheckBox);
			}
			{
				this.genreFilterComboBox = new JComboBox();
				this.genreFilterComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Action", "Action-Adventures", "Adventures", "Textadventures", "Horror", "Shooter", "Erotik", "Geschicklichtkeitsspiele,", "Jump 'n' Runs", "Lernspiele", "Open-World", "Musikspiele", "R\u00E4tselspiele", "RPG", "Simulation", "Sport", "Strategie"}));
				this.genreFilterComboBox.setToolTipText("");
				this.genreFilterComboBox.setBounds(10, 156, 205, 20);
				this.linkesMenuePanel.add(this.genreFilterComboBox);
			}
			{
				this.uskFilterComboBox = new JComboBox();
				this.uskFilterComboBox.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						do_uskFilterComboBox_itemStateChanged(e);
					}
				});
				this.uskFilterComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Von USK 0 bis USK 18", "Von USK 18 bis USK 0", "Nur USK 0", "Nur USK 6", "Nur USK 12", "Nur USK 16", "Nur USK 18"}));
				this.uskFilterComboBox.setToolTipText("");
				this.uskFilterComboBox.setBounds(10, 212, 205, 20);
				this.linkesMenuePanel.add(this.uskFilterComboBox);
			}
			{
				this.preisFilterComboBox = new JComboBox();
				this.preisFilterComboBox.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						do_preisFilterComboBox_itemStateChanged(arg0);
					}
				});
				this.preisFilterComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "teuerste", "billigste"}));
				this.preisFilterComboBox.setToolTipText("");
				this.preisFilterComboBox.setBounds(10, 268, 205, 20);
				this.linkesMenuePanel.add(this.preisFilterComboBox);
			}
			{
				this.alphabetischSortierenLabel = new JLabel("Nach Titel sortieren:");
				this.alphabetischSortierenLabel.setBounds(10, 76, 205, 14);
				this.linkesMenuePanel.add(this.alphabetischSortierenLabel);
			}
			{
				this.genreFilterLabel = new JLabel("Nach Genre filtern:");
				this.genreFilterLabel.setBounds(10, 131, 205, 14);
				this.linkesMenuePanel.add(this.genreFilterLabel);
			}
			{
				this.uskFilterLabel = new JLabel("Nach USK-Freigabe filtern:");
				this.uskFilterLabel.setBounds(10, 187, 205, 14);
				this.linkesMenuePanel.add(this.uskFilterLabel);
			}
			{
				this.preisSortierenLabel = new JLabel("Nach Preis sortieren:");
				this.preisSortierenLabel.setBounds(10, 243, 205, 14);
				this.linkesMenuePanel.add(this.preisSortierenLabel);
			}
		}
		{
			this.adminLoginPane = new JPanel();
			this.adminLoginPane.setVisible(false);
			this.adminLoginPane.setBounds(0, 0, 759, 362);
			this.contentPane.add(this.adminLoginPane);
			this.adminLoginPane.setLayout(null);
			{
				this.idLabel = new JLabel("ID:");
				this.idLabel.setBounds(10, 11, 80, 14);
				this.adminLoginPane.add(this.idLabel);
			}
			{
				this.passwortLabel = new JLabel("Passwort:");
				this.passwortLabel.setBounds(10, 36, 80, 14);
				this.adminLoginPane.add(this.passwortLabel);
			}
			{
				this.idTextField = new JTextField();
				this.idTextField.setBounds(100, 8, 86, 20);
				this.adminLoginPane.add(this.idTextField);
				this.idTextField.setColumns(10);
			}
			{
				this.passwortTextField = new JTextField();
				this.passwortTextField.setBounds(100, 33, 86, 20);
				this.adminLoginPane.add(this.passwortTextField);
				this.passwortTextField.setColumns(10);
			}
			{
				this.loginButton = new JButton("Einloggen");
				this.loginButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_loginButton_actionPerformed(e);
					}
				});
				this.loginButton.setBounds(97, 64, 89, 23);
				this.adminLoginPane.add(this.loginButton);
			}
		}
	}
	
	
	
		protected void do_hilfeButton_actionPerformed(ActionEvent e) {
		}
		protected void do_suchenButton_actionPerformed(ActionEvent e) throws ClassNotFoundException {
			String gesuchtesSpiel = String.valueOf(suchfeldTextField.getText());
			if (!gesuchtesSpiel.equalsIgnoreCase("")) {
				ResultSet rs = hauptDAO.sucheNachSpiel(gesuchtesSpiel);
				System.out.println(rs);
				this.spielelisteTable.setModel(DbUtils.resultSetToTableModel(rs));
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if (gesuchtesSpiel.equalsIgnoreCase("")) {
				ResultSet rs = hauptDAO.sucheNachSpiel(gesuchtesSpiel);
				System.out.println(rs);
				this.spielelisteTable.setModel(DbUtils.resultSetToTableModel(rs));
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
}
		protected void do_schliessenButton_actionPerformed(ActionEvent e) {
			System.exit(1);
		}
		protected void do_kundenverwaltungButton_actionPerformed(ActionEvent e) {
			Kundenverwaltung kunde = new Kundenverwaltung();
			kunde.setVisible(true);
		}
		protected void do_topZehnSpieleButton_actionPerformed(ActionEvent e) {
		}
		protected void do_spieleverwaltungButton_actionPerformed(ActionEvent e) {
			Spieleverwaltung spiel = new Spieleverwaltung();
			spiel.setVisible(true);
		}
		protected void do_adminLoginButton_actionPerformed(ActionEvent e) {
			spielelistePanel.setVisible(false);
			linkesMenuePanel.setVisible(false);
			buttonMenuePanel.setVisible(false);
			adminLoginPane.setVisible(true);
			this.setSize(200, 125);
			this.setResizable(false);
		}
		protected void do_alphabetischFilterComboBox_actionPerformed(ActionEvent e) throws ClassNotFoundException {
			
		}
		
		
		
	protected void do_alphabetischFilterComboBox_itemStateChanged(ItemEvent arg0) throws ClassNotFoundException, SQLException {
		String alphabetischFilterWert = String.valueOf(alphabetischFilterComboBox.getSelectedItem());
		if (alphabetischFilterWert != null) {
			ResultSet rs = hauptDAO.orderBy(alphabetischFilterWert);
			this.spielelisteTable.setModel(DbUtils.resultSetToTableModel(rs));
		}
	}
	
	protected void do_spielelisteTable_mouseClicked(MouseEvent arg0) throws ClassNotFoundException, SQLException {
		String ausgewaehltesSpiel = spielAuswaehlen.getWertInZeile(spielelisteTable);
		Spieledetailfenster fenster = new Spieledetailfenster(ausgewaehltesSpiel);
		fenster.setVisible(true);
	}
	
	protected void do_spielVerfuegbarCheckBox_itemStateChanged(ItemEvent arg0) throws ClassNotFoundException {
		if (this.spielVerfuegbarCheckBox.isSelected()) {
			boolean spielVerfuegbarkeit = this.spielVerfuegbarCheckBox.isSelected();
			ResultSet rs = hauptDAO.sucheVerfuegbareSpiele(spielVerfuegbarkeit);
			this.spielelisteTable.setModel(DbUtils.resultSetToTableModel(rs));
		}
		else if (!this.spielVerfuegbarCheckBox.isSelected()) {
			do_suchenButton_actionPerformed(null);
		}
	}
	
	protected void do_preisFilterComboBox_itemStateChanged(ItemEvent arg0) {
		String sortierEingabe = String.valueOf(this.preisFilterComboBox.getSelectedItem());
		if (sortierEingabe != null) {
			ResultSet rs = hauptDAO.sortiereNachPreis(sortierEingabe);
			this.spielelisteTable.setModel(DbUtils.resultSetToTableModel(rs));
		}
	}
	
	protected void do_uskFilterComboBox_itemStateChanged(ItemEvent e) {
		String sortierEingabe = String.valueOf(this.uskFilterComboBox.getSelectedItem());
		this.genreFilterComboBox.setSelectedItem("");
		genreFilterComboBox.setSelectedItem("");
		if (sortierEingabe != null) {
			ResultSet rs = hauptDAO.sortiereNachUSK(sortierEingabe);
			this.spielelisteTable.setModel(DbUtils.resultSetToTableModel(rs));

			}
		}
	
	protected void do_genreFilterComboBox_itemStateChanged(ItemEvent e) {
		String sortierEingabe = String.valueOf(this.genreFilterComboBox.getSelectedItem());
		if (sortierEingabe != null) {
			ResultSet rs = hauptDAO.sortiereNachGenre(sortierEingabe);
			this.spielelisteTable.setModel(DbUtils.resultSetToTableModel(rs));
			genreFilterComboBox.setSelectedItem("");
			preisFilterComboBox.setSelectedItem("");
		}
		genreFilterComboBox.setSelectedItem("");
		preisFilterComboBox.setSelectedItem("");
		}	
	
	
	protected void confirmOnClose() {

		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			
				if (idTextField.getText().length() > 0

						|| genreFilterComboBox.getItemAt(0).toString().length() > 0
						|| genreFilterComboBox.getSelectedItem().toString().length() > 0
						|| uskFilterComboBox.getItemAt(0).toString().length() > 0
						|| uskFilterComboBox.getSelectedItem().toString().length() > 0) {
					if (JOptionPane.showConfirmDialog(that, 
							"Are you sure you want to close this window?", "Close Window?", 
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
						dispose();
					}
				} else {
					dispose();
				}
			}
		});
	} 	
	
	public void checkAdminLoggedIn() {
		if (idTextField.getText().equalsIgnoreCase(adminId) && passwortTextField.getText().equalsIgnoreCase(adminPasswort)) {
			adminLoginPane.setVisible(false);
			spielelistePanel.setVisible(true);
			buttonMenuePanel.setVisible(true);
			linkesMenuePanel.setVisible(true);
			initGUI();
			kundenverwaltungButton.setEnabled(true);
			spieleverwaltungButton.setEnabled(true);
		}
		else if (!idTextField.getText().equalsIgnoreCase(adminId) || !passwortTextField.getText().equalsIgnoreCase(adminPasswort)) {
			JOptionPane alert = new JOptionPane();
			alert.showMessageDialog(this, "Die von Ihnen eingegebenen Daten sind nicht korrekt", "Login fehlgeschlagen", JOptionPane.ERROR_MESSAGE);
		}
		else {
			System.out.println("False oder Error");
		}
	}
	protected void do_loginButton_actionPerformed(ActionEvent e) {
		 checkAdminLoggedIn();
	}

}
