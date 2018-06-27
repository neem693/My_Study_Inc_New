package network;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ox_survive.Ox_Suvive;

public class Ox_survive_Client extends JFrame {

	Ox_Suvive ox_survive;
	JPanel main_panel;
	JPanel north_panel;
	JLabel server_label;
	JLabel nick_label;
	JButton connect_server;
	JButton ready_nick_set;
	boolean connect = false;
	boolean ready = false;

	JTextArea jtext;
	JTextField jserver_addr;
	JTextField jnick_name;
	JScrollPane jscroll;
	JList<String> juser;
	Socket socket;

	ObjectInputStream ios;
	ObjectOutputStream oos;

	public Ox_survive_Client() {
		super("�������� ������");
		this.setLocation(200, 100);
		// this.setBounds(200, 100, 400, 300);
		init_panel_button();
		init_event();
		this.pack();
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void connect_socket() {
		// TODO Auto-generated method stub
		if (connect == false) {

			try {

				socket = new Socket(divide_get(0), Integer.parseInt(divide_get(1)));
				connect = true;
				check_view();
				oos = new ObjectOutputStream(socket.getOutputStream());
				ios = new ObjectInputStream(socket.getInputStream());

				Ox_Survive_Data data = new Ox_Survive_Data();
				data.protocol = Ox_Survive_Data.USER_IN;
				data.nick_name = InetAddress.getLocalHost().getHostAddress();
				oos.writeObject(data);
				read_data();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				show_the_message("������ ������ ����.");
				init_client();

			}
		} else {
			connect = false;
			init_client();

		}

	}

	private void init_client() {
		// TODO Auto-generated method stub
		if (connect)
			connect = false;
		if (ready)
			ready = false;

		try {
			socket = null;
			ios.close();
			oos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();

		}
		check_view();

	}

	private String divide_get(int i) {
		// TODO Auto-generated method stub
		// 0�̸� ip 2�� ��Ʈ�̴�.

		String[] str;
		try {
			str = jserver_addr.getText().split(":");
			switch (i) {
			case 0:
				return str[0].trim();
			case 1:
				return str[1].trim();

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			show_the_message("��Ʈ�� �Է��϶��!! ������ �� �κ� ��)192.168.0.5:7000");
		}

		return null;
	}

	private void show_the_message(String display) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		jtext.append(String.format("%s\n", display));
		int position = jtext.getDocument().getLength();
		jtext.setCaretPosition(position);

	}

	private void check_view() {
		// TODO Auto-generated method stub
		// ������ �����ϰ� ���� �ϴ� Ŭ���̾�Ʈ ������ ���ؼ� ��� üũ�Ͽ� ����ؼ� view�� ��ȭ��Ų��.

		if (connect) {
			connect_server.setText("�������");
			ready_nick_set.setEnabled(true);// ������ �Ǹ� ���� ����������
		} else {
			connect_server.setText("��������");
			ready_nick_set.setEnabled(false);// ������ �ȵɰ�� ���� ��ü�� �������� �ʵ��� ��.
		}
		if (!ready) {
			ready_nick_set.setText("�г��� ����&����");
		} else
			ready_nick_set.setText("��������");

	}

	private void read_data() {
		// TODO Auto-generated method stub

		new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				while (true) {
					try {
						Ox_Survive_Data data = (Ox_Survive_Data) ios.readObject();
						show_the_message(data.protocol + "�� ���������� �޾ҽ��ϴ�.");
						switch (data.protocol) {
						case Ox_Survive_Data.USER_IN:
							show_the_message(data.nick_name + "���� �����ϼ˽��ϴ�. ����");
							
							
							break;
						case Ox_Survive_Data.USER_LIST:
							juser.setListData(data.user_list);
							break;
						case Ox_Survive_Data.USER_OUT:
							show_the_message(data.nick_name + "���� �����ϼ̽��ϴ�. ����");
							break;
						case Ox_Survive_Data.GAME_START:
							ox_survive = new Ox_Suvive();
							ox_survive.setIos(ios);
							ox_survive.setOos(oos);
							
							break;	
						case Ox_Survive_Data.INITIALIZE_GAME:
							ox_survive.send_message(data);
							break;
						case Ox_Survive_Data.NEXT_ROUND:
						
							ox_survive.send_message(data);
							break;
						case Ox_Survive_Data.KILL:
							ox_survive.send_message(data);
						case Ox_Survive_Data.CHARACTER_MOVE:
							ox_survive.send_message(data);
							break;

						}
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						show_the_message("�������");
						init_client();
						break;
					}
				}

			}

		}.start();

	}

	private void init_event() {
		// TODO Auto-generated method stub
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (connect_server == e.getSource()) {
					connect_socket();
				}
				if (ready_nick_set == e.getSource()) {
					ready_nick_set();

				}
			}

		};
		connect_server.addActionListener(action);
		ready_nick_set.addActionListener(action);

	}

	protected void ready_nick_set() {
		// TODO Auto-generated method stub
		Ox_Survive_Data data = new Ox_Survive_Data();
		check_view();

		if (ready) {
			data.protocol = Ox_Survive_Data.READY_CANCLE;
			ready = false;

		} else {

			data.protocol = Ox_Survive_Data.READY_NICKSET;
			data.nick_name = jnick_name.getText().trim();
			ready = true;

		}
		try {
			oos.writeObject(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		check_view();

	}

	private void init_panel_button() {
		// TODO Auto-generated method stub
		main_panel = new JPanel(new BorderLayout());
		main_panel.setPreferredSize(new Dimension(600, 400));

		north_panel = new JPanel(new GridLayout(3, 2));

		connect_server = new JButton("��������");
		north_panel.add(connect_server);

		ready_nick_set = new JButton("�г��� ����&����");
		north_panel.add(ready_nick_set);
		ready_nick_set.setEnabled(false);

		server_label = new JLabel("���� ip");
		server_label.setFont(new Font("����", 0, 15));
		server_label.setHorizontalAlignment(SwingConstants.CENTER);
		north_panel.add(server_label);

		nick_label = new JLabel("�г���");
		nick_label.setFont(new Font("����", 0, 15));
		nick_label.setHorizontalAlignment(SwingConstants.CENTER);
		north_panel.add(nick_label);
		jserver_addr = new JTextField("192.168.0.5:7000");
//		try {
//			jserver_addr = new JTextField(InetAddress.getLocalHost().getHostAddress()+":7000");
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		north_panel.add(jserver_addr);

		jnick_name = new JTextField();
		north_panel.add(jnick_name);

		main_panel.add(north_panel, BorderLayout.NORTH);

		jtext = new JTextArea();
		jscroll = new JScrollPane(jtext);
		jscroll.setPreferredSize(new Dimension(400, 400));
		main_panel.add(jscroll, BorderLayout.WEST);

		juser = new JList<String>();
		juser.setPreferredSize(new Dimension(200, 400));
		main_panel.add(juser, BorderLayout.EAST);
		//
		String[] list_data = { "����Ʈ��", "�ζ�Ʈ��", "�ȳȳ�" };
		//
		juser.setListData(list_data);

		this.add(main_panel);

	}

	public static void main(String[] args) {
		new Ox_survive_Client();
		// new Ox_Suvive();

	}

}