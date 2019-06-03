package model.element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.model.Permeability;
import contract.model.SpriteType;

public class Wall extends Sprite {

	/**
	 * Constructor of Wall
	 * @param x
	 * @param y
	 */
	public Wall(int x, int y) {
		super();
		this.permeability = Permeability.BLOCKING;
		if ((x/16)<0 || (x/16)>24) {
			throw new IllegalArgumentException("X out of range");
		}
		this.x = x;
			
		if ((y/16)<0 || (y/16)>24) {
			throw new IllegalArgumentException("Y out of range");
		}
		this.y = y;
		this.type = SpriteType.WALL;
		
		try {
			image = ImageIO.read(new File("../images/Wall.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
