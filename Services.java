import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Services extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Services frame = new Services();
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
	public Services() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btnNewButton = new JButton("BALANCE");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				CheckBalance checkBalance = new CheckBalance();
				checkBalance.show();
				dispose();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setBounds(25, 49, 125, 44);
		contentPane.add(btnNewButton);
		
		JButton btnChangeMobileNo = new JButton("CHANGE MOBILE NO.");
		btnChangeMobileNo.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				ChangeMobile changeMobile = new ChangeMobile();
				changeMobile.show();
				dispose();
			}
		});
		
		btnChangeMobileNo.setForeground(Color.WHITE);
		btnChangeMobileNo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		btnChangeMobileNo.setBackground(Color.GRAY);
		btnChangeMobileNo.setBounds(25, 142, 125, 44);
		contentPane.add(btnChangeMobileNo);
		
		JButton btnAddEmail = new JButton("CHANGE EMAIL");
		btnAddEmail.addActionListener(new ActionListener() {
			@SuppressWarnings({ "deprecation" })
			public void actionPerformed(ActionEvent e) {
				AddEMail addEmail = new AddEMail();
				addEmail.show();
				dispose();
			}
		});
		btnAddEmail.setForeground(Color.WHITE);
		btnAddEmail.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		btnAddEmail.setBackground(Color.GRAY);
		btnAddEmail.setBounds(25, 253, 125, 44);
		contentPane.add(btnAddEmail);
		
		JButton btnWidraw = new JButton("WITHDRAW");
		btnWidraw.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Withdraw withdraw = new Withdraw();
				withdraw.show();
				dispose();
			}
		});
		btnWidraw.setForeground(Color.WHITE);
		btnWidraw.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		btnWidraw.setBackground(Color.GRAY);
		btnWidraw.setBounds(417, 49, 125, 44);
		contentPane.add(btnWidraw);
		
		JButton btnDiposit = new JButton("DIPOSIT");
		btnDiposit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Diposit diposit = new Diposit();
				diposit.show();
				dispose();
			}
		});
		btnDiposit.setForeground(Color.WHITE);
		btnDiposit.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		btnDiposit.setBackground(Color.GRAY);
		btnDiposit.setBounds(417, 142, 125, 44);
		contentPane.add(btnDiposit);
		
		JButton btnChangeP = new JButton("CHANGE PIN");
		btnChangeP.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				ChangePin changePin = new ChangePin();
				changePin.show();
				dispose();
			}
		});
		btnChangeP.setForeground(Color.WHITE);
		btnChangeP.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnChangeP.setBackground(Color.GRAY);
		btnChangeP.setBounds(417, 240, 125, 44);
		contentPane.add(btnChangeP);

	}
}
