package model.move;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.model.ISprite;
import contract.view.IPanel;
import model.element.Background;
import model.element.Enemy;

public class GoDown extends Move {

	/**
	 * Constructor of GoDown
	 * 
	 * @param sprites
	 * @param SET_SIZE
	 * @param panel
	 */
	public GoDown(ISprite[][] sprites, int SET_SIZE, IPanel panel) {
		super(sprites, SET_SIZE, panel);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Player down movement, it either collects a diamond, wins the game, dies, moves down or get
	 * blocked depending on the element under it.
	 * 
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @param sprites
	 * @param panel
	 * @return sprites
	 */
	public ISprite[][] goDown(int colonne, int ligne, ISprite sprite, ISprite[][] sprites, IPanel panel) {
		try {
			image = ImageIO.read(new File("../images/PlayerDown.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (nextToDiamond(sprites[ligne + 1][colonne])) {
			panel.setDiamondsGet(panel.getDiamondsGet() + 1);
			panel.setScore(panel.getScore() + 1000);
		}
		if (nextToOpenedExit(sprites[ligne + 1][colonne])) {
			panel.setScore(panel.getScore() + 10000);
			setVictory(true);
		} 
		if (nextToMonster(sprites[ligne + 1][colonne])) {
			sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
			sprite.setY(sprite.getY() + 16);
			sprites[ligne + 1][colonne] = new Enemy(sprite.getX(), sprite.getY());
			gameOver(true);
			return sprites;
		} else if (isSpriteOn(sprites[ligne + 1][colonne])) {
			return sprites;
		} else {
			sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
			sprite.setY(sprite.getY() + 16);
			sprite.setImage(image);
			sprites[ligne + 1][colonne] = sprite;
			return sprites;
		}
	}
}
