package mymain;

import java.util.Calendar;
import java.util.Scanner;

import myutil.MyCalendar;

public class MyMain_�޷� {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Calendar c = Calendar.getInstance();
		//Calendar�� �̷��� �ۿ� ������ ���Ѵ�.
		
		int year = 2018;
		int month = 5;
		
		//���� ���ϴ� ��¥�� ����
		
		c.set(year, month-1,1);
		//0���̽� ���� �ϱ� �޷� -1�� �ؾ� �Ѵ�.
		
		int yoil = c.get(Calendar.DAY_OF_WEEK);
		System.out.printf("%d-%d-%d ���� : %d\n",year,month,1,yoil);
		
		MyCalendar mc = new MyCalendar();
		
		while(true) {
			System.out.print("��  �� : ");
			year = s.nextInt();
			month = s.nextInt();
			
			if(year>=9999 || month >12) {
				System.out.println("ġ������ ������ �߻��Ͽ����ϴ�. �����ϰڽ��ϴ�.");
				break;
			}
			
			mc.setDate(year, month);
			mc.display();
		}

	}

}
