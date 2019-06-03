package model.move;

import java.awt.Image;

import contract.model.IMove;
import contract.model.ISprite;
import contract.model.Permeability;
import contract.model.SpriteType;
import contract.view.IPanel;

public class Move implements IMove {
	protected ISprite[][] sprites;
	protected int SET_SIZE;
	protected IPanel panel;
	protected static boolean gameOver = false, victory = false;
	protected Image image;


	/**
	 * Constructor of Move
	 * @param sprites
	 * @param SET_SIZE
	 * @param panel
	 */
	public Move(ISprite[][] sprites, int SET_SIZE, IPanel panel) {
		this.sprites = sprites;
		this.SET_SIZE = SET_SIZE;
		this.panel = panel;
	}

	/**
	 * move the character to the left and replace the old position by background
	 * 
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @return sprites
	 */
	@Override
	public ISprite[][] digLeft(int colonne, int ligne, ISprite sprite) {
		GoLeft left = new GoLeft(sprites, ligne, panel);
		return left.goLeft(colonne, ligne, sprite, this.sprites, this.panel);
	}

	/**
	 * move the character to the right and replace the old position by
	 * background
	 * 
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @return sprites
	 */
	@Override
	public ISprite[][] digRight(int colonne, int ligne, ISprite sprite) {
		GoRight right = new GoRight(sprites, ligne, panel);
		return right.goRight(colonne, ligne, sprite, this.sprites, this.panel);
	}

	/**
	 * move the character up and replace the old position by background
	 * 
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @return sprites
	 */
	@Override
	public ISprite[][] digUp(int colonne, int ligne, ISprite sprite) {
		GoUp up = new GoUp(sprites, ligne, panel);
		return up.goUp(colonne, ligne, sprite, this.sprites, this.panel);

	}

	/**
	 * move the character down and replace the old position by background
	 * 
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @return sprites
	 */
	@Override
	public ISprite[][] digDown(int colonne, int ligne, ISprite sprite) {
		GoDown down = new GoDown(sprites, ligne, panel);
		return down.goDown(colonne, ligne, sprite, this.sprites, this.panel);
	}

	/**
	 * return true if the sprite permeability is BLOCKING
	 * @param sprite
	 * @return boolean
	 */
	public Boolean isSpriteOn(ISprite sprite) {
		return sprite.getPermeability() == Permeability.BLOCKING;
	}

	/**
	 * return true if the sprite is a Diamond
	 * @param sprite
	 * @return boolean
	 */
	public Boolean nextToDiamond(ISprite sprite) {
		return sprite.getType() == SpriteType.DIAMOND;
	}

	/**
	 * return true if the sprite is an Enemy
	 * @param sprite
	 * @return boolean
	 */
	public Boolean nextToMonster(ISprite sprite) {
		return sprite.getType() == SpriteType.ENEMY;
	}

	/* (non-Javadoc)
	 * @see view.IMove#nextToBackground(view.ISprite)
	 */
	@Override
	public Boolean nextToBackground(ISprite sprite) {
		return sprite.getType() == SpriteType.BACKGROUND;
	}

	/**
	 * return true if the sprite is a Boulder
	 * @param sprite
	 * @return boolean
	 */
	public Boolean nextToRock(ISprite sprite) {
		return sprite.getType() == SpriteType.BOULDER;
	}

	/**
	 * return true if the sprite is the Exit and if it's PERMEABLE
	 * @param sprite
	 * @return boolean
	 */
	public Boolean nextToOpenedExit(ISprite sprite) {
		return (sprite.getType() == SpriteType.EXIT && sprite.getPermeability() == Permeability.PERMEABLE);
	}

	/* (non-Javadoc)
	 * @see view.IMove#gameOver()
	 */
	@Override
	public void gameOver(boolean gameOver) {
		Move.gameOver = gameOver;
	}

	/* (non-Javadoc)
	 * @see view.IMove#isGameOver()
	 */
	@Override
	public boolean isGameOver() {
		return gameOver;
	}

	/* (non-Javadoc)
	 * @see view.IMove#isVictory()
	 */
	@Override
	public boolean isVictory() {
		return victory;
	}

	/* (non-Javadoc)
	 * @see view.IMove#setVictory(boolean)
	 */
	
	@Override
	public void setVictory(boolean victory) {
		Move.victory = victory;
	}
}