class Q_star6{
	public static void main(String [] args){
		int h=0, t = 4;
		for(int i =0;i<5;i++){//���η� �� ���
			
			for(int k =0;k<5;k++)//�� �ٲٱ� 
			{
				if(k==h || k==t)
					System.out.print("-");
				else 
					System.out.print("*");
				
			}
			System.out.println();
			h++;
			t--;
		}
	}
}
			