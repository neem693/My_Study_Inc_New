package ox_survive;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import images.Images;
import pv.Character_ox;
import utill.Character_Manager;
import utill.Pan;

public class Ox_Suvive extends JFrame {
	public static int gap_w = (int) (MyConst.GAME_W * MyConst.XPAN_W * 0.1 * 0.75);
	JPanel full;
	Pan xpan;
	Pan opan;
	Character_Manager chManager;
	Random rand = new Random();
	KeyAdapter adapter;
	Timer timer;
	GameOver gameover;

	public Ox_Suvive() {
		super("내가만든 윈도우");

		init_pan();
		init_event();
		init_game();
		init_timer();

		this.setLocation(200, 100);
		// this.setBounds(200, 100, MyConst.GAME_W, MyConst.GAME_H);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void init_game() {
		// TODO Auto-generated method stub
		gameover = new GameOver(chManager, timer, full);
		gameover.nextRound();

	}

	private void init_timer() {
		// TODO Auto-generated method stub
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				process();
				full.repaint();

			}
		};

		timer = new Timer(10, listener);
		timer.start();

	}

	protected void process() {
		// TODO Auto-generated method stub
		chManager.move();
		gameover.count_up();
		if (gameover.count_zero()) {
			gameover.lets_kill();
		}
		if(!gameover.isRound)
			gameover.nextRound();

		// gameover.
	}

	private void init_event() {
		// TODO Auto-generated method stub
		adapter = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);
				int key = e.getKeyCode();
				if (chManager.getCh_user() != null && gameover.isQuetioning()) {
					if (key == KeyEvent.VK_RIGHT) {
						chManager.user_goto(xpan, chManager.getCh_user());
					}
					if (key == KeyEvent.VK_LEFT) {
						chManager.user_goto(opan, chManager.getCh_user());
					}
				}

			}
		};
		this.addKeyListener(adapter);

	}

	private void init_pan() {
		// TODO Auto-generated method stub
		int border = (int) (MyConst.GAME_W * 0.05);
		int width = Pan.WIDTH;
		int height = Pan.HEIGHT;

		opan = new Pan(Pan.OPAN, 0 + border, 0 + border);
		xpan = new Pan(Pan.XPAN, MyConst.GAME_W - border - width, 0 + border);
		chManager = new Character_Manager(opan, xpan, Character_Manager.HEAVY, 1);

		/////////// 테스트
		// for(int i=0;i<10;i++) {
		// for(int j=0;j<5;j++) {
		// System.out.printf("%02d ",xpan.ch_lo[i][j].getPriority());
		// }
		// System.out.println();
		// }

		// priority 제대로 동작하느냐 테스트
		// for(int i =0;i<50;i++) {
		// System.out.println(xpan.ch_priority_lo[i].getPriority());
		// }
		full = new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);

				//// 이 때 쯤에 배경화면 하나 추가하자.
				
				g.drawImage(Images.BACKGROUND, 0, 0,null);

				g.drawRect(0 + border, 0 + border, width, height);
				g.drawRect(MyConst.GAME_W - border - width, 0 + border, width, height);
				chManager.draw(g);
				gameover.draw_count(g);
				gameover.munje_show(g);

				// 그리기 테스트 이다.
				// for (int i = 0; i < xpan.ch_lo.length; i++) {
				// for (int j = 0; j < xpan.ch_lo[i].length; j++) {
				// if (rand.nextInt() % 2 == 0)
				// g.drawImage(Images.RYON, xpan.ch_lo[i][j].getCharacter_start_w(),
				// xpan.ch_lo[i][j].getCharacter_start_h(), xpan.CH_WIDHT, xpan.CH_HEIGHT,
				// null);
				// else
				// g.drawImage(Images.APEACHE, xpan.ch_lo[i][j].getCharacter_start_w(),
				// xpan.ch_lo[i][j].getCharacter_start_h(), xpan.CH_WIDHT, xpan.CH_HEIGHT,
				// null);
				//
				// }
				// }
				//
				// for (int i = 0; i < opan.ch_lo.length; i++) {
				// for (int j = 0; j < opan.ch_lo[i].length; j++) {
				// if (rand.nextInt() % 2 == 0)
				// g.drawImage(Images.RYON, opan.ch_lo[i][j].getCharacter_start_w(),
				// opan.ch_lo[i][j].getCharacter_start_h(), opan.CH_WIDHT, opan.CH_HEIGHT,
				// null);
				// else
				// g.drawImage(Images.APEACHE, opan.ch_lo[i][j].getCharacter_start_w(),
				// opan.ch_lo[i][j].getCharacter_start_h(), opan.CH_WIDHT, opan.CH_HEIGHT,
				// null);
				//
				// }
				// }
			}
		};

		full.setPreferredSize(new Dimension(MyConst.GAME_W, MyConst.GAME_H));
		this.add(full);

	}

	public static void main(String[] args) {
		new Ox_Suvive();

	}

}