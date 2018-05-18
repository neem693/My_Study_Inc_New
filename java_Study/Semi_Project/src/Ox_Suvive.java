
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ox_Suvive extends JFrame {
	
	JPanel full;
	

	public Ox_Suvive() {
		super("내가만든 윈도우");
		//this.setLocation(200,100);
		this.setBounds(200, 100, MyConst.GAME_W, MyConst.GAME_H);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		init_pan();
	}

	private void init_pan() {
		// TODO Auto-generated method stub
		full = new JPanel() {
			int border=50;
			
			
			
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				g.drawRect(0+border, 0+border, (int)(MyConst.GAME_W * MyConst.XPAN_W), (int)(MyConst.GAME_H*MyConst.XPAN_H));
				
				
				
			}
		};
		
		this.add(full);
		
		
		
	}

	public static void main(String[] args) {
		new Ox_Suvive();

	}

}