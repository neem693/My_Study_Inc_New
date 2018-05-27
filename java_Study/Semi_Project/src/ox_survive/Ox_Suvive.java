package ox_survive;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import images.Images;
import utill.Pan;

public class Ox_Suvive extends JFrame {
	
	JPanel full;
	Pan pan;

	public Ox_Suvive() {
		super("내가만든 윈도우");
		init_pan();
		this.setLocation(200,100);
		//this.setBounds(200, 100, MyConst.GAME_W, MyConst.GAME_H);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}

	private void init_pan() {
		// TODO Auto-generated method stub
		int border=(int)(MyConst.GAME_W * 0.05);
		int width = (int)(MyConst.GAME_W * MyConst.XPAN_W);
		int height  = (int)(MyConst.GAME_H*MyConst.XPAN_H);
		pan = new Pan(0+border,0+border);
		
		full = new JPanel() {

			
			
			
			@Override
			protected void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);
				g.drawRect(0+border, 0+border, width, height);
				g.drawRect(MyConst.GAME_W - border-width, 0+border, width, height);
				g.drawImage(Images.RYON, pan.ch_lo.getCharacter_start_w(), pan.ch_lo.getCharacter_start_w(),pan.ch_lo.width,pan.ch_lo.height, null);
			
				
				
			}
		};
		
		full.setPreferredSize(new Dimension(MyConst.GAME_W, MyConst.GAME_H));
		this.add(full);
		
		
		
	}

	public static void main(String[] args) {
		new Ox_Suvive();

	}

}