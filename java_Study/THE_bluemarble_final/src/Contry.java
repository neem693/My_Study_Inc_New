import java.awt.Graphics;

public class Contry extends Set_Contry {

	public Contry() {
	};

	public Contry(String name, int x, int y, int money, Boolean check, int unin) { // ��ü ������ �����ڸ� ���� ������ ��ġ �� �̸�����

		pos.width = 200; // ũ�� ����
		pos.height = 200;
		pos.x = x;
		pos.y = y;
		contry_name = name; // ���� �̸� ����
		price = money; // ���� �ʱ� ������ ��ü�� �����ϸ鼭 �����ڷ� �ʱ�ȭ
		city_buy_check = check;
		unique_num = unin; // �� ������ ������ȣ�� �ʱ�ȭ�� ���´�.

	}

	public void draw(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

		g.drawImage(Contry_Class.bulding, pos.x, pos.y + y, null);

	}

	public void draw(Graphics g, int x, int y, int j) {
		// TODO Auto-generated method stub

		g.drawImage(Contry_Class.play2_bulding, pos.x, pos.y + y, null);

	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

	}

	public void draw(Graphics g, String name) {
		// TODO Auto-generated method stub

		/*
		 * if(name=="����") {g.drawImage(blue_marble.�밡��img,pos.x,pos.y,null);
		 * System.out.println( "�̹���" ); }
		 */

		switch (name) {

		case "start":
			g.drawImage(Contry_Class.startimg, pos.x, pos.y, null);
			break;
		case "����":
			g.drawImage(Contry_Class.����img, pos.x, pos.y, null);
			break;
		case "������":
			g.drawImage(Contry_Class.������img, pos.x, pos.y, null);
			break;
		case "������":
			g.drawImage(Contry_Class.������img, pos.x, pos.y, null);
			break;
		case "�Ϻ�":
			g.drawImage(Contry_Class.�Ϻ�img, pos.x, pos.y, null);
			break;
		case "��Ż����":
			g.drawImage(Contry_Class.��Ż����img, pos.x, pos.y, null);
			break;
		case "���Ϸ���":
			g.drawImage(Contry_Class.���Ϸ���img, pos.x, pos.y, null);
			break;
		case "������":
			g.drawImage(Contry_Class.������img, pos.x, pos.y, null);
			break;
		case "�ʶ���":
			g.drawImage(Contry_Class.�ʶ���img, pos.x, pos.y, null);
			break;
		case "�밡��":
			g.drawImage(Contry_Class.�밡��img, pos.x, pos.y, null);
			break;
		case "�縶�Ͼ�":
			g.drawImage(Contry_Class.�縶�Ͼ�img, pos.x, pos.y, null);
			break;
		case "���ѹα�":
			g.drawImage(Contry_Class.���ѹα�img, pos.x, pos.y, null);
			break;
		case "�븣����":
			g.drawImage(Contry_Class.������img, pos.x, pos.y, null);
			break;
		case "���ε�":
			g.drawImage(Contry_Class.���ε�img, pos.x, pos.y, null);
			break;
		case "�߱�":
			g.drawImage(Contry_Class.�߱�img, pos.x, pos.y, null);
			break;
		case "���þ�":
			g.drawImage(Contry_Class.���þ�img, pos.x, pos.y, null);
			break;

		default:
			System.out.println("����� �־�� �߸����.");

		}

	}

}
