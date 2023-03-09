package ConnJDBC;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import FrameBenhAn.FrameBenhAn;
import User.UserLogin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;


import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.GridLayout;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	public static JTextField txtTaiKhoan;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					com.sun.java.swing.plaf.gtk.GTKLookAndFeel
//					com.sun.java.swing.plaf.motif.MotifLookAndFeel
//					com.sun.java.swing.plaf.windows.WindowsLookAndFeel
					
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					Login frame = new Login();
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
	public Login() {
		// Set title
		super("Hệ thống quản lý hồ sơ bệnh án");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		setResizable(false); // Don't resize
		setLocationRelativeTo(null);
		ImageIcon imageDoctor = new ImageIcon("doctor.png");
		setIconImage(imageDoctor.getImage()); // change icon
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(359, 154, 191, 35);
		contentPane.add(passwordField);
		passwordField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER ) {
					JDBCData cn = new JDBCData();
					Connection conn = null;
					try {
						conn = cn.getConnection();
						// NOTE : a' or 1=1-- can hack to sql sever 
						
						String sql = "select * from Users where username = ? and password=?";
																			 
						PreparedStatement pst = conn.prepareCall(sql);
						pst.setString(1, txtTaiKhoan.getText());
						pst.setString(2, passwordField.getText());
						ResultSet rs = pst.executeQuery();
						
						if(rs.next()) {
							FrameBenhAn fr = new FrameBenhAn();
							fr.show(); // Show FrameBenhNhan
							dispose();
							
						} else {
							JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu!","Lỗi!",JOptionPane.ERROR_MESSAGE);

						}
					} catch (Exception ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu!","Lỗi!",JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTaiKhoan.setBounds(359, 93, 191, 35);
		contentPane.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		txtTaiKhoan.addKeyListener(new KeyListener() {
		
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu!","Lỗi!",JOptionPane.INFORMATION_MESSAGE);

				}
			}
		});
		
		JButton btnThoat = new JButton("Tho\u00E1t");
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 15));
/* 
 * Button để thoát
 */		
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnThoat.setBounds(475, 220, 75, 63);
		contentPane.add(btnThoat);
/* 
 * end 
 */		
		
		
/* 
 * Button đăng nhập vào hệ thống 
 */
		JButton btnDangNhap = new JButton("\u0110\u0103ng nh\u1EADp");
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnDangNhap.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JDBCData cn = new JDBCData();
				Connection conn = null;
				try {
					conn = cn.getConnection();
					// NOTE : a' or 1=1-- can hack to sql sever 
					
					String sql = "select * from Users where username = ? and password=?";
																		 
					PreparedStatement pst = conn.prepareCall(sql);
					pst.setString(1, txtTaiKhoan.getText());
					pst.setString(2, passwordField.getText());
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()) {
						FrameBenhAn fr = new FrameBenhAn();
						fr.show(); // Show FrameBenhNhan
						dispose();
						
					} else {
						JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu!","Lỗi!",JOptionPane.ERROR_MESSAGE);

					}
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu!","Lỗi!",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDangNhap.setBounds(360, 220, 105, 63);
		contentPane.add(btnDangNhap);
/* 
 * end 
 */	
		JPanel panelTieuDe = new JPanel();
		panelTieuDe.setBackground(new Color(84, 186, 185));
		panelTieuDe.setBounds(88, 383, 413, 52);
		contentPane.add(panelTieuDe);
		
		JLabel lbTieuDe = new JLabel("Hệ thống quản lý hồ sơ bệnh án");
			
		lbTieuDe.setFont(new Font("Segoe UI Black", Font.ITALIC, 25));
		lbTieuDe.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelTieuDe.add(lbTieuDe);
		
		// Icon Login
		JPanel panelLogin = new JPanel();
		ImageIcon iconLogin = new ImageIcon("../HoSoBenhAn/res/images/login.png");
			panelLogin.setLayout(new GridLayout(0, 1, 0, 0));
			
			JLabel lbImage = new JLabel();
			lbImage.setHorizontalAlignment(SwingConstants.CENTER);
				lbImage.setIcon(iconLogin);
				panelLogin.add(lbImage);
		panelLogin.setBounds(37, 92, 191, 191);
		
		contentPane.add(panelLogin);
		
		JLabel lbTaiKhoan = new JLabel("Tài khoản");
		lbTaiKhoan.setIcon(new ImageIcon("../HoSoBenhAn/res/images/user.png"));
		lbTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbTaiKhoan.setBounds(266, 103, 92, 14);
		contentPane.add(lbTaiKhoan);
		
		JLabel lbMatKhau = new JLabel("Mật khẩu");
		lbMatKhau.setIcon(new ImageIcon("../HoSoBenhAn/res/images/pass.png"));
		lbMatKhau.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbMatKhau.setBounds(266, 161, 92, 22);
		contentPane.add(lbMatKhau);
		
		JLabel lbBackGround = new JLabel("");
		lbBackGround.setIcon(new ImageIcon("../HoSoBenhAn/res/images/doctorBackground.png"));
		lbBackGround.setBounds(0, 0, 584, 461);
		contentPane.add(lbBackGround);
	}
}
