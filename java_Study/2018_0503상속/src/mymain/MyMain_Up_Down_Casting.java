package mymain;

import java.util.ArrayList;

public class MyMain_Up_Down_Casting {

	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		list.add("���");
		list.add("����");
		list.add("����");
		
		//���� ���ͼ� ���ÿ��� down-casting �ؾ� �ȴ�.
		String fruit = (String)list.get(0);
		
		
		System.out.println("���� ������ ������/��� ����");
		
		list.remove(0);
		
		
		for(int i =0;i<list.size();i++) {
			String f = (String)list.get(i);
			System.out.println(f);
			System.out.println();
			System.out.println(list.get(i));
		}
		
		System.out.println();
		
		for(int i =0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		//�̷��� ���� String�� �ִ� toStirng()�޼ҵ尡 �������̵� �Ǽ� Object�� ����� �Ǵ��� String�� �ִ� toStirng()�޼ҵ��̴�.
		
		System.out.println();
		
		for(Object ob : list) {
			System.out.println((String)ob);
		}
		

	}

}
