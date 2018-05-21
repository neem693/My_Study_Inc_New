package mymain;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DDongManager {
	
	ExplosionManager explosionManger;
	public static final int DDONG_MAKE_INTERVAL = 20;
	public List<DDong> ddong_list = new ArrayList<DDong>();
	
	
	Random rand = new Random();
	
	int ddong_make_interval = DDONG_MAKE_INTERVAL;
	int level = 1;
	int maxDDongSize;

	public DDongManager(ExplosionManager explosionManager) {
		// TODO Auto-generated constructor stub
		this.explosionManger = explosionManager;
		
	}

	public void make_ddong() {
		DDong ddong = new DDong();
		maxDDongSize = level * 5;
		if(ddong_make_interval==DDONG_MAKE_INTERVAL && ddong_list.size()<=maxDDongSize)
		{
		ddong.pos.y = -ddong.pos.height;
		ddong.pos.x = rand.nextInt(MyConst.GamePan.GAMEPAN_W) - ddong.pos.width/2;
		ddong.speed = rand.nextInt(level * 3) + 2; // 이동속도 : 2~3
		//생성된 DDong을 리스트에 추가
		ddong_list.add(ddong);
		}
		
		ddong_make_interval--;
		if(ddong_make_interval <0) ddong_make_interval = DDONG_MAKE_INTERVAL;

	}

	public void move() {
		for(int i =0;i<ddong_list.size();i++) {
			DDong ddong = ddong_list.get(i); 
			
			if(ddong.move()==false) {//화면밖으로 벗어난 경우
				this.explosionManger.make_explosion(ddong.pos.x + MyImages.img_exp[0].getWidth(null)/3, ddong.pos.y - MyImages.img_exp[0].getHeight(null)/3);
				this.explosionManger.move();
				ddong_list.remove(i);
				//System.out.println(this.explosionManger.explosion_list.size());
				
			}
		}
	}

	public void draw(Graphics g) {
		for(int i =0;i<ddong_list.size();i++) {
			DDong ddong = ddong_list.get(i);
			ddong.draw(g);
			explosionManger.draw(g);
			
		}

	}

}
