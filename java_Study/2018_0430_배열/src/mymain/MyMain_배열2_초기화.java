package mymain;

import myutil.MyArrays;

public class MyMain_�迭2_�ʱ�ȭ {

	public static void main(String[] args) {
		
		int [][] mm = new int [][] {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12}
		};
		
		MyArrays.display_array2(mm);
		
		int [][] t_block = {
				{1,1,1},
				{0,1,0},
				{0,1,0}
		};
		int [][] l_block = {
				{1,0,0},
				{1,0,0},
				{1,1,1}
		};
		
		MyArrays.display_array2_block(l_block);
		MyArrays.display_array2_block(t_block);
		

	}
	

}
