package ox_survive;
import java.awt.Graphics;
import java.awt.Point;

import utill.Item;

public class Character extends Item{

	Point current_point;
	Point next_point;
	boolean not_hear;

	public Character() {
		// TODO Auto-generated constructor stub
		
		

	}

	public Character(int x, int y) {
		super();
		this.current_point.x= x;
		this.current_point.y =y;
		
	}

	@Override
	public boolean move() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	
}
