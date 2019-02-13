import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private double ausleihpreisProTag;
	private double gesamtausleihpreis;
	private JLabel ausleihmengeLabel;
	private JTextField ausleihmengeTextField;	
	private JButton preisBerechnenButton;
	private String spiel;
	
	SpielDAO spielDAO = new SpielDAO();
	//Spiel spiel = new Spiel();
	KundenDAO kundenDAO = new KundenDAO();
	GetWertInZeile kundeAuswaehlen = new GetWertInZeile();
	KundenSpieleDAO kundenSpieleDAO = new KundenSpieleDAO();
		
	String pattern = "#0.00";
	DecimalFormat df = new DecimalFormat(pattern);
	private JButton ausleihenButton;
	private JTextField waehrungTextField;

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	
	public Ausleihfenster(String spiel) throws ClassNotFoundException, SQLException  {
		this.spiel = spiel;
		initGUI();
	}
	private void initGUI() {
		setTitle("Ausleihfenster");
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
				this.kundenlisteTable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						do_kundenlisteTable_mouseClicked(e);
					}
				});
				this.kundenlisteTable.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"ID", "Vorname", "Nachname", "IBAN", "Strasse"
					}
				) {
					boolean[] columnEditables = new boolean[] {
						true, false, false, true
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				this.kundenlisteTable.getColumnModel().getColumn(1).setResizable(false);
				this.kundenlisteTable.getColumnModel().getColumn(2).setResizable(false);
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
			ausleihpreisTextField.setBounds(485, 145, 50, 20);
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
					try {
						do_preisBerechnenButton_actionPerformed(e);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			this.contentPane.add(this.preisBerechnenButton);
		}
		{
			this.ausleihenButton = new JButton("Ausleihen");
			this.ausleihenButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						do_ausleihenButton_actionPerformed(arg0);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			this.ausleihenButton.setBounds(370, 173, 135, 23);
			this.contentPane.add(this.ausleihenButton);
		}
		{
			this.waehrungTextField = new JTextField();
			this.waehrungTextField.setText("EUR");
			this.waehrungTextField.setEditable(false);
			this.waehrungTextField.setBounds(545, 145, 29, 20);
			this.contentPane.add(this.waehrungTextField);
			this.waehrungTextField.setColumns(10);
		}
	}
	protected void do_suchenButton_actionPerformed(ActionEvent e) throws ClassNotFoundException {
		ResultSet rs = kundenDAO.selectKundeAusleihfenster(kundensucheTextField.getText());
		this.kundenlisteTable.setModel(DbUtils.resultSetToTableModel(rs));
	}
	protected void do_kundeAnlegenButton_actionPerformed(ActionEvent arg0) {
		Kundenverwaltung.main(null);
	}
	protected void do_preisBerechnenButton_actionPerformed(ActionEvent e) throws ClassNotFoundException, SQLException {
		this.ausleihpreisProTag = Double.valueOf(getSpieleDaten(spiel).getPreis());
		this.gesamtausleihpreis = (Double.valueOf(this.leihdauerInTagenTextField.getText()) * ausleihpreisProTag);
		this.gesamtausleihpreis = this.gesamtausleihpreis * Double.valueOf(this.ausleihmengeTextField.getText());
		this.ausleihpreisTextField.setText(String.valueOf(this.df.format(this.gesamtausleihpreis).replace('.', ',')));
		System.out.println("preisRechnen: " + this.ausleihpreisTextField.getText());
	}
	protected void do_kundenlisteTable_mouseClicked(MouseEvent e) {
		String ausgewaehlterKunde = kundeAuswaehlen.getKundennachnameInTable(kundenlisteTable);
	}
	public Spiel getSpieleDaten(String ausgewaehltesSpiel) throws ClassNotFoundException, SQLException {
		Spiel spiel = spielDAO.selectSpiel(ausgewaehltesSpiel);
		return spiel;
	}
	protected void do_ausleihenButton_actionPerformed(ActionEvent arg0) throws ClassNotFoundException, SQLException, ParseException {
		KundenSpiele ks = setKundenSpieleDaten(spiel);
		kundenSpieleDAO.insertToKundenSpiele(ks);
		//String ausgewaehlterKunde = kundeAuswaehlen.getWertInZeileAusleihfenster(kundenlisteTable);
		//this.ausleihpreisTextField.getText();
	}
	
	public KundenSpiele setKundenSpieleDaten(String ausgewaehltesSpiel) throws ClassNotFoundException, SQLException, ParseException {
		System.out.println("test:" + ausgewaehltesSpiel);
		Spiel spiel = getSpieleDaten(ausgewaehltesSpiel);
		KundenSpiele kundenSpiele = new KundenSpiele();
<<<<<<< HEAD
		kundenSpiele.setId(Integer.parseInt(spiel.getId()));
=======
		kundenSpiele.setId(spiel.getId());
		System.out.println(spiel.getId());
>>>>>>> 5a650a1841cc5836412470d1a62e14b76a8057d8
		kundenSpiele.setSpieltitel(spiel.getTitel());
		kundenSpiele.setSpielRelease(spiel.getVeroeffentlichkeitsdatum());
		System.out.println("sRelease: " + kundenSpiele.getSpielRelease());
		String kundenIBAN = kundeAuswaehlen.getIBANInTable(kundenlisteTable);
		String ausgewaehlterKunde = kundeAuswaehlen.getKundennachnameInTable(kundenlisteTable);
		kundenSpiele.setKundennachname(ausgewaehlterKunde);
		kundenSpiele.setKundenIBAN(kundenIBAN);
		System.out.println("preis: " + this.ausleihpreisTextField.getText());
		kundenSpiele.setPreis(Double.valueOf(this.ausleihpreisTextField.getText().replace(',', '.')));
		kundenSpiele.setMenge(this.ausleihmengeTextField.getText());
		// gibt falschen Wert zurück. Siehe emittelFaelligkeitsdatum-Methode!
		kundenSpiele.setFaelligkeitsdatum(String.valueOf(ermittelFaelligkeitsdatum()));
		return kundenSpiele;
	}
	
	public LocalDate ermittelFaelligkeitsdatum() throws ParseException {
		// Methode funzt noch nicht!
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		int leihdauer = Integer.valueOf(this.leihdauerInTagenTextField.getText());
		LocalDate date = LocalDate.now().plusDays(leihdauer);
		/*String currentDateString = String.valueOf(localDate);
		Date currentDate = myFormat.parse(currentDateString);
	    Date faelligkeitsdatum = currentDate.getTime() + leihdauer;*/
	    System.out.println("faellig: " + date);
		return date;
	}
}
