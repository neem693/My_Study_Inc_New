import java.util.Scanner;

class For_Ex4
{
	public static void main(String [] args){
		Scanner s = new Scanner(System.in);
		int dan;
		
		while( true ){
			
		System.out.print("��(����� -1 �� �Է��Ͻÿ�) :");
		dan = s.nextInt();
		if(dan == -1)
			break;
		if(dan  < 2 || dan > 9){
			System.out.println("2~9������ ���� �Է��ϼ���");
			continue;
		}

			for(int j= 1; j<=9; j++){
				System.out.printf("%d x %d = %d\n",dan,j,dan*j);
			
			}
			System.out.println();
		}
	}
}
			