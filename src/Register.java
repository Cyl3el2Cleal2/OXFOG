import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Register {

	private JFrame frmOxRegister;
	private JPasswordField passwordField;
	private JTextField textUser;
	private JPasswordField passwordFieldRe;
	private JTextField textEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
					window.frmOxRegister.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOxRegister = new JFrame();
		frmOxRegister.setResizable(false);
		frmOxRegister.setTitle("OX - Register");
		frmOxRegister.setBounds(100, 100, 800, 600);
		frmOxRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOxRegister.getContentPane().setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(250, 343, 185, 20);
		frmOxRegister.getContentPane().add(passwordField);
		
		textUser = new JTextField();
		textUser.setBounds(250, 282, 185, 20);
		frmOxRegister.getContentPane().add(textUser);
		textUser.setColumns(10);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setBounds(143, 285, 86, 14);
		frmOxRegister.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(143, 346, 86, 14);
		frmOxRegister.getContentPane().add(lblPassword);
		
		JButton btnNewButton = new JButton("CLEAR");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textEmail.setText("");
				textUser.setText("");
				passwordField.setText("");
				passwordFieldRe.setText("");
			}
		});
		btnNewButton.setBounds(250, 432, 89, 23);
		frmOxRegister.getContentPane().add(btnNewButton);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new connect().InsertUser(textUser.getText(), passwordField.getText(), textEmail.getText());
				
			}
		});
		btnRegister.setBounds(349, 432, 89, 23);
		frmOxRegister.getContentPane().add(btnRegister);
		
		passwordFieldRe = new JPasswordField();
		passwordFieldRe.setBounds(250, 373, 185, 20);
		frmOxRegister.getContentPane().add(passwordFieldRe);
		
		JLabel lblRepassword = new JLabel("RE-PASSWORD");
		lblRepassword.setBounds(143, 376, 86, 14);
		frmOxRegister.getContentPane().add(lblRepassword);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(250, 313, 185, 20);
		frmOxRegister.getContentPane().add(textEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(143, 316, 86, 14);
		frmOxRegister.getContentPane().add(lblEmail);
	}
}
