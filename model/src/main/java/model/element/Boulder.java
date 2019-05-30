package model.element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.model.Permeability;
import contract.model.SpriteType;

public class Boulder extends Sprite {

	/**
	 * Constructor of Boulder
	 * @param x
	 * @param y
	 */
	public Boulder(int x, int y) {
		super();
		this.permeability = Permeability.BLOCKING;
		this.x = x;
		this.y = y;
		this.type = SpriteType.BOULDER;
		
		try {
			image = ImageIO.read(new File("../images/Boulder.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
