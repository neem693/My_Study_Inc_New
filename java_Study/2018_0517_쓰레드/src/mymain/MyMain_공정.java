package mymain;

class MyRunnable implements Runnable {
	Object syncObj = new Object();

	public void run() {
		String name = Thread.currentThread().getName();

		while (true) {

			synchronized (syncObj) {

				syncObj.notify();//

				System.out.printf("--[%s] ���� --\n", name);

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

public class MyMain_���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyRunnable runnable = new MyRunnable();
		Thread t1 = new Thread(runnable, "����");
		Thread t2 = new Thread(runnable, "�ƿ�");

		t1.start();
		t2.start();

	}

}
