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

public class CheckBalance extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idField;
	private JPasswordField passField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckBalance frame = new CheckBalance();
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
	public CheckBalance() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCheckBalance = new JLabel("CHECK BALANCE");
		lblCheckBalance.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckBalance.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));
		lblCheckBalance.setBounds(147, 32, 264, 33);
		contentPane.add(lblCheckBalance);
		
		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(90, 108, 45, 26);
		contentPane.add(lblNewLabel);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(145, 101, 247, 33);
		contentPane.add(idField);
		
		JLabel lblPin = new JLabel("PIN  :");
		lblPin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblPin.setBounds(75, 168, 68, 26);
		contentPane.add(lblPin);
		
		passField = new JPasswordField();
		passField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		passField.setBounds(145, 161, 247, 33);
		contentPane.add(passField);
		
		JButton btnNewButton_1 = new JButton("CHECK ");
		btnNewButton_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			
			public void actionPerformed(ActionEvent e) {
				int userId = Integer.parseInt(idField.getText());
				String password = passField.getText();
				String pass;
				int curAmount = 0;
				
				try {
					Databasecon d = new Databasecon();
					Connection con = d.connn();
					PreparedStatement ps = con.prepareStatement("SELECT PIN,MONEY FROM JAVABANK WHERE USER_ID = ?");
					ps.setInt(1, userId);
					ResultSet resultSet = ps.executeQuery();
					if(resultSet.next()) {
						pass = resultSet.getString("PIN");
						if(pass.equals(password)){
							curAmount=resultSet.getInt("MONEY");
							JOptionPane.showMessageDialog(null,"YOUR CURRENT BALANCE IS "+ curAmount);
							dispose();
						}else {
							JOptionPane.showMessageDialog(null,"INCORRECT PASSWORD");
						}
					}else {
						JOptionPane.showMessageDialog(null,"CHECK CREDINTIALS");
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
		btnNewButton_1.setBounds(187, 235, 136, 46);
		contentPane.add(btnNewButton_1);
		setLocationRelativeTo(null);
	}

}
