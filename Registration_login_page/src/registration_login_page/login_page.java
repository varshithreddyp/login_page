package registration_login_page;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class login_page {

	JFrame lframe;
	private JTextField t1;
	private JPasswordField p1;
	JLabel lbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_page window = new login_page();
					window.lframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login_page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		lframe = new JFrame();
		lframe.getContentPane().setBackground(new Color(255, 255, 206));
		lframe.setBounds(100, 100, 689, 518);
		lframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lframe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN PAGE");
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 22));
		lblNewLabel.setBounds(224, 52, 221, 30);
		lframe.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 18));
		lblNewLabel_1.setBounds(124, 118, 121, 35);
		lframe.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Monospaced", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(124, 190, 121, 35);
		lframe.getContentPane().add(lblNewLabel_1_1);
		
		t1 = new JTextField();
		t1.setBounds(321, 118, 186, 35);
		lframe.getContentPane().add(t1);
		t1.setColumns(10);
		
		p1 = new JPasswordField();
		p1.setBounds(321, 185, 186, 40);
		lframe.getContentPane().add(p1);
		
		JButton btn = new JButton("LOGIN");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String un=t1.getText();
				String pswd=p1.getText();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","123456");
					String q="Select count(*) from reglog where Username=? and Password=?";
					PreparedStatement pd=con.prepareStatement(q);
					pd.setString(1, un);
					pd.setString(2, pswd);
					ResultSet rs=pd.executeQuery();
					rs.next();
					int count=rs.getInt(1);
					if(count==1) {
						JOptionPane.showMessageDialog(btn,"Valid Credentials");
					}
					else {
						JOptionPane.showMessageDialog(btn,"Invalid Credentials");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn.setFont(new Font("Verdana", Font.BOLD, 16));
		btn.setBounds(224, 278, 105, 40);
		lframe.getContentPane().add(btn);
		
		JLabel lbl = new JLabel(" ");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl.setBounds(476, 52, 99, 30);
		lframe.getContentPane().add(lbl);
	}
}
