package FrameBenhAn;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import BacSy.BacSy;
import BacSy.BacSyData;
import BenhNhan.BenhNhan;
import BenhNhan.BenhNhanData;
import ConnJDBC.Login;
import HoTro.ServerChatter;
import Server.IServer;

import javax.swing.UIManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.Naming;

public class FrameBenhAn extends JFrame{

	private JPanel contentPane;
	private JComboBox cbbGioiTinh;
	private JTextField txtTimKiemTen;
	private JTextField txtTimKiemID;
	private JTextField txtIDBN;
	private JTextField txtName;
	private JTextField txtNoiSinh;
	private	 JTextField txtCanNang;
	private JTextField txtChieuCao;
	private JTextField txtNhomMau;
	private JTextField txtSDT;
	private JTextField txtBenhLayNhiem;
	private JTextField txtBenhTieuHoa;
	private JTextField txtBenhTimMach;
	private JTextField txtBenhVeThan;
	private JTextField txtBenhHoHap;
	private JTextField txtBenhVeDa;
	private JTextField txtChanDoan;
	private JTextField txtLocBenhNhan;
	private JTextField txtNamSinh;
	private JTextField txtTimKiemTenBS;
	private JTextField txtTimKiemIDBS;
	
	private JTextField txtIDBS;
	private JTextField txtTenBacSy;
	private JTextField txtChuyenMon;
	private JTextField txtLocBacSy;
	private JTextField txtKinhNghiem;
	private JTextField txtNamSinhBSS;
	public static JTable tableShowData2;
	public static JTable tableShowDataBS;
	public static JTable tableShowDataBacSy;
	public static JTable tableShowDataBenhNhan;
	private JTextField txtTrinhDo;
	private JTextField txtKhoa;
	private JTextField textField;
	

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
					FrameBenhAn frame = new FrameBenhAn();
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
	public FrameBenhAn() {
		super("Hệ thống quản lý hồ sơ bệnh án");
		
/*
 * Kết nối server
 */
		try {
			IServer iServer = (IServer) Naming.lookup("rmi://localhost:1099/db");
			JOptionPane.showMessageDialog(null, "Đã kết nối với server", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Chưa kết nối với server", "Thông Báo", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
			
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1150, 760);
		setLocationRelativeTo(null);
		ImageIcon imageDoctor = new ImageIcon("../HoSoBenhAn/res/images/doctor.png");
		setIconImage(imageDoctor.getImage()); // change icon
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(7, 34, 39));
		panel.setPreferredSize(new Dimension(200, 100));
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(7, 34, 39));
		panel_3.setBorder(new MatteBorder(3, 3, 3, 3, new Color(253, 233, 201)));
		panel_3.setBounds(10, 11, 180, 106);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText("PATIENT");
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setForeground(new Color(174, 254, 255));
		lblNewLabel.setBounds(10, 11, 160, 27);
		panel_3.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 128, 180, 180);
		panel.add(panel_2);
		
		JLabel logo = new JLabel();
		ImageIcon iconLogo = new ImageIcon("../HoSoBenhAn/res/images/logo.png");
			panel_2.setLayout(new GridLayout(0, 1, 0, 0));
			logo.setIcon(iconLogo);
			
		panel_2.add(logo);
		
		JLabel lblSystem = new JLabel();
		lblSystem.setText("MANAGEMENT\r\n");
		lblSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblSystem.setForeground(new Color(174, 254, 255));
		lblSystem.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblSystem.setBounds(10, 40, 160, 27);
		panel_3.add(lblSystem);
		
		JLabel lblSystem_1 = new JLabel();
		lblSystem_1.setText("SYSTEM\r\n");
		lblSystem_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSystem_1.setForeground(new Color(174, 254, 255));
		lblSystem_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblSystem_1.setBounds(31, 68, 117, 27);
		panel_3.add(lblSystem_1);
		
		JButton btnTrangChu = new JButton("Trang chủ");
		
		btnTrangChu.setIcon(new ImageIcon("../HoSoBenhAn/res/images/trangchu.png"));
		btnTrangChu.setBorder(null);
		btnTrangChu.setForeground(Color.WHITE);
		btnTrangChu.setFont(new Font("Segoe UI Semibold", Font.BOLD, 22));
		btnTrangChu.setBackground(new Color(7, 34, 39));
		btnTrangChu.setBounds(20, 323, 160, 47);
		panel.add(btnTrangChu);
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("../HoSoBenhAn/res/images/doctorman.png"));
		lblNewLabel_1.setBounds(0, 606, 145, 145);
		panel.add(lblNewLabel_1);
		
		JButton btnDangXuat = new JButton("Đăng\r\n xuất");
		btnDangXuat.setIcon(new ImageIcon("../HoSoBenhAn/res/images/logout.png"));
		btnDangXuat.setForeground(Color.WHITE);
		btnDangXuat.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		btnDangXuat.setBorder(null);
		btnDangXuat.setBackground(new Color(179, 48, 48));
		btnDangXuat.setBounds(88, 654, 110, 47);
		btnDangXuat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Login lg = new Login();
				lg.show();
				dispose();
			}
		});
		panel.add(btnDangXuat);
		
		JButton btnCapNhat = new JButton("Bệnh nhân");
		
		btnCapNhat.setIcon(new ImageIcon("../HoSoBenhAn/res/images/patienticon.png"));
		btnCapNhat.setForeground(Color.WHITE);
		btnCapNhat.setFont(new Font("Segoe UI Semibold", Font.BOLD, 22));
		btnCapNhat.setBorder(null);
		btnCapNhat.setBackground(new Color(7, 34, 39));
		btnCapNhat.setBounds(20, 388, 160, 47);
		panel.add(btnCapNhat);
		
		JButton btnBcS = new JButton("Bác Sỹ");
		btnBcS.setIcon(new ImageIcon("../HoSoBenhAn/res/images/doctoricon.png"));
		btnBcS.setForeground(Color.WHITE);
		btnBcS.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
		btnBcS.setBorder(null);
		btnBcS.setBackground(new Color(7, 34, 39));
		btnBcS.setBounds(20, 453, 160, 47);
		panel.add(btnBcS);
		
		JButton btnChat = new JButton("Hỗ trợ");
		btnChat.setIcon(new ImageIcon("../HoSoBenhAn/res/images/support.png"));
		btnChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServerChatter st = new ServerChatter();
				st.show();
			}
		});
		btnChat.setForeground(Color.WHITE);
		btnChat.setFont(new Font("Segoe UI Semibold", Font.BOLD, 28));
		btnChat.setBorder(null);
		btnChat.setBackground(new Color(7, 34, 39));
		btnChat.setBounds(20, 518, 160, 47);
		panel.add(btnChat);
		
		
		// Card Layout bruh bruh
		
		JPanel cardpanel = new JPanel();
		contentPane.add(cardpanel, BorderLayout.CENTER);
		cardpanel.setLayout(new CardLayout(0, 0));
		
		JPanel viewInformation = new JPanel();
		viewInformation.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		cardpanel.add(viewInformation, "name_2480645089485400");
		viewInformation.setLayout(null);
		
		JPanel pnBenhNhan = new JPanel();
		pnBenhNhan.setBounds(150, 150, 250, 250);
		viewInformation.add(pnBenhNhan);
		
		
		
		JPanel viewBenhNhan = new JPanel();
		cardpanel.add(viewBenhNhan, "name_2663391137604200");
		viewBenhNhan.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setInheritsPopupMenu(true);
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setPreferredSize(new Dimension(0, 600));
		viewBenhNhan.add(scrollPane, BorderLayout.CENTER);
		
		tableShowDataBenhNhan = new JTable();
		tableShowDataBenhNhan.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		tableShowDataBenhNhan.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID B\u1EC7nh nh\u00E2n", "T\u00EAn b\u1EC7nh nh\u00E2n", "Gi\u1EDBi t\u00EDnh", "N\u01A1i sinh", "N\u0103m sinh", "S\u0110T", "Nh\u00F3m m\u00E1u", "Chi\u1EC1u cao", "C\u00E2n n\u1EB7ng", "B\u1EC7nh l\u00E2y nhi\u1EC5m", "B\u1EC7nh v\u1EC1 da", "B\u1EC7nh h\u00F4 h\u1EA5p", "B\u1EC7nh v\u1EC1 th\u1EADn", "B\u1EC7nh tim m\u1EA1ch", "B\u1EC7nh ti\u00EAu h\u00F3a", "Ch\u1EA9n \u0111o\u00E1n"
			}
		));
		tableShowDataBenhNhan.setAutoResizeMode(JTable.AUTO_RESIZE_OFF );
		scrollPane.setViewportView(tableShowDataBenhNhan);
		
		tableShowDataBenhNhan.setSelectionBackground(Color.pink);
		tableShowDataBenhNhan.setSelectionForeground(Color.black);

		
			
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(0, 150));
		panel_1.setBackground(new Color(202, 240, 248));
		viewBenhNhan.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(null);
		
		txtTimKiemTen = new JTextField();
		txtTimKiemTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimKiemTen.setColumns(10);
		txtTimKiemTen.setBounds(158, 60, 190, 35);
		panel_1.add(txtTimKiemTen);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BenhNhan bn = new BenhNhan();
				try {
					bn.setName(txtTimKiemTen.getText());
					bn.setIDBN(txtTimKiemID.getText());
					
					showDataViewBenhNhan(BenhNhanData.findNameBenhNhan(bn));
					
				} catch (Exception ex) {
					
				}
			}
		});
		btnTimKiem.setBounds(158, 106, 133, 35);
		panel_1.add(btnTimKiem);
		
		txtTimKiemID = new JTextField();
		txtTimKiemID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimKiemID.setColumns(10);
		txtTimKiemID.setBounds(158, 13, 190, 35);
		panel_1.add(txtTimKiemID);
		
		JLabel lblNewLabel_2 = new JLabel("ID Bệnh nhân");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(37, 13, 111, 35);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tên bệnh nhân");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(37, 58, 111, 35);
		panel_1.add(lblNewLabel_2_1);
		
		JButton btnRefresh = new JButton("");
		btnRefresh.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				showDataViewBenhNhan(BenhNhanData.findAllPatient());
			}
		});
		btnRefresh.setIcon(new ImageIcon("../HoSoBenhAn/res/images/refresh.png"));
		btnRefresh.setBounds(301, 106, 47, 35);
		panel_1.add(btnRefresh);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("XEM THÔNG TIN BỆNH NHÂN");
		lblNewLabel_6_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1_1.setForeground(new Color(255, 0, 92));
		lblNewLabel_6_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_6_1_1.setBounds(388, 0, 503, 48);
		panel_1.add(lblNewLabel_6_1_1);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("../HoSoBenhAn/res/images/imagebenhnhan.png"));
		lblNewLabel_7.setBounds(551, 49, 190, 101);
		panel_1.add(lblNewLabel_7);
		
		JButton btnBenhNhan = new JButton("");
		btnBenhNhan.setIcon(new ImageIcon("../HoSoBenhAn/res/images/patient.png"));
		btnBenhNhan.setSelectedIcon(new ImageIcon("../HoSoBenhAn/res/images/patienttt.png"));
		
		JPanel UpdateBenhNhan = new JPanel();
		cardpanel.add(UpdateBenhNhan, "name_2674452726556900");
		UpdateBenhNhan.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setPreferredSize(new Dimension(0, 190));
		UpdateBenhNhan.add(scrollPane_1, BorderLayout.SOUTH);
		
		tableShowData2 = new JTable();
		tableShowData2.addMouseListener(new MouseAdapter() {
/*
 * Click bảng để show dữ liệu của bệnh nhân
 */
			@Override
			public void mouseClicked(MouseEvent e) {
				int idBN = tableShowData2.getSelectedRow();
				TableModel model = tableShowData2.getModel();
				
				txtIDBN.setText(model.getValueAt(idBN, 0).toString());
				txtName.setText(model.getValueAt(idBN, 1).toString());
				cbbGioiTinh.setSelectedItem(model.getValueAt(idBN, 2).toString());
				txtNoiSinh.setText(model.getValueAt(idBN, 3).toString());
				txtNamSinh.setText(model.getValueAt(idBN, 4).toString());
				txtSDT.setText(model.getValueAt(idBN, 5).toString());
				txtNhomMau.setText(model.getValueAt(idBN, 6).toString());
				txtChieuCao.setText(model.getValueAt(idBN, 7).toString());
				txtCanNang.setText(model.getValueAt(idBN, 8).toString());
				txtBenhLayNhiem.setText(model.getValueAt(idBN, 9).toString());
				txtBenhVeDa.setText(model.getValueAt(idBN, 10).toString());
				txtBenhHoHap.setText(model.getValueAt(idBN,11).toString());
				txtBenhVeThan.setText(model.getValueAt(idBN, 12).toString());
				txtBenhTimMach.setText(model.getValueAt(idBN, 13).toString());
				txtBenhTieuHoa.setText(model.getValueAt(idBN, 14).toString());
				txtChanDoan.setText(model.getValueAt(idBN, 15).toString());
				txtChanDoan.setText(model.getValueAt(idBN, 16).toString());

				
			}
		});
		tableShowData2.setSelectionForeground(Color.BLACK);
		tableShowData2.setSelectionBackground(Color.PINK);
		tableShowData2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tableShowData2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID B\u1EC7nh nh\u00E2n", "T\u00EAn b\u1EC7nh nh\u00E2n", "Gi\u1EDBi t\u00EDnh", "N\u01A1i sinh", "N\u0103m sinh", "S\u0110T", "Nh\u00F3m m\u00E1u", "Chi\u1EC1u cao", "C\u00E2n n\u1EB7ng", "B\u1EC7nh l\u00E2y nhi\u1EC5m", "B\u1EC7nh v\u1EC1 da", "B\u1EC7nh h\u00F4 h\u1EA5p", "B\u1EC7nh v\u1EC1 th\u1EADn", "B\u1EC7nh tim m\u1EA1ch", "B\u1EC7nh ti\u00EAu h\u00F3a", "Ch\u1EA9n \u0111o\u00E1n", "Ghi Ch\u00FA"
			}
		));
		tableShowData2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_1.setViewportView(tableShowData2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(202, 240, 248));
		UpdateBenhNhan.add(panel_4, BorderLayout.NORTH);
		panel_4.setPreferredSize(new Dimension(0, 530));
		panel_4.setLayout(null);
		
		txtIDBN = new JTextField();
		txtIDBN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtIDBN.setColumns(10);
		txtIDBN.setBounds(153, 58, 143, 30);
		panel_4.add(txtIDBN);
		
		JLabel lblNewLabel_2_2 = new JLabel("ID Bệnh nhân");
		lblNewLabel_2_2.setForeground(Color.BLACK);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(32, 55, 111, 35);
		panel_4.add(lblNewLabel_2_2);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtName.setColumns(10);
		txtName.setBounds(462, 56, 143, 30);
		panel_4.add(txtName);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Tên bệnh nhân");
		
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_1.setBounds(341, 53, 111, 35);
		panel_4.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Giới tính");
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_2.setBounds(627, 58, 111, 35);
		panel_4.add(lblNewLabel_2_2_2);
		
		txtNoiSinh = new JTextField();
		txtNoiSinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNoiSinh.setColumns(10);
		txtNoiSinh.setBounds(153, 112, 143, 30);
		panel_4.add(txtNoiSinh);
		
		JLabel lblNewLabel_2_2_3 = new JLabel("Nơi sinh");
		lblNewLabel_2_2_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_3.setBounds(32, 109, 111, 35);
		panel_4.add(lblNewLabel_2_2_3);
		
		JLabel lblNewLabel_2_2_4 = new JLabel("Năm sinh");
		lblNewLabel_2_2_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_4.setBounds(341, 112, 111, 35);
		panel_4.add(lblNewLabel_2_2_4);
		
		txtBenhLayNhiem = new JTextField();
		txtBenhLayNhiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtBenhLayNhiem.setColumns(10);
		txtBenhLayNhiem.setBounds(153, 239, 143, 30);
		panel_4.add(txtBenhLayNhiem);
		
		JLabel lblNewLabel_2_2_4_1 = new JLabel("Bệnh lây nhiễm");
		lblNewLabel_2_2_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_4_1.setBounds(32, 236, 111, 35);
		panel_4.add(lblNewLabel_2_2_4_1);
		
		JLabel lblNewLabel_2_2_3_1 = new JLabel("Cân nặng");
		lblNewLabel_2_2_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_3_1.setBounds(627, 174, 111, 35);
		panel_4.add(lblNewLabel_2_2_3_1);
		
		txtCanNang = new JTextField();
		txtCanNang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCanNang.setColumns(10);
		txtCanNang.setBounds(748, 177, 143, 30);
		panel_4.add(txtCanNang);
		
		txtChieuCao = new JTextField();
		txtChieuCao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtChieuCao.setColumns(10);
		txtChieuCao.setBounds(462, 174, 143, 30);
		panel_4.add(txtChieuCao);
		
		JLabel lblNewLabel_2_2_2_1 = new JLabel("Chiều cao");
		lblNewLabel_2_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_2_1.setBounds(341, 171, 111, 35);
		panel_4.add(lblNewLabel_2_2_2_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Nhóm máu");
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_1_1.setBounds(32, 174, 111, 35);
		panel_4.add(lblNewLabel_2_2_1_1);
		
		txtNhomMau = new JTextField();
		txtNhomMau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNhomMau.setColumns(10);
		txtNhomMau.setBounds(153, 177, 143, 30);
		panel_4.add(txtNhomMau);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSDT.setColumns(10);
		txtSDT.setBounds(748, 115, 143, 30);
		panel_4.add(txtSDT);
		
		JLabel lblNewLabel_2_2_5 = new JLabel("SĐT");
		lblNewLabel_2_2_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_5.setBounds(627, 112, 111, 35);
		panel_4.add(lblNewLabel_2_2_5);
		
		txtBenhTieuHoa = new JTextField();
		txtBenhTieuHoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtBenhTieuHoa.setColumns(10);
		txtBenhTieuHoa.setBounds(748, 297, 143, 30);
		panel_4.add(txtBenhTieuHoa);
		
		JLabel lblNewLabel_2_2_4_2 = new JLabel("Bệnh tiêu hóa");
		lblNewLabel_2_2_4_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_4_2.setBounds(627, 294, 111, 35);
		panel_4.add(lblNewLabel_2_2_4_2);
		
		JLabel lblNewLabel_2_2_3_2 = new JLabel("Bệnh tim mạch");
		lblNewLabel_2_2_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_3_2.setBounds(627, 236, 111, 35);
		panel_4.add(lblNewLabel_2_2_3_2);
		
		txtBenhTimMach = new JTextField();
		txtBenhTimMach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtBenhTimMach.setColumns(10);
		txtBenhTimMach.setBounds(748, 239, 143, 30);
		panel_4.add(txtBenhTimMach);
		
		txtBenhVeThan = new JTextField();
		txtBenhVeThan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtBenhVeThan.setColumns(10);
		txtBenhVeThan.setBounds(462, 300, 143, 30);
		panel_4.add(txtBenhVeThan);
		
		JLabel lblNewLabel_2_2_2_2 = new JLabel("Bệnh về thận");
		lblNewLabel_2_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_2_2.setBounds(341, 297, 111, 35);
		panel_4.add(lblNewLabel_2_2_2_2);
		
		JLabel lblNewLabel_2_2_1_2 = new JLabel("Bệnh hô hấp");
		lblNewLabel_2_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_1_2.setBounds(32, 292, 111, 35);
		panel_4.add(lblNewLabel_2_2_1_2);
		
		txtBenhHoHap = new JTextField();
		txtBenhHoHap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtBenhHoHap.setColumns(10);
		txtBenhHoHap.setBounds(153, 295, 143, 30);
		panel_4.add(txtBenhHoHap);
		
		txtBenhVeDa = new JTextField();
		txtBenhVeDa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtBenhVeDa.setColumns(10);
		txtBenhVeDa.setBounds(462, 242, 143, 30);
		panel_4.add(txtBenhVeDa);
		
		JLabel lblNewLabel_2_2_6 = new JLabel("Bệnh về da");
		lblNewLabel_2_2_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_6.setBounds(341, 239, 111, 35);
		panel_4.add(lblNewLabel_2_2_6);
		
		cbbGioiTinh = new JComboBox();
		cbbGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbbGioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cbbGioiTinh.setBounds(748, 58, 143, 30);
		panel_4.add(cbbGioiTinh);
		
		JLabel lblNewLabel_2_2_4_2_1 = new JLabel("Chẩn đoán");
		lblNewLabel_2_2_4_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_4_2_1.setBounds(341, 351, 111, 35);
		panel_4.add(lblNewLabel_2_2_4_2_1);
		
		txtChanDoan = new JTextField();
		txtChanDoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtChanDoan.setColumns(10);
		txtChanDoan.setBounds(462, 354, 143, 30);
		panel_4.add(txtChanDoan);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_5.setBounds(10, 395, 904, 124);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		txtLocBenhNhan = new JTextField();
		txtLocBenhNhan.setText("ID hoặc tên\r\n");
		txtLocBenhNhan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtLocBenhNhan.setColumns(10);
		txtLocBenhNhan.setBounds(47, 83, 143, 30);
		panel_5.add(txtLocBenhNhan);
		
		JButton btnLoc = new JButton("Lọc");
		btnLoc.setBounds(214, 83, 82, 30);
		btnLoc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BenhNhan bn = new BenhNhan();
				try {
					bn.setName(txtLocBenhNhan.getText());
					bn.setIDBN(txtLocBenhNhan.getText());
					showDataUpdateBenhNhan(BenhNhanData.findNameBenhNhan(bn));
					
				} catch (Exception ex) {
					
				}
			}						
		});
		panel_5.add(btnLoc);
		
		JButton btnNpDLiu = new JButton("Nạp dữ liệu");
		btnNpDLiu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNpDLiu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showDataUpdateBenhNhan(BenhNhanData.findAllPatient());
			}
		});
		btnNpDLiu.setBounds(47, 11, 143, 61);
		panel_5.add(btnNpDLiu);

