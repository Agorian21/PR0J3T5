package model.element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.model.Permeability;
import contract.model.SpriteType;

public class Background extends Sprite {

	/**
	 * Constructor of Background
	 * @param x
	 * @param y
	 */
	public Background(int x, int y) {
		super();
		this.permeability = Permeability.PERMEABLE;
		if ((x/16)<=0 || (x/16)>=24) {
			throw new IllegalArgumentException("X out of range");
		}
		this.x = x;
			
		if ((y/16)<=0 || (y/16)>=24) {
			throw new IllegalArgumentException("Y out of range");
		}
		this.y = y;
		
		this.type = SpriteType.BACKGROUND;
		
		try {
			image = ImageIO.read(new File("../images/Background.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
