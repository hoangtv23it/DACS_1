package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Outcomemanagement extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField SAL;
	private JTextField EQUIP;
	private JLabel lblTngTinPhi;
	private JTextField RENT;
	private JLabel lblTngTinThu;
	private JButton btnNewButton;
	private JButton btnEquipmeng;
	private JButton btnRental;
	private JSeparator separator;
	private JLabel lblNewLabel_1;
	
	public static Double salary;
	public static Double equipment;
	public static Double rental;
	private static Double Sumall;
	public Human hu = new Human();
	public Equipment eq = new Equipment();
	public Rental r = new Rental();
	public static Double getSumall() {
		return Sumall;
	}

	public static void setSumall(Double sumall) {
		Sumall = sumall;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		Outcomemanagement.salary = salary;
	}

	public Double getEquipment() {
		return equipment;
	}

	public void setEquipment(Double equipment) {
		Outcomemanagement.equipment = equipment;
	}

	public Double getRental() {
		return rental;
	}

	public void setRental(Double rental) {
		Outcomemanagement.rental = rental;
	}
	
	Human hum;
	Equipment equ;
	Rental renta;

	public Outcomemanagement() {
		hum = hu;
		equ = eq;
		renta  = r;
		setLayout(null);
		
		SAL = new JTextField();
		SAL.setFont(new Font("Tahoma", Font.PLAIN, 25));
		SAL.setBounds(10, 119, 257, 40);
		add(SAL);
		SAL.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tổng tiền lương trong năm");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 80, 297, 30);
		add(lblNewLabel);
		
		EQUIP = new JTextField();
		EQUIP.setFont(new Font("Tahoma", Font.PLAIN, 25));
		EQUIP.setColumns(10);
		EQUIP.setBounds(10, 212, 257, 40);
		add(EQUIP);
		
		lblTngTinPhi = new JLabel("Tổng tiền phải trả cho thiết bị");
		lblTngTinPhi.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngTinPhi.setBounds(10, 175, 325, 30);
		add(lblTngTinPhi);
		
		RENT = new JTextField();
		RENT.setFont(new Font("Tahoma", Font.PLAIN, 25));
		RENT.setColumns(10);
		RENT.setBounds(10, 305, 257, 40);
		add(RENT);
		
		lblTngTinThu = new JLabel("Tổng tiền thuê mặt bằng trong năm");
		lblTngTinThu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTngTinThu.setBounds(10, 262, 368, 30);
		add(lblTngTinThu);
		
		btnNewButton = new JButton("Human");
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Human hu = new Human();
				hu.setVisible(true);
			}
		});
		btnNewButton.setBounds(361, 119, 200, 40);
		add(btnNewButton);
		
		btnEquipmeng = new JButton("Equipment");
		btnEquipmeng.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnEquipmeng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Equipment eq = new Equipment();
				eq.setVisible(true);
			}
		});
		btnEquipmeng.setBounds(361, 212, 200, 40);
		add(btnEquipmeng);
		
		btnRental = new JButton("Rental");
		btnRental.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnRental.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rental rt = new Rental();
				rt.setVisible(true);
			}
		});
		btnRental.setBounds(361, 302, 200, 40);
		add(btnRental);
		
		separator = new JSeparator();
		separator.setBounds(10, 67, 600, 2);
		add(separator);
		
		lblNewLabel_1 = new JLabel(" TUITION OUTCOME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(214, 10, 257, 66);
		add(lblNewLabel_1);

		String textsal = String.valueOf(hum.getSumLuong1month());
		SAL.setText(textsal);
		SAL.setEditable(false);
		String textequip = String.valueOf(equ.getSumEquipment1month());
		EQUIP.setText(textequip);
		EQUIP.setEditable(false);
		String textrent = String.valueOf(renta.getSum1month());
		RENT.setText(textrent);
		RENT.setEditable(false);
		Sumall =hum.getSumLuong1month() + equ.getSumEquipment1month()+renta.getSum1month();
	}

}
