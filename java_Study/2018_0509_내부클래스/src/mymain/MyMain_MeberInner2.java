package mymain;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

//  awt ->Ȯ�� -> swing
//  Frame         JFrame

public class MyMain_MeberInner2 extends JFrame {

	//������ �̺�Ʈ ó����ü
	class MyWindowAdapter extends WindowAdapter
	{
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
	}
	
	public MyMain_MeberInner2() {
		// TODO Auto-generated constructor stub
		super("�������� ������");

		// ��ġ + ũ������
		this.setBounds(200, 100, 400, 300);

		//�������
		this.setVisible(true);

		//�����ڵ�
		
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		WindowListener listener = new MyWindowAdapter();
		this.addWindowListener(listener);
		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyMain_MeberInner2();
	}

}