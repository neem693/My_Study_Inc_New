package mymain;

import java.util.List;

import javax.swing.Timer;

public class IsGameOver {

	DDongManager ddm;
	Bate bate;
	Timer timer;

	public IsGameOver() {
		// TODO Auto-generated constructor stub
	}

	public IsGameOver(DDongManager ddm, Bate bate, Timer timer) {
		super();
		this.ddm = ddm;
		this.bate = bate;
		this.timer = timer;
	}

	public boolean isGameOver() {
		List<DDong> ddong_list = ddm.ddong_list;
		System.out.println(ddong_list.size());
		for (int i = 0; i < ddong_list.size(); i++) {
	
			if (ddong_list.get(i).pos.intersects(bate.pos)) {
				
				this.timer.stop();
				return true;
			}
		}
		return false;

	}

}
