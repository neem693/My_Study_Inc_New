package pv;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Random;

import images.Images;
import ox_survive.MyConst;
import utill.Character_Manager;
import utill.Item;
import utill.Pan;

public class Character_ox extends Item {

	
	final static int CHARACTER_COUNT = 3;
	String currentLocation;
	int ch_count;
	BufferedImage character_Image;
	Point current_point;
	Point next_point;
	boolean moving;
	Random rand;

	public Character_ox() {
		// TODO Auto-generated constructor stub
		super();
		moving = false;
		rand = new Random();
		ch_count = rand.nextInt(CHARACTER_COUNT) + 1;
		switch (ch_count) {
		case 1:
			character_Image = Images.RYON;
			break;
		case 2:
			character_Image = Images.APEACHE;
			break;
		case 3:
			character_Image = Images.TUBE;
			break;

		}

	}

	public Character_ox(int x, int y) {
		this();
		this.current_point = new Point(x,y);

	}
	
	
	

	public Point getCurrent_point() {
		return current_point;
	}

	public void setCurrent_point(Point current_point) {
		this.current_point = current_point;
	}

	public Point getNext_point() {
		return next_point;
	}

	public void setNext_point(Point next_point) {
		this.next_point = next_point;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	@Override
	public boolean move() {
		// TODO Auto-generated method stub

		return false;
	}
	
	
	

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(character_Image,current_point.x,current_point.y,Pan.CH_WIDHT,Pan.CH_HEIGHT,null);

	}

}
