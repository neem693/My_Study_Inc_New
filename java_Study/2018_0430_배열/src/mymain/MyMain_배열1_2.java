package mymain;

import myutil.MyArrays;

public class MyMain_�迭1_2 {

	public static void main(String[] args) {
		
		//int [] mr = new int [] {10,20,30,40,50};
		int [] mr = {20,30,40,10,50};

		MyArrays.display_array(mr);
		
		String [] tti_array = {"������","��","��","����","��","��","ȣ����","�䳢","��","��","��","����"};
		String [] gan_array = {"��","��","��","��","��","��","��","��","��","��"};
		String [] ji_array = {"��","��","��","��","��","��","��","��","��","��","��","��"};
		
		
		MyArrays.display_array(gan_array);
		
		int year = 1980;
		
		
		int tti_index = 1980%12;
		String tti = tti_array[tti_index];
		System.out.println(tti);
		String ganji = String.format("%s%s��",gan_array[year%10],ji_array[year%12]);
		System.out.printf("%d�⵵(%s)\n",year,ganji);
		
		//�⺻�迭������ ���ο� �迭��ü�� �ʱ�ȭ ���·� ������ �Ʒ����
		System.out.println("---before sort---");
		MyArrays.display_array(mr);
		

		
		System.out.println("---after sort(asc)---");
		MyArrays.sort_asc(mr);
		MyArrays.display_array(mr);
		
		
		System.out.println("---after sort(desc)---");
		MyArrays.sort_desc(mr);
		MyArrays.display_array(mr);
	
	}
}
