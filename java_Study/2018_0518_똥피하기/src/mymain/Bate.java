package mymain;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Bate extends Item {
	int key_state;
	int rect_space_x;//바트의 좌표와 가로의 길이를 더 작게해준다. 그래야 바트 안쪽으로 똥이 맞을거 같다.
	int rect_space_y;//바타의 y좌표와 세로의 길이를 더 작게해준다. 그래야 바트 안쪽으로 똥이 맞을거 같다.
	double space = 0.3;
	
	
	public Bate() {
		// TODO Auto-generated constructor stub
		this.rect_space_x = (int)(MyImages.img_me.getWidth(null)*space);
		this.rect_space_y = (int)(MyImages.img_me.getHeight(null)*space);
		this.pos.width = MyImages.img_me.getWidth(null)- rect_space_x;
		this.pos.height = MyImages.img_me.getHeight(null) - rect_space_y;
		this.pos.x = (int) (MyConst.GamePan.GAMEPAN_W / 2 * 0.9)+ rect_space_x;
		this.pos.y = MyConst.GamePan.GAMEPAN_H - MyImages.img_me.getHeight(null) + rect_space_y;
		
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
		g.drawRect(this.pos.x-rect_space_x, this.pos.y + rect_space_y, this.pos.width+ rect_space_x, this.pos.height + rect_space_y);

	}

	public int getKey_state() {
		return key_state;
	}

	public void setKey_state(int key_state) {
		this.key_state = key_state;
	}

}
