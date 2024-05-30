package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConnectDatabase.Connect;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class STUDENTFORM extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField txtHello;
	private JTextField Name;
	private JTextField Phonenum;
	private JTextField Email;
	private JTextField School;
	private JTextField Province;
	private JTextField ID;
	private JTextField textField;
	private COURSESCHECK cocheck;
	public static String Studentid;
	public static String username;
	public static String password;
	
	public static String getusername(){
		return username;
	
	}
	public static void setusername(String username) {
		STUDENTFORM.username = username;
	}
	public static String getpassword(){
		return password;
	
	}
	public static void setpassword(String password) {
		STUDENTFORM.password = password;
	}

	public static String getStudentid() {
		return Studentid;
	}

	public static void setStudentid(String studentid) {
		Studentid = studentid;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					STUDENTFORM frame = new STUDENTFORM();
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
	
	public STUDENTFORM() {
		
		this.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STUDENT FORM");
		lblNewLabel.setBounds(265, 10, 160, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 33, 672, 2);
		add(separator);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(10, 46, 672, 98);
		add(contentPane_1);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setBounds(10, 38, 79, 17);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setBounds(10, 66, 79, 17);
		contentPane_1.add(lblNewLabel_1_1);
		
		txtHello = new JTextField();
		
		txtHello.setColumns(10);
		txtHello.setBounds(99, 36, 203, 20);
		txtHello.setEditable(false);
		contentPane_1.add(txtHello);
		
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(99, 64, 203, 20);
		contentPane_1.add(textField);
		
		JLabel lblAccount = new JLabel("ACCOUNT");
		lblAccount.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAccount.setBounds(99, 0, 160, 25);
		contentPane_1.add(lblAccount);
		
		JButton btnNewButton = new JButton("REFRESH");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connection c = Connect.getConnection();
				try {
					PreparedStatement pst = c.prepareStatement(
						"SELECT Studentid FROM Studentform WHERE Username = ? AND Password = ?");
					pst.setString(1, username);
					pst.setString(2, password);
					ResultSet rs = pst.executeQuery();
					if (rs.next()) {
						setStudentid(rs.getString("Studentid"));
						System.out.println("Day la du lieu id lay tu Studentform va bo vao trong REFRESH");
						System.out.println(Studentid);
					}
					
				} catch (Exception e1) {
					// TODO: handle exception
				}

				ID.setText(Studentid);
					try {
						
						PreparedStatement pst = c.prepareStatement(
								"Select distinct a.Studentid,a.Studentname,a.Studentphonenumber,a.Studentemail,a.Studentschool,a.Studentprovince from StudentAcc as a where a.Studentid = "+ID.getText()+"");
						ResultSet rs = pst.executeQuery();
						while (rs.next()) {
							Name.setText(rs.getString("Studentname"));
							Phonenum.setText(rs.getString("Studentphonenumber"));
							Email.setText(rs.getString("Studentemail"));
							School.setText(rs.getString("Studentschool"));
							Province.setText(rs.getString("Studentprovince"));
						} 
					} catch (Exception e1) {
						// TODO: handle exception
					}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(402, 38, 160, 46);
		contentPane_1.add(btnNewButton);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 147, 672, 7);
		add(separator_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("STUDENT NAME");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(33, 200, 145, 25);
		add(lblNewLabel_1_1_1);
		
		Name = new JTextField();
		Name.setColumns(10);
		Name.setBounds(223, 202, 444, 25);
		Name.setEditable(false);
		add(Name);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("PHONE NUMBER");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(33, 235, 145, 25);
		add(lblNewLabel_1_1_1_1);
		
		Phonenum = new JTextField();
		Phonenum.setColumns(10);
		Phonenum.setBounds(223, 237, 444, 25);
		Phonenum.setEditable(false);
		add(Phonenum);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("EMAIL ADDRESS");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1.setBounds(33, 270, 145, 25);
		add(lblNewLabel_1_1_1_1_1);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(223, 272, 444, 25);
		Email.setEditable(false);
		add(Email);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("SCHOOL");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_2.setBounds(33, 305, 145, 25);
		add(lblNewLabel_1_1_1_1_2);
		
		School = new JTextField();
		School.setColumns(10);
		School.setBounds(223, 307, 444, 25);
		School.setEditable(false);
		add(School);
		
		JLabel lblNewLabel_1_1_1_1_2_1 = new JLabel("PROVINCE");
		lblNewLabel_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_2_1.setBounds(33, 340, 145, 25);
		add(lblNewLabel_1_1_1_1_2_1);
		
		Province = new JTextField();
		Province.setColumns(10);
		Province.setBounds(223, 342, 444, 25);
		Province.setEditable(false);
		add(Province);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("STUDENT ID");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_2.setBounds(33, 165, 145, 25);
		add(lblNewLabel_1_1_1_2);
		
		ID = new JTextField();
		
		ID.setColumns(10);
		ID.setBounds(223, 167, 444, 25);
		ID.setEditable(false);
		add(ID);
		
		
		
		 
	}
	public void studentform(String username,String password, String id2) {
		  
	      ID.setText(id2);
	      setStudentid(id2);
		  setusername(username);
		  setpassword(password);

	      txtHello.setText(username);
	      textField.setText(password);
	      Connection c = Connect.getConnection();
			try {
				
				PreparedStatement pst = c.prepareStatement(
						"Select distinct a.Studentid,a.Studentname,a.Studentphonenumber,a.Studentemail,a.Studentschool,a.Studentprovince from StudentAcc as a where a.Studentid = "+ID.getText()+"");
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					Name.setText(rs.getString("Studentname"));
					Phonenum.setText(rs.getString("Studentphonenumber"));
					Email.setText(rs.getString("Studentemail"));
					School.setText(rs.getString("Studentschool"));
					Province.setText(rs.getString("Studentprovince"));
				} 
			} catch (Exception e) {
				// TODO: handle exception
			}
	    }
}
