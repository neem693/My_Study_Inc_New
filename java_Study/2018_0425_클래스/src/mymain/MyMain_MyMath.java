package mymain;

import myutil.MyMath;

public class MyMain_MyMath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=10,b =5;
		int res = MyMath.plus(a, b);
		
		System.out.printf("%d + %d = %d\n",a,b,res);
		
		res = Math.max(a, b);
		System.out.printf("%d�� %d �� ū ���� = %d\n",a,b,res);
		
		MyMath.sosu(14);
		MyMath.sosu(37);
		
		System.out.println(MyMath.max(5, 3423443, 37));
		

	}

}
