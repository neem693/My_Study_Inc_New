package mymain;

import java.util.Scanner;

import myutil.MyDate2;
import myutil.MyInfo;

public class MyMain_MyInfo {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		MyInfo info = new MyInfo();
		
		int year,month;
		String yn = "";
		
		while(true) {
			System.out.print("����⵵>>");
			year = s.nextInt();

			info.setYear(year);
			int age = info.getAge()	;
			String tti = info.getTti();
			String ganzi = info.getZi();
			
			
			//������
			System.out.println("--------------------------");
			System.out.printf("�⵵ : %d(%s��)\n",year,ganzi);
			System.out.printf("���� : %d(��)\n",age+1);
			System.out.printf("��    : %s\n",tti);
			System.out.println("--------------------------");
			
			System.out.print("��(y/n):");
			yn = s.next();
			
			if(yn.equalsIgnoreCase("y")== false)break;

		}
	}
}
