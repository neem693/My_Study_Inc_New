package mymain.serial;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;

import vo.PersonVo;

public class MyMain_0_��ü����ȭ {

	public static void main(String[] args) throws Exception {
		/*// TODO Auto-generated method stub
		PersonVo p1 = new PersonVo("�ϰ���",30,"���� ���α� ����3��");
		FileOutputStream fos = new FileOutputStream("person.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(p1);
		
		oos.close();
		fos.close();
*/
		//����ȭ ������ �о����
		InputStream fis = new FileInputStream("Person.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		PersonVo p2 = (PersonVo)ois.readObject();
		
		System.out.println(p2);
		
		ois.close();
		fis.close();
		
	}

}
