package mymain;
import java.util.ArrayList;

import myutil.MyArrayList;

public class MyMain_Generic_Test {

	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		list.add("��");
		list.add(new Integer(100));
		list.add(new Double(1.0));
		list.add(new Boolean(true));
		
		String str = (String)list.get(0);
		
		Integer nob =null;
		
		if(list.get(1) instanceof Integer)
			nob = (Integer)list.get(1);
		
		ArrayList<String> fruit_list = new ArrayList<String>();
		fruit_list.add("���");
		fruit_list.add("����");
		fruit_list.add("����");
		//fruit_list.addAll(new Integer(100));
		
		String fruit = fruit_list.get(0);
		
		
		ArrayList<Integer> month_list = new ArrayList<Integer>();
		month_list.add(31);
		month_list.add(28);
		month_list.add(31);
		
		//month_list.addAll("4��");
		
		MyArrayList<String> name_list = new MyArrayList<String>();
		name_list.add("�ϱ浿");
		//name_list.add(new Integer(100));
		
		
		
		MyArrayList<Integer> int_list = new MyArrayList<Integer>();
		
		
		

	}

}
