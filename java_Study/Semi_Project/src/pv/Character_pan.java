package pv;

import ox_survive.MyConst;

public class Character_pan {
	public static int  gap_w = (int)(MyConst.GAME_W*MyConst.XPAN_W*0.1*0.75);
	public static int width = (int)(MyConst.GAME_W*MyConst.XPAN_W*0.1);
	public static int height = 80;
	int character_start_w;
	int character_start_h;


	

	
	
	
	
	public Character_pan() {
		// TODO Auto-generated constructor stub
		super();
		
	}
	
	public Character_pan(int character_start_w, int character_start_h) {
		this();
		this.character_start_w = character_start_w;
		this.character_start_h = character_start_h;
	}
	public int getCharacter_start_w() {
		return character_start_w;
	}
	public void setCharacter_start_w(int character_start_w) {
		this.character_start_w = character_start_w;
	}
	public int getCharacter_start_h() {
		return character_start_h;
	}
	public void setCharacter_start_h(int character_start_h) {
		this.character_start_h = character_start_h;
	}


	
	
	

}
