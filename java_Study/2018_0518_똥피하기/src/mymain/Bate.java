package mymain;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Bate extends Item {
	int key_state;
	int draw_x;
	int draw_y;
	int width;
	int height;
	double space = 0.3;
	
	
	public Bate() {
		// TODO Auto-generated constructor stub
		
		width = MyImages.img_me.getWidth(null);
		height = MyImages.img_me.getHeight(null);
		
		this.pos.x = width + (int)(width*0.25);
		this.pos.y = height + (int)(height*0.25);

		this.pos.width = width + (int)(width*0.5);
		this.pos.height = height + (int)(height*0.5);
		
		
		
	}

	@Override
	public boolean move() {
		// TODO Auto-generated method stub

		if ((key_state & MyConst.Key.LEFT) == MyConst.Key.LEFT)
			if (this.pos.x <= 0)
				this.pos.x = 0;
			else
				this.pos.x -= 5;
		if ((key_state & MyConst.Key.RIGHT) == MyConst.Key.RIGHT)
			if (this.pos.x >= MyConst.GamePan.GAMEPAN_W - MyImages.img_me.getWidth(null))
				this.pos.x = MyConst.GamePan.GAMEPAN_W - MyImages.img_me.getWidth(null);
			else
				this.pos.x += 5;
		if ((key_state & MyConst.Key.UP) == MyConst.Key.UP)
			;

		return false;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
		g.drawImage(MyImages.img_me, this.pos.x, this.pos.y, null);
		//g.drawRect(this.pos.x-rect_space_x, this.pos.y + rect_space_y, this.pos.width+ rect_space_x, this.pos.height + rect_space_y);

	}

	public int getKey_state() {
		return key_state;
	}

	public void setKey_state(int key_state) {
		this.key_state = key_state;
	}

}
