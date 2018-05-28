package mymain.tcp.multichat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiChatClient extends JFrame {
	
	JTextArea jta_display;		//���â
	JTextField jtf_message;		//�޽���â
	JList<String> jlist_user;	//�����ڸ��
	JButton jbt_connect;
	boolean bConnect = false; 	//������°����� ����
	
	
	

	public MultiChatClient() {
		super("��Ƽä�� Ŭ���̾�Ʈ");
		
		//��ȸâ �ʱ�ȭ
		init_display();
		
		//�����ڸ�� �ʱ�ȭ
		init_userlist();
		
		//�����ڼ� �ʱ�ȭ
		init_input();
		
		this.pack();
		this.setLocation(200,100);
		//this.setBounds(200, 100, 400, 300);
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void init_input() {
		// TODO Auto-generated method stub
		
		JPanel p = new JPanel(new BorderLayout());
		
		//�޽���â
		jtf_message = new JTextField();
		
		
		p.add(jtf_message,"Center");
		
		//�����ư
		jbt_connect = new JButton("����");
		p.add(jbt_connect,"East");
		jbt_connect.setPreferredSize(new Dimension(150, 10));
		
		
		
		this.add(p,"South");
		
		
		
		jbt_connect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//�̰� ��� ����̶�� �Ѵ�.
				bConnect = !bConnect;
				
				
				if(bConnect) {
					//�����۾�
					
					
				}else {
					//�����۾�
					
					
				}
				
				
				
				jbt_connect.setText(bConnect?"����":"����");
				
			}
		});
		
		
		//Ű�̺�Ʈ ó��
		init_key_event();
		
		
		
	}

	private void init_key_event() {
		// TODO Auto-generated method stub
		
		KeyAdapter adapater = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);
				int key = e.getKeyCode();
				
				if(key == KeyEvent.VK_ENTER) {
					my_send_message();
					
				}
			}
		};
		jtf_message.addKeyListener(adapater);
		
	}

	protected void my_send_message() {
		// TODO Auto-generated method stub
		jtf_message.setText("");
	}

	private void init_userlist() {
		// TODO Auto-generated method stub
		jlist_user = new JList<String>();
		JScrollPane jsp = new JScrollPane(jlist_user);
		
		this.add(jsp,"East");
		
		jsp.setPreferredSize(new Dimension(150, 400));
		
		
		String [] user_array = {"�浿1","�浿2","�����","�浿3"};
		jlist_user.setListData(user_array);
		
		
		
		
	}

	private void init_display() {
		// TODO Auto-generated method stub
		jta_display = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta_display);
		
		this.add(jsp,"Center");
		
		jsp.setPreferredSize(new Dimension(400, 400));
		
		//�б�����
		jta_display.setEditable(false);
		
		
		
	}

	public static void main(String[] args) {
		new MultiChatClient();

	}

}