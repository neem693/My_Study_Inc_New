import java.util.Scanner;
class Qp3{
	public static void main(String [] args){
		Scanner s = new Scanner(System.in);
		System.out.print("Ű�� �Է��Ͻÿ�:");
		double ki = s.nextDouble();
		
		double inch,feet;
		inch=feet=0.0;
		
		inch = ki/2.54;
		feet = inch/12.0;
		inch = inch%12.0;
		
		
		System.out.printf("%.2fcm�� %.0f��Ʈ %.0f��ġ�̴�.",ki,Math.floor(inch),feet,Math.floor(inch));
	}
}

	