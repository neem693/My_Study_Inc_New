package mymain;

import java.util.Scanner;

import myutil.Mabangjin;

public class MyMain_������ {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int chasu;
		Mabangjin mabangjin = new Mabangjin();
		
		while(true) {
			System.out.print("����");
			chasu = s.nextInt();
			
			if(chasu%2==0) {
				System.out.println("Ȧ���� �Է��ϼ���");
				continue;
			}
			mabangjin.setChasu(chasu);
			mabangjin.display();
		}
	}
}
