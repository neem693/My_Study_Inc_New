package Question;

import java.util.Scanner;

public class Q_12 {
	

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("�Ǽ��� �Է��ϼ���>>");
		double r = s.nextDouble();
		double fr= r;
		System.out.println(r);

		System.out.print("������ �Է��ϼ���>>");
		int n = s.nextInt();
		
		for(int i =0; i <n-1;i++) {
			r*=fr;
		
		}
		System.out.println(r);
		
		

	}

}
