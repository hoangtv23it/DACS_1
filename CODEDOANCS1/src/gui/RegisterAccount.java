package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConnectDatabase.Connect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class RegisterAccount extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	public String username;
	public String password;
	private JTextField textField_1;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterAccount frame = new RegisterAccount();
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
	public RegisterAccount() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 492, 378);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(192, 192, 192));
		setLocationRelativeTo(contentPane);
		
		JLabel lblRegister = new JLabel("REGISTER");
		lblRegister.setForeground(new Color(0, 128, 255));
		lblRegister.setFont(new Font("Jokerman", Font.BOLD, 30));
		lblRegister.setBounds(195, 15, 155, 46);
		contentPane.add(lblRegister);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 64, 466, 20);
		contentPane.add(separator);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(200, 93, 224, 20);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setForeground(new Color(128, 255, 128));
		lblNewLabel_1.setFont(new Font("Jokerman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(44, 94, 99, 17);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ENTER PASSWORD");
		lblNewLabel_1_1.setForeground(new Color(128, 255, 128));
		lblNewLabel_1_1.setFont(new Font("Jokerman", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(44, 153, 146, 17);
		contentPane.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(200, 152, 224, 20);
		contentPane.add(passwordField);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.setForeground(new Color(0, 0, 0));
		btnRegister.setFont(new Font("Jokerman", Font.PLAIN, 15));
		
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				setUsername(username);
				String password = new String(passwordField.getPassword());
				setPassword(password);
				String reenter = new String(passwordField_1.getPassword());
				String eop = textField_1.getText();
					int i = 0;
					if (!username.isEmpty() && !password.isEmpty() && !reenter.isEmpty()&&!eop.isEmpty() ) {
						Connection c = Connect.getConnection();

//						

						try {
							PreparedStatement pst1 = c.prepareStatement("Select Username,Pass from Studentform ");
							ResultSet rs = pst1.executeQuery();
							while (rs.next()) {
								if (username.equals(rs.getString("Username"))
										&& password.equals(rs.getString("Pass"))) {
									i = 0;
									JOptionPane.showMessageDialog(RegisterAccount.this, "Tài khoản đã tồn tại vui lòng đăng nhập",
											"", JOptionPane.ERROR_MESSAGE);
									break;
								}
								else if(!(password.equals(reenter))) {
									JOptionPane.showMessageDialog(RegisterAccount.this, "Mật khẩu không khớp vui lòng nhập lại", "", JOptionPane.ERROR_MESSAGE);
									i = 0;
									break;
								}
								else
									i++;

							}
							if (i >= 1) {
								try {
									PreparedStatement pst = c
											.prepareStatement("INSERT INTO Studentform(Username,Pass) values (?,?) ");
									pst.setString(1, username);
									pst.setString(2, password);
									pst.executeUpdate();
									JOptionPane.showMessageDialog(RegisterAccount.this, "Đăng kí tài khoản thành công", "",
											JOptionPane.INFORMATION_MESSAGE);
								} catch (Exception e2) {
									// TODO: handle exception
									e2.printStackTrace();
								}
							}
						} catch (Exception e2) {
							// TODO: handle exception
							e2.getMessage();

						}

					} else {
						JOptionPane.showMessageDialog(RegisterAccount.this, "Không được để trống", "", JOptionPane.ERROR_MESSAGE);
					}
				
			}
		});
		btnRegister.setBounds(83, 305, 109, 23);
		contentPane.add(btnRegister);
		
		

	    
		
		JButton btnCancel = new JButton("RETURN");
		btnCancel.setForeground(new Color(0, 0, 0));
		btnCancel.setFont(new Font("Jokerman", Font.PLAIN, 15));
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterAccount.this.dispose();
				LOGIN_2 log = new LOGIN_2();
				log.setVisible(true);
			}
		});
		btnCancel.setBounds(254, 305, 108, 23);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("RE-ENTER PASSWORD");
		lblNewLabel_1_1_1.setForeground(new Color(128, 255, 128));
		lblNewLabel_1_1_1.setFont(new Font("Jokerman", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(44, 213, 146, 17);
		contentPane.add(lblNewLabel_1_1_1);
		
		passwordField_1 = new JPasswordField();
		
		passwordField_1.setBounds(200, 212, 224, 20);
		contentPane.add(passwordField_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("EMAIL OR PHONE");
		lblNewLabel_1_1_1_1.setForeground(new Color(128, 255, 128));
		lblNewLabel_1_1_1_1.setFont(new Font("Jokerman", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1.setBounds(44, 266, 140, 17);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(200, 265, 224, 20);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			private int clickCount = 0;
			public void actionPerformed(ActionEvent e) {
				if (clickCount % 2 == 0) {
                    // Hiển thị mật khẩu
                    passwordField.setEchoChar('\0');
                } else {
                    // Ẩn mật khẩu
                    passwordField.setEchoChar('\u2022');
                }
                clickCount++;
            
			}
		});
		btnNewButton.setBounds(434, 151, 24, 23);
		scaleImagebtn("F:\\CodeJava_NBean\\CODEDOANCS1\\src\\img\\pngwing.com.png", btnNewButton);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			private int Count = 0;
			public void actionPerformed(ActionEvent e) {
				
				if (Count % 2 == 0) {
                    // Hiển thị mật khẩu
                    passwordField_1.setEchoChar('\0');
                } else {
                    // Ẩn mật khẩu
                    passwordField_1.setEchoChar('\u2022');
                }
                Count++;
			}
		});
		btnNewButton_1.setBounds(434, 211, 24, 23);
		scaleImagebtn("F:\\CodeJava_NBean\\CODEDOANCS1\\src\\img\\pngwing.com.png", btnNewButton_1);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(134, 11, 50, 50);
		scaleImage("F:\\\\CodeJava_NBean\\\\CODEDOANCS1\\\\src\\\\img\\\\register.256x256.png", lblNewLabel);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, 85, 30, 30);
		scaleImage("F:\\CodeJava_NBean\\CODEDOANCS1\\src\\img\\user-solid.png", lblNewLabel_2);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(10, 140, 30, 30);
		scaleImage("F:\\CodeJava_NBean\\CODEDOANCS1\\src\\img\\pass-solid.png", lblNewLabel_3);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(10, 200, 30, 30);
		scaleImage("F:\\CodeJava_NBean\\CODEDOANCS1\\src\\img\\change-password-icon.png", lblNewLabel_4);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(10, 254, 30, 30);
		scaleImage("F:\\CodeJava_NBean\\CODEDOANCS1\\src\\img\\email_5084772.png", lblNewLabel_5);
		contentPane.add(lblNewLabel_5);
	}
	
	private void scaleImage(String location, JLabel label){
	    ImageIcon icon = new ImageIcon(location);
	    Image img = icon.getImage();
	    Image imgScale = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
	    ImageIcon scaledIcon = new ImageIcon(imgScale);
	    label.setIcon(scaledIcon);
	}
	
	private void scaleImagebtn(String location, JButton btn){
		    ImageIcon icon = new ImageIcon(location);
		    Image img = icon.getImage();
		    Image imgScale = img.getScaledInstance(btn.getWidth(), btn.getHeight(), Image.SCALE_SMOOTH);
		    ImageIcon scaledIcon = new ImageIcon(imgScale);
		    btn.setIcon(scaledIcon);
	
	}
}
	