import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

@SuppressWarnings("unused")
public class WelcomeFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeFrame frame = new WelcomeFrame();
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
	public WelcomeFrame() {
		setTitle("WELCOME PAGE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		JPanel contentPane = new JPanel();
		contentPane.setName("WelcomePage");
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel.setBounds(201, 26, 161, 37);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.show();
				dispose();
				
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFocusTraversalPolicyProvider(true);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 10));
		btnNewButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setBounds(386, 180, 136, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CREATE ACCOUNT");
		btnNewButton_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				CreateAccount ca  = new CreateAccount();
				ca.show();
				dispose();
				
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 10));
		btnNewButton_1.setFocusTraversalPolicyProvider(true);
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setAlignmentX(1.0f);
		btnNewButton_1.setBounds(44, 180, 136, 46);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("BANK MANAGEMENT SYSTEM");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_1.setBounds(155, 91, 279, 46);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sameer Bhoyar");
		lblNewLabel_2.setBounds(10, 340, 111, 13);
		contentPane.add(lblNewLabel_2);

	}
}
