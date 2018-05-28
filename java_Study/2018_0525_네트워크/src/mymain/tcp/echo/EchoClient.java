package mymain.tcp.echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		String server_ip = "inca001";//������ ����
		String local_ip = "localhost";
		
		
		//���� ����
		Socket client = new Socket(server_ip,7000);
		
		//1-1:����� ��Ʈ��
		InputStream is = client.getInputStream();//����
		OutputStream os = client.getOutputStream();//����
		
		//2.�޽��� ����
		String message = "�޾Ƹ�";
		//String->byte [] ����
		os.write(message.getBytes());
		
		//3.���۸޽��� ����
		byte [] buff = new byte[100];
		// len : ����ũ��
		// buff : ������ ����
		int len = is.read(buff);
		
		String read_message = new String(buff,0,len);
		System.out.printf("�ǵ��ƿ� �޽���: %s\n", read_message);
		

	}

}
