package contract.model;

import contract.view.IPanel;

public interface IGravity {
	/**
	 * It is responsible for the boulders and diamonds fall.
	 * It also handles the explosion of an enemy in case of a diamond or boulder falling onto it
	 * @param sprites
	 * @param audio
	 * @return
	 */
	public ISprite[][] makeThemFall(ISprite[][] sprites, IPanel panel);
	
	/**
	 * Verify if the sprite is a background
	 * @param sprites
	 * @return boolean
	 */
	public Boolean isSpriteNextToBackground(ISprite sprites);
	
	/**
	 * It is responsible for the boulders and diamonds slide
	 * @param sprites
	 * @return
	 */
	public ISprite[][] makeThemSlide(ISprite[][] sprites);
	
	/**
	 * Getter of gameOver
	 * @return gameOver
	 */
	public boolean isGameOver();
}
