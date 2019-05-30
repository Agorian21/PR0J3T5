package contract.model;

public interface IEnemyMove {
	/**
	 * Make the monsters move
	 * @param sprites
	 * @param audio
	 * @return sprites
	 */
	public ISprite[][] toMoveTheEnemies(ISprite[][] sprites);

	/**
	 * verify if the sprite is the background
	 * @param sprite
	 * @return boolean
	 */
	public Boolean isSpriteNearToBackground(ISprite sprite);

	/**
	 * set boolean gameOver to true
	 */
	public void gameOver();

	/**
	 * verify if the sprite is the character
	 * @param sprite
	 * @return boolean
	 */
	public Boolean isSpriteNearCharacter(ISprite sprite);

	/**
	 * Getter of gameOver
	 * @return boolean
	 */
	public boolean isGameOver();
}
