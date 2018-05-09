package mymain;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyMain_Menu extends JFrame implements ActionListener {

	public void init_menu() {
		JMenuBar menuBar = new JMenuBar();

		JMenu menu_color = new JMenu("����");
		JMenu menu_help = new JMenu("����");

		menuBar.add(menu_color);
		menuBar.add(menu_help);

		JMenuItem itemR = new JMenuItem("����");
		JMenuItem itemG = new JMenuItem("�ʷ�");
		JMenuItem itemB = new JMenuItem("�Ķ�");
		JMenuItem itemExit = new JMenuItem("����");

		menu_color.add(itemR);
		menu_color.add(itemG);
		menu_color.add(itemB);
		menu_color.addSeparator();
		menu_color.add(itemExit);

		this.setJMenuBar(menuBar);

		// �޴�(������)�̺�Ʈ ó�� + ��ư �̺�Ʈ
		// ���Ǹ����� �������̽� + Ÿ�̸��̺�Ʈ
		// ���⼭ this�� ActionListener�� ���Ѵ�.
		// �� ���Ǹ����ʶ� ���� ������� �ߴ�.
		itemR.addActionListener(this);
		itemG.addActionListener(this);
		itemB.addActionListener(this);
		itemExit.addActionListener(this);
	}

	public MyMain_Menu() {
		super("�������� ������");

		// �޴�
		init_menu();

		JButton bt1 = new JButton("����");
		this.add(bt1, "East");
		bt1.addActionListener(this);

		// this.setLocation(200,100);
		this.setBounds(200, 100, 400, 300);
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyMain_Menu();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
		// System.out.println(new Date(e.getWhen()));

		// ActionEvent e : Event Source����(�̺�Ʈ�� �߻���Ų ��ü����)
		Object evt_ob = e.getSource();
		// �̺�Ʈ�� �߻���Ų ��Ʈ���� ����
		String cmd = e.getActionCommand();
		// System.out.println(cmd);

		if (evt_ob instanceof JMenuItem) {
			System.out.printf("�޴����� ���õ� : %s\n",cmd);
			if(cmd.equals("����"))
				getContentPane().setBackground(Color.RED);
			else if(cmd.equals("�ʷ�"))
				getContentPane().setBackground(Color.GREEN);
			else if(cmd.equals("�Ķ�"))
				getContentPane().setBackground(Color.BLUE);
		}
		else if(evt_ob instanceof JButton) {
			System.out.printf("��ư���� ���õ� : %s\n",cmd);
			((Component)evt_ob).setBackground(Color.RED);
			//�ٿ��ɽ���
		}

	}

}