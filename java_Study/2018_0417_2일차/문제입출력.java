import java.util.Scanner;
class ���������{
	public static void main(String[] args){
	
		Scanner s= new Scanner(System.in);
		
		System.out.println("--[�Ż������Է�]--");
		System.out.print("�̸�:");
		String name=s.next();
		System.out.print("����:");
		int age = s.nextInt();
		s.nextLine();
		System.out.print("�ּ�:");
		String addr = s.nextLine();
		System.out.print("Ű:");
		double ki = s.nextDouble();
		
		s.nextLine();
		System.out.print("��ȭ:");
		String tel = s.nextLine();
		System.out.println("--[��³���]--");
		System.out.printf("�̸�: %s ��\n",name);
		System.out.printf("����: %d(��)\n",age);
		System.out.printf("�ּ�: %s\n",addr);
		System.out.printf("Ű: %.1f(cm)\n",ki);
		System.out.printf("��ȭ: %s\n",tel);
		
	}
}