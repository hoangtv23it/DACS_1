package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConnectDatabase.Connect;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LOGIN_2 extends JFrame {

	private JPanel contentPane;
	public JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	private StudentMain sm;
	private AdminMain am;
	private STUDENTFORM sf;
	private RegisterAccount re; 
	public String id;
	public static String username;
	public static String password;
	
	Equipment eq;
	Human a;
	Rental r;
	
	public static String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		LOGIN_2.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		LOGIN_2.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LOGIN_2 frame = new LOGIN_2();
					frame.setVisible(true);
					frame.setResizable(false);	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LOGIN_2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setIcon(new ImageIcon("F:\\CodeJava\\DoAnCoSo1\\CODEDOANCS1\\src\\img\\bg_login.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 300, 365);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(300, 0, 331, 365);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setForeground(new Color(0, 128, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Jokerman", Font.PLAIN, 40));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 10, 315, 59);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("F:\\CodeJava\\DoAnCoSo1\\CODEDOANCS1\\src\\img\\user-solid.png"));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(25, 92, 45, 45);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("F:\\CodeJava\\DoAnCoSo1\\CODEDOANCS1\\src\\img\\pass-solid.png"));
		lblNewLabel_3.setBounds(25, 169, 45, 45);
		panel.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(79, 92, 200, 45);
		panel.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Jokerman", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "ADMIN", "STUDENT" }));
		comboBox.setBounds(79, 230, 96, 25);
		panel.add(comboBox);
		
		btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String username = textField.getText();
				setUsername(username);
				String password = new String(passwordField.getPassword());
				setPassword(password);
				String right = (String) comboBox.getSelectedItem();
				
				
				if (right == "ADMIN") {
				    if (username.equals("admin") && password.equals("admin123")) {      
				        am = new AdminMain();
				        am.setVisible(true); // Hiển thị JFrame của Administrator
				        LOGIN_2.this.dispose(); // Đóng cửa sổ đăng nhập
				    } else {
				        JOptionPane.showMessageDialog(LOGIN_2.this, "Đăng nhập thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
				    }
				} else if (right == "STUDENT") {
					int i = 0;
					if (!username.isEmpty() && !password.isEmpty()) {
						Connection c = Connect.getConnection();

						try {
							PreparedStatement pst1 = c.prepareStatement("Select Username,Pass,Studentid from Studentform ");
							ResultSet rs = pst1.executeQuery();
							while (rs.next()) {
								if (username.equals(rs.getString("Username"))
									&& password.equals(rs.getString("Pass"))) {
									
									i = 0;
									setId(rs.getString("Studentid"));
									
									
									sm = new StudentMain();
									sm.setInfoAccount(getUsername(), getPassword(), getId());
									sm.setVisible(true);
//									System.out.println(getUsername() + " " + getPassword());System.out.println(getUsername() + " " + getPassword() + " " + getId() );
									
									LOGIN_2.this.dispose();
									break;
								} else
									i++;

							}

						} catch (Exception e2) {
							// TODO: handle exception
							e2.getMessage();

						}
						if (i >= 1) {
							JOptionPane.showMessageDialog(LOGIN_2.this,
									"Mật khẩu hoặc tên đăng nhập bị sai vui lòng đăng nhập lại hoặc tạo tài khoản mới!!",
									"", JOptionPane.ERROR_MESSAGE);
						}

					} else {
						JOptionPane.showMessageDialog(LOGIN_2.this, "Không được để trống", "", JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setFont(new Font("Jokerman", Font.PLAIN, 20));
		btnNewButton.setBounds(49, 292, 110, 35);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				re = new RegisterAccount();
				re.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(0, 255, 255));
		btnNewButton_1.setFont(new Font("Jokerman", Font.PLAIN, 20));
		btnNewButton_1.setBounds(199, 292, 110, 35);
		panel.add(btnNewButton_1);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(80, 169, 200, 45);
		panel.add(passwordField);
	}
}
