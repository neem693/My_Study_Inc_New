import java.util.Scanner;
class Q5p4{
	public static void main(String [] args){
		System.out.println("���ڸ� �Է��ϼ���:");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int result =0;
		for(int i = 1; i<=n;i++)
			if(i%2==1)
				result += i;
		System.out.println(result);
	}
}