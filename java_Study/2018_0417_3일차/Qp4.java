import java.util.Scanner;
class Qp4{
	public static void main(String [] args){
		Scanner s = new Scanner(System.in);
		boolean exit= true;
		String command;
		do{
		System.out.print("��ġ�� �Է��Ϸ��� i, ��Ʈ�� �Է��Ϸ��� f�� �������� e�� �Է��Ͻÿ�: ");
		command = s.next();
		double feet,inch,ki;
		feet = inch = ki = 0.0;
		
		if(command.equals("f")){
			System.out.print("��Ʈ�� �Է��ϼ���:");
			feet = s.nextDouble();
			inch = feet*12.0;
			ki = inch*2.54;
			inch= inch%12.0;
			System.out.printf("%.0f��Ʈ %.0f��ġ�� %.2fcm�̴�.\n",Math.floor(feet),Math.floor(inch),ki);
		
			
		}
		else if(command.equals("i")){
			System.out.print("��ġ�� �Է��ϼ���:");
			inch = s.nextDouble();
			feet = inch/12.0;
			ki = inch*2.54;
			inch = inch%12.0;
			System.out.printf("%.0f��Ʈ %.0f��ġ�� %.2fcm�̴�.\n",Math.floor(feet),Math.floor(inch),ki);
			
			
		}
		else if(command.equals("e")){
			System.out.printf("�����ϰڽ��ϴ�");
			exit=false;
		}
		else System.out.printf("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է��Ͻ���.\n");
		}while(exit);
		
	}
}

	