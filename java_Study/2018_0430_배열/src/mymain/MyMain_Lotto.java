package mymain;

import java.util.Arrays;
import java.util.Scanner;

import myutil.Lotto;

public class MyMain_Lotto {

	public static void main(String[] args) {
		int check;
		int [] user_number = new int[6];
		Lotto lotto = new Lotto();
		Scanner s = new Scanner(System.in);
		
		
		lotto.make_win_number();
		
		
		END:
		while(true)
		{
			System.out.println("��ȣ 6���� �Է�");
			AGAIN: for(int i =0; i<6;i++) {
				check = s.nextInt();
				for(int j =0; j<i;j++) {
					if(check == user_number[j]) {
						System.out.println("��ȣ�� �ߺ��˴ϴ�. �ٸ� ������ �ٽ� �Է����ּ���.");
						i--;
						continue AGAIN;
					}
				}
				
				
				if(!(check>=0 && check <=45)) {
					System.out.println("ġ������ ������ �߻��ϼ̽��ϴ�. ���߿� �ٽ� �õ����ּ���.");
					break END;
				}
				else user_number[i] = check;
			}
			lotto.setUser_number(user_number);
			lotto.display();

		}
		

	}

}
