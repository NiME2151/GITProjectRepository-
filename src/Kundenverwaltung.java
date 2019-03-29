
import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.*;
import java.beans.*;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Kundenverwaltung extends JFrame {
	//
	private JPanel contentPane;
	private JLabel vornameLabel;
	private JPanel kundendatenPanel;
	private JLabel nachnameLabel;
	private JLabel ibanLabel;
	private JLabel emailLabel;
	private JLabel telefronnummerLabel;
	private JTextField vornameTextField;
	private JTextField nachnameTextField;
	private JTextField ibanTextField;
	private JTextField emailTextField;
	private JTextField telefonnummerTextField;
	private JTextField strasseTextField;
	private JTextField ortTextField;
	private JTextField plzTextField;
	private JTextField idTextField;
	private JTextField suchenTextField;
	private JButton hinzufuegenButton;
	private JButton entfernenButton;
	private JButton aendernButton;
	private JButton suchenButton;
	private JButton schliessenButton;
	private JPanel kundenlistePanel;
	private JLabel kundenlisteLabel;
	private JTable kundenlisteTable;
	private JScrollPane kundenlisteScrollPane;
	private JFrame that = this;
	private Kunde k;
	private String check = "";

	KundenDAO kundenDAO;
	GetWertInZeile kundeAuswaehlen = new GetWertInZeile();
	private JLabel strasseLabel;
	private JLabel idLabel;

	public Kundenverwaltung() {
		initGUI();
		kundenDAO = new KundenDAO();
		this.confirmOnClose();
	}

	private void initGUI() {
		setTitle("Kundenverwaltung");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		contentPane.setLayout(null);
		{
			this.kundendatenPanel = new JPanel();
			kundendatenPanel.setBounds(10, 11, 320, 339);
			this.kundendatenPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
			this.contentPane.add(this.kundendatenPanel);
			this.kundendatenPanel.setLayout(null);
			{
				this.vornameLabel = new JLabel("Vorname:");
				this.vornameLabel.setBounds(10, 36, 100, 14);
				this.kundendatenPanel.add(this.vornameLabel);
			}
			{
				this.nachnameLabel = new JLabel("Nachname:");
				this.nachnameLabel.setBounds(10, 61, 100, 14);
				this.kundendatenPanel.add(this.nachnameLabel);
			}
			{
				this.ibanLabel = new JLabel("IBAN:");
				this.ibanLabel.setBounds(10, 86, 100, 14);
				this.kundendatenPanel.add(this.ibanLabel);
			}
			{
				this.emailLabel = new JLabel("Email:");
				this.emailLabel.setBounds(10, 111, 100, 14);
				this.kundendatenPanel.add(this.emailLabel);
			}
			{
				this.telefronnummerLabel = new JLabel("Telefonnummer:");
				this.telefronnummerLabel.setBounds(10, 136, 100, 14);
				this.kundendatenPanel.add(this.telefronnummerLabel);
			}
			{
				this.vornameTextField = new JTextField();
				this.vornameTextField.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_vornameTextField_actionPerformed(e);
					}
				});
				this.vornameTextField.setBounds(120, 33, 190, 20);
				this.kundendatenPanel.add(this.vornameTextField);
				this.vornameTextField.setColumns(10);
			}
			{
				this.nachnameTextField = new JTextField();
				this.nachnameTextField.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_nachnameTextField_actionPerformed(e);
					}
				});
				this.nachnameTextField.setColumns(10);
				this.nachnameTextField.setBounds(120, 58, 190, 20);
				this.kundendatenPanel.add(this.nachnameTextField);
			}
			{
				this.ibanTextField = new JTextField();
				this.ibanTextField.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_ibanTextField_actionPerformed(e);
					}
				});
				this.ibanTextField.setColumns(10);
				this.ibanTextField.setBounds(120, 83, 190, 20);
				this.kundendatenPanel.add(this.ibanTextField);
			}
			{
				this.emailTextField = new JTextField();
				this.emailTextField.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_emailTextField_actionPerformed(e);
					}
				});
				this.emailTextField.setColumns(10);
				this.emailTextField.setBounds(120, 108, 190, 20);
				this.kundendatenPanel.add(this.emailTextField);
			}
			{
				this.telefonnummerTextField = new JTextField();
				this.telefonnummerTextField.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_telefonnummerTextField_actionPerformed(e);
					}
				});
				this.telefonnummerTextField.setColumns(10);
				this.telefonnummerTextField.setBounds(120, 133, 190, 20);
				this.kundendatenPanel.add(this.telefonnummerTextField);
			}
			{
				this.hinzufuegenButton = new JButton("Hinzuf\u00FCgen");
				this.hinzufuegenButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_hinzufuegenButton_actionPerformed(e);
					}
				});
				this.hinzufuegenButton.setBounds(10, 305, 98, 23);
				this.kundendatenPanel.add(this.hinzufuegenButton);
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
				this.kundendatenPanel.add(this.entfernenButton);
			}
			{
				this.aendernButton = new JButton("\u00C4ndern");
				this.aendernButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						do_aendernButton_actionPerformed(arg0);
					}
				});
				this.aendernButton.setBounds(120, 305, 82, 23);
				this.kundendatenPanel.add(this.aendernButton);
			}
			{
				strasseLabel = new JLabel("Strasse:");
				strasseLabel.setBounds(10, 161, 67, 14);
				kundendatenPanel.add(strasseLabel);
			}

			strasseTextField = new JTextField();
			this.strasseTextField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_strasseTextField_actionPerformed(e);
				}
			});
			strasseTextField.setBounds(120, 158, 190, 20);
			kundendatenPanel.add(strasseTextField);
			strasseTextField.setColumns(10);

			JLabel ortLabel = new JLabel("Ort:");
			ortLabel.setBounds(10, 186, 46, 14);
			kundendatenPanel.add(ortLabel);

			JLabel plzLabel = new JLabel("Plz:");
			plzLabel.setBounds(10, 210, 46, 14);
			kundendatenPanel.add(plzLabel);

			ortTextField = new JTextField();
			this.ortTextField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_ortTextField_actionPerformed(e);
				}
			});
			ortTextField.setBounds(120, 183, 190, 20);
			kundendatenPanel.add(ortTextField);
			ortTextField.setColumns(10);

			plzTextField = new JTextField();
			this.plzTextField.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_plzTextField_actionPerformed(e);
				}
			});
			plzTextField.setBounds(120, 208, 190, 20);
			kundendatenPanel.add(plzTextField);
			plzTextField.setColumns(10);
			{
				idTextField = new JTextField();
				this.idTextField.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_idTextField_actionPerformed(e);
					}
				});
				idTextField.setBounds(120, 8, 190, 20);
				kundendatenPanel.add(idTextField);
				idTextField.setColumns(10);
			}
			{
				idLabel = new JLabel("ID:");
				idLabel.setBounds(10, 11, 46, 14);
				kundendatenPanel.add(idLabel);
			}
		}
		{
			this.suchenTextField = new JTextField();
			this.suchenTextField.setToolTipText("Hier kann ein Kundennachname eingegeben werden");
			suchenTextField.setBounds(340, 11, 284, 20);
			this.contentPane.add(this.suchenTextField);
			this.suchenTextField.setColumns(10);
		}
		{
			this.suchenButton = new JButton("Suchen");
			this.suchenButton.setToolTipText("Bei Klick auf den Button wird nach einem Kunden gesucht");
			suchenButton.setBounds(535, 42, 89, 23);
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
			this.contentPane.add(this.suchenButton);
		}
		{
			this.schliessenButton = new JButton("Schlie\u00DFen");
			schliessenButton.setBounds(524, 327, 100, 23);
			this.schliessenButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_schliessenButton_actionPerformed(e);
				}
			});
			this.contentPane.add(this.schliessenButton);
		}

		{
			this.kundenlistePanel = new JPanel();
			kundenlistePanel.setBounds(340, 70, 284, 250);
			this.kundenlistePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
			this.contentPane.add(this.kundenlistePanel);
			this.kundenlistePanel.setLayout(null);
			{
				this.kundenlisteTable = new JTable();
				this.kundenlisteTable.removeEditor();
				this.kundenlisteTable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							do_kundenlisteTable_mouseClicked(e);
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				this.kundenlisteTable.setModel(new DefaultTableModel(new Object[][] {},
						new String[] { "ID", "Vorname", "Nachname", "Strasse" }));
				this.kundenlisteTable.getColumnModel().getColumn(0).setPreferredWidth(90);
				this.kundenlisteTable.getColumnModel().getColumn(1).setPreferredWidth(90);
				this.kundenlisteTable.setBounds(10, 11, 264, 228);
				this.kundenlistePanel.add(this.kundenlisteTable);
			}
			{
				this.kundenlisteScrollPane = new JScrollPane(kundenlisteTable);
				this.kundenlisteScrollPane.setToolTipText("Hier werden die Kunden angezeigt die gesucht werden");
				this.kundenlisteScrollPane.setBounds(0, 0, 284, 250);
				this.kundenlistePanel.add(this.kundenlisteScrollPane);
			}
		}
		{
			this.kundenlisteLabel = new JLabel("Kundenliste:");
			kundenlisteLabel.setBounds(340, 51, 185, 14);
			this.contentPane.add(this.kundenlisteLabel);
		}
	}

	protected void do_aendernButton_actionPerformed(ActionEvent arg0) {
		k = new Kunde();
		k.setId(idTextField.getText().trim());
		System.out.println("test:" + k.getId());
		k.setVorname(vornameTextField.getText().trim());
		k.setNachname(nachnameTextField.getText().trim());
		k.setIban(ibanTextField.getText().trim());
		k.setEmail(emailTextField.getText().trim());
		k.setTelefonnummer(telefonnummerTextField.getText().trim());
		k.setStrasse(strasseTextField.getText().trim());
		k.setOrt(ortTextField.getText().trim());
		k.setPlz(plzTextField.getText().trim());
		try {
			kundenDAO.update(k);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*
		 * idTextField.setText(""); vornameTextField.setText("");
		 * nachnameTextField.setText(""); ibanTextField.setText("");
		 * emailTextField.setText(""); telefonnummerTextField.setText("");
		 * strasseTextField.setText(""); ortTextField.setText("");
		 * plzTextField.setText("");
		 * 
		 */

	}

	protected void do_schliessenButton_actionPerformed(ActionEvent e) {
		dispose();
	}

	protected void confirmOnClose() {

		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				if (emailTextField.getText().length() > 0 || idTextField.getText().length() > 0
						|| vornameTextField.getText().length() > 0 || nachnameTextField.getText().length() > 0
						|| ibanTextField.getText().length() > 0 || telefonnummerTextField.getText().length() > 0
						|| strasseTextField.getText().length() > 0 || ortTextField.getText().length() > 0
						|| plzTextField.getText().length() > 0) {
					if (JOptionPane.showConfirmDialog(that, "Are you sure you want to close this window?",
							"Close Window?", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
						dispose();
					}
				} else {
					dispose();
				}
			}
		});
	}

	protected void do_suchenButton_actionPerformed(ActionEvent e) throws ClassNotFoundException {
		String gesuchterKunde = String.valueOf(suchenTextField.getText().trim());
		ResultSet rs = kundenDAO.selectKunde(gesuchterKunde);
		this.kundenlisteTable.setModel(DbUtils.resultSetToTableModel(rs));

		if (gesuchterKunde.equalsIgnoreCase("")) {
			JOptionPane spielAngebenAlert = new JOptionPane();
			spielAngebenAlert.showMessageDialog(this, "Bitte den Namen des Kunden angeben!", "Fehler",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void do_hinzufuegenButton_actionPerformed(ActionEvent e) {
		try {
			kundenDAO.add(idTextField.getText(), vornameTextField.getText(), nachnameTextField.getText(),
					ibanTextField.getText(), emailTextField.getText(), telefonnummerTextField.getText(),
					strasseTextField.getText(), ortTextField.getText(), plzTextField.getText());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	protected void do_entfernenButton_actionPerformed(ActionEvent e) throws ClassNotFoundException {
		String id = kundeAuswaehlen.getKundennachnameInTable(kundenlisteTable);
		kundenDAO.delete(id);
	}

	protected void do_kundenlisteTable_mouseClicked(MouseEvent e) throws ClassNotFoundException, SQLException {
		String id = kundeAuswaehlen.getWertInZeile(kundenlisteTable);
		setKundenDaten(id);

	}

	public Kunde setKundenDaten(String id) throws ClassNotFoundException, SQLException {
		System.out.println("idid: " + id);
		Kunde kunde = kundenDAO.selectKundeKundenverwaltung(id);
		idTextField.setText(String.valueOf(kunde.getId()));
		vornameTextField.setText(String.valueOf(kunde.getVorname()));
		nachnameTextField.setText(String.valueOf(kunde.getNachname()));
		ibanTextField.setText(String.valueOf(kunde.getIban()));
		emailTextField.setText(String.valueOf(kunde.getEmail()));
		telefonnummerTextField.setText(String.valueOf(kunde.getTelefonnummer()));
		strasseTextField.setText(String.valueOf(kunde.getStrasse()));
		ortTextField.setText(String.valueOf(kunde.getOrt()));
		plzTextField.setText(String.valueOf(kunde.getPlz()));
		return kunde;
	}
	
	public void checkForFilledTextFields() {
		if (idTextField.getText().length() > 0
				&& vornameTextField.getText().length() > 0
				&& nachnameTextField.getText().length() > 0
				&& ibanTextField.getText().length() > 0
				&& emailTextField.getText().length() > 0
				&& telefonnummerTextField.getText().length() > 0
				&& strasseTextField.getText().length() > 0
				&& ortTextField.getText().length() > 0
				&& plzTextField.getText().length() > 0
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
	protected void do_ibanTextField_actionPerformed(ActionEvent e) {
		checkForFilledTextFields();
	}
	protected void do_telefonnummerTextField_actionPerformed(ActionEvent e) {
		checkForFilledTextFields();
	}
	protected void do_ortTextField_actionPerformed(ActionEvent e) {
		checkForFilledTextFields();
	}
	protected void do_idTextField_actionPerformed(ActionEvent e) {
		checkForFilledTextFields();
	}
	protected void do_plzTextField_actionPerformed(ActionEvent e) {
		checkForFilledTextFields();
	}
	protected void do_strasseTextField_actionPerformed(ActionEvent e) {
		checkForFilledTextFields();
	}
	protected void do_nachnameTextField_actionPerformed(ActionEvent e) {
		checkForFilledTextFields();
	}
	protected void do_vornameTextField_actionPerformed(ActionEvent e) {
		checkForFilledTextFields();
	}
	protected void do_emailTextField_actionPerformed(ActionEvent e) {
		checkForFilledTextFields();
	}
}