package mymain;

public class MyMain_Final {
	
	class A
	{
		
		protected void sub1() {}
		
		
		void sub() {}
		boolean sub(int a) { return false;}
		final void sub_final() {
			
		}
		
		void sub2() {
			
		}
	}
	
	class AA extends A
	{
		//Method Override : �θ� Ŭ������ �޼ҵ带 �ٽ� �����ϴ� ��.
		//(�޼ҵ� ������)
		
		public void sub1() {
			
		}
		
		void sub() {
			
		}
		
		@Override
		void sub2() {
			super.sub2();
		}
		
		//void sub_final() {
			//��������.
			//�����ǰ� �Ұ��ϱ� �����̴�.
		//}
	}
	
	class AAA
	{
		//int plus(int a,int b) { return a+b;}
		double plus(int a,int b) { return a+b;}
		
	}
	
	
	
	
	
	
	
	
	
	//class MyString extends String{
		
	//}//String�� final Ŭ�����̱� ������ ����� ���� �ʴ´�.
	
	public final static double PI = 3.14;

	public static void main(String[] args) {
		
		final int MY_AGE = 20;
		//MY_AGE  = 21;
		
		
		

	}

}
