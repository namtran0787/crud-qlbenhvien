package HoTro;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.UIManager;

import ConnJDBC.JDBCData;
import FrameBenhAn.FrameBenhAn;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChatPanel extends JPanel {
	private Socket socket;
	String sender;
	String receiver;
	private BufferedReader bfr;
	private PrintWriter pw;
	private JTextArea textArea;
	private JTextField txtSend;
	

	
	public ChatPanel(Socket socket, String sender, String receiver) {
		this.socket = socket;
		this.sender = sender;
		this.receiver = receiver;
/*
 * TCP 
 */
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			bfr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 430, 190);
		add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setText("");
		scrollPane.setViewportView(textArea);
		setLayout(null);
		
		JButton btnsend = new JButton("Send");
		btnsend.addActionListener(new ActionListener() {
			String s;
			public void actionPerformed(ActionEvent e) {
				if(txtSend.getText().equals("") == false)
				{
					s = txtSend.getText();
					send(s);
					txtSend.setText("");
					
				}
			}
		});
		btnsend.setBounds(347, 212, 89, 74);
		add(btnsend);
		
		txtSend = new JTextField();
		txtSend.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String s;
				if(e.getKeyCode()==KeyEvent.VK_ENTER ) {
					if(txtSend.getText().equals("") == false)
					{
						s = txtSend.getText();
						send(s);
						txtSend.setText("");
						
					}
				
				}
				
			}
		});
		txtSend.setBounds(10, 212, 327, 49);
		add(txtSend);
		txtSend.setColumns(10);

	}
	
	public void receiver() {
		Thread t = new Thread() {
			public void run() {
				while(true) {
					try {
						bfr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						String s;
						try {
							s = bfr.readLine();
							if(s != null) {
								textArea.append("\n"+ receiver +": "+ s);
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
		t.start();
	}
	
	public void send(String message) {
		try {
			pw = new PrintWriter(socket.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		textArea.append("\n"+ sender +": "+ message);
		pw.println(message);
		pw.flush();
	}
	
	public void close() {
		try {
			pw.close();
			bfr.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
