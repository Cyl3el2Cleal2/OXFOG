import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Register {
	File imageFile;

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
		frmOxRegister.getContentPane().setBackground(new Color(255, 255, 204));
		frmOxRegister.setResizable(false);
		frmOxRegister.setTitle("OX - Register");
		frmOxRegister.setBounds(100, 100, 800, 600);
		frmOxRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOxRegister.getContentPane().setLayout(null);
		DB db = new connect().getConnect();
		JLabel jPhoto = new javax.swing.JLabel();
		jPhoto.setBounds(273, 47, 220, 220);
		frmOxRegister.getContentPane().add(jPhoto);
		passwordField = new JPasswordField();
		passwordField.setBounds(290, 380, 185, 20);
		frmOxRegister.getContentPane().add(passwordField);

	
		
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setBounds(183, 322, 86, 14);
		frmOxRegister.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(183, 383, 86, 14);
		frmOxRegister.getContentPane().add(lblPassword);
		
		JButton btnNewButton = new JButton("CLEAR");
		
		JLabel lbAlert = new JLabel("This user is already exited.");
		lbAlert.setBounds(485, 322, 156, 14);
		lbAlert.setVisible(false);
		frmOxRegister.getContentPane().add(lbAlert);

		textUser = new JTextField();
		frmOxRegister.getContentPane().add(textUser);
		textUser.setBounds(290, 319, 185, 20);
		textUser.setVisible(true);
		textUser.setColumns(10);
	
			
			
				
				
			
			
	
		
	
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textEmail.setText("");
				textUser.setText("");
				passwordField.setText("");
				passwordFieldRe.setText("");
			}
		});
		btnNewButton.setBounds(290, 469, 89, 23);
		frmOxRegister.getContentPane().add(btnNewButton);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!passwordField.getText().equals(passwordFieldRe.getText())) {
					JOptionPane.showMessageDialog(null, "Please enter same password");
					return;
				}
				if(textEmail.getText().equals("") || textEmail.getText() == null) {
					JOptionPane.showMessageDialog(null, "Please enter email");
					return;
				}
				if(passwordField.getText() == null || passwordField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter password");
					return;
				}
	DBCollection coll = db.getCollection("USER");
				
	BasicDBObject whereQuery = new BasicDBObject();
	whereQuery.put("USERNAME", textUser.getText());
				if(coll.find(whereQuery).count()>0) {
					
					lbAlert.setVisible(true);
				}else {
					lbAlert.setVisible(false);
					GridFS gfsPhoto = new GridFS(new connect().getConnect(), "photo");
					GridFSInputFile gfsFile;
					try {
						gfsFile = gfsPhoto.createFile(imageFile);
						gfsFile.setFilename(textUser.getText());
						gfsFile.save();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Please Select profile picture");
						return;
					}
					
					new connect().InsertUser(textUser.getText(), passwordField.getText(), textEmail.getText());
				}
				
				
				
				
			}
		});
		btnRegister.setBounds(389, 469, 89, 23);
		frmOxRegister.getContentPane().add(btnRegister);
		
		passwordFieldRe = new JPasswordField();
		passwordFieldRe.setBounds(290, 410, 185, 20);
		frmOxRegister.getContentPane().add(passwordFieldRe);
		
		JLabel lblRepassword = new JLabel("RE-PASSWORD");
		lblRepassword.setBounds(183, 413, 86, 14);
		frmOxRegister.getContentPane().add(lblRepassword);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(290, 350, 185, 20);
		frmOxRegister.getContentPane().add(textEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(183, 353, 86, 14);
		frmOxRegister.getContentPane().add(lblEmail);
		JButton btnNewButton_1 = new JButton("Upload");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
				fc.addChoosableFileFilter(filter);
				fc.setFileFilter(filter);
				
				//In response to a button click:
				int returnVal = fc.showOpenDialog(fc);
				
				
				if(returnVal == JFileChooser.APPROVE_OPTION){
					imageFile = new File(fc.getSelectedFile().getPath());
					jPhoto.setIcon(new javax.swing.ImageIcon(imageFile.getAbsolutePath())); 
					
		          }
			}
		});
		btnNewButton_1.setBounds(290, 285, 89, 23);
		frmOxRegister.getContentPane().add(btnNewButton_1);
		
		
	}
}
