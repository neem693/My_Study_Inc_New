class �ڷ���
{
	public static void main(String [] args)
	{
		
		//�����ڷ���
		//���: true or false
		//����: boolean bYes;
		//��¼���: %b or %B
		
		
		//��¹��
		//1.��¸� :
		// Ŭ������.��ü��,�޼ҵ�()
		//System.out.print("��");
		//2.��� + ����(line next)
		System.out.println("��");
		System.out.printf("%b  %B \n", true,true);
		
		int a =5;
		int b =3;
		boolean bYes = a>b;
		
		System.out.printf("%d>%d �� ����� %b �Դϴ�\n",a,b,bYes);
		
		bYes = (a==b);
		System.out.printf("%d==%d�� ����� %b �Դϴ�.\n",a,b,bYes);
		

		
		/*
		byte b = 100;
		
		System.out.printf("[%32s]\n",Integer.toBinaryString(100));
		System.out.printf("[%32s]\n",Integer.toBinaryString(-100));
		
		float f = 1.234567890123456789f;
		double d = 1.234567890123456789;
		
		System.out.printf("%.20f\n",f);
		System.out.printf("%.20f\n",d);
		*/
	}
}