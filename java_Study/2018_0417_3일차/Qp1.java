import java.util.Scanner;
class Qp1{

	public static void main (String [] args){
		Scanner s = new Scanner(System.in);
		int p_mny;//��ǰ �ܰ�
		int input_m;//������ ��
		int items;//����
		int output_m; //�Ž�����
		int comm;//�ΰ���
		int cost=0; //�Ѻ��
		
		System.out.print("������ ��:");
		input_m = s.nextInt();
		System.out.print("���� ��ī �ܰ�:");
		p_mny = s.nextInt();
		System.out.print("����:");
		items = s.nextInt();
		
		comm = (int)((p_mny * items) *0.1);
		System.out.printf("�ΰ���: %d\n" , cost= comm);
		System.out.printf("��ǰ�Ѿ�: %d\n", cost +=  items*p_mny);
		System.out.printf("�Ž�����: %d\n", input_m - cost);
		
		
		
	
	
		
	}

}
