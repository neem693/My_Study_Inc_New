class Q_star5{
	public static void main(String [] args){
		int h=4;
		for(int i =0;i<5;i++){//���η� �� ���
			
			for(int k =0;k<5;k++)//�� �ٲٱ� 
			{
				if(k>=h)
					System.out.print("*");
				else
					System.out.print("-");
			}
			h--;
			System.out.println();
		}
	}
}
			