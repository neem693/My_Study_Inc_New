package mymain;

import myutil.MyArrays;

public class MyMain_2�������� {

	public static void main(String[] args) {
		int [][] mm  =new int [5][5];
		
		MyArrays.set_array2(mm);
		System.out.println("--[����]--");
		MyArrays.display_array2(mm);
		mm=MyArrays.rotate_right_90(mm);
		System.out.println("--[�� 90�� ���� ��]--");
		MyArrays.display_array2(mm);
		
		MyArrays.set_array2(mm);
		System.out.println("--[����]--");
		MyArrays.display_array2(mm);
		mm=MyArrays.rotate_left_90(mm);
		System.out.println("--[�� 90�� ���� ��]--");
		MyArrays.display_array2(mm);
		
		MyArrays.set_array2(mm);
		System.out.println("--[����]--");
		MyArrays.display_array2(mm);
		mm=MyArrays.flip_left_right(mm);
		System.out.println("--[�������� ������]--");
		MyArrays.display_array2(mm);
		
		MyArrays.set_array2(mm); 
		System.out.println("--[����]--");
		MyArrays.display_array2(mm);
		mm=MyArrays.flip_up_down(mm);
		System.out.println("--[������ �Ʒ��� ���� ��]--");
		MyArrays.display_array2(mm);
		
		MyArrays.set_array2(mm); 
		System.out.println("--[����]--");
		MyArrays.display_array2(mm);
		mm=MyArrays.flip_diagonal2(mm);
		System.out.println("--[���� �밢�� ���� ��]--");
		MyArrays.display_array2(mm);
		
		MyArrays.set_array2(mm); 
		System.out.println("--[����]--");
		MyArrays.display_array2(mm);
		mm=MyArrays.flip_diagonal1(mm);
		System.out.println("--[������ �밢������ ���� ��]--");
		MyArrays.display_array2(mm);
		
	}

}
