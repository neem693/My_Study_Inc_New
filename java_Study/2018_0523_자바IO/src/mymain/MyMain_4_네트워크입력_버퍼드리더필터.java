package mymain;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class MyMain_4_��Ʈ��ũ�Է�_���۵帮������ {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String str_url = "https://www.naver.com";
		URL url = new URL(str_url);

		// �Է�(byte)��Ʈ�� ȹ��
		InputStream is = url.openStream();

		InputStreamReader isr = new InputStreamReader(is,"utf-8");
		BufferedReader br = new BufferedReader(isr);
		int count =0;

		while (true) {
			String str = br.readLine();
			if (str == null)
				break;
			System.out.println(str);// ���⼭ println�� �ϸ� \n�� �߰� �ǰ����� �ϳ��� ��� �з�����.
			count ++;

		}
		System.out.println("�ݺ� Ƚ��:" + count);

	}

}
