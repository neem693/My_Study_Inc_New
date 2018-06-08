package ox_survive;

import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import pv.Character_ox;
import utill.Character_Manager;
import utill.Pan;

public class GameOver {
	Character_Manager ch_m;
	Timer timer;
	
	Random rand;
	ArrayList<Character_ox> ch_list;
	JPanel full;
	Graphics g;

	static final int POSITIVE_PERCENT = 6;
	static final int NEGATIVE_PERCENT = 10;
	boolean isRound=false;
	int round_interval;
	int count = 0;
	String count_str;

	public GameOver() {
		// TODO Auto-generated constructor stub
		super();
		round_interval = 0;
		rand = new Random();
	}

	public GameOver(Character_Manager ch_m, Timer timer, JPanel full) {
		this();

		this.ch_m = ch_m;
		this.timer = timer;
		this.ch_list = ch_m.getCh_list();
		this.full = full;

	}

	public void nextRound() {
		// TODO Auto-generated method stub

		// int max_character = ch_list.size();
		if(isRound)
			return;
		int r;

		if (true) // 만약 답이 o라면 60%가 o로 간다. 지금으로선 무조건 O가 60퍼센트라고 하자.
		{
			for (Character_ox ch : ch_list) {
				if (ch.equals(ch_m.getCh_user()))
					continue;
				r = rand.nextInt(10);

				if (0 <= r && r <= GameOver.POSITIVE_PERCENT) {
					ch_m.user_goto(ch_m.getOpan(), ch);
				} else if (GameOver.POSITIVE_PERCENT < r && r <= GameOver.NEGATIVE_PERCENT) {
					ch_m.user_goto(ch_m.getXpan(), ch);
				}

			}

		}

	}

	public void count_up() {
		if(!isRound)
			isRound=true;
		count++;
	}
	public boolean count_zero() {
		if(count>=500) {
			if(round_interval <600) {
				round_interval ++;
				count=500;
			}else if(round_interval >=600) {
				count =0;
				round_interval=0;
				isRound=false;
			}
			return true;
		}else
			return false;
	}

	public int getCount() {
		return count;
	}

	public void draw_count(Graphics g) {
		// TODO Auto-generated method stub
		g.setFont(new Font("굴림",1,20));
		count_str = String.format("%d . %02d", this.getCount()/100,this.getCount()%100);
		g.drawString(count_str, MyConst.GAME_W/2-g.getFontMetrics().stringWidth(count_str)/2, 100);
	}

	public void lets_kill() {
		// TODO Auto-generated method stub

		Pan pan;
		if(true) {	//x판이 틀렸을 때
			pan = ch_m.getXpan();
		}
		for(int i=0;i<pan.ch_lo.length;i++) {
			for(int j =0;j<pan.ch_lo[i].length;j++) {
				if(pan.ch_lo[i][j].isIs_hear())
					for(int n =0;n<ch_list.size();n++) {
						if(ch.equals(pan.ch_lo[i][j].getCh()))
							ch_list.remove(n);
					}
						
			}
		}
		
		
		
	}
	
}
