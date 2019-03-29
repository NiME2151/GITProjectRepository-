import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Top10SpieleFenster extends JFrame {

	private JPanel contentPane;
	private final JTable topspieleTable = new JTable();
	private JScrollPane topspieleScrollPane;
	private JButton zurueckButton;
	Top10SpieleFensterDAO top10spiele = new Top10SpieleFensterDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Top10SpieleFenster frame = new Top10SpieleFenster();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Top10SpieleFenster() throws SQLException {
		initGUI();
		ResultSet rs = top10spiele.getTop10Games();
		this.topspieleTable.setModel(DbUtils.resultSetToTableModel(rs));
	}
	private void initGUI() {
		setTitle("Top-10-Spiele");
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		topspieleTable.removeEditor();
		topspieleTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Spieletitel", "Ausleihmenge", "Release"
			}
		));
		topspieleTable.setBounds(0, 0, 434, 262);
		this.contentPane.add(topspieleTable);
		{
			this.topspieleScrollPane = new JScrollPane(topspieleTable);
			this.topspieleScrollPane.setBounds(0, 0, 434, 220);
			this.contentPane.add(this.topspieleScrollPane);
		}
		{
			this.zurueckButton = new JButton("Zur\u00FCck");
			this.zurueckButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_zurueckButton_actionPerformed(e);
				}
			});
			this.zurueckButton.setBounds(335, 228, 89, 23);
			this.contentPane.add(this.zurueckButton);
		}
	}
	protected void do_zurueckButton_actionPerformed(ActionEvent e) {
		zurueckButton.setVisible(false);
		Hauptbildschirm hauptbildschirm = new Hauptbildschirm();
		hauptbildschirm.setVisible(true);
	}
}
