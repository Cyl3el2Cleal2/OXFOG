package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

import org.bson.Document;

import com.mongodb.MongoTimeoutException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import javax.swing.JPasswordField;
import java.awt.Color;

import mongo_connector.dbmanage;

public class Register {

	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JPasswordField passwordConfirmField;

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
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setTitle("\u0E2A\u0E21\u0E31\u0E04\u0E23\u0E2A\u0E21\u0E32\u0E0A\u0E34\u0E01");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel label = new JLabel("\u0E23\u0E2B\u0E31\u0E2A\u0E1C\u0E48\u0E32\u0E19");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(85, 85, 64, 34);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u0E22\u0E37\u0E19\u0E22\u0E31\u0E19\u0E23\u0E2B\u0E31\u0E2A\u0E1C\u0E48\u0E32\u0E19");
		label_1.setForeground(Color.BLACK);
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(43, 130, 110, 34);
		frame.getContentPane().add(label_1);
		
		JButton confirmButton = new JButton("\u0E22\u0E37\u0E19\u0E22\u0E31\u0E19");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pattern pettern = Pattern.compile("[$&+,:;=?@#|'<>.^*()%!\\/-]");
				Matcher matcher = pettern.matcher(usernameField.getText());
				
				if (usernameField.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(frame, "กรุณาใส่ username!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else if (usernameField.getText().length() > 12 || usernameField.getText().length() < 6)
				{
					JOptionPane.showMessageDialog(frame, "ยูเซอร์เนมต้องมีความยาวระหว่าง 6-12 ตัวอักษร", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else if (matcher.find(0))
				{
					JOptionPane.showMessageDialog(frame, "ห้ามใช้อักขระพิเศษ", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				matcher = pettern.matcher(new String(passwordField.getPassword()));
				
				if (passwordField.getPassword().length == 0)
				{
					JOptionPane.showMessageDialog(frame, "กรุณาใส่ password!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else if (passwordField.getPassword().length > 12 || passwordField.getPassword().length < 6)
				{
					JOptionPane.showMessageDialog(frame, "พาสเวิร์ดต้องมีความยาวระหว่าง 6-12 ตัวอักษร", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else if (matcher.find(0))
				{
					JOptionPane.showMessageDialog(frame, "ห้ามใช้อักขระพิเศษ", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else if (!new String(passwordField.getPassword()).equals(new String(passwordConfirmField.getPassword())))
				{
					JOptionPane.showMessageDialog(frame, "รหัสผ่านไม่ตรงกัน", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else
				{
					//duplicate check
					dbmanage.getConnect();
					MongoDatabase db = dbmanage.getDatabase();
					MongoCollection<Document> table = db.getCollection("USER");
					
					Document document = new Document();
					document.append("username", usernameField.getText());
					
					try (MongoCursor<Document> cursor = table.find(document).iterator()) 
					{
						Document userdata = cursor.next();
						if (userdata.getString("username").equals(usernameField.getText())) {
							JOptionPane.showMessageDialog(frame, "ยูเซอร์เนมมีคนใช้แล้ว", "Error", JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					catch (MongoTimeoutException e2) 
					{
						System.out.println("mongodb timeout");
					}
					catch (NoSuchElementException e2) 
					{
						document = new Document();
						document.append("username", usernameField.getText());
						document.append("password",new String( passwordField.getPassword()));
						
						table.insertOne(document);
					}
				}
			}
		});
		confirmButton.setFont(new Font("Leelawadee UI", Font.PLAIN, 14));
		confirmButton.setBounds(160, 210, 106, 34);
		frame.getContentPane().add(confirmButton);
		
		JButton cancelButton = new JButton("\u0E22\u0E01\u0E40\u0E25\u0E34\u0E01");
		cancelButton.setFont(new Font("Leelawadee UI", Font.PLAIN, 14));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		cancelButton.setBounds(287, 210, 106, 34);
		frame.getContentPane().add(cancelButton);
		
		JLabel label_2 = new JLabel("\u0E0A\u0E37\u0E48\u0E2D\u0E1C\u0E39\u0E49\u0E43\u0E0A\u0E49");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setBounds(94, 40, 55, 34);
		frame.getContentPane().add(label_2);
		
		usernameField = new JTextField();
		usernameField.setColumns(10);
		usernameField.setBounds(159, 40, 234, 34);
		frame.getContentPane().add(usernameField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(159, 85, 234, 34);
		frame.getContentPane().add(passwordField);
		
		passwordConfirmField = new JPasswordField();
		passwordConfirmField.setBounds(159, 130, 234, 34);
		frame.getContentPane().add(passwordConfirmField);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 203, 434, 47);
		frame.getContentPane().add(panel);
	}
}
