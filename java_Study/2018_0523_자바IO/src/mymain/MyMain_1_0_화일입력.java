package mymain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MyMain_1_0_ȭ���Է� {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStream is = new FileInputStream("src/mymain/MyMain_1_0_ȭ���Է�.java");
		
		while(true) 
		{
			int ch = is.read();
			if(ch==-1)break;
			System.out.print((char)ch);//���⼭ println�� �ϸ� \n�� �߰� �ǰ����� �ϳ��� ��� �з�����.
			
		}

	}

}
