import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.UnknownHostException;

import org.bson.BSON;
import com.mongodb.*;
import com.mongodb.util.JSON;
public class register {
	private JFrame frmRegister;
	private JTextField txtusername;
	private JTextField txtemail;
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register window = new register();
					window.frmRegister.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public register() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegister = new JFrame();
		frmRegister.setResizable(false);
		frmRegister.setBounds(100, 100, 700, 400);
		frmRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegister.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblNewLabel.setBounds(138, 60, 89, 36);
		frmRegister.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblPassword.setBounds(138, 107, 89, 36);
		frmRegister.getContentPane().add(lblPassword);
		
		JLabel lblComfirmPassword = new JLabel("Confirm password");
		lblComfirmPassword.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblComfirmPassword.setBounds(138, 156, 165, 36);
		frmRegister.getContentPane().add(lblComfirmPassword);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblEmail.setBounds(138, 206, 68, 36);
		frmRegister.getContentPane().add(lblEmail);
		
		txtusername = new JTextField();
		txtusername.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		txtusername.setBounds(327, 65, 200, 28);
		frmRegister.getContentPane().add(txtusername);
		txtusername.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		txtemail.setColumns(10);
		txtemail.setBounds(327, 210, 200, 28);
		frmRegister.getContentPane().add(txtemail);
		
		JButton btnsubmit = new JButton("Submit");
		btnsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!txtusername.getText().equals("")&&!txtemail.getText().equals("")&&!passwordField1.getPassword().equals("")&&!passwordField1.getPassword().equals("")) {
					
				new connect1().InsertUser(txtusername.getText(), new String (passwordField1.getPassword()), txtemail.getText());
				reset();
				
					}else{
						JOptionPane.showMessageDialog(null, "กรุณากรอกข้อมูลให้ครบด้วยค่ะ", "เกิดข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
		
					}
			}
		});
		
		btnsubmit.setFont(new Font("Sylfaen", Font.BOLD, 14));
		btnsubmit.setBounds(327, 258, 200, 36);
		frmRegister.getContentPane().add(btnsubmit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnClear.setFont(new Font("Sylfaen", Font.BOLD, 14));
		btnClear.setBounds(138, 258, 178, 36);
		frmRegister.getContentPane().add(btnClear);
		
		passwordField1 = new JPasswordField();
		passwordField1.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		passwordField1.setBounds(327, 111, 200, 28);
		frmRegister.getContentPane().add(passwordField1);
		
		passwordField2 = new JPasswordField();
		passwordField2.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		passwordField2.setBounds(327, 160, 200, 28);
		frmRegister.getContentPane().add(passwordField2);
	}
	public void reset() {
			txtusername.setText("");
			txtemail.setText("");
			passwordField1.setText("");
			passwordField2.setText("");
	}
	
}

class connect1 {
private String url = "mongodb://ox:oxox@125.27.10.67:27017/OX";
private MongoClient mongo =null;
DB db;
	public DB getConnect() {
		
		try {
			mongo = new MongoClient(new MongoClientURI(url));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db = mongo.getDB("OX");
		
		return db;
	}
	public String testConnect() {
		getConnect();
		return 	db.toString() + "\nStatus : Connected+\n" + db.getCollectionNames().toString();
		
	}
	public 	void InsertUser(String user,String pass,String email) {
		getConnect();
		DBCollection coll  = db.getCollection("USER");
		BasicDBObject searchQuery  = new BasicDBObject();
		searchQuery.put("USERNAME", user);
		DBCursor cursor = coll.find(searchQuery);
		int i=0;
		while (cursor.hasNext()) {
                    i++;
			cursor.next();
		} if(i!=0){  
			JOptionPane.showMessageDialog(null, "Username ของท่านซ่ำกับผู้อื่นกรุณาใช้ Username อื่น", "เกิดข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
                }            
        
		if(i==0){
        		DBObject x = (DBObject) JSON
				.parse("{'USERNAME':'"+user+"', 'PASSWORD':'"+pass+"', 'email':'"+email+"'}");
		
		coll.insert(x);
		JOptionPane.showMessageDialog(null,"OK");
        }
        	
        
	}
}

