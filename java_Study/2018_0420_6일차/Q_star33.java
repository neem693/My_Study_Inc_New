import java.util.Scanner;
class Q_star33{
	public static void main(String [] args){
		Scanner s = new Scanner(System.in);
		int chasu;
		String yn = "y";
		
		while(true)
		{
			System.out.print("����:");
			chasu = s.nextInt();
			if(chasu%2==0){
				System.out.println("Ȧ���� �Է��ϼ���");
				continue;
			}
			
			//ó��
			int center = chasu/2;
			
			for(int i=0;i<chasu;i++)
			{
				for(int k =0;k<chasu;k++)
				{
					if(i<=center){
						if(k>=center-i && k<=center + i)
							System.out.print("*");
						else
							System.out.print("-");
					}else{
						int a = chasu -i -1;
						if(k>=center -a && k<=center+a)
							System.out.print("*");
						else
							System.out.print("-");
						
					}
				}
				System.out.println();
			}
			
			//�� �ҷ�?
			
			System.out.print("�� �ҷ�?(y/n)");
			yn = s.next();
			
			if((yn.equals("y")||yn.equals("Y"))==false)
				break;
			
			
		}
		System.out.println("--End--");
	}
}
		
		