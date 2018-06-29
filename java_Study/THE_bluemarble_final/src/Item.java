

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Item {

	// ��ġ + ũ�� // �� ��ġ(X,Y), ũ�� ����
	public Rectangle pos = new Rectangle();
	//�ൿ �Ӽ�,�������� �����̴� �Ӽ�
	// �߻� �޼ҵ带 �ϳ��� ���Ե��ִ� Ŭ������ �߻� Ŭ������ ����մϴ�.
	
	public abstract boolean move();
	public abstract void draw(Graphics g);
}
