class �Ϲݳ�������{
	public static void main(String[] args){
		System.out.printf("true && true = %b\n",true && true);
		System.out.printf("true && false = %b\n",true && false);
		System.out.printf("false && true = %b\n",false && true);
		System.out.printf("false && false = %b\n",false && false);
		
		System.out.printf("true || true = %b\n",true || true);
		System.out.printf("true || false = %b\n",true || false);
		System.out.printf("false|| true = %b\n",false || true);
		System.out.printf("false|| false = %b\n",false || false);
		int x =1;
		int y =2;
		boolean z;
		z = (--x > 0) && (++y>1);
		//x = 0 y = 3 z = false
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		System.out.println("z = " + z);
		
		x=1;
		y=2;
		z = (++x > 0) || (++y>1);
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		System.out.println("z = " + z);
		
		
		
		int n = 6;
		
		// 2�� 3�� �����?
		if((n%2==0)&&(n%3==0))
			System.out.printf("%d�� 2,3�� ���\n",n);
		else
			System.out.println("���ǿ� ���� �ʽ��ϴ�.");
		
		int year_one = 2000;
		int year;
		//��������
		//1)400����� ���� (year%400 == 0)
		//or
		//2)4�� ��� --100�� ����� �ƴ� �� (year%4= 0) && (year %100 != 0)
		
		for(int i = 0; i <38; i++){
			year = year_one +i;
		if((year % 400 ==0) || ((year%4 ==0)&&(year%100 != 100)))
			System.out.printf("%d�� �����Դϴ�.\n",year);
		else
			System.out.printf("%d�� ������ �ƴմϴ�.\n",year);
		}
		
		
		

	
	
	}
}