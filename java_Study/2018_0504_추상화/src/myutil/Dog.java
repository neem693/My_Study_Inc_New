package myutil;

public class Dog extends Animal{
	
	
	
	public Dog() {
		super.name = "�ٽǸ�";
		super.type = "��";
	}
	
	@Override
	public void cry() {
		System.out.println("�п�");
		
	}
	@Override
	public void eat() {
		System.out.println("����Ḧ �Դ´�.");
	}

}
