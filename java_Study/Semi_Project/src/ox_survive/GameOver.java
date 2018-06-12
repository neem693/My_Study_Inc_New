package ox_survive;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import pv.Character_User;
import pv.Character_ox;
import utill.Character_Manager;
import utill.MunJe;
import utill.Pan;

public class GameOver {
	MunJe munje;
	Character_Manager ch_m;
	Timer timer;
	int s;
	int round;

	Random rand;
	ArrayList<Character_ox> ch_list;
	JPanel full;
	Graphics g;

	ArrayList<String> quiz_r_n;
	ArrayList<String> quiz_r_m;
	ArrayList<String> quiz_r_c;

	FontMetrics fontmet;

	static final int ALL_COUNT = 500;
	static final int POSITIVE_PERCENT = 6;
	static final int NEGATIVE_PERCENT = 10;
	boolean isRound = false; // 라운드 중일때 다음 라운드가 실행되지 않게
	boolean quetioning = false; // 문제 5초 동안 일 때만
	boolean gameover = false;
	boolean already_killed = false;
	
	int round_interval;
	int count = 0;
	String count_str;

	public GameOver() {
		// TODO Auto-generated constructor stub
		super();
		round_interval = 0;
		rand = new Random();
		s = 0;
		round = 0;
		try {
			munje = new MunJe();
			munje.random();
			quiz_r_n = munje.getQuiz_r_n();
			quiz_r_m = munje.getQuiz_r_m();
			quiz_r_c = munje.getQuiz_r_c();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		// if (isRound)
		// return;
		int r;
		int i = 0;
		int m = 0;
		for (; s < ch_list.size(); s++) {
			// System.out.println(ch_m.ch_move_list.size());

			i++;
			if (ch_list.get(s) == ch_m.getCh_user())
				continue;
			if (ch_m.ch_move_list.size() >= Character_Manager.MAX_MOVING) {
				break;
			}
			for (Character_ox coh : ch_list) {
				if (coh.isMoving())
					m++;
				if (m >= Character_Manager.MAX_MOVING)
					break;
			}

			if (i == ch_m.MAX_MOVING) {
				// i=0;
				break;
			}
			r = rand.nextInt(10);
			if (quiz_r_c.get(round).equals("O")) // 만약 답이 o라면 60%가 o로 간다. 지금으로선 무조건 O가 60퍼센트라고 하자.
			{

				if (0 <= r && r <= GameOver.POSITIVE_PERCENT) {
					ch_m.user_goto(ch_m.getOpan(), ch_list.get(s));
				} else if (GameOver.POSITIVE_PERCENT < r && r <= GameOver.NEGATIVE_PERCENT) {
					ch_m.user_goto(ch_m.getXpan(), ch_list.get(s));
				}
			}else if(quiz_r_c.get(round).equals("X"))
			{
				if (0 <= r && r <= GameOver.POSITIVE_PERCENT) {
					ch_m.user_goto(ch_m.getXpan(), ch_list.get(s));
				} else if (GameOver.POSITIVE_PERCENT < r && r <= GameOver.NEGATIVE_PERCENT) {
					ch_m.user_goto(ch_m.getOpan(), ch_list.get(s));
				}
			}

		}
	}

	// for (Character_ox ch : ch_list) {
	// if (ch.equals(ch_m.getCh_user()))
	// continue;
	// r = rand.nextInt(10);
	//
	// if (0 <= r && r <= GameOver.POSITIVE_PERCENT) {
	// ch_m.user_goto(ch_m.getOpan(), ch);
	// } else if (GameOver.POSITIVE_PERCENT < r && r <= GameOver.NEGATIVE_PERCENT) {
	// ch_m.user_goto(ch_m.getXpan(), ch);
	// }
	// }
	public void count_up() {
		if (!isRound && s == ch_list.size()) {
			s = 0;
			isRound = true;
		}
		if (!quetioning && count < GameOver.ALL_COUNT)
			quetioning = true;
		else if (count >= GameOver.ALL_COUNT)
			quetioning = false;
		// System.out.println(quetioning);
		count++;
	}

	public boolean count_zero() {
		if (count >= GameOver.ALL_COUNT) {
			if (round_interval < 600) {
				round_interval++;
				count = GameOver.ALL_COUNT;
				already_killed = false;
			} else if (round_interval >= 600) {
				count = 0;// 인터벌이 다 됬을시 다시 초기화 하는 것
				round_interval = 0; // 인터벌도 초기화 해준다.
				isRound = false; // 현재 라운드가 아니고, 갖가지 에니메이션 오답 처리를 하는 과정임을 의미함
				round++;
			}
			return true;
		} else
			return false;
	}

	public int getCount() {
		return count;
	}

	public void draw_count(Graphics g) {
		// TODO Auto-generated method stub
		g.setFont(new Font("굴림", 1, 20));
		count_str = String.format("%d . %02d", this.getCount() / 100, this.getCount() % 100);
		g.drawString(count_str, MyConst.GAME_W / 2 - g.getFontMetrics().stringWidth(count_str) / 2, 100);
	}

	public void lets_kill() {
		// TODO Auto-generated method stub
		if(already_killed)
			return;
		already_killed = true;

		Pan pan=null;
		if (quiz_r_c.get(round).equals("O")) { // x판이 틀렸을 때
			pan = ch_m.getXpan();
		}else if(quiz_r_c.get(round).equals("X")) {
			pan = ch_m.getOpan();
		}
		for (int i = 0; i < pan.ch_lo.length; i++) {
			for (int j = 0; j < pan.ch_lo[i].length; j++) {

				if (pan.ch_lo[i][j].isIs_hear()) {
					for (int n = 0; n < ch_list.size(); n++) {

						if (ch_list.get(n) == pan.ch_lo[i][j].getCh()) {
							// System.out.println("---same---");
							if (ch_list.get(n) == ch_m.ch_user)// user가 망가졌을 때
								ch_m.ch_user = null;
							ch_list.remove(n);
							pan.ch_lo[i][j].setIs_hear(false);
							pan.ch_lo[i][j].setCh(null);
							break;
						}

					}
				}

			}
		}

		// System.out.println(ch_list.size());

	}

	public boolean isQuetioning() {
		return quetioning;
	}

	public void munje_show(Graphics g) {
		if(!quetioning)
			return;
		fontmet = g.getFontMetrics();
		g.setColor(new Color(0, 0, 0, 126));
		g.fillRect(640 - fontmet.stringWidth(quiz_r_m.get(round)) / 2, 10,
				fontmet.stringWidth(quiz_r_m.get(round)) + 30, fontmet.getHeight() + 15);
		g.setColor(Color.WHITE);

		g.drawString(quiz_r_m.get(round), 640 - fontmet.stringWidth(quiz_r_m.get(round)) / 2 + 15, 10 + 20);

	}

}