/*
 * Thêm
 */
		JButton btnThm = new JButton("Thêm");
		btnThm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BenhNhan bn = new BenhNhan();
					
					bn.setIDBN(txtIDBN.getText());
					bn.setName(txtName.getText());
					bn.setGioiTinh(cbbGioiTinh.getSelectedIndex());
					bn.setNoiSinh(txtNoiSinh.getText());				
					bn.setNamSinh(Integer.parseInt(txtNamSinh.getText()));
					bn.setSDT(txtSDT.getText());
					bn.setNhomMau(txtNhomMau.getText());
					bn.setChieuCao(txtChieuCao.getText());
					bn.setCanNang(txtCanNang.getText());
					bn.setBenhLayNhiem(txtBenhLayNhiem.getText());
					bn.setBenhVeDa(txtBenhVeDa.getText());
					bn.setBenhHoHap(txtBenhHoHap.getText());
					bn.setBenhVeThan(txtBenhVeThan.getText());
					bn.setBenhVeTimMach(txtBenhTimMach.getText());
					bn.setBenhTieuHoa(txtBenhTieuHoa.getText());
					bn.setChanDoan(txtChanDoan.getText());
					bn.setGhiChu(textField.getText());
										
					BenhNhanData.insert(bn);
					

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Thêm bệnh nhân thất bại!","Message",JOptionPane.ERROR_MESSAGE);
					System.err.println("Nhap loi" + ex);
				}
				showDataUpdateBenhNhan(BenhNhanData.findAllPatient());
				showDataViewBenhNhan(BenhNhanData.findAllPatient());
				
			}
			
		});
