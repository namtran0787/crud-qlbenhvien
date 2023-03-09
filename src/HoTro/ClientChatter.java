package HoTro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class ClientChatter extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPort;
	private JTextField textFieldHost;
	private JTextField textFieldName;
	private JTabbedPane tabbedPane;
	private JButton btnExit;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

					ClientChatter frame = new ClientChatter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ClientChatter() {
		super("Bác sỹ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon imageDoctor = new ImageIcon("icondoc.png");
		setIconImage(imageDoctor.getImage()); // change icon		
		JLabel lblPort = new JLabel("Room");
		lblPort.setBounds(10, 11, 37, 14);
		contentPane.add(lblPort);
		
		textFieldPort = new JTextField();
		textFieldPort.setBounds(46, 8, 66, 25);
		contentPane.add(textFieldPort);
		textFieldPort.setColumns(10);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = textFieldHost.getText();
				int p = Integer.parseInt(textFieldPort.getText());
				try {
					Socket socket = new Socket(s, p);
					if(socket != null) {
						DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
						dos.writeUTF(textFieldName.getText());
						dos.flush();
						ChatPanel chatpanel = new ChatPanel(socket, textFieldName.getText(), "Manager");
						chatpanel.receiver();
						
						tabbedPane.addTab(null, chatpanel);
					}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConnect.setBounds(375, 7, 89, 25);
		contentPane.add(btnConnect);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 49, 454, 302);
		contentPane.add(tabbedPane);
		
		JLabel lblHost = new JLabel("Host");
		lblHost.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHost.setBounds(119, 11, 46, 14);
		contentPane.add(lblHost);
		
		textFieldHost = new JTextField();
		textFieldHost.setBounds(152, 8, 75, 25);
		contentPane.add(textFieldHost);
		textFieldHost.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(234, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(274, 8, 80, 25);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		btnExit = new JButton("exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(375, 33, 89, 25);
		contentPane.add(btnExit);
	}
}
