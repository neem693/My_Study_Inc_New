package mymain.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import vo.PersonVo3;

public class MyMain_2_��ü����ȭ_Array {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		PersonVo3 [] p_array= {
				new PersonVo3("�ϱ浿",20,"���� ���α� ����3��"),
				new PersonVo3("�̱浿",21,"���� ���α� ����2��"),
				new PersonVo3("��浿",22,"���� ���α� ����1��"),
		};
		
		
		//����(����ȭ) : p_array.dat//
		OutputStream ops = new FileOutputStream("p_array.dat");
		ObjectOutputStream oos = new ObjectOutputStream(ops);
		
		oos.writeObject(p_array);
		
		
		oos.close();
		ops.close();
		
		//����(������ȭ)//
		
		
		InputStream ins = new FileInputStream("p_array.dat");
		ObjectInputStream ois = new ObjectInputStream(ins);
		
//		if(ois.readObject() instanceof PersonVo3[])
//			System.out.println("����.");
		
		PersonVo3 [] p_array1 = (PersonVo3[])ois.readObject();
		
		for(PersonVo3 array : p_array1)
			System.out.println(array);
		
		ois.close();
		ins.close();
		
		
		
		
		
		
		
		
		
		

	}

}
