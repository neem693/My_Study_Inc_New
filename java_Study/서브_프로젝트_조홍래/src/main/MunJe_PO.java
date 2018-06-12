package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//	awt -> Ȯ�� -> swing
// Frame		   JFrame

public class MunJe_PO extends JFrame {
	
	JTextArea jta_display; //���â
	JPanel pmunje;
	MunJe munje;
	ArrayList<String> quiz_r_n;
	ArrayList<String> quiz_r_m;
	ArrayList<String> quiz_r_c;
	FontMetrics fontmet;
	int n;
	Graphics g;
	
	//�۾�ü
	Font font = new Font("����ü",Font.BOLD,16);
	
	public MunJe_PO() throws IOException {
		// TODO Auto-generated constructor stub
		super("�������� ������");
	

		
		
		//��ġ
		this.setLocation(200, 100);
		//ũ������
		//this.setSize(1280, 720);
		init_panel();
		init_key_event();

		// ��ġ + ũ������
		//this.setBounds(1280, 720, 400, 300);
		pack();
		
		//�������
		this.setVisible(true);

		//�����ڵ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
		
		
	private void init_key_event() {
		// TODO Auto-generated method stub
		KeyAdapter adapter = new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_SPACE) {
					n++;
					pmunje.repaint();
					
					
				}
			}
		};
		this.addKeyListener(adapter);
	}



	private void init_panel() throws IOException {
		// TODO Auto-generated method stub
		n=0;
		munje = new MunJe();
		munje.random();
		quiz_r_n = munje.getQuiz_r_n();
		quiz_r_m = munje.getQuiz_r_m();
		quiz_r_c = munje.getQuiz_r_c();
		Font font = new Font("a����",0, 20);
		
	
		pmunje = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				g.setFont(font);
				fontmet =  g.getFontMetrics();
				g.setColor(new Color(0,0,0,126));
				g.fillRect(640-fontmet.stringWidth(quiz_r_m.get(n))/2, 10, fontmet.stringWidth(quiz_r_m.get(n))+30, fontmet.getHeight()+15);
				g.setColor(Color.WHITE);
								
				
				g.drawString(quiz_r_m.get(n),640-fontmet.stringWidth(quiz_r_m.get(n))/2+15, 10+20);
				
				
				
			}
		};
		pmunje.setPreferredSize(new Dimension(1280, 720));
		this.add(pmunje);
		
		
		
		
		
	}
		


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		new MunJe_PO();
	}

}
