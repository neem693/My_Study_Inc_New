package mymain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class GamePan extends JPanel
{
	Font font = new Font("����ü",Font.BOLD,30);
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		g.setFont(font);
		g.drawString("������ �������...", 50, 100);
		g.setColor(Color.RED);
		g.drawString("������ �������...", 50-2, 100-2);
	}
}

public class MyMain_Anonymous2 extends JFrame {
	
	JPanel gamePan;

	public MyMain_Anonymous2() {
		super("�������� ������");
		
		gamePan = new GamePan();
		this.add(gamePan);//�����ϸ� �߾�
		//this.setLocation(200,100);
		this.setBounds(200, 100, 400, 300);
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyMain_Anonymous2();

	}

}