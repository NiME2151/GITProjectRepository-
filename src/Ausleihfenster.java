import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

public class Ausleihfenster extends JFrame {

	private JPanel contentPane;
	private JTextField kundensucheTextField;
	private JButton suchenButton;
	private JPanel kundenlistePanel;
	private JLabel kundenlisteLabel;
	private JTable kundenlisteTable;
	private JScrollPane scrollPane;
	private JButton kundenAnlegenButton;
	private JLabel leihdauerInTagenLabel;
	private JTextField leihdauerInTagenTextField;
	private JLabel ausleihpreisLabel;
	private JTextField ausleihpreisTextField;
	private double ausleihpreis;
	private double gesamtausleihpreis;
	private JLabel ausleihmengeLabel;
	private JTextField ausleihmengeTextField;	
	private JButton preisBerechnenButton;
	private Spiel spiel;
		
	String pattern = "#0.00";
	DecimalFormat df = new DecimalFormat(pattern);

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	
	public Ausleihfenster(Spiel spiel)  {
		this.spiel = spiel;
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		contentPane.setLayout(null);
		{
			this.kundensucheTextField = new JTextField();
			kundensucheTextField.setBounds(155, 11, 320, 20);
			this.contentPane.add(this.kundensucheTextField);
			this.kundensucheTextField.setColumns(10);
		}
		{
			this.suchenButton = new JButton("Suchen");
			suchenButton.setBounds(485, 10, 89, 23);
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
			this.kundenlistePanel = new JPanel();
			kundenlistePanel.setBounds(10, 61, 284, 290);
			this.kundenlistePanel.setLayout(null);
			this.kundenlistePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
			this.contentPane.add(this.kundenlistePanel);
			{
				this.kundenlisteTable = new JTable();
				this.kundenlisteTable.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Vorname", "Nachname"
					}
				) {
					boolean[] columnEditables = new boolean[] {
						false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				this.kundenlisteTable.getColumnModel().getColumn(0).setResizable(false);
				this.kundenlisteTable.getColumnModel().getColumn(1).setResizable(false);
				this.kundenlisteTable.setBounds(10, 11, 264, 268);
				this.kundenlistePanel.add(this.kundenlisteTable);
			}
			{
				this.scrollPane = new JScrollPane(kundenlisteTable);
				this.scrollPane.setBounds(0, 0, 284, 290);
				this.kundenlistePanel.add(this.scrollPane);
			}
		}
		{
			this.kundenlisteLabel = new JLabel("Kundenliste:");
			kundenlisteLabel.setBounds(10, 42, 185, 14);
			this.contentPane.add(this.kundenlisteLabel);
		}
		{
			this.kundenAnlegenButton = new JButton("Kunden anlegen");
			kundenAnlegenButton.setBounds(10, 10, 135, 23);
			this.kundenAnlegenButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					do_kundeAnlegenButton_actionPerformed(arg0);
				}
			});
			this.contentPane.add(this.kundenAnlegenButton);
		}
		{
			this.leihdauerInTagenLabel = new JLabel("Leihdauer (in Tagen):");
			leihdauerInTagenLabel.setBounds(304, 61, 171, 14);
			this.contentPane.add(this.leihdauerInTagenLabel);
		}
		{
			this.leihdauerInTagenTextField = new JTextField();
			leihdauerInTagenTextField.setBounds(485, 58, 89, 20);
			this.contentPane.add(this.leihdauerInTagenTextField);
			this.leihdauerInTagenTextField.setColumns(10);
		}
		{
			this.ausleihpreisLabel = new JLabel("Ausleihpreis:");
			ausleihpreisLabel.setBounds(304, 148, 171, 14);
			this.contentPane.add(this.ausleihpreisLabel);
		}
		{
			this.ausleihpreisTextField = new JTextField();
			ausleihpreisTextField.setBounds(485, 145, 89, 20);
			this.contentPane.add(this.ausleihpreisTextField);
			this.ausleihpreisTextField.setColumns(10);
		}
		{
			this.ausleihmengeLabel = new JLabel("Ausleihmenge:");
			ausleihmengeLabel.setBounds(304, 86, 171, 14);
			this.contentPane.add(this.ausleihmengeLabel);
		}
		{
			this.ausleihmengeTextField = new JTextField();
			ausleihmengeTextField.setBounds(485, 83, 89, 20);
			this.contentPane.add(this.ausleihmengeTextField);
			this.ausleihmengeTextField.setColumns(10);
		}
		{
			this.preisBerechnenButton = new JButton("Preis berechnen");
			preisBerechnenButton.setBounds(370, 111, 135, 23);
			this.preisBerechnenButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_preisBerechnenButton_actionPerformed(e);
				}
			});
			this.contentPane.add(this.preisBerechnenButton);
		}
	}
	protected void do_suchenButton_actionPerformed(ActionEvent e) throws ClassNotFoundException {
		ResultSet rs = KundenverwaltungDAO.selectKunde(kundensucheTextField.getText());
		this.kundenlisteTable.setModel(DbUtils.resultSetToTableModel(rs));

		KundeInTabelleAuswaehlen kundeAuswaehlen = new KundeInTabelleAuswaehlen(kundenlisteTable);
	}
	protected void do_kundeAnlegenButton_actionPerformed(ActionEvent arg0) {
		Kundenverwaltung.main(null);
	}
	protected void do_preisBerechnenButton_actionPerformed(ActionEvent e) {
		// ausleihpreis muss noch vom Spieledetailfenster geholt werden
		this.ausleihpreis = Double.valueOf(spiel.getPreis());
		this.gesamtausleihpreis = (Double.valueOf(this.leihdauerInTagenTextField.getText()) + ausleihpreis);
		this.gesamtausleihpreis = this.gesamtausleihpreis * Double.valueOf(this.ausleihmengeTextField.getText());
		this.ausleihpreisTextField.setText(String.valueOf(this.df.format(this.gesamtausleihpreis).replace('.', ',')) + " EUR");
	}
}