/*
 * END ( Thêm )
 */
		btnThm.setBounds(214, 11, 143, 61);
		panel_5.add(btnThm);
		
		JButton btnCpNht = new JButton("Cập nhật");
		btnCpNht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				BenhNhan bn = new BenhNhan();
				bn.setIDBN(txtIDBN.getText());
				bn.setName(txtName.getText());
				bn.setGioiTinh(cbbGioiTinh.getSelectedIndex());
				bn.setNoiSinh(txtNoiSinh.getText());			
				bn.setNamSinh(Integer.parseInt(txtNamSinh.getText()));
				bn.setSDT(txtSDT.getText());
				bn.setNhomMau(txtNhomMau.getText());
				bn.setChieuCao(txtChieuCao.getText());
				bn.setCanNang(txtCanNang.getText());
				bn.setBenhLayNhiem(txtBenhLayNhiem.getText());
				bn.setBenhVeDa(txtBenhVeDa.getText());
				bn.setBenhHoHap(txtBenhHoHap.getText());
				bn.setBenhVeThan(txtBenhVeThan.getText());
				bn.setBenhVeTimMach(txtBenhTimMach.getText());
				bn.setBenhTieuHoa(txtBenhTieuHoa.getText());
				bn.setChanDoan(txtChanDoan.getText());
				bn.setGhiChu(textField.getText());

				
				BenhNhanData.update(bn);
				
				
				JOptionPane.showMessageDialog(null, "Cập nhật thành công!","Message",JOptionPane.INFORMATION_MESSAGE);
			
								
				} catch ( Exception ex) {
					JOptionPane.showMessageDialog(null, "Cập nhật thất bại!","Message",JOptionPane.ERROR_MESSAGE);
					System.err.println("Nhap loi" + ex);
				}
				showDataUpdateBenhNhan(BenhNhanData.findAllPatient());
				showDataViewBenhNhan(BenhNhanData.findAllPatient());
			}
		});
		btnCpNht.setEnabled(false);
		btnCpNht.setBounds(409, 83, 82, 30);
		panel_5.add(btnCpNht);
