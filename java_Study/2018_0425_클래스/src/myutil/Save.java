package myutil;

public class Save {

	String name; // �����ڸ�
	int money;// �����
	public static double save_rate;// ����

	public Save(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}

	public void display() {
		System.out.printf("%-10s%-10d%-5.1f%-10d\n", this.name, this.money, save_rate, (int)(this.money * save_rate));
	}

}
