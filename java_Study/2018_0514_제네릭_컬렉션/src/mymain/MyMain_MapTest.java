package mymain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import vo.PersonVo;

public class MyMain_MapTest {

	public static void main(String[] args) {
		
		Map<Integer,String> telMap = new HashMap<Integer,String>();
		
		telMap.put(1,"010-111-1234");
		telMap.put(2,"010-222-1234");
		telMap.put(3,"010-333-1234");
		
		int short_num =1;
		String tel = telMap.get(short_num);
		
		telMap.put(1, "010-999-9999");//�ٽ� ����
		
		System.out.printf("�����ȣ %d : %s\n", short_num,tel);
		
		Set<Integer> keySet = telMap.keySet();
		
		System.out.println("---key ����---");
		for(int key : keySet)
			System.out.println(key);
		System.out.println("������ : " + telMap.size());
		System.out.println("---Value ����---");
		for(int i =1; i<=telMap.size();i++)
			System.out.println(telMap.get(i));
		
		

	}

}
