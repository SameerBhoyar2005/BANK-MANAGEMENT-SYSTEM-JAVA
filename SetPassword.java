import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.sql.*;

public class SetPassword extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField cpasswordField;
	private JButton btnSubmit;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetPassword frame = new SetPassword();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public SetPassword() {
		setTitle("frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("SET A STRONG PIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(164, 42, 229, 23);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(152, 85, 241, 37);
		contentPane.add(passwordField);
		
		JLabel lblConformPassword = new JLabel("CONFORM PIN");
		lblConformPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblConformPassword.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblConformPassword.setBounds(164, 149, 229, 23);
		contentPane.add(lblConformPassword);
		
		cpasswordField = new JPasswordField();
		cpasswordField.setHorizontalAlignment(SwingConstants.CENTER);
		cpasswordField.setBounds(152, 182, 241, 37);
		contentPane.add(cpasswordField);
		
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String pass = passwordField.getText().toString();
				String cpass = cpasswordField.getText().toString();
				
				java.sql.Date fdob = java.sql.Date.valueOf(CreateAccount.dob);
				
				
				if(pass.equals(cpass)) {
					try {
						
						Databasecon d = new Databasecon();
						Connection con = d.connn();
						
						String query="insert into JAVABANK (FNAME,MNAME,LNAME,DOB,CONTACT_NO,EMAIL_ID,PIN)values(?,?,?,?,?,?,?)";
						PreparedStatement pstmt = con.prepareStatement(query);
						
						pstmt.setString(1,CreateAccount.f_name);
						pstmt.setString(2,CreateAccount.m_name);
						pstmt.setString(3, CreateAccount.l_name);
						pstmt.setDate(4, fdob);
						pstmt.setString(5,CreateAccount.contactno);
						pstmt.setString(6,CreateAccount.email);
						pstmt.setString(7,cpass);
						int row=pstmt.executeUpdate();
						
						PreparedStatement ps = con.prepareStatement("SELECT USER_ID FROM JAVABANK WHERE CONTACT_NO =?");
						ps.setString(1,CreateAccount.contactno);
						ResultSet resultSet = ps.executeQuery();
						String userid = null;
						
						if(resultSet.next()){
						int id = resultSet.getInt("USER_ID");
						userid = String.valueOf(id);
						}else {
							JOptionPane.showMessageDialog(null,"USER NOT FOUND");
						}
						if(row > 0) {
							JOptionPane.showMessageDialog(null, "ACCOUNT CREATED SUCCESSFULLY ! AND USER ID IS "+ userid);
							dispose();
							Diposit diposit = new Diposit();
							diposit.show();
						}else {							
							JOptionPane.showMessageDialog(null, "UNSUCCESSFULL !");
						}
						}catch(Exception em) {
							JOptionPane.showMessageDialog(null, em.getMessage());					}
				}else {
					JOptionPane.showMessageDialog(null, "CHECK PASSWORD AGAIN!");
				}				
			}
		});
		btnSubmit.setName("");
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		btnSubmit.setBackground(Color.GRAY);
		btnSubmit.setBounds(223, 265, 101, 37);
		contentPane.add(btnSubmit);

	}
}
