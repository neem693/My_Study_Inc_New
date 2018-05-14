package mymain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class MyMain_Set_Test {

	public static void main(String[] args) {
		
		Random rand = new Random();
		
		//�������̽�(���޴���)			���輭
		Set<Integer> set_lotto = new HashSet<Integer>();
		//Set<Integer> set_lotto = new TreeSet<Integer>();
		
		
		int n =6;
		while(n>0)
		{
			int su = rand.nextInt(45) + 1; //1~45
			//�ߺ��� ����� �����ʱ� ������
			//���� ���� ���� add������
			if(set_lotto.add(su)==false)continue;
			n--;
		}
		System.out.println(set_lotto.toString());
		
		System.out.println("----���� loop ----");
		for(Integer nob : set_lotto)
			System.out.println(nob);//toString �̿�
		
		System.out.println("---Iterator �̿�----");
		Iterator<Integer> it = set_lotto.iterator(); 
		
		while(it.hasNext()) {
			Integer nob2 = it.next();//���簪 ��������
			System.out.println(nob2);
		}
		
		

	}

}
