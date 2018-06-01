package mymain.tcp.multichat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

//����Ÿ�� ���� �� �ִ� ���� ������

public class ReadThread extends Thread {

	MultiChatServer frame;
	// ��� �̰ͺ��ٴ� ����Ŭ������ ����.
	// �׷������� �� ReadThread Ŭ���� �ȿ� �ִ� �ڿ����� �����Ӱ� ����� �� �ֱ� �����̴�.
	Socket child;
	//BufferedReader br;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;

	public ReadThread() {
		// TODO Auto-generated constructor stub
	}

	public ReadThread(MultiChatServer frame, Socket child) {
		super();
		this.frame = frame;
		this.child = child;

		try {
			ois = new ObjectInputStream(child.getInputStream());
			oos = new ObjectOutputStream(child.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while (true) {
			try {
				//String readStr = br.readLine();
				//������ ����
				MyData data = (MyData)ois.readObject();
				if (data == null)
					break;
				// ���� ������ close()�Ǿ��� ��
				String display = String.format("[%d][%s][%s]", data.data_protocol,data.user_name,data.message);
				frame.my_display_message(display);
				//String[] data = readStr.split("#");
				
				
			

				switch (data.data_protocol) {
				case MyData.IN:
					
					synchronized (frame) {
						frame.userList.add(data.user_name);
						frame.my_display_userlist();
						frame.my_send_userlist();
						frame.my_send_message_all(data);
					}
					break;
				case MyData.CHAT : 
					synchronized (frame) {
						String [] bad_string = {"����","���۳�","�ٺ�"};
						
						for(String bad : bad_string)
							data.message = data.message.replaceAll(bad, "***");
						frame.my_display_userlist();
						frame.my_send_userlist();
						frame.my_send_message_all(data);
					}
					break;
				case MyData.GRIM :
					synchronized (frame) {
						frame.my_display_userlist();
						frame.my_send_userlist();
						frame.my_send_message_all(data);
					}
				
					

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				break;// Ŭ���� ���ϰ� �����
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// ��������(�����尡 �Ҹ�����)
		synchronized (frame) {
			int index = frame.socketList.indexOf(this);
			// ���� ��ü�� soketList�� ���° ��ü��?
			frame.socketList.remove(this);

			// ����� �� ����
			frame.my_display_user_count();

			String out_user_name = frame.userList.get(index);

			// ��������ó��
			frame.userList.remove(index);

			frame.my_display_userlist();
			
			frame.my_send_userlist();
			
			//String out_message = String.format("OUT#%s\n", out_user_name);
			
			MyData data = new MyData();
			data.data_protocol = MyData.OUT;
			data.user_name = out_user_name;
			
			frame.my_send_message_all(data);
		}

	}

}
