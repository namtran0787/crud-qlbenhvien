package Server;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import Server.ServerIMP;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
	
public class ServerGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ServerIMP iServer;
	private JLabel lblNewLabel_1;
	private JToggleButton btShowandHide;
	private JLabel lblNewLabel_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					ServerGui frame = new ServerGui();
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
	public ServerGui() {
		setForeground(SystemColor.window);
		setTitle("Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon imageServer = new ImageIcon("../HoSoBenhAn/res/images/server.png");
		setIconImage(imageServer.getImage());
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 165, 276, 68);
		lblNewLabel_1.setForeground(new Color(0, 255, 0));
		contentPane.add(lblNewLabel_1);
		
		btShowandHide = new JToggleButton("Start Server");
		btShowandHide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btShowandHide.isSelected()) {
					try {
						iServer = new ServerIMP();
						LocateRegistry.createRegistry(1099);
						Naming.rebind("rmi://localhost:1099/db", iServer);
						lblNewLabel_1.setText("Server đang chạy .....");
						lblNewLabel_2.setVisible(true);
					} catch (Exception e1) {				
					}
					btShowandHide.setText("Stop Server");
				} else {
					System.exit(0);
				}
			}
		});
		contentPane.setLayout(null);
		btShowandHide.setBounds(62, 219, 150, 34);
		btShowandHide.setForeground(Color.BLACK);
		btShowandHide.setBackground(Color.WHITE);
		btShowandHide.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 15));
		contentPane.add(btShowandHide);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setForeground(SystemColor.activeCaption);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(10, 11, 264, 62);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Phòng máy chủ");
		lblNewLabel.setBounds(15, 11, 232, 37);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("../HoSoBenhAn/res/images/checkmark.png"));
		lblNewLabel_2.setVisible(false);
		lblNewLabel_2.setBounds(90, 84, 100, 100);
		contentPane.add(lblNewLabel_2);
	}
}
