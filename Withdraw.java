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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Withdraw extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idField;
	private JTextField amountField;
	private JPasswordField pinField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdraw frame = new Withdraw();
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
	public Withdraw() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWithdraw = new JLabel("WITHDRAW");
		lblWithdraw.setHorizontalAlignment(SwingConstants.CENTER);
		lblWithdraw.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));
		lblWithdraw.setBounds(199, 22, 179, 33);
		contentPane.add(lblWithdraw);
		
		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(76, 98, 45, 26);
		contentPane.add(lblNewLabel);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(131, 91, 247, 33);
		contentPane.add(idField);
		
		JLabel lblAmount = new JLabel("AMOUNT :");
		lblAmount.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblAmount.setBounds(18, 153, 109, 26);
		contentPane.add(lblAmount);
		
		amountField = new JTextField();
		amountField.setColumns(10);
		amountField.setBounds(131, 152, 247, 33);
		contentPane.add(amountField);
		
		JLabel lblPin = new JLabel("PIN  :");
		lblPin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblPin.setBounds(59, 227, 68, 26);
		contentPane.add(lblPin);
		
		pinField = new JPasswordField();
		pinField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		pinField.setBounds(131, 220, 247, 33);
		contentPane.add(pinField);
		
		JButton btnNewButton_1 = new JButton("WITHDRAW");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userId= Integer.parseInt(idField.getText());
				int amount= Integer.parseInt(amountField.getText());
				@SuppressWarnings("deprecation")
				String userPassword= pinField.getText();	
				int curAmount = 0,totalAmount = 0;
				String pin = null;
				try {
					Databasecon d = new Databasecon();
					Connection con = d.connn();
					PreparedStatement ps;
					ps = con.prepareStatement("SELECT MONEY,PIN FROM JAVABANK WHERE USER_ID = ?");
					ps.setInt(1, userId);
					ResultSet resultSet = ps.executeQuery();
					if(resultSet.next()) {
						 curAmount = resultSet.getInt("MONEY");
						 pin = resultSet.getString("PIN");
					}else {
						JOptionPane.showMessageDialog(null,"PLEASE CHECK CREDENTIALS");
					}
					if(pin.equals(userPassword)) {
						if(amount>curAmount) {
							JOptionPane.showMessageDialog(null,"INSUFFFICIENT BALANCE");
							return;
						}
						totalAmount = curAmount - amount;
						PreparedStatement pstmt = con.prepareStatement("UPDATE JAVABANK SET MONEY = ? WHERE USER_ID = ?");
						pstmt.setInt(1, totalAmount);
						pstmt.setInt(2, userId);
						pstmt.executeUpdate();
						JOptionPane.showMessageDialog(null,"AMOUNT WITHDRAWED SUCCESSFULLY");
						dispose();
					}else {
						JOptionPane.showMessageDialog(null,"INCORRECT PIN");
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
		btnNewButton_1.setBounds(181, 282, 136, 46);
		contentPane.add(btnNewButton_1);
		setLocationRelativeTo(null);

	}

}
