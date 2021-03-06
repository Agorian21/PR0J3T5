package contract.view;

import java.awt.Graphics;

import contract.model.ISprite;

public interface IMapConstructor {
	/**
	 * Fill a Sprite array in terms of a SpriteType table
	 * @param SET_SIZE
	 */
	public void spritesCreation(final int SET_SIZE);

	/**
	 * Draw the map
	 * @param g
	 */
	public void drawMap(Graphics g);

	/**
	 * Getter of sprites
	 * @return sprites
	 */
	public ISprite[][] getSprites();
	
	/**
	 * Get the character
	 * @param colonne
	 * @param ligne
	 * @return the character's sprite
	 */
	public ISprite getCharacter(int colonne, int ligne);

	/**
	 * Setter of sprites
	 * @param sprites
	 */
	public void setSprites(ISprite[][] sprites);
	
	/**
	 * Set the attribute HasMoved to false for every object in the matrix
	 * @param sprites
	 */
	public void setAllHasMovedToFalse(ISprite[][] sprites);
}