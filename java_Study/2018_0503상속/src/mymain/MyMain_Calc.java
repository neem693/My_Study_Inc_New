package mymain;

import myutil.AdvanceCalc;

public class MyMain_Calc {

	public static void main(String[] args) {
		
		int a=10,b=5,result;
		
		AdvanceCalc ac = new AdvanceCalc();
		result = ac.plus(a, b);
		System.out.printf("%d + %d = %d\n",a,b,result);
		
		result = ac.hap(a);
		System.out.printf("1 ~ %d±îÁö ÇÕ: %d\n",a,result);
		
		result = ac.pow(a, b);
		System.out.printf("%d's %d½Â	 : %d\n",a,b,result);
		
	}

}
