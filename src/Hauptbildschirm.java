<<<<<<< HEAD
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
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

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
	private JTextField aktuelleSeiteLinksTextField;
	private JButton seiteZurueckButton;
	private JTextField aktuelleSeiteRechtsTextField;
	private JButton seiteVorwaertsButton;
	private JComboBox genreFilterComboBox;
	private JComboBox uskFilterComboBox;
	private JComboBox preisFilterComboBox;
	private JLabel alphabetischSortierenLabel;
	private JLabel genreFilterLabel;
	private JLabel uskFilterLabel;
	private JLabel preisSortierenLabel;

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
	}
	private void initGUI() {
		setTitle("Hauptbildschirm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 400);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(this.contentPane);
		contentPane.setLayout(null);
		{
			this.buttonMenuePanel = new JPanel();
			buttonMenuePanel.setBounds(0, 0, 759, 50);
			this.buttonMenuePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
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
			linkesMenuePanel.setBounds(0, 49, 225, 312);
			this.linkesMenuePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
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
						do_suchenButton_actionPerformed(e);
					}
				});
				this.suchenButton.setBounds(10, 42, 80, 23);
				this.linkesMenuePanel.add(this.suchenButton);
			}
			{
				this.alphabetischFilterComboBox = new JComboBox();
				this.alphabetischFilterComboBox.setModel(new DefaultComboBoxModel(new String[] {"absteigend", "aufsteigend"}));
				this.alphabetischFilterComboBox.setToolTipText("");
				this.alphabetischFilterComboBox.setBounds(10, 100, 205, 20);
				this.linkesMenuePanel.add(this.alphabetischFilterComboBox);
			}
			{
				this.spielVerfuegbarCheckBox = new JCheckBox("Spiel verf\u00FCgbar");
				this.spielVerfuegbarCheckBox.setBounds(96, 42, 119, 23);
				this.linkesMenuePanel.add(this.spielVerfuegbarCheckBox);
			}
			{
				this.genreFilterComboBox = new JComboBox();
				this.genreFilterComboBox.setModel(new DefaultComboBoxModel(new String[] {"Action", "Action-Adventures", "Adventures", "Textadventures", "Horror", "Shooter", "Erotik", "Geschicklichtkeitsspiele,", "Jump 'n' Runs", "Lernspiele", "Open-World", "Musikspiele", "R\u00E4tselspiele", "RPG", "Simulation", "Sport", "Strategie"}));
				this.genreFilterComboBox.setToolTipText("");
				this.genreFilterComboBox.setBounds(10, 156, 205, 20);
				this.linkesMenuePanel.add(this.genreFilterComboBox);
			}
			{
				this.uskFilterComboBox = new JComboBox();
				this.uskFilterComboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "6", "12", "16", "18"}));
				this.uskFilterComboBox.setToolTipText("");
				this.uskFilterComboBox.setBounds(10, 212, 205, 20);
				this.linkesMenuePanel.add(this.uskFilterComboBox);
			}
			{
				this.preisFilterComboBox = new JComboBox();
				this.preisFilterComboBox.setModel(new DefaultComboBoxModel(new String[] {"teuerste", "billigste"}));
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
			this.aktuelleSeiteLinksTextField = new JTextField();
			aktuelleSeiteLinksTextField.setBounds(235, 330, 55, 20);
			this.aktuelleSeiteLinksTextField.setEditable(false);
			this.aktuelleSeiteLinksTextField.setText("Seite 1");
			this.contentPane.add(this.aktuelleSeiteLinksTextField);
			this.aktuelleSeiteLinksTextField.setColumns(10);
		}
		{
			this.seiteZurueckButton = new JButton("Zur\u00FCck");
			seiteZurueckButton.setBounds(300, 329, 90, 23);
			this.seiteZurueckButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_seiteZurueckButton_actionPerformed(e);
				}
			});
			this.contentPane.add(this.seiteZurueckButton);
		}
		{
			this.aktuelleSeiteRechtsTextField = new JTextField();
			aktuelleSeiteRechtsTextField.setBounds(694, 330, 55, 20);
			this.aktuelleSeiteRechtsTextField.setEditable(false);
			this.aktuelleSeiteRechtsTextField.setText("Seite 1");
			this.contentPane.add(this.aktuelleSeiteRechtsTextField);
			this.aktuelleSeiteRechtsTextField.setColumns(10);
		}
		{
			this.seiteVorwaertsButton = new JButton("Vorw\u00E4rts");
			seiteVorwaertsButton.setBounds(594, 329, 90, 23);
			this.seiteVorwaertsButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_seiteVorwaertsButton_actionPerformed(e);
				}
			});
			this.contentPane.add(this.seiteVorwaertsButton);
		}
	}
	protected void do_hilfeButton_actionPerformed(ActionEvent e) {
	}
	protected void do_suchenButton_actionPerformed(ActionEvent e) {
	}
	protected void do_schliessenButton_actionPerformed(ActionEvent e) {
		System.exit(1);
	}
	protected void do_seiteZurueckButton_actionPerformed(ActionEvent e) {
	}
	protected void do_kundenverwaltungButton_actionPerformed(ActionEvent e) {
	}
	protected void do_topZehnSpieleButton_actionPerformed(ActionEvent e) {
	}
	protected void do_spieleverwaltungButton_actionPerformed(ActionEvent e) {
	}
	protected void do_adminLoginButton_actionPerformed(ActionEvent e) {
	}
	protected void do_seiteVorwaertsButton_actionPerformed(ActionEvent e) {
	}
}
=======
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
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

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
	private JTextField aktuelleSeiteLinksTextField;
	private JButton seiteZurueckButton;
	private JTextField aktuelleSeiteRechtsTextField;
	private JButton seiteVorwaertsButton;
	private JComboBox genreFilterComboBox;
	private JComboBox uskFilterComboBox;
	private JComboBox preisFilterComboBox;
	private JLabel alphabetischSortierenLabel;
	private JLabel genreFilterLabel;
	private JLabel uskFilterLabel;
	private JLabel preisSortierenLabel;

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
			this.linkesMenuePanel.setBounds(0, 49, 225, 312);
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
						do_suchenButton_actionPerformed(e);
					}
				});
				this.suchenButton.setBounds(10, 42, 80, 23);
				this.linkesMenuePanel.add(this.suchenButton);
			}
			{
				this.alphabetischFilterComboBox = new JComboBox();
				this.alphabetischFilterComboBox.setModel(new DefaultComboBoxModel(new String[] {"absteigend", "aufsteigend"}));
				this.alphabetischFilterComboBox.setToolTipText("");
				this.alphabetischFilterComboBox.setBounds(10, 100, 205, 20);
				this.linkesMenuePanel.add(this.alphabetischFilterComboBox);
			}
			{
				this.spielVerfuegbarCheckBox = new JCheckBox("Spiel verf\u00FCgbar");
				this.spielVerfuegbarCheckBox.setBounds(96, 42, 119, 23);
				this.linkesMenuePanel.add(this.spielVerfuegbarCheckBox);
			}
			{
				this.genreFilterComboBox = new JComboBox();
				this.genreFilterComboBox.setModel(new DefaultComboBoxModel(new String[] {"Action", "Action-Adventures", "Adventures", "Textadventures", "Horror", "Shooter", "Erotik", "Geschicklichtkeitsspiele,", "Jump 'n' Runs", "Lernspiele", "Open-World", "Musikspiele", "R\u00E4tselspiele", "RPG", "Simulation", "Sport", "Strategie"}));
				this.genreFilterComboBox.setToolTipText("");
				this.genreFilterComboBox.setBounds(10, 156, 205, 20);
				this.linkesMenuePanel.add(this.genreFilterComboBox);
			}
			{
				this.uskFilterComboBox = new JComboBox();
				this.uskFilterComboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "6", "12", "16", "18"}));
				this.uskFilterComboBox.setToolTipText("");
				this.uskFilterComboBox.setBounds(10, 212, 205, 20);
				this.linkesMenuePanel.add(this.uskFilterComboBox);
			}
			{
				this.preisFilterComboBox = new JComboBox();
				this.preisFilterComboBox.setModel(new DefaultComboBoxModel(new String[] {"teuerste", "billigste"}));
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
			this.aktuelleSeiteLinksTextField = new JTextField();
			this.aktuelleSeiteLinksTextField.setEditable(false);
			this.aktuelleSeiteLinksTextField.setText("Seite 1");
			this.aktuelleSeiteLinksTextField.setBounds(235, 330, 55, 20);
			this.contentPane.add(this.aktuelleSeiteLinksTextField);
			this.aktuelleSeiteLinksTextField.setColumns(10);
		}
		{
			this.seiteZurueckButton = new JButton("Zur\u00FCck");
			this.seiteZurueckButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_seiteZurueckButton_actionPerformed(e);
				}
			});
			this.seiteZurueckButton.setBounds(300, 329, 90, 23);
			this.contentPane.add(this.seiteZurueckButton);
		}
		{
			this.aktuelleSeiteRechtsTextField = new JTextField();
			this.aktuelleSeiteRechtsTextField.setEditable(false);
			this.aktuelleSeiteRechtsTextField.setText("Seite 1");
			this.aktuelleSeiteRechtsTextField.setBounds(694, 330, 55, 20);
			this.contentPane.add(this.aktuelleSeiteRechtsTextField);
			this.aktuelleSeiteRechtsTextField.setColumns(10);
		}
		{
			this.seiteVorwaertsButton = new JButton("Vorw\u00E4rts");
			this.seiteVorwaertsButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_seiteVorwaertsButton_actionPerformed(e);
				}
			});
			this.seiteVorwaertsButton.setBounds(594, 329, 90, 23);
			this.contentPane.add(this.seiteVorwaertsButton);
		}
	}
	protected void do_hilfeButton_actionPerformed(ActionEvent e) {
	}
	protected void do_suchenButton_actionPerformed(ActionEvent e) {
	}
	protected void do_schliessenButton_actionPerformed(ActionEvent e) {
		System.exit(1);
	}
	protected void do_seiteZurueckButton_actionPerformed(ActionEvent e) {
	}
	protected void do_kundenverwaltungButton_actionPerformed(ActionEvent e) {
	}
	protected void do_topZehnSpieleButton_actionPerformed(ActionEvent e) {
	}
	protected void do_spieleverwaltungButton_actionPerformed(ActionEvent e) {
	}
	protected void do_adminLoginButton_actionPerformed(ActionEvent e) {
	}
	protected void do_seiteVorwaertsButton_actionPerformed(ActionEvent e) {
	}
}
>>>>>>> 210b9c96296de825c737a89edf86a3c4b0a4d511
