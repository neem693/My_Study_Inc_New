package mymain;

public class MyMain_����ó�� {

	public static void main(String[] args) {
		
		int a =10,b=1,res=0;
		
		try {
			//���ڵ�
			if(b==0) throw new ArithmeticException("0���� ������ ����� ����!?");
			res = a/b;
			res = res + 1;
			
			String name = null;
			if(name ==null) throw new NullPointerException("��ü�� ���µ� �� ����Ϸ��� �ϳ�?");
			int len = name.length();
			
			Exception e = new ArithmeticException();
		}catch(ArithmeticException e) {
			//�����ڵ�
			//e.printStackTrace();
		}catch(NullPointerException e) {
			//e.printStackTrace();
		}catch(Exception e) {
			
		}

	}

}
