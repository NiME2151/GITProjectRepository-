<<<<<<< HEAD


=======
>>>>>>> b1f400e6f3865b379b89770990db2a8e00ae4b68
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class Spieledetailfenster extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3706194479046457310L;
	private JPanel contentPane;
	private JLabel titelLabel;
	private JPanel panel;
	private JLabel preisLabel;
	private JLabel releaseDatumLabel;
	private JLabel genreLabel;
	private JLabel uskFreigabeLabel;
	private JLabel lageranzahlLabel;
	private JLabel verfuegbarkeitLabel;
	private JLabel spracheLabel;
	private JTextField titelTextField;
	private JTextField preisTextField;
	private JTextField releaseDatumTextField;
	private JTextField genreTextField;
	private JTextField uskFreigabeTextField;
	private JTextField lageranzahlTextField;
	private JTextField spracheTextField;
	private JButton schliessenButton;
	private JPanel beschreibungPanel;
	private JLabel beschreibungLabel;
	private JTextField beschreibungTextField;
	private JButton ausleihenButton;
	private JTextField verfuegbarkeitTextField;
	private String spiel;

	//Spiel spiel = new Spiel();
	SpielDAO spielDAO = new SpielDAO();
	private JLabel idLabel;
	private JTextField idTextField;
	
	DecimalFormat df = new DecimalFormat("####0");

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Spieledetailfenster(String ausgewaehltesSpiel) throws ClassNotFoundException, SQLException {
		this.spiel = ausgewaehltesSpiel;
		System.out.println(this.spiel);
		initGUI();
		setDaten(ausgewaehltesSpiel);
	}
	
	private void initGUI() throws ClassNotFoundException, SQLException {
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
				this.titelLabel.setBounds(10, 39, 100, 14);
				this.panel.add(this.titelLabel);
			}
			{
				this.preisLabel = new JLabel("Preis pro Tag:");
				this.preisLabel.setBounds(10, 64, 100, 14);
				this.panel.add(this.preisLabel);
			}
			{
				this.releaseDatumLabel = new JLabel("Release-Datum:");
				this.releaseDatumLabel.setBounds(10, 89, 100, 14);
				this.panel.add(this.releaseDatumLabel);
			}
			{
				this.genreLabel = new JLabel("Genre:");
				this.genreLabel.setBounds(10, 114, 100, 14);
				this.panel.add(this.genreLabel);
			}
			{
				this.uskFreigabeLabel = new JLabel("USK-Freigabe:");
				this.uskFreigabeLabel.setBounds(10, 139, 100, 14);
				this.panel.add(this.uskFreigabeLabel);
			}
			{
				this.lageranzahlLabel = new JLabel("Lageranzahl:");
				this.lageranzahlLabel.setBounds(10, 164, 100, 14);
				this.panel.add(this.lageranzahlLabel);
			}
			{
				this.verfuegbarkeitLabel = new JLabel("Verf\u00FCgbarkeit:");
				this.verfuegbarkeitLabel.setBounds(10, 189, 100, 14);
				this.panel.add(this.verfuegbarkeitLabel);
			}
			{
				this.spracheLabel = new JLabel("Sprache:");
				this.spracheLabel.setBounds(10, 217, 100, 14);
				this.panel.add(this.spracheLabel);
			}
			{
				this.titelTextField = new JTextField();
				this.titelTextField.setEditable(false);
				this.titelTextField.setBounds(120, 36, 190, 20);
				this.panel.add(this.titelTextField);
				this.titelTextField.setColumns(10);
			}
			{
				this.preisTextField = new JTextField();
				this.preisTextField.setEditable(false);
				this.preisTextField.setColumns(10);
				this.preisTextField.setBounds(120, 61, 190, 20);
				this.panel.add(this.preisTextField);
			}
			{
				this.releaseDatumTextField = new JTextField();
				this.releaseDatumTextField.setEditable(false);
				this.releaseDatumTextField.setColumns(10);
				this.releaseDatumTextField.setBounds(120, 86, 190, 20);
				this.panel.add(this.releaseDatumTextField);
			}
			{
				this.genreTextField = new JTextField();
				this.genreTextField.setEditable(false);
				this.genreTextField.setColumns(10);
				this.genreTextField.setBounds(120, 111, 190, 20);
				this.panel.add(this.genreTextField);
			}
			{
				this.uskFreigabeTextField = new JTextField();
				this.uskFreigabeTextField.setEditable(false);
				this.uskFreigabeTextField.setColumns(10);
				this.uskFreigabeTextField.setBounds(120, 136, 190, 20);
				this.panel.add(this.uskFreigabeTextField);
			}
			{
				this.lageranzahlTextField = new JTextField();
				this.lageranzahlTextField.setEditable(false);
				this.lageranzahlTextField.setColumns(10);
				this.lageranzahlTextField.setBounds(120, 161, 190, 20);
				this.panel.add(this.lageranzahlTextField);
			}
			{
				this.spracheTextField = new JTextField();
				this.spracheTextField.setEditable(false);
				this.spracheTextField.setColumns(10);
				this.spracheTextField.setBounds(120, 214, 190, 20);
				this.panel.add(this.spracheTextField);
			}
			{
				this.verfuegbarkeitTextField = new JTextField();
				this.verfuegbarkeitTextField.setEditable(false);
				this.verfuegbarkeitTextField.setColumns(10);
				this.verfuegbarkeitTextField.setBounds(120, 186, 190, 20);
				this.panel.add(this.verfuegbarkeitTextField);
			}
			{
				this.idLabel = new JLabel("ID:");
				this.idLabel.setBounds(10, 11, 100, 14);
				this.panel.add(this.idLabel);
			}
			{
				this.idTextField = new JTextField();
				this.idTextField.setEditable(false);
				this.idTextField.setBounds(120, 8, 190, 20);
				this.panel.add(this.idTextField);
				this.idTextField.setColumns(10);
			}
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
			this.beschreibungPanel.setBounds(340, 11, 285, 240);
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
					try {
						do_ausleihenButton_actionPerformed(e);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			this.ausleihenButton.setBounds(340, 262, 100, 23);
			this.contentPane.add(this.ausleihenButton);
		}
		
		JButton btnZurckgeben = new JButton("Zur\u00FCckgeben");
		btnZurckgeben.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZurueckgebenFenster fenster = new ZurueckgebenFenster();
				fenster.setVisible(true);
			}
		});
		btnZurckgeben.setBounds(524, 263, 100, 23);
		contentPane.add(btnZurckgeben);

	}

	protected void do_suchenButton_actionPerformed(ActionEvent arg0) throws ClassNotFoundException, SQLException {
	}
	protected void do_ausleihenButton_actionPerformed(ActionEvent e) throws ClassNotFoundException, SQLException {
		
		Ausleihfenster fenster = new Ausleihfenster(spiel);
		fenster.setVisible(true);
	}
	protected void do_schliessenButton_actionPerformed(ActionEvent e) {
		System.exit(1);
	}

	public Spiel setDaten(String ausgewaehltesSpiel) throws ClassNotFoundException, SQLException {
		Spiel spiel = spielDAO.selectSpiel(ausgewaehltesSpiel);
		System.out.println(spiel.getId());
		this.idTextField.setText(spiel.getId());
//		System.out.println(df.format(spiel.getId()));
		this.titelTextField.setText(spiel.getTitel());
		this.genreTextField.setText(spiel.getGenre());
		this.releaseDatumTextField.setText(spiel.getVeroeffentlichkeitsdatum());
		this.uskFreigabeTextField.setText(spiel.getUsk());
		this.preisTextField.setText(String.valueOf(spiel.getPreis()));
		this.lageranzahlTextField.setText(String.valueOf(spiel.getLageranzahl()));
		this.verfuegbarkeitTextField.setText(spiel.getVerfuegbarkeit());
		this.spracheTextField.setText(spiel.getSprache());
		return spiel;
	}
}
