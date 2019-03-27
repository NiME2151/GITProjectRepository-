import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Component;

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
	private JLabel kundenverwaltungImageLabel;
	private JLabel spieledetailfensterImageLabel;
	private JLabel spieleverwaltungImageLabel;
	private JPanel ausleihfensterPanel;
	private JButton ausleihfensterZurueckButton;
	private JLabel ausleihfensterImageLabel;
	private JScrollPane ausleihfensterScrollPane;
	private JTextArea ausleihfensterTextArea;
	private JPanel hauptbildschirmPanel;
	private JButton hauptbildschirmZurueckButton;
	private JLabel hauptbildschirmImageLabel;
	private JScrollPane hauptbildschirmScrollPane;
	private JTextArea hauptbildschirmTextArea;
	
	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Hilfefenster() throws IOException {
		initGUI();
	}
	private void initGUI() throws IOException {
		setTitle("Hilfefenster");
		setBounds(100, 100, 700, 450);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		{
			{
				{
					this.kundenverwaltungPanel = new JPanel();
					this.kundenverwaltungPanel.setVisible(false);
					this.spieledetailfensterPanel = new JPanel();
					this.spieledetailfensterPanel.setVisible(false);
					this.spieleverwaltungPanel = new JPanel();
					this.spieleverwaltungPanel.setVisible(false);
					this.menuePanel = new JPanel();
					this.menuePanel.setBounds(0, 0, 684, 412);
					this.contentPane.add(this.menuePanel);
					this.menuePanel.setLayout(null);
					{
						this.ueberschriftLabel = new JLabel("Hier finden Sie Hilfe zu folgenden Fenstern:");
						this.ueberschriftLabel.setBounds(10, 11, 280, 14);
						this.menuePanel.add(this.ueberschriftLabel);
					}
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
					this.hauptbildschirmPanel = new JPanel();
					this.hauptbildschirmPanel.setVisible(false);
					this.hauptbildschirmPanel.setBounds(0, 0, 684, 412);
					this.contentPane.add(this.hauptbildschirmPanel);
					this.hauptbildschirmPanel.setLayout(null);
					{
						this.hauptbildschirmZurueckButton = new JButton("Zur\u00FCck");
						this.hauptbildschirmZurueckButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								do_hauptbildschirmZurueckButton_actionPerformed(arg0);
							}
						});
						this.hauptbildschirmZurueckButton.setBounds(524, 378, 150, 23);
						this.hauptbildschirmPanel.add(this.hauptbildschirmZurueckButton);
					}
					this.hauptbildschirmImageLabel = new JLabel();
					this.hauptbildschirmImageLabel.setBounds(180, 11, 494, 356);
					this.hauptbildschirmPanel.add(this.hauptbildschirmImageLabel);
					ImageIcon imgIconhauptbildschirm = new ImageIcon(getClass().getResource("/images/hauptbildschirm.PNG"));
					Image imgHauptbildschirm = imgIconhauptbildschirm.getImage().getScaledInstance(hauptbildschirmImageLabel.getWidth(), hauptbildschirmImageLabel.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon resizedImageIconHauptbildschirm = new ImageIcon(imgHauptbildschirm);
					this.hauptbildschirmImageLabel.setIcon(resizedImageIconHauptbildschirm);
					{
						this.hauptbildschirmScrollPane = new JScrollPane();
						this.hauptbildschirmScrollPane.setBounds(10, 11, 160, 390);
						this.hauptbildschirmPanel.add(this.hauptbildschirmScrollPane);
						{
							this.hauptbildschirmTextArea = new JTextArea();
							this.hauptbildschirmScrollPane.setViewportView(this.hauptbildschirmTextArea);
							this.hauptbildschirmTextArea.setWrapStyleWord(true);
							this.hauptbildschirmTextArea.setText("1: Mit dem Admin-Login-Button kann sich der Besitzer anmelden. Damit schaltet er die beiden ausgegrauten Buttons frei"
									+ "Diese führen zur Spiele- und Kundenverwaltung, also dort hin wo Spiele bzw. Kunden angelegt, geändert oder entfernt werden können. "
									+ "Die Daten zum Einloggen werden in einer Text-Datei dem Besitzer hinterlegt.\n\n"
									+ "2: Mit diesem Button kann angezeigt werden was die zehn am meisten augeliehenden Spiele sind.\n\n"
									+ "3: Der Hilfe-Button führt sie hierher. zum Hilfefenster.\n\n"
									+ "4: Mit diesem Button schließen Sie die Anwendung.\n\n"
									+ "5: Mit dem Suchfeld kann nach Spielen gesucht werden. Diese werden in der Tabelle unten rechts angezeigt."
									+ "Klickt man auf die Zeile eines Spiels bekommt man ein Fenster mit allen Daten zum Spiel zu Gesicht. "
									+ "Dort kann auch das angeklickte Spiel ausgeliehen oder zurückgegeben werden."
									+ "Wird der Suchen-Button genutzt ohne etwas einzugeben so werden alle Spiele angezeigt.\n\n"
									+ "6: Wird der Hacken hier gesetzt werden nur die Spiele angezeigt, welche noch verfügbar sind. Heißt die, die noch mindestens einmal im Laden vorhanden sind.\n\n"
									+ "7: Mit diesen Comboboxen können Spiele gefilter/sortiert werden. Es kann immer nur ein Filter auf einmal angewendet werden."
									+ "Bei Titel sortieren werden die Spiele alphabetisch von A-Z oder Z-A sortiert. Beim Genre-Filter werden nur Spiele des ausgewählten Genres angezeigt."
									+ "Beim Filter nach der USK kann von der geringsten USK zur höchsten oder auch anders herum gefiltert werden. Es können auch nur Spiele einer USK-Stufe angezeigt werden."
									+ "Beim sortieren nach Preis werden alle Spiele angezeigt sortiert nach dem teuersten vom Ausleihpreis her oder nach dem billigestem.");
							this.hauptbildschirmTextArea.setLineWrap(true);
							this.hauptbildschirmTextArea.setEditable(false);
							this.hauptbildschirmTextArea.setBackground(SystemColor.menu);
						}
					}
					{
						this.ausleihfensterPanel = new JPanel();
						this.ausleihfensterPanel.setVisible(false);
						this.ausleihfensterPanel.setBounds(0, 0, 684, 412);
						this.contentPane.add(this.ausleihfensterPanel);
						this.ausleihfensterPanel.setLayout(null);
						{
							this.ausleihfensterZurueckButton = new JButton("Zur\u00FCck");
							this.ausleihfensterZurueckButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									do_ausleihfensterZurueckButton_actionPerformed(arg0);
								}
							});
							this.ausleihfensterZurueckButton.setBounds(524, 378, 150, 23);
							this.ausleihfensterPanel.add(this.ausleihfensterZurueckButton);
						}
						{
							this.ausleihfensterImageLabel = new JLabel();
							this.ausleihfensterImageLabel.setBounds(180, 11, 494, 356);
							this.ausleihfensterPanel.add(this.ausleihfensterImageLabel);
							ImageIcon imgIconAusleihfenster = new ImageIcon(getClass().getResource("/images/ausleihfenster.PNG"));
							Image imgAusleihfenster = imgIconAusleihfenster.getImage().getScaledInstance(ausleihfensterImageLabel.getWidth(), ausleihfensterImageLabel.getHeight(), Image.SCALE_SMOOTH);
							ImageIcon resizedImageIconAusleihfenster = new ImageIcon(imgAusleihfenster);
							this.ausleihfensterImageLabel.setIcon(resizedImageIconAusleihfenster);
						}
						{
							this.ausleihfensterScrollPane = new JScrollPane();
							this.ausleihfensterScrollPane.setBounds(10, 11, 160, 390);
							this.ausleihfensterPanel.add(this.ausleihfensterScrollPane);
							{
								this.ausleihfensterTextArea = new JTextArea();
								this.ausleihfensterScrollPane.setViewportView(this.ausleihfensterTextArea);
								this.ausleihfensterTextArea.setWrapStyleWord(true);
								this.ausleihfensterTextArea.setText("1: Im Suchfeld kann, per Nachname, nach einem Kunden gesucht werden. "
										+ "Dieser wird in der Tabelle unten links angezeigt. Dieser muss dann per Klick auf die Zeile in der Tabelle ausgewählt werden damit klar ist wer das Spiel ausleiht.\n\n"
										+ "2: Ist der Kunde noch nicht im System beim Ausleihprozess, dann kann der Kunden anlegen-Button genutzt werden um zur Kundenverwaltung zu gelangen.\n\n"
										+ "3: Wurde der Kunde ausgewählt so kann nun angegeben werden wie lang der Kunde das Spiel ausleiehen möchte. Außerdem muss noch angeben werden wie oft er das Spiel ausleihen möchte.\n\n"
										+ "4: Der Preis berechnen-Button wird erst dann sichtbar wenn korrekte eingaben in den beiden vorherigen Feldern eingeben wurden. "
										+ "Dann kann jener genutzt werden um zu berechnen wie viel es kostet das Spiel auszuleihen.\n\n"
										+ "5: Der Ausleih-Button beendet den Prozess und ist erst dann nutzbar wenn alle vorherigen Schritte korrekt ausgeführt wurden. Dann kann der Button genutzt werden um das Spiel auszuleihen.");
								this.ausleihfensterTextArea.setLineWrap(true);
								this.ausleihfensterTextArea.setEditable(false);
								this.ausleihfensterTextArea.setBackground(SystemColor.menu);
							}
						}
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
									+ "2: Sind alle Felder ausgefï¿½llt kann der Hinzufï¿½gen-Button benutzt werden um einen neuen Kunden anzulegen\n\n"
									+ "3: Ist ein Kunde ausgewï¿½hlt kann man die Daten in den Textfeldern ï¿½ndern, um mit Klick auf den ï¿½ndern-Button werden die Daten geï¿½ndert.\n\n"
									+ "4: Der Entfernen-Button wird erst nuztbar, wenn alle Textfelder ausgefï¿½llt sind. Dann kann der ausgewewï¿½hlte Kunde gelï¿½scht werden\n\n"
									+ "5: Der Schlieï¿½en-Button schlieï¿½t das aktuelle Fenster.");
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
					this.spieleverwaltungImageLabel = new JLabel();
					this.spieleverwaltungImageLabel.setBounds(180, 11, 494, 356);
					this.spieleverwaltungPanel.add(this.spieleverwaltungImageLabel);
					{
						this.spieleverwaltungScrollPane = new JScrollPane(spieleverwaltungTextArea);
						this.spieleverwaltungScrollPane.setBounds(10, 11, 160, 390);
						this.spieleverwaltungPanel.add(this.spieleverwaltungScrollPane);
					}
					{
						ImageIcon imgIconspieleverwaltung = new ImageIcon(getClass().getResource("/images/spieleverwaltung.PNG"));
						Image imgSpieleverwaltung = imgIconspieleverwaltung.getImage().getScaledInstance(spieleverwaltungImageLabel.getWidth(), spieleverwaltungImageLabel.getHeight(), Image.SCALE_SMOOTH);
						ImageIcon resizedImageIconspieleverwaltung = new ImageIcon(imgSpieleverwaltung);
						this.spieleverwaltungImageLabel.setIcon(resizedImageIconspieleverwaltung);
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
						this.spieledetailfensterImageLabel = new JLabel();
						this.spieledetailfensterImageLabel.setBounds(180, 11, 494, 356);
						this.spieledetailfensterPanel.add(this.spieledetailfensterImageLabel);
						ImageIcon imgIconspieledetailfenster = new ImageIcon(getClass().getResource("/images/spieledetailfenster.PNG"));
					    Image imgSpieledetailfenster = imgIconspieledetailfenster.getImage().getScaledInstance(spieledetailfensterImageLabel.getWidth(), spieledetailfensterImageLabel.getHeight(), Image.SCALE_SMOOTH);
						ImageIcon resizedImageIconspieledetailfenster = new ImageIcon(imgSpieledetailfenster);
					    this.spieledetailfensterImageLabel.setIcon(resizedImageIconspieledetailfenster);
					}
					{
						this.spieledetailfensterScrollPane = new JScrollPane(spieledetailfensterTextArea);
						this.spieledetailfensterScrollPane.setBounds(10, 11, 160, 390);
						this.spieledetailfensterPanel.add(this.spieledetailfensterScrollPane);
					}
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
									+ "Dieser wird in der Tabelle unter dem Suchfeld angezeigt. Bei Klick auf die Zeile des Kunden den man auswï¿½hlen will"
									+ "werden die Daten des Kunden in die Textfelder geschrieben.\n\n"
									+ "2: Sind alle Felder ausgefï¿½llt kann der Hinzufï¿½gen-Button benutzt werden um einen neuen Kunden anzulegen\n\n"
									+ "3: Ist ein Kunde ausgewï¿½hlt kann man die Daten in den Textfeldern ï¿½ndern, um mit Klick auf den ï¿½ndern-Button werden die Daten geï¿½ndert.\n\n"
									+ "4: Der Entfernen-Button wird erst nuztbar, wenn alle Textfelder ausgefï¿½llt sind. Dann kann der ausgewewï¿½hlte Kunde gelï¿½scht werden\n\n"
									+ "5: Der Schlieï¿½en-Button schlieï¿½t das aktuelle Fenster.");
						}
						this.kundenverwaltungZurueckButton.setBounds(524, 378, 150, 23);
						this.kundenverwaltungPanel.add(this.kundenverwaltungZurueckButton);
					}
					{
						this.kundenverwaltungImageLabel = new JLabel();
						this.kundenverwaltungImageLabel.setBounds(180, 11, 494, 356);
						this.kundenverwaltungPanel.add(this.kundenverwaltungImageLabel);
						ImageIcon imgIcokundenverwaltungn = new ImageIcon(getClass().getResource("/images/Kundenverwaltung.PNG"));
					    Image imgKundenverwaltung = imgIcokundenverwaltungn.getImage().getScaledInstance(kundenverwaltungImageLabel.getWidth(), kundenverwaltungImageLabel.getHeight(), Image.SCALE_SMOOTH);
						ImageIcon resizedImageIconkundenverwaltung = new ImageIcon(imgKundenverwaltung);
					    this.kundenverwaltungImageLabel.setIcon(resizedImageIconkundenverwaltung);
					}
					{
						this.kundenverwaltungScrollPane = new JScrollPane(kundenverwaltungTextArea);
						this.kundenverwaltungScrollPane.setBounds(10, 11, 160, 390);
						this.kundenverwaltungPanel.add(this.kundenverwaltungScrollPane);
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
		menuePanel.setVisible(false);
		ausleihfensterPanel.setVisible(true);
	}
	protected void do_hauptbildschirmButton_actionPerformed(ActionEvent e) {
		menuePanel.setVisible(false);
		hauptbildschirmPanel.setVisible(true);
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
	protected void do_ausleihfensterZurueckButton_actionPerformed(ActionEvent arg0) {
		ausleihfensterPanel.setVisible(false);
		menuePanel.setVisible(true);
	}
	protected void do_hauptbildschirmZurueckButton_actionPerformed(ActionEvent arg0) {
		hauptbildschirmPanel.setVisible(false);
		menuePanel.setVisible(true);
	}
}
