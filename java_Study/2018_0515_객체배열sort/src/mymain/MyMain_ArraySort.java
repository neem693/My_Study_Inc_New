package mymain;

import java.util.Arrays;

import vo.PersonComp;
import vo.PersonVo;

public class MyMain_ArraySort {

	public static void main(String[] args) {
		
		PersonVo[] p_array = {
				
				new PersonVo("�󰥵�",32,"���� ���α�"),
				new PersonVo("������",22,"���� ���α�"),
				new PersonVo("�ٰ���",52,"���� ���α�"),
				new PersonVo("������",42,"���� ���α�"),
				new PersonVo("������",28,"���� ���α�"),
				new PersonVo("�ٰ���",27,"���� ���α�"),
				new PersonVo("�ϰ���",39,"���� ���α�"),
				
		};
		
		System.out.println("---before sort---");
		for(PersonVo p : p_array)
			System.out.println(p);
		
		//Arrays.sort(p_array);//��ü�� ������ ������ �� ���� ������ ���⿡ ������ ����.
		
		//������ ������ ������ ��ü ����
		
		
		PersonComp com = new PersonComp();
		Arrays.sort(p_array, com);
		System.out.println("---after sort : �⺻�� �̸��� ��������---");
		for(PersonVo p : p_array)
			System.out.println(p);
		
		
		//���̼� ��������
		com.setSort_field(PersonComp.SORT_FIELD_AGE);
		
		Arrays.sort(p_array, com);
		
		System.out.println("---after sort : ���̼� �������� ---");
		for(PersonVo p : p_array)
			System.out.println(p);
		
		System.out.println("---after sort : �̸��� ��������---");
		com.setSort_field(PersonComp.SORT_FIELD_NAME);
		com.setSort_type(com.SORT_TYPE_DESC);
		Arrays.sort(p_array, com);
		
		for(PersonVo p : p_array)
			System.out.println(p);
		
		

	}

}
