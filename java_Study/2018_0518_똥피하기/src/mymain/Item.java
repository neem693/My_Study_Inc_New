package mymain;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class  Item {
	
	
	//��ġ  + ũ��
	public Rectangle pos = new Rectangle();

	
	//���� �Ӽ�
	public abstract boolean move();
	public abstract void draw(Graphics g);
}
