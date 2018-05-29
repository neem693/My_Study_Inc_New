package mymain.tcp.multichat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiChatClient extends JFrame {

	JTextArea jta_display; // ���â
	JTextField jtf_message; // �޽���â
	JList<String> jlist_user; // �����ڸ��
	JButton jbt_connect;
	boolean bConnect = false; // ������°����� ����
	BufferedReader br;
	// ����

	Socket client;
	String user_name = "����Ʈ��"; // ��ȭ��

	public MultiChatClient() {
		super("��Ƽä�� Ŭ���̾�Ʈ");

		// ��ȸâ �ʱ�ȭ
		init_display();

		// �����ڸ�� �ʱ�ȭ
		init_userlist();

		// �����ڼ� �ʱ�ȭ
		init_input();

		this.pack();
		this.setLocation(200, 100);
		// this.setBounds(200, 100, 400, 300);
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void init_input() {
		// TODO Auto-generated method stub

		JPanel p = new JPanel(new BorderLayout());

		// �޽���â
		jtf_message = new JTextField();

		p.add(jtf_message, "Center");

		// �����ư
		jbt_connect = new JButton("����");
		p.add(jbt_connect, "East");
		jbt_connect.setPreferredSize(new Dimension(150, 10));

		this.add(p, "South");

		jbt_connect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// �̰� ��� ����̶�� �Ѵ�.
				bConnect = !bConnect;

				if (bConnect) {
					// �����۾�
					try {
						client = new Socket("inca08",8500);
						//client = new Socket("inca001", 8500);
						// ������������ ����
						String send_message = String.format("IN#%s\n", user_name);
						// ���⼭ �ݵ�� \n�� �ؾ� �Ѵ�. ���۵帮���̱� ������
						client.getOutputStream().write(send_message.getBytes());

						my_read_message();

					} catch (UnknownHostException e1) {
						// TODO Auto-generated catch block
						// e1.printStackTrace();
						bConnect = false;
						System.out.println("��� �ּ����� �𸣰ڴ�.");
						System.out.println("�������");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						// e1.printStackTrace();
						bConnect = false;
						System.out.println("������ �׾��ִ°� ������?");
						System.out.println("�������");
					}

				} else {
					// �����۾�
					try {
						client.close();
						my_clear_userlist();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						// e1.printStackTrace();
						System.out.println("���������� ������ �׾��ִ� �� ������?");
					}

				}

				jbt_connect.setText(bConnect ? "����" : "����");

			}
		});

		// Ű�̺�Ʈ ó��
		init_key_event();

	}

	protected void my_clear_userlist() {
		// TODO Auto-generated method stub
		String[] empty = new String[0];
		jlist_user.setListData(empty);
	}

	protected void my_read_message() {
		// TODO Auto-generated method stub
		try {
			br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		new Thread() {
			public void run() {
				while (true) {

					try {
						String readStr = br.readLine();
						if (readStr == null)
							break;

						// ���ŵ����� �������� �и��۾�
						String[] data = readStr.split("#");
						String display_message;
						switch (data[0]) {
						case "IN":
							display_message = String.format("[%s]�� ����", data[1]);
							my_display_message(display_message);
							break;
						case "OUT":
							display_message = String.format("[%s]�� ����", data[1]);
							my_display_message(display_message);
							break;
						case "LIST":
							my_display_userlist(data);
							break;
						// ����������� ����� �����Ȳ
						// data = "LIST#�浿1#�浿2#"
						// data = { "LIST","�浿1","�浿2"};
						case "CHAT":
							display_message = String.format("[%s] : %s", data[1], data[2]);
							my_display_message(display_message);
							break;

						}

					} catch (IOException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
						break;
					}

				}
				bConnect = false;
				jbt_connect.setText("����");
			}
		}.start();

	}

	public void my_display_message(String message) {

		jta_display.append(message + "\r\n");

		int position = jta_display.getDocument().getLength();
		jta_display.setCaretPosition(position);

	}

	protected void my_display_userlist(String[] user_array) {
		// TODO Auto-generated method stub

		String[] name_array = new String[user_array.length - 1];

		System.arraycopy(user_array, 1, name_array, 0, name_array.length);

		jlist_user.setListData(name_array);

	}

	private void init_key_event() {
		// TODO Auto-generated method stub

		KeyAdapter adapater = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);
				int key = e.getKeyCode();

				if (key == KeyEvent.VK_ENTER) {
					my_send_message();

				}
			}
		};
		jtf_message.addKeyListener(adapater);

	}

	protected void my_send_message() {
		// TODO Auto-generated method stub
		if (bConnect == false) {
			jtf_message.setText("");
			JOptionPane.showMessageDialog(this, "���� ���� �� �̿��ϼ���");
			return;

		}

		String message = jtf_message.getText().trim();
		if (message.isEmpty())
			return;

		String send_message = String.format("CHAT#%s#%s\n", user_name, message); // ����

		try {
			client.getOutputStream().write(send_message.getBytes());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("--�޽��� ���� ����--");
		}
		jtf_message.setText("");
	}

	private void init_userlist() {
		// TODO Auto-generated method stub
		jlist_user = new JList<String>();
		JScrollPane jsp = new JScrollPane(jlist_user);

		this.add(jsp, "East");

		jsp.setPreferredSize(new Dimension(150, 400));

		// String[] user_array = { "�浿1", "�浿2", "�����", "�浿3" };
		// jlist_user.setListData(user_array);

	}

	private void init_display() {
		// TODO Auto-generated method stub
		jta_display = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta_display);

		this.add(jsp, "Center");

		jsp.setPreferredSize(new Dimension(400, 400));

		// �б�����
		jta_display.setEditable(false);

	}

	public static void main(String[] args) {
		new MultiChatClient();

	}

}