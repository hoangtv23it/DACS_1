package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConnectDatabase.Connect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.print.attribute.standard.JobOriginatingUserName;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class STUDENTREGISTER extends JPanel {

	private static final long serialVersionUID = 1L;
	
//	private AdminMain adminmain = new AdminMain();
	private String id;
	private String user;
	private String pass;
	private JTextField Name;
	private JTextField PHONE;
	private JTextField EMAIL;
	private JTextField SCHOOL;
	private JTextField PROVINCE;
	private boolean hasException = false;
	private static final List<String> validCities = (List<String>) Arrays.asList(
            "Hà Nội",
            "Hồ Chí Minh",
            "Đà Nẵng",
            "Hải Phòng",
            "Cần Thơ",
            "An Giang",
            "Bà Rịa - Vũng Tàu",
            "Bạc Liêu",
            "Bắc Kạn",
            "Bắc Giang",
            "Bắc Ninh",
            "Bến Tre",
            "Bình Dương",
            "Bình Định",
            "Bình Phước",
            "Bình Thuận",
            "Cà Mau",
            "Cao Bằng",
            "Đắk Lắk",
            "Đắk Nông",
            "Điện Biên",
            "Đồng Nai",
            "Đồng Tháp",
            "Gia Lai",
            "Hà Giang",
            "Hà Nam",
            "Hà Tĩnh",
            "Hải Dương",
            "Hậu Giang",
            "Hòa Bình",
            "Hưng Yên",
            "Khánh Hòa",
            "Kiên Giang",
            "Kon Tum",
            "Lai Châu",
            "Lâm Đồng",
            "Lạng Sơn",
            "Lào Cai",
            "Long An",
            "Nam Định",
            "Nghệ An",
            "Ninh Bình",
            "Ninh Thuận",
            "Phú Thọ",
            "Quảng Bình",
            "Quảng Nam",
            "Quảng Ngãi",
            "Quảng Ninh",
            "Quảng Trị",
            "Sóc Trăng",
            "Sơn La",
            "Tây Ninh",
            "Thái Bình",
            "Thái Nguyên",
            "Thanh Hóa",
            "Thừa Thiên Huế",
            "Tiền Giang",
            "Trà Vinh",
            "Tuyên Quang",
            "Vĩnh Long",
            "Vĩnh Phúc",
            "Yên Bái"
    );
	

	
//	private String Username;
//	public String getUsername() {
//		return Username;
//	}
//
//	public void setUsername(String username) {
//		Username = username;
//	}
//	
	public static String realid;




	public static String getRealid() {
		return realid;
	}

	public void setRealid(String realid) {
		STUDENTREGISTER.realid = realid;
	}
	
	public STUDENTREGISTER() {
//		
//		log = new Login();
//		
	
		this.setLayout(null);

		JLabel lblNewLabel = new JLabel("REGISTER STUDENT");
		lblNewLabel.setBounds(223, 14, 235, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 50, 657, 2);
		add(separator);

		JLabel lblNewLabel_1_1 = new JLabel("NAME");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(33, 63, 145, 25);
		add(lblNewLabel_1_1);

		Name = new JTextField();
		Name.setColumns(10);
		Name.setBounds(223, 63, 444, 25);
		add(Name);

		JLabel lblNewLabel_1_1_1 = new JLabel("PHONE NUMBER");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(33, 99, 145, 25);
		add(lblNewLabel_1_1_1);

		PHONE = new JTextField();
		PHONE.setColumns(10);
		PHONE.setBounds(223, 103, 444, 25);
		add(PHONE);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("EMAIL ADDRESS");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(33, 135, 145, 25);
		add(lblNewLabel_1_1_1_1);

		EMAIL = new JTextField();
		EMAIL.setColumns(10);
		EMAIL.setBounds(223, 139, 444, 25);
		add(EMAIL);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 264, 658, 2);
		add(separator_1);

//		STUDENTFORM st = new STUDENTFORM();
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Day la khi nhan nut register va lay realid");
				System.out.println(realid);
				if(realid != null) {
					JOptionPane.showMessageDialog(STUDENTREGISTER.this, "Bạn đã đăng kí học sinh rồi bây giờ bạn có thể chọn khóa học", "", JOptionPane.WARNING_MESSAGE);
				}
				else {
					
					String studentname = Name.getText();
					String phonenumber = PHONE.getText();
					try {
						validatePhoneNumber(phonenumber);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String email = EMAIL.getText();
					try {
						validateEmail(email);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String school = SCHOOL.getText();
					String province = PROVINCE.getText();
					try {
						validateCity(province);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (hasException || studentname.isEmpty() || phonenumber.isEmpty() || email.isEmpty()
							|| school.isEmpty() || province.isEmpty()) {
						JOptionPane.showMessageDialog(STUDENTREGISTER.this, "Vui lòng nhập đầy đủ và hợp lệ!!", "",
								JOptionPane.WARNING_MESSAGE);
					} else {
						
						String id = random()+"";
						setRealid(id);
						Connection c = Connect.getConnection();
						try {
							PreparedStatement pstm1 = c.prepareStatement("INSERT INTO StudentAcc(Studentid,Studentname,Studentphonenumber,Studentemail,Studentschool,StudentProvince) VALUES (?,?,?,?,?,?)");
							pstm1.setString(1, id);
							pstm1.setString(2, studentname);
							pstm1.setString(3, phonenumber);
							pstm1.setString(4, email);
							pstm1.setString(5, school);
							pstm1.setString(6, province);
							
							pstm1.executeUpdate();
							
							
							
							
						if(realid != null) {
							System.out.println("Day la cua register");
							System.out.println(realid);
							System.out.println(user);
							System.out.println(pass);
							
							PreparedStatement pstm2 = c.prepareStatement("Update Studentform SET Studentid = ? where Username = ? and Pass = ?");
							pstm2.setString(1, realid);
							pstm2.setString(2, user);
							pstm2.setString(3, pass);
							pstm2.executeUpdate();
							}
						} catch (SQLException ex) {
							// TODO Auto-generated catch block
							ex.printStackTrace();
						}
						
					
						JOptionPane.showMessageDialog(STUDENTREGISTER.this, "Đăng kí học sinh thành công!!", "",
								JOptionPane.INFORMATION_MESSAGE);


						JOptionPane.showMessageDialog(STUDENTREGISTER.this,
								"Bạn đã đăng kí học sinh rồi vui lòng login lại để có thể chọn khóa học", "",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}	
		});
		btnRegister.setBounds(163, 277, 125, 33);
		add(btnRegister);

		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Name.setText("");
				PHONE.setText("");
				EMAIL.setText("");
				SCHOOL.setText("");
				PROVINCE.setText("");
			}
		});
		btnCancel.setBounds(368, 277, 125, 33);
		add(btnCancel);

		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("SCHOOL");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_2.setBounds(33, 171, 145, 25);
		add(lblNewLabel_1_1_1_1_2);

		SCHOOL = new JTextField();
		SCHOOL.setColumns(10);
		SCHOOL.setBounds(223, 175, 444, 25);
		add(SCHOOL);

		JLabel lblNewLabel_1_1_1_1_2_1 = new JLabel("PROVINCE");
		lblNewLabel_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_2_1.setBounds(33, 211, 145, 25);
		add(lblNewLabel_1_1_1_1_2_1);

		PROVINCE = new JTextField();
		PROVINCE.setColumns(10);
		PROVINCE.setBounds(223, 215, 444, 25);
		add(PROVINCE);
		
		JButton btnNewButton = new JButton("ResetCheck");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hasException = false;
			}
		});
		btnNewButton.setBounds(20, 272, 85, 21);
		add(btnNewButton);
	}

	public static int random() {
		int min = 10000;
		int max = 99999;
		int a = (int) (Math.random() * (max - min + 1) + min);
		return a;

	}
	public void getuserandpass(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}
	 public void validateEmail(String email) throws Exception {
	        
	    	   try {
				if (!email.matches( "^(.+)@(\\S+)$")) {
					throw new Exception("Email không hợp lệ");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(STUDENTREGISTER.this, "Email không hợp lệ", "",
						JOptionPane.WARNING_MESSAGE);
				hasException = true;
				
			}
	        }
	    
	    public void validatePhoneNumber(String phoneNumber) throws Exception {
	        try {
				if (!phoneNumber.matches("^[0-9]{10}$")) {
					throw new Exception("Số điện thoại không hợp lệ");
				} 
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(STUDENTREGISTER.this, "Số đt không hợp lệ", "",
						JOptionPane.WARNING_MESSAGE);
				hasException = true;
				
			}
	    }
	    public void validateCity(String cityName) throws Exception {
	        try {
				if (!validCities.contains(cityName)) {
					throw new Exception("Tên tỉnh/thành phố không hợp lệ");
				} 
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(STUDENTREGISTER.this, "Tỉnh không hợp lệ", "",
						JOptionPane.WARNING_MESSAGE);
				hasException = true;
				
			}
	    }
}
