package mymain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyMain_0_1_Ű�����Է� {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStream is = System.in;
		
		InputStreamReader isr = new InputStreamReader(is);
		

		
		
		
		
		System.out.println("������ �Է��ϼ���");
		
		
		while(true) 
		{
			int ch = isr.read();
			if(ch==-1)break;
			System.out.print((char)ch);//���⼭ println�� �ϸ� \n�� �߰� �ǰ����� �ϳ��� ��� �з�����.
			
		}

	}

}
