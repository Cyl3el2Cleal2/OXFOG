import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.awt.Label;
import javax.swing.JTable;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.UIManager;

import com.sun.prism.Image;

import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import java.awt.Button;

public class board {
	private   OX ox;
    private  JLabel userDraw;
    private  JLabel userWin1;
    private  JLabel userWin2;
    private  JButton button1;
    private  JButton button2;
    private  JButton button3;
    private  JButton button4;
    private  JButton button5;
    private  JButton button6;
    private  JButton button7;
    private  JButton button8;
    private  JButton button9;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					board window = new board();
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
	public board() {
		ox=new OX();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.getContentPane().setFocusCycleRoot(true);
		frame.getContentPane().setFocusTraversalPolicyProvider(true);
		frame.getContentPane().setBounds(new Rectangle(50, 50, 50, 50));
		frame.setSize(new Dimension(800, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocation(500, 200);
		frame.setTitle("OXGame");
		frame.setSize(800,600);
		frame.setResizable(false);
		
		
		Label userPic1 = new Label("");
		userPic1.setCursor(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));
		userPic1.setBackground(new Color(238, 232, 170));
		userPic1.setBounds(30, 34, 130, 140);
		frame.getContentPane().add(userPic1);
		
		Label userPic2 = new Label("");
		userPic2.setBackground(new Color(240, 230, 140));
		userPic2.setBounds(626, 34, 130, 140);
		frame.getContentPane().add(userPic2);
		
		JPanel from = new JPanel();
		from.setBackground(new Color(255, 218, 185));
		from.setBounds(252, 153, 275, 275);
		frame.getContentPane().add(from);
		from.setLayout(null);
		
		button1 = new JButton("-");
		button1.setFocusable(false);
		button1.setBounds(new Rectangle(0, 0, 50, 50));
		button1.setBorder(UIManager.getBorder("CheckBox.border"));
		button1.setBackground(new Color(240, 255, 240));
		button1.setHorizontalTextPosition(SwingConstants.CENTER);
		button1.setFont(new Font("Roboto", Font.BOLD, 72));
		button1.setBounds(5, 5, 85, 85);
		from.add(button1);
		
		button2 = new JButton("-");
		button2.setFocusable(false);
		button2.setBorder(UIManager.getBorder("CheckBox.border"));
		button2.setBackground(new Color(240, 255, 240));
		button2.setHorizontalTextPosition(SwingConstants.CENTER);
		button2.setFont(new Font("Roboto", Font.BOLD, 72));
		button2.setBounds(95, 5, 85, 85);
		from.add(button2);
		
		button3 = new JButton("-");
		button3.setFocusable(false);
		button3.setBorder(UIManager.getBorder("CheckBox.border"));
		button3.setBackground(new Color(240, 255, 240));
		button3.setHorizontalTextPosition(SwingConstants.CENTER);
		button3.setFont(new Font("Roboto", Font.BOLD, 72));
		button3.setBounds(185, 5, 85, 85);
		from.add(button3);
		
		button4 = new JButton("-");
		button4.setFocusable(false);
		button4.setBorder(UIManager.getBorder("CheckBox.border"));
		button4.setBackground(new Color(240, 255, 240));
		button4.setHorizontalTextPosition(SwingConstants.CENTER);
		button4.setFont(new Font("Roboto", Font.BOLD, 72));
		button4.setBounds(5, 95, 85, 85);
		from.add(button4);
		
		button5 = new JButton("-");
		button5.setFocusable(false);
		button5.setBorder(UIManager.getBorder("CheckBox.border"));
		button5.setBackground(new Color(240, 255, 240));
		button5.setHorizontalTextPosition(SwingConstants.CENTER);
		button5.setFont(new Font("Roboto", Font.BOLD, 72));
		button5.setBounds(95, 95, 85, 85);
		from.add(button5);
		
		button6 = new JButton("-");
		button6.setFocusable(false);
		button6.setSize(new Dimension(50, 50));
		button6.setBorder(UIManager.getBorder("CheckBox.border"));
		button6.setBackground(new Color(240, 255, 240));
		button6.setHorizontalTextPosition(SwingConstants.CENTER);
		button6.setFont(new Font("Roboto", Font.BOLD, 72));
		button6.setBounds(185, 95, 85, 85);
		from.add(button6);
		
		button7 = new JButton("-");
		button7.setFocusable(false);
		button7.setSize(new Dimension(50, 50));
		button7.setBorder(UIManager.getBorder("CheckBox.border"));
		button7.setBackground(new Color(240, 255, 240));
		button7.setHorizontalTextPosition(SwingConstants.CENTER);
		button7.setFont(new Font("Roboto", Font.BOLD, 72));
		button7.setBounds(5, 185, 85, 85);
		from.add(button7);
		
		button8 = new JButton("-");
		button8.setFocusable(false);
		button8.setSize(new Dimension(50, 50));
		button8.setBorder(UIManager.getBorder("CheckBox.border"));
		button8.setBackground(new Color(240, 255, 240));
		button8.setHorizontalTextPosition(SwingConstants.CENTER);
		button8.setFont(new Font("Roboto", Font.BOLD, 72));
		button8.setBounds(95, 185, 85, 85);
		from.add(button8);
		
		button9 = new JButton("-");
		button9.setFocusable(false);
		button9.setSize(new Dimension(50, 50));
		button9.setBorder(UIManager.getBorder("CheckBox.border"));
		button9.setBackground(new Color(240, 255, 240));
		button9.setHorizontalTextPosition(SwingConstants.CENTER);
		button9.setFont(new Font("Roboto", Font.BOLD, 72));
		button9.setBounds(185, 185, 85, 85);
		from.add(button9);
		
		JLabel timeShow = new JLabel("20");
		timeShow.setForeground(new Color(255, 69, 0));
		timeShow.setFont(new Font("Tahoma", Font.BOLD, 74));
		timeShow.setBounds(342, 34, 94, 91);
		frame.getContentPane().add(timeShow);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(new Color(255, 99, 71));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
	    btnNewButton.setBounds(30, 517, 83, 35);
	    frame.getContentPane().add(btnNewButton);
	    
	    userWin1 = new JLabel("");
        userWin1.setFont(new Font("Dialog", Font.PLAIN, 22));
        userWin1.setBackground(Color.WHITE);
        userWin1.setForeground(Color.WHITE);
        userWin1.setBounds(120, 468, 120, 30);
        frame.getContentPane().add(userWin1);
        
        userDraw = new JLabel("");
        userDraw = new JLabel("");
        userDraw.setForeground(Color.WHITE);
        userDraw.setFont(new Font("Dialog", Font.PLAIN, 22));
        userDraw.setBackground(Color.WHITE);
        userDraw.setBounds(330, 468, 120, 30);
        frame.getContentPane().add(userDraw);
        
        userWin2 = new JLabel("");
        userWin2 = new JLabel("");
        userWin2.setForeground(Color.WHITE);
        userWin2.setFont(new Font("Dialog", Font.PLAIN, 22));
        userWin2.setBackground(Color.WHITE);
        userWin2.setBounds(573, 468, 120, 30);
        frame.getContentPane().add(userWin2);
        
        userWin1.setText("Win: "+ox.getScoreX());
        userWin2.setText("Win: "+ox.getScoreO());
        userDraw.setText("Draw: "+ox.getScoreDraw());
		
		 try {
		        ImageIcon img=new ImageIcon(scaleImage(800, 600, ImageIO.read(new File(".\\img\\bg4.jpg"))));	        
		        JLabel background = new JLabel("");
		        background.setBackground(new Color(139, 69, 19));
		        background.setBounds(0, 0, 800, 565);
		        frame.getContentPane().add(background);
		        background.setIcon(img);

		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		 
		 button1.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                if(ox.put(0,0)){
	                    render();
	                    process();
	                }

	            }
	        });
	        button2.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                if(ox.put(1,0)){
	                    render();
	                    process();
	                }

	            }
	        });
	        button3.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                if(ox.put(2,0)){
	                    render();
	                    process();
	                }

	            }
	        });
	        button4.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                if(ox.put(0,1)){
	                    render();
	                    process();
	                }

	            }
	        });
	        button5.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                if(ox.put(1,1)){
	                    render();
	                    process();
	                }

	            }
	        });
	        button6.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                if(ox.put(2,1)){
	                    render();
	                    process();
	                }

	            }
	        });
	        button7.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                if(ox.put(0,2)){
	                    render();
	                    process();
	                }

	            }
	        });
	        button8.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                if(ox.put(1,2)){
	                    render();
	                    process();
	                }

	            }
	        });
	        button9.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                if(ox.put(2,2)){
	                    render();
	                    process();

	                }

	            }
	        }); 
	        

	    }
	 private void loadDatabase(){
		 
	 }
	
	 private   void render() {		
	        button1.setText(ox.get(0,0));
	        button2.setText(ox.get(1,0));
	        button3.setText(ox.get(2,0));
	        button4.setText(ox.get(0,1));
	        button5.setText(ox.get(1,1));
	        button6.setText(ox.get(2,1));
	        button7.setText(ox.get(0,2));
	        button8.setText(ox.get(1,2));
	        button9.setText(ox.get(2,2));
	        userWin1.setText("Win: "+ox.getScoreX());
	        userWin2.setText("Win: "+ox.getScoreO());
	        userDraw.setText("Draw: "+ox.getScoreDraw());
	    }
	
    private   void process() {
        if(ox.checkWin()){
            ox.addScoreOfForm();
            int result=JOptionPane.showConfirmDialog(null,
                    ox.getCurrentPlayer()+" Win , "+
                "Do you want to play agian?",
                    "Win",
                    JOptionPane.YES_NO_OPTION);
            if(result==JOptionPane.YES_OPTION){
                ox.reset();
                render();
                return;
            }else{
                System.exit(0);
            }
        }else if(ox.isDraw()){
            int result=JOptionPane.showConfirmDialog(null, " Draw , "+
                    "Do you want to play agian?",
                    "Win",
                    JOptionPane.YES_NO_OPTION);
            if(result==JOptionPane.YES_OPTION){
                ox.reset();
                render();
                return;
            }else{
                System.exit(0);
            }
        }
        ox.switchPlayer();
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
}
