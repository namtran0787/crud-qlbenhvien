package HoTro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class ServerChatter extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPort;
	private JTabbedPane tabbedPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					ServerChatter frame = new ServerChatter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ServerChatter() {
		super("Phòng hỗ trợ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPort = new JLabel("Room");
		lblPort.setBounds(10, 11, 37, 14);
		contentPane.add(lblPort);
		
		textFieldPort = new JTextField();
		textFieldPort.setBounds(57, 8, 130, 25);
		contentPane.add(textFieldPort);
		textFieldPort.setColumns(10);
		
		JButton btnListen = new JButton("Enter");
		btnListen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ServerSocket svSocket = new ServerSocket(Integer.parseInt(textFieldPort.getText()));
					
					Thread t = new Thread() {
						public void run() {
							while(true ) {
								try {
									Socket socket = svSocket.accept();
									DataInputStream dis = new DataInputStream(socket.getInputStream());
									String name = dis.readUTF();
									ChatPanel chatpanel = new ChatPanel(socket, "Manager", name);
									chatpanel.receiver();
									
									tabbedPane.addTab(name, chatpanel);
								} catch (IOException e) {
										// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					};
					t.start();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnListen.setBounds(197, 7, 89, 25);
		contentPane.add(btnListen);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 49, 454, 302);
		contentPane.add(tabbedPane);
		
		JButton btnExit = new JButton("exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(375, 7, 89, 25);
		contentPane.add(btnExit);
	}
}
