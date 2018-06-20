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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import pv.Character_User;
import pv.Character_ox;
import utill.Pan;

public class Ox_survive_Server extends JFrame {
	JList<String> juserlist;
	JButton jbt_start;
	JTextArea jta_text;
	ServerSocket server;
	ArrayList<ReadThread> socket_list;
	ArrayList<Character_ox> ch_list;
	ArrayList<Character_User> ch_user;

	ArrayList<String> user_list;

	Pan opan, xpan;

	boolean all_ready;

	class ReadThread extends Thread {
		Socket child;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		int index;
		boolean ready;
		String nick_name;

		public ReadThread() {
			// TODO Auto-generated constructor stub
			super();

		}

		public ReadThread(Socket child) {
			this();
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
							user_list.add(data.nick_name);
							show_user_list();
							send_user_list();
							send_all_client(data);
							check_all_ready();
							break;
						}
					case Ox_Survive_Data.READY_NICKSET:
						synchronized (Ox_survive_Server.this) {
							index = socket_list.indexOf(this);
							// System.out.println(data.nick_name.equals(""));

							if (data.nick_name.equals("")) {
								nick_name = String.format("%s<레디>", user_list.get(index));
							} else {
								nick_name = String.format("%s<레디>", data.nick_name.trim());
							}
							user_list.set(index, nick_name);
							show_user_list();
							send_user_list();

							this.ready = true;
							check_all_ready();

							break;
						}
					case Ox_Survive_Data.READY_CANCLE:
						synchronized (Ox_survive_Server.this) {
							// nick_name = user_list.ge
							index = socket_list.indexOf(this);
							nick_name = user_list.get(index);
							nick_name = nick_name.replaceAll("\\<레디\\>", "");
							user_list.set(index, nick_name);
							show_user_list();
							send_user_list();

							this.ready = false;
							check_all_ready();
							break;

						}

					}

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					break;
				}

			}

			synchronized (Ox_survive_Server.this) {
				index = socket_list.indexOf(this);
				String name = user_list.get(index);

				// 제거
				socket_list.remove(index);
				user_list.remove(index);

				show_user_list();
				send_user_list();

				String display = String.format("%s님이 나가셨습니다.\n", name);
				Ox_survive_Server.this.show_the_text(display);

				Ox_Survive_Data data = new Ox_Survive_Data();
				data.protocol = Ox_Survive_Data.USER_OUT;
				data.nick_name = name;
				send_all_client(data);
				check_all_ready();

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

	public void check_all_ready() {
		// TODO Auto-generated method stub
		int i = 0;

		for (ReadThread rt : socket_list) {
		//	System.out.println(rt.ready);
			if (rt.ready) {
				i++;
			}
		}

		System.out.println(i==socket_list.size());
		if (i == socket_list.size())
			all_ready = true;
		else
			all_ready = false;

		check_view();

	}

	private void check_view() {
		// TODO Auto-generated method stub
		if (!(socket_list.size() == 0) && all_ready) {
			jbt_start.setEnabled(true);
		} else
			jbt_start.setEnabled(false);
	}

	public void send_user_list() {
		// TODO Auto-generated method stub
		String[] users = new String[user_list.size()];
		user_list.toArray(users);
		Ox_Survive_Data data = new Ox_Survive_Data();
		data.protocol = Ox_Survive_Data.USER_LIST;
		data.user_list = users;
		send_all_client(data);

	}

	private void send_all_client(Ox_Survive_Data data) {
		// TODO Auto-generated method stub
		for (ReadThread rt : socket_list) {
			try {
				rt.oos.writeObject(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void show_user_list() {
		// TODO Auto-generated method stub
		String[] users = new String[user_list.size()];
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

		user_list = new ArrayList<String>();

		jbt_start = new JButton("시작");
		this.add(jbt_start, BorderLayout.NORTH);

		check_view();

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
