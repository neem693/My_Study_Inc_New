package Question;

import java.io.IOException;
import java.util.Scanner;

public class Q_13 {
	// ���ĺ� �� �, ���ڰ� �, ȭ��Ʈ ���ڰ� �(\t,\r,\n, ' '(�����̽���)), Ư�� ��ȣ�� �
	public static void main(String[] args) throws IOException {
		
		Scanner s = new Scanner(System.in);
		
		int str;
		int alph = 0;
		int number = 0;
		int white = 0;
		int special = 0;
		System.out.println("�����͸� �Է��ϼ���. �������� [CTRL] + Z�� ��������");
		while (true) {
			str = System.in.read();
			if (str == -1) 
			break;
			System.out.printf("%c", str);

			if (str >= 65 && str <= 90 || str >= 97 && str <= 122)
				alph++;
			else if (str >= 48 && str <= 57)
				number++;
			else if (str >= 33 && str <= 47 || str >= 58 && str <= 64 || str >= 91 && str <= 96
					|| str >= 123 && str <= 126)
				special++;
			else if (str == 13 || str == 10 || str == 32 || str == 9)
				white++;
		}
		System.out.println("���ĺ� ����:" + alph);
		System.out.println("����: " + number);
		System.out.println("ȭ��Ʈ ����:" + white);
		System.out.println("Ư�� ��ȣ:" + special);

	}

}
