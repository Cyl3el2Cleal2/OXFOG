package org.eclipse.wb.swt;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import org.eclipse.swt.widgets.MessageBox;

import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class reg {

	private JFrame frame;
	private JTextField usernameBox;
	private JTextField emailBox;
	private JPasswordField passwordBox;
	private JPasswordField repasswordBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reg window = new reg();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public reg() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 204, 204));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 0, 204));
		panel.setBounds(0, 0, 683, 764);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		usernameBox = new JTextField();
		usernameBox.setForeground(new Color(255, 255, 255));
		usernameBox.setBackground(new Color(153, 0, 204));
		usernameBox.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		usernameBox.setCaretColor(new Color(255, 255, 255));
		usernameBox.setBounds(new Rectangle(9, 0, 5, 0));
		usernameBox.setBounds(214, 149, 215, 39);
		panel.add(usernameBox);
		usernameBox.setColumns(10);
		
		emailBox = new JTextField();
		emailBox.setForeground(new Color(255, 255, 255));
		emailBox.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		emailBox.setBackground(new Color(153, 0, 204));
		emailBox.setColumns(10);
		emailBox.setCaretColor(new Color(255, 255, 255));
		emailBox.setBounds(new Rectangle(9, 0, 5, 0));
		emailBox.setBounds(214, 217, 215, 39);
		panel.add(emailBox);
		
		JButton insertButton = new JButton("OK");
		insertButton.setBorder(new LineBorder(new Color(51, 255, 51), 20, true));
		insertButton.setForeground(new Color(0, 0, 0));
		insertButton.setBorderPainted(false);
		insertButton.setBackground(new Color(153, 255, 102));
		insertButton.addActionListener(new ActionListener() {
			public void mouseClicked(MouseEvent e) {
				
				
			}
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(passwordBox.getText().equals(repasswordBox.getText())){
					
				new connect().InsertUser(usernameBox.getText(), passwordBox.getText(), emailBox.getText());
				JOptionPane.showMessageDialog(null, "Registion Succeeded");
			}else{
				JOptionPane.showMessageDialog(null, "Registion Please check your password.");
			}
				
			}
			
		});
		insertButton.setBounds(340, 473, 89, 23);
		panel.add(insertButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBorderPainted(false);
		cancelButton.setBackground(new Color(255, 0, 51));
		cancelButton.setBorder(new LineBorder(new Color(255, 0, 102), 15, true));
		cancelButton.setBounds(214, 473, 89, 23);
		panel.add(cancelButton);
		
		passwordBox = new JPasswordField();
		passwordBox.setForeground(new Color(255, 255, 255));
		passwordBox.setBackground(new Color(153, 0, 204));
		passwordBox.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		passwordBox.setBounds(214, 288, 215, 39);
		panel.add(passwordBox);
		
		repasswordBox = new JPasswordField();
		repasswordBox.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		repasswordBox.setBackground(new Color(153, 0, 204));
		repasswordBox.setCaretColor(new Color(255, 255, 255));
		repasswordBox.setForeground(new Color(255, 255, 255));
		repasswordBox.setBounds(214, 353, 215, 39);
		panel.add(repasswordBox);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setIcon(null);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("TH SarabunPSK", Font.PLAIN, 20));
		lblNewLabel.setBounds(123, 153, 72, 27);
		panel.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("TH SarabunPSK", Font.PLAIN, 20));
		lblEmail.setBounds(123, 221, 72, 27);
		panel.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("TH SarabunPSK", Font.PLAIN, 20));
		lblPassword.setBounds(123, 292, 72, 27);
		panel.add(lblPassword);
		
		JLabel lblRepassword = new JLabel("Re-Password");
		lblRepassword.setForeground(new Color(255, 255, 255));
		lblRepassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblRepassword.setFont(new Font("TH SarabunPSK", Font.PLAIN, 20));
		lblRepassword.setBounds(87, 357, 117, 27);
		panel.add(lblRepassword);
		frame.setBounds(100, 100, 699, 803);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
