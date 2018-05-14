package mymain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import myutil.MyConst;

public class Nunal extends JFrame {

	JPanel gamePan;
	Point eye_left, eye_right, eyeball_left, eyeball_right;
	int eye_radius, eyeball_radius;
	int width,height;
	BufferedImage img;
	
	
	public Nunal() {
		super("눈알굴리기");

		// 그림판 초기화
		init_gamepan();

		// 눈알의 좌표 초기화
		init_eye_position();

		init_eyeball_position();
		
		init_mouse_event();
		
		 try {                
	          img = ImageIO.read(new File("_background.jpg"));
	          
	          width = img.getWidth();
	          height = img.getHeight();
	          System.out.println(width);
	          System.out.println(height);
	       } catch (IOException ex) {
	    	   	ex.printStackTrace();
	            // handle exception...
	       }
		 
		

		this.setLocation(200, 100);

		this.setResizable(false);
		this.pack();

		// this.setBounds(200, 100, 400, 300);
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void init_mouse_event() {
		
		MouseAdapter adapter = new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				System.out.println(e);
				Point pt = e.getPoint();
				
				//왼쪽 눈알 중심좌표 구하기
				left_eyeball_position(pt);
				
				//오른쪽 눈알 중심좌표 구하기
				right_eyeball_position(pt);
				
				
				gamePan.repaint();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				init_eyeball_position();
				gamePan.repaint();
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseDragged(e);
				System.out.println(e);
				Point pt = e.getPoint();
				
				//왼쪽 눈알 중심좌표 구하기
				left_eyeball_position(pt);
				
				//오른쪽 눈알 중심좌표 구하기
				right_eyeball_position(pt);
				
				
				
				gamePan.repaint();
			}
			
		};
		
		//gamePan에 마우스 이벤트 설정
		gamePan.addMouseListener(adapter);//pressed,released,entered,exited,clicked
		gamePan.addMouseMotionListener(adapter);//draged,moved
		
	}

	protected void right_eyeball_position(Point pt) {
		
	
		
		
		int xx = pt.x - eye_right.x;
		int yy = pt.y - eye_right.y;
		
		double r = Math.sqrt(xx*xx + yy* yy);
		double right_rate = eyeball_radius /r;
		
		eyeball_right.x = (int)(eye_right.x + xx * right_rate);
		eyeball_right.y = (int)(eye_right.y + yy * right_rate);
		
		
	}

	protected void left_eyeball_position(Point pt) {
	
		int xx = pt.x - eye_left.x;
		int yy = pt.y - eye_left.y;
		
		double r = Math.sqrt(xx*xx + yy* yy);
		double left_rate = eyeball_radius /r;
		
		eyeball_left.x = (int)(eye_left.x + xx * left_rate);
		eyeball_left.y = (int)(eye_left.y + yy * left_rate);
		
		
	}

	private void init_eyeball_position() {

		eyeball_left = new Point(eye_left.x, eye_left.y);
		eyeball_right = new Point(eye_right.x, eye_right.y);

		eyeball_radius = eye_radius / 2;

	}

	private void init_eye_position() {

		// 왼쪽 눈 중심좌표

		eye_left = new Point();
		eye_left.x = MyConst.GAME_W / 4;
		eye_left.y = MyConst.GAME_H / 2;

		// 오른쪽 눈 중심좌표
		eye_right = new Point();
		eye_right.x = MyConst.GAME_W / 4 * 3;
		eye_right.y = MyConst.GAME_H / 2;

		// 눈의 반지름
		eye_radius = (MyConst.GAME_W / 4) / 3 * 2;

	}

	private void init_gamepan() {
		gamePan = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				g.drawImage(img,0,0,this);
				g.drawString("눈알그리기", 10, 60);
				
				//g.clearRect(0, 0, MyConst.GAME_W, MyConst.GAME_H);

				//g.drawOval(eye_left.x - eye_radius, eye_left.y - eye_radius, eye_radius * 2, eye_radius * 2);
				//g.drawOval(eye_right.x - eye_radius, eye_right.y - eye_radius , eye_radius * 2, eye_radius * 2);
				
				//g.fillOval(eyeball_left.x - eyeball_radius,eyeball_left.y - eyeball_radius, eyeball_radius * 2, eyeball_radius * 2);
				//g.fillOval(eyeball_right.x - eyeball_radius,eyeball_right.y - eyeball_radius, eyeball_radius * 2, eyeball_radius * 2);
				
			}
		};
		// 크기예약
	

		
		gamePan.setPreferredSize(new Dimension(800, 785));

		//gamePan.setPreferredSize(new Dimension(MyConst.GAME_W, MyConst.GAME_H));

		this.add(gamePan, "Center");

	}

	public static void main(String[] args) {
		new Nunal();

	}

}