import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Hilfefenster extends JFrame {

	private JPanel contentPane;
	private JLabel ueberschriftLabel;
	private JButton ausleihfensterButton;
	private JButton hauptbildschirmButton;
	private JButton kundenverwaltungButton;
	private JButton spieleverwaltungButton;
	private JButton spieledetailfensterButton;
	private JButton zurueckgebenfensterButton;
	private JPanel menuePane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hilfefenster frame = new Hilfefenster();
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
	public Hilfefenster() {
		initGUI();
	}
	private void initGUI() {
		setTitle("Hilfefenster");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		{
			this.menuePane = new JPanel();
			this.menuePane.setBounds(0, 0, 684, 412);
			this.contentPane.add(this.menuePane);
			this.menuePane.setLayout(null);
			{
				this.ueberschriftLabel = new JLabel("Hier finden Sie Hilfe zu folgenden Fenstern:");
				this.ueberschriftLabel.setBounds(10, 11, 280, 14);
				this.menuePane.add(this.ueberschriftLabel);
			}
			{
				this.ausleihfensterButton = new JButton("Ausleihfenster");
				this.ausleihfensterButton.setBounds(10, 35, 150, 23);
				this.menuePane.add(this.ausleihfensterButton);
				{
					this.hauptbildschirmButton = new JButton("Hauptbildschirm");
					this.hauptbildschirmButton.setBounds(10, 75, 150, 23);
					this.menuePane.add(this.hauptbildschirmButton);
					{
						this.kundenverwaltungButton = new JButton("Kundenverwaltung");
						this.kundenverwaltungButton.setBounds(10, 115, 150, 23);
						this.menuePane.add(this.kundenverwaltungButton);
						{
							this.spieleverwaltungButton = new JButton("Spieleverwaltung");
							this.spieleverwaltungButton.setBounds(10, 155, 150, 23);
							this.menuePane.add(this.spieleverwaltungButton);
							{
								this.spieledetailfensterButton = new JButton("Spieledetailfenster");
								this.spieledetailfensterButton.setBounds(10, 195, 150, 23);
								this.menuePane.add(this.spieledetailfensterButton);
								{
									this.zurueckgebenfensterButton = new JButton("Zur\u00FCckgebenfenster");
									this.zurueckgebenfensterButton.setBounds(10, 235, 150, 23);
									this.menuePane.add(this.zurueckgebenfensterButton);
									this.zurueckgebenfensterButton.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											do_zurueckgebenfensterButton_actionPerformed(e);
										}
									});
								}
								this.spieledetailfensterButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										do_spieledetailfensterButton_actionPerformed(e);
									}
								});
							}
							this.spieleverwaltungButton.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									do_spieleverwaltungButton_actionPerformed(e);
								}
							});
						}
						this.kundenverwaltungButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								do_kundenverwaltungButton_actionPerformed(e);
							}
						});
					}
					this.hauptbildschirmButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							do_hauptbildschirmButton_actionPerformed(e);
						}
					});
				}
				this.ausleihfensterButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						do_ausleihfensterButton_actionPerformed(e);
					}
				});
			}
		}
	}
	protected void do_spieledetailfensterButton_actionPerformed(ActionEvent e) {
	}
	protected void do_kundenverwaltungButton_actionPerformed(ActionEvent e) {
	}
	protected void do_ausleihfensterButton_actionPerformed(ActionEvent e) {
	}
	protected void do_hauptbildschirmButton_actionPerformed(ActionEvent e) {
	}
	protected void do_zurueckgebenfensterButton_actionPerformed(ActionEvent e) {
	}
	protected void do_spieleverwaltungButton_actionPerformed(ActionEvent e) {
	}
}
