package images;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Images {
//	public static BufferedImage Back_user;
//	public static BufferedImage RYON;
//	public static BufferedImage APEACHE;
//	public static BufferedImage TUBE;
//	public static BufferedImage MUZI;
//	public static BufferedImage BACKGROUND;
//	
//	public static BufferedImage MAIN_BACK;
//	public static BufferedImage EXIT;
//	public static BufferedImage START;
	
	public static ImageIcon Back_user;
	public static ImageIcon RYON;
	public static ImageIcon APEACHE;
	public static ImageIcon TUBE;
	public static ImageIcon MUZI;
	public static Image BACKGROUND;
	
	public static ImageIcon MAIN_BACK;
	public static ImageIcon EXIT;
	public static ImageIcon START;
	
	
	
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
//			Back_user = ImageIO.read(new File("src/images/user_back.png"));
//			RYON = ImageIO.read(new File("src/images/Ryon.png"));
//			APEACHE = ImageIO.read(new File("src/images/Apeache.png"));
//			TUBE = ImageIO.read(new File("src/images/Tube.png"));
//			MUZI = ImageIO.read(new File("src/images/MUZI.png"));
//			BACKGROUND = ImageIO.read(new File("src/images/Background.png"));
//			MAIN_BACK = ImageIO.read(new File("src/images/main_back.png"));
//			EXIT = ImageIO.read(new File("src/images/exit.png"));
//			START = ImageIO.read(new File("src/images/start.png"));
			
			URL url =  ClassLoader.getSystemResource("images/user_back.png");
			Back_user = new ImageIcon(url);
			url = ClassLoader.getSystemResource("images/Ryon.png"); 
			RYON = new ImageIcon(url);
			url = ClassLoader.getSystemResource("images/Apeache.png"); 
			APEACHE = new ImageIcon(url);
			url = ClassLoader.getSystemResource("images/Tube.png");
			TUBE = new ImageIcon(url);
			url = ClassLoader.getSystemResource("images/MUZI.png");
			MUZI = new ImageIcon(url);
			
			url =  ClassLoader.getSystemResource("images/Background.png");//new URL("images/Background.png");
			BACKGROUND = new ImageIcon (url).getImage();
			
			url =  ClassLoader.getSystemResource("images/main_back.png");
			MAIN_BACK = new ImageIcon(url);
			url =  ClassLoader.getSystemResource("images/exit.png");
			EXIT = new ImageIcon(url);
			url = ClassLoader.getSystemResource("images/start.png");
			START = new ImageIcon(url);
			
			
			
			url = ClassLoader.getSystemResource("images/������Ŭ.gif");
			LOSE1 = new ImageIcon("../images/������Ŭ.gif").getImage();
			LOSE2 = new ImageIcon("../images/��ġ Ŭ���.gif").getImage();
			LOSE3 = new ImageIcon("../images/lose3.gif").getImage();
			WIN1 = new ImageIcon("../images/�����.gif").getImage();
			WIN2 = new ImageIcon("../images/win2.gif").getImage();
			WIN3 = new ImageIcon("../images/win3.gif").getImage();
			WIN4 = new ImageIcon("../images/win4.gif").getImage();
			WIN5 = new ImageIcon("../images/win5.gif").getImage();
			WIN6 = new ImageIcon("../images/win6.gif").getImage();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
