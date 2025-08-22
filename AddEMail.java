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
import java.awt.event.ActionEvent;
import java.sql.*;

public class AddEMail extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idField;
	private JPasswordField passField;
	private JTextField mailField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEMail frame = new AddEMail();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

		public AddEMail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddEmail = new JLabel("CHANGE E-MAIL");
		lblAddEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddEmail.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblAddEmail.setBounds(127, 23, 337, 33);
		contentPane.add(lblAddEmail);
		
		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(62, 87, 45, 26);
		contentPane.add(lblNewLabel);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(117, 80, 247, 33);
		contentPane.add(idField);
		
		JLabel lblPin = new JLabel("PIN  :");
		lblPin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblPin.setBounds(40, 136, 68, 26);
		contentPane.add(lblPin);
		
		passField = new JPasswordField();
		passField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		passField.setBounds(117, 129, 247, 33);
		contentPane.add(passField);
		
		JLabel lblEmailId = new JLabel("E-MAIL ID :");
		lblEmailId.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblEmailId.setBounds(10, 198, 119, 26);
		contentPane.add(lblEmailId);
		
		mailField = new JTextField();
		mailField.setColumns(10);
		mailField.setBounds(127, 191, 247, 33);
		contentPane.add(mailField);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userId = Integer.parseInt(idField.getText());
				String pass = passField.getText();
				String email = mailField.getText();
				String curPass = null;
				
				try {
					Databasecon d = new Databasecon();
					Connection con = d.connn();
					PreparedStatement ps = con.prepareStatement("SELECT PIN FROM JAVABANK WHERE USER_ID = ?");
					ps.setInt(1, userId);
					ResultSet resultSet = ps.executeQuery();
					if(resultSet.next()) {
						curPass = resultSet.getString("PIN");
					}else {
						JOptionPane.showMessageDialog(null,"CHECK CREDETIALS");
					}
					if(curPass.equals(pass)) {
						PreparedStatement pstmt = con.prepareStatement("UPDATE JAVABANK SET EMAIL_ID = ? WHERE USER_ID = ?");
						pstmt.setString(1,email);
						pstmt.setInt(2, userId);
						pstmt.executeUpdate();
						JOptionPane.showMessageDialog(null,"EMAIL ID CHANGED SUCCESSFULLY");
					}
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		btnSubmit.setName("");
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		btnSubmit.setBackground(Color.GRAY);
		btnSubmit.setBounds(206, 260, 119, 48);
		contentPane.add(btnSubmit);
		

	}

}
