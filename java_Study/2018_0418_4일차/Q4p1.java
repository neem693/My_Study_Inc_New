import java.util.Scanner;

class Q4p1{
	public static void main(String [] args){
		int kor,eng,mat,tot;
		double avg;
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("����, ����, ���� 3�������� ���� �Է¹�������:");
		kor = s.nextInt();
		eng = s.nextInt();
		mat = s.nextInt();
		tot = kor+eng+mat;
		avg = (double)(tot)/3.0;
		System.out.printf("������ ������ �����ϴ�. %d\n ����� ������ �����ϴ�. %.2f\n",tot,avg);
		
		
		
	}
}