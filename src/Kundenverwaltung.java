<<<<<<< HEAD
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

//import net.proteanit.sql.DbUtils;

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

public class Kundenverwaltung extends JFrame {

	private JPanel contentPane;
	private JLabel vornameLabel;
	private JPanel kundendatenPanel;
	private JLabel nachnameLabel;
	private JLabel ibanLabel;
	private JLabel emailLabel;
	private JLabel telefronnummerLabel;
	private JLabel adresseLabel;
	private JTextField vornameTextField;
	private JTextField nachnameTextField;
	private JTextField ibanTextField;
	private JTextField emailTextField;
	private JTextField telefronnummerTextField;
	private JTextField adresseTextField;
	private JButton hinzufuegenButton;
	private JButton entfernenButton;
	private JButton aendernButton;
	private JTextField suchenTextField;
	private JButton suchenButton;
	private JButton schliessenButton;
	private JPanel kundenlistePanel;
	private JLabel kundenlisteLabel;
	private JTable kundenlisteTable;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kundenverwaltung frame = new Kundenverwaltung();
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
	public Kundenverwaltung() {
		initGUI();
	}

	private void initGUI() {
		setTitle("Kundenverwaltung");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				this.vornameLabel.setBounds(10, 11, 100, 14);
				this.kundendatenPanel.add(this.vornameLabel);
			}
			{
				this.nachnameLabel = new JLabel("Nachname:");
				this.nachnameLabel.setBounds(10, 36, 100, 14);
				this.kundendatenPanel.add(this.nachnameLabel);
			}
			{
				this.ibanLabel = new JLabel("IBAN:");
				this.ibanLabel.setBounds(10, 61, 100, 14);
				this.kundendatenPanel.add(this.ibanLabel);
			}
			{
				this.emailLabel = new JLabel("Email:");
				this.emailLabel.setBounds(10, 86, 100, 14);
				this.kundendatenPanel.add(this.emailLabel);
			}
			{
				this.telefronnummerLabel = new JLabel("Telefonnummer:");
				this.telefronnummerLabel.setBounds(10, 111, 100, 14);
				this.kundendatenPanel.add(this.telefronnummerLabel);
			}
			{
				this.adresseLabel = new JLabel("Adresse:");
				this.adresseLabel.setBounds(10, 136, 100, 14);
				this.kundendatenPanel.add(this.adresseLabel);
			}
			{
				this.vornameTextField = new JTextField();
				this.vornameTextField.setEditable(false);
				this.vornameTextField.setBounds(120, 8, 190, 20);
				this.kundendatenPanel.add(this.vornameTextField);
				this.vornameTextField.setColumns(10);
			}
			{
				this.nachnameTextField = new JTextField();
				this.nachnameTextField.setEditable(false);
				this.nachnameTextField.setColumns(10);
				this.nachnameTextField.setBounds(120, 33, 190, 20);
				this.kundendatenPanel.add(this.nachnameTextField);
			}
			{
				this.ibanTextField = new JTextField();
				this.ibanTextField.setEditable(false);
				this.ibanTextField.setColumns(10);
				this.ibanTextField.setBounds(120, 58, 190, 20);
				this.kundendatenPanel.add(this.ibanTextField);
			}
			{
				this.emailTextField = new JTextField();
				this.emailTextField.setEditable(false);
				this.emailTextField.setColumns(10);
				this.emailTextField.setBounds(120, 83, 190, 20);
				this.kundendatenPanel.add(this.emailTextField);
			}
			{
				this.telefronnummerTextField = new JTextField();
				this.telefronnummerTextField.setEditable(false);
				this.telefronnummerTextField.setColumns(10);
				this.telefronnummerTextField.setBounds(120, 108, 190, 20);
				this.kundendatenPanel.add(this.telefronnummerTextField);
			}
			{
				this.adresseTextField = new JTextField();
				this.adresseTextField.setEditable(false);
				this.adresseTextField.setColumns(10);
				this.adresseTextField.setBounds(120, 133, 190, 20);
				this.kundendatenPanel.add(this.adresseTextField);
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
				this.entfernenButton.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {
						do_entfernenButton_actionPerformed(e);
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
		}
		{
			this.suchenTextField = new JTextField();
			suchenTextField.setBounds(340, 11, 284, 20);
			this.contentPane.add(this.suchenTextField);
			this.suchenTextField.setColumns(10);
		}
		{
			this.suchenButton = new JButton("Suchen");
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
				this.kundenlisteTable
						.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Vorname", "Nachname" }));
				this.kundenlisteTable.getColumnModel().getColumn(0).setPreferredWidth(90);
				this.kundenlisteTable.getColumnModel().getColumn(1).setPreferredWidth(90);
				this.kundenlisteTable.setBounds(10, 11, 264, 228);
				this.kundenlistePanel.add(this.kundenlisteTable);
			}
			{
				this.scrollPane = new JScrollPane(kundenlisteTable);
				this.scrollPane.setBounds(0, 0, 284, 250);
				this.kundenlistePanel.add(this.scrollPane);
			}
		}
	{
		this.kundenlisteLabel = new JLabel("Kundenliste:");
		kundenlisteLabel.setBounds(340, 51, 185, 14);
		this.contentPane.add(this.kundenlisteLabel);
	}
	
