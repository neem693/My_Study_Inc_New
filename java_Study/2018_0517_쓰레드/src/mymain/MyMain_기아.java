package mymain;

class MyRunnable2 implements Runnable {
	Object syncObj = new Object();

	int money = 10000;

	public void run() {
		String name = Thread.currentThread().getName();

		while (true) {

			synchronized (syncObj) {
				//���԰� ���ÿ�
				//�ڿ��� ������ �����ִ� �����带 �����.
				money -= 1000;
				if (money >= 1000)
					syncObj.notify();//�ڿ��� �־�� ���� �ִ� �����带 �����.

				System.out.printf("--[%s](�ܾ�: %d ���� --\n", name, money);

				try {
					syncObj.wait();
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}

public class MyMain_��� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyRunnable2 runnable = new MyRunnable2();
		Thread t1 = new Thread(runnable, "����");
		Thread t2 = new Thread(runnable, "�ƿ�");

		t1.start();
		t2.start();

	}

}
