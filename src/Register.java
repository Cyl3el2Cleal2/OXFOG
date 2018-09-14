import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.mongodb.DBCollection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Register {

	private JFrame frame;
	private JTextField id;
	private JTextField em;
	private JPasswordField pw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 743, 413);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		id = new JTextField();
		id.setBounds(212, 92, 328, 25);
		frame.getContentPane().add(id);
		id.setColumns(10);
		
		em = new JTextField();
		em.setColumns(10);
		em.setBounds(212, 190, 328, 25);
		frame.getContentPane().add(em);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(98, 82, 104, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPasswords = new JLabel("Passwords :");
		lblPasswords.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPasswords.setBounds(98, 130, 104, 39);
		frame.getContentPane().add(lblPasswords);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEmail.setBounds(98, 180, 104, 39);
		frame.getContentPane().add(lblEmail);
		
		JButton btnNewButton = new JButton("CLEAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setText("");
				pw.setText("");
				em.setText("");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(137, 270, 178, 56);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!id.getText().equals("")&&!pw.getPassword().equals("")&&!em.getText().equals("")) {
					
				new connect().InsertUser(id.getText(),new String(pw.getPassword()), em.getText());
					}else{
						JOptionPane.showMessageDialog(null, "กรุณากรอกข้อมูลให้ครบด้วยครับ", "เกิดข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
		
							}
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRegister.setBounds(397, 270, 178, 56);
		frame.getContentPane().add(btnRegister);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblRegister.setBounds(269, 11, 338, 63);
		frame.getContentPane().add(lblRegister);
		
		pw = new JPasswordField();
		pw.setBounds(212, 142, 328, 27);
		frame.getContentPane().add(pw);
	}
}
