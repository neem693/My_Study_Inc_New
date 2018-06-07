package ox_survive;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

import pv.Character_ox;
import utill.Character_Manager;

public class GameOver {
	Character_Manager ch_m;
	Timer timer;
	int interval, count;
	Random rand;
	ArrayList<Character_ox> ch_list;

	static final int POSITIVE_PERCENT = 6;
	static final int NEGATIVE_PERCENT = 10;

	public GameOver() {
		// TODO Auto-generated constructor stub
		super();
		interval = 0;
		count = 0;
		rand = new Random();
	}

	public GameOver(Character_Manager ch_m, Timer timer) {
		this();
		
		this.ch_m = ch_m;
		this.timer = timer;
		this.ch_list = ch_m.getCh_list();
	}

	public void nextRound() {
		// TODO Auto-generated method stub
		
		//int max_character = ch_list.size();
		int r;
		
		if(true) //만약 답이 o라면 60%가  o로 간다. 지금으로선 무조건 O가 60퍼센트라고 하자.
		{
				for(Character_ox ch : ch_list) {
					if(ch.equals(ch_m.getCh_user()))
						continue;
					r = rand.nextInt(10);
					
					if(0<=r&&r<=GameOver.POSITIVE_PERCENT) {
						ch_m.user_goto(ch_m.getOpan(), ch);
					}
					else if(GameOver.POSITIVE_PERCENT<r&&r<=GameOver.NEGATIVE_PERCENT){
						ch_m.user_goto(ch_m.getXpan(), ch);
					}
					
					
					
					
				}
			
			
			
			
			
			
			
		}
		
	}

}
