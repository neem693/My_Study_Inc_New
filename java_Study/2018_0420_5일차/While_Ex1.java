class While_Ex1{
	public static void main(String [] args)throws Exception{
		int ch,count=0;
		while(true)
		{
			ch = System.in.read();
			//Ű����� ���� ���� �Է¹���
			if(ch==-1)break;
			System.out.printf("%c",ch);
			
			count++;
			Thread.sleep(1000);
		}
		
		System.out.printf("�ݺ�Ƚ�� %d",count);
	}
}
			