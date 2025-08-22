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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idField;
	private JPasswordField pinField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setBounds(169, 24, 197, 33);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));
		contentPane.add(lblLogin);
		
		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(94, 114, 43, 26);
		contentPane.add(lblNewLabel);
		
		idField = new JTextField();
		idField.setBounds(147, 113, 247, 33);
		contentPane.add(idField);
		idField.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD  :");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblPassword.setBounds(10, 184, 127, 26);
		contentPane.add(lblPassword);
		
		JButton btnNewButton_1 = new JButton("LOGIN");
		btnNewButton_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
			int userId = Integer.parseInt(idField.getText());
			String password = pinField.getText();
			String curPassword = null;
			
			try {
				Databasecon d = new Databasecon();
				Connection con = d.connn();
				PreparedStatement ps;
				ps = con.prepareStatement("SELECT PIN FROM JAVABANK WHERE USER_ID = ?");
				ps.setInt(1, userId);
				ResultSet resultSet = ps.executeQuery();
				if(resultSet.next()) {
					 curPassword = resultSet.getString("PIN");
				}else {
					JOptionPane.showMessageDialog(null,"PLEASE CHECK CREDENTIALS");
				}
				if(curPassword.equals(password)) {
					Services s = new Services();
					s.show();
					dispose();
				}else {
					JOptionPane.showMessageDialog(null,"INCORRECT PASSWORD");
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
		btnNewButton_1.setBounds(198, 257, 136, 46);
		contentPane.add(btnNewButton_1);
		
		pinField = new JPasswordField();
		pinField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		pinField.setBounds(147, 176, 247, 33);
		contentPane.add(pinField);

	}
}