	JButton zurueckgebenButton = new JButton("Zur\u00FCckgeben");
	zurueckgebenButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ZurueckgebenFenster fenster = new ZurueckgebenFenster();
			fenster.setVisible(true);
			
		}
	});
	zurueckgebenButton.setBounds(350, 327, 107, 23);
	contentPane.add(zurueckgebenButton);
	}

	protected void do_aendernButton_actionPerformed(ActionEvent arg0) {
	}

	protected void do_schliessenButton_actionPerformed(ActionEvent e) {
		System.exit(1);
	}

	protected void do_suchenButton_actionPerformed(ActionEvent e) throws ClassNotFoundException {
		ResultSet rs = KundenverwaltungDAO.selectKunde(suchenTextField.getText());
		//this.kundenlisteTable.setModel(DbUtils.resultSetToTableModel(rs));

		KundeInTabelleAuswaehlen kundeAuswaehlen = new KundeInTabelleAuswaehlen(kundenlisteTable);
	}

	protected void do_hinzufuegenButton_actionPerformed(ActionEvent e) {
	}

	protected void do_entfernenButton_actionPerformed(ActionEvent e) {
	}
}
=======
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

//import net.proteanit.sql.DbUtils;

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

public class Kundenverwaltung extends JFrame {

	private JPanel contentPane;
	private JLabel vornameLabel;
	private JPanel kundendatenPanel;
	private JLabel nachnameLabel;
	private JLabel ibanLabel;
	private JLabel emailLabel;
	private JLabel telefronnummerLabel;
	private JLabel adresseLabel;
	private JTextField vornameTextField;
	private JTextField nachnameTextField;
	private JTextField ibanTextField;
	private JTextField emailTextField;
	private JTextField telefronnummerTextField;
	private JTextField adresseTextField;
	private JButton hinzufuegenButton;
	private JButton entfernenButton;
	private JButton aendernButton;
	private JTextField suchenTextField;
	private JButton suchenButton;
	private JButton schliessenButton;
	private JPanel kundenlistePanel;
	private JLabel kundenlisteLabel;
	private JTable kundenlisteTable;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kundenverwaltung frame = new Kundenverwaltung();
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
	public Kundenverwaltung() {
		initGUI();
	}

