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
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import pv.Character_User;
import pv.Character_ox;
import utill.Pan;

public class Ox_survive_Server extends JFrame {

	JTextArea jta_text;
	ServerSocket server;
	ArrayList<ReadThread> socket_list;
	ArrayList<Character_ox> ch_list;
	ArrayList<Character_User> ch_user;
	JList<String> juserlist;
	ArrayList<String> user_list;

	Pan opan, xpan;

	class ReadThread extends Thread {
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
			while (true) {

				try {
					Ox_Survive_Data data = (Ox_Survive_Data) ois.readObject();
					String display = String.format("%s님이 %d의 프로토콜로 데이터를 보냈습니다.\n",
							child.getInetAddress().getHostAddress(), data.protocol);
					show_the_text(display);
					switch (data.protocol) {

					case Ox_Survive_Data.USER_IN:
						synchronized (Ox_survive_Server.this) {
							user_list.add(child.getInetAddress().getHostAddress());
							show_user_list();
							send_user_list();
							break;
						}
					case Ox_Survive_Data.READY_NICKSET:
						synchronized (Ox_survive_Server.this) {
							
							break;
						}

					}

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					break;
				}

			}

			synchronized (Ox_survive_Server.this) {
				String display = String.format("%s님이 나가셨습니다.\n", child.getInetAddress().getHostAddress());
				Ox_survive_Server.this.show_the_text(display);

			}

		}

	}

	public Ox_survive_Server() {
		super("내가만든 윈도우");
		socket_list = new ArrayList<ReadThread>();
		this.setLocation(200, 100);
		init_display();
		init_server();

		// this.setBounds(200, 100, 400, 300);
		this.pack();
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void send_user_list() {
		// TODO Auto-generated method stub
		String [] users = new String[user_list.size()];
		user_list.toArray(users);
		Ox_Survive_Data data = new Ox_Survive_Data();
		data.protocol = Ox_Survive_Data.USER_IN;
		data.user_list = users;
		send_all_client(data);
		
	}

	private void send_all_client(Ox_Survive_Data data) {
		// TODO Auto-generated method stub
		for(ReadThread rt : socket_list) {
			rt.oos.writeObject(data);
		}
	}

	public void show_user_list() {
		// TODO Auto-generated method stub
		String [] users = new String[user_list.size()];
		user_list.toArray(users);
		juserlist.setListData(users);

	}

	public void show_the_text(String display) {
		// TODO Auto-generated method stub
		jta_text.append(display);
		int position = jta_text.getDocument().getLength();
		jta_text.setCaretPosition(position);
	}

	private void init_display() {
		// TODO Auto-generated method stub
		this.setLayout(new BorderLayout());
		jta_text = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta_text);
		jsp.setPreferredSize(new Dimension(400, 400));
		jta_text.setEditable(false);
		this.add(jsp, BorderLayout.WEST);

		juserlist = new JList<String>();
		juserlist.setPreferredSize(new Dimension(200, 400));
		this.add(juserlist, BorderLayout.EAST);
		
		user_list= new ArrayList<String>();

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
					while (true) {
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
