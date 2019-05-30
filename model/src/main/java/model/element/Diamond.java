package model.element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.model.Permeability;
import contract.model.SpriteType;

public class Diamond extends Sprite {

	/**
	 * Constructor of Diamond
	 * @param x
	 * @param y
	 */
	public Diamond(int x, int y) {
		super();
		this.permeability = Permeability.PERMEABLE;
		this.x = x;
		this.y = y;
		this.type = SpriteType.DIAMOND;
		
		try {
			image = ImageIO.read(new File("../images/Diamond.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
