class ���������{
	public static void main(String [] args){
		int x = 10;
		int y =3;
		int z;
		
		z = x+y;
		
		System.out.printf("%d + %d = %d\n",x,y,z);
		
		z = x-y;
		System.out.printf("%d - %d = %d\n",x,y,z);
		
		z= x*y;
		System.out.printf("%d - %d = %d\n",x,y,z);
		
		z= x/y;
		System.out.printf("%d / %d = %d\n",x,y,z);
		
		z= x%y;
		System.out.printf("%d %% %d = %d\n",x,y,z);
		//�� ������ ���� �Ǽ�/����
		System.out.println(10/3.0);
		System.out.println(10/(int)3.0);
		System.out.println((int)(10/3.0));
		System.out.println(10%3.0);
		
		
		
		int n = 11;
		
		//Ȧ����? ¦����?
		if(n%2 == 0)
			System.out.printf("%d�� ¦��\n",n);
		else
			System.out.printf("%d�� Ȧ��\n",n);
		
		//3�� �����?
		if(n%3 == 0)
			System.out.printf("%d�� 3�� ���",n);
		else
			System.out.printf("%d�� 3�� ����� �ƴϴ�.",n);
		
	}
}