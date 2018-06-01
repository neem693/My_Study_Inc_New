package images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
	public static BufferedImage RYON;
	public static BufferedImage APEACHE;
	public static BufferedImage TUBE;


	static {
		try {
			RYON = ImageIO.read(new File("src/images/Ryon.png"));
			APEACHE = ImageIO.read(new File("src/images/Apeache.png"));
			TUBE = ImageIO.read(new File("src/images/Tube.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
