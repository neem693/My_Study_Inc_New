package mymain.tcp.echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	
	public static void main(String[] args) throws IOException {
		//1.�������ϻ���(port�Ҵ�, backlog-���ť����)
		ServerSocket server = new ServerSocket(7000);
		
		System.out.println("---����������...---");
		
		//2.���Ӵ��
		
		while(true) {
			//1.���Ӵ��->2.��û����->3.�ڼ��ϻ���->4.������ϰ�����
			Socket child =  server.accept();
			
			//�����������(IP)�� ȹ��
			InetAddress ia_you = child.getInetAddress();
			System.out.printf("[%s]���� ����\n",ia_you.getHostAddress());
			
			//����½�Ʈ��
			
			InputStream is = child.getInputStream();
			OutputStream os = child.getOutputStream();
			
			//2.���۸޽��� ����
			byte [] buff = new byte[100];
			// len : ����ũ��
			// buff : ������ ����
			int len = is.read(buff);
			
			String read_message = new String(buff,0,len);
			System.out.printf("[%s]���� ����: %s\n",  ia_you.getHostAddress(),read_message);
			
			
			//3.�������� ���Ÿ޽����� ������
			os.write(read_message.getBytes());
			
			
		}
	}

}
