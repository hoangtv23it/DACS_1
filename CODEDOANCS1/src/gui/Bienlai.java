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
import javax.swing.KeyStroke;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Bienlai extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField Diachi;
    private JTextField Sodienthoai;
    private JTextField Gmail;
    private JTextField Tong;
    private JTextField Studentname;
    public static String Studentid;
    public static String CourseName;
    private JTextField Id;
    private JTextField Khoahoc;
    private JTextField textField;

    public static String getCourseName() {
        return CourseName;
    }

    public static void setCourseName(String courseName) {
        CourseName = courseName;
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
                    Bienlai frame = new Bienlai();
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
    public Bienlai() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 614, 557);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblReciept = new JLabel("BIÊN LAI THU PHÍ");
        lblReciept.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblReciept.setBounds(158, 11, 336, 60);
        contentPane.add(lblReciept);

        JSeparator separator = new JSeparator();
        separator.setBounds(25, 73, 557, 7);
        contentPane.add(separator);

        JLabel lblNewLabel_1_3 = new JLabel("Họ và tên người nộp: ");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_1_3.setBounds(62, 127, 149, 27);
        contentPane.add(lblNewLabel_1_3);

        Connection c = Connect.getConnection();
        try {
            PreparedStatement pstm = c.prepareStatement("Select distinct StudentID from Studentcourses where Debt = 0");
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                // comboBox.addItem(rs.getString("StudentID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblNewLabel_1_3_1 = new JLabel("Địa chỉ");
        lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_1_3_1.setBounds(62, 164, 149, 27);
        contentPane.add(lblNewLabel_1_3_1);

        Diachi = new JTextField();
        Diachi.setEditable(false);
        Diachi.setBounds(264, 169, 298, 20);
        contentPane.add(Diachi);
        Diachi.setColumns(10);

        Sodienthoai = new JTextField();
        Sodienthoai.setEditable(false);
        Sodienthoai.setColumns(10);
        Sodienthoai.setBounds(264, 206, 298, 20);
        contentPane.add(Sodienthoai);

        JLabel lblNewLabel_1_3_1_1 = new JLabel("Số điện thoại:");
        lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_1_3_1_1.setBounds(62, 201, 149, 27);
        contentPane.add(lblNewLabel_1_3_1_1);

        JLabel lblNewLabel_1_3_1_1_1 = new JLabel("Gmail:");
        lblNewLabel_1_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_1_3_1_1_1.setBounds(62, 237, 149, 27);
        contentPane.add(lblNewLabel_1_3_1_1_1);

        Gmail = new JTextField();
        Gmail.setEditable(false);
        Gmail.setColumns(10);
        Gmail.setBounds(264, 242, 298, 20);
        contentPane.add(Gmail);

        JLabel lblNewLabel_1_3_2 = new JLabel("Khóa học muốn thanh toán:");
        lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_1_3_2.setBounds(62, 274, 184, 27);
        contentPane.add(lblNewLabel_1_3_2);

        JLabel lblNewLabel_1_3_1_1_1_1 = new JLabel("Số tiền thu:");
        lblNewLabel_1_3_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_1_3_1_1_1_1.setBounds(62, 349, 149, 27);
        contentPane.add(lblNewLabel_1_3_1_1_1_1);

        Tong = new JTextField();
        Tong.setEditable(false);
        Tong.setColumns(10);
        Tong.setBounds(264, 353, 298, 20);
        contentPane.add(Tong);

        JButton btnPreview = new JButton("XEM BIÊN LAI");
        btnPreview.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logic for printing the receipt
                System.out.println("IN BIÊN LAI button clicked");
                // You can add your logic here
            }
        });
        btnPreview.setBounds(62, 396, 200, 70);
        contentPane.add(btnPreview);

        // Adding key bindings to the root pane for the "IN BIÊN LAI" button
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "clickButton");
        getRootPane().getActionMap().put("clickButton", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPreview.doClick();
            }
        });

        JButton btnReturn = new JButton("Return");
        btnReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Bienlai.this.dispose();
            }
        });
        btnReturn.setBounds(361, 396, 200, 70);
        contentPane.add(btnReturn);

        JLabel lblNewLabel_1_3_4 = new JLabel("ID:");
        lblNewLabel_1_3_4.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_1_3_4.setBounds(62, 90, 149, 27);
        contentPane.add(lblNewLabel_1_3_4);

        Studentname = new JTextField();
        Studentname.setEditable(false);
        Studentname.setColumns(10);
        Studentname.setBounds(264, 132, 298, 20);
        contentPane.add(Studentname);
        
        Id = new JTextField();
        Id.setEditable(false);
        Id.setBounds(264, 95, 300, 20);
        contentPane.add(Id);
        Id.setColumns(10);
        
        Khoahoc = new JTextField();
        Khoahoc.setEditable(false);
        Khoahoc.setBounds(264, 279, 298, 20);
        contentPane.add(Khoahoc);
        Khoahoc.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("ID khóa học:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setBounds(62, 311, 184, 27);
        contentPane.add(lblNewLabel);
        
        textField = new JTextField();
        textField.setEditable(false);
        textField.setBounds(264, 316, 298, 20);
        contentPane.add(textField);
        textField.setColumns(10);
    }
}