	private void initGUI() {
		setTitle("Kundenverwaltung");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				this.vornameLabel.setBounds(10, 11, 100, 14);
				this.kundendatenPanel.add(this.vornameLabel);
			}
			{
				this.nachnameLabel = new JLabel("Nachname:");
				this.nachnameLabel.setBounds(10, 36, 100, 14);
				this.kundendatenPanel.add(this.nachnameLabel);
			}
			{
				this.ibanLabel = new JLabel("IBAN:");
				this.ibanLabel.setBounds(10, 61, 100, 14);
				this.kundendatenPanel.add(this.ibanLabel);
			}
			{
				this.emailLabel = new JLabel("Email:");
				this.emailLabel.setBounds(10, 86, 100, 14);
				this.kundendatenPanel.add(this.emailLabel);
			}
			{
				this.telefronnummerLabel = new JLabel("Telefonnummer:");
				this.telefronnummerLabel.setBounds(10, 111, 100, 14);
				this.kundendatenPanel.add(this.telefronnummerLabel);
			}
			{
				this.adresseLabel = new JLabel("Adresse:");
				this.adresseLabel.setBounds(10, 136, 100, 14);
				this.kundendatenPanel.add(this.adresseLabel);
			}
			{
				this.vornameTextField = new JTextField();
				this.vornameTextField.setEditable(false);
				this.vornameTextField.setBounds(120, 8, 190, 20);
				this.kundendatenPanel.add(this.vornameTextField);
				this.vornameTextField.setColumns(10);
			}
			{
				this.nachnameTextField = new JTextField();
				this.nachnameTextField.setEditable(false);
				this.nachnameTextField.setColumns(10);
				this.nachnameTextField.setBounds(120, 33, 190, 20);
				this.kundendatenPanel.add(this.nachnameTextField);
			}
			{
				this.ibanTextField = new JTextField();
				this.ibanTextField.setEditable(false);
				this.ibanTextField.setColumns(10);
				this.ibanTextField.setBounds(120, 58, 190, 20);
				this.kundendatenPanel.add(this.ibanTextField);
			}
			{
				this.emailTextField = new JTextField();
				this.emailTextField.setEditable(false);
				this.emailTextField.setColumns(10);
				this.emailTextField.setBounds(120, 83, 190, 20);
				this.kundendatenPanel.add(this.emailTextField);
			}
			{
				this.telefronnummerTextField = new JTextField();
				this.telefronnummerTextField.setEditable(false);
				this.telefronnummerTextField.setColumns(10);
				this.telefronnummerTextField.setBounds(120, 108, 190, 20);
				this.kundendatenPanel.add(this.telefronnummerTextField);
			}
			{
				this.adresseTextField = new JTextField();
				this.adresseTextField.setEditable(false);
				this.adresseTextField.setColumns(10);
				this.adresseTextField.setBounds(120, 133, 190, 20);
				this.kundendatenPanel.add(this.adresseTextField);
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
				this.entfernenButton.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {
						do_entfernenButton_actionPerformed(e);
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
		}
		{
			this.suchenTextField = new JTextField();
			suchenTextField.setBounds(340, 11, 284, 20);
			this.contentPane.add(this.suchenTextField);
			this.suchenTextField.setColumns(10);
		}
		{
			this.suchenButton = new JButton("Suchen");
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
				this.kundenlisteTable
						.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Vorname", "Nachname" }));
				this.kundenlisteTable.getColumnModel().getColumn(0).setPreferredWidth(90);
				this.kundenlisteTable.getColumnModel().getColumn(1).setPreferredWidth(90);
				this.kundenlisteTable.setBounds(10, 11, 264, 228);
				this.kundenlistePanel.add(this.kundenlisteTable);
			}
			{
				this.scrollPane = new JScrollPane(kundenlisteTable);
				this.scrollPane.setBounds(0, 0, 284, 250);
				this.kundenlistePanel.add(this.scrollPane);
			}
		}
	{
		this.kundenlisteLabel = new JLabel("Kundenliste:");
		kundenlisteLabel.setBounds(340, 51, 185, 14);
		this.contentPane.add(this.kundenlisteLabel);
	}
	
	JButton zurueckgebenButton = new JButton("Zur\u00FCckgeben");
	zurueckgebenButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ZurueckgebenFenster.main(null);
		}
	});
	zurueckgebenButton.setBounds(350, 327, 107, 23);
	contentPane.add(zurueckgebenButton);
	}

	protected void do_aendernButton_actionPerformed(ActionEvent arg0) {
	}

	protected void do_schliessenButton_actionPerformed(ActionEvent e) {
		System.exit(1);
	}

	protected void do_suchenButton_actionPerformed(ActionEvent e) throws ClassNotFoundException {
		ResultSet rs = KundenverwaltungDAO.selectKunde(suchenTextField.getText());
		//this.kundenlisteTable.setModel(DbUtils.resultSetToTableModel(rs));

		KundeInTabelleAuswaehlen kundeAuswaehlen = new KundeInTabelleAuswaehlen(kundenlisteTable);
	}

	protected void do_hinzufuegenButton_actionPerformed(ActionEvent e) {
	}

	protected void do_entfernenButton_actionPerformed(ActionEvent e) {
	}
}
>>>>>>> 210b9c96296de825c737a89edf86a3c4b0a4d511
