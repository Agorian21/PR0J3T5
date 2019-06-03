package model.element;

import java.awt.Image;

import contract.model.ISprite;
import contract.model.Permeability;
import contract.model.SpriteType;

public abstract class Sprite implements ISprite {
	protected Image image;
	protected int x = 0, y = 0;
	protected Permeability permeability;
	protected SpriteType type;
	protected boolean hasMoved = false;
	protected boolean blocked = false;
	protected boolean isNearCharacter = false;
	protected boolean wasAboveCharacter = false;
	private int direction = 0;

	/**
	 * @return x the position on the X axle
	 */
	@Override
	public int getX() {
		return x;
	}


	/**
	 * @param x
	 *            the position on the X axle
	 */
	@Override
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return y the position on the Y axle
	 */
	@Override
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the position on the Y axle
	 */
	@Override
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return image the path of the file were the picture is stored
	 */
	@Override
	public Image getImage() {
		return image;
	}

	/* (non-Javadoc)
	 * @see view.ISprite#setImage(java.awt.Image)
	 */
	@Override
	public void setImage(Image image) {
		this.image = image;
	}

	/* (non-Javadoc)
	 * @see view.ISprite#getPermeability()
	 */
	@Override
	public Permeability getPermeability() {
		return permeability;
	}

	/* (non-Javadoc)
	 * @see view.ISprite#setPermeability(model.Permeability)
	 */
	@Override
	public void setPermeability(Permeability permeability) {
		this.permeability = permeability;
	}

	/* (non-Javadoc)
	 * @see view.ISprite#getType()
	 */
	@Override
	public SpriteType getType() {
		return type;
	}

	/* (non-Javadoc)
	 * @see view.ISprite#isHasMoved()
	 */
	@Override
	public boolean HasMoved() {
		return hasMoved;
	}

	/* (non-Javadoc)
	 * @see view.ISprite#setHasMoved(boolean)
	 */
	@Override
	public void setHasMoved(boolean hasMoved ) {
		this.hasMoved = hasMoved;
	}
	
	/* (non-Javadoc)
	 * @see view.ISprite#getDirection()
	 */
	@Override
	public int getDirection() {
		return direction;
	}
	/* (non-Javadoc)
	 * @see view.ISprite#setDirection(int)
	 */
	@Override
	public void setDirection(int direction) {
		this.direction = direction;
	}


	@Override
	public boolean wasAboveCharacter() {
		return wasAboveCharacter;
	}


	@Override
	public void setWasAboveCharacter(boolean wasAboveCharacter) {
		this.wasAboveCharacter = wasAboveCharacter;
	}


	@Override
	public boolean isBlocked() {
		return blocked;
	}


	@Override
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
}
