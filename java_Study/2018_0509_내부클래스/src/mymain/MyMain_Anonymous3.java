package mymain;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyMain_Anonymous3 extends JFrame {
	JPanel gamePan;
	public MyMain_Anonymous3() {
		super("�������� ������");
		
		//������ �߾ӿ� �ִ´�.
		
		gamePan = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				g.drawString("���� ��...", 10, 50);
			}
		};
		this.add(gamePan,"Center");
		
		this.setBounds(200, 100, 400, 300);
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyMain_Anonymous3();

	}

}