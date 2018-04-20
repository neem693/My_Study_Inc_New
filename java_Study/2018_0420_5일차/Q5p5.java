import java.util.Scanner;
class Q5p5{
	public static void main(String [] args){
		System.out.println("숫자를 입력하세요:");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int result =0;
		for(int i =1; i<=n; i++)
			if(i%3==0)
				result += i;
		System.out.println(result);

	}
}