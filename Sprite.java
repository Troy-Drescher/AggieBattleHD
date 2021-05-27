import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Sprite {
		
	private BufferedImage SPRITESHEET = null;
	private int wSprite;
	private int hSprite;

	public Sprite(String file) {
		System.out.println("Loading: " + file + "...");
		SPRITESHEET = loadSprite(file);
		
		wSprite = SPRITESHEET.getWidth(); // if make custom sheet with two faces, can make getWidth / 2
		hSprite = SPRITESHEET.getHeight();
	}
	
	private BufferedImage loadSprite(String file) {
		BufferedImage sprite = null;
		try {
			sprite = ImageIO.read(getClass().getClassLoader().getResourceAsStream(file));
		}
		catch(Exception e) {
			System.out.println("Failed to load file");
		}
		return sprite;
	}
	
	public BufferedImage getSprite() {
		return SPRITESHEET.getSubimage(0, 0, wSprite, hSprite);
	}
	
}
