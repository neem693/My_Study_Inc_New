package network;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import pv.Character_User;
import pv.Character_ox;
import utill.Pan;

public class Ox_survive_Server extends JFrame {
	
	JTextArea jta_text;
	ServerSocket server;
	ArrayList<ReadThread> socket_list
	ArrayList<Character_ox> ch_list;
	ArrayList<Character_User> user_list;
	Pan Opan,xpan;
	
	
	
	class ReadThread extends Thread{
		Socket child;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		public ReadThread() {
			// TODO Auto-generated constructor stub
		}
		public ReadThread(Socket child) {
			super();
			this.child = child;
			try {
				ois = new ObjectInputStream(child.getInputStream());
				oos = new ObjectOutputStream(child.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			while(true) {
				try {
					Ox_Survive_Data data = (Ox_Survive_Data)ois.readObject();
					String display = String.format("%s님이 %d의 프로토콜로 데이터를 보냈습니다.", child.getInetAddress().getHostAddress(),data.protocol);
					show_the_text(display);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
		}
		
	}
	
	

	public Ox_survive_Server() {
		super("내가만든 윈도우");
		socket_list= new ArrayList<ReadThread>();
		this.setLocation(200,100);
		init_display();
		init_server();
		
		//this.setBounds(200, 100, 400, 300);
		this.pack();
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void show_the_text(String display) {
		// TODO Auto-generated method stub
		jta_text.append(display);
		int position = jta_text.getDocument().getLength();
		jta_text.setCaretPosition(position);
	}

	private void init_display() {
		// TODO Auto-generated method stub
		jta_text = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta_text);
		this.setLayout(new BorderLayout());
		this.add(jsp,"Center");
		jsp.setPreferredSize(new Dimension(400, 400));
		jta_text.setEditable(false);
	}

	private void init_server() {
		// TODO Auto-generated method stub
		
		new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				try {
					server = new ServerSocket(7000);
					System.out.println("서버 구동중");
					while(true) {
						Socket child = server.accept();
						ReadThread rt = new ReadThread(child);
						socket_list.add(rt);
						rt.start();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}.start();
		
		
	}
	

	public static void main(String[] args) {
		new Ox_survive_Server();

	}

}
