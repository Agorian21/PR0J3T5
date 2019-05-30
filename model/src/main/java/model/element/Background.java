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
		this.x = x;
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
