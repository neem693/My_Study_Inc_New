package mymain;

public class MyMain_�迭1_0 {

	public static void main(String[] args) {
		int mr[];
		//�迭�� ������ ��� 1�����迭�� ��������
		mr = new int [4];
		
		mr[0] = 1;
		mr[1] = 2;
		mr[2] = 3;
		mr[3] = 4;
		
		System.out.println("---���---");
		System.out.printf("mr[%d] = %d\n",0,mr[0]);
		System.out.printf("mr[%d] = %d\n",1,mr[1]);
		System.out.printf("mr[%d] = %d\n",2,mr[2]);
		System.out.printf("mr[%d] = %d\n",3,mr[3]);
		System.out.println();
		for(int i =0;i<mr.length;i++)
			System.out.printf("mr[%d] = %d\n",i,mr[i]);
		
		

	}

}
