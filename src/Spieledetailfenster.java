import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Spieledetailfenster extends JFrame {

	private JPanel contentPane;
	private JLabel titelLabel;
	private JPanel panel;
	private JLabel preisLabel;
	private JLabel releaseDatumLabel;
	private JLabel genreLabel;
	private JLabel uskFreigabeLabel;
	private JLabel lageranzahlLabel;
	private JLabel verfuegbarkeitLabel;
	private JLabel spielzeitLabel;
	private JLabel spracheLabel;
	private JTextField titelTextField;
	private JTextField preisTextField;
	private JTextField releaseDatumTextField;
	private JTextField genreTextField;
	private JTextField uskFreigabeTextField;
	private JTextField lageranzahlTextField;
	private JTextField spielzeitTextField;
	private JTextField spracheTextField;
	private JTextField suchenTextField;
	private JButton suchenButton;
	private JButton schliessenButton;
	private JPanel beschreibungPanel;
	private JLabel beschreibungLabel;
	private JTextField beschreibungTextField;
	private JButton ausleihenButton;
	private JTextField verfuegbarkeitTextField;
	private Spiel spiel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Spieledetailfenster frame = new Spieledetailfenster();
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
	public Spieledetailfenster() {
		initGUI();
	}
	private void initGUI() {
		setTitle("Spieleausleihfenster");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		{
			this.panel = new JPanel();
			this.panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			this.panel.setBounds(10, 11, 320, 339);
			this.contentPane.add(this.panel);
			this.panel.setLayout(null);
			{
				this.titelLabel = new JLabel("Titel: ");
				this.titelLabel.setBounds(10, 11, 100, 14);
				this.panel.add(this.titelLabel);
			}
			{
				this.preisLabel = new JLabel("Preis pro Tag:");
				this.preisLabel.setBounds(10, 36, 100, 14);
				this.panel.add(this.preisLabel);
			}
			{
				this.releaseDatumLabel = new JLabel("Release-Datum:");
				this.releaseDatumLabel.setBounds(10, 61, 100, 14);
				this.panel.add(this.releaseDatumLabel);
			}
			{
				this.genreLabel = new JLabel("Genre:");
				this.genreLabel.setBounds(10, 86, 100, 14);
				this.panel.add(this.genreLabel);
			}
			{
				this.uskFreigabeLabel = new JLabel("USK-Freigabe:");
				this.uskFreigabeLabel.setBounds(10, 111, 100, 14);
				this.panel.add(this.uskFreigabeLabel);
			}
			{
				this.lageranzahlLabel = new JLabel("Lageranzahl:");
				this.lageranzahlLabel.setBounds(10, 136, 100, 14);
				this.panel.add(this.lageranzahlLabel);
			}
			{
				this.verfuegbarkeitLabel = new JLabel("Verf\u00FCgbarkeit:");
				this.verfuegbarkeitLabel.setBounds(10, 161, 100, 14);
				this.panel.add(this.verfuegbarkeitLabel);
			}
			{
				this.spielzeitLabel = new JLabel("Spielzeit:");
				this.spielzeitLabel.setBounds(10, 186, 100, 14);
				this.panel.add(this.spielzeitLabel);
			}
			{
				this.spracheLabel = new JLabel("Sprache:");
				this.spracheLabel.setBounds(10, 211, 100, 14);
				this.panel.add(this.spracheLabel);
			}
			{
				this.titelTextField = new JTextField();
				this.titelTextField.setEditable(false);
				this.titelTextField.setBounds(120, 8, 190, 20);
				this.panel.add(this.titelTextField);
				this.titelTextField.setColumns(10);
			}
			{
				this.preisTextField = new JTextField();
				this.preisTextField.setEditable(false);
				this.preisTextField.setColumns(10);
				this.preisTextField.setBounds(120, 33, 190, 20);
				this.panel.add(this.preisTextField);
			}
			{
				this.releaseDatumTextField = new JTextField();
				this.releaseDatumTextField.setEditable(false);
				this.releaseDatumTextField.setColumns(10);
				this.releaseDatumTextField.setBounds(120, 58, 190, 20);
				this.panel.add(this.releaseDatumTextField);
			}
			{
				this.genreTextField = new JTextField();
				this.genreTextField.setEditable(false);
				this.genreTextField.setColumns(10);
				this.genreTextField.setBounds(120, 83, 190, 20);
				this.panel.add(this.genreTextField);
			}
			{
				this.uskFreigabeTextField = new JTextField();
				this.uskFreigabeTextField.setEditable(false);
				this.uskFreigabeTextField.setColumns(10);
				this.uskFreigabeTextField.setBounds(120, 108, 190, 20);
				this.panel.add(this.uskFreigabeTextField);
			}
			{
				this.lageranzahlTextField = new JTextField();
				this.lageranzahlTextField.setEditable(false);
				this.lageranzahlTextField.setColumns(10);
				this.lageranzahlTextField.setBounds(120, 133, 190, 20);
				this.panel.add(this.lageranzahlTextField);
			}
			{
				this.spielzeitTextField = new JTextField();
				this.spielzeitTextField.setEditable(false);
				this.spielzeitTextField.setColumns(10);
				this.spielzeitTextField.setBounds(120, 183, 190, 20);
				this.panel.add(this.spielzeitTextField);
			}
			{
				this.spracheTextField = new JTextField();
				this.spracheTextField.setEditable(false);
				this.spracheTextField.setColumns(10);
				this.spracheTextField.setBounds(120, 208, 190, 20);
				this.panel.add(this.spracheTextField);
			}
			{
				this.verfuegbarkeitTextField = new JTextField();
				this.verfuegbarkeitTextField.setEditable(false);
				this.verfuegbarkeitTextField.setColumns(10);
				this.verfuegbarkeitTextField.setBounds(120, 158, 190, 20);
				this.panel.add(this.verfuegbarkeitTextField);
			}
		}
		{
			this.suchenTextField = new JTextField();
			this.suchenTextField.setBounds(340, 11, 284, 20);
			this.contentPane.add(this.suchenTextField);
			this.suchenTextField.setColumns(10);
		}
		{
			this.suchenButton = new JButton("Suchen");
			this.suchenButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					do_suchenButton_actionPerformed(arg0);
				}
			});
			this.suchenButton.setBounds(535, 42, 89, 23);
			this.contentPane.add(this.suchenButton);
		}
		{
			this.schliessenButton = new JButton("Schlie\u00DFen");
			this.schliessenButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_schliessenButton_actionPerformed(e);
				}
			});
			this.schliessenButton.setBounds(524, 327, 100, 23);
			this.contentPane.add(this.schliessenButton);
		}
		{
			this.beschreibungPanel = new JPanel();
			this.beschreibungPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
			this.beschreibungPanel.setBounds(340, 75, 285, 240);
			this.contentPane.add(this.beschreibungPanel);
			this.beschreibungPanel.setLayout(null);
			{
				this.beschreibungLabel = new JLabel("Beschreibung");
				this.beschreibungLabel.setHorizontalAlignment(SwingConstants.CENTER);
				this.beschreibungLabel.setBounds(90, 0, 100, 26);
				this.beschreibungPanel.add(this.beschreibungLabel);
			}
			{
				this.beschreibungTextField = new JTextField();
				this.beschreibungTextField.setEditable(false);
				this.beschreibungTextField.setBounds(10, 25, 265, 205);
				this.beschreibungPanel.add(this.beschreibungTextField);
				this.beschreibungTextField.setColumns(10);
			}
		}
		{
			this.ausleihenButton = new JButton("Ausleihen");
			this.ausleihenButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_ausleihenButton_actionPerformed(e);
				}
			});
			this.ausleihenButton.setBounds(350, 327, 100, 23);
			this.contentPane.add(this.ausleihenButton);
		}
	}
	
	protected void do_suchenButton_actionPerformed(ActionEvent arg0) {
	}
	protected void do_ausleihenButton_actionPerformed(ActionEvent e) {
		Ausleihfenster fenster = new Ausleihfenster(spiel);
		fenster.setVisible(true);
	}
	protected void do_schliessenButton_actionPerformed(ActionEvent e) {
		System.exit(1);
	}
}
