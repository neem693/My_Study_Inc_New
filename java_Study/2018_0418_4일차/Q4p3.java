import java.util.Scanner;
class Q4p3{
	public static void main(String [] args){
		double radius, pi = Math.PI;
		Scanner s = new Scanner(System.in);
		System.out.print("���� �������� �Է��Ͻʽÿ�: ");
		radius = s.nextDouble();
		
		double cife = 2.0*pi*radius; //���ѷ�
		double area = radius*radius*pi;// ����
		double vol = 4.0/3.0 * pi *(radius*radius*radius) ;//����
		
		System.out.printf("�ش� ���� �ѷ��� %.2f\n�ش���� ������ %.2f\n�ش� ���� ���Ǵ� %.2f",cife,area,vol);
		
		
	}
}