package images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
	public static BufferedImage Back_user;
	public static BufferedImage RYON;
	public static BufferedImage APEACHE;
	public static BufferedImage TUBE;
	public static BufferedImage MUZI;



	static {
		try {
			Back_user = ImageIO.read(new File("src/images/user_back.png"));
			RYON = ImageIO.read(new File("src/images/Ryon.png"));
			APEACHE = ImageIO.read(new File("src/images/Apeache.png"));
			TUBE = ImageIO.read(new File("src/images/Tube.png"));
			MUZI = ImageIO.read(new File("src/images/MUZI.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
