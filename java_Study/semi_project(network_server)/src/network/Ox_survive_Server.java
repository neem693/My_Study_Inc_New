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
import ox_survive.GameOver;
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
	// ArrayList<Character_ox> ch_list;
	ArrayList<Character_User> ch_user;

	ArrayList<String> user_list;

	Pan opan, xpan;// pan//
	Character_Manager ch_m;
	MunJe munje;
	GameOver gameover;

	boolean all_ready;
	boolean start = false;

	class ReadThread extends Thread {
		Socket child;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		int index;
		boolean ready;
		boolean receive;
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
					Ox_Survive_Data data = (Ox_Survive_Data) ois.readObject();// ����ȭ �����Ͱ� �ٸ���� exception�߻�
					// System.out.println((data==null) + " ���� " + data + " ����");
					if (data == null)
						break;

					int index = socket_list.indexOf(this);// ���� ���ϸ���Ʈ�� �ش��ϴ� �ε���
					data.message_index = index;// �ǹ��ϴ� �ٴ� ������ ��� �ε��� �̸���������

					String display = String.format("%s���� %d�� �������ݷ� �����͸� ���½��ϴ�.\n",
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

							// System.out.println(data.nick_name.equals(""));
							

							if (data.nick_name.equals("")) {
								nick_name = String.format("%s<����>", user_list.get(index));
							} else {
								nick_name = String.format("%s<����>", data.nick_name.trim());
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

							nick_name = user_list.get(index);
							nick_name = nick_name.replaceAll("\\<����\\>", "");
							user_list.set(index, nick_name);
							show_user_list();
							send_user_list();

							this.ready = false;
							check_all_ready();
							break;
						}
					case Ox_Survive_Data.END_ROUND:
						synchronized (Ox_survive_Server.this) {
							this.receive = true;
							if (all_user_end()) {

								Ox_Survive_Data re_data = new Ox_Survive_Data();
								re_data.setProtocol(Ox_Survive_Data.KILL);
								re_data.setKill_allow(true);
								send_all_client(re_data);

							}
							break;
						}
					case Ox_Survive_Data.REQUEST_NEXTROUND:
						synchronized (Ox_survive_Server.this) {
							this.receive = true;
							if (all_user_end()) {
								System.out.println("o�� ��������Ƽ");
								for (int z = 0; z < 50; z++) {
									System.out.println(z + " " + data.getOpan().ch_priority_lo[z].isIs_hear());
								}
								System.out.println("x�� ��������Ƽ");
								for (int z = 0; z < 50; z++) {
									System.out.println(z + " " + data.getXpan().ch_priority_lo[z].isIs_hear());
								}
								System.out.println(data.ch_list.size() + "���� �����͸� �޾���");
								System.out.println("�Ͻ�" + data.date);
								next_round_send(data);
								Ox_Survive_Data re_data = new Ox_Survive_Data();
								re_data.protocol = Ox_Survive_Data.NEXT_ROUND;
								re_data.setAi_move(gameover.getAi_move());
								send_all_client(re_data);
							}
							break;

						}
					case Ox_Survive_Data.CHARACTER_MOVE:
						synchronized (Ox_survive_Server.this) {
							send_all_client(data);
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

				// ����
				socket_list.remove(index);
				user_list.remove(index);

				show_user_list();
				send_user_list();

				String display = String.format("%s���� �����̽��ϴ�.\n", name);
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
		super("�������� ������");
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

	public void next_round_send(Ox_Survive_Data data) {
		// TODO Auto-generated method stub
		opan = data.getOpan();
		xpan = data.getXpan();
		ch_m.setOpan(opan);
		ch_m.setXpan(xpan);
		ch_m.ch_list = data.ch_list;
		ch_m.ch_user_list = data.ch_user_list;
		gameover.setCh_list(ch_m.ch_list);
		gameover.gameover_server_ready();
		gameover.nextRound();

	}

	public boolean all_user_end() {
		// TODO Auto-generated method stub
		int index = 0;
		for (ReadThread rt : socket_list) {
			if (rt.receive)
				index++;
		}
		if (socket_list.size() == index) {
			for (ReadThread rt : socket_list) {
				rt.receive = false;
			}
			return true;

		} else
			return false;
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
					// ��ó���� �ʿ��� ������ ���⿡ �־��//
					////////////////////////
					send_all_client(data);
					start = true;///// ���߿� �� �� ������ ���. �̰� �׳� ��������� ����� ���� �ȳ��� start��.
					check_view();

					/// ���� �ʱ�ȭ �ؼ� ������
					init_game_fisrt();
					data = new Ox_Survive_Data();
					data.protocol = Ox_Survive_Data.INITIALIZE_GAME;
					data.opan = opan;
					data.xpan = xpan;
					data.ch_list = ch_m.ch_list;
					data.ch_user_list = ch_m.ch_user_list;
					data.setQuiz_r_n(munje.getQuiz_r_n());
					data.setQuiz_r_m(munje.getQuiz_r_m());
					data.setQuiz_r_c(munje.getQuiz_r_c());
					send_all_client(data);

					init_game_round();
					data = new Ox_Survive_Data();
					data.protocol = Ox_Survive_Data.NEXT_ROUND;
					data.setAi_move(gameover.getAi_move());
					send_all_client(data);

				}

			}
		};
		jbt_start.addActionListener(action);
	}

	protected void init_game_round() {
		// TODO Auto-generated method stub
		gameover = new GameOver(munje, ch_m);
		gameover.nextRound();
	}

	protected void init_game_fisrt() {
		// TODO Auto-generated method stub
		int border = (int) (MyConst.GAME_W * 0.05);
		int width = Pan.WIDTH;
		int height = Pan.HEIGHT;

		opan = new Pan(Pan.OPAN, 0 + border, 0 + border);
		xpan = new Pan(Pan.XPAN, MyConst.GAME_W - border - width, 0 + border);
		ch_m = new Character_Manager(opan, xpan, Character_Manager.HEAVY, socket_list.size());
		try {
			munje = new MunJe();
			munje.random();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int z = 0; z < 50; z++) {
			System.out.println(z + " " + ch_m.getOpan().ch_priority_lo[z].isIs_hear());
		}
		System.out.println("x�� ��������Ƽ");
		for (int z = 0; z < 50; z++) {
			System.out.println(z + " " + ch_m.getXpan().ch_priority_lo[z].isIs_hear());
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
			jbt_start.setText("������...");
		} else if (!(socket_list.size() == 0) && all_ready) {
			jbt_start.setEnabled(true);
			jbt_start.setText("����");
		} else {
			jbt_start.setEnabled(false);
			jbt_start.setText("����");
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
		// for (ReadThread rt : socket_list) {
		for (int i = 0; i < socket_list.size(); i++) {
			ReadThread rt = socket_list.get(i);
			data.user_index = i;
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

		jbt_start = new JButton("����");
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
					System.out.println("���� ������");
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
