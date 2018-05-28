package mymain.tcp.multichat;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiChatServer extends JFrame {
	
	JTextArea jta_display;		//���â
	JTextField jtf_count;		//�����ڼ�
	JList<String> jlist_user;	//�����ڸ��
	
	
	
	

	public MultiChatServer() {
		super("��Ƽä�� ����");
		
		//��ȸâ �ʱ�ȭ
		init_display();
		
		//�����ڸ�� �ʱ�ȭ
		init_userlist();
		
		//�����ڼ� �ʱ�ȭ
		init_usercount();
		
		this.pack();
		this.setLocation(200,100);
		//this.setBounds(200, 100, 400, 300);
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void init_usercount() {
		// TODO Auto-generated method stub
		
		JPanel p = new JPanel(new GridLayout(1, 3));
		JLabel jlb_title1 = new JLabel("�����ڼ�: ",JLabel.RIGHT);
		jtf_count = new JTextField("0");
		JLabel jlb_title2 = new JLabel("(��)",JLabel.LEFT);
		
		
		p.add(jlb_title1);
		p.add(jtf_count);
		p.add(jlb_title2);
		
		this.add(p,"South");
		
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
		new MultiChatServer();

	}

}