/*
 * Sửa ( update )
 */		
		JButton btnSa = new JButton("Sửa");
		btnSa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					btnCpNht.setEnabled(true);
					lblNewLabel_2_2.setForeground(Color.RED);
				} catch (Exception ex) {
					
				}
			}
		});
		btnSa.setBounds(379, 11, 143, 61);
		panel_5.add(btnSa);
/*
 * Delete		
 */
		JButton btnXa = new JButton("Xóa");
		btnXa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BenhNhan bn = new BenhNhan();
				
				try {	
						
					bn.setIDBN(txtIDBN.getText());
					
					if (txtIDBN.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Không được để trống ID!","Message",JOptionPane.ERROR_MESSAGE);
					} else {
					
					BenhNhanData.delete(bn);
					JOptionPane.showMessageDialog(null, "Xóa bệnh nhân thành công!","Message",JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Xóa bệnh nhân thất bại!","Message",JOptionPane.ERROR_MESSAGE);
					System.out.println(ex);
				}	
				showDataUpdateBenhNhan(BenhNhanData.findAllPatient());
				showDataViewBenhNhan(BenhNhanData.findAllPatient());
			}
		});
		btnXa.setBounds(544, 11, 143, 61);
		panel_5.add(btnXa);
	
/*
 * Làm mới
 */
		JButton btnLmMi = new JButton("Làm mới");
		btnLmMi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLmMi.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				txtIDBN.setText("");
				txtName.setText("");
				txtNoiSinh.setText("");
				txtNamSinh.setText("");
				txtSDT.setText("");
				txtNhomMau.setText("");
				txtChieuCao.setText("");
				txtCanNang.setText("");
				txtBenhLayNhiem.setText("");
				txtBenhVeDa.setText("");
				txtBenhHoHap.setText("");
				txtBenhVeThan.setText("");
				txtBenhTimMach.setText("");
				txtBenhTieuHoa.setText("");
				txtChanDoan.setText("");
				
			}
		});
		btnLmMi.setBounds(711, 11, 143, 61);
		panel_5.add(btnLmMi);
		
		
		
		txtNamSinh = new JTextField();
		txtNamSinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNamSinh.setColumns(10);
		txtNamSinh.setBounds(462, 118, 143, 30);
		panel_4.add(txtNamSinh);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("../HoSoBenhAn/res/images/gear.png"));
		lblNewLabel_5.setBounds(0, 0, 80, 80);
		panel_4.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setIcon(new ImageIcon("../HoSoBenhAn/res/images/gear2.png"));
		lblNewLabel_5_1.setBounds(844, 0, 80, 80);
		panel_4.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6 = new JLabel("CHỈNH SỬA THÔNG TIN BỆNH NHÂN");
		lblNewLabel_6.setForeground(new Color(255, 0, 92));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(153, 0, 596, 48);
		panel_4.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5_3 = new JLabel("");
		lblNewLabel_5_3.setIcon(new ImageIcon("../HoSoBenhAn/res/images/gear3.png"));
		lblNewLabel_5_3.setBounds(0, 312, 80, 80);
		panel_4.add(lblNewLabel_5_3);
		
		JLabel txtGhiChu = new JLabel("");
		txtGhiChu.setIcon(new ImageIcon("../HoSoBenhAn/res/images/gear4.png"));

		txtGhiChu.setBounds(844, 312, 80, 80);
		panel_4.add(txtGhiChu);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(748, 354, 143, 30);
		panel_4.add(textField);
		
		JLabel lblNewLabel_2_2_4_2_2 = new JLabel("Ghi chú");
		lblNewLabel_2_2_4_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_4_2_2.setBounds(627, 351, 111, 35);
		panel_4.add(lblNewLabel_2_2_4_2_2);
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		

		pnBenhNhan.setLayout(new GridLayout(0, 1, 0, 0));
		pnBenhNhan.add(btnBenhNhan);
		
		JButton btnBacSy = new JButton("");
		btnBacSy.setSelectedIcon(new ImageIcon("../HoSoBenhAn/res/images/doctorbeautyyy.png"));
		
		btnBacSy.setIcon(new ImageIcon("../HoSoBenhAn/res/images/doctorbeauty.png"));
		btnBacSy.setBounds(530, 150, 250, 250);
		viewInformation.add(btnBacSy);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setLayout(null);
		panel_6_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_6_1.setBackground(new Color(249, 228, 212));
		panel_6_1.setBounds(316, 53, 288, 63);
		viewInformation.add(panel_6_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Xem thông tin");
		lblNewLabel_4_1.setBounds(34, 11, 244, 41);
		panel_6_1.add(lblNewLabel_4_1);
		lblNewLabel_4_1.setForeground(new Color(122, 11, 192));
		lblNewLabel_4_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 35));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(249, 228, 212));
		panel_6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_6.setBounds(68, 513, 780, 94);
		viewInformation.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("HỆ THỐNG QUẢN LÝ HỒ SƠ BỆNH ÁN");
		lblNewLabel_4.setBounds(33, 21, 723, 58);
		panel_6.add(lblNewLabel_4);
		lblNewLabel_4.setForeground(new Color(122, 11, 192));
		lblNewLabel_4.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("../HoSoBenhAn/res/images/backgroundinfor.png"));
		lblNewLabel_3.setBounds(0, 0, 924, 751);
		viewInformation.add(lblNewLabel_3);
		
		
		
		JPanel viewBacSy = new JPanel();
		cardpanel.add(viewBacSy, "name_2761119360848100");
		viewBacSy.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setPreferredSize(new Dimension(0, 600));
		scrollPane_2.setInheritsPopupMenu(true);
		scrollPane_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		viewBacSy.add(scrollPane_2, BorderLayout.CENTER);
		
		tableShowDataBacSy = new JTable();
		tableShowDataBacSy.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID B\u00E1c s\u1EF9", "T\u00EAn B\u00E1c S\u1EF9", "N\u0103m sinh", "Chuy\u00EAn m\u00F4n", "Kinh nghi\u1EC7m", "Khoa", "Tr\u00ECnh \u0111\u1ED9"
			}
		));
		tableShowDataBacSy.setSelectionForeground(Color.BLACK);
		tableShowDataBacSy.setSelectionBackground(Color.PINK);
		tableShowDataBacSy.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		scrollPane_2.setViewportView(tableShowDataBacSy);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setPreferredSize(new Dimension(0, 150));
		panel_1_1.setBackground(new Color(193, 222, 174));
		viewBacSy.add(panel_1_1, BorderLayout.NORTH);
		
		txtTimKiemTenBS = new JTextField();
		txtTimKiemTenBS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimKiemTenBS.setColumns(10);
		txtTimKiemTenBS.setBounds(158, 60, 190, 35);
		panel_1_1.add(txtTimKiemTenBS);
		
		JButton btnTimKiem_1 = new JButton("Tìm kiếm");
		btnTimKiem_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BacSy bs = new BacSy();
				try {
					bs.setIDBS(txtTimKiemIDBS.getText());
					bs.setTenBacSy(txtTimKiemTenBS.getText());
					showDataViewBacSy(BacSyData.findNameBacSy(bs));
					
				} catch (Exception ex) {
					
				}
			}
		});

		btnTimKiem_1.setBounds(158, 106, 133, 35);
		panel_1_1.add(btnTimKiem_1);
		
		txtTimKiemIDBS = new JTextField();
		txtTimKiemIDBS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimKiemIDBS.setColumns(10);
		txtTimKiemIDBS.setBounds(158, 13, 190, 35);
		panel_1_1.add(txtTimKiemIDBS);
		
		JLabel lblNewLabel_2_3 = new JLabel("ID Bác Sỹ");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(37, 13, 111, 35);
		panel_1_1.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Tên bác sỹ");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(37, 58, 111, 35);
		panel_1_1.add(lblNewLabel_2_1_1);
		
		JButton btnRefresh_1 = new JButton("");
		btnRefresh_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showDataViewBacSy(BacSyData.findAllBacSy());
			}
		});
		btnRefresh_1.setIcon(new ImageIcon("../HoSoBenhAn/res/images/refresh.png"));
		btnRefresh_1.setBounds(301, 106, 47, 35);
		panel_1_1.add(btnRefresh_1);
		
		JLabel lblNewLabel_6_1_1_1 = new JLabel("XEM THÔNG TIN BÁC SỸ");
		lblNewLabel_6_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1_1_1.setForeground(new Color(255, 0, 92));
		lblNewLabel_6_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_6_1_1_1.setBounds(391, 0, 503, 48);
		panel_1_1.add(lblNewLabel_6_1_1_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("");
		lblNewLabel_7_1.setIcon(new ImageIcon("../HoSoBenhAn/res/images/imagebacsy.png"));
		lblNewLabel_7_1.setBounds(590, 25, 125, 125);
		panel_1_1.add(lblNewLabel_7_1);
		
		JPanel UpdateBacSy = new JPanel();
		cardpanel.add(UpdateBacSy, "name_2905115496818400");
		UpdateBacSy.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setPreferredSize(new Dimension(0, 190));
		UpdateBacSy.add(scrollPane_1_1, BorderLayout.SOUTH);
		
		tableShowDataBS = new JTable();
		tableShowDataBS.addMouseListener(new MouseAdapter() {
/*
 * Click bảng để lấy thông tin lên Bác sỹ			
 */
			@Override
			public void mouseClicked(MouseEvent e) {
				int idBS = tableShowDataBS.getSelectedRow();
				TableModel model = tableShowDataBS.getModel();
				
				txtIDBS.setText(model.getValueAt(idBS, 0).toString());
				txtTenBacSy.setText(model.getValueAt(idBS, 1).toString());
				txtNamSinhBSS.setText(model.getValueAt(idBS, 2).toString());
				txtChuyenMon.setText(model.getValueAt(idBS, 3).toString());
				txtKinhNghiem.setText(model.getValueAt(idBS, 4).toString());
				txtKhoa.setText(model.getValueAt(idBS, 5).toString());
				txtTrinhDo.setText(model.getValueAt(idBS, 6).toString());

			}
		});
		tableShowDataBS.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID B\u00E1c S\u1EF9", "T\u00EAn b\u00E1c s\u1EF9", "N\u0103m sinh", "Chuy\u00EAn m\u00F4n", "Kinh nghi\u1EC7m", "Khoa", "Tr\u00ECnh \u0111\u1ED9"
			}
		));
		tableShowDataBS.setSelectionForeground(Color.BLACK);
		tableShowDataBS.setSelectionBackground(Color.PINK);
		tableShowDataBS.setFont(new Font("Times New Roman", Font.BOLD, 14));
		scrollPane_1_1.setViewportView(tableShowDataBS);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBackground(new Color(193, 222, 174));
		panel_4_1.setLayout(null);
		panel_4_1.setPreferredSize(new Dimension(0, 530));
		UpdateBacSy.add(panel_4_1, BorderLayout.NORTH);
		
		txtIDBS = new JTextField();
		txtIDBS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtIDBS.setColumns(10);
		txtIDBS.setBounds(153, 58, 143, 30);
		panel_4_1.add(txtIDBS);
		
		JLabel IDBS = new JLabel("ID Bác Sỹ");
		IDBS.setForeground(Color.BLACK);
		IDBS.setFont(new Font("Tahoma", Font.BOLD, 14));
		IDBS.setBounds(32, 55, 111, 35);
		panel_4_1.add(IDBS);
		
		txtTenBacSy = new JTextField();
		txtTenBacSy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenBacSy.setColumns(10);
		txtTenBacSy.setBounds(462, 56, 143, 30);
		panel_4_1.add(txtTenBacSy);
		
		JLabel TenBacSy = new JLabel("Tên bác Sỹ");
		TenBacSy.setFont(new Font("Tahoma", Font.BOLD, 14));
		TenBacSy.setBounds(341, 53, 111, 35);
		panel_4_1.add(TenBacSy);
		
		JLabel lblNewLabel_2_2_2_3 = new JLabel("Năm Sinh");
		lblNewLabel_2_2_2_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_2_3.setBounds(627, 58, 111, 35);
		panel_4_1.add(lblNewLabel_2_2_2_3);
		
		txtChuyenMon = new JTextField();
		txtChuyenMon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtChuyenMon.setColumns(10);
		txtChuyenMon.setBounds(153, 112, 143, 30);
		panel_4_1.add(txtChuyenMon);
		
		JLabel lblNewLabel_2_2_3_3 = new JLabel("Chuyên môn");
		lblNewLabel_2_2_3_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_3_3.setBounds(32, 109, 111, 35);
		panel_4_1.add(lblNewLabel_2_2_3_3);
		
		JLabel lblNewLabel_2_2_4_3 = new JLabel("Kinh nghiệm");
		lblNewLabel_2_2_4_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_4_3.setBounds(341, 112, 111, 35);
		panel_4_1.add(lblNewLabel_2_2_4_3);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setLayout(null);
		panel_5_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_5_1.setBounds(10, 395, 904, 124);
		panel_4_1.add(panel_5_1);
		
		txtLocBacSy = new JTextField();
		txtLocBacSy.setText("ID hoặc tên\r\n");
		txtLocBacSy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtLocBacSy.setColumns(10);
		txtLocBacSy.setBounds(47, 83, 143, 30);
		panel_5_1.add(txtLocBacSy);
		
		JButton btnLoc_1 = new JButton("Lọc");
		btnLoc_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BacSy bs = new BacSy();
				try {
					bs.setIDBS(txtLocBacSy.getText());
					bs.setTenBacSy(txtLocBacSy.getText());
					showDataUpdateBacSy(BacSyData.findNameBacSy(bs));
					
				} catch (Exception ex) {
					
				}
			}		
		});
		btnLoc_1.setBounds(214, 83, 82, 30);
		panel_5_1.add(btnLoc_1);
		
		JButton btnNpDLiu_1 = new JButton("Nạp dữ liệu");
		btnNpDLiu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showDataUpdateBacSy(BacSyData.findAllBacSy());
			}
		});
		btnNpDLiu_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNpDLiu_1.setBounds(47, 11, 143, 61);
		panel_5_1.add(btnNpDLiu_1);
		
		JButton btnThm_1 = new JButton("Thêm");
		btnThm_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BacSy bs = new BacSy();
				try {
					bs.setIDBS(txtIDBS.getText());
					bs.setTenBacSy(txtTenBacSy.getText());
					bs.setChuyenMon(txtChuyenMon.getText());
					bs.setNamSinh(Integer.parseInt(txtNamSinhBSS.getText()));
					bs.setKhoa(txtKhoa.getText());
					bs.setKinhNghiem(txtKinhNghiem.getText());
					bs.setTrinhDo(txtTrinhDo.getText());
					
					if (txtIDBS.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Bạn chưa nhập ID Bác Sỹ","Message",JOptionPane.INFORMATION_MESSAGE);

					} else {
						BacSyData.insert(bs);
						JOptionPane.showMessageDialog(null, "Thêm bác sỹ mới thành công!","Message",JOptionPane.INFORMATION_MESSAGE);

					}
					

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Thêm bác sỹ mới thất bại!","Message",JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);
				}
				showDataUpdateBacSy(BacSyData.findAllBacSy());
				showDataViewBacSy(BacSyData.findAllBacSy());
			}
		});
		btnThm_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThm_1.setBounds(214, 11, 143, 61);
		panel_5_1.add(btnThm_1);
		
		JButton btnCpNht_1 = new JButton("Cập nhật");
		btnCpNht_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BacSy bs = new BacSy();
				try {
					
					bs.setIDBS(txtIDBS.getText());
					bs.setTenBacSy(txtTenBacSy.getText());
					bs.setChuyenMon(txtChuyenMon.getText());
					bs.setNamSinh(Integer.parseInt(txtNamSinhBSS.getText()));
					bs.setKhoa(txtKhoa.getText());
					bs.setKinhNghiem(txtKinhNghiem.getText());
					bs.setTrinhDo(txtTrinhDo.getText());
					
					BacSyData.update(bs);
					

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Cập nhật bác sỹ thất bại!","Message",JOptionPane.ERROR_MESSAGE);
					System.err.println(ex);
				}
				showDataUpdateBacSy(BacSyData.findAllBacSy());
				showDataViewBacSy(BacSyData.findAllBacSy());
			}		
		});
		btnCpNht_1.setEnabled(false);
		btnCpNht_1.setBounds(409, 83, 82, 30);
		panel_5_1.add(btnCpNht_1);
		
		JButton btnSa_1 = new JButton("Sửa");
		btnSa_1.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					btnCpNht_1.setEnabled(true);
					IDBS.setForeground(Color.RED);
				} catch (Exception ex) {
					
				}
			}
		});
		btnSa_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSa_1.setBounds(379, 11, 143, 61);
		panel_5_1.add(btnSa_1);
		
		JButton btnXa_1 = new JButton("Xóa");
		btnXa_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BacSy bs = new BacSy();
				
				try {	
						
					bs.setIDBS(txtIDBS.getText());
					bs.setTenBacSy(txtTenBacSy.getText());
					
					if (txtIDBS.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Không được để trống ID!","Message",JOptionPane.ERROR_MESSAGE);
					} else {
						
					
					BacSyData.delete(bs);
					JOptionPane.showMessageDialog(null, "Xóa bác sỹ thành công!","Message",JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Xóa bác sỹ thất bại!","Message",JOptionPane.ERROR_MESSAGE);
					System.out.println(ex);
				}	
				showDataUpdateBacSy(BacSyData.findAllBacSy());
				showDataViewBacSy(BacSyData.findAllBacSy());
			}
		});
		btnXa_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXa_1.setBounds(544, 11, 143, 61);
		panel_5_1.add(btnXa_1);
		
		JButton btnLmMi_1 = new JButton("Làm mới");
		btnLmMi_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIDBS.setText("");
				txtTenBacSy.setText("");
				txtKhoa.setText("");
				txtKinhNghiem.setText("");
				txtChuyenMon.setText("");
				txtNamSinh.setText("");
				txtTrinhDo.setText("");
				txtNamSinhBSS.setText("");
			}
		});
		btnLmMi_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLmMi_1.setBounds(711, 11, 143, 61);
		panel_5_1.add(btnLmMi_1);
		
		txtKinhNghiem = new JTextField();
		txtKinhNghiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtKinhNghiem.setColumns(10);
		txtKinhNghiem.setBounds(462, 118, 143, 30);
		panel_4_1.add(txtKinhNghiem);
		
		txtNamSinhBSS = new JTextField();
		txtNamSinhBSS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNamSinhBSS.setColumns(10);
		txtNamSinhBSS.setBounds(748, 58, 143, 30);
		panel_4_1.add(txtNamSinhBSS);
		
		JLabel lblNewLabel_5_2 = new JLabel("");
		lblNewLabel_5_2.setIcon(new ImageIcon("../HoSoBenhAn/res/images/gear.png"));
		lblNewLabel_5_2.setBounds(0, 0, 80, 80);
		panel_4_1.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("");
		lblNewLabel_5_1_1.setIcon(new ImageIcon("../HoSoBenhAn/res/images/gear2.png"));
		lblNewLabel_5_1_1.setBounds(844, 0, 80, 80);
		panel_4_1.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("CHỈNH SỬA THÔNG TIN BÁC SỸ");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setForeground(new Color(255, 0, 92));
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_6_1.setBounds(142, 0, 596, 48);
		panel_4_1.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_5_2_1 = new JLabel("");
		lblNewLabel_5_2_1.setIcon(new ImageIcon("../HoSoBenhAn/res/images/gear3.png"));
		lblNewLabel_5_2_1.setBounds(0, 135, 80, 80);
		panel_4_1.add(lblNewLabel_5_2_1);
		
		JLabel lblNewLabel_5_2_2 = new JLabel("");
		lblNewLabel_5_2_2.setIcon(new ImageIcon("../HoSoBenhAn/res/images/gear4.png"));
		lblNewLabel_5_2_2.setBounds(844, 135, 80, 80);
		panel_4_1.add(lblNewLabel_5_2_2);
		
		JLabel lblNewLabel_2_2_5_1 = new JLabel("Trình độ");
		lblNewLabel_2_2_5_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_5_1.setBounds(341, 170, 111, 35);
		panel_4_1.add(lblNewLabel_2_2_5_1);
		
		txtTrinhDo = new JTextField();
		txtTrinhDo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTrinhDo.setColumns(10);
		txtTrinhDo.setBounds(462, 173, 143, 30);
		panel_4_1.add(txtTrinhDo);
		
		JLabel lblNewLabel_2_2_5_1_1 = new JLabel("Khoa");
		lblNewLabel_2_2_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2_5_1_1.setBounds(627, 112, 111, 35);
		panel_4_1.add(lblNewLabel_2_2_5_1_1);
		
		txtKhoa = new JTextField();
		txtKhoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtKhoa.setColumns(10);
		txtKhoa.setBounds(748, 115, 143, 30);
		panel_4_1.add(txtKhoa);
