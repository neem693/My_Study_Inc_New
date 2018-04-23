import java.util.Scanner;
class Q5p5{
	public static void main(String [] args){
		System.out.println("숫자를 입력하세요:");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int result =0;
		for(int i =0; i<=n;i+=3)
			result +=i;
		System.out.printf("%d",result);
	}
}