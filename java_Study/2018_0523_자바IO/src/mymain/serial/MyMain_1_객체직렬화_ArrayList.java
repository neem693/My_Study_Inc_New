package mymain.serial;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import vo.PersonVo;

public class MyMain_1_��ü����ȭ_ArrayList {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		/*List<PersonVo> p_list = new ArrayList<PersonVo>();
		
		for(int i =1;i<=100;i++) {
			String name = String.format("�浿_%03d", i);
			int age = 20 + (i%20);
			String addr = String.format("���� ���α� ���� %d��", (i%3)+1);
			
			p_list.add(new PersonVo(name,age,addr));
		}
		OutputStream fis = new FileOutputStream("person_list.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fis);
		
		oos.writeObject(p_list);
		
		//���� ���� ���� �ݱ�
		oos.close();
		fis.close();
		*/
		
		
		List<PersonVo> p_list1 = null;
		
		String name;
		int age;
		String addr;
		
		InputStream pis = new FileInputStream("person_list.dat");
		ObjectInputStream ios = new ObjectInputStream(pis);
		
		p_list1 = (ArrayList)ios.readObject();
		
		for(int i =0;i<100;i++) {
			System.out.println(p_list1.get(i));
			
			
			
		}
		
		
		
		
		
		
		
		

	}

}
