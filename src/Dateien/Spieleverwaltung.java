package Dateien;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Spieleverwaltung extends JFrame {

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
	private JTextField verfuegbarkeitTextField;
	private JTextField spielzeitTextField;
	private JTextField spracheTextField;
	private JButton hinzufuegenButton;
	private JButton entfernenButton;
	private JButton aendernButton;
	private JTextField suchenTextField;
	private JButton suchenButton;
	private JButton schliessenButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Spieleverwaltung frame = new Spieleverwaltung();
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
	public Spieleverwaltung() {
		initGUI();
	}
	private void initGUI() {
		setTitle("Spieleverwaltung");
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
				this.titelTextField.setBounds(120, 8, 190, 20);
				this.panel.add(this.titelTextField);
				this.titelTextField.setColumns(10);
			}
			{
				this.preisTextField = new JTextField();
				this.preisTextField.setColumns(10);
				this.preisTextField.setBounds(120, 33, 190, 20);
				this.panel.add(this.preisTextField);
			}
			{
				this.releaseDatumTextField = new JTextField();
				this.releaseDatumTextField.setColumns(10);
				this.releaseDatumTextField.setBounds(120, 58, 190, 20);
				this.panel.add(this.releaseDatumTextField);
			}
			{
				this.genreTextField = new JTextField();
				this.genreTextField.setColumns(10);
				this.genreTextField.setBounds(120, 83, 190, 20);
				this.panel.add(this.genreTextField);
			}
			{
				this.uskFreigabeTextField = new JTextField();
				this.uskFreigabeTextField.setColumns(10);
				this.uskFreigabeTextField.setBounds(120, 108, 190, 20);
				this.panel.add(this.uskFreigabeTextField);
			}
			{
				this.lageranzahlTextField = new JTextField();
				this.lageranzahlTextField.setColumns(10);
				this.lageranzahlTextField.setBounds(120, 133, 190, 20);
				this.panel.add(this.lageranzahlTextField);
			}
			{
				this.verfuegbarkeitTextField = new JTextField();
				this.verfuegbarkeitTextField.setColumns(10);
				this.verfuegbarkeitTextField.setBounds(120, 158, 190, 20);
				this.panel.add(this.verfuegbarkeitTextField);
			}
			{
				this.spielzeitTextField = new JTextField();
				this.spielzeitTextField.setColumns(10);
				this.spielzeitTextField.setBounds(120, 183, 190, 20);
				this.panel.add(this.spielzeitTextField);
			}
			{
				this.spracheTextField = new JTextField();
				this.spracheTextField.setColumns(10);
				this.spracheTextField.setBounds(120, 208, 190, 20);
				this.panel.add(this.spracheTextField);
			}
			{
				this.hinzufuegenButton = new JButton("Hinzuf\u00FCgen");
				this.hinzufuegenButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_hinzufuegenButton_actionPerformed(e);
					}
				});
				this.hinzufuegenButton.setBounds(10, 305, 98, 23);
				this.panel.add(this.hinzufuegenButton);
			}
			{
				this.entfernenButton = new JButton("Entfernen");
				this.entfernenButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_entfernenButton_actionPerformed(e);
					}
				});
				this.entfernenButton.setBounds(212, 305, 98, 23);
				this.panel.add(this.entfernenButton);
			}
			{
				this.aendernButton = new JButton("\u00C4ndern");
				this.aendernButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_aendernButton_actionPerformed(e);
					}
				});
				this.aendernButton.setBounds(120, 305, 82, 23);
				this.panel.add(this.aendernButton);
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
				public void actionPerformed(ActionEvent e) {
					do_suchenButton_actionPerformed(e);
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
	}

	protected void do_suchenButton_actionPerformed(ActionEvent e) {
	}
	protected void do_hinzufuegenButton_actionPerformed(ActionEvent e) {
	}
	protected void do_schliessenButton_actionPerformed(ActionEvent e) {
		System.exit(1);
	}
	protected void do_entfernenButton_actionPerformed(ActionEvent e) {
	}
	protected void do_aendernButton_actionPerformed(ActionEvent e) {
	}
}
