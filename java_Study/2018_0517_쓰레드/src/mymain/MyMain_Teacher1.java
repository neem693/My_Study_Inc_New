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

//  awt ->Ȯ�� -> swing
//  Frame         JFrame

public class MyMain_Teacher1 extends JFrame {

	JLabel jlb_date;
	JLabel jlb_time;
	JLabel jlb_stop_watch;
    Font font = new Font("����ü",Font.BOLD,20);
    
    Thread t_stop_watch;
    int stop_hour,stop_minute,stop_second,stop_mili_sec;
    long start_time;
	
	public MyMain_Teacher1() {
		// TODO Auto-generated constructor stub
		super("������ Ex1");

		//���� ����ǰ� �ִ� ������ Ȯ��
		//System.out.println(Thread.currentThread().getName());
		
		
		JPanel p = new JPanel(new GridLayout(4, 1));
		jlb_date = new JLabel("��¥",JLabel.CENTER);
		jlb_time = new JLabel("�ð�",JLabel.CENTER);
		jlb_stop_watch = new JLabel("00:00:00 .000",JLabel.CENTER);
		//��Ʈ����
		jlb_date.setFont(font);
		jlb_time.setFont(font);
		jlb_stop_watch.setFont(font);
		
		p.add(jlb_date);
		p.add(jlb_time);
		p.add(jlb_stop_watch);
		
		
		//4��°��...
		JPanel p1 = new JPanel();
		JButton jbt_start = new JButton("����");
		JButton jbt_stop  = new JButton("����");
		JButton jbt_clear  = new JButton("�ʱ�ȭ");
		p1.add(jbt_start);
		p1.add(jbt_stop);
		p1.add(jbt_clear);
		
		p.add(p1);
		
		this.add(p,"Center");
		
		//��ž��ġ ��ư �̺�Ʈ
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object evt_bt = e.getSource();
				
				if(evt_bt==jbt_start) {
					
					start_time = System.currentTimeMillis();//����(����)�ð�
					t_stop_watch.resume();//�簡��
					
					
				}else if(evt_bt==jbt_stop) {
					
					t_stop_watch.suspend();//�Ͻ�����
					
				}else if(evt_bt==jbt_clear) {
					
					stop_hour=stop_minute=stop_second=stop_mili_sec = 0;
					jlb_stop_watch.setText("00:00:00.000");
					
				} 
			}
		};
		
		jbt_start.addActionListener(listener);
		jbt_stop.addActionListener(listener);
		jbt_clear.addActionListener(listener);
		
		
		
		
		
		//��¥������ ������
		init_date_thread();
		
		//�ð������� ������
		init_time_thread();
		
		//stopwatch ������ ������
		init_stopwatch_thread();
		
		
		//��ġ
		//this.setLocation(200, 100);
		//ũ������
		//this.setSize(400, 300);

		// ��ġ + ũ������
		this.setBounds(200, 100, 400, 200);

		//�������
		this.setVisible(true);

		//�����ڵ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_stopwatch_thread() {
		// TODO Auto-generated method stub
		// �͸��� Ŭ����
		t_stop_watch = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					
					long end_time = System.currentTimeMillis();
					
					int gap_mili_sec = (int)(end_time - start_time);
					
					//System.out.println(gap_mili_sec);
					stop_mili_sec = gap_mili_sec % 1000;
					
					int total_sec = gap_mili_sec / 1000; //������� ����� sec
					
					stop_hour = total_sec / 3600;
					total_sec = total_sec % 3600;
					
					stop_minute = total_sec / 60;
					stop_second = total_sec % 60;
					
					String str_stop_watch = 
							String.format("%02d:%02d:%02d.%03d", 
									     stop_hour,stop_minute,stop_second,stop_mili_sec
									);
					jlb_stop_watch.setText(str_stop_watch);
					
					
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		};
		
		t_stop_watch.start();//��⿭�߰� runnable
		t_stop_watch.suspend();//�Ͻ�����
		
		
	}

	private void init_date_thread() {
		// TODO Auto-generated method stub
		//1.Thread�������(��ӹ޾Ƽ� �����ϴ� ���)
		class DateThread extends Thread
		{
			int color = 0;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				while(true)
				{
					//System.out.printf("������ྲ����  %s\n",currentThread().getName());
					try {
						Calendar c = Calendar.getInstance();//���� �ý��� ��¥
						int year 	= c.get(Calendar.YEAR);
						int month 	= c.get(Calendar.MONTH) + 1;
						int day 	= c.get(Calendar.DATE);
						
						String str_date = String.format("%d�� %02d�� %02d��", 
								                       year,month,day 
								);
						
						//��¥����ϴ� JLabel�� �ִ´�
						jlb_date.setForeground(color==0 ? Color.RED : Color.YELLOW);
						jlb_date.setText(str_date);
						
						if(color==0)color = 1;
						else color = 0;
						
						
						sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		Thread t = new DateThread();//new(����)
		t.start();                  //���� => Runnable���·� ����
		//t.run();
	
	}
	
	private void init_time_thread() {
		// TODO Auto-generated method stub
		//System.out.println(Thread.currentThread().getName());
		//2.Thread����(���)���: Thread���ఴü�� ���������� ��������
		
		class TimeRunnable implements Runnable
		{
			@Override
			public void run() { //Thread Procedure(�����ڵ�)
				// TODO Auto-generated method stub
				while(true) {
					
					//System.out.println(Thread.currentThread().getName());
					try {
						
						Calendar c 	= Calendar.getInstance();
						int hour 	= c.get(Calendar.HOUR_OF_DAY);
						int minute 	= c.get(Calendar.MINUTE);
						int second	= c.get(Calendar.SECOND);
						int mili_sec = c.get(Calendar.MILLISECOND);
						
						String str_time = 
								String.format("%02d:%02d:%02d %03d", 
										      hour,minute,second,mili_sec);
						jlb_time.setText(str_time);
												
						
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}//run() ����Ǹ� �ش� ������� Dead(�Ҹ�)
		}
		
		TimeRunnable tr = new TimeRunnable();
		//               //���ఴü����
		Thread t = new Thread(tr);
		t.start();//���� t.run()����ȣ���ϸ� �ȵȴ�
		
		
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyMain_Teacher1();
	}

}