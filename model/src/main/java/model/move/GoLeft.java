package model.move;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.model.ISprite;
import contract.view.IPanel;
import model.element.Background;
import model.element.Boulder;
import model.element.Enemy;

public class GoLeft extends Move {

	public GoLeft(ISprite[][] sprites, int SET_SIZE, IPanel panel) {
		super(sprites, SET_SIZE, panel);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Player left movement, it either collects a diamond, wins the game, dies, moves left or get
	 * blocked depending on the element on its left.
	 * 
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @param sprites
	 * @param panel
	 * @return sprites
	 */
	public ISprite[][] goLeft(int colonne, int ligne, ISprite sprite, ISprite[][] sprites, IPanel panel) {
		try {
			image = ImageIO.read(new File("../images/PlayerLeft.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (nextToDiamond(sprites[ligne][colonne - 1])) {
			panel.setDiamondsGet(panel.getDiamondsGet() + 1);
			panel.setScore(panel.getScore() + 1000);
		}
		if (nextToOpenedExit(sprites[ligne][colonne - 1])) {
			panel.setScore(panel.getScore() + 10000);
			setVictory(true);
		}
		if (nextToMonster(sprites[ligne][colonne - 1])) {
			sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
			sprite.setX(sprite.getX() - 16);
			sprites[ligne][colonne - 1] = new Enemy(sprite.getX(), sprite.getY());
			gameOver(true);
			return sprites;
		}
		if (nextToRock(sprites[ligne][colonne - 1]) && nextToBackground(sprites[ligne][colonne - 2])) {
			sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
			sprite.setX(sprite.getX() - 16);
			sprite.setImage(image);
			sprites[ligne][colonne - 1] = sprite;
			sprites[ligne][colonne - 2] = new Boulder((sprite.getX() - 16), sprite.getY());
			return sprites;
		} else if (isSpriteOn(sprites[ligne][colonne - 1])) {
			return sprites;
		}

		else {
			sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
			sprite.setX(sprite.getX() - 16);
			sprite.setImage(image);
			sprites[ligne][colonne - 1] = sprite;
			return sprites;
		}

	}
}
