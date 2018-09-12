import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.mongodb.Mongo;
import com.sun.prism.Image;
import java.awt.Color;
import javax.swing.SwingConstants;

import org.eclipse.osgi.internal.signedcontent.Base64;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.UIManager;


public class OXGameRegister {

	private JFrame frame;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JPasswordField txtRepass;
	static MongoDb mongo;
	static String filename=".\\img\\komate.png";
	static File f=null;
	static ImageIcon img;
	private final Action action = new SwingAction();
	static String encodstring;
	private JTextField txtEmail;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OXGameRegister window = new OXGameRegister();
					window.frame.setVisible(true);
					
					mongo=new MongoDb();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OXGameRegister() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setLocation(new Point(1500, 1500));
		frame.setResizable(false);
		frame.setLocationByPlatform(true);
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.getContentPane().setLayout(null);
		frame.setBackground(new Color(0, 0, 0));
		frame.setSize(new Dimension(800, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(323, 107, 183, 81);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPassword.setBounds(323, 190, 183, 81);
		frame.getContentPane().add(lblPassword);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUser.setBounds(518, 134, 193, 29);
		frame.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblRepassword = new JLabel("Re-Password:");
		lblRepassword.setForeground(Color.WHITE);
		lblRepassword.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblRepassword.setBounds(323, 279, 183, 81);
		frame.getContentPane().add(lblRepassword);
		
		JButton btnSummit = new JButton("Summit");
		btnSummit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=txtUser.getText();
				String password=new String(txtPass.getPassword());
				String Repassword=new String(txtRepass.getPassword());
				
				if(username.equals("")) {
					JOptionPane.showMessageDialog(null, "��سһ�͹ Username");
					return;
				}
				if(password.equals("")) {
					JOptionPane.showMessageDialog(null, "��سһ�͹ Password");
					return;
				}
				if(Repassword.equals(""))  {
					JOptionPane.showMessageDialog(null, "��سһ�͹ Re-Password");
					return;
				}
				if(txtEmail.getText().equals(""))  {
					JOptionPane.showMessageDialog(null, "��سһ�͹  Email");
					return;
				}
				if(f==null) {
					JOptionPane.showMessageDialog(null, "��س�����Ҿ");
					return;
				}
				if(password.length()<8) { 
					JOptionPane.showMessageDialog(null, "��سһ�͹ Password 8 ���");
					return;
				}
				
				if(!Repassword.equals(password)) { 
					JOptionPane.showMessageDialog(null, "��سһ�͹ Password ���ç�ѹ");
					return;
				}
				
				if(mongo.addMember(username, password,encodstring,txtEmail.getText())) {
					JOptionPane.showMessageDialog(null, "Username ���!!");
					return;
				}
				JOptionPane.showMessageDialog(null, "����� Your Username: "+txtUser.getText());

			}
		});
		btnSummit.setAlignmentY(Component.TOP_ALIGNMENT);
		btnSummit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSummit.setForeground(new Color(0, 0, 0));
		btnSummit.setBackground(Color.GREEN);
		btnSummit.setBounds(552, 468, 123, 48);
		frame.getContentPane().add(btnSummit);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setForeground(new Color(255, 0, 102));
		lblRegister.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblRegister.setBounds(297, 29, 183, 81);
		frame.getContentPane().add(lblRegister);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBackground(new Color(255, 0, 0));
		btnBack.setAlignmentY(0.0f);
		btnBack.setBounds(390, 468, 123, 48);
		frame.getContentPane().add(btnBack);
		
		JLabel lblNewLabel_1 = new JLabel("OX");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 99));
		lblNewLabel_1.setForeground(new Color(255, 102, 0));
		lblNewLabel_1.setBounds(33, 420, 158, 119);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblGame = new JLabel("Game");
		lblGame.setForeground(new Color(255, 102, 0));
		lblGame.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 30));
		lblGame.setBounds(139, 504, 103, 48);
		frame.getContentPane().add(lblGame);
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPass.setBounds(518, 217, 193, 29);
		frame.getContentPane().add(txtPass);
		
		txtRepass = new JPasswordField();
		txtRepass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtRepass.setBounds(518, 306, 193, 29);
		frame.getContentPane().add(txtRepass);
		
		JLabel picture = new JLabel("");
		picture.setBackground(Color.WHITE);
		picture.setBounds(100, 84, 130, 150); 
		try {
			ImageIcon	img21 = new ImageIcon(scaleImage(110, 120, ImageIO.read(new File(".\\img\\komate.png"))));
			picture.setIcon(img21);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		frame.getContentPane().add(picture);
		
		JButton btnUpload = new JButton("Upload");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileDialog fd = new FileDialog(frame, "Choose a file", FileDialog.LOAD);
				fd.setDirectory("C:\\");
				fd.setFile("*.jpg;*.jpeg;*.png");
				fd.setVisible(true);
				filename = fd.getDirectory()+fd.getFile();
				fd.setSize(110, 120);
				f =  new File(filename);
	             encodstring = encodeFileToBase64Binary(f);
	             //System.out.println(encodstring);
	             byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(encodstring);
	             try {
	            	ImageIcon img=new ImageIcon(scaleImage(110, 120, ImageIO.read(new ByteArrayInputStream(imageBytes))));
					picture.setIcon(img);
				} catch (IOException e1) {			
					e1.printStackTrace();
				}				
	             catch (Exception e1) {			
					e1.printStackTrace();
				}
			}
		});
		btnUpload.setForeground(Color.BLACK);
		btnUpload.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpload.setBackground(Color.GREEN);
		btnUpload.setAlignmentY(0.0f);
		btnUpload.setBounds(100, 266, 123, 48);
		frame.getContentPane().add(btnUpload);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblEmail.setBounds(323, 358, 183, 81);
		frame.getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEmail.setColumns(10);
		txtEmail.setBounds(518, 385, 193, 29);
		frame.getContentPane().add(txtEmail);

		
	}
	public static BufferedImage scaleImage(int w, int h, BufferedImage img) throws Exception {
	    BufferedImage bi;
	    bi = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
	    Graphics2D g2d = (Graphics2D) bi.createGraphics();
	    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
	    g2d.drawImage(img, 0, 0, w, h, null);
	    g2d.dispose();
	    return bi;
	}
	 private static String encodeFileToBase64Binary(File file){
         String encodedfile = null;
         try {
             FileInputStream fileInputStreamReader = new FileInputStream(file);
             byte[] bytes = new byte[(int)file.length()];
             fileInputStreamReader.read(bytes);
             encodedfile = new String(Base64.encode(bytes), "UTF-8");
         } catch (FileNotFoundException e) {
       
             e.printStackTrace();
         } catch (IOException e) {
    
             e.printStackTrace();
         }

         return encodedfile;
     }
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
