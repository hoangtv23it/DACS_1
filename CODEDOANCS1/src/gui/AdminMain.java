package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminMain extends JFrame {
	private JMenuBar menu = new JMenuBar();
	private JMenu accnew = new JMenu("Account");
	private JMenuItem logout = new JMenuItem("Log out");
	private Incomemanagement incomemanagement = new Incomemanagement();
	private Outcomemanagement outcomemanagement = new Outcomemanagement();
	private ADMINTABLECOURSES admintablecourses = new ADMINTABLECOURSES();
	private ADMINTABLESTUDENT admintablestudent = new ADMINTABLESTUDENT();
	private Administrator administrator = new Administrator();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardlayout = new CardLayout(0, 0);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMain frame = new AdminMain();
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
	public AdminMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1551, 769);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		menu.add(accnew);
		accnew.add(logout);
		this.setJMenuBar(menu);
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					AdminMain.this.dispose();
					new LOGIN_2().setVisible(true);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		
		JPanel menu = new JPanel();
		menu.setBackground(new Color(192, 192, 192));
		
		JPanel contentpanel = new JPanel();
		contentpanel.setLayout(cardlayout);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 204));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EDUCATION MANAGEMENT");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(0, 0, 280, 98);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				incomemanagement.setVisible(false);
				outcomemanagement.setVisible(false);
				admintablecourses.setVisible(false);
				admintablestudent.setVisible(false);
				administrator.setVisible(true);
			}
		});
		panel_2.setBackground(new Color(0, 0, 255));
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				incomemanagement.setVisible(true);
				admintablecourses.setVisible(false);
				admintablestudent.setVisible(false);
				administrator.setVisible(false);
				outcomemanagement.setVisible(false);
				
			}
		});
		panel_3.setBackground(new Color(0, 0, 255));
		panel_3.setForeground(new Color(0, 0, 204));
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				incomemanagement.setVisible(false);
				admintablecourses.setVisible(false);
				outcomemanagement.setVisible(true);
				admintablestudent.setVisible(false);
				administrator.setVisible(false);
				
			}
		});
		panel_4.setBackground(new Color(0, 0, 255));
		
		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				incomemanagement.setVisible(false);
				admintablecourses.setVisible(true);
				outcomemanagement.setVisible(false);
				admintablestudent.setVisible(false);
				administrator.setVisible(false);
			}
		});
		panel_5.setBackground(new Color(0, 0, 255));
		
		JPanel panel_6 = new JPanel();
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				incomemanagement.setVisible(false);
				outcomemanagement.setVisible(false);
				admintablecourses.setVisible(false);
				administrator.setVisible(false);
				admintablestudent.setVisible(true);
			}
		});
		panel_6.setBackground(new Color(0, 0, 255));
		
		JLabel lblNewLabel_2 = new JLabel("Incomemanagement");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(0, 0, 280, 60);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Statistics");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(0, 0, 280, 60);
		panel_2.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(menu, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1226, Short.MAX_VALUE)
						.addComponent(contentpanel, GroupLayout.DEFAULT_SIZE, 1226, Short.MAX_VALUE))
					.addGap(15))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(menu, GroupLayout.PREFERRED_SIZE, 708, GroupLayout.PREFERRED_SIZE)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(contentpanel, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE)
					.addGap(60))
		);
		GroupLayout gl_menu = new GroupLayout(menu);
		gl_menu.setHorizontalGroup(
			gl_menu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menu.createSequentialGroup()
					.addGroup(gl_menu.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_menu.setVerticalGroup(
			gl_menu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menu.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(76)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
		);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Student management");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(0, 0, 280, 60);
		panel_6.add(lblNewLabel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("course management");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setEnabled(true);
		lblNewLabel_4.setBounds(0, 0, 280, 60);
		panel_5.add(lblNewLabel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Outcomemanagement");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 0, 280, 60);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_3);
		menu.setLayout(gl_menu);
		contentPane.setLayout(gl_contentPane);
		contentpanel.add(administrator);
		
		//Bỏ các JPanel vào CardLayout
		contentpanel.add(incomemanagement);
		contentpanel.add(outcomemanagement);
		contentpanel.add(admintablecourses);
		contentpanel.add(admintablestudent);
		
		//Hiển thị thẻ ban đầu 
		cardlayout.show(contentpanel, "administrator");
	}
}
