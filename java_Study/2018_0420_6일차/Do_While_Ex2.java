import java.util.Scanner;
class Do_While_Ex2{
	public static void main(String [] args){
		Scanner s = new Scanner(System.in);
		int n;
		int y;
		
		String yn = "y";
		
		do{
			System.out.print("��:");
			n = s.nextInt();
			System.out.printf("�Էµ� �� %d\n",n);
			for(int i = 31;i>=0;i--){
				y=n>>i;
				System.out.printf("%d",y&0x1);
			}
			System.out.println();
			
			
			System.out.print("�� �ҷ�?(y/n):");
			yn = s.next();
			
		}while(yn.equals("y") || yn.equals( "Y"));
	}
}