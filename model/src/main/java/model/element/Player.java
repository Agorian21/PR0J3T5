package model.element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.model.Permeability;
import contract.model.SpriteType;

public class Player extends Sprite {

	/**
	 * Constructor of Player
	 * @param x
	 * @param y
	 */
	public Player(int x, int y) {
		super();
		this.permeability = Permeability.BLOCKING;
		this.x = x;
		this.y = y;
		this.type = SpriteType.PLAYER;
		
		try {
			image = ImageIO.read(new File("../images/Player.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
