package contract.model;

public interface IMove {
	
	/**
	 * Move the player to the left and replace the old position by a background object
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @param audio
	 * @return array which contains the modified map
	 */
	public ISprite[][] digLeft(int colonne, int ligne, ISprite sprite);

	/**
	 * Move the player to the right and replace the old position by a background object
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @param audio
	 * @return array which contains the modified map
	 */
	public ISprite[][] digRight(int colonne, int ligne, ISprite sprite);

	/**
	 * Move the player up and replace the old position by a background object
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @param audio
	 * @return array which contains the modified map
	 */
	public ISprite[][] digUp(int colonne, int ligne, ISprite sprite);
	
	/**
	 * Move the player down and replace the old position by a background object
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @param audio
	 * @return array which contains the modified map
	 */
	public ISprite[][] digDown(int colonne, int ligne, ISprite sprite);
	
	/**
	 * Set the boolean gameOver to true
	 */
	public void gameOver(boolean gameOver);

	/**
	 * @return boolean
	 */
	public boolean isGameOver();
	
	/**
	 * @return boolean
	 */
	public boolean isVictory();

	/**
	 * Set the boolean victory to true
	 * @param victory
	 */
	public void setVictory(boolean victory);
	
	/**
	 * Verify if the sprite is a background
	 * @param sprite
	 * @return
	 */
	public Boolean nextToBackground(ISprite sprite);
	
}
