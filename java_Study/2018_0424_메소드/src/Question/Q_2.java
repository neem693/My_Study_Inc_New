package Question;

import java.util.Scanner;

public class Q_2 {

	public static void main(String[] args) {
		Scanner s  = new Scanner(System.in);
		System.out.print("�� ���� ������ �Է��ϼ���. >>");
		int o = s.nextInt();
		int t = s.nextInt();
		int th = s.nextInt();
		System.out.println("�� : " + o + " " + t + " " + th );
		System.out.print("�� ���� ���� �߿��� ���� ���� �� : ");
		System.out.println(Math.min(o,Math.min(t, th)));
		
		
		

	}

}
