package pv;

import java.awt.Graphics;

import images.Images;
import utill.Pan;

public class Character_User extends Character_ox  {
	
	
	
	
	public Character_User() {
		// TODO Auto-generated constructor stub
		
	}
	
	public Character_User(int x,int y) {
		super(x,y);
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Images.Back_user,current_point.x-Pan.CH_WIDHT*5/2,current_point.y-Pan.CH_WIDHT*5/2,Pan.CH_WIDHT*6,Pan.CH_WIDHT*6,null);
		//g.fillOval(current_point.x, current_point.y, 10, 10); Å×½ºÆ®
		//g.drawImage(Images.Back_user,current_point.x-Pan.CH_WIDHT*2,current_point.y-Pan.CH_HEIGHT*2,Pan.CH_WIDHT*6,Pan.CH_WIDHT*6,null);
		super.draw(g);
	}

}
