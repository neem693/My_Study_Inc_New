package ox_survive;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import images.Images;
import utill.Character_Manager;
import utill.Pan;

public class Ox_Suvive extends JFrame {
	public static int gap_w = (int) (MyConst.GAME_W * MyConst.XPAN_W * 0.1 * 0.75);
	JPanel full;
	Pan xpan;
	Pan opan;
	Character_Manager chManager;
	Random rand = new Random();
	

	public Ox_Suvive() {
		super("내가만든 윈도우");
		
		init_pan();
		
		this.setLocation(200, 100);
		// this.setBounds(200, 100, MyConst.GAME_W, MyConst.GAME_H);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_pan() {
		// TODO Auto-generated method stub
		int border = (int) (MyConst.GAME_W * 0.05);
		int width = Pan.WIDTH;
		int height = Pan.HEIGHT;

		xpan = new Pan("x",0 + border, 0 + border);
		opan = new Pan("o",MyConst.GAME_W - border - width,0+border);
		chManager = new Character_Manager(opan,xpan);
		
		///////////테스트
//		for(int i=0;i<10;i++) {
//			for(int j=0;j<5;j++) {
//				System.out.printf("%02d ",xpan.ch_lo[i][j].getPriority());
//			}
//			System.out.println();
//		}
		
		//priority 제대로 동작하느냐 테스트
//		for(int i =0;i<50;i++) {
//			System.out.println(xpan.ch_priority_lo[i].getPriority());
//		}
		full = new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				
				////이 때 쯤에 배경화면 하나 추가하자.
				
				
				
				g.drawRect(0 + border, 0 + border, width, height);
				g.drawRect(MyConst.GAME_W - border - width, 0 + border, width, height);
				chManager.draw(g);
				
				
				
				
				
				
				//그리기 테스트 이다.
//				for (int i = 0; i < xpan.ch_lo.length; i++) {
//					for (int j = 0; j < xpan.ch_lo[i].length; j++) {
//						if (rand.nextInt() % 2 == 0)
//							g.drawImage(Images.RYON, xpan.ch_lo[i][j].getCharacter_start_w(),
//									xpan.ch_lo[i][j].getCharacter_start_h(), xpan.CH_WIDHT, xpan.CH_HEIGHT, null);
//						else
//							g.drawImage(Images.APEACHE, xpan.ch_lo[i][j].getCharacter_start_w(),
//									xpan.ch_lo[i][j].getCharacter_start_h(), xpan.CH_WIDHT, xpan.CH_HEIGHT, null);
//
//					}
//				}
//				
//				for (int i = 0; i < opan.ch_lo.length; i++) {
//					for (int j = 0; j < opan.ch_lo[i].length; j++) {
//						if (rand.nextInt() % 2 == 0)
//							g.drawImage(Images.RYON, opan.ch_lo[i][j].getCharacter_start_w(),
//									opan.ch_lo[i][j].getCharacter_start_h(), opan.CH_WIDHT, opan.CH_HEIGHT, null);
//						else
//							g.drawImage(Images.APEACHE, opan.ch_lo[i][j].getCharacter_start_w(),
//									opan.ch_lo[i][j].getCharacter_start_h(), opan.CH_WIDHT, opan.CH_HEIGHT, null);
//
//					}
//				}
			}
		};

		full.setPreferredSize(new Dimension(MyConst.GAME_W, MyConst.GAME_H));
		this.add(full);

	}

	public static void main(String[] args) {
		new Ox_Suvive();

	}

}