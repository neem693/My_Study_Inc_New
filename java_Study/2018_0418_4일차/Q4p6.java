import java.util.GregorianCalendar;
import java.util.Scanner;
class Q4p6{
	public static void main(String [] args){
		GregorianCalendar gcl = new GregorianCalendar();
		int year = gcl.get(GregorianCalendar.YEAR);
		int birth_year,ganzi;
		String ganzi_name="";
		Scanner s = new Scanner(System.in);
		System.out.print("����⵵�� �Է��ϼ���:");
		birth_year = s.nextInt();
		ganzi = birth_year%12;
		
		switch(ganzi){
			case 0:
			ganzi_name = "��";
			break;
			case 1:
			ganzi_name = "�";
			break;
			case 2:
			ganzi_name = "��";
			break;
			case 3:
			ganzi_name = "��";
			break;
			case 4:
			ganzi_name = "�";
			break;
			case 5:
			ganzi_name = "��";
			break;
			case 6:
			ganzi_name = "��";
			break;
			case 7:
			ganzi_name = "��";
			break;
			case 8:
			ganzi_name = "��";
			break;
			case 9:
			ganzi_name = "��";
			break;
			case 10:
			ganzi_name = "��";
			break;
			case 11:
			ganzi_name = "ڱ";
			break;
		}
		System.out.println("����� ��� " + ganzi_name + "�Դϴ�.\n");
	}
}
			
			
			
			
			