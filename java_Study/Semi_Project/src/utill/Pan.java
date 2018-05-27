package utill;

import java.awt.Point;
import java.util.ArrayList;

import ox_survive.MyConst;
import pv.Character_pan;

public class Pan {
	
	Point First_Point = new Point();
	public Character_pan ch_lo;
//	Character_pan [] ch_lo = new Character_pan[30];//캐릭터 로케이션;
	
	public Pan() {
		// TODO Auto-generated constructor stub
		super();
	}
	public Pan(int x, int y	) {
		// TODO Auto-generated constructor stub
		this();
		First_Point = new Point(x,y);
		int start_point_w=  x +(int)(MyConst.GAME_W*MyConst.XPAN_W*0.1);
		int start_point_h = y +  (int)(MyConst.GAME_H*MyConst.XPAN_H*0.1);
		
		
		
		ch_lo = new Character_pan(start_point_w, start_point_h);
			
			
		
			
		
		
		
		
		
	}
	

}
