package mymain;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class MyMain_3_��Ʈ��ũ_���ڽ�Ʈ������ {
	public static void main(String[] args) throws IOException {
		String str_url = "https://www.naver.com";
		URL url = new URL(str_url);

		// �Է�(byte)��Ʈ�� ȹ��
		InputStream is = url.openStream();

		InputStreamReader isr = new InputStreamReader(is,"utf-8");
		int count =0;

		while (true) {
			int ch = isr.read();
			if (ch == -1)
				break;
			System.out.print((char) ch);// ���⼭ println�� �ϸ� \n�� �߰� �ǰ����� �ϳ��� ��� �з�����.
			count ++;

		}
		System.out.println("�� ���� �� :" + count);
	}

}
