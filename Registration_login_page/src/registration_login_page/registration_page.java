package registration_login_page;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class registration_page {

	private JFrame rframe;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JPasswordField p1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registration_page window = new registration_page();
					window.rframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public registration_page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		rframe = new JFrame();
		rframe.setBounds(100, 100, 662, 432);
		rframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rframe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration Page");
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 24));
		lblNewLabel.setBounds(217, 24, 277, 41);
		rframe.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(79, 93, 98, 30);
		rframe.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Phone No.");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(79, 147, 98, 30);
		rframe.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Username");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1_1.setBounds(79, 207, 98, 30);
		rframe.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Password");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1_2.setBounds(79, 268, 98, 30);
		rframe.getContentPane().add(lblNewLabel_1_1_2);
		
		t1 = new JTextField();
		t1.setBounds(245, 93, 185, 30);
		rframe.getContentPane().add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(245, 147, 185, 30);
		rframe.getContentPane().add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(245, 216, 185, 30);
		rframe.getContentPane().add(t3);
		
		p1 = new JPasswordField();
		p1.setBounds(246, 268, 184, 30);
		rframe.getContentPane().add(p1);
		
		JButton btn = new JButton("SUBMIT");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nm=t1.getText();
				String pn=t2.getText();
				int pno=Integer.parseInt(pn);
				String un=t3.getText();
				String pswd=p1.getText();
				
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","123456");
					String q="Insert into reglog values('"+nm+"','"+pno+"','"+un+"','"+pswd+"')";
					Statement sta=con.createStatement();
					sta.executeUpdate(q);
					con.close();
					JOptionPane.showMessageDialog(btn,nm+" your Registration Done!");
					login_page l=new login_page();
					l.lframe.setVisible(true);
					rframe.dispose();				
					}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn.setBounds(170, 342, 118, 21);
		rframe.getContentPane().add(btn);
	}

}

