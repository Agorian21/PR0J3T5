package model.move;

import contract.model.IGravity;
import contract.model.ISprite;
import contract.model.SpriteType;
import contract.view.IPanel;
import model.element.Background;
import model.element.Diamond;

public class Gravity implements IGravity {
	private int ligne = 0, colonne = 0;
	private boolean gameOver = false;

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.IGravity#makeThemFall(view.ISprite[][])
	 */
	@Override
	public ISprite[][] makeThemFall(ISprite[][] sprites, IPanel panel) {
		ligne = 0;
		for (ISprite sousSprit[] : sprites) {
			colonne = 0;
			for (ISprite sprit : sousSprit) {
				if ((sprit.getType() == SpriteType.DIAMOND || sprit.getType() == SpriteType.BOULDER)) {
					if ((isSpriteNextToBackground(sprites[ligne + 1][colonne])
							|| isSpriteAboveMonster(sprites[ligne + 1][colonne])) && !sprit.HasMoved()) {
						if(isSpriteAboveMonster(sprites[ligne + 1][colonne])){
							panel.setScore(panel.getScore() + 200);
							for (int i=-1;i<=1;i++) {
								for (int j=-1;j<=1;j++) {
									if ((ligne+1+i>0) && (ligne+1+i<25) && (ligne+1+j>0) && (ligne+1+j<25)) {
										if (sprites[ligne + 1 + i][colonne + j].getType() != SpriteType.WALL) {
											sprites[ligne + 1 + i][colonne + j] = new Diamond(sprit.getX()+(j*16), sprit.getY()+16+(i*16));
										}
									}	
								}
							}
						}
						else {
							sprites[ligne][colonne] = new Background(sprit.getX(), sprit.getY());	
							sprit.setY(sprit.getY() + 16);
							sprit.setHasMoved(true);
							sprit.setBlocked(false);
							sprites[ligne + 1][colonne] = sprit;
						}
					} else if (isSpriteAboveCharacter(sprites[ligne + 1][colonne]) && !sprit.HasMoved()
							&& sprit.wasAboveCharacter() && !sprit.isBlocked()) {
						sprites[ligne][colonne] = new Background(sprit.getX(), sprit.getY());
						sprit.setY(sprit.getY() + 16);
						sprit.setHasMoved(true);
						sprites[ligne + 1][colonne] = sprit;
						gameOver();
					} else if (isSpriteAboveCharacter(sprites[ligne + 1][colonne]) && !sprit.HasMoved()
							&& !sprit.wasAboveCharacter()) {
						sprit.setWasAboveCharacter(true);
						sprit.setBlocked(true);
					} else if(isSpriteAboveDirt(sprites[ligne + 1][colonne])){
						sprit.setWasAboveCharacter(false);
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
	@Override
	public ISprite[][] makeThemSlide(ISprite[][] sprites) {
		ligne = 0;
		for (ISprite sousSprit[] : sprites) {
			colonne = 0;
			for (ISprite sprit : sousSprit) {
				if ((sprit.getType() == SpriteType.DIAMOND || sprit.getType() == SpriteType.BOULDER)
						&& isSpriteAboveRockOrDiamond(sprites[ligne + 1][colonne])) {
					if (isSpriteNextToBackground(sprites[ligne][colonne + 1])
						&& isSpriteNextToBackground(sprites[ligne + 1][colonne + 1])) {
							sprites[ligne][colonne] = new Background(sprit.getX(), sprit.getY());
							sprit.setX(sprit.getX() + 16);
							sprites[ligne][colonne + 1] = sprit;
							sprit.setHasMoved(true);
					} else if (isSpriteNextToBackground(sprites[ligne][colonne - 1])
							&& isSpriteNextToBackground(sprites[ligne + 1][colonne - 1])) {
						sprites[ligne][colonne] = new Background(sprit.getX(), sprit.getY());
						sprit.setX(sprit.getX() - 16);
						sprites[ligne][colonne - 1] = sprit;
						sprit.setHasMoved(true);	
					}
					else {
						sprit.setBlocked(true);
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
	@Override
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
	@Override
	public boolean isGameOver() {
		return gameOver;
	}
}