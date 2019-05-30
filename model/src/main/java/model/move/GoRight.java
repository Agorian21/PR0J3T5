package model.move;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.model.ISprite;
import contract.view.IPanel;
import model.element.Background;
import model.element.Boulder;
import model.element.Enemy;

public class GoRight extends Move {

	public GoRight(ISprite[][] sprites, int SET_SIZE, IPanel panel) {
		super(sprites, SET_SIZE, panel);
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * Tries to move the character right, if he cross a diamond he will collect
	 * it, if it's an opened exit he will win, if it's a monster he will die, if
	 * it's a BLOCKING sprite he wouldn't move, otherwise he will go right
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @param sprites
	 * @param panel
	 * @param audio
	 * @return
	 */
	public ISprite[][] goRight(int colonne, int ligne, ISprite sprite, ISprite[][] sprites, IPanel panel) {
		try {
			image = ImageIO.read(new File("../images/PlayerRight.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (nextToDiamond(sprites[ligne][colonne + 1])) {
			panel.setDiamondsGet(panel.getDiamondsGet() + 1);
			panel.setScore(panel.getScore() + 1000);
		}
		if (nextToOpenedExit(sprites[ligne][colonne + 1])) {
			panel.setScore(panel.getScore() + 10000);
			setVictory(true);
		}
		if (nextToMonster(sprites[ligne][colonne + 1])) {
			sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
			sprite.setX(sprite.getX() + 16);
			sprites[ligne][colonne + 1] = new Enemy(sprite.getX(), sprite.getY());
			gameOver(true);
			return sprites;
		}
		if (nextToRock(sprites[ligne][colonne + 1]) && nextToBackground(sprites[ligne][colonne + 2])) {
			sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
			sprite.setX(sprite.getX() + 16);
			sprite.setImage(image);
			sprites[ligne][colonne + 1] = sprite;
			sprites[ligne][colonne + 2] = new Boulder((sprite.getX() + 16), sprite.getY());
			return sprites;
		} else if (isSpriteOn(sprites[ligne][colonne + 1])) {
			return sprites;
		}

		else {
			sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
			sprite.setX(sprite.getX() + 16);
			sprite.setImage(image);
			sprites[ligne][colonne + 1] = sprite;
			return sprites;
		}
	}
}
