package myutil;

public class Pig extends Animal {

	public Pig() {
		super.name = "���";
		super.type = "����";
	}
	
	
	@Override
	public void cry() {
		// TODO Auto-generated method stub
		System.out.println("�ܲ�");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("�ܲ������� �Դ´�.");
	}

}
