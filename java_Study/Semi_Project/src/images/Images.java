package images;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Images {
	public static BufferedImage Back_user;
	public static BufferedImage RYON;
	public static BufferedImage APEACHE;
	public static BufferedImage TUBE;
	public static BufferedImage MUZI;
	public static BufferedImage BACKGROUND;
	
	public static BufferedImage MAIN_BACK;
	public static BufferedImage EXIT;
	public static BufferedImage START;
	
	
	
	public static int WIN_L =6;
	public static int LOSE_L = 3;
	
	public static Image WIN1;
	public static Image WIN2;
	public static Image WIN3;
	public static Image WIN4;
	public static Image WIN5;
	public static Image WIN6;
	public static Image LOSE1;
	public static Image LOSE2;
	public static Image LOSE3;



	static {
		try {
			Back_user = ImageIO.read(new File("src/images/user_back.png"));
			RYON = ImageIO.read(new File("src/images/Ryon.png"));
			APEACHE = ImageIO.read(new File("src/images/Apeache.png"));
			TUBE = ImageIO.read(new File("src/images/Tube.png"));
			MUZI = ImageIO.read(new File("src/images/MUZI.png"));
			BACKGROUND = ImageIO.read(new File("src/images/Background.png"));
			MAIN_BACK = ImageIO.read(new File("src/images/main_back.png"));
			EXIT = ImageIO.read(new File("src/images/exit.png"));
			START = ImageIO.read(new File("src/images/start.png"));
			LOSE1 = new ImageIcon("src/images/살인태클.gif").getImage();
			LOSE2 = new ImageIcon("src/images/벤치 클리어링.gif").getImage();
			LOSE3 = new ImageIcon("src/images/lose3.gif").getImage();
			WIN1 = new ImageIcon("src/images/잠수함.gif").getImage();
			WIN2 = new ImageIcon("src/images/win2.gif").getImage();
			WIN3 = new ImageIcon("src/images/win3.gif").getImage();
			WIN4 = new ImageIcon("src/images/win4.gif").getImage();
			WIN5 = new ImageIcon("src/images/win5.gif").getImage();
			WIN6 = new ImageIcon("src/images/win6.gif").getImage();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
