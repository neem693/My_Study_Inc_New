import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class Blue_Marble extends JFrame {

	Timer timer, t;
	static Player play = new Player("�����", 1000000); // ����1 ��ü ����( ������̸� , �ʱ��ں�)

	static Player play2 = new Player("�����2", 1000000); // ����2 ��ü ����( ������̸� , �ʱ��ں�)

	public static final int index_interval = 30;
	int interval = 0;

	Contry con = new Contry();
	JPanel BlueGamePan; // ������ �����!!!!!!!!!!!!!!!
	Buy_Sell_new nbs;
	public JTextArea jta_chat;
	public JTextArea jta_ai_chat;
	JPanel p;

	JButton jbt_buy = new JButton(new ImageIcon(
			((new ImageIcon("Button/����.png")).getImage()).getScaledInstance(75, 70, java.awt.Image.SCALE_SMOOTH)));
	/*
	 * JButton jbt_sell = new JButton(new ImageIcon( ((new
	 * ImageIcon("�Ǹ�1.png")).getImage()).getScaledInstance(120, 50,
	 * java.awt.Image.SCALE_SMOOTH)));
	 */
	JButton jbt_pass = new JButton(new ImageIcon(
			((new ImageIcon("Button/������.png")).getImage()).getScaledInstance(75, 70, java.awt.Image.SCALE_SMOOTH)));
	JButton jbt_dice = new JButton(new ImageIcon(
			((new ImageIcon("Button/�ֻ���.png")).getImage()).getScaledInstance(130, 140, java.awt.Image.SCALE_SMOOTH)));// 160,60

	Image pic = Contry_Class.back_img;
	static Image Image_back = new ImageIcon("contry_img/Blue_iF_back.png").getImage();
	static Image boom = new ImageIcon("contry_img/test_back.gif").getImage(); // �ֻ��� �̺�Ʈ
	static Image dic_img = new ImageIcon("dice.gif").getImage();

	static Image back = Image_back;
	static Image[] img_exp = new Image[4];
	static {
		for (int i = 0; i < img_exp.length; i++)// i = 0~4
		{
			String filename = String.format("dice/exp_%02d.png", i + 1);
			img_exp[i] = new ImageIcon(filename).getImage();
			continue;
		}
	}

	Random rand = new Random(); // �����Լ� ����
	int index = 0;
	int move_count = 0;
	int interval_count = 0;
	int my_index = -1; /// �ʱ� ���� ��ġ (my_index+1)���� �����̹Ƿ� 0���� �����ϱ� ���� -1 ����
	int play2_index = -1; /// �ʱ� ���� ��ġ (my_index+1)���� �����̹Ƿ� 0���� �����ϱ� ���� -1 ����
	int dice_size = 100;
	public double dice_x = (MyConst.GAMEPAN_W / 2) - 200 - dice_size / 2; // ����x��ǥ
	double dice_y = 500 - dice_size; // ����y��ǥ
	////////////////////////////////////////////////////////////
	public double v = 30; // �ʱ� ���� �ӵ�
	public final double v_first = 6; // �ʱ� ���� �ӵ� ����
	public double vx; // x��ǥ�� �̵���ȭ�� ���
	double vy; // y��ǥ�� �̵���ȭ�� ���
	public double angle = 15; // ���� ����
	public double h = 1; // �ð�
	public double g = 0.2; // �߷°��ӵ�
	public double changh = 1;
	public double changh_buf = 0.1;
	public int dice_effet_count = 0;
	public int round = 0;
	public int round_ai = 0;

	//////////////////////////////////////////////////////////// �ֻ����� ������ ��꺯��

	public static int dice_num = 0;
	public static int dice_count = 0;
	public static int my_place_stack = 1;
	public static int play2_place_stack = 1;
	static String chat5 = "";
	static String chat6 = "";
	static int fine = 200000;
	int sqr_n = rand.nextInt(11); // 0~11

	public boolean click_check = false;
	public boolean now_moving = true;
	public boolean dice_moving = true;
	public static boolean turn = false; // false�� ���ΰ�
	public boolean char_move = true;
	public boolean fail_check_stats = false;

	public int delay_count = 0;

	// ���� ��ü 16�� ����

	public static List<Contry> con_col = new ArrayList<Contry>();

	static JButton ���� = new JButton("����");
	static JButton �븣���� = new JButton("�븣����");
	static JButton ���þ� = new JButton("���þ�");
	static JButton �縶�Ͼ� = new JButton("�縶�Ͼ�");
	static JButton ������ = new JButton("������");
	static JButton �ʶ��� = new JButton("�ʶ���");
	static JButton ������ = new JButton("������");
	static JButton ���Ϸ��� = new JButton("���Ϸ���");
	static JButton ��Ż���� = new JButton("��Ż����");
	static JButton �߱� = new JButton("�߱�");
	static JButton �Ϻ� = new JButton("�Ϻ�");
	static JButton �밡�� = new JButton("�밡��");
	static JButton ����_ai = new JButton("����");
	static JButton �븣����_ai = new JButton("�븣����");
	static JButton ���þ�_ai = new JButton("���þ�");
	static JButton �縶�Ͼ�_ai = new JButton("�縶�Ͼ�");
	static JButton ������_ai = new JButton("������");
	static JButton �ʶ���_ai = new JButton("�ʶ���");
	static JButton ������_ai = new JButton("������");
	static JButton ���Ϸ���_ai = new JButton("���Ϸ���");
	static JButton ��Ż����_ai = new JButton("��Ż����");
	static JButton �߱�_ai = new JButton("�߱�");
	static JButton �Ϻ�_ai = new JButton("�Ϻ�");
	static JButton �밡��_ai = new JButton("�밡��");

	public Blue_Marble() {

		super("��縶�� ���ο�");

		init_contry_set(); // ���� ��ü�� array_list�� ���ų��� ����?

		
		/*  play.contry_stack[0]=5; play.contry_stack[1]=13;
		 
		  
		  play2.contry_stack[0]=2; play2.contry_stack[1]=3; play2.contry_stack[2]=4;
		  play2.contry_stack[3]=6; play2.contry_stack[4]=7; play2.contry_stack[5]=8;*/
		 

		init_game_pan();

		init_timer();

		init_display();

		init_sound("music/���1.wav", true);

		nbs.active_button();
		nbs.active_button_ai();
		
		this.setLocation(200, 0);
		setResizable(true);
		pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_sound(String file, boolean Loop) {
		// TODO Auto-generated method stub
		// ��� ����
		try {
			AudioInputStream bgm = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));
			// Clip�������̽��� ����� �����͸� ��� �����ε� �� ���ִ� Ư���� ������ ������ ������ ��Ÿ���ϴ�.
			Clip clip = AudioSystem.getClip();
			clip.open(bgm);
			clip.start();
			if (Loop)
				clip.loop(-1); // �ݺ� ���

			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(0f); // ���� ��Ʈ��

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	static JLabel jlb_price;
	static JLabel jlb_building;
	static JLabel jlb_price_ai;
	static JLabel jlb_building_ai;

	public void init_display() {
		// TODO Auto-generated method stub
		// nbs = new buy_sell(this);
		nbs = new Buy_Sell_new(this);
		
		
		
		
		int count = 0;
		int count1 = 0;
		p = new JPanel(new GridLayout(2, 1));
		JPanel play1 = new JPanel(new BorderLayout());
		JPanel play2 = new JPanel(new GridLayout(9, 1));

		play2.add(new JLabel("Player"));
		play2.add(jlb_price = new JLabel());

		play2.add(new JLabel("�ѱݾ� : "));
		play2.add(jlb_price = new JLabel());

		jlb_price.setText(Blue_Marble.play.price + "��");// �ʱ� �ѱݾ� ��

		play2.add(new JLabel("�ǹ��� : "));
		play2.add(jlb_building = new JLabel());

		jlb_building.setText(count + "��");// �ʱ� ȣ�ڼ� ��

		play2.add(����);
		play2.add(�븣����);
		play2.add(���þ�);
		play2.add(�縶�Ͼ�);
		play2.add(������);
		play2.add(�ʶ���);
		play2.add(������);
		play2.add(���Ϸ���);
		play2.add(��Ż����);
		play2.add(�߱�);
		play2.add(�Ϻ�);
		play2.add(�밡��);

		ActionListener my_play = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Object evt_bt = e.getSource();// �̺�Ʈ�� �߻���Ų ��Ʈ��,�������ȴ��� �𸣱⶧���� obŸ������ �޴´�.

				if (evt_bt == ����) {
					nbs.sell(2);
					����.setEnabled(false);
				}

				else if (evt_bt == �븣����) {
					nbs.sell(3);
					�븣����.setEnabled(false);

				} else if (evt_bt == ���þ�) {
					nbs.sell(4);
					���þ�.setEnabled(false);

				} else if (evt_bt == �縶�Ͼ�) {
					nbs.sell(5);
					�縶�Ͼ�.setEnabled(false);

				} else if (evt_bt == ������) {
					nbs.sell(6);
					������.setEnabled(false);

				} else if (evt_bt == �ʶ���) {
					nbs.sell(7);
					�ʶ���.setEnabled(false);

				} else if (evt_bt == ������) {
					nbs.sell(9);
					������.setEnabled(false);

				} else if (evt_bt == ���Ϸ���) {
					nbs.sell(10);
					���Ϸ���.setEnabled(false);

				} else if (evt_bt == ��Ż����) {
					nbs.sell(11);
					��Ż����.setEnabled(false);

				} else if (evt_bt == �߱�) {
					nbs.sell(13);
					�߱�.setEnabled(false);

				} else if (evt_bt == �Ϻ�) {
					nbs.sell(14);
					�Ϻ�.setEnabled(false);

				} else if (evt_bt == �밡��) {
					nbs.sell(15);
					�밡��.setEnabled(false);

				}

				File file_sell = new File("music/�Ǹ�.wav");

				try {
					AudioInputStream stream = AudioSystem.getAudioInputStream(file_sell);
					Clip clip = AudioSystem.getClip();
					clip.open(stream);
					clip.start();
					// clip.loop(count);
				} catch (Exception w) {
					// TODO: handle exception
					w.printStackTrace();
				}

			}

		};

		����.addActionListener(my_play);
		�븣����.addActionListener(my_play);
		���þ�.addActionListener(my_play);
		�縶�Ͼ�.addActionListener(my_play);
		������.addActionListener(my_play);
		�ʶ���.addActionListener(my_play);
		������.addActionListener(my_play);
		���Ϸ���.addActionListener(my_play);
		��Ż����.addActionListener(my_play);
		�߱�.addActionListener(my_play);
		�Ϻ�.addActionListener(my_play);
		�밡��.addActionListener(my_play);

		// Player�� ä��â
		jta_chat = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta_chat);

		jta_chat.append(nbs.chat + ""); // �α� ������ JTextArea ���� �ٿ��ְ�
		jta_chat.setCaretPosition(jta_chat.getDocument().getLength()); // �ǾƷ��� ��ũ���Ѵ�.

		jta_chat.append(nbs.chat1 + ""); // �α� ������ JTextArea ���� �ٿ��ְ�
		jta_chat.setCaretPosition(jta_chat.getDocument().getLength()); // �ǾƷ��� ��ũ���Ѵ�.

		play1.add(play2, "North");// ��Ȳ��
		// play2.setPreferredSize(new Dimension(200, 100));

		play1.add(jsp, "Center");// ä��â
		jsp.setPreferredSize(new Dimension(300, 500));

		p.add(play1, "Center");// play1 = BorderLayout ��ġ�� ������
		// play1.setPreferredSize(new Dimension(200, 1200));

		JPanel ai = new JPanel(new BorderLayout());
		JPanel ai2 = new JPanel(new GridLayout(9, 1));

		ai2.add(new JLabel("AI"));
		ai2.add(jlb_price_ai = new JLabel());

		ai2.add(new JLabel("�ѱݾ� : "));
		ai2.add(jlb_price_ai = new JLabel());

		jlb_price_ai.setText(Blue_Marble.play.price + "��");// �ʱ� �ѱݾ� ��

		ai2.add(new JLabel("�ǹ��� : "));
		ai2.add(jlb_building_ai = new JLabel());

		jlb_building_ai.setText(count1 + "��");// �ʱ� ȣ�ڼ� ��

		// AI�� ä��â
		jta_ai_chat = new JTextArea();
		JScrollPane jsp1 = new JScrollPane(jta_ai_chat);

		jta_ai_chat.append(nbs.chat_ai + ""); // �α� ������ JTextArea ���� �ٿ��ְ�
		jta_ai_chat.setCaretPosition(jta_ai_chat.getDocument().getLength()); // �ǾƷ��� ��ũ���Ѵ�.

		jta_ai_chat.append(nbs.chat_ai1 + ""); // �α� ������ JTextArea ���� �ٿ��ְ�
		jta_ai_chat.setCaretPosition(jta_ai_chat.getDocument().getLength()); // �ǾƷ��� ��ũ���Ѵ�.

		ai2.add(����_ai);
		ai2.add(�븣����_ai);
		ai2.add(���þ�_ai);
		ai2.add(�縶�Ͼ�_ai);
		ai2.add(������_ai);
		ai2.add(�ʶ���_ai);
		ai2.add(������_ai);
		ai2.add(���Ϸ���_ai);
		ai2.add(��Ż����_ai);
		ai2.add(�߱�_ai);
		ai2.add(�Ϻ�_ai);
		ai2.add(�밡��_ai);

		ActionListener ai_play = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Object evt_bt = e.getSource();// �̺�Ʈ�� �߻���Ų ��Ʈ��,�������ȴ��� �𸣱⶧���� obŸ������ �޴´�.

				if (evt_bt == ����_ai) {
					//nbs.play2_sell(2);
					//����_ai.setEnabled(false);
				}

				else if (evt_bt == �븣����_ai) {
					//nbs.play2_sell(3);
					//�븣����_ai.setEnabled(false);

				} else if (evt_bt == ���þ�_ai) {
					//nbs.play2_sell(4);
					//���þ�_ai.setEnabled(false);

				} else if (evt_bt == �縶�Ͼ�_ai) {
					//nbs.play2_sell(5);
					//�縶�Ͼ�_ai.setEnabled(false);

				} else if (evt_bt == ������_ai) {
					//nbs.play2_sell(6);
					//������_ai.setEnabled(false);

				} else if (evt_bt == �ʶ���_ai) {
					//nbs.play2_sell(7);
					//�ʶ���_ai.setEnabled(false);

				} else if (evt_bt == ������_ai) {
					//nbs.play2_sell(9);
					//������_ai.setEnabled(false);

				} else if (evt_bt == ���Ϸ���_ai) {
					//nbs.play2_sell(10);
					//���Ϸ���_ai.setEnabled(false);

				} else if (evt_bt == ��Ż����_ai) {
					//nbs.play2_sell(11);
					//��Ż����_ai.setEnabled(false);

				} else if (evt_bt == �߱�_ai) {
					//nbs.play2_sell(13);
					//�߱�_ai.setEnabled(false);

				} else if (evt_bt == �Ϻ�_ai) {
					//nbs.play2_sell(14);
					//�Ϻ�_ai.setEnabled(false);

				} else if (evt_bt == �밡��_ai) {
					//nbs.play2_sell(15);
					//�밡��_ai.setEnabled(false);

				}

				File file_sell = new File("music/�Ǹ�.wav");

				try {
					AudioInputStream stream = AudioSystem.getAudioInputStream(file_sell);
					Clip clip = AudioSystem.getClip();
					clip.open(stream);
					clip.start();
					// clip.loop(count);
				} catch (Exception w) {
					// TODO: handle exception
					w.printStackTrace();
				}

			}

		};

		����_ai.addActionListener(ai_play);
		�븣����_ai.addActionListener(ai_play);
		���þ�_ai.addActionListener(ai_play);
		�縶�Ͼ�_ai.addActionListener(ai_play);
		������_ai.addActionListener(ai_play);
		�ʶ���_ai.addActionListener(ai_play);
		������_ai.addActionListener(ai_play);
		���Ϸ���_ai.addActionListener(ai_play);
		��Ż����_ai.addActionListener(ai_play);
		�߱�_ai.addActionListener(ai_play);
		�Ϻ�_ai.addActionListener(ai_play);
		�밡��_ai.addActionListener(ai_play);

		button_defult();

		ai.add(ai2, "North");// ai ��Ȳ��
		// ai2.setPreferredSize(new Dimension(200, 100));

		p.add(ai, "Center");// ai ä��â
		ai.setPreferredSize(new Dimension(200, 1200));

		ai.add(jsp1, "Center"); // ai = BorderLayout ��ġ�� ������
		jsp.setPreferredSize(new Dimension(200, 600));

		this.add(p, "East");// ��Ȳ�� GridLayouy ��ġ �� ������
		p.setPreferredSize(new Dimension(300, 1000));

	}

	private void button_defult() {
		// TODO Auto-generated method stub

		����.setEnabled(false);
		�븣����.setEnabled(false);
		���þ�.setEnabled(false);
		�縶�Ͼ�.setEnabled(false);
		������.setEnabled(false);
		�ʶ���.setEnabled(false);
		������.setEnabled(false);
		���Ϸ���.setEnabled(false);
		��Ż����.setEnabled(false);
		�߱�.setEnabled(false);
		�Ϻ�.setEnabled(false);
		�밡��.setEnabled(false);

		����_ai.setEnabled(false);
		�븣����_ai.setEnabled(false);
		���þ�_ai.setEnabled(false);
		�縶�Ͼ�_ai.setEnabled(false);
		������_ai.setEnabled(false);
		�ʶ���_ai.setEnabled(false);
		������_ai.setEnabled(false);
		���Ϸ���_ai.setEnabled(false);
		��Ż����_ai.setEnabled(false);
		�߱�_ai.setEnabled(false);
		�Ϻ�_ai.setEnabled(false);
		�밡��_ai.setEnabled(false);

	}

	private void init_contry_set() {
		// TODO Auto-generated method stub

		con_col.add(Contry_Class.start); // ��� ����Ʈ�� ����ü�� ���Ź���
		con_col.add(Contry_Class.����); // ���������� �ſ� �߿��ϹǷ� �߸��Ǹ� ���� �̻��Ѱ��� ����
		con_col.add(Contry_Class.������);
		con_col.add(Contry_Class.���þ�);
		con_col.add(Contry_Class.�縶�Ͼ�);
		con_col.add(Contry_Class.������);
		con_col.add(Contry_Class.�ʶ���);
		con_col.add(Contry_Class.������);
		con_col.add(Contry_Class.���ε�);
		con_col.add(Contry_Class.���Ϸ���);
		con_col.add(Contry_Class.��Ż����);
		con_col.add(Contry_Class.������);
		con_col.add(Contry_Class.�߱�);
		con_col.add(Contry_Class.�Ϻ�);
		con_col.add(Contry_Class.�밡��);
		con_col.add(Contry_Class.���ѹα�);

	}

	private void init_timer() {

		ActionListener listener1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (click_check) {
					if (dice_y < 630) {
						changh += 1;

						if (g < 1)
							g += 0.01;

						vy = -(v * Math.sin(angle * Math.PI / 180) - g * changh);
						dice_y += vy; // �ֻ����� ���Ͽ y��
						dice_x += 5;

						if (dice_x > MyConst.GAMEPAN_W - 200 - dice_size) {
							dice_x = MyConst.GAMEPAN_W - 200 - dice_size;
						}
						if (dice_y > 610) { // �ٴۿ� ��������� ���~
											// �������������� ������ �������� �ڵ�

							changh = changh_buf;
							changh_buf = changh_buf + 3;
							h = 1;
							changh -= (v * Math.sin(angle * Math.PI / 180));

						}

					}
				}

				if (dice_moving) { // �ֻ��� ������ ���� �Ŀ� �����δ�.
					if (turn == false)
						move_char(); // turn�� true�� ��� ���� �����δ�.
					else
						play2_move_char(); // turn�� false ��� ai�� �����δ�.
				}

				BlueGamePan.repaint(); // �����г��� 10ms���� ����ȣ��� �׸���.
										// repaint�� �Ʒ��� paint component�� ȣ���Ѵ�.
			}

		};

		timer = new Timer(15, listener1);
		timer.start();

	}

	private void play2_move_char() {
		// TODO Auto-generated method stub

		// jbt_buy.setEnabled(play2_index+1 > 0); //start ��ġ�� �ǹ� �Ǽ����� ���ϰ���

		if (play2_index + 1 > 15)
			play2_index = -1; // �Ѱ�ü�� ���� 16���̱⶧���� 16+1�� ������ �߻��ϹǷ� -1�� �־� 16���� ���Ѱ��Ѵ�.

		if (click_check) {

			if (play2.pos.x < con_col.get(play2_index + 1).pos.x) {
				play2.pos.x += 10;
			}

			else if (play2.pos.x > con_col.get(play2_index + 1).pos.x) {

				play2.pos.x -= 10;
			}

			if (play2.pos.y < con_col.get(play2_index + 1).pos.y) {
				play2.pos.y += 10;
			}

			else if (play2.pos.y > con_col.get(play2_index + 1).pos.y) {

				play2.pos.y -= 10;
			}

			if (play2.pos.x == con_col.get(play2_place_stack - 1).pos.x
					&& play2.pos.y == con_col.get(play2_place_stack - 1).pos.y && fail_check_stats == true) {

				
				if ((play2_place_stack ) == 9) // ����
				{

					Blue_Marble.play2.price -= fine;

					System.out.printf("%d\n", Blue_Marble.play2.price);
					System.out.printf("%d\n", play2_place_stack);
					jlb_price.setText(Blue_Marble.play2.price + "��");

					chat6 = String.format("���� 200000���Դϴ�");
					jta_ai_chat.append(chat6 + "\r\n");

				}
				
				
		
				
				
				for (int i = 0; i < 15; i++) {

					// ����ġ�� ������ ������ ��ġ���� Ȯ��
					if (play2_place_stack == play.contry_stack[i]) { // ���� �ǹ����� Ȯ��

						if (0 > (play2.price - con_col.get(play.contry_stack[i] - 1).price)) {
							// �����ϰ� �� �� 0�� ���������� �ǹ��� �����ϰ� ������� �Ǹ��ϴ� �˻�

							ai_pay_check(play.contry_stack[i] - 1);

						}

						play2.price -= con_col.get(play.contry_stack[i] - 1).price; // ���� ����
						play.price += con_col.get(play.contry_stack[i] - 1).price;

						System.out.printf("AI�� �÷��̾�� %d���� �����߽��ϴ�.", con_col.get(play.contry_stack[i] - 1).price);
					}
					jlb_price.setText(play.price + "��");// player ȭ�鿡 ����ǥ��
					jlb_price_ai.setText(play2.price + "��");// ai ȭ�鿡 ����ǥ��

				}

				////////////////////////////////////////////////////////////////////////////////////

				if (ai_buy_check()) {// ������ ���� �ݾ��� ��� �ܾ��� 30���� �̻��� Ȯ�εɰ��

					int i = rand.nextInt(2);
					System.out.printf("�������� %d\n", i);

					if (i == 1) {
						nbs.play2_buy();

						File file_buy = new File("music/����.wav");

						try {
							AudioInputStream stream = AudioSystem.getAudioInputStream(file_buy);
							Clip clip = AudioSystem.getClip();
							clip.open(stream);
							clip.start();
							// clip.loop(count);
						} catch (Exception w) {
							// TODO: handle exception
							w.printStackTrace();
						}

					}

				}

				////////////////////////////////////////////////////////////////////////////////////
				fail_check(); // ���ӿ��� ���� üũ
				fail_check_stats = false;
				jbt_dice.setEnabled(true);
				jbt_pass.setEnabled(true);// ĳ���� �̵� �Ϸ� �� ��ư Ȱ��ȭ
				jbt_buy.setEnabled(true);

				if (turn) { // ai�� ��� �ൿ�� ���� ���Ŀ� ���� ��ģ��!!!!!!
					turn = false;

				} else {
					// t.start();
					turn = true;

				}

				now_moving = true; // �ֻ��� ��ư Ŭ�� Ȱ��ȭ

			}

		}

		if (index_interval == interval_count) {

			if (dice_count > 0) {

				play2_index++;

			}

			if (dice_count == 0) {
				// ĳ���� �̵��߿��� �ֻ��� ��ư Ŭ���� �ȵȴ�.

				if (char_move == false) {
					char_move = true;

				}

			}

			dice_count--;

			// ���� ��ġ���� ������ǥ ��ġ���� ��ġ�� ��쿡�� ����ĭ���� �̵�

		}

		interval_count--;
		if (interval_count < 0)
			interval_count = 30;

	}

	public boolean ai_pay_check(int x) {
		// TODO Auto-generated method stub

		for (int i = 0; i < 15; i++) {

			if (play2.contry_stack[i] != 0) { // ������ ���ú��� ���ʴ�� �Ǹ��� ������.

				if (0 > play2.price - con_col.get(x).price) {
					nbs.play2_sell(play2.contry_stack[i]); // �Ǹ��Ŀ� �ܾ� ��˻�
					System.out.printf("ó���� ����ݾ�%d �ǸŽ����� ��ġ%d\n", play2.price, play2.contry_stack[x]);
				} else
					return true;

			}

		}

		return true;

	}

	public boolean ai_buy_check() {
		int n = 0;

		if (play2_place_stack == 9 || play2_place_stack == 1)
			return false; // ��ŸƮ �� ���ε� ����

		for (int i = 0; i < 15; i++) {

			if (play2.contry_stack[i] == play2_place_stack)
				return false;

			if (play.contry_stack[i] == play2_place_stack) {

				n = play.contry_stack[i];
				if (n > 0) {
					System.out.println("������ �������̰ų� �����Ҽ����� ���Դϴ� ����?.\n");
					return false;
				}
			}

		}

		if (200000 < (play2.price - con_col.get(play2_place_stack - 1).price)) {

			System.out.printf("ai�� ���� �ݾ� %d���� %d�� �E���� ������ 30���� �̻��Դϴ�.\n", play2.price,
					con_col.get(play2_place_stack - 1).price);
			return true;
		} else {

			System.out.println("���� ���߶� ����ϴ�\n");
			return false;
		}

	}

	public void move_char() {

		// jbt_buy.setEnabled(my_index+1> 0); // start ��ġ�� �ǹ� �Ǽ����� ���ϰ���

		// my_index = -1; /// �ʱ� ���� ��ġ���� �����̹Ƿ� 0���� �����ϱ� ���� -1 ����

		if (my_index + 1 > 15)
			my_index = -1; // �Ѱ�ü�� ���� 16���̱⶧���� 16+1�� ������ �߻��ϹǷ� -1�� �־� 16���� ���Ѱ��Ѵ�.

		if (click_check) {

			if (play.pos.x < con_col.get(my_index + 1).pos.x) {
				play.pos.x += 10;
			}

			else if (play.pos.x > con_col.get(my_index + 1).pos.x) {

				play.pos.x -= 10;
			}

			if (play.pos.y < con_col.get(my_index + 1).pos.y) {
				play.pos.y += 10;
			}

			else if (play.pos.y > con_col.get(my_index + 1).pos.y) {

				play.pos.y -= 10;
			}

			// System.out.printf("���� ����ġ %d ��ǥ��ġ%d, ����ġ %d ��ǥ��ġ
			// %d\n",play.pos.x,con_col.get(my_index + 1).pos.x,play.pos.y,
			// con_col.get(my_index + 1).pos.y);

			if (play.pos.x == con_col.get(my_place_stack - 1).pos.x
					&& play.pos.y == con_col.get(my_place_stack - 1).pos.y && fail_check_stats == true) {

				fail_check_stats = false;

				for (int i = 0; i < 15; i++) { // ����ġ�� ������ ������ ��ġ���� Ȯ��
					if (my_place_stack == play2.contry_stack[i]) { // ���� �ǹ����� Ȯ��

						play.price -= con_col.get(play2.contry_stack[i] - 1).price; // ���� ����
						play2.price += con_col.get(play2.contry_stack[i] - 1).price;

						System.out.printf("�÷��̾ AI���� %d���� �����߽��ϴ�.\n", con_col.get(play2.contry_stack[i] - 1).price);
					}
					jlb_price.setText(play.price + "��");// player ȭ�鿡 ����ǥ��
					jlb_price_ai.setText(play2.price + "��");// ai ȭ�鿡 ����ǥ��
				}

				if ((my_place_stack ) == 9) // ����
				{

					Blue_Marble.play.price -= fine;

					System.out.printf("%d\n", Blue_Marble.play.price);
					System.out.printf("%d\n", my_place_stack - 1);
					jlb_price.setText(Blue_Marble.play.price + "��");

					chat5 = String.format("���� 200000���Դϴ�");
					jta_chat.append(chat5 + "\r\n");

				}

				if ((my_place_stack ) == 5 || (my_place_stack ) == 13||(my_place_stack ) == 8) // ����
				{

					int result = 0;

					sqr_n = rand.nextInt(11);

					int button = JOptionPane.showOptionDialog(null, Contry_Class.str_quiz[sqr_n], "ox����!!!",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Contry_Class.str,
							Contry_Class.str[0]);
					// �����̸� 0 �����̸� 1

					result = Contry_Class.answer[sqr_n];
					// 0 0
					if (result == button) {
						Blue_Marble.play.price += 200000;
						jlb_price.setText(Blue_Marble.play.price + "��");

						chat5 = String.format("����! ��� 200000���Դϴ�");
						jta_chat.append(chat5 + "\r\n");
					} else {
						Blue_Marble.play.price -= 200000;
						jlb_price.setText(Blue_Marble.play.price + "��");

						chat5 = String.format("��! ���� 200000���Դϴ�");
						jta_chat.append(chat5 + "\r\n");
					}

				}

				fail_check();
				jbt_buy.setEnabled(true);
				jbt_pass.setEnabled(true);// ĳ���� �̵� �Ϸ� �� ��ư Ȱ��ȭ

			}

		}

		if (index_interval == interval_count) {

			if (dice_count > 0) {

				my_index++;

			}

			if (dice_count == 0) {

				if (char_move == false) {
					char_move = true;

				}

			}
			dice_count--;

			// ���� ��ġ���� ������ǥ ��ġ���� ��ġ�� ��쿡�� ����ĭ���� �̵�

		}

		interval_count--;
		if (interval_count < 0)
			interval_count = 30;

	}

	private void fail_check() {

		if (play2.price < 0) {

			JOptionPane.showMessageDialog(this, "�Ļ�!!!!!! ");

			set_defult();

		}

		if (play.price < 0) {

			JOptionPane.showMessageDialog(this, "�Ļ�!!!!!! ");

			set_defult();

		} else if (round > 2) {

			JOptionPane.showMessageDialog(this, "�÷��̾� ���ּ���!!!");
			System.out.println("���� ����\n");

			result();

			set_defult();

		} else if (round_ai > 2) {

			JOptionPane.showMessageDialog(this, "AI ���� ����!!!!");

			result();

			System.out.println("���� ����\n");
			set_defult();

		}

	}

	private void result() {
		// TODO Auto-generated method stub

		for (int i = 0; i < 15; i++) {

			if (0 != play.contry_stack[i])
				play.price += con_col.get(play.contry_stack[i] - 1).price;

			if (0 != play2.contry_stack[i])
				play2.price += con_col.get(play2.contry_stack[i] - 1).price;

			System.out.printf("�÷��̾� �ǹ� �Ѱ�:%d , ��ǻ�� �ǹ� �� ��:%d ���ð�%d\n", play.price, play2.price, play.contry_stack[i]);

		}

		// System.out.printf("�÷��̾� �ǹ� �Ѱ�:%d , ��ǻ�� �ǹ� �� ��:%d",play.price,play2.price);

		if (play.price > play2.price)
			JOptionPane.showMessageDialog(this, "�÷��̾� ��!!!");
		else
			JOptionPane.showMessageDialog(this, "�÷��̾� �й�!!!!!!!");

	}

	private void set_defult() {

		dice_num = 0;
		dice_count = 0;
		my_place_stack = 1;
		play2_place_stack = 1;
		index = 0;
		move_count = 0;
		interval_count = 0;
		my_index = -1; /// �ʱ� ���� ��ġ (my_index+1)���� �����̹Ƿ� 0���� �����ϱ� ���� -1 ����
		play2_index = -1; /// �ʱ� ���� ��ġ (my_index+1)���� �����̹Ƿ� 0���� �����ϱ� ���� -1 ����
		click_check = false;
		now_moving = true;
		dice_moving = true;
		turn = false; // false�� ���ΰ�
		char_move = true;
		fail_check_stats = false;

		play.price = 1000000; // ���� �ʱ�ȭ
		play.pos.x = 0;
		play.pos.y = 800; // ��ġ �ʱ�ȭ

		play2.price = 1000000; // ���� �ʱ�ȭ
		play2.pos.x = 0;
		play2.pos.y = 800; // ��ġ �ʱ�ȭ

		// ��ġ �ʱ�ȭ
		for (int i = 0; i < 15; i++) { // ���� �ʱ�ȭ

			play.contry_stack[i] = 0;
			button_defult();
		}

	}

	public void init_game_pan() {
		// TODO Auto-generated method stub

		BlueGamePan = new JPanel() {

			@Override
			protected void paintComponent(Graphics g) { // Jcomponent�� �߻�Ŭ������ ��ӵǾ��ִ�.
				// ��� �׸���

				g.drawImage(pic, 200, 200, this);

				for (int i = 0; i < con_col.size(); i++) {

					con_col.get(i).draw(g, con_col.get(i).contry_name);

				}

				for (int k = 0; k < play2.contry_stack.length; k++) {

					if (play2.contry_stack[k] != 0)
						con_col.get((play2.contry_stack[k]) - 1).draw(g, 0, 140, 10);// �ǹ� ��ġ

				}

				for (int k = 0; k < play.contry_stack.length; k++) {

					if (play.contry_stack[k] != 0)
						con_col.get((play.contry_stack[k]) - 1).draw(g, 0, 140);
				}

				if (click_check) {
					if (dice_y < 630)
						g.drawImage(dic_img, (int) dice_x, (int) dice_y, dice_size, dice_size, this);

					else {

						g.drawImage(img_exp[dice_num - 1], 520 - dice_size, 500 - dice_size, 150, 200, this);

						dice_moving = true; // �ֻ����� �����̴µ��� ĳ���Ͱ� �������� �ʰ� üũ�ϴ� ����

					}
				}

				play.draw(g); // ���� ĳ����

			}

		};

		this.add(jbt_buy); // ��ư �����ӿ� �߰�
		// this.add(jbt_sell);
		this.add(jbt_pass);

		jbt_buy.setBorderPainted(false);// Jbutton Borade(�ܰ���)�� �����ش�.
		jbt_buy.setContentAreaFilled(false); // jbutton ���뿵�� ���ֱ�
		// jbt_sell.setBorderPainted(false);
		// jbt_sell.setContentAreaFilled(false);
		jbt_pass.setBorderPainted(false);
		jbt_pass.setContentAreaFilled(false);
		jbt_dice.setBorderPainted(false);
		jbt_dice.setContentAreaFilled(false);

		jbt_buy.setBounds(650, 730, 75, 70); // ��ư ��ġ, ��ư������
		// jbt_sell.setBounds(360, 730, 120, 50); // 90, 50
		jbt_pass.setBounds(720, 730, 75, 70);
		jbt_dice.setBounds(500, 660, 130, 140);

		BlueGamePan.add(jbt_buy); // ��ư �����ӿ� �߰�
		// BlueGamePan.add(jbt_sell);
		BlueGamePan.add(jbt_pass);
		BlueGamePan.add(jbt_dice);
		BlueGamePan.setLayout(null);
		BlueGamePan.setPreferredSize(new Dimension(MyConst.GAMEPAN_W, MyConst.GAMEPAN_H));
		this.add(BlueGamePan);

		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Object evt_bt = e.getSource();// �̺�Ʈ�� �߻���Ų ��Ʈ��,�������ȴ��� �𸣱⶧���� obŸ������ �޴´�.

				if (evt_bt == jbt_buy) {

					nbs.buy();

					File file_buy = new File("music/����.wav");

					try {
						AudioInputStream stream = AudioSystem.getAudioInputStream(file_buy);
						Clip clip = AudioSystem.getClip();
						clip.open(stream);
						clip.start();
						// clip.loop(count);
					} catch (Exception w) {
						// TODO: handle exception
						w.printStackTrace();
					}

				}

				/*
				 * else if (evt_bt == jbt_sell) {
				 * 
				 * 
				 * // bs.sell(); // nbs.sell(); if (turn == false) //nbs.sell(); if (turn ==
				 * true) nbs.play2_sell();
				 * 
				 * File file_sell = new File("music/�Ǹ�.wav");
				 * 
				 * try { AudioInputStream stream = AudioSystem.getAudioInputStream(file_sell);
				 * Clip clip = AudioSystem.getClip(); clip.open(stream); clip.start(); //
				 * clip.loop(count); } catch (Exception w) { // TODO: handle exception
				 * w.printStackTrace(); }
				 * 
				 * 
				 * }
				 */

				else if (evt_bt == jbt_pass) {

					if (turn) {
						turn = false;

					} else {
						// t.start();
						turn = true;

					}

		/*			File file_pass = new File("music/���.wav");

					try {
						AudioInputStream stream = AudioSystem.getAudioInputStream(file_pass);
						Clip clip = AudioSystem.getClip();
						clip.open(stream);
						clip.start();
						// clip.loop(count);
					} catch (Exception w) {
						// TODO: handle exception
						w.printStackTrace();
					}*/

					// now_moving = true;
					// jbt_dice.setEnabled(true);
					play2_dice(); // AI �ڵ����� ����

				}

			}

		};

		/*
		 * t = new Timer(2000, new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * 
		 * if(turn = true) {
		 * 
		 * }
		 * 
		 * 
		 * //now_moving = true;
		 * 
		 * //new blue_marble(); // start ��ư Ŭ���� blue_marble ���� //setVisible(false); //
		 * Start Ŭ���� â�� ������� blue_marble Ŭ������ ���� // TODO Auto-generated method stub
		 * repaint(); } }); t.setRepeats(false);//Ÿ�̸Ӱ� �ݺ��ϴ��� ���θ� �����ϰų� �����ɴϴ�.
		 */

		jbt_buy.addActionListener(listener); // ��ư��ü�� �̺�Ʈ ������ ���
		// jbt_sell.addActionListener(listener);
		jbt_pass.addActionListener(listener);

		jbt_dice.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				File file_dice = new File("music/�ֻ���.wav");

				try {
					AudioInputStream stream = AudioSystem.getAudioInputStream(file_dice);
					Clip clip = AudioSystem.getClip();
					clip.open(stream);
					clip.start();

					FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
					gainControl.setValue(6.0f); // ���� ��Ʈ��

				} catch (Exception w) {
					// TODO: handle exception
					w.printStackTrace();
				}

				if (now_moving) { // now_moving���� üũ ĳ���� �̵����� ��� ��ư�� ������ �ʴ´�.

					dice_x = (MyConst.GAMEPAN_W / 2) - 200 - dice_size / 2; // ����x��ǥ
					dice_y = 500 - dice_size; // ����y��ǥ
					h = 1;
					g = 0.2;
					changh = 1;
					changh_buf = 0.1;

					dice_num = rand.nextInt(4) + 1; // �ֻ��� ���ڻ���
					// dice_num = 4;
					dice_effet_count = 0; // ����Ʈ ȿ�� �ʱ�ȭ
					dice_count = dice_num;
					click_check = true;
					now_moving = false;
					jbt_dice.setEnabled(false); // �����ϱ��� ��ư ��Ȱ��ȭ
					jbt_pass.setEnabled(false);
					jbt_buy.setEnabled(false);

					char_move = false; // ĳ���� �̵��� �������

					my_place_stack += dice_num;

					// �ѹٲ� ���Ƽ� �Ѿ�� �ʱ� ��ġ ����
					if (my_place_stack > 16) {
						my_place_stack -= 16;// 0

						play.price = play.price + 200000;// �ѹ��� ���� 20000�� �Ա�
						Blue_Marble.jlb_price.setText(Blue_Marble.play.price + "��");
						System.out.println(play.price);
						round++;
					}

					fail_check_stats = true;
					// ����üũ on���� �̰� now_moving�� char�� true�����϶� ������ üũ�Ѵ�.
					// �ֻ��� �������� ������� char_move true ����
					// �������� �������� now_moving false ����
					// ���� üũ�� fail_check = false�� ����

					dice_moving = false;

				}

			}
		});

	}

	public void play2_dice() {
		
		File file_dice = new File("music/�ֻ���.wav");

		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(file_dice);
			Clip clip = AudioSystem.getClip();
			clip.open(stream);
			clip.start();

			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(6.0f); // ���� ��Ʈ��

		} catch (Exception w) {
			// TODO: handle exception
			w.printStackTrace();
		}

		dice_x = (MyConst.GAMEPAN_W / 2) - 200 - dice_size / 2; // ����x��ǥ
		dice_y = 500 - dice_size; // ����y��ǥ
		h = 1;
		g = 0.2;
		changh = 1;
		changh_buf = 0.1;

		dice_num = rand.nextInt(4) + 1; // �ֻ��� ���ڻ���
		 //dice_num = 4;
		dice_effet_count = 0; // ����Ʈ ȿ�� �ʱ�ȭ
		dice_count = dice_num;

		jbt_dice.setEnabled(false); // �����ϱ��� ��ư ��Ȱ��ȭ
		jbt_pass.setEnabled(false);
		jbt_buy.setEnabled(false);

		char_move = false; // ĳ���� �̵��� �������

		play2_place_stack += dice_num;

		if (play2_place_stack > 16) {
			play2_place_stack -= 16;
			play2.price = play2.price + 200000;
			Blue_Marble.jlb_price_ai.setText(Blue_Marble.play2.price + "��");
			System.out.println(play2.price);
			round++;
		}
		fail_check_stats = true; // ����üũ on���� �̰� now_moving�� char�� true�����϶� ������ üũ�Ѵ�.
		dice_moving = false;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Contry_Class(); // ���� ��ü ����
		new Blue_Marble(); // ���� ��ü ����
		// new Blue_interFace();

	}

}
