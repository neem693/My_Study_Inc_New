package mymain;

import java.awt.BorderLayout;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyMain_Win2 extends JFrame {
	
	public MyMain_Win2() {
		
		super("ó�� ���� ������");
		super.setTitle("ó�� ���� ������");
		
		Button bt_east = new Button("East Button");
		Button bt_west = new Button("West Button");
		Button bt_south = new Button("South Button");
		Button bt_north = new Button("North Button");
		JButton bt_center = new JButton("Center Button");
		
		
		//���� �������� ��ư �߰�
		super.add(bt_east, BorderLayout.EAST);
		super.add(bt_west, "West");
		super.add(bt_south, "South");
		super.add(bt_north, "North");
		super.add(bt_center, "Center");
		
		
		
		
		//��ġ����
		super.setLocation(100,100);
		
		//ũ������
		super.setSize(400,300);
		
		//ȭ�鿡 �����ֱ�
		super.setVisible(true);
	
	}
	
	

	public static void main(String[] args) {
		
		new MyMain_Win2();

	}

}
