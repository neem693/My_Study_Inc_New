package mymain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyMain_0_2_Ű�����Է� {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStream is = System.in;
		
		InputStreamReader isr = new InputStreamReader(is);
		
		BufferedReader br = new BufferedReader(isr);
		

		
		
		
		
		System.out.println("������ �Է��ϼ���");
		
		int count = 0;
		while(true) 
		{
			String str = br.readLine();
			if(str == null)break;
			System.out.println(str);
			count++;
		}
		System.out.println(count);

	}

}
