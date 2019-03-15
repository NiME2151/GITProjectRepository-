
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sun.glass.events.WindowEvent;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;

public class Spieleverwaltung extends JFrame {

	private JPanel contentPane;
	private JLabel titelLabel;
	private JPanel linkesPanel;
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
	private JTextField uskFreigabeTextField;
	private JTextField lageranzahlTextField;
	private JTextField verfuegbarkeitTextField;
	private JTextField spracheTextField;
	private JButton hinzufuegenButton;
	private JButton entfernenButton;
	private JButton aendernButton;
	private JTextField suchenTextField;
	private JButton suchenButton;
	private JButton schliessenButton;
	private JComboBox genreComboBox;
	private Spiel s;
	SpielDAO spielDAO;
	private JTextField idTextField;
	private JTable spielelisteTable;
	Spieleverwaltung frame;

	GetWertInZeile spielAuswaehlen = new GetWertInZeile();
	private JLabel beschreibungLabel;
	private JTextField beschreibungTextField;

	public Spieleverwaltung() {
		initGUI();
		spielDAO = new SpielDAO();
		this.confirmOnClose();
	}

	private void initGUI() {
		setTitle("Spieleverwaltung");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		{
			this.linkesPanel = new JPanel();
			this.linkesPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
			this.linkesPanel.setBounds(10, 11, 320, 339);
			this.contentPane.add(this.linkesPanel);
			this.linkesPanel.setLayout(null);
			{
				this.titelLabel = new JLabel("Titel: ");
				this.titelLabel.setBounds(10, 41, 100, 14);
				this.linkesPanel.add(this.titelLabel);
			}
			{
				this.preisLabel = new JLabel("Preis pro Tag:");
				this.preisLabel.setBounds(10, 66, 100, 14);
				this.linkesPanel.add(this.preisLabel);
			}
			{
				this.releaseDatumLabel = new JLabel("Release-Datum:");
				this.releaseDatumLabel.setBounds(10, 91, 100, 14);
				this.linkesPanel.add(this.releaseDatumLabel);
			}
			{
				this.genreLabel = new JLabel("Genre:");
				this.genreLabel.setBounds(10, 116, 100, 14);
				this.linkesPanel.add(this.genreLabel);
			}
			{
				this.uskFreigabeLabel = new JLabel("USK-Freigabe:");
				this.uskFreigabeLabel.setBounds(10, 141, 100, 14);
				this.linkesPanel.add(this.uskFreigabeLabel);
			}
			{
				this.lageranzahlLabel = new JLabel("Lageranzahl:");
				this.lageranzahlLabel.setBounds(10, 166, 100, 14);
				this.linkesPanel.add(this.lageranzahlLabel);
			}
			{
				this.verfuegbarkeitLabel = new JLabel("Verf\u00FCgbarkeit:");
				this.verfuegbarkeitLabel.setBounds(10, 191, 100, 14);
				this.linkesPanel.add(this.verfuegbarkeitLabel);
			}
			{
				this.spracheLabel = new JLabel("Sprache:");
				this.spracheLabel.setBounds(10, 216, 100, 14);
				this.linkesPanel.add(this.spracheLabel);
			}
			{
				this.titelTextField = new JTextField();
				this.titelTextField.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_titelTextField_actionPerformed(e);
					}
				});
				this.titelTextField.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						//do_titelTextField_keyTyped(e);
					}
				});
				this.titelTextField.setBounds(120, 38, 190, 20);
				this.linkesPanel.add(this.titelTextField);
				this.titelTextField.setColumns(10);
			}
			{
				this.preisTextField = new JTextField();
				this.preisTextField.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_preisTextField_actionPerformed(e);
					}
				});
				this.preisTextField.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						//do_preisTextField_keyTyped(e);
					}
				});
				this.preisTextField.setColumns(10);
				this.preisTextField.setBounds(120, 63, 190, 20);
				this.linkesPanel.add(this.preisTextField);
			}
			{
				this.releaseDatumTextField = new JTextField();
				this.releaseDatumTextField.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_releaseDatumTextField_actionPerformed(e);
					}
				});
				this.releaseDatumTextField.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						//do_releaseDatumTextField_keyTyped(e);
					}
				});
				this.releaseDatumTextField.setColumns(10);
				this.releaseDatumTextField.setBounds(120, 88, 190, 20);
				this.linkesPanel.add(this.releaseDatumTextField);
			}
			{
				this.uskFreigabeTextField = new JTextField();
				this.uskFreigabeTextField.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_uskFreigabeTextField_actionPerformed(e);
					}
				});
				this.uskFreigabeTextField.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						//do_uskFreigabeTextField_keyTyped(e);
					}
				});
				this.uskFreigabeTextField.setColumns(10);
				this.uskFreigabeTextField.setBounds(120, 138, 190, 20);
				this.linkesPanel.add(this.uskFreigabeTextField);
			}
			{
				this.lageranzahlTextField = new JTextField();
				this.lageranzahlTextField.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_lageranzahlTextField_actionPerformed(e);
					}
				});
				this.lageranzahlTextField.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						//do_lageranzahlTextField_keyTyped(e);
					}
				});
				this.lageranzahlTextField.setColumns(10);
				this.lageranzahlTextField.setBounds(120, 163, 190, 20);
				this.linkesPanel.add(this.lageranzahlTextField);
			}
			{
				this.verfuegbarkeitTextField = new JTextField();
				this.verfuegbarkeitTextField.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_verfuegbarkeitTextField_actionPerformed(e);
					}
				});
				this.verfuegbarkeitTextField.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						//do_verfuegbarkeitTextField_keyTyped(e);
					}
				});
				this.verfuegbarkeitTextField.setColumns(10);
				this.verfuegbarkeitTextField.setBounds(120, 188, 190, 20);
				this.linkesPanel.add(this.verfuegbarkeitTextField);
			}
			{
				this.spracheTextField = new JTextField();
				this.spracheTextField.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_spracheTextField_actionPerformed(e);
					}
				});
				this.spracheTextField.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						//do_spracheTextField_keyTyped(e);
					}
				});
				this.spracheTextField.setColumns(10);
				this.spracheTextField.setBounds(120, 213, 190, 20);
				this.linkesPanel.add(this.spracheTextField);
			}
			{
				this.hinzufuegenButton = new JButton("Hinzuf\u00FCgen");
				this.hinzufuegenButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							do_hinzufuegenButton_actionPerformed(e);
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				this.hinzufuegenButton.setBounds(10, 305, 98, 23);
				this.linkesPanel.add(this.hinzufuegenButton);
			}
			{
				this.entfernenButton = new JButton("Entfernen");
				this.entfernenButton.setEnabled(false);
				this.entfernenButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							do_entfernenButton_actionPerformed(e);
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				this.entfernenButton.setBounds(212, 305, 98, 23);
				this.linkesPanel.add(this.entfernenButton);
			}
			{
				this.aendernButton = new JButton("\u00C4ndern");
				this.aendernButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_aendernButton_actionPerformed(e);
					}
				});
				this.aendernButton.setBounds(120, 305, 82, 23);
				this.linkesPanel.add(this.aendernButton);
			}
			{
				this.genreComboBox = new JComboBox();
				this.genreComboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_genreComboBox_actionPerformed(e);
					}
				});
				this.genreComboBox.setModel(new DefaultComboBoxModel(new String[] { "", "Action", "Action-Adventures",
						"Adventure", "Textadventures", "Horror", "Shooter", "Erotik", "Geschicklichtkeitsspiele,",
						"Jump 'n' Runs", "Lernspiele", "Open-World", "Musikspiele", "R\u00E4tselspiele", "RPG",
						"Simulation", "Sport", "Strategie" }));
				this.genreComboBox.setToolTipText("");
				this.genreComboBox.setBounds(120, 113, 190, 20);
				this.linkesPanel.add(this.genreComboBox);
			}

			JLabel idLabel = new JLabel("ID:");
			idLabel.setBounds(10, 16, 100, 14);
			linkesPanel.add(idLabel);

			idTextField = new JTextField();
			this.idTextField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_idTextField_actionPerformed(e);
				}
			});
			this.idTextField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					//do_idTextField_keyTyped(e);
				}
			});
			idTextField.setBounds(120, 13, 190, 20);
			linkesPanel.add(idTextField);
			idTextField.setColumns(10);
			{
				this.beschreibungLabel = new JLabel("Beschreibung:");
				this.beschreibungLabel.setBounds(10, 241, 100, 14);
				this.linkesPanel.add(this.beschreibungLabel);
			}
			{
				this.beschreibungTextField = new JTextField();
				this.beschreibungTextField.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_beschreibungTextField_actionPerformed(e);
					}
				});
				this.beschreibungTextField.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						//do_beschreibungTextField_keyTyped(e);
					}
				});
				this.beschreibungTextField.setColumns(10);
				this.beschreibungTextField.setBounds(120, 238, 190, 20);
				this.linkesPanel.add(this.beschreibungTextField);
			}
		}
		{
			this.suchenTextField = new JTextField();
			this.suchenTextField.setBounds(340, 11, 284, 20);
			this.contentPane.add(this.suchenTextField);
			this.suchenTextField.setColumns(10);
		}
		try {
			{
				this.suchenButton = new JButton("Suchen");
				this.suchenButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							try {
								do_suchenButton_actionPerformed(e);
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
				this.suchenButton.setBounds(535, 42, 89, 23);
				this.contentPane.add(this.suchenButton);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

		spielelisteTable = new JTable();
		this.spielelisteTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					do_spielelisteTable_mouseClicked(e);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		spielelisteTable
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Titel", "Genre", "Release" }));
		spielelisteTable.setBounds(350, 331, 284, 240);
		contentPane.add(spielelisteTable);

		JScrollPane spielelisteScrollPane = new JScrollPane(spielelisteTable);
		spielelisteScrollPane.setBounds(340, 76, 284, 240);
		contentPane.add(spielelisteScrollPane);
	}

	protected void do_suchenButton_actionPerformed(ActionEvent e) throws ClassNotFoundException, SQLException {
		s = new Spiel();
		String gesuchtesSpiel = String.valueOf(suchenTextField.getText().trim());
		


		if (!gesuchtesSpiel.equalsIgnoreCase("")) {
			ResultSet rs = spielDAO.sucheNachSpiel(gesuchtesSpiel);
			System.out.println(rs);
			this.spielelisteTable.setModel(DbUtils.resultSetToTableModel(rs));
			try {
				rs.close();
			} catch (SQLException e1) { 
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} else if (gesuchtesSpiel.equalsIgnoreCase("")) {
			JOptionPane spielAngebenAlert = new JOptionPane();
			spielAngebenAlert.showMessageDialog(this, "Name des Spiels angeben", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
		}
			

	protected void do_spielelisteTable_mouseClicked(MouseEvent e) throws ClassNotFoundException, SQLException {
		String ausgewaehltesSpiel = spielAuswaehlen.getWertInZeile(spielelisteTable);
		Spiel spiel = spielDAO.selectSpiel(ausgewaehltesSpiel);
		idTextField.setText(spiel.getId());
		titelTextField.setText(spiel.getTitel());
		verfuegbarkeitTextField.setText(spiel.getVerfuegbarkeit());
		releaseDatumTextField.setText(spiel.getVeroeffentlichkeitsdatum());
		preisTextField.setText(String.valueOf(spiel.getPreis()));
		genreComboBox.getItemAt(0).toString().contains(spiel.getGenre());
		genreComboBox.setSelectedItem(String.valueOf(spiel.getGenre()));
		uskFreigabeTextField.setText(spiel.getUsk());
		lageranzahlTextField.setText(String.valueOf(spiel.getLageranzahl()));
		spracheTextField.setText(spiel.getSprache());
		beschreibungTextField.setText(spiel.getBeschreibung());
	}

	protected void do_hinzufuegenButton_actionPerformed(ActionEvent e) throws ClassNotFoundException {

		s = new Spiel();
		s.setId(idTextField.getText().trim());
		s.setLageranzahl(Integer.parseInt(lageranzahlTextField.getText().trim()));
		s.setPreis(Double.parseDouble(preisTextField.getText().trim()));
		s.setVeroeffentlichkeitsdatum(String.valueOf(releaseDatumTextField.getText().trim()));
		s.setTitel(titelTextField.getText().trim());
		s.setGenre(String.valueOf(genreComboBox.getSelectedItem()));
		s.setUsk(uskFreigabeTextField.getText().trim());
		s.setSprache(spracheTextField.getText().trim());
		s.setVerfuegbarkeit(verfuegbarkeitTextField.getText().trim());
		s.setBeschreibung(beschreibungTextField.getText().trim());

		spielDAO.insert(s);

		textFelderLeeren();
	}

	protected void do_schliessenButton_actionPerformed(ActionEvent e) {
		dispose();
	}
	
	protected void confirmOnClose() {

		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			
				if (idTextField.getText().length() > 0
						|| lageranzahlTextField.getText().length() > 0 
						|| preisTextField.getText().length() > 0
						|| releaseDatumTextField.getText().length() > 0
						|| titelTextField.getText().length() > 0 
						|| genreComboBox.getItemAt(0).toString().length() > 0
						|| genreComboBox.getSelectedItem().toString().length() > 0
						|| uskFreigabeTextField.getText().length() > 0
						|| spracheTextField.getText().length() > 0 
						|| verfuegbarkeitTextField.getText().length() > 0) {
					if (JOptionPane.showConfirmDialog(frame, 
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
	protected void do_aendernButton_actionPerformed(ActionEvent e) {
		s = new Spiel();
		s.setId(idTextField.getText().trim());
		s.setLageranzahl(Integer.parseInt(lageranzahlTextField.getText().trim()));
		s.setPreis(Double.parseDouble(preisTextField.getText().trim()));
		s.setVeroeffentlichkeitsdatum(String.valueOf(releaseDatumTextField.getText().trim()));
		s.setTitel(titelTextField.getText().trim());
		s.setGenre(String.valueOf(genreComboBox.getSelectedItem()));
		s.setUsk(uskFreigabeTextField.getText().trim());
		s.setSprache(spracheTextField.getText().trim());
		s.setVerfuegbarkeit(verfuegbarkeitTextField.getText().trim());
		s.setBeschreibung(beschreibungTextField.getText().trim());
		try {
			spielDAO.update(s);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		textFelderLeeren();

	}

	protected void do_entfernenButton_actionPerformed(ActionEvent e) throws ClassNotFoundException {
		spielDAO.delete(idTextField.getText());
		textFelderLeeren();
	}

	public void textFelderLeeren() {
		titelTextField.setText("");
		releaseDatumTextField.setText("");
		preisTextField.setText("");
		genreComboBox.setSelectedItem("");
		uskFreigabeTextField.setText("");
		lageranzahlTextField.setText("");
		spracheTextField.setText("");
		idTextField.setText("");
		verfuegbarkeitTextField.setText("");
		beschreibungTextField.setText("");
	}
	
	public void checkForFilledTextFields() {
		if (idTextField.getText().length() > 0
				&& preisTextField.getText().length() > 0
				&& titelTextField.getText().length() > 0
				&& releaseDatumTextField.getText().length() > 0
				&& beschreibungTextField.getText().length() > 0
				&& lageranzahlTextField.getText().length() > 0
				&& uskFreigabeTextField.getText().length() > 0
				&& spracheTextField.getText().length() > 0
				&& verfuegbarkeitTextField.getText().length() > 0
				&& genreComboBox.getSelectedItem() != ""
				) {
			entfernenButton.setEnabled(true);
		}
		/*else if (!idTextField.getText().equals("")
				&& !preisTextField.getText().equals("")
				&& !titelTextField.getText().equals("")
				&& !releaseDatumTextField.getText().equals("")
				&& !beschreibungTextField.getText().equals("")
				&& !lageranzahlTextField.getText().equals("")
				&& !uskFreigabeTextField.getText().equals("")
				&& !spracheTextField.getText().equals("")
				&& !verfuegbarkeitTextField.getText().equals("")
				&& !genreComboBox.getSelectedItem().equals("")
				) {
			entfernenButton.setEnabled(true);
		}*/
		else {
			entfernenButton.setEnabled(false);
		}
	}
	protected void do_releaseDatumTextField_keyTyped(KeyEvent e) {
		checkForFilledTextFields();
	}
	protected void do_verfuegbarkeitTextField_keyTyped(KeyEvent e) {
		checkForFilledTextFields();
	}
	protected void do_idTextField_keyTyped(KeyEvent e) {
		checkForFilledTextFields();
	}
	protected void do_titelTextField_keyTyped(KeyEvent e) {
		checkForFilledTextFields();
	}
	protected void do_preisTextField_keyTyped(KeyEvent e) {
		checkForFilledTextFields();
	}
	protected void do_beschreibungTextField_keyTyped(KeyEvent e) {
		checkForFilledTextFields();
	}
	protected void do_lageranzahlTextField_keyTyped(KeyEvent e) {
		checkForFilledTextFields();
	}
	protected void do_uskFreigabeTextField_keyTyped(KeyEvent e) {
		checkForFilledTextFields();
	}
	protected void do_spracheTextField_keyTyped(KeyEvent e) {
		checkForFilledTextFields();
	}
	protected void do_uskFreigabeTextField_actionPerformed(ActionEvent e) {
		checkForFilledTextFields();
	}
	protected void do_releaseDatumTextField_actionPerformed(ActionEvent e) {
		checkForFilledTextFields();
	}
	protected void do_verfuegbarkeitTextField_actionPerformed(ActionEvent e) {
		checkForFilledTextFields();
	}
	protected void do_preisTextField_actionPerformed(ActionEvent e) {
		checkForFilledTextFields();
	}
	protected void do_idTextField_actionPerformed(ActionEvent e) {
		checkForFilledTextFields();
	}
	protected void do_genreComboBox_actionPerformed(ActionEvent e) {
		checkForFilledTextFields();
	}
	protected void do_lageranzahlTextField_actionPerformed(ActionEvent e) {
		checkForFilledTextFields();
	}
	protected void do_titelTextField_actionPerformed(ActionEvent e) {
		checkForFilledTextFields();
	}
	protected void do_spracheTextField_actionPerformed(ActionEvent e) {
		checkForFilledTextFields();
	}
	protected void do_beschreibungTextField_actionPerformed(ActionEvent e) {
		checkForFilledTextFields();
	}
}
