package mymain;

import java.util.ArrayList;

public class MyMain_Wrapper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int n = 10;
		Integer nOb = new Integer(n);
		//�̰� �ڽ��̶�� �Ѵ�.
		Integer nOb1 = n;
		
		int n1 = nOb.intValue();
		//�� �ڽ��̶�� �Ѵ�.
		int n2 = nOb;
		
		float f =nOb; //nOb.floatValue()
		double d = nOb; //nOb.doubleValue()
		//�ΰ��� ��ڽ��̴�.
		
		
		ArrayList list = new ArrayList();
		list.add(10);
		list.add(new Integer(10));
		

	}

}
