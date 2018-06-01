package mymain.tcp.multichat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
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
	// BufferedReader br=null;
	// ����
	ObjectInputStream ois = null; // ��ü����ȭ(����)
	ObjectOutputStream oos = null;// ��ü����ȭ(�۽�)

	JPanel grimPan;
	Image memPan; // �޸𸮻��� �׸���
	int thick; // �� ����
	int r = 0, g = 0, b = 0; // �� ����

	Socket client;
	String user_name = "�̳��߿�_����Ʈ��(����)"; // ��ȭ��

	public MultiChatClient() {
		super("��Ƽä�� Ŭ���̾�Ʈ");

		// ��ȸâ �ʱ�ȭ
		init_display();

		// �����ڸ�� �ʱ�ȭ
		init_userlist();

		// �����ڼ� �ʱ�ȭ �޽��� â �ʱ�ȭ
		init_input();

		init_grimpan();

		this.pack();
		this.setLocation(200, 100);
		// this.setBounds(200, 100, 400, 300);
		this.setVisible(true);

		System.out.println(grimPan);
		memPan = grimPan.createImage(400, 400);
		System.out.println(memPan);

		Graphics g = memPan.getGraphics();
		g.clearRect(0, 0, 400, 400);
		g.drawString("�� �Ȱǰ�?", 10, 50);

		grimPan.repaint();
		this.setResizable(false);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void init_grimpan() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel(new BorderLayout());

		grimPan = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				g.drawImage(memPan, 0, 0, this);
			}

		};

		grimPan.setPreferredSize(new Dimension(400, 400));
		p.add(grimPan, "Center");

		JPanel menuP = new JPanel(new GridLayout(1, 3));

		p.add(menuP, "North");

		// ������
		Integer[] thick_array = { 10, 20, 30, 40, 50 };
		JComboBox<Integer> jcb_thick = new JComboBox<Integer>(thick_array);
		thick = jcb_thick.getItemAt(0);
		menuP.add(jcb_thick);
		// 2.������
		JButton jbt_color = new JButton("������");
		menuP.add(jbt_color);

		// 3.�����
		JButton jbt_clear = new JButton("�����");
		menuP.add(jbt_clear);

		this.add(p, "West");

		// �޴� �̺�Ʈ ó��
		// �� ����(�޺��ڽ�)
		jcb_thick.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub

				if (e.getStateChange() == ItemEvent.SELECTED) {
					thick = (Integer) e.getItem();

				}

			}
		});

		jbt_color.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// JColorChooser chooser = new JColorChooser(new Color(r,g,b));
				//
				Color color = JColorChooser.showDialog(MultiChatClient.this, "������", new Color(r, g, b));
				// null�� ù���� �Ķ���Ϳ� ���� �ػ� �߾ӿ� ���� �ȴ�.

				if (color != null) {
					r = color.getRed();
					g = color.getGreen();
					b = color.getBlue();
				} else
					color = new Color(r, g, b);

			}
		});
		// ����� �޴� �̺�Ʈ

		jbt_clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				memPan.getGraphics().clearRect(0, 0, 400, 400);
				grimPan.repaint();
			}
		});
		init_mouse_event();

	}

	private void init_mouse_event() {
		// TODO Auto-generated method stub

		MouseAdapter adapter = new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				my_send_line(e.getPoint());
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseDragged(e);
				System.out.println(e.getPoint().x + " " + e.getPoint().y);
				my_send_line(e.getPoint());
				

			}

		};

		// grimPan�� ���콺 �̺�Ʈ�� �߰��Ѵ�.
		grimPan.addMouseListener(adapter); // mousePressed
		grimPan.addMouseMotionListener(adapter); // mouseDragged

	}

	protected void my_send_line(Point point) {
		// TODO Auto-generated method stub


		if (bConnect == false)
			return;

		// ������ �׸��� ������ ����
		MyData data = new MyData();
		
		data.data_protocol = MyData.GRIM;
		
		data.pt = point;
		
		data.thick = thick;
		data.color = new Color(r, g, b);
		
		try {
			// �׸������� ����
			oos.writeObject(data);

		} catch (Exception e) {
			// TODO: handle exception
		}

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
						client = new Socket("inca08", 9500);

						// ObjectInputStream / ObjectOutputStream
						// �������ǻ���(Cross�����ؾ� �Ѵ�.)

						oos = new ObjectOutputStream(client.getOutputStream());
						ois = new ObjectInputStream(client.getInputStream());
						// out -> in
						// in -> out

						// client = new Socket("inca001", 8500);
						// ������������ ����
						// String send_message = String.format("IN#%s\n", user_name);
						// ���⼭ �ݵ�� \n�� �ؾ� �Ѵ�. ���۵帮���̱� ������
						// client.getOutputStream().write(send_message.getBytes());
						MyData data = new MyData();
						data.data_protocol = MyData.IN;
						data.user_name = user_name;
						
						Graphics g  = memPan.getGraphics();
						
						g.clearRect(0, 0, 400, 400);

						oos.writeObject(data);// ����

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
						oos.close();
						ois.close();
						oos = null;
						ois = null;
						// null �����Ѱ� ���� ����ذ�
						// ���� �۾�
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

		new Thread() {
			public void run() {
				while (true) {

					try {
						// String readStr = br.readLine();
						MyData data = (MyData) ois.readObject();
						if (data == null)
							break;

						// ���ŵ����� �������� �и��۾�

						String display_message;
						switch (data.data_protocol) {
						case MyData.IN:
							display_message = String.format("[%s]�� ����", data.getUser_name());
							my_display_message(display_message);
							break;
						case MyData.OUT:
							display_message = String.format("[%s]�� ����", data.getUser_name());
							my_display_message(display_message);
							break;
						case MyData.LIST:
							my_display_userlist(data);
							break;
						// ����������� ����� �����Ȳ

						case MyData.CHAT:
							display_message = String.format("[%s] : %s", data.user_name, data.message);
							my_display_message(display_message);
							break;
						case MyData.GRIM:
							
							my_read_draw(data);
							
						}

					} catch (Exception e) {
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

	protected void my_read_draw(MyData data) {
		// TODO Auto-generated method stub
		Graphics gg = memPan.getGraphics();
		gg.setColor(data.color);
		gg.fillOval(data.pt.x-data.thick/2, data.pt.y-data.thick/2, data.thick, data.thick);
		grimPan.repaint();
	}

//	protected void my_draw_line(MyData data) {
//		// TODO Auto-generated method stub
//		Graphics g1 = memPan.getGraphics();
//		// Color color = new Color(red, green, blue);
//
//		g1.setColor(data.color);
//		g1.fillOval(data.pt.x - data.thick / 2, data.pt.y - data.thick / 2, data.thick, data.thick);
//
//		// �޸� -->ȭ�麹�� : paintComponent���� �����ڵ尡 �ִ�.
//		grimPan.repaint();
//	}

	public void my_display_message(String message) {

		jta_display.append(message + "\r\n");

		int position = jta_display.getDocument().getLength();
		jta_display.setCaretPosition(position);

	}

	protected void my_display_userlist(MyData data) {
		// TODO Auto-generated method stub

		jlist_user.setListData(data.user_list);

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

		

		try {
			
			MyData data = new MyData();
			data.data_protocol = MyData.CHAT;
			data.user_name = user_name;
			data.message = message;
			
			oos.writeObject(data);
			
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