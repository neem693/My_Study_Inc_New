
package Question;

import java.util.Scanner;

public class Q_4 {

	public static void main(String[] args) {
		int a,b;
		String str;
		char result;
		System.out.print("�� ������ *,-,+,/ �� �ϳ��� �����ڸ� �Է��ϼ���. >>");
		Scanner s = new Scanner(System.in);
		a= s.nextInt();
		b= s.nextInt();
		str= s.next();
		if(str.length()>1) {
			System.out.print("�߸��Է��ϼ̽��ϴ�.");
			return;
		}
		
		if(str.equals("*"))
			System.out.println(a*b);
		else if(str.equals("-"))
			System.out.println(a-b);
		else if(str.equals("+"))
			System.out.println(a+b);
		else if(str.equals("/"))
			System.out.println(a/b);

		
		
		
		
		
	}

}
