package mymain;

import java.awt.Graphics;

public class Bate extends Item{

	@Override
	public boolean move() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(MyImages.img_me,this.pos.x,this.pos.y,null);
		
	}
	

}
