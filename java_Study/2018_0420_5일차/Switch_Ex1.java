import java.util.Scanner;
class Switch_Ex1
{
	public static void main(String[] args){
		String yoil;
		String job= "";
		boolean ending =true;
		Scanner scan = new Scanner(System.in);
	
		while(ending){	
			System.out.print("����:");
			yoil = scan.next();
		
			switch(yoil)
			{
				case "��" : job ="�ֱ���ȸ"; break;
				case "ȭ" : job ="����"; break;
				case "��" : job ="�"; break;
				case "��" : job ="��ȭ"; break;
				case "��" : job ="���Ա�"; break;
				case "��" :
				case "��" : job ="���ڱ�";break;
				case "��" : ending = false;
			}
			System.out.printf("[%s]������ [%s]\n",yoil,job);
		}
	}
}