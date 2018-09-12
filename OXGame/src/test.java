import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import java.net.UnknownHostException;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import com.mongodb.Block;

import java.util.Arrays;


import static com.mongodb.client.model.Filters.eq;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import com.sun.prism.Image;

import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.eclipse.osgi.internal.signedcontent.Base64;

import java.awt.Label;
import java.awt.Button;
public class test {

	private static JFrame frame;
	private JTextField jTextField1;
	private JLabel jLabel1;
	private JButton btnNewButton;
	static String filename;
	static File f;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
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
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
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
	 public static void find(ObjectId objectId) {
		  System.out.println("Calling find...");
		  MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		 
		  try {
		   MongoDatabase database = mongoClient.getDatabase("technicalkeeda");
		   GridFSBucket gridBucket = GridFSBuckets.create(database);
		 
		   GridFSFile gridFSFile = gridBucket.find(eq("_id",objectId)).first();
		   System.out.println("File Name:- " + gridFSFile.getFilename());
		   System.out.println("Meta Data:- " + gridFSFile.getMetadata());
		   
		 
		  } catch (Exception e) {
		   e.printStackTrace();
		  } finally {
		   mongoClient.close();
		  }
		    } 

	public  void delete(ObjectId objectId) {
		  System.out.println("Calling delete...");
		  MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		  try {
		   MongoDatabase database = mongoClient.getDatabase("technicalkeeda");
		   GridFSBucket gridBucket = GridFSBuckets.create(database);
		   gridBucket.delete(objectId);
		  } catch (Exception e) {
		   e.printStackTrace();
		  } finally {
		   mongoClient.close();
		  }
		    } 
	 public static ObjectId upload(String filePath,String fileName) {
		  System.out.println("Calling upload...");
		  MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://chain:chain555@ds018538.mlab.com:18538/ox"));
		  ObjectId fileId = null;
		  try {
		   MongoDatabase database = mongoClient.getDatabase("ox");
		   GridFSBucket gridBucket = GridFSBuckets.create(database);
		   InputStream inputStream = new FileInputStream(new File(filePath));
		   // Create some custom options
		   GridFSUploadOptions uploadOptions = new GridFSUploadOptions().chunkSizeBytes(1024).metadata(new Document("type", "image").append("upload_date", "2016-09-01T00:00:00Z").append("content_type", "image/jpg"));
		   fileId = gridBucket.uploadFromStream(fileName, inputStream, uploadOptions);
		 
		  } catch (Exception e) {
		   e.printStackTrace();
		  } finally {
		   mongoClient.close();
		  }
		  return fileId;
		    }
	 private static String encodeFileToBase64Binary(File file){
         String encodedfile = null;
         try {
             FileInputStream fileInputStreamReader = new FileInputStream(file);
             byte[] bytes = new byte[(int)file.length()];
             fileInputStreamReader.read(bytes);
             encodedfile = new String(Base64.encode(bytes), "UTF-8");
         } catch (FileNotFoundException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }

         return encodedfile;
     }
	private void initialize() {	
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		jTextField1 = new JTextField();
		jTextField1.setBounds(134, 153, 116, 22);
		frame.getContentPane().add(jTextField1);
		jTextField1.setColumns(10);
		
		jLabel1 = new JLabel("New label");
		jLabel1.setBounds(81, 27, 110, 120);
		frame.getContentPane().add(jLabel1);
		
		Button button = new Button("New button");
		button.setBackground(Color.GREEN);
		button.setBounds(148, 191, 79, 24);
		frame.getContentPane().add(button);
		
		btnNewButton = new JButton("New button");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					//upload(filename, "UserPicture");
				
			}
		});
		btnNewButton.setBounds(300, 190, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		label = new JLabel("New label");
		label.setBounds(259, 29, 110, 120);
		frame.getContentPane().add(label);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				FileDialog fd = new FileDialog(frame, "Choose a file", FileDialog.LOAD);
				fd.setDirectory("C:\\");
				fd.setFile("*.jpg;*.jpeg;*.png");
				fd.setVisible(true);
				filename = fd.getDirectory()+fd.getFile();
				if (filename == null)
				  System.out.println("You cancelled the choice");
				else
				  System.out.println("You chose " + filename);
				fd.setSize(110, 120);
				jTextField1.setText(filename);
				
				  f =  new File(filename);
	             String encodstring = encodeFileToBase64Binary(f);
	             System.out.println(encodstring);
	             byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(encodstring);
	             try {
	            	  ImageIcon img=new ImageIcon(scaleImage(110, 120, ImageIO.read(new ByteArrayInputStream(imageBytes))));
					label.setIcon(img);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//jLabel1.setIcon(new ImageIcon(filename));
	             catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	             
				 try {
				        ImageIcon ii=new ImageIcon(scaleImage(110, 120, ImageIO.read(new File(filename))));//get the image from file chooser and scale it to match JLabel size
				        jLabel1.setIcon(ii);
				        
				    } catch (Exception ex) {
				        ex.printStackTrace();
				    }
			  /* JFileChooser chooser = new JFileChooser();
			    chooser.showOpenDialog(null);
			    f = chooser.getSelectedFile();
			    filename = f.getAbsolutePath();
			    jTextField1.setText(filename);
			    try {
			       ImageIcon ii=new ImageIcon(scaleImage(120, 120, ImageIO.read(new File(f.getAbsolutePath()))));//get the image from file chooser and scale it to match JLabel size
			        jLabel1.setIcon(ii);
			        
			    } catch (Exception ex) {
			        ex.printStackTrace();
			    }
				*/
			}
			
				
		});

	}
}
