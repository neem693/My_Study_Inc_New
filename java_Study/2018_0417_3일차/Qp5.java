import java.util.Scanner;
class Qp5{
	public static void main(String [] args){
		Scanner s = new Scanner(System.in);
		System.out.print("������ �Է��Ͻÿ�:");
		double c = s.nextDouble();
		double cf = ((9.0/5.0)*c) + 32.0;
		System.out.printf("%.1f(C)�� ȭ���� ��ȯ�ϸ� %.1f(F)�� �ȴ�.\n",c,cf);
		
		System.out.print("ȭ���� �Է��Ͻÿ�:");
		double f = s.nextDouble();
		double fc = (5.0/9.0)*(f-32.0);
		System.out.printf("%.1f(F)�� ȭ���� ��ȯ�ϸ� %.1f(C)�� �ȴ�.",f,fc);
		
		
	}
}