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
	
	JTextArea jta_display;		//출력창
	JTextField jtf_message;		//메시지창
	JList<String> jlist_user;	//접속자목록
	JButton jbt_connect;
	boolean bConnect = false; 	//연결상태관리할 변수
	
	
	

	public MultiChatClient() {
		super("멀티채팅 클라이언트");
		
		//조회창 초기화
		init_display();
		
		//접속자목록 초기화
		init_userlist();
		
		//접속자수 초기화
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
		
		//메시지창
		jtf_message = new JTextField();
		
		
		p.add(jtf_message,"Center");
		
		//연결버튼
		jbt_connect = new JButton("연결");
		p.add(jbt_connect,"East");
		jbt_connect.setPreferredSize(new Dimension(150, 10));
		
		
		
		this.add(p,"South");
		
		
		
		jbt_connect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//이건 토글 방식이라고 한다.
				bConnect = !bConnect;
				
				
				if(bConnect) {
					//연결작업
					
					
				}else {
					//끊기작업
					
					
				}
				
				
				
				jbt_connect.setText(bConnect?"끊기":"연결");
				
			}
		});
		
		
		//키이벤트 처리
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
		
		
		String [] user_array = {"길동1","길동2","삼식이","길동3"};
		jlist_user.setListData(user_array);
		
		
		
		
	}

	private void init_display() {
		// TODO Auto-generated method stub
		jta_display = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta_display);
		
		this.add(jsp,"Center");
		
		jsp.setPreferredSize(new Dimension(400, 400));
		
		//읽기전용
		jta_display.setEditable(false);
		
		
		
	}

	public static void main(String[] args) {
		new MultiChatClient();

	}

}