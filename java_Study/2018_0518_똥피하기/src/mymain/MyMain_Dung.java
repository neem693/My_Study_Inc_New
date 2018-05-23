package mymain;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyMain_Dung extends JFrame {
	JPanel gamePan;
	int key_state;

	Bate bate = new Bate();
	ExplosionManager explosionManager = new ExplosionManager();
	DDongManager ddongManager = new DDongManager(explosionManager);
	Timer timer;
	IsGameOver gameOver;

	public MyMain_Dung() {
		super("내가만든 윈도우");
		this.setLocation(200, 100);
		// this.setBounds(200, 100, 400, 300);
		init_gamePan();
		init_timer();
		init_mouse_event();
		init_gameOver();
		this.setResizable(false);

		this.pack();
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void init_gameOver() {
		// TODO Auto-generated method stub
		gameOver = new IsGameOver(ddongManager,bate,timer);
		
	}

	private void init_mouse_event() {
		// TODO Auto-generated method stub

		MouseAdapter adapter = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				explosionManager.make_explosion(e.getX(), e.getY());
			}
		};

		gamePan.addMouseListener(adapter);
		

		KeyListener keyListener = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);
				int key = e.getKeyCode();

				if (key == KeyEvent.VK_LEFT)
					key_state = key_state | MyConst.Key.LEFT;
				if (key == KeyEvent.VK_RIGHT)
					key_state = key_state | MyConst.Key.RIGHT;
				if (key == KeyEvent.VK_UP)
					key_state = key_state | MyConst.Key.UP;

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyReleased(e);
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_LEFT)
					key_state = key_state ^ MyConst.Key.LEFT;
				if (key == KeyEvent.VK_RIGHT)
					key_state = key_state ^ MyConst.Key.RIGHT;
				if (key == KeyEvent.VK_UP)
					key_state = key_state ^ MyConst.Key.UP;

			}

		};
		this.addKeyListener(keyListener);

	}

	private void init_timer() {
		// TODO Auto-generated method stub
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				process();
				// Rectangle rect = new Rectangle(0,0,100,100);
				gamePan.repaint();
			}
		};
		timer = new Timer(10, listener);
		timer.start();

	}

	protected void process() {
		// TODO Auto-generated method stub
		// 똥생성
		ddongManager.make_ddong();
		// 똥이동
		ddongManager.move();
		explosionManager.move();
		bate.setKey_state(key_state);
		bate.move();
		gameOver.isGameOver();
	}

	private void init_gamePan() {
		// TODO Auto-generated method stub
		gamePan = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);

				g.clearRect(0, 0, MyConst.GamePan.GAMEPAN_W, MyConst.GamePan.GAMEPAN_H);

				ddongManager.draw(g);
				explosionManager.draw(g);
				bate.draw(g);
			}
		};

		gamePan.setPreferredSize(new Dimension(MyConst.GamePan.GAMEPAN_W, MyConst.GamePan.GAMEPAN_H));
		this.add(gamePan);

	}

	public static void main(String[] args) {
		new MyMain_Dung();

	}

}