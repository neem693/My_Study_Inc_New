package mymain;

import java.awt.Button;
import java.awt.Frame;

public class MyMain_Win1 {
	

	public static void main(String[] args) {
		
		//awt(Abstract Window Toolkit) : ������ ������ �߻�ȭ
		//����������
		
		Frame f = new Frame();
		//��ġ����
		f.setLocation(100, 100);
		//ũ������
		f.setSize(400,300);
		//ȭ�鿡 ��������
		f.setVisible(true);
		
		
		Button bt = new Button("Ŭ���ϼ���");
		Button bt1 = new Button("���ʿ� �ִ� ��ư");
		
		f.add(bt,"South");
		f.add(bt1,"East");
		//ȭ�鿡 ��������

	}

}
