package mymain.output;

import java.io.IOException;
import java.io.OutputStream;

public class MyMain_�������� {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		OutputStream os = System.out;
		
		String msg = "�ȳ��ϼ���\n";
		
		byte [] msg_bytes = msg.getBytes();
		
		os.write(msg_bytes);
		
		double pi = 3.14;
		
		String double_str = String.format("%.2f\n", pi);
		os.write(double_str.getBytes());
		
		

	}

}
