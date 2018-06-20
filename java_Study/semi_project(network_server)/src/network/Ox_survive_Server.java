package network;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import main.MyConst;
import pv.Character_User;
import pv.Character_ox;
import utill.Character_Manager;
import utill.MunJe;
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

	Pan opan, xpan;//pan//
	Character_Manager ch_m;

	boolean all_ready;
	boolean start = false;

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
		init_event();

		// this.setBounds(200, 100, 400, 300);
		this.pack();
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void init_event() {
		// TODO Auto-generated method stub
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (jbt_start == e.getSource()) {
					Ox_Survive_Data data = new Ox_Survive_Data();
					data.protocol = Ox_Survive_Data.GAME_START;
					////////////////////////
					// 맨처음에 필요한 데이터 여기에 넣어라//
					////////////////////////
					send_all_client(data);
					start = true;///// 나중에 쓸 때 있으면 써라. 이건 그냥 예비용으로 만들어 놓은 냠냠이 start다.
					check_view();
					
					
					
					///게임 초기화 해서 보내기
					init_game_fisrt();
					data = new Ox_Survive_Data();
					data.protocol = Ox_Survive_Data.INITIALIZE_GAME;
					data.opan = opan;
					data.xpan = xpan;
					data.ch_list = ch_m.ch_list;

				}

			}
		};
		jbt_start.addActionListener(action);
	}

	protected void init_game_fisrt() {
		// TODO Auto-generated method stub
		int border = (int) (MyConst.GAME_W * 0.05);
		int width = Pan.WIDTH;
		int height = Pan.HEIGHT;

		opan = new Pan(Pan.OPAN, 0 + border, 0 + border);
		xpan = new Pan(Pan.XPAN, MyConst.GAME_W - border - width, 0 + border);
		ch_m = new Character_Manager(opan, xpan, Character_Manager.HEAVY, 1);
		MunJe munje;
		try {
			munje = new MunJe();
			munje.random();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void check_all_ready() {
		// TODO Auto-generated method stub
		int i = 0;

		for (ReadThread rt : socket_list) {
			// System.out.println(rt.ready);
			if (rt.ready) {
				i++;
			}
		}

		// System.out.println(i==socket_list.size());
		if (i == socket_list.size())
			all_ready = true;
		else
			all_ready = false;

		check_view();

	}

	private void check_view() {
		// TODO Auto-generated method stub
		if (start) {
			jbt_start.setEnabled(false);
			jbt_start.setText("시작중...");
		}
		else if (!(socket_list.size() == 0) && all_ready) {
			jbt_start.setEnabled(true);
			jbt_start.setText("시작");
		} else {
			jbt_start.setEnabled(false);
			jbt_start.setText("시작");
		}
		start = false;
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
