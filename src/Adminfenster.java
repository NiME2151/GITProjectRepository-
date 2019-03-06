import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Adminfenster extends JFrame {

	private JPanel contentPane;
	private JLabel idLabel;
	private JLabel passwortLabel;
	private JTextField idTextField;
	private JTextField passwortTextField;
	private JButton einloggButton;
	private String adminId = "8954";
	private String adminPasswort = "saU2sG";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminfenster frame = new Adminfenster();
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
	public Adminfenster() {
		initGUI();
	}
	private void initGUI() {
		setResizable(false);
		setTitle("Admin-Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 210, 125);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		{
			this.idLabel = new JLabel("ID:");
			this.idLabel.setBounds(10, 11, 85, 14);
			this.contentPane.add(this.idLabel);
		}
		{
			this.passwortLabel = new JLabel("Passwort:");
			this.passwortLabel.setBounds(10, 36, 85, 14);
			this.contentPane.add(this.passwortLabel);
		}
		{
			this.idTextField = new JTextField();
			this.idTextField.setBounds(105, 8, 85, 20);
			this.contentPane.add(this.idTextField);
			this.idTextField.setColumns(10);
		}
		{
			this.passwortTextField = new JTextField();
			this.passwortTextField.setColumns(10);
			this.passwortTextField.setBounds(105, 33, 85, 20);
			this.contentPane.add(this.passwortTextField);
		}
		{
			this.einloggButton = new JButton("Einloggen");
			this.einloggButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					do_einloggButton_actionPerformed(e);
				}
			});
			this.einloggButton.setBounds(60, 61, 89, 23);
			this.contentPane.add(this.einloggButton);
		}
	}
	protected void do_einloggButton_actionPerformed(ActionEvent e) {
		
	}
}
