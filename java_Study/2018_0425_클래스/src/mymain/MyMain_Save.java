package mymain;

import myutil.Save;

public class MyMain_Save {

	public static void main(String[] args) {
		Save.save_rate = 0.1;
		
		Save s1  = new Save("�ϱ浿", 1000000);
		Save s2  = new Save("�ϱ浿", 2000000);
		Save s3  = new Save("�ϱ浿", 3000000);
		
		System.out.println("---���� : 0.1 ---");
		s1.display();
		s2.display();
		s3.display();
		
		Save.save_rate = 0.2;
		System.out.println("---���� : 0.2 ---");
		s1.display();
		s2.display();
		s3.display();
		

	}

}
