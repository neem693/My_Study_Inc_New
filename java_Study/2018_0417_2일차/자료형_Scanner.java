import java.util.Scanner;

class �ڷ���_Scanner
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String name;
		int age;
		double ki;
		System.out.print("�̸��� �Է��ϼ���:");
		name = scan.next();
		System.out.print("���̸� �Է��ϼ���:");
		age = scan.nextInt();
		System.out.print("���� Ű�� �Է��ϼ���: ");
		ki = scan.nextDouble();
		System.out.printf("����� ���̴� %d�� �̱���!!\n",age);
		System.out.printf("����� Ű�� %.1f �̱���!!\n",ki);
		
	}
}