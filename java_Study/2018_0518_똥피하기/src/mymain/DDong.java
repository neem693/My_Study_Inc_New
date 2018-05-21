package mymain;

import java.awt.Graphics;

public class DDong extends Item{
	
	
	
	public DDong() {
		// TODO Auto-generated constructor stub
		pos.width = MyImages.img_ddong.getWidth(null);
		pos.height = MyImages.img_ddong.getHeight(null);
	}
	
	
	public int speed;

	@Override
	public boolean move() {
		// TODO Auto-generated method stub
		pos.y += speed;
		return pos.y<=MyConst.GamePan.GAMEPAN_H;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(MyImages.img_ddong,pos.x,pos.y,null);//추상화 인터페이스
		g.drawRect(this.pos.x, this.pos.y, this.pos.width,this.pos.height );
		
	}

	
}
