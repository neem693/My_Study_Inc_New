package mymain;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyMain_1_3_ȭ���Է�_���� {

	public static void main(String[] args) throws Exception {

		InputStream is = new FileInputStream("src/mymain/MyMain_1_0_ȭ���Է�.java");
		
		InputStreamReader isr = new InputStreamReader(is);
		
		BufferedReader br = new BufferedReader(isr);

		while (true) {
			String str = br.readLine();
			if (str == null)
				break;
			System.out.println(str);

		}

	}

}
