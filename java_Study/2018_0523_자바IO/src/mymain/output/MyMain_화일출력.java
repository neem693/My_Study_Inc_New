package mymain.output;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class MyMain_ȭ����� {

	public static void main(String[] args) throws IOException {

		OutputStream os = new FileOutputStream("test.txt");

		String msg = "�ȳ��ϼ���\n";
		os.write(msg.getBytes());
		double pi = 3.14;

		String double_str = String.format("%.2f\n", pi);
		os.write(double_str.getBytes());
		
		//System.out.println("-----------------------");
		
		PrintStream ps = new PrintStream(os);
		
		ps.println("--------------------");
		os.write("--------------------\n".getBytes());
		
		String name = "ȫ�浿";
		
		int age = 20;
		double ki = 180.5;
		
		ps.printf("�̸�:%s\n", name);
		ps.printf("����%d\n", age);
		ps.printf("Ű:%.1f(cm)\n",ki);
		
		ps.flush();//���ۺ���
		
		ps.close();
		os.close();
		
		
	
		

	}

}
