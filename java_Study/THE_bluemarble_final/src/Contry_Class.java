import java.awt.Image;

import javax.swing.ImageIcon;

public class Contry_Class {
	//���� ��ü ����	
	static Contry start = new Contry("start", 0, 800, 1000, true,1); // �̸� ,��ġx,��ġy,���� ����,���Ű��ɿ���,������ȣ
	static Contry ���� = new Contry("����", 200, 800, 70000, true,2);
	static Contry ������ = new Contry("�븣����", 400, 800, 100000, true,3);
	static Contry ���þ� = new Contry("���þ�", 600, 800, 120000, true,4);
	static Contry �縶�Ͼ� = new Contry("�縶�Ͼ�", 800, 800, 150000, true,5);
	static Contry ������ = new Contry("������", 800, 600, 170000, true,6);
	static Contry �ʶ��� = new Contry("�ʶ���", 800, 400, 210000, true,7);
	static Contry ������ = new Contry("������", 800, 200, 240000, true,8);
	static Contry ���ε� = new Contry("���ε�", 800, 0, -200000, true,9);
	static Contry ���Ϸ��� = new Contry("���Ϸ���", 600, 0, 260000, true,10);
	static Contry ��Ż���� = new Contry("��Ż����", 400, 0, 290000, true,11);
	static Contry ������ = new Contry("������", 200, 0, 310000, true,12);
	static Contry �߱� = new Contry("�߱�", 0, 0, 330000, true,13);
	static Contry �Ϻ� = new Contry("�Ϻ�", 0, 200, 350000, true,14);
	static Contry �밡�� = new Contry("�밡��", 0, 400, 380000, true,15);
	static Contry ���ѹα� = new Contry("���ѹα�", 0, 600, 500000, true,16);
	
	
	//�̹��� ���� ����
	static Image ����char = new ImageIcon("character/player10.gif").getImage();
	static Image play2 = new ImageIcon("character/player20.gif").getImage();
	
	static Image slime_myturn = new ImageIcon("character/player11.gif").getImage();
	static Image play2_turn = new ImageIcon("character/player21.gif").getImage();
	
	
	 
	
	
	static Image back_img, �밡��img, startimg, ������img, �Ϻ�img, ��Ż����img, ���Ϸ���img, ���ѹα�img, ������img, ���ε�img, �ʶ���img, ������img, �縶�Ͼ�img,
			����img, ������img, �߱�img, ���þ�img,bulding,play2_bulding;
	
	
	static {
		bulding =  new ImageIcon("contry_img/����.png").getImage();
		play2_bulding =  new ImageIcon("contry_img/play2_����.png").getImage();
		back_img = new ImageIcon("contry_img/blue_back_ground.png").getImage();
		������img = new ImageIcon("contry_img/�븣����.png").getImage();
		startimg = new ImageIcon("contry_img/����1.png").getImage();
		���ѹα�img = new ImageIcon("contry_img/���ѹα�.png").getImage();
		�밡��img = new ImageIcon("contry_img/�밡��.png").getImage();
		������img = new ImageIcon("contry_img/������.png").getImage();
		�Ϻ�img = new ImageIcon("contry_img/�Ϻ�.png").getImage();
		��Ż����img = new ImageIcon("contry_img/��Ż����.png").getImage();
		���Ϸ���img = new ImageIcon("contry_img/���Ϸ���.png").getImage();
		������img = new ImageIcon("contry_img/������.png").getImage();
		���ε�img = new ImageIcon("contry_img/���ε�.png").getImage();
		�ʶ���img = new ImageIcon("contry_img/�ʶ���.png").getImage();
		������img = new ImageIcon("contry_img/������.png").getImage();
		�縶�Ͼ�img = new ImageIcon("contry_img/�縶�Ͼ�.png").getImage();
		����img = new ImageIcon("contry_img/����.png").getImage();
		�߱�img = new ImageIcon("contry_img/�߱�.png").getImage();
		���þ�img = new ImageIcon("contry_img/���þ�.png").getImage();

	}


static	int[] answer = {0,1,1,0,0,1,0,1,0,1,1,0}; 
	
	static String [] str= {"O" , "X"};
	
	static	String [] str_quiz = {  "�����̴� ������ �ִ�", 
									"����� ���ڽ��� �������̴�",
									"������ ���� ������ �ִ�",
									"����⵵ ��ħ�� �Ѵ�",
									"������ ������ 3�� �̴�",
									"�������� ������ 2�� �̴�",
									"���迡�� ���� �� ���� ���ϰ��̴�",
									"�ϱ��� ���غ��� �� ���",
									"�ʰ��� ������ �Ƹ���Ƽ����",
									"�üҴ� �츮���̴�",
									"���ָ� ���� ���ø� �谡 ���´�",
									"TV �Ҹ��� ũ���ϸ� �������� �ణ �� ���´�"}; //[0~11]








}
