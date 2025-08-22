import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.sql.*;

public class ChangePin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passField;
	private JPasswordField npassField;
	private JPasswordField cpassField;
	private JTextField idField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePin frame = new ChangePin();
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
	public ChangePin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChangePin = new JLabel("CHANGE PIN");
		lblChangePin.setBounds(204, 10, 174, 33);
		lblChangePin.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangePin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		contentPane.add(lblChangePin);
		
		JLabel lblOldPin = new JLabel("OLD PIN  :");
		lblOldPin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblOldPin.setBounds(54, 157, 107, 26);
		contentPane.add(lblOldPin);
		
		passField = new JPasswordField();
		passField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		passField.setBounds(171, 155, 247, 33);
		contentPane.add(passField);
		
		JLabel lblNewPin = new JLabel("NEW PIN  :");
		lblNewPin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewPin.setBounds(54, 205, 107, 26);
		contentPane.add(lblNewPin);
		
		JLabel lblConformNewPin = new JLabel("CONFORM NEW  PIN  :");
		lblConformNewPin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblConformNewPin.setBounds(10, 241, 162, 26);
		contentPane.add(lblConformNewPin);
		
		npassField = new JPasswordField();
		npassField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		npassField.setBounds(171, 198, 247, 33);
		contentPane.add(npassField);
		
		cpassField = new JPasswordField();
		cpassField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cpassField.setBounds(171, 238, 247, 33);
		contentPane.add(cpassField);
		
		JButton btnNewButton_1 = new JButton("CHANGE");
		btnNewButton_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				int userId = Integer.parseInt(idField.getText());
				String curPass = passField.getText();
				String newPass = npassField.getText();	
				String cnewPass = cpassField.getText();	
				String pass;
				try {
					Databasecon d = new Databasecon();
					Connection con = d.connn();
					PreparedStatement ps = con.prepareStatement("SELECT PIN FROM JAVABANK WHERE USER_ID = ?");
					ps.setInt(1,userId);
					ResultSet resultSet = ps.executeQuery();
					if(resultSet.next()) {
						pass = resultSet.getString("PIN");
						if(pass.equals(curPass)) {
							if(newPass.equals(cnewPass)) {
								PreparedStatement pstmt = con.prepareStatement("UPDATE JAVABANK SET PIN = ? WHERE USER_ID = ?");
								pstmt.setString(1, cnewPass);
								pstmt.setInt(2, userId);
								pstmt.executeUpdate();
								JOptionPane.showMessageDialog(null,"PASSWORD CHANGED SUCCESSFULLY ");
								dispose();
							}else {
								JOptionPane.showMessageDialog(null,"CONFORM YOUR NEW PASSWOD CORRECTLY");
							}
							
						}else {
							JOptionPane.showMessageDialog(null,"CHECK CURRENT PASSWORD");
						}
					}else {
						JOptionPane.showMessageDialog(null,"CHECK CREDENTIALS");
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
				
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 10));
		btnNewButton_1.setFocusTraversalPolicyProvider(true);
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setAlignmentX(1.0f);
		btnNewButton_1.setBounds(219, 307, 136, 46);
		contentPane.add(btnNewButton_1);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblId.setBounds(122, 113, 39, 26);
		contentPane.add(lblId);
		
		idField = new JTextField();
		idField.setBounds(171, 112, 247, 33);
		contentPane.add(idField);
		idField.setColumns(10);
		setLocationRelativeTo(null);
	}
}
