import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.ComponentOrientation;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class CreateAccount extends JFrame {
	public static String f_name,m_name,l_name,dob,contactno,email;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ftextField;
	private JTextField mtextField;
	private JTextField ltextField;
	private JTextField dtextField;
	private JTextField ctextField;
	private JTextField etextField;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount frame = new CreateAccount();
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
	public CreateAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,400);
		contentPane = new JPanel();
		contentPane.setName("CR1");
		contentPane.setToolTipText("");
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("CREATE NEW ACCOUNT");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setToolTipText("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(189, 27, 207, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FIRST NAME  :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(30, 82, 93, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("MIDDLE NAME  :");
		lblNewLabel_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		lblNewLabel_1_1.setBounds(30, 125, 93, 23);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("LAST NAME  :");
		lblNewLabel_1_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		lblNewLabel_1_2.setBounds(30, 166, 93, 23);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel(" DATE OF BIRTH  :");
		lblNewLabel_1_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		lblNewLabel_1_3.setBounds(30, 212, 93, 23);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("CONTACT NO.  :");
		lblNewLabel_1_4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		lblNewLabel_1_4.setBounds(30, 249, 93, 23);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("EMAIL ID.  :");
		lblNewLabel_1_4_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4_1.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		lblNewLabel_1_4_1.setBounds(30, 282, 93, 23);
		contentPane.add(lblNewLabel_1_4_1);
		
		ftextField = new JTextField();
		ftextField.setHorizontalAlignment(SwingConstants.CENTER);
		ftextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ftextField.setBounds(133, 83, 357, 22);
		contentPane.add(ftextField);
		ftextField.setColumns(10);
		
		mtextField = new JTextField();
		mtextField.setHorizontalAlignment(SwingConstants.CENTER);
		mtextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mtextField.setColumns(10);
		mtextField.setBounds(133, 126, 357, 22);
		contentPane.add(mtextField);
		
		ltextField = new JTextField();
		ltextField.setHorizontalAlignment(SwingConstants.CENTER);
		ltextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ltextField.setColumns(10);
		ltextField.setBounds(133, 167, 357, 22);
		contentPane.add(ltextField);
		
		dtextField = new JTextField();
		dtextField.setHorizontalAlignment(SwingConstants.CENTER);
		dtextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		dtextField.setColumns(10);
		dtextField.setBounds(133, 213, 357, 22);
		contentPane.add(dtextField);
		
		ctextField = new JTextField();
		ctextField.setHorizontalAlignment(SwingConstants.CENTER);
		ctextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ctextField.setColumns(10);
		ctextField.setBounds(133, 250, 357, 22);
		contentPane.add(ctextField);
		
		etextField = new JTextField();
		etextField.setHorizontalAlignment(SwingConstants.CENTER);
		etextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		etextField.setColumns(10);
		etextField.setBounds(133, 283, 357, 22);
		contentPane.add(etextField);
		
		btnNewButton = new JButton("NEXT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetPassword setPassword = new SetPassword();
				setPassword.show();
				dispose();
				f_name = ftextField.getText().toString();
				m_name = mtextField.getText().toString();
				l_name = ltextField.getText().toString();
				dob = dtextField.getText().toString();
				contactno = ctextField.getText().toString();
				email = etextField.getText().toString();
				
			}
		});
		btnNewButton.setName("");
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.setBounds(237, 315, 99, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("(yyyy-mm-dd)");
		lblNewLabel_1_3_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_1_3_1.setBounds(493, 212, 93, 23);
		contentPane.add(lblNewLabel_1_3_1);

	}
}
