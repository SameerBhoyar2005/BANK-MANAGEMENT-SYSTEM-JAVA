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

public class ChangeMobile extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idField;
	private JPasswordField passField;
	private JTextField oldNumberField;
	private JTextField newNumberField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeMobile frame = new ChangeMobile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChangeMobile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChangeMobileNumber = new JLabel("CHANGE MOBILE NUMBER");
		lblChangeMobileNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangeMobileNumber.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblChangeMobileNumber.setBounds(107, 10, 337, 33);
		contentPane.add(lblChangeMobileNumber);
		
		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(81, 71, 45, 26);
		contentPane.add(lblNewLabel);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(147, 64, 247, 33);
		contentPane.add(idField);
		
		JLabel lblPin = new JLabel("PIN  :");
		lblPin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblPin.setBounds(66, 133, 68, 26);
		contentPane.add(lblPin);
		
		passField = new JPasswordField();
		passField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		passField.setBounds(147, 126, 247, 33);
		contentPane.add(passField);
		
		JLabel lblOldNumber = new JLabel("OLD NUMBER :");
		lblOldNumber.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblOldNumber.setBounds(10, 195, 116, 26);
		contentPane.add(lblOldNumber);
		
		oldNumberField = new JTextField();
		oldNumberField.setColumns(10);
		oldNumberField.setBounds(147, 188, 247, 33);
		contentPane.add(oldNumberField);
		
		JLabel lblNewNumber = new JLabel("NEW NUMBER :");
		lblNewNumber.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewNumber.setBounds(10, 249, 124, 26);
		contentPane.add(lblNewNumber);
		
		newNumberField = new JTextField();
		newNumberField.setColumns(10);
		newNumberField.setBounds(147, 242, 247, 33);
		contentPane.add(newNumberField);
		
		JLabel lblNewLabel_1 = new JLabel("Please Fill Carefully");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(418, 249, 158, 21);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("CHANGE");
		btnNewButton_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				int userId = Integer.parseInt(idField.getText());
				String pass = passField.getText();
				String oldNumber = oldNumberField.getText();
				String newNumber = newNumberField.getText();
				String dbpass,curNumber;
				try {
					Databasecon d = new Databasecon();
					Connection con = d.connn();
					PreparedStatement ps = con.prepareStatement("SELECT PIN,CONTACT_NO FROM JAVABANK WHERE USER_ID = ?");
					ps.setInt(1, userId);
					ResultSet resultSet = ps.executeQuery();
					if(resultSet.next()) {
						dbpass = resultSet.getString("PIN");
						curNumber = resultSet.getString("CONTACT_NO");
						if(pass.equals(dbpass) && oldNumber.equals(curNumber)) {
							PreparedStatement pstmt = con.prepareStatement("UPDATE JAVABANK SET CONTACT_NO = ? WHERE USER_ID = ?");
							pstmt.setString(1,newNumber);
							pstmt.setInt(2,userId);
							pstmt.executeUpdate();
							JOptionPane.showMessageDialog(null,"CONTACT NUMBER CHANGED SUCCESSFULLY");
							dispose();
						}else {
							JOptionPane.showMessageDialog(null,"CHECK PASSWORD OR CONTACT NUMBERS");
						}
					}else {
						JOptionPane.showMessageDialog(null,"CHECK CREDENTIALS");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					
				}
				
				
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 10));
		btnNewButton_1.setFocusTraversalPolicyProvider(true);
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setAlignmentX(1.0f);
		btnNewButton_1.setBounds(198, 294, 136, 46);
		contentPane.add(btnNewButton_1);
		setLocationRelativeTo(null);
	}

}
