package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Administrator extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField Income;
	private JTextField OUT;
	
	Outcomemanagement out = new Outcomemanagement();
	Incomemanagement in = new Incomemanagement();
	
	public Administrator() {
		
		this.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 107, 557, 49);
		add(separator);
		
		JLabel lblNewLabel = new JLabel("ADMIN FORM");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(180, 11, 258, 143);
		add(lblNewLabel);
		
		Income = new JTextField();
		Income.setEditable(false);
		Income.setBounds(82, 197, 164, 34);
		add(Income);
		Income.setColumns(10);
		
		String formattedNumber1 = String.format("%.2f tỷ",in.getSumIn() / 1_000_000_000L);
		Income.setText(formattedNumber1);
		
		OUT = new JTextField();
		OUT.setEditable(false);
		OUT.setColumns(10);
		OUT.setBounds(332, 197, 164, 34);
		add(OUT);
		String formattedNumber2 = String.format("%.2f tỷ", out.getSumall() / 1_000_000_000L);
	
		OUT.setText(formattedNumber2);
	
		
		JLabel lblNewLabel_1 = new JLabel("TOTAL INCOME");
		lblNewLabel_1.setBounds(123, 167, 164, 19);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("TOTAL OUTCOME");
		lblNewLabel_1_1.setBounds(368, 167, 164, 19);
		add(lblNewLabel_1_1);
	}

}
