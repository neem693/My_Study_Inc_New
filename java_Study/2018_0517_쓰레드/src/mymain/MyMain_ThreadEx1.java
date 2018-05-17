package mymain;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyMain_ThreadEx1 extends JFrame {

	long time, start_time, diff_time;
	boolean stop = false;

	int mode = 0;
	int melle = 0;
	int sec = 0;
	int minute = 0;
	int hour = 0;
	int color = 0;

	int stop_hour, stop_minute, stop_second, stop_mili_sec;
	Font font = new Font("����ü", Font.BOLD, 20);
	JLabel jlb_date;
	JLabel jlb_time;
	JLabel jlb_stop_watch;

	JButton jb_start;
	JButton jb_stop;
	JButton jb_init;
	Thread stopwatch;

	public MyMain_ThreadEx1() {
		super("�������� ������");

		// ���� ����ǰ� �ִ� ������ Ȯ��
		// System.out.println(Thread.currentThread().getName());
		// static�̶� �׳� ���� �ȴ�.
		JPanel p = new JPanel(new GridLayout(4, 1));
		jlb_date = new JLabel("��¥", JLabel.CENTER);
		jlb_time = new JLabel("�ð�", JLabel.CENTER);
		jlb_stop_watch = new JLabel("��ž��ġ", JLabel.CENTER);

		JPanel p_button = new JPanel();

		jb_start = new JButton("����");
		jb_stop = new JButton("����");
		jb_init = new JButton("�ʱ�ȭ");
		p_button.add(jb_start);
		p_button.add(jb_stop);
		p_button.add(jb_init);

		jlb_date.setFont(font);
		jlb_time.setFont(font);

		p.add(jlb_date);
		p.add(jlb_time);
		p.add(jlb_stop_watch);
		p.add(p_button);

		this.add(p, "Center");

		init_date_thread();
		init_time_thread();
		init_stopwatch_tread();
		init_button_event();

		// this.setLocation(200,100);
		// this.pack();
		this.setBounds(200, 100, 400, 200);
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void init_button_event() {
		// TODO Auto-generated method stub
		ActionListener listner = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object ob = e.getSource();

				if (ob == jb_start) {
					start_time = System.currentTimeMillis();

				}
				if (ob == jb_stop) {
					stopwatch.suspend();

				}
				if (ob == jb_init) {
					stop_hour = stop_minute = stop_second = stop_mili_sec = 0;
					jlb_stop_watch.setText("00:00:00.000");

				}

			}

		};
		jb_start.addActionListener(listner);
		jb_stop.addActionListener(listner);
		jb_init.addActionListener(listner);

	}

	private void init_stopwatch_tread() {
		// TODO Auto-generated method stub
		class StopRun implements Runnable {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				start_time = (int) System.currentTimeMillis();
				System.out.println(start_time);
				// diff_time = 0;

				// System.out.println(melle_remain);
				// System.out.println(sec_remain);
				// System.out.println(minute_remain);
				// System.out.println(hour_remain);
				while (true) {
					long end_time = System.currentTimeMillis();
					int gap_mili_sec = (int) (end_time - start_time);

					stop_mili_sec = gap_mili_sec % 1000;

					int time = gap_mili_sec / 1000;

					melle = time % 1000;
					sec = time / 1000 % 60;
					minute = time / 1000 / 60 % 60;
					hour = time / 1000 / 60 / 60 % 24;

					String str = String.format("%02d : %02d : %02d : %03d", hour, minute, sec, melle);
					jlb_stop_watch.setText(str);

					try {
						Thread.sleep(1);

					}

					// System.out.println(melle);

					catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}

		StopRun sr = new StopRun();
		stopwatch = new Thread(sr);
	}

	private void init_time_thread() {
		// TODO Auto-generated method stub
		class TimeRunnable implements Runnable {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					// System.out.println(Thread.currentThread().getName());
					try {

						Calendar c = Calendar.getInstance();
						int h = c.get(Calendar.HOUR_OF_DAY);
						int m = c.get(Calendar.MINUTE);
						int s = c.get(Calendar.SECOND);
						int milli = c.get(Calendar.MILLISECOND);

						System.out.println();

						String str_time = String.format("%02d : %02d : %02d : %03d ", h, m, s, milli);

						jlb_time.setText(str_time);
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
		TimeRunnable tr = new TimeRunnable();

		Thread t = new Thread(tr);

		t.start();

	}

	private void init_date_thread() {
		// TODO Auto-generated method stub
		class DateThread extends Thread {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				while (true) {

					try {
						// System.out.println("������� ������ " + Thread.currentThread().getName());
						Calendar c = Calendar.getInstance();
						int year = c.get(Calendar.YEAR);
						int month = c.get(Calendar.MONTH) + 1;
						int day = c.get(Calendar.DATE);

						String str_date = String.format("%d�� %02d�� %02d��", year, month, day);

						jlb_date.setForeground(color == 0 ? Color.RED : Color.BLACK);
						jlb_date.setText(str_date);

						if (color == 0)
							color = 1;
						else
							color = 0;

						this.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
		Thread t = new DateThread();
		t.start();
		// t.run();

	}

	public static void main(String[] args) {
		new MyMain_ThreadEx1();

	}

}