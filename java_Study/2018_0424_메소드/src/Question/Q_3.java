package Question;

public class Q_3 {

	public static void main(String[] args)throws Exception {
		
		System.out.print("���� �� ���� �Է��ϼ���>>");
		int r = System.in.read();
		if(r>='A' && r<='Z' || r>='a' && r<='z')
			System.out.println("�� ���ڴ� ���ĺ��̴�.");

		else if(r>='0' && r<='9')
			System.out.println("�� ���ڴ� �����̴�.");
		else
			System.out.println("�� ���ڴ� Ư�������̴�.");
		
		
		
		
		

	}

}
