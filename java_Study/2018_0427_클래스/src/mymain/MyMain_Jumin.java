package mymain;

import java.util.Scanner;

import myutil.Jumin;

public class MyMain_Jumin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Jumin jumin = new Jumin();
		Scanner scan = new Scanner(System.in);
		//Ű����κ��� �Է¹޴´�
		String jumin_no="801212-1234560";
		
		
		while(true)
		{
			System.out.print("�ֹι�ȣ(xxxxxx-xxxxxxx):");
			jumin_no = scan.next();
			
			jumin.setJumin_no(jumin_no);
			
			int year = jumin.getYear();//����⵵ 
			int age  = jumin.getAge();//����
			String tti= jumin.getTti();//��
			String season = jumin.getSeason();//����
			String local = jumin.getLocal();//����
			String ganji = jumin.getZi();//����
			String sex = jumin.getSex();//����
			
			System.out.println("---[���]---");
			System.out.printf("����⵵:%d(%s��) ����� %d�� �̳׿�\n", year,ganji,age);
			System.out.printf("�������:%s\n", season);
			System.out.printf("�������:%s\n",local);
			System.out.printf("����Ǽ���: %s\n",sex);
			System.out.printf("����Ƕ�: %s\n",tti);
			
			
			System.out.print("��� �Ұſ���? y/n>>");
			String again = scan.next();
			if(again.equalsIgnoreCase("y"))
				continue;
			else
				break;
			
			
			
			
		
		}
		scan.close();
		
		
		

	}

}
