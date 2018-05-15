package mymain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vo.PersonVo;

public class MyMain_MapTest2 {

	public static void main(String[] args) {
		
		List<PersonVo> p_list = new ArrayList<PersonVo>();
		for(int i =1;i<=100;i++) {
			String name = String.format("�浿%d", i);
			int age = 20 + i %10;
			String addr = String.format("����� ���α� ����%d��", 1 + i%3);
			PersonVo p = new PersonVo(name,age,addr);
			p_list.add(p);
		}
		
		System.out.printf("���� �ο��� : %d\n", p_list.size());
		
		//�浿 100�� ������ �˻� : ArrayList �����˻�
		int search_count =0;
		for(PersonVo p : p_list) {
			search_count++;
			if(p.getName().equals("�浿100")) {
				System.out.println(p);
				break;
			}
		}
		System.out.printf("�˻�Ƚ��: %d\n",search_count);
		Map<String,PersonVo> personMap = new HashMap<String,PersonVo>();
		for(int i =1;i<=100;i++) {
			String name = String.format("�浿%d", i);
			int age = 20 + i %10;
			String addr = String.format("����� ���α� ����%d��", 1 + i%3);
			PersonVo p = new PersonVo(name,age,addr);
			personMap.put(name, p);
		}
		PersonVo pp = personMap.get("�浿100");
		System.out.println("�˻�Ƚ�� �ѹ�");

		System.out.println(pp);

	}

}
