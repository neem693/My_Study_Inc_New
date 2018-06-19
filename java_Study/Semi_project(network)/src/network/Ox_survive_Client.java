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
		super("내가만든 윈도우");
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
				check_view();
				oos = new ObjectOutputStream(socket.getOutputStream());
				ios = new ObjectInputStream(socket.getInputStream());

				Ox_Survive_Data data = new Ox_Survive_Data();
				data.protocol = Ox_Survive_Data.USER_IN;
				oos.writeObject(data);
				read_data();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				show_the_message("서버가 이상하네. 나중에 접속 ㄱㄱ\n");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				show_the_message("서버가 죽은거 같다.\n");

			}
		} else {

			check_view();
			try {
				ios.close();
				oos.close();
				socket = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		}

	}

	private String divide_get(int i) {
		// TODO Auto-generated method stub
		// 0이면 ip 2는 포트이다.

		String[] str;
		try {
			str = jserver_addr.getText().split(":");
			switch (i) {
			case 0:
				return str[0];
			case 1:
				return str[1];

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			show_the_message("포트를 입력하라고!! 마지막 네 부분 예)192.168.0.5:7000\n");
		}

		return null;
	}

	private void show_the_message(String display) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		jtext.append(display);
		int position = jtext.getDocument().getLength();
		jtext.setCaretPosition(position);

	}

	private void check_view() {
		// TODO Auto-generated method stub
		// 서버에 연결하고 레디 하는 클라이언트 정보에 대해서 계속 체크하여 계속해서 view를 변화시킨다.
		connect = !connect;

		if (connect) {
			connect_server.setText("연결끊기");
			ready_nick_set.setEnabled(true);
		} else {
			connect_server.setText("서버연결");
			ready_nick_set.setEnabled(false);
		}

	}

	private void read_data() {
		// TODO Auto-generated method stub
		
		

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
		ready = !ready;
		Ox_Survive_Data data = new Ox_Survive_Data();

		if (!ready) {
			data.protocol = Ox_Survive_Data.READY_CANCLE;
			ready_nick_set.setText("레디");

		} else {

			data.protocol = Ox_Survive_Data.READY_NICKSET;
			data.nick_name = jnick_name.getText();
			ready_nick_set.setText("레디해제");
			
		}
		try {
			oos.writeObject(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void init_panel_button() {
		// TODO Auto-generated method stub
		main_panel = new JPanel(new BorderLayout());
		main_panel.setPreferredSize(new Dimension(600, 400));

		north_panel = new JPanel(new GridLayout(3, 2));

		connect_server = new JButton("서버연결");
		north_panel.add(connect_server);

		ready_nick_set = new JButton("닉네임 적용&레디");
		north_panel.add(ready_nick_set);
		ready_nick_set.setEnabled(false);

		server_label = new JLabel("서버 ip");
		server_label.setFont(new Font("굴림", 0, 15));
		server_label.setHorizontalAlignment(SwingConstants.CENTER);
		north_panel.add(server_label);

		nick_label = new JLabel("닉네임");
		nick_label.setFont(new Font("굴림", 0, 15));
		nick_label.setHorizontalAlignment(SwingConstants.CENTER);
		north_panel.add(nick_label);

		jserver_addr = new JTextField("192.168.0.5:7000");
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
		String[] list_data = { "오라트리", "로라트리", "냠냠냠" };
		//
		juser.setListData(list_data);

		this.add(main_panel);

	}

	public static void main(String[] args) {
		new Ox_survive_Client();
		// new Ox_Suvive();

	}

}