/*
 * All acctionListener CardPanel list below	
*/
				
	// Xem view bệnh nhân
		btnBenhNhan.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnBenhNhan) {
					cardpanel.removeAll();
					cardpanel.add(viewBenhNhan);
					cardpanel.repaint();
					cardpanel.revalidate();
				}
			}
		});		
	// xem view bac sy
		btnBacSy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnBacSy) {
					cardpanel.removeAll();
					cardpanel.add(viewBacSy);
					cardpanel.repaint();
					cardpanel.revalidate();
				}
			}
		});
		btnBcS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnBcS) {
					cardpanel.removeAll();
					cardpanel.add(UpdateBacSy);
					cardpanel.repaint();
					cardpanel.revalidate();
				}
			}
		});
	// xem view thông tin
		btnTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnTrangChu) {
					cardpanel.removeAll();
					cardpanel.add(viewInformation);
					cardpanel.repaint();
					cardpanel.revalidate();
				}
			}
		});
		btnCapNhat.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnCapNhat) {
					
					cardpanel.removeAll();
					cardpanel.add(UpdateBenhNhan);
					cardpanel.repaint();
					cardpanel.revalidate();
				}
			}
		});
		
/*
 *  Show Data Benh nhan
 */
		showDataUpdateBenhNhan(BenhNhanData.findAllPatient());
		showDataViewBenhNhan(BenhNhanData.findAllPatient());
		showDataViewBacSy(BacSyData.findAllBacSy());
		showDataUpdateBacSy(BacSyData.findAllBacSy());
	}
	public void showDataViewBenhNhan(List<BenhNhan> listBenhNhan) {
		List<BenhNhan> benhNhanList = new ArrayList<>();
		benhNhanList = listBenhNhan;
		DefaultTableModel tableModel;
		tableShowDataBenhNhan.getModel();
		tableModel=(DefaultTableModel)tableShowDataBenhNhan.getModel();
		tableModel.setRowCount(0);
		
		benhNhanList.forEach((benhnhan) -> {
			String gioiTinh;
			if (benhnhan.getGioiTinh()==0) {
				gioiTinh="Nam";
						}
			else {
			gioiTinh="Nữ";
			}		
			tableModel.addRow(new Object[] {benhnhan.getIDBN(),
											benhnhan.getName(),
											gioiTinh,
											benhnhan.getNoiSinh(),
											benhnhan.getNamSinh(),
											benhnhan.getSDT(),
											benhnhan.getNhomMau(),
											benhnhan.getChieuCao(),
											benhnhan.getCanNang(),
											benhnhan.getBenhLayNhiem(),
											benhnhan.getBenhVeDa(),
											benhnhan.getBenhHoHap(),
											benhnhan.getBenhVeThan(),
											benhnhan.getBenhVeTimMach(),
											benhnhan.getBenhTieuHoa(),
											benhnhan.getChanDoan(),
											benhnhan.getGhiChu()
			});
		});
		
	}
	public void showDataUpdateBenhNhan(List<BenhNhan> listBenhNhan) {
		List<BenhNhan> benhNhanList = new ArrayList<>();
		benhNhanList = listBenhNhan;
		DefaultTableModel tableModel;
		tableShowData2.getModel();
		tableModel=(DefaultTableModel)tableShowData2.getModel();
		tableModel.setRowCount(0);
		
		benhNhanList.forEach((benhnhan) -> {
			String gioiTinh;
			if (benhnhan.getGioiTinh()==0) {
				gioiTinh="Nam";
						}
			else {
			gioiTinh="Nữ";
			}		
			tableModel.addRow(new Object[] {benhnhan.getIDBN(),
											benhnhan.getName(),
											gioiTinh,
											benhnhan.getNoiSinh(),
											benhnhan.getNamSinh(),
											benhnhan.getSDT(),
											benhnhan.getNhomMau(),
											benhnhan.getChieuCao(),
											benhnhan.getCanNang(),
											benhnhan.getBenhLayNhiem(),
											benhnhan.getBenhVeDa(),
											benhnhan.getBenhHoHap(),
											benhnhan.getBenhVeThan(),
											benhnhan.getBenhVeTimMach(),
											benhnhan.getBenhTieuHoa(),
											benhnhan.getChanDoan(),
											benhnhan.getGhiChu()
			});
		});	
	}
