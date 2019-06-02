package model.move;

import java.util.Random;

import contract.model.IEnemyMove;
import contract.model.ISprite;
import contract.model.SpriteType;
import model.element.Background;

public class EnemyMove implements IEnemyMove {
	private int ligne = 0, colonne = 0;
	private boolean gameOver = false;
	Random rand = new Random();

	/* (non-Javadoc)
	 * @see view.IMonsterMove#toMoveTheMonsters(view.ISprite[][])
	 */
	public ISprite[][] toMoveTheEnemies(ISprite[][] sprites) {
		ligne = 0;
		for (ISprite sousSprit[] : sprites) {
			colonne = 0;
			for (ISprite sprit : sousSprit) {
				if ((sprit.getType() == SpriteType.ENEMY)) {
					if (!sprit.HasMoved()) {
					if (isSpriteNearCharacter(sprites[ligne + 1][colonne])) {
						moveDown(sprites,sprit);
						gameOver();
					}
					else if (isSpriteNearCharacter(sprites[ligne - 1][colonne])) {
						moveUp(sprites,sprit);
						gameOver();
					}
					else if (isSpriteNearCharacter(sprites[ligne][colonne - 1])) {
						moveLeft(sprites,sprit);
						gameOver();
					}
					else if (isSpriteNearCharacter(sprites[ligne][colonne + 1])) {
						moveRight(sprites,sprit);
						gameOver();
					}
				/*	else if (isSpriteNearToBackground(sprites[ligne - 1][colonne]) 
							&& sprit.getDirection()==1){
						moveUp(sprites,sprit);
					}	
					else if (isSpriteNearToBackground(sprites[ligne][colonne + 1])
							&& sprit.getDirection()==4){
						moveRight(sprites,sprit);
					}				
					else if (isSpriteNearToBackground(sprites[ligne + 1][colonne])
							&& sprit.getDirection()==2){
						moveDown(sprites,sprit);
					}				
					else if (isSpriteNearToBackground(sprites[ligne][colonne - 1])
							&& sprit.getDirection()==3){
						moveLeft(sprites,sprit);
					}*/
					else {
						int random = rand.nextInt(4)+1;
						
						switch(random) {
						case 1: 
							 if (isSpriteNearToBackground(sprites[ligne - 1][colonne]))
									 moveUp(sprites,sprit);
							break;						
						case 2: 
							 if (isSpriteNearToBackground(sprites[ligne + 1][colonne]))
								 	moveDown(sprites,sprit);
							break;
						case 3: 
							if (isSpriteNearToBackground(sprites[ligne][colonne + 1]))
									moveRight(sprites,sprit);
							break;
						case 4: 
							if (isSpriteNearToBackground(sprites[ligne][colonne - 1]))
									moveLeft(sprites,sprit);
							break;
						}
					}
					}
				}
				colonne++;
			}
			ligne++;
		}
		return sprites;
	}

	/**
	 * @param sprites
	 * @param sprit
	 * @return
	 */
	public ISprite[][] moveUp(ISprite[][] sprites, ISprite sprit) {
		sprites[ligne][colonne] = new Background(sprit.getX(), sprit.getY());
		sprit.setY(sprit.getY() - 16);
		sprit.setHasMoved(true);
		sprit.setDirection(1);
		sprites[ligne - 1][colonne] = sprit;
		return sprites;
	}

	/**
	 * @param sprites
	 * @param sprit
	 * @return
	 */
	public ISprite[][] moveDown(ISprite[][] sprites, ISprite sprit) {
		sprites[ligne][colonne] = new Background(sprit.getX(), sprit.getY());
		sprit.setY(sprit.getY() + 16);
		sprit.setHasMoved(true);
		sprit.setDirection(2);
		sprites[ligne + 1][colonne] = sprit;
		return sprites;
	}

	/**
	 * @param sprites
	 * @param sprit
	 * @return
	 */	
	public ISprite[][] moveLeft(ISprite[][] sprites, ISprite sprit) {
		sprites[ligne][colonne] = new Background(sprit.getX(), sprit.getY());
		sprit.setX(sprit.getX() - 16);
		sprit.setHasMoved(true);
		sprit.setDirection(3);
		sprites[ligne][colonne - 1] = sprit;
		return sprites;
	}	
	
	/**
	 * @param sprites
	 * @param sprit
	 * @return
	 */	
	public ISprite[][] moveRight(ISprite[][] sprites, ISprite sprit) {
		sprites[ligne][colonne] = new Background(sprit.getX(), sprit.getY());
		sprit.setX(sprit.getX() + 16);
		sprit.setHasMoved(true);
		sprit.setDirection(4);
		sprites[ligne][colonne + 1] = sprit;
		return sprites;
	}	
	/* (non-Javadoc)
	 * @see view.IMonsterMove#isSpriteNearToBackground(view.ISprite)
	 */
	public Boolean isSpriteNearToBackground(ISprite sprites) {
		return sprites.getType() == SpriteType.BACKGROUND;
	}

	/* (non-Javadoc)
	 * @see view.IMonsterMove#isSpriteNearCharacter(view.ISprite)
	 */
	public Boolean isSpriteNearCharacter(ISprite sprites) {
		return sprites.getType() == SpriteType.PLAYER;
	}

	public void gameOver() {
		gameOver = true;
	}

	public boolean isGameOver() {
		return gameOver;
	}
}