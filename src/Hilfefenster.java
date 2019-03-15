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
	private JPanel ausleihfensterPanel;
	private JTextArea ausleihfensterTextArea;
	private JButton ausleihfensterZurueckButton;
	
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
			this.spieledetailfensterPanel = new JPanel();
			this.spieledetailfensterPanel.setVisible(false);
			{
				ausleihfensterPanel = new JPanel();
				ausleihfensterPanel.setBounds(0, 0, 674, 401);
				contentPane.add(ausleihfensterPanel);
				ausleihfensterPanel.setLayout(null);
				{
					ausleihfensterTextArea = new JTextArea();
					ausleihfensterTextArea.setBounds(10, 11, 160, 390);
					ausleihfensterTextArea.setText("1: Oben Links ist der Kunden anlegen Button. Wenn man auf den Button klickt dann \u00F6ffnet sich ein neues Kundenverwaltungsfenster in dem man einen neuen Kunden anlegen kann.\\n\\n  2: Rechts daneben ist ein TextField, in dem TextField wird ein Nachname eingegeben und mit dem Klick auf den Suchen Button wird links der Kunde aufgelistet den man gesucht hat. \\n\\n  3: Rechts unter dem Suchen Button sind mehrere TextFields, in den ersten beiden wird die Leihdauer und die Ausleihmenge angegeben. \tWird da ein falscher Wert eingebeben dann kommt eine Fehlermeldung und der Preis kann nicht berechnet werden. Darunter kann man dann, mit einem klick auf den AusleihButton ausleihen.");
					ausleihfensterTextArea.setWrapStyleWord(true);
					ausleihfensterTextArea.setLineWrap(true);
					ausleihfensterTextArea.setEditable(false);
					ausleihfensterTextArea.setBackground(SystemColor.menu);
					ausleihfensterPanel.add(ausleihfensterTextArea);
				}
				{
					ausleihfensterZurueckButton = new JButton("Zur\u00FCck");
					ausleihfensterZurueckButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							ausleihfensterPanel.setVisible(false);
							menuePanel.setVisible(true);
						}
					});
					ausleihfensterZurueckButton.setBounds(513, 378, 131, 23);
					ausleihfensterPanel.add(ausleihfensterZurueckButton);
				}
			}
			{
				this.kundenverwaltungPanel = new JPanel();
				this.kundenverwaltungPanel.setBounds(0, 0, 684, 412);
				this.contentPane.add(this.kundenverwaltungPanel);
				{
					this.kundenverwaltungZurueckButton = new JButton("Zur\u00FCck");
					kundenverwaltungZurueckButton.setBounds(524, 378, 150, 23);
					this.kundenverwaltungZurueckButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							do_kundenverwaltungZurueckButton_actionPerformed(e);
						}
					});
					kundenverwaltungPanel.setLayout(null);
					{
						this.kundenverwaltungTextArea = new JTextArea();
						kundenverwaltungTextArea.setBounds(10, 11, 160, 390);
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
					this.kundenverwaltungPanel.add(this.kundenverwaltungZurueckButton);
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
				this.spieledetailfensterTextArea.setText("1: Links sind die Daten des ausgewählten Spieles zu sehen.\n\n"
						+ "2: Im Feld rechts ist eine kurze Beschreibung des Spieles.\n\n"
						+ "3: Der Ausleihen-Button führt zum Ausleihfenster, dort kann das ausgewählte Spiel ausgeliehen werden.\n\n"
						+ "4: Der Zurückgeben-Button führt zum Zzurückgebenfenster, dort kann man das ausgewählte Spiele wieder zurückgeben\n\n"
						+ "5: Der Schließen-Button schließt das aktuelle Fenster.");
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
	}
	protected void do_zurueckgebenfensterButton_actionPerformed(ActionEvent e) {
	}
	protected void do_spieleverwaltungButton_actionPerformed(ActionEvent e) {
	}
	protected void do_spieledetailfensterZurueckButton_actionPerformed(ActionEvent e) {
		spieledetailfensterPanel.setVisible(false);
		menuePanel.setVisible(true);
	}
	protected void do_kundenverwaltungZurueckButton_actionPerformed(ActionEvent e) {
		kundenverwaltungPanel.setVisible(false);
		menuePanel.setVisible(true);
	}
}
