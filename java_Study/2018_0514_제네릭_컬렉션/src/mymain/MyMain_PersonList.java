package mymain;

import java.util.ArrayList;
import java.util.List;

import vo.PersonVo;

public class MyMain_PersonList {

	public static void main(String[] args) {
		PersonVo p = new PersonVo("�ϰ���",20,"���� ���ȱ�");
		System.out.println(p.toString());
		List<PersonVo> p_list = new ArrayList<PersonVo>();
		
		PersonVo p1 = new  PersonVo("�̱浿", 20, "���� ������");
		
		p_list.add(p);
		p_list.add(p1);
		p_list.add(new PersonVo("��浿", 21, "���� ���α�"));
		p_list.add(new PersonVo("��浿", 22, "���� �����"));
		p_list.add(new PersonVo("���浿", 23, "���� ���빮��"));
		
		System.out.println("---÷�ڸ� �̿��� ���---");
		
		
		for(int i =0;i<p_list.size();i++) {
			PersonVo pp = p_list.get(i);
			System.out.println(pp);
			//toString�� �ڵ����� ȣ�� ��
		}
		System.out.println("---���� ������ �̿��� ��� ---");
		for(PersonVo pp : p_list)
			System.out.println(pp);
		

	}

}
