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
		this.x = x;
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
