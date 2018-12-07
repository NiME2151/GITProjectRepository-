package guis;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Ausleihfenster extends JFrame {

	private JPanel contentPane;
	private JTextField kundensucheTextField;
	private JButton suchenButton;
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
					Ausleihfenster frame = new Ausleihfenster();
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
	public Ausleihfenster() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		{
			this.kundensucheTextField = new JTextField();
			this.kundensucheTextField.setBounds(10, 11, 465, 20);
			this.contentPane.add(this.kundensucheTextField);
			this.kundensucheTextField.setColumns(10);
		}
		{
			this.suchenButton = new JButton("Suchen");
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
			this.suchenButton.setBounds(485, 10, 89, 23);
			this.contentPane.add(this.suchenButton);
		}
		{
			this.kundenlistePanel = new JPanel();
			this.kundenlistePanel.setLayout(null);
			this.kundenlistePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
			this.kundenlistePanel.setBounds(10, 61, 284, 290);
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
			this.kundenlisteLabel.setBounds(10, 42, 185, 14);
			this.contentPane.add(this.kundenlisteLabel);
		}
	}
	protected void do_suchenButton_actionPerformed(ActionEvent e) throws ClassNotFoundException {
		ResultSet rs=DBVerbindungHerstellen.getResultSetForKundenName(kundensucheTextField.getText());
		this.kundenlisteTable.setModel(DbUtils.resultSetToTableModel(rs));

		KundeInTabelleAuswaehlen kundeAuswaehlen = new KundeInTabelleAuswaehlen(kundenlisteTable);
	}
}
