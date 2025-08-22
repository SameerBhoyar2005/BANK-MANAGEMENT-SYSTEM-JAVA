import java.awt.EventQueue;
import java.sql.*;

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
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class Diposit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idtextField;
	private JTextField amttextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Diposit frame = new Diposit();
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
	public Diposit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblDiposit = new JLabel("DIPOSIT");
		lblDiposit.setBounds(212, 29, 144, 33);
		lblDiposit.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiposit.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));
		contentPane.add(lblDiposit);
		
		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(74, 105, 45, 26);
		contentPane.add(lblNewLabel);
		
		idtextField = new JTextField();
		idtextField.setColumns(10);
		idtextField.setBounds(145, 98, 247, 33);
		contentPane.add(idtextField);
		
		JLabel lblAmount = new JLabel("AMOUNT :");
		lblAmount.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblAmount.setBounds(10, 168, 109, 26);
		contentPane.add(lblAmount);
		
		amttextField = new JTextField();
		amttextField.setColumns(10);
		amttextField.setBounds(145, 161, 247, 33);
		contentPane.add(amttextField);
		
		JButton btnNewButton_1 = new JButton("DIPOSIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userId = Integer.parseInt(idtextField.getText());
				int amount = Integer.parseInt(amttextField.getText());
				int curAmount,totalAmount = 0;
				try {
					Databasecon d = new Databasecon();
					Connection con = d.connn();
					PreparedStatement ps;
					ps = con.prepareStatement("SELECT MONEY FROM JAVABANK WHERE USER_ID = ?");
					ps.setInt(1, userId);
					ResultSet resultSet = ps.executeQuery();
					if(resultSet.next()) {
						 curAmount = resultSet.getInt("MONEY");
						 totalAmount = amount + curAmount;
					}else {
						JOptionPane.showMessageDialog(null,"PLEASE CHECK CREDENTIALS");
					}
					PreparedStatement pstmt = con.prepareStatement("UPDATE JAVABANK SET MONEY = ? WHERE USER_ID = ?");
					pstmt.setInt(1, totalAmount);
					pstmt.setInt(2, userId);
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null,"AMOUNT DIPOSITED SUCCESSFULLY");
					
					
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
		btnNewButton_1.setBounds(198, 243, 136, 46);
		contentPane.add(btnNewButton_1);

	}

}
