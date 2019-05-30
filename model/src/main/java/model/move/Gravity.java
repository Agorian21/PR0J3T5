package model.move;

import contract.model.IGravity;
import contract.model.ISprite;
import contract.model.SpriteType;
import contract.view.IPanel;
import model.element.Background;

public class Gravity implements IGravity {
	private int ligne = 0, colonne = 0;
	private boolean gameOver = false;

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.IGravity#makeThemFall(view.ISprite[][])
	 */
	public ISprite[][] makeThemFall(ISprite[][] sprites, IPanel panel) {
		ligne = 0;
		for (ISprite sousSpit[] : sprites) {
			colonne = 0;
			for (ISprite spit : sousSpit) {
				if ((spit.getType() == SpriteType.DIAMOND || spit.getType() == SpriteType.BOULDER)) {
					if ((isSpriteNextToBackground(sprites[ligne + 1][colonne])
							|| isSpriteAboveMonster(sprites[ligne + 1][colonne])) && !spit.HasMoved()) {
						if(isSpriteAboveMonster(sprites[ligne + 1][colonne])){
							panel.setScore(panel.getScore() + 200);
						}
						sprites[ligne][colonne] = new Background(spit.getX(), spit.getY());
						spit.setY(spit.getY() + 16);
						spit.setHasMoved(true);
						spit.setBlocked(false);
						sprites[ligne + 1][colonne] = spit;
					} else if (isSpriteAboveCharacter(sprites[ligne + 1][colonne]) && !spit.HasMoved()
							&& spit.isWasAboveCharacter() && !spit.isBlocked()) {
						sprites[ligne][colonne] = new Background(spit.getX(), spit.getY());
						spit.setY(spit.getY() + 16);
						spit.setHasMoved(true);
						sprites[ligne + 1][colonne] = spit;
						gameOver();
					} else if (isSpriteAboveCharacter(sprites[ligne + 1][colonne]) && !spit.HasMoved()
							&& !spit.isWasAboveCharacter()) {
						spit.setWasAboveCharacter(true);
						spit.setBlocked(true);
					} else if(isSpriteAboveDirt(sprites[ligne + 1][colonne])){
						spit.setWasAboveCharacter(false);
					}
				}
				colonne++;
			}
			ligne++;
		}
		return sprites;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.IGravity#makeThemSlide(view.ISprite[][])
	 */
	public ISprite[][] makeThemSlide(ISprite[][] sprites) {
		ligne = 0;
		for (ISprite sousSpit[] : sprites) {
			colonne = 0;
			for (ISprite spit : sousSpit) {
				if ((spit.getType() == SpriteType.DIAMOND || spit.getType() == SpriteType.BOULDER)
						&& isSpriteAboveRockOrDiamond(sprites[ligne + 1][colonne])) {
					if (isSpriteNextToBackground(sprites[ligne][colonne + 1])
							&& isSpriteNextToBackground(sprites[ligne + 1][colonne + 1])) {
						sprites[ligne][colonne] = new Background(spit.getX(), spit.getY());
						spit.setX(spit.getX() + 16);
						sprites[ligne][colonne + 1] = spit;
					} else if (isSpriteNextToBackground(sprites[ligne][colonne - 1])
							&& isSpriteNextToBackground(sprites[ligne + 1][colonne - 1])) {
						sprites[ligne][colonne] = new Background(spit.getX(), spit.getY());
						spit.setX(spit.getX() - 16);
						sprites[ligne][colonne - 1] = spit;
					}
				}
				colonne++;
			}
			ligne++;
		}
		return sprites;
	}

	/**
	 * return true if the sprite is a rock or diamond
	 * 
	 * @param sprite
	 * @return boolean
	 */
	public Boolean isSpriteAboveRockOrDiamond(ISprite sprite) {
		return sprite.getType() == SpriteType.BOULDER || sprite.getType() == SpriteType.DIAMOND;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.IGravity#isSpriteNextToBackground(view.ISprite)
	 */
	public Boolean isSpriteNextToBackground(ISprite sprite) {
		return sprite.getType() == SpriteType.BACKGROUND;
	}

	/**
	 * return true if the sprite is a character
	 * 
	 * @param sprite
	 * @return boolean
	 */
	public Boolean isSpriteAboveCharacter(ISprite sprite) {
		return sprite.getType() == SpriteType.PLAYER;
	}

	/**
	 * return true if the sprite is a monster
	 * 
	 * @param sprite
	 * @return
	 */
	public Boolean isSpriteAboveMonster(ISprite sprite) {
		return sprite.getType() == SpriteType.ENEMY;
	}
	
	/**
	 * return true if the sprite is a monster
	 * 
	 * @param sprite
	 * @return
	 */
	public Boolean isSpriteAboveDirt(ISprite sprite) {
		return sprite.getType() == SpriteType.DIRT;
	}

	/**
	 * Set gameOver to true
	 */
	public void gameOver() {
		gameOver = true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.IGravity#isGameOver()
	 */
	public boolean isGameOver() {
		return gameOver;
	}
}