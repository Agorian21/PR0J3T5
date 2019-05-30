package model.move;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.model.ISprite;
import contract.view.IPanel;
import model.element.Background;
import model.element.Enemy;

public class GoUp extends Move {

	public GoUp(ISprite[][] sprites, int SET_SIZE, IPanel panel) {
		super(sprites, SET_SIZE, panel);
		// TODO Auto-generated constructor stub
	}



	/**
	 * Tries to move the character up, if he cross a diamond he will collect it,
	 * if it's an opened exit he will win, if it's a monster he will die, if
	 * it's a BLOCKING sprite he wouldn't move, otherwise he will go up
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @param sprites
	 * @param panel
	 * @param audio
	 * @return
	 */
	public ISprite[][] goUp(int colonne, int ligne, ISprite sprite, ISprite[][] sprites, IPanel panel) {
		try {
			image = ImageIO.read(new File("../images/PlayerUp.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (nextToDiamond(sprites[ligne - 1][colonne])) {
			panel.setDiamondsGet(panel.getDiamondsGet() + 1);
			panel.setScore(panel.getScore() + 1000);

		}
		if (nextToOpenedExit(sprites[ligne - 1][colonne])) {
			panel.setScore(panel.getScore() + 10000);
			setVictory(true);
		}
		if (nextToMonster(sprites[ligne - 1][colonne])) {
			sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
			sprite.setY(sprite.getY() - 16);
			sprites[ligne - 1][colonne] = new Enemy(sprite.getX(), sprite.getY());
		
			gameOver(true);
			return sprites;
		}
		if (isSpriteOn(sprites[ligne - 1][colonne])) {
			return sprites;
		} else {
			sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
			sprite.setY(sprite.getY() - 16);
			sprite.setImage(image);
			sprites[ligne - 1][colonne] = sprite;
			return sprites;
		}
	}
}
