import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Set_Contry {
	
	
	String contry_name;
	int price;
	int unique_num;
	boolean city_buy_check;
	
	
	//���� �̹��� ũ���� �簢�� ��ǥ ���� (ũ�� 200�� 200)
	
	public Rectangle pos = new Rectangle();	
	
	
	public abstract void draw(Graphics g);

	


}
/*
���� ���� �ӽ� 1000~16000������



*/