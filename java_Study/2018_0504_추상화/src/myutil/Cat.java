package myutil;

public class Cat extends Animal{
	
	public Cat() {
		super.name = "����";
		super.type = "�����";
	}
	
	@Override
	public void cry() {
		// TODO Auto-generated method stub
		System.out.println("�߿� �߿�");
	}
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("�㸦 �Դ´�.");
	}

}
