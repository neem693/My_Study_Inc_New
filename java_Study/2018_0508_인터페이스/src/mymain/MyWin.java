package mymain;

import java.awt.event.WindowListener;

import javax.swing.JFrame;

import inter.MyWindowEventListener;

public class MyWin extends JFrame {
	public MyWin() {
		super("�������� ������");
		//this.setLocation(200,100);
		this.setBounds(200, 100, 400, 300);
		this.setVisible(true);

		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		WindowListener listener = new MyWindowEventListener();
		this.addWindowListener(listener);
		//���� �����쿡�� �߻��Ǵ� ��� �̺�Ʈ listener���� ������.
		
	}

	public static void main(String[] args) {
		new MyWin();

	}
}
