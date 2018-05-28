package utill;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import ox_survive.MyConst;
import pv.Character_pan;

public class Pan {
	public static int width = (int)(MyConst.GAME_W*MyConst.XPAN_W);
	public static int height = (int)(MyConst.GAME_H*MyConst.XPAN_H);
	
	public static int ch_width = (int)(MyConst.GAME_W*MyConst.XPAN_W*0.1);
	public static int gap_w = (int)(ch_width * 0.75);
	public static int ch_height = 80;
	public static int gap_h = (int)(ch_height * 0.5);
	
	Point First_Point = new Point();

	public Character_pan[][] ch_lo;
	// Character_pan [] ch_lo = new Character_pan[30];//캐릭터 로케이션;

	public Pan() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Pan(int x, int y) {
		// TODO Auto-generated constructor stub
		this();
		First_Point = new Point(x, y);
		int start_point_w = x + (int) (MyConst.GAME_W * MyConst.XPAN_W * 0.1);
		int start_point_h = y + (int) (MyConst.GAME_H * MyConst.XPAN_H * 0.1);
		int count = 0;
		ch_lo = new Character_pan[10][5];

		for (int i = 0; i < ch_lo.length; i++) {
			for (int j = 0; j < ch_lo[i].length; j++) {
				int w = start_point_w + (j*Pan.ch_width + j*Pan.gap_w);
				int h = start_point_h + (i*Pan.gap_h);
				ch_lo[i][j] = new Character_pan(w,h);
			}
		}

	}
	

}
