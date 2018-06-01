package utill;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import pv.Character_ox;

public class Character_Manager {

	static final int HEAVY = 50;
	static final int MEDIUM = 35;
	static final int LOW = 20;
	Random rand;

	static final String OLOCATION = "O";
	static final String XLOCATION = "X";
	Pan opan, xpan;
	int count;
	public ArrayList<Character_ox> ch_list;

	public Character_Manager() {
		// TODO Auto-generated constructor stub
		rand = new Random();
		ch_list = new ArrayList<Character_ox>();
	}

	public Character_Manager(Pan opan, Pan xpan) {
		this();
		this.opan = opan;
		this.xpan = xpan;
		int x, y;
		int count_x = 0, count_o = 0;
		Character_ox ch;
		for (int i = 0; i < this.HEAVY; i++) {
			if (i % 2 == 0) {
				x = opan.ch_priority_lo[count_o].getCharacter_start_w();
				y = opan.ch_priority_lo[count_o].getCharacter_start_h();
				opan.ch_priority_lo[count_o].is_hear = true;

				ch = new Character_ox(x, y);
				opan.ch_priority_lo[count_o].setCh(ch);
				count_o++;

			} else {
				x = xpan.ch_priority_lo[count_x].getCharacter_start_w();
				y = xpan.ch_priority_lo[count_x].getCharacter_start_h();
				xpan.ch_priority_lo[count_x].is_hear = true;

				ch = new Character_ox(x, y);
				xpan.ch_priority_lo[count_x].setCh(ch);
				count_x++;
			}

			ch_list.add(ch);

		}
		// for(int i =0; )
		// this.ch_list = new
	}

	public boolean move() {
		// TODO Auto-generated method stub

		return false;
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		// 멈춰있는것들을 먼저 그린다.
		drawPan(g, opan);
		drawPan(g, xpan);
		
		for(Character_ox ch : ch_list) {
			if(ch.isMoving() == true)
				ch.draw(g);
		}
	}

	private void drawPan(Graphics g, Pan pan) {
		// TODO Auto-generated method stub
		for (int i = 0; i < pan.ch_lo.length; i++) {
			for (int j = 0; j < pan.ch_lo[i].length; j++) {

				if (pan.ch_lo[i][j].isIs_hear())
					pan.ch_lo[i][j].getCh().draw(g);

			}
		}

	}
}
