package myutil;

public class Parent {
	
	protected int parent_money;
	
	public Parent() {
		//�����ϸ� ���������� super();�� �������
		super();
		parent_money = 1000;
		System.out.println("--Parent()--");
		
	}

	public Parent(int parent_money) {
		super();
		this.parent_money = parent_money;
		System.out.println("--Parent(int a)--");
		
	}
	
	

}
