package Question;

import java.util.Scanner;

public class Q_9 {
	public static int cacule(int n) {
		int result = 1;
		for(int i=n;i>=1;i--) {
			result *=i;
		}
		return result;
	}


	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("������ �Է��Ͻÿ�>>");
		int cal = s.nextInt();
		System.out.print(cal + "!= ");
		cal = cacule(cal);
		System.out.println(cal);
		
		
		
		

	}

}
