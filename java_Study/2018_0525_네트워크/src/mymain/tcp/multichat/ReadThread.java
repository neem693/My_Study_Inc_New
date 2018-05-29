package mymain.tcp.multichat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

//����Ÿ�� ���� �� �ִ� ���� ������

public class ReadThread extends Thread {

	MultiChatServer frame;
	// ��� �̰ͺ��ٴ� ����Ŭ������ ����.
	// �׷������� �� ReadThread Ŭ���� �ȿ� �ִ� �ڿ����� �����Ӱ� ����� �� �ֱ� �����̴�.
	Socket child;
	BufferedReader br;

	public ReadThread() {
		// TODO Auto-generated constructor stub
	}

	public ReadThread(MultiChatServer frame, Socket child) {
		super();
		this.frame = frame;
		this.child = child;

		try {
			br = new BufferedReader(new InputStreamReader(child.getInputStream()));
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
				String readStr = br.readLine();
				if (readStr == null)
					break;
				// ���� ������ close()�Ǿ��� ��
				frame.my_display_message(readStr);
				String[] data = readStr.split("#");
				
				
			

				switch (data[0]) {
				case "IN":
					
					synchronized (frame) {
						frame.userList.add(data[1]);
						frame.my_display_userlist();
						frame.my_send_userlist();
						frame.my_send_message_all(readStr + "\n");
					}
					break;
				case "CHAT" : 
					synchronized (frame) {
						String [] bad_string = {"����","���۳�","�ٺ�"};
						
						for(String bad : bad_string)
							readStr = readStr.replaceAll(bad, "***");
						frame.my_display_userlist();
						frame.my_send_userlist();
						frame.my_send_message_all(readStr + "\n");
					}
					break;
				
					

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				break;// Ŭ���� ���ϰ� �����
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
			
			String out_message = String.format("OUT#%s\n", out_user_name);
			frame.my_send_message_all(out_message);
		}

	}

}
