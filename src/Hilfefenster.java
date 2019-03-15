import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JScrollPane;

public class Hilfefenster extends JFrame {

	private JPanel contentPane;
	private JLabel ueberschriftLabel;
	private JButton ausleihfensterButton;
	private JButton hauptbildschirmButton;
	private JButton kundenverwaltungButton;
	private JButton spieleverwaltungButton;
	private JButton spieledetailfensterButton;
	private JButton zurueckgebenfensterButton;
	private JPanel menuePanel;
	private JPanel spieledetailfensterPanel;
	private JTextArea spieledetailfensterTextArea;
	private JButton spieledetailfensterZurueckButton;
	private JPanel kundenverwaltungPanel;
	private JButton kundenverwaltungZurueckButton;
	private JTextArea kundenverwaltungTextArea;
	private JPanel spieleverwaltungPanel;
	private JTextArea spieleverwaltungTextArea;
	private JButton spieleverwaltungZurueckButton;
	private JButton schliessenButton;
	private JScrollPane spieleverwaltungScrollPane;
	private JScrollPane spieledetailfensterScrollPane;
	private JScrollPane kundenverwaltungScrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hilfefenster frame = new Hilfefenster();
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
	public Hilfefenster() {
		initGUI();
	}
	private void initGUI() {
		setTitle("Hilfefenster");
		setBounds(100, 100, 700, 450);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		{
			{
				this.spieleverwaltungPanel = new JPanel();
				this.spieleverwaltungPanel.setVisible(false);
				this.spieledetailfensterPanel = new JPanel();
				this.spieledetailfensterPanel.setVisible(false);
				{
					this.kundenverwaltungPanel = new JPanel();
					this.kundenverwaltungPanel.setVisible(false);
					this.kundenverwaltungPanel.setBounds(0, 0, 684, 412);
					this.contentPane.add(this.kundenverwaltungPanel);
					this.kundenverwaltungPanel.setLayout(null);
					{
						this.kundenverwaltungZurueckButton = new JButton("Zur\u00FCck");
						this.kundenverwaltungZurueckButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								do_kundenverwaltungZurueckButton_actionPerformed(e);
							}
						});
						{
							this.kundenverwaltungTextArea = new JTextArea();
							this.kundenverwaltungTextArea.setBounds(10, 11, 160, 390);
							this.kundenverwaltungPanel.add(this.kundenverwaltungTextArea);
							this.kundenverwaltungTextArea.setWrapStyleWord(true);
							this.kundenverwaltungTextArea.setLineWrap(true);
							this.kundenverwaltungTextArea.setEditable(false);
							this.kundenverwaltungTextArea.setBackground(SystemColor.menu);
							this.kundenverwaltungTextArea.setText("1: Im Suchfeld kann, per Nachname, nach einen Kunden gesucht werden. "
									+ "Dieser wird in der Tabelle unter dem Suchfeld angezeigt. Bei Klick auf die Zeile des Kunden den man auswählen will"
									+ "werden die Daten des Kunden in die Textfelder geschrieben.\n\n"
									+ "2: Sind alle Felder ausgefüllt kann der Hinzufügen-Button benutzt werden um einen neuen Kunden anzulegen\n\n"
									+ "3: Ist ein Kunde ausgewählt kann man die Daten in den Textfeldern ändern, um mit Klick auf den Ändern-Button werden die Daten geändert.\n\n"
									+ "4: Der Entfernen-Button wird erst nuztbar, wenn alle Textfelder ausgefüllt sind. Dann kann der ausgewewählte Kunde gelöscht werden\n\n"
									+ "5: Der Schließen-Button schließt das aktuelle Fenster.");
						}
						this.kundenverwaltungZurueckButton.setBounds(524, 378, 150, 23);
						this.kundenverwaltungPanel.add(this.kundenverwaltungZurueckButton);
					}
					{
						this.kundenverwaltungScrollPane = new JScrollPane(kundenverwaltungTextArea);
						this.kundenverwaltungScrollPane.setBounds(10, 11, 160, 390);
						this.kundenverwaltungPanel.add(this.kundenverwaltungScrollPane);
					}
				}
				this.spieledetailfensterPanel.setBounds(0, 0, 684, 412);
				this.contentPane.add(this.spieledetailfensterPanel);
				this.spieledetailfensterPanel.setLayout(null);
				{
					this.spieledetailfensterTextArea = new JTextArea();
					this.spieledetailfensterTextArea.setWrapStyleWord(true);
					this.spieledetailfensterTextArea.setBackground(UIManager.getColor("Button.background"));
					this.spieledetailfensterTextArea.setEditable(false);
					this.spieledetailfensterTextArea.setBounds(10, 11, 160, 390);
					this.spieledetailfensterPanel.add(this.spieledetailfensterTextArea);
					this.spieledetailfensterTextArea.setLineWrap(true);
					this.spieledetailfensterTextArea.setText("1: Links sind die Daten des ausgew\u00E4hlten Spieles zu sehen.\r\n\r\n2: Im Feld rechts ist eine kurze Beschreibung des Spieles.\r\n\r\n3: Der Ausleihen-Button f\u00FChrt zum Ausleihfenster, dort kann das ausgew\u00E4hlte Spiel ausgeliehen werden.\r\n\r\n4: Der Zur\u00FCckgeben-Button f\u00FChrt zum Zzur\u00FCckgebenfenster, dort kann man das ausgew\u00E4hlte Spiele wieder zur\u00FCckgeben\r\n\r\n5: Der Schlie\u00DFen-Button schlie\u00DFt das aktuelle Fenster.");
				}
				{
					this.spieledetailfensterZurueckButton = new JButton("Zur\u00FCck");
					this.spieledetailfensterZurueckButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							do_spieledetailfensterZurueckButton_actionPerformed(e);
						}
					});
					this.spieledetailfensterZurueckButton.setBounds(524, 378, 150, 23);
					this.spieledetailfensterPanel.add(this.spieledetailfensterZurueckButton);
				}
				{
					this.spieledetailfensterScrollPane = new JScrollPane(spieledetailfensterTextArea);
					this.spieledetailfensterScrollPane.setBounds(10, 11, 160, 390);
					this.spieledetailfensterPanel.add(this.spieledetailfensterScrollPane);
				}
				this.spieleverwaltungPanel.setBounds(0, 0, 684, 412);
				this.contentPane.add(this.spieleverwaltungPanel);
				this.spieleverwaltungPanel.setLayout(null);
				{
					this.spieleverwaltungZurueckButton = new JButton("Zur\u00FCck");
					this.spieleverwaltungZurueckButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							do_spieleverwaltungZurueckButton_actionPerformed(e);
						}
					});
					{
						this.spieleverwaltungTextArea = new JTextArea();
						this.spieleverwaltungTextArea.setText("1: In dem Suchfeld kann nach einem Spieletitel gesucht werden. Die Ergebnisse werden in der Liste darunter angezeigt.\n\n"
								+ "2: Sind alle Felder ausgefüllt kann der Hinzufügen-Button benutzt werden um einen neuen Kunden anzulegen\n\n"
								+ "3: Ist ein Kunde ausgewählt kann man die Daten in den Textfeldern ändern, um mit Klick auf den Ändern-Button werden die Daten geändert.\n\n"
								+ "4: Der Entfernen-Button wird erst nuztbar, wenn alle Textfelder ausgefüllt sind. Dann kann der ausgewewählte Kunde gelöscht werden\n\n"
								+ "5: Der Schließen-Button schließt das aktuelle Fenster.");
						this.spieleverwaltungTextArea.setWrapStyleWord(true);
						this.spieleverwaltungTextArea.setLineWrap(true);
						this.spieleverwaltungTextArea.setEditable(false);
						this.spieleverwaltungTextArea.setBackground(SystemColor.menu);
						this.spieleverwaltungTextArea.setBounds(10, 11, 160, 390);
						this.spieleverwaltungPanel.add(this.spieleverwaltungTextArea);
					}
					this.spieleverwaltungZurueckButton.setBounds(524, 378, 150, 23);
					this.spieleverwaltungPanel.add(this.spieleverwaltungZurueckButton);
				}
				{
					this.spieleverwaltungScrollPane = new JScrollPane(spieleverwaltungTextArea);
					this.spieleverwaltungScrollPane.setBounds(10, 11, 160, 390);
					this.spieleverwaltungPanel.add(this.spieleverwaltungScrollPane);
				}
				{
					this.menuePanel = new JPanel();
					this.menuePanel.setBounds(0, 0, 684, 412);
					this.contentPane.add(this.menuePanel);
					this.menuePanel.setLayout(null);
					{
						this.ueberschriftLabel = new JLabel("Hier finden Sie Hilfe zu folgenden Fenstern:");
						this.ueberschriftLabel.setBounds(10, 11, 280, 14);
						this.menuePanel.add(this.ueberschriftLabel);
					}
					{
						this.ausleihfensterButton = new JButton("Ausleihfenster");
						this.ausleihfensterButton.setBounds(10, 35, 150, 23);
						this.menuePanel.add(this.ausleihfensterButton);
						{
							this.hauptbildschirmButton = new JButton("Hauptbildschirm");
							this.hauptbildschirmButton.setBounds(10, 75, 150, 23);
							this.menuePanel.add(this.hauptbildschirmButton);
							{
								this.kundenverwaltungButton = new JButton("Kundenverwaltung");
								this.kundenverwaltungButton.setBounds(10, 115, 150, 23);
								this.menuePanel.add(this.kundenverwaltungButton);
								{
									this.spieleverwaltungButton = new JButton("Spieleverwaltung");
									this.spieleverwaltungButton.setBounds(10, 155, 150, 23);
									this.menuePanel.add(this.spieleverwaltungButton);
									{
										this.spieledetailfensterButton = new JButton("Spieledetailfenster");
										this.spieledetailfensterButton.setBounds(10, 195, 150, 23);
										this.menuePanel.add(this.spieledetailfensterButton);
										{
											this.zurueckgebenfensterButton = new JButton("Zur\u00FCckgebenfenster");
											this.zurueckgebenfensterButton.setBounds(10, 235, 150, 23);
											this.menuePanel.add(this.zurueckgebenfensterButton);
											{
												this.schliessenButton = new JButton("Schlie\u00DFen");
												this.schliessenButton.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														do_schliessenButton_actionPerformed(e);
													}
												});
												this.schliessenButton.setBounds(574, 378, 100, 23);
												this.menuePanel.add(this.schliessenButton);
											}
											this.zurueckgebenfensterButton.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													do_zurueckgebenfensterButton_actionPerformed(e);
												}
											});
										}
										this.spieledetailfensterButton.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												do_spieledetailfensterButton_actionPerformed(e);
											}
										});
									}
									this.spieleverwaltungButton.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											do_spieleverwaltungButton_actionPerformed(e);
										}
									});
								}
								this.kundenverwaltungButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										do_kundenverwaltungButton_actionPerformed(e);
									}
								});
							}
							this.hauptbildschirmButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									do_hauptbildschirmButton_actionPerformed(e);
								}
							});
						}
						this.ausleihfensterButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								do_ausleihfensterButton_actionPerformed(e);
							}
						});
					}
				}
			}
		}
	}
	protected void do_spieledetailfensterButton_actionPerformed(ActionEvent e) {
		menuePanel.setVisible(false);
		spieledetailfensterPanel.setVisible(true);
	}
	protected void do_kundenverwaltungButton_actionPerformed(ActionEvent e) {
		menuePanel.setVisible(false);
		kundenverwaltungPanel.setVisible(true);
	}
	protected void do_ausleihfensterButton_actionPerformed(ActionEvent e) {
	}
	protected void do_hauptbildschirmButton_actionPerformed(ActionEvent e) {
	}
	protected void do_zurueckgebenfensterButton_actionPerformed(ActionEvent e) {
	}
	protected void do_spieleverwaltungButton_actionPerformed(ActionEvent e) {
		menuePanel.setVisible(false);
		spieleverwaltungPanel.setVisible(true);
	}
	protected void do_spieledetailfensterZurueckButton_actionPerformed(ActionEvent e) {
		spieledetailfensterPanel.setVisible(false);
		menuePanel.setVisible(true);
	}
	protected void do_kundenverwaltungZurueckButton_actionPerformed(ActionEvent e) {
		kundenverwaltungPanel.setVisible(false);
		menuePanel.setVisible(true);
	}
	protected void do_spieleverwaltungZurueckButton_actionPerformed(ActionEvent e) {
		spieleverwaltungPanel.setVisible(false);
		menuePanel.setVisible(true);
	}
	protected void do_schliessenButton_actionPerformed(ActionEvent e) {
		this.dispose();
	}
}
