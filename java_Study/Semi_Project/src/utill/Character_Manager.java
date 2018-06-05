package utill;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import org.omg.CosNaming.IstringHelper;

import pv.Character_User;
import pv.Character_ox;

public class Character_Manager {

	public static final int HEAVY = 50;
	public static final int MEDIUM = 35;
	public static final int LOW = 20;
	Random rand;

	static final String OLOCATION = "O";
	static final String XLOCATION = "X";
	Pan opan, xpan;
	int how_many;
	public ArrayList<Character_ox> ch_list;
	public Character_ox ch_user;

	public Character_Manager() {
		// TODO Auto-generated constructor stub
		rand = new Random();
		ch_list = new ArrayList<Character_ox>();
	}

	public Character_Manager(Pan opan, Pan xpan, int how_many, int how_many_user) {
		this();
		this.how_many = how_many;
		this.opan = opan;
		this.xpan = xpan;
		int x, y;
		int count_x = 0, count_o = 0;
		int[] user_count = new int[how_many_user];
		int count = 0;

		make_user_count(user_count);

		Character_ox ch = null;

		for (int i = 0; i < this.how_many; i++) {
			if (i % 2 == 0) {
				x = opan.ch_priority_lo[count_o].getCharacter_start_w();
				y = opan.ch_priority_lo[count_o].getCharacter_start_h();
				opan.ch_priority_lo[count_o].is_hear = true;

				if (user_count[count] == i) {
					ch = new Character_User(x, y);
					ch_user = ch;
				} else {
					ch = new Character_ox(x, y);
				}
				ch.setCurrentLocation(Pan.OPAN);
				opan.ch_priority_lo[count_o].setCh(ch);
				ch.setCurrent_pan(opan.ch_priority_lo[count_o]);
				count_o++;

			} else {
				x = xpan.ch_priority_lo[count_x].getCharacter_start_w();
				y = xpan.ch_priority_lo[count_x].getCharacter_start_h();
				xpan.ch_priority_lo[count_x].is_hear = true;

				if (user_count[count] == i) {
					ch = new Character_User(x, y);
					ch_user = ch;
				} else {
					ch = new Character_ox(x, y);
				}
				ch.setCurrentLocation(Pan.XPAN);
				xpan.ch_priority_lo[count_x].setCh(ch);
				ch.setCurrent_pan(xpan.ch_priority_lo[count_x]);
				count_x++;
			}

			ch_list.add(ch);

		}
		// for(int i =0; )
		// this.ch_list = new
	}

	private void make_user_count(int[] user_count) {
		// TODO Auto-generated method stub
		// user_count = new int[how_many_user];
		int check;
		AGAIN: for (int i = 0; i < user_count.length; i++) {
			check = rand.nextInt(Character_Manager.HEAVY);
			for (int j = 0; j < i; j++)
				if (check == user_count[j]) {
					i -= 1;
					continue AGAIN;
				}
			user_count[i] = check;
		}
	}

	public boolean move() {
		// TODO Auto-generated method stub
		System.out.println("실행중");
		Point cpoint, npoint;
		for (Character_ox ch_ox_move : ch_list) {
			cpoint = ch_ox_move.getCurrent_point();
			npoint = ch_ox_move.getNext_point();
			if (ch_ox_move.isMoving()) {
				if (cpoint.x < npoint.x)
					cpoint.x += 5;
				else if (cpoint.x > npoint.x)
					cpoint.x -= 5;

				if (cpoint.y < npoint.y)
					cpoint.y += 5;
				else if (cpoint.y > npoint.y)
					cpoint.y -= 5;

				if (ch_ox_move.getCurrent_pan().rect.contains(ch_ox_move.getCurrent_point())) {
					ch_ox_move.setCurrent_point(ch_ox_move.getNext_point());
					ch_ox_move.setMoving(false);
				}
			}

		}
		return false;
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		// 멈춰있는것들을 먼저 그린다.
		drawPan(g, opan);
		drawPan(g, xpan);

		for (Character_ox ch : ch_list) {
			if (ch.isMoving() == true)
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

	public void user_goto(Pan pan) {
		// TODO Auto-generated method stub
		Character_pan ch_pan = null;
		Character_pan ch_pan2 = null;
		int i = 0;
		int r;
		for (; i < 30; i++) {
			if (pan.ch_priority_lo[i].is_hear == false) {
				ch_pan = pan.ch_priority_lo[i];
				if (i != 29 && pan.ch_priority_lo[i + 1].is_hear == false)
					ch_pan2 = pan.ch_priority_lo[i + 1];
				break;

			}

		}

		if (ch_pan == null && ch_pan2 == null) {
			for (; i < 50; i++) {
				if (pan.ch_priority_lo[i].is_hear == false) {
					ch_pan = pan.ch_priority_lo[i];
				}
			}
		}
		if (ch_pan2 == (null)) {
			go_ox(ch_pan, ch_user);

		} else {
			r = rand.nextInt(10) + 1;
			if (1 <= r && 5 >= r)
				go_ox(ch_pan, ch_user);
			else if (6 <= r && 10 >= r)
				go_ox(ch_pan2, ch_user);

		}

	}

	private void go_ox(Character_pan ch_pan, Character_ox ch) {
		// TODO Auto-generated method stub
		ch.setNext_point(new Point(ch_pan.character_start_w, ch_pan.character_start_h));
		ch.setMoving(true);
		ch.getCurrent_pan().setIs_hear(false);
		ch.getCurrent_pan().setCh(null);
		ch.setCurrent_pan(ch_pan);
		ch.getCurrent_pan().setIs_hear(true);
		ch_pan.setCh(ch);
		System.out.println(ch.getCurrent_point() + " " + ch.getNext_point());
	}

}
