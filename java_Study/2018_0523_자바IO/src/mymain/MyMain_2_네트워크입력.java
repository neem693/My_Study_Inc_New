package mymain;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MyMain_2_��Ʈ��ũ�Է� {

	public static void main(String[] args) throws MalformedURLException,IOException {
		// TODO Auto-generated method stub
		
		String str_url = "https://www.naver.com";
		URL url = new URL(str_url);
		
		//�Է�(byte)��Ʈ�� ȹ��
		InputStream is = url.openStream();
		
		while(true) 
		{
			int ch = is.read();
			if(ch==-1)break;
			System.out.print((char)ch);//���⼭ println�� �ϸ� \n�� �߰� �ǰ����� �ϳ��� ��� �з�����.
			
		}
		


	}

}