/*
 *  Show Data Bac Sy
 */	
	public void showDataViewBacSy(List<BacSy> listBacSy) {
		List<BacSy> bacSyList = new ArrayList<>();
		bacSyList = listBacSy;
		DefaultTableModel tableModel;
		tableShowDataBacSy.getModel();
		tableModel=(DefaultTableModel)tableShowDataBacSy.getModel();
		tableModel.setRowCount(0);
		
		bacSyList.forEach((bacsy) -> {
		
			tableModel.addRow(new Object[] {bacsy.getIDBS(),
											bacsy.getTenBacSy(),
											bacsy.getNamSinh(),
											bacsy.getChuyenMon(),
											bacsy.getKinhNghiem(),
											bacsy.getKhoa(),
											bacsy.getTrinhDo(),											
			});
		});	
	}
	public void showDataUpdateBacSy(List<BacSy> listBacSy) {
		List<BacSy> bacSyList = new ArrayList<>();
		bacSyList = listBacSy;
		DefaultTableModel tableModel;
		tableShowDataBS.getModel();
		tableModel=(DefaultTableModel)tableShowDataBS.getModel();
		tableModel.setRowCount(0);
		
		bacSyList.forEach((bacsy) -> {
		
			tableModel.addRow(new Object[] {bacsy.getIDBS(),
											bacsy.getTenBacSy(),
											bacsy.getNamSinh(),
											bacsy.getChuyenMon(),
											bacsy.getKinhNghiem(),
											bacsy.getKhoa(),
											bacsy.getTrinhDo(),											
			});
		});	
	}
}
