package mymain;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyMain_1_2_ȭ���Է�_���� {

	public static void main(String[] args) throws Exception {

		InputStream is = new FileInputStream("src/mymain/MyMain_1_0_ȭ���Է�.java");
		
		InputStreamReader isr = new InputStreamReader(is);

		while (true) {
			int ch = isr.read();
			if (ch == -1)
				break;
			System.out.print((char) ch);// ���⼭ println�� �ϸ� \n�� �߰� �ǰ����� �ϳ��� ��� �з�����.

		}

	}

}
