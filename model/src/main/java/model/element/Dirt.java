package model.element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.model.Permeability;
import contract.model.SpriteType;

public class Dirt extends Sprite {

	/**
	 * Constructor of Dirt
	 * @param x
	 * @param y
	 */
	public Dirt(int x, int y) {
		super();
		this.permeability = Permeability.PERMEABLE;
		this.x = x;
		this.y = y;
		this.type = SpriteType.DIRT;
		
		try {
			image = ImageIO.read(new File("../images/Dirt.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
