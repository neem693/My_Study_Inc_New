import java.util.Scanner;
class Qp2{
	public static void main(String [] args){
		Scanner s = new Scanner(System.in);
		System.out.print("�ð��ʸ� �Է��ϼ��� :");
		int ts = s.nextInt(); //�ð���
		int os = ts; //�������� �ð���
		int m,h,cs;
		m=h=0;		//��,�ð�,compare �ð���
		cs=3600;
		if(ts>cs){
			h= ts/cs;
			ts = ts%cs;
		}
		cs = 60;
		if(ts>cs){
			m= ts/cs;
			ts = ts%cs;
		}
		System.out.printf("%d�ʴ� %d�ð� %d�� %d���̴�",os,h,m,ts);
		
	}
}

	