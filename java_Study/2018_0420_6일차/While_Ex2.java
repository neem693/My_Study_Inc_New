import java.io.FileReader;

class While_Ex2
{
	public static void main(String [] args)throws Exception
	
	//FileNotFoundException�� �߻��� �ٴ� �� �ش� ������ �������� ��� �ҷ�? ��� ����� �Ͱ� ����.
	{
		int count=0;
		int alpha_upper_count = 0;//�빮�� ���� ���庯��
		int alpha_lower_count = 0;//�ҹ��� ���� ���庯��
		int number_count = 0; //���� ���� ���庯��
		int hangul_count=0;
		FileReader fr = new FileReader("While_Ex2.java");
		
		while(true)
		{
			int readChar = fr.read();
			if(readChar == -1)break;
			System.out.printf("%c",readChar);
			count++;
			if(readChar >=65 && readChar <=90)
				alpha_upper_count++;
			if(readChar>=61 && readChar <= 122)
				alpha_lower_count++;
			if(readChar>=48 && readChar <= 57)
				number_count++;
			if((readChar & 0x8000) == 0x8000)
				hangul_count++;
		}
		
		fr.close(); 
		System.out.println();
		//å�� ���������� �����Դ� �Ͱ� ���� �̰͵� ���� �ش� �ϴ� �ڿ��� �ݳ��ؾ� �ϴ� ������ ���ľ� �Ѵ�. ���� ������ �� ���� close�� �ؾ� �Ѵ�. �׷��� ������ �ٸ� ����� �ش� ���ҽ��� ������� ���Ѵ�.
		System.out.printf("�� ���� �� : %d\n",count);
		System.out.printf("�� �ҹ��� �� : %d\n",alpha_lower_count);
		System.out.printf("�� �빮�� �� : %d\n",alpha_upper_count);
		System.out.printf("�� ���� �� : %d\n",number_count);
		System.out.printf("�� �ѱ� �� : %d\n",hangul_count);
		

		
	}